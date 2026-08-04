# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$$ExternalSyntheticLambda2;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function0;

.field public final synthetic f$0:Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;
.field public final synthetic f$1:Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;
.field public final synthetic f$2:Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;
.field public final synthetic f$3:Z


.method public synthetic constructor <init>(com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog  com.bytedance.trae.conversation.chat.checkpoint.CheckpointPage  com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator  boolean)void
    .registers 5
    # ins_size=5
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$$ExternalSyntheticLambda2;->f$0 Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$$ExternalSyntheticLambda2;->f$1 Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$$ExternalSyntheticLambda2;->f$2 Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;
    iput-boolean v4, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$$ExternalSyntheticLambda2;->f$3 Z
    return-void 
.end method

.method public final invoke()java.lang.Object
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$$ExternalSyntheticLambda2;->f$0 Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$$ExternalSyntheticLambda2;->f$1 Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;
    iget-object v2, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$$ExternalSyntheticLambda2;->f$2 Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;
    iget-boolean v3, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$$ExternalSyntheticLambda2;->f$3 Z
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->$r8$lambda$XIP0rIlVmOzRJ-ysWVM53RL3UEY(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog; Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage; Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator; Z)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method
