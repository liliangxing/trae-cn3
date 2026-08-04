# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetToolcallGroupRenderer;
.super Ljava/lang/Object;
.source "PureShowWidgetToolcallGroupRenderer.kt"

.implements Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;


.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final bind(android.widget.LinearLayout  com.bytedance.trae.conversation.chat.block.AgentContentBlock$PureShowWidgetToolcallGroup)void
    .registers 8
    # ins_size=3
    invoke-static v7, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetToolcallGroupRendererKt;->access$pureShowWidgetPayload(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PureShowWidgetToolcallGroup;)Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPayload;
    move-result-object v0
    if-nez v0, +00ch
    move-object v7, v6
    check-cast v7, Landroid/view/View;
    invoke-virtual v5, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetToolcallGroupRenderer;->release$conversation_mainlandRelease(Landroid/view/View;)V
    invoke-direct v5, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetToolcallGroupRenderer;->notifyContentChanged(Landroid/widget/LinearLayout;)V
    return-void 
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPayload;->getWidgetCode()Ljava/lang/String;
    move-result-object v1
    invoke-direct v5, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetToolcallGroupRenderer;->findPureShowWidgetInlineView(Landroid/widget/LinearLayout;)Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;
    move-result-object v2
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PureShowWidgetToolcallGroup;->getGroupFinished()Z
    move-result v3
    if-eqz v3, +01bh
    move-object v3, v1
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v3, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v3
    if-nez v3, +008h
    invoke-static v1, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetToolcallGroupRendererKt;->access$hasBalancedWidgetTags(Ljava/lang/String;)Z
    move-result v1
    if-nez v1, +00ch
    move-object v7, v6
    check-cast v7, Landroid/view/View;
    invoke-virtual v5, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetToolcallGroupRenderer;->release$conversation_mainlandRelease(Landroid/view/View;)V
    invoke-direct v5, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetToolcallGroupRenderer;->notifyContentChanged(Landroid/widget/LinearLayout;)V
    return-void 
    if-nez v2, +029h
    new-instance v2, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;
    invoke-virtual v6, Landroid/widget/LinearLayout;->getContext()Landroid/content/Context;
    move-result-object v1
    const-string v3, "getContext(...)"
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v2, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;-><init>(Landroid/content/Context;)V
    invoke-direct v5, v6, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetToolcallGroupRenderer;->notifyPureShowWidgetInlineViewCreated(Landroid/widget/LinearLayout; Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;)V
    invoke-virtual v6, Landroid/widget/LinearLayout;->removeAllViews()V
    move-object v1, v2
    check-cast v1, Landroid/view/View;
    invoke-virtual v6, Landroid/widget/LinearLayout;->getContext()Landroid/content/Context;
    move-result-object v4
    invoke-static v4, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v5, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetToolcallGroupRenderer;->pureShowWidgetLayoutParams(Landroid/content/Context;)Landroid/widget/LinearLayout$LayoutParams;
    move-result-object v3
    check-cast v3, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v6, v1, v3, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    sget v1, Lcom/bytedance/trae/conversation/R$id;->tag_on_content_changed I
    sget v3, Lcom/bytedance/trae/conversation/R$id;->tag_on_content_changed I
    invoke-virtual v6, v3, Landroid/widget/LinearLayout;->getTag(I)Ljava/lang/Object;
    move-result-object v6
    invoke-virtual v2, v1, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->setTag(I Ljava/lang/Object;)V
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PureShowWidgetToolcallGroup;->getGroupFinished()Z
    move-result v6
    invoke-virtual v2, v0, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->bind(Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPayload; Z)V
    return-void 
.end method

.method private final findPureShowWidgetInlineView(android.widget.LinearLayout)com.bytedance.trae.conversation.chat.block.renderer.PureShowWidgetInlineView
    .registers 6
    # ins_size=2
    invoke-virtual v5, Landroid/widget/LinearLayout;->getChildCount()I
    move-result v0
    const/4 v1, 0
    if-ge v1, v0, +010h
    invoke-virtual v5, v1, Landroid/widget/LinearLayout;->getChildAt(I)Landroid/view/View;
    move-result-object v2
    instance-of v3, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;
    if-eqz v3, +005h
    check-cast v2, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;
    return-object v2
    add-int/lit8 v1, v1, 1
    goto -fh
    const/4 v5, 0
    return-object v5
.end method

.method private final notifyContentChanged(android.widget.LinearLayout)void
    .registers 4
    # ins_size=2
    check-cast v3, Landroid/view/View;
    if-eqz v3, +022h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tag_on_content_changed I
    invoke-virtual v3, v0, Landroid/view/View;->getTag(I)Ljava/lang/Object;
    move-result-object v0
    const/4 v1, 0
    invoke-static v0, v1, Lkotlin/jvm/internal/TypeIntrinsics;->isFunctionOfArity(Ljava/lang/Object; I)Z
    move-result v1
    if-eqz v1, +008h
    check-cast v0, Lkotlin/jvm/functions/Function0;
    invoke-interface v0, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    return-void 
    invoke-virtual v3, Landroid/view/View;->getParent()Landroid/view/ViewParent;
    move-result-object v3
    instance-of v0, v3, Landroid/view/View;
    if-eqz v0, +005h
    check-cast v3, Landroid/view/View;
    goto -1fh
    const/4 v3, 0
    goto -21h
    return-void 
.end method

.method private final notifyPureShowWidgetInlineViewCreated(android.widget.LinearLayout  com.bytedance.trae.conversation.chat.block.renderer.PureShowWidgetInlineView)void
    .registers 6
    # ins_size=3
    check-cast v4, Landroid/view/View;
    if-eqz v4, +02bh
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tag_on_pure_show_widget_inline_view_created I
    invoke-virtual v4, v0, Landroid/view/View;->getTag(I)Ljava/lang/Object;
    move-result-object v0
    const/4 v1, 1
    invoke-static v0, v1, Lkotlin/jvm/internal/TypeIntrinsics;->isFunctionOfArity(Ljava/lang/Object; I)Z
    move-result v2
    if-eqz v2, +011h
    const-string v4, "null cannot be cast to non-null type kotlin.Function1<com.bytedance.trae.conversation.chat.block.renderer.PureShowWidgetInlineView, kotlin.Unit>"
    invoke-static v0, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v0, v1, Lkotlin/jvm/internal/TypeIntrinsics;->beforeCheckcastToFunctionOfArity(Ljava/lang/Object; I)Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lkotlin/jvm/functions/Function1;
    invoke-interface v4, v5, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
    invoke-virtual v4, Landroid/view/View;->getParent()Landroid/view/ViewParent;
    move-result-object v4
    instance-of v0, v4, Landroid/view/View;
    if-eqz v0, +005h
    check-cast v4, Landroid/view/View;
    goto -28h
    const/4 v4, 0
    goto -2ah
    return-void 
.end method

.method private final pureShowWidgetLayoutParams(android.content.Context)android.widget.LinearLayout$LayoutParams
    .registers 5
    # ins_size=2
    new-instance v0, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v1, -1
    const/4 v2, -2
    invoke-direct v0, v1, v2, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    invoke-virtual v4, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v4
    sget v1, Lcom/bytedance/trae/conversation/R$dimen;->trae_dp_8 I
    invoke-virtual v4, v1, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v4
    iput v4, v0, Landroid/widget/LinearLayout$LayoutParams;->topMargin I
    return-object v0
.end method

.method public final createContainer$conversation_mainlandRelease(android.content.Context)android.widget.LinearLayout
    .registers 5
    # ins_size=2
    const-string v0, "context"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Landroid/widget/LinearLayout;
    invoke-direct v0, v4, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v4, 1
    invoke-virtual v0, v4, Landroid/widget/LinearLayout;->setOrientation(I)V
    new-instance v4, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v1, -1
    const/4 v2, -2
    invoke-direct v4, v1, v2, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v4, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v4, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    return-object v0
.end method

.method public final release$conversation_mainlandRelease(android.view.View)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, view
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    instance-of v0, v2, Landroid/widget/LinearLayout;
    if-eqz v0, +005h
    check-cast v2, Landroid/widget/LinearLayout;
    goto +2h
    const/4 v2, 0
    if-nez v2, +003h
    return-void 
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetToolcallGroupRenderer;->findPureShowWidgetInlineView(Landroid/widget/LinearLayout;)Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;
    move-result-object v0
    if-eqz v0, +005h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->release()V
    invoke-virtual v2, Landroid/widget/LinearLayout;->removeAllViews()V
    invoke-virtual v2, Landroid/widget/LinearLayout;->requestLayout()V
    return-void 
.end method

.method public render(android.content.Context  com.bytedance.trae.conversation.chat.block.AgentContentBlock$PureShowWidgetToolcallGroup)android.view.View
    .registers 4
    # ins_size=3
    const-string v0, "context"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "block"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetToolcallGroupRenderer;->createContainer$conversation_mainlandRelease(Landroid/content/Context;)Landroid/widget/LinearLayout;
    move-result-object v2
    invoke-direct v1, v2, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetToolcallGroupRenderer;->bind(Landroid/widget/LinearLayout; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PureShowWidgetToolcallGroup;)V
    check-cast v2, Landroid/view/View;
    return-object v2
.end method

.method public bridge synthetic render(android.content.Context  com.bytedance.trae.conversation.chat.block.AgentContentBlock)android.view.View
    .registers 3
    # ins_size=3
    check-cast v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PureShowWidgetToolcallGroup;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetToolcallGroupRenderer;->render(Landroid/content/Context; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PureShowWidgetToolcallGroup;)Landroid/view/View;
    move-result-object v1
    return-object v1
.end method

.method public update(android.view.View  com.bytedance.trae.conversation.chat.block.AgentContentBlock$PureShowWidgetToolcallGroup)void
    .registers 4
    # ins_size=3
    const-string/jumbo v0, view
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "block"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    instance-of v0, v2, Landroid/widget/LinearLayout;
    if-eqz v0, +005h
    check-cast v2, Landroid/widget/LinearLayout;
    goto +2h
    const/4 v2, 0
    if-nez v2, +003h
    return-void 
    invoke-direct v1, v2, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetToolcallGroupRenderer;->bind(Landroid/widget/LinearLayout; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PureShowWidgetToolcallGroup;)V
    return-void 
.end method

.method public bridge synthetic update(android.view.View  com.bytedance.trae.conversation.chat.block.AgentContentBlock)void
    .registers 3
    # ins_size=3
    check-cast v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PureShowWidgetToolcallGroup;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetToolcallGroupRenderer;->update(Landroid/view/View; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PureShowWidgetToolcallGroup;)V
    return-void 
.end method
