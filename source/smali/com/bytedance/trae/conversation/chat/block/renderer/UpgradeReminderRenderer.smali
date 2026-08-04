# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/renderer/UpgradeReminderRenderer;
.super Ljava/lang/Object;
.source "UpgradeReminderRenderer.kt"

.implements Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;


.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public render(android.content.Context  com.bytedance.trae.conversation.chat.block.AgentContentBlock$UpgradeReminder)android.view.View
    .registers 5
    # ins_size=3
    const-string v0, "context"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "block"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/chat/viewholder/UpgradeReminderViewHolder;->Companion Lcom/bytedance/trae/conversation/chat/viewholder/UpgradeReminderViewHolder$Companion;
    const/4 v1, 0
    invoke-virtual v0, v3, v1, Lcom/bytedance/trae/conversation/chat/viewholder/UpgradeReminderViewHolder$Companion;->createView(Landroid/content/Context; Z)Lcom/bytedance/trae/conversation/chat/viewholder/UpgradeReminderViewHolder;
    move-result-object v3
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$UpgradeReminder;->getConversationId()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$UpgradeReminder;->getOnClick()Lkotlin/jvm/functions/Function1;
    move-result-object v4
    invoke-virtual v3, v0, v4, Lcom/bytedance/trae/conversation/chat/viewholder/UpgradeReminderViewHolder;->bind(Ljava/lang/String; Lkotlin/jvm/functions/Function1;)V
    iget-object v3, v3, Lcom/bytedance/trae/conversation/chat/viewholder/UpgradeReminderViewHolder;->itemView Landroid/view/View;
    const-string v4, "itemView"
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v3
.end method

.method public bridge synthetic render(android.content.Context  com.bytedance.trae.conversation.chat.block.AgentContentBlock)android.view.View
    .registers 3
    # ins_size=3
    check-cast v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$UpgradeReminder;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/UpgradeReminderRenderer;->render(Landroid/content/Context; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$UpgradeReminder;)Landroid/view/View;
    move-result-object v1
    return-object v1
.end method

.method public update(android.view.View  com.bytedance.trae.conversation.chat.block.AgentContentBlock$UpgradeReminder)void
    .registers 4
    # ins_size=3
    const-string/jumbo v0, view
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "block"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/chat/viewholder/UpgradeReminderViewHolder;->Companion Lcom/bytedance/trae/conversation/chat/viewholder/UpgradeReminderViewHolder$Companion;
    invoke-virtual v0, v2, Lcom/bytedance/trae/conversation/chat/viewholder/UpgradeReminderViewHolder$Companion;->fromView(Landroid/view/View;)Lcom/bytedance/trae/conversation/chat/viewholder/UpgradeReminderViewHolder;
    move-result-object v2
    if-eqz v2, +00dh
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$UpgradeReminder;->getConversationId()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$UpgradeReminder;->getOnClick()Lkotlin/jvm/functions/Function1;
    move-result-object v3
    invoke-virtual v2, v0, v3, Lcom/bytedance/trae/conversation/chat/viewholder/UpgradeReminderViewHolder;->bind(Ljava/lang/String; Lkotlin/jvm/functions/Function1;)V
    return-void 
.end method

.method public bridge synthetic update(android.view.View  com.bytedance.trae.conversation.chat.block.AgentContentBlock)void
    .registers 3
    # ins_size=3
    check-cast v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$UpgradeReminder;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/UpgradeReminderRenderer;->update(Landroid/view/View; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$UpgradeReminder;)V
    return-void 
.end method
