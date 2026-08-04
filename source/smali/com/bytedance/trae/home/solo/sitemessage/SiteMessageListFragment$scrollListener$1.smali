# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment$scrollListener$1;
.super Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;
.source "SiteMessageListFragment.kt"

.field final synthetic this$0:Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;


.method constructor <init>(com.bytedance.trae.home.solo.sitemessage.SiteMessageListFragment)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment$scrollListener$1;->this$0 Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;
    invoke-direct v0, Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;-><init>()V
    return-void 
.end method

.method public onScrollStateChanged(androidx.recyclerview.widget.RecyclerView  int)void
    .registers 4
    # ins_size=3
    const-string v0, "recyclerView"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v2, 1
    if-ne v3, v2, +013h
    iget-object v2, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment$scrollListener$1;->this$0 Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;
    invoke-static v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->access$getAdapter$p(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;)Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;
    move-result-object v2
    if-nez v2, +008h
    const-string v2, "adapter"
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v2, 0
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;->closeOpenItem()V
    return-void 
.end method

.method public onScrolled(androidx.recyclerview.widget.RecyclerView  int  int)void
    .registers 7
    # ins_size=4
    const-string v5, "recyclerView"
    invoke-static v4, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v4, Landroidx/recyclerview/widget/RecyclerView;->getLayoutManager()Landroidx/recyclerview/widget/RecyclerView$LayoutManager;
    move-result-object v4
    instance-of v5, v4, Landroidx/recyclerview/widget/LinearLayoutManager;
    const/4 v6, 0
    if-eqz v5, +005h
    check-cast v4, Landroidx/recyclerview/widget/LinearLayoutManager;
    goto +2h
    move-object v4, v6
    if-nez v4, +003h
    return-void 
    invoke-virtual v4, Landroidx/recyclerview/widget/LinearLayoutManager;->getItemCount()I
    move-result v5
    invoke-virtual v4, Landroidx/recyclerview/widget/LinearLayoutManager;->findLastVisibleItemPosition()I
    move-result v0
    add-int/lit8 v5, v5, -3
    if-lt v0, v5, +007h
    iget-object v5, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment$scrollListener$1;->this$0 Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;
    invoke-static v5, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->access$loadMore(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;)V
    invoke-virtual v4, Landroidx/recyclerview/widget/LinearLayoutManager;->findFirstVisibleItemPosition()I
    move-result v5
    invoke-virtual v4, Landroidx/recyclerview/widget/LinearLayoutManager;->findLastVisibleItemPosition()I
    move-result v4
    if-gt v5, v4, +038h
    iget-object v0, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment$scrollListener$1;->this$0 Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;
    invoke-static v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->access$getAdapter$p(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;)Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;
    move-result-object v0
    if-nez v0, +008h
    const-string v0, "adapter"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v6
    invoke-virtual v0, v5, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;->getItem(I)Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;
    move-result-object v0
    if-nez v0, +003h
    goto +1dh
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;->isRead()Ljava/lang/Boolean;
    move-result-object v1
    const/4 v2, 0
    invoke-static v2, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v2
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +00fh
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment$scrollListener$1;->this$0 Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;
    invoke-static v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->access$getReadTracker(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;)Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;
    move-result-object v1
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;->getId()I
    move-result v0
    invoke-virtual v1, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;->startTracking(I)V
    if-eq v5, v4, +005h
    add-int/lit8 v5, v5, 1
    goto -35h
    return-void 
.end method
