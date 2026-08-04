# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Landroid/view/View$OnClickListener;

.field public final synthetic f$0:Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;
.field public final synthetic f$1:F


.method public synthetic constructor <init>(com.bytedance.trae.conversation.chat.block.renderer.TodoGroupRenderer$TodoGroupViewManager  float)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;
    iput v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager$$ExternalSyntheticLambda0;->f$1 F
    return-void 
.end method

.method public final onClick(android.view.View)void
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;
    iget v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager$$ExternalSyntheticLambda0;->f$1 F
    invoke-static v0, v1, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;->$r8$lambda$nGVoGsmUYdL4SpoUYT9x_VK2TQc(Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager; F Landroid/view/View;)V
    return-void 
.end method
