# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$setQuestionText$listener$1;
.super Ljava/lang/Object;
.source "CheckpointDialog.kt"

.implements Landroid/view/View$OnLayoutChangeListener;

.field final synthetic $text:Ljava/lang/String;
.field final synthetic this$0:Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;


.method constructor <init>(com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialog  java.lang.String)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$setQuestionText$listener$1;->this$0 Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$setQuestionText$listener$1;->$text Ljava/lang/String;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public onLayoutChange(android.view.View  int  int  int  int  int  int  int  int)void
    .registers 10
    # ins_size=10
    const-string/jumbo v2, v
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$setQuestionText$listener$1;->this$0 Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;
    iget-object v2, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$setQuestionText$listener$1;->$text Ljava/lang/String;
    invoke-static v1, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->access$applyQuestionViewportIfReady(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog; Ljava/lang/String;)Z
    move-result v1
    if-eqz v1, +025h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$setQuestionText$listener$1;->this$0 Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;
    invoke-static v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->access$getTvQuestion$p(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;)Landroid/widget/TextView;
    move-result-object v1
    const/4 v2, 0
    if-nez v1, +009h
    const-string/jumbo v1, tvQuestion
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v2
    move-object v3, v0
    check-cast v3, Landroid/view/View$OnLayoutChangeListener;
    invoke-virtual v1, v3, Landroid/widget/TextView;->removeOnLayoutChangeListener(Landroid/view/View$OnLayoutChangeListener;)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$setQuestionText$listener$1;->this$0 Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;
    invoke-static v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->access$getQuestionLayoutListener$p(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;)Landroid/view/View$OnLayoutChangeListener;
    move-result-object v1
    if-ne v1, v0, +007h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$setQuestionText$listener$1;->this$0 Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;
    invoke-static v1, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->access$setQuestionLayoutListener$p(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog; Landroid/view/View$OnLayoutChangeListener;)V
    return-void 
.end method
