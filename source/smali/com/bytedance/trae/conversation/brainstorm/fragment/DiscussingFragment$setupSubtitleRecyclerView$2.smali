# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$setupSubtitleRecyclerView$2;
.super Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;
.source "DiscussingFragment.kt"

.field final synthetic this$0:Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;


.method constructor <init>(com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$setupSubtitleRecyclerView$2;->this$0 Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;
    invoke-direct v0, Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;-><init>()V
    return-void 
.end method

.method public onScrollStateChanged(androidx.recyclerview.widget.RecyclerView  int)void
    .registers 4
    # ins_size=3
    const-string v0, "recyclerView"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v2, 1
    if-ne v3, v2, +00dh
    iget-object v3, v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$setupSubtitleRecyclerView$2;->this$0 Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;
    invoke-static v3, v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->access$setUserScrolling$p(Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment; Z)V
    iget-object v3, v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$setupSubtitleRecyclerView$2;->this$0 Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;
    invoke-static v3, v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->access$setDragging$p(Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment; Z)V
    goto +7h
    iget-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$setupSubtitleRecyclerView$2;->this$0 Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;
    const/4 v3, 0
    invoke-static v2, v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->access$setDragging$p(Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment; Z)V
    return-void 
.end method

.method public onScrolled(androidx.recyclerview.widget.RecyclerView  int  int)void
    .registers 4
    # ins_size=4
    const-string v2, "recyclerView"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v2, 1
    invoke-virtual v1, v2, Landroidx/recyclerview/widget/RecyclerView;->canScrollVertically(I)Z
    move-result v1
    xor-int/2addr v1, v2
    iget-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$setupSubtitleRecyclerView$2;->this$0 Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;
    invoke-static v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->access$updateSubtitleTopGradient(Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;)V
    if-eqz v1, +00eh
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$setupSubtitleRecyclerView$2;->this$0 Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;
    const/4 v2, 0
    invoke-static v1, v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->access$setUserScrolling$p(Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment; Z)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$setupSubtitleRecyclerView$2;->this$0 Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;
    invoke-static v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->access$hideScrollToBottomButton(Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;)V
    goto +eh
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$setupSubtitleRecyclerView$2;->this$0 Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;
    invoke-static v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->access$isUserScrolling$p(Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;)Z
    move-result v1
    if-eqz v1, +007h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$setupSubtitleRecyclerView$2;->this$0 Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;
    invoke-static v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->access$showScrollToBottomButton(Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;)V
    return-void 
.end method
