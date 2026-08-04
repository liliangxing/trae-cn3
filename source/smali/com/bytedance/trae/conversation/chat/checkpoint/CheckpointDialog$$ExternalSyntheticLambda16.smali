# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$$ExternalSyntheticLambda16;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Landroid/widget/TextView$OnEditorActionListener;

.field public final synthetic f$0:Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;


.method public synthetic constructor <init>(com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$$ExternalSyntheticLambda16;->f$0 Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;
    return-void 
.end method

.method public final onEditorAction(android.widget.TextView  int  android.view.KeyEvent)boolean
    .registers 5
    # ins_size=4
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$$ExternalSyntheticLambda16;->f$0 Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;
    invoke-static v0, v2, v3, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->$r8$lambda$OOVLldU9yqqrV6UEXV-cNCGAVo0(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog; Landroid/widget/TextView; I Landroid/view/KeyEvent;)Z
    move-result v2
    return v2
.end method
