# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/ConversationActivity$initCheckpointDialog$3;
.super Ljava/lang/Object;
.source "ConversationActivity.kt"

.implements Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointInteractionCallback;

.field final synthetic this$0:Lcom/bytedance/trae/conversation/ConversationActivity;


.method constructor <init>(com.bytedance.trae.conversation.ConversationActivity)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity$initCheckpointDialog$3;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public onDecision(com.bytedance.trae.conversation.chat.checkpoint.CheckpointDecision)void
    .registers 3
    # ins_size=2
    const-string v0, "decision"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity$initCheckpointDialog$3;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationActivity;->access$getViewModel$p(Lcom/bytedance/trae/conversation/ConversationActivity;)Lcom/bytedance/trae/conversation/ConversationViewModel;
    move-result-object v0
    if-nez v0, +009h
    const-string/jumbo v0, viewModel
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    invoke-virtual v0, v2, Lcom/bytedance/trae/conversation/ConversationViewModel;->handleCheckpointDecision(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision;)V
    return-void 
.end method
