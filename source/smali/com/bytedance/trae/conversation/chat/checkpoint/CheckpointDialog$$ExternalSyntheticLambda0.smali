# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Landroid/view/View$OnClickListener;

.field public final synthetic f$0:Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;
.field public final synthetic f$1:Lcom/bytedance/trae/im/model/ParsedPlanItem;
.field public final synthetic f$2:Ljava/lang/String;


.method public synthetic constructor <init>(com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog  com.bytedance.trae.im.model.ParsedPlanItem  java.lang.String)void
    .registers 4
    # ins_size=4
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$$ExternalSyntheticLambda0;->f$1 Lcom/bytedance/trae/im/model/ParsedPlanItem;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$$ExternalSyntheticLambda0;->f$2 Ljava/lang/String;
    return-void 
.end method

.method public final onClick(android.view.View)void
    .registers 5
    # ins_size=2
    iget-object v0, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$$ExternalSyntheticLambda0;->f$1 Lcom/bytedance/trae/im/model/ParsedPlanItem;
    iget-object v2, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$$ExternalSyntheticLambda0;->f$2 Ljava/lang/String;
    invoke-static v0, v1, v2, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->$r8$lambda$ZNnxbRc8H0IExWCbV5NizaHvj1g(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog; Lcom/bytedance/trae/im/model/ParsedPlanItem; Ljava/lang/String; Landroid/view/View;)V
    return-void 
.end method
