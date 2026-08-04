# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/ConversationActivity$voiceMinimizedBackCallback$1;
.super Landroidx/activity/OnBackPressedCallback;
.source "ConversationActivity.kt"

.field final synthetic this$0:Lcom/bytedance/trae/conversation/ConversationActivity;


.method constructor <init>(com.bytedance.trae.conversation.ConversationActivity)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity$voiceMinimizedBackCallback$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    const/4 v1, 0
    invoke-direct v0, v1, Landroidx/activity/OnBackPressedCallback;-><init>(Z)V
    return-void 
.end method

.method public handleOnBackPressed()void
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity$voiceMinimizedBackCallback$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationActivity;->access$showEndVoiceDiscussionDialog(Lcom/bytedance/trae/conversation/ConversationActivity;)V
    return-void 
.end method
