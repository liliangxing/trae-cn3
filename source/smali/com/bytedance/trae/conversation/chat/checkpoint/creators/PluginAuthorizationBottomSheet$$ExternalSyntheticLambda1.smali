# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet$$ExternalSyntheticLambda1;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Landroid/content/DialogInterface$OnShowListener;

.field public final synthetic f$0:Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;
.field public final synthetic f$1:I


.method public synthetic constructor <init>(com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationBottomSheet  int)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet$$ExternalSyntheticLambda1;->f$0 Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;
    iput v2, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet$$ExternalSyntheticLambda1;->f$1 I
    return-void 
.end method

.method public final onShow(android.content.DialogInterface)void
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet$$ExternalSyntheticLambda1;->f$0 Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;
    iget v1, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet$$ExternalSyntheticLambda1;->f$1 I
    invoke-static v0, v1, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;->$r8$lambda$0udP-cOL4BqJX1P7IWXUSPZavKk(Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet; I Landroid/content/DialogInterface;)V
    return-void 
.end method
