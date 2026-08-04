# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/chat/block/renderer/ViewVoiceHistoryRenderer$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Landroid/view/View$OnClickListener;

.field public final synthetic f$0:Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ViewVoiceHistory;
.field public final synthetic f$1:Landroid/content/Context;


.method public synthetic constructor <init>(com.bytedance.trae.conversation.chat.block.AgentContentBlock$ViewVoiceHistory  android.content.Context)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ViewVoiceHistoryRenderer$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ViewVoiceHistory;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ViewVoiceHistoryRenderer$$ExternalSyntheticLambda0;->f$1 Landroid/content/Context;
    return-void 
.end method

.method public final onClick(android.view.View)void
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ViewVoiceHistoryRenderer$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ViewVoiceHistory;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ViewVoiceHistoryRenderer$$ExternalSyntheticLambda0;->f$1 Landroid/content/Context;
    invoke-static v0, v1, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ViewVoiceHistoryRenderer;->$r8$lambda$ctpJ9yujqnQF6UsFBl2LqZzVyr0(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ViewVoiceHistory; Landroid/content/Context; Landroid/view/View;)V
    return-void 
.end method
