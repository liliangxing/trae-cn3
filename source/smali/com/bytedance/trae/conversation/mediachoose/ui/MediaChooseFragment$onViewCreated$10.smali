# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$onViewCreated$10;
.super Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;
.source "MediaChooseFragment.kt"

.field final synthetic $gridLayoutManager:Landroidx/recyclerview/widget/GridLayoutManager;
.field final synthetic this$0:Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;


.method constructor <init>(androidx.recyclerview.widget.GridLayoutManager  com.bytedance.trae.conversation.mediachoose.ui.MediaChooseFragment)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$onViewCreated$10;->$gridLayoutManager Landroidx/recyclerview/widget/GridLayoutManager;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$onViewCreated$10;->this$0 Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;
    invoke-direct v0, Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;-><init>()V
    return-void 
.end method

.method public onScrolled(androidx.recyclerview.widget.RecyclerView  int  int)void
    .registers 4
    # ins_size=4
    const-string v2, "recyclerView"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    if-gtz v3, +003h
    return-void 
    iget-object v1, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$onViewCreated$10;->$gridLayoutManager Landroidx/recyclerview/widget/GridLayoutManager;
    invoke-virtual v1, Landroidx/recyclerview/widget/GridLayoutManager;->findLastVisibleItemPosition()I
    move-result v1
    iget-object v2, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$onViewCreated$10;->this$0 Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;
    invoke-static v2, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->access$getAdapter$p(Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;)Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter;
    move-result-object v2
    if-nez v2, +008h
    const-string v2, "adapter"
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v2, 0
    invoke-virtual v2, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter;->getItemCount()I
    move-result v2
    add-int/lit8 v2, v2, -12
    if-lt v1, v2, +007h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$onViewCreated$10;->this$0 Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;
    invoke-static v1, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->access$loadNextPageIfNeed(Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;)V
    return-void 
.end method
