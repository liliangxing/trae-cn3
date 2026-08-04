# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$$ExternalSyntheticLambda1;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Ljava/lang/Runnable;

.field public final synthetic f$0:Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;
.field public final synthetic f$1:Ljava/lang/String;
.field public final synthetic f$2:Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$setQuestionText$listener$1;


.method public synthetic constructor <init>(com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog  java.lang.String  com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog$setQuestionText$listener$1)void
    .registers 4
    # ins_size=4
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$$ExternalSyntheticLambda1;->f$0 Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$$ExternalSyntheticLambda1;->f$1 Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$$ExternalSyntheticLambda1;->f$2 Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$setQuestionText$listener$1;
    return-void 
.end method

.method public final run()void
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$$ExternalSyntheticLambda1;->f$0 Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$$ExternalSyntheticLambda1;->f$1 Ljava/lang/String;
    iget-object v2, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$$ExternalSyntheticLambda1;->f$2 Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$setQuestionText$listener$1;
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->$r8$lambda$pQ2hPJr_IhSq1Z8uu0ZrFiLUe4I(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog; Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$setQuestionText$listener$1;)V
    return-void 
.end method
