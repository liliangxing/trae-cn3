# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$setupSubtitleRecyclerView$1;
.super Ljava/lang/Object;
.source "DiscussingFragment.kt"

.implements Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentCallback;

.field final synthetic this$0:Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;


.method constructor <init>(com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$setupSubtitleRecyclerView$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public onClose(java.lang.String  com.bytedance.trae.conversation.brainstorm.model.AttachmentState)void
    .registers 6
    # ins_size=3
    const-string v0, "attachmentId"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, state
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;->Uploading Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;
    const/4 v1, 0
    const-string/jumbo v2, viewModel
    if-ne v5, v0, +013h
    iget-object v5, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$setupSubtitleRecyclerView$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;
    invoke-static v5, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->access$getViewModel$p(Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;)Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    move-result-object v5
    if-nez v5, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v5
    invoke-virtual v1, v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->cancelAttachment(Ljava/lang/String;)V
    goto +11h
    iget-object v5, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$setupSubtitleRecyclerView$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;
    invoke-static v5, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->access$getViewModel$p(Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;)Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    move-result-object v5
    if-nez v5, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v5
    invoke-virtual v1, v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->removeAttachment(Ljava/lang/String;)V
    return-void 
.end method

.method public onPreview(com.bytedance.trae.conversation.brainstorm.model.BrainstormAttachment)void
    .registers 3
    # ins_size=2
    const-string v0, "attachment"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$setupSubtitleRecyclerView$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;
    invoke-static v0, v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->access$previewAttachment(Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment; Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;)V
    return-void 
.end method

.method public onRetry(java.lang.String)void
    .registers 3
    # ins_size=2
    const-string v0, "attachmentId"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$setupSubtitleRecyclerView$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;
    invoke-static v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->access$getViewModel$p(Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;)Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    move-result-object v0
    if-nez v0, +009h
    const-string/jumbo v0, viewModel
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    invoke-virtual v0, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->retryAttachment(Ljava/lang/String;)V
    return-void 
.end method
