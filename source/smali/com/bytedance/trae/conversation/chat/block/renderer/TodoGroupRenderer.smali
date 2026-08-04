# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer;
.super Ljava/lang/Object;
.source "TodoGroupRenderer.kt"

.implements Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;

.field private final BLOCK_TAG:Ljava/lang/String;


.method public constructor <init>()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    const-string v0, "TodoGroupRenderer"
    iput-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer;->BLOCK_TAG Ljava/lang/String;
    return-void 
.end method

.method public render(android.content.Context  com.bytedance.trae.conversation.chat.block.AgentContentBlock$TodoGroup)android.view.View
    .registers 4
    # ins_size=3
    const-string v0, "context"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "block"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;-><init>()V
    invoke-virtual v0, v2, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->render(Landroid/content/Context; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;)Landroid/view/View;
    move-result-object v2
    sget v3, Lcom/bytedance/trae/conversation/R$id;->trae_tag_todo_group_view_manager I
    invoke-virtual v2, v3, v0, Landroid/view/View;->setTag(I Ljava/lang/Object;)V
    return-object v2
.end method

.method public bridge synthetic render(android.content.Context  com.bytedance.trae.conversation.chat.block.AgentContentBlock)android.view.View
    .registers 3
    # ins_size=3
    check-cast v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer;->render(Landroid/content/Context; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;)Landroid/view/View;
    move-result-object v1
    return-object v1
.end method

.method public update(android.view.View  com.bytedance.trae.conversation.chat.block.AgentContentBlock$TodoGroup)void
    .registers 5
    # ins_size=3
    const-string/jumbo v0, view
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "block"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget v0, Lcom/bytedance/trae/conversation/R$id;->trae_tag_todo_group_view_manager I
    invoke-virtual v3, v0, Landroid/view/View;->getTag(I)Ljava/lang/Object;
    move-result-object v0
    instance-of v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;
    if-eqz v1, +005h
    check-cast v0, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;
    goto +2h
    const/4 v0, 0
    if-nez v0, +003h
    return-void 
    invoke-virtual v0, v3, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->update(Landroid/view/View; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;)V
    return-void 
.end method

.method public bridge synthetic update(android.view.View  com.bytedance.trae.conversation.chat.block.AgentContentBlock)void
    .registers 3
    # ins_size=3
    check-cast v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer;->update(Landroid/view/View; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;)V
    return-void 
.end method
