# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$$ExternalSyntheticLambda6;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;
.field public final synthetic f$1:Ljava/lang/String;


.method public synthetic constructor <init>(com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog  java.lang.String)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$$ExternalSyntheticLambda6;->f$0 Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$$ExternalSyntheticLambda6;->f$1 Ljava/lang/String;
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$$ExternalSyntheticLambda6;->f$0 Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$$ExternalSyntheticLambda6;->f$1 Ljava/lang/String;
    check-cast v3, Ljava/lang/String;
    invoke-static v0, v1, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->$r8$lambda$bdDGUdPLh_H7sx-3cAeJ1cpMTCQ(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog; Ljava/lang/String; Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v3
    return-object v3
.end method
