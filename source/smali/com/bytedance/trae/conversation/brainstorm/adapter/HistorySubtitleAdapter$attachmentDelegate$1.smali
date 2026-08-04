# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$attachmentDelegate$1;
.super Ljava/lang/Object;
.source "HistorySubtitleAdapter.kt"

.implements Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentCallback;

.field final synthetic this$0:Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;


.method constructor <init>(com.bytedance.trae.conversation.brainstorm.adapter.HistorySubtitleAdapter)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$attachmentDelegate$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public onClose(java.lang.String  com.bytedance.trae.conversation.brainstorm.model.AttachmentState)void
    .registers 4
    # ins_size=3
    const-string v0, "attachmentId"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, state
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$attachmentDelegate$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->getAttachmentCallback()Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentCallback;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, v2, v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentCallback;->onClose(Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;)V
    return-void 
.end method

.method public onPreview(com.bytedance.trae.conversation.brainstorm.model.BrainstormAttachment)void
    .registers 3
    # ins_size=2
    const-string v0, "attachment"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$attachmentDelegate$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->getAttachmentCallback()Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentCallback;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentCallback;->onPreview(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;)V
    return-void 
.end method

.method public onRetry(java.lang.String)void
    .registers 3
    # ins_size=2
    const-string v0, "attachmentId"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$attachmentDelegate$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;->getAttachmentCallback()Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentCallback;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentCallback;->onRetry(Ljava/lang/String;)V
    return-void 
.end method
