# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager$$ExternalSyntheticLambda2;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Ljava/lang/String;
.field public final synthetic f$1:Ljava/lang/String;
.field public final synthetic f$2:Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
.field public final synthetic f$3:Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointInteractionCallback;
.field public final synthetic f$4:Lcom/bytedance/trae/im/model/ParsedPlanItem;
.field public final synthetic f$5:Ljava/lang/String;
.field public final synthetic f$6:Ljava/lang/String;


.method public synthetic constructor <init>(java.lang.String  java.lang.String  com.bytedance.trae.im.model.ParsedToolCallInfo  com.bytedance.trae.conversation.chat.checkpoint.CheckpointInteractionCallback  com.bytedance.trae.im.model.ParsedPlanItem  java.lang.String  java.lang.String)void
    .registers 8
    # ins_size=8
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager$$ExternalSyntheticLambda2;->f$0 Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager$$ExternalSyntheticLambda2;->f$1 Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager$$ExternalSyntheticLambda2;->f$2 Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager$$ExternalSyntheticLambda2;->f$3 Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointInteractionCallback;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager$$ExternalSyntheticLambda2;->f$4 Lcom/bytedance/trae/im/model/ParsedPlanItem;
    iput-object v6, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager$$ExternalSyntheticLambda2;->f$5 Ljava/lang/String;
    iput-object v7, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager$$ExternalSyntheticLambda2;->f$6 Ljava/lang/String;
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 10
    # ins_size=2
    iget-object v0, v8, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager$$ExternalSyntheticLambda2;->f$0 Ljava/lang/String;
    iget-object v1, v8, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager$$ExternalSyntheticLambda2;->f$1 Ljava/lang/String;
    iget-object v2, v8, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager$$ExternalSyntheticLambda2;->f$2 Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager$$ExternalSyntheticLambda2;->f$3 Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointInteractionCallback;
    iget-object v4, v8, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager$$ExternalSyntheticLambda2;->f$4 Lcom/bytedance/trae/im/model/ParsedPlanItem;
    iget-object v5, v8, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager$$ExternalSyntheticLambda2;->f$5 Ljava/lang/String;
    iget-object v6, v8, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager$$ExternalSyntheticLambda2;->f$6 Ljava/lang/String;
    move-object v7, v9
    check-cast v7, Ljava/lang/String;
    invoke-static/range v0 ... v7, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;->$r8$lambda$4ORSHP29KShZ64EpWHvLJXhXLIM(Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedToolCallInfo; Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointInteractionCallback; Lcom/bytedance/trae/im/model/ParsedPlanItem; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v9
    return-object v9
.end method
