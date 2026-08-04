# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$$ExternalSyntheticLambda15;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Landroid/view/View$OnFocusChangeListener;

.field public final synthetic f$0:Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;
.field public final synthetic f$1:Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;


.method public synthetic constructor <init>(com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog  com.bytedance.trae.conversation.chat.checkpoint.CheckpointPage)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$$ExternalSyntheticLambda15;->f$0 Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$$ExternalSyntheticLambda15;->f$1 Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;
    return-void 
.end method

.method public final onFocusChange(android.view.View  boolean)void
    .registers 5
    # ins_size=3
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$$ExternalSyntheticLambda15;->f$0 Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$$ExternalSyntheticLambda15;->f$1 Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;
    invoke-static v0, v1, v3, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->$r8$lambda$UirLPKGaeg-he9YCYED_V71UIOs(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog; Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage; Landroid/view/View; Z)V
    return-void 
.end method
