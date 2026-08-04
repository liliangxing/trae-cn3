# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$onViewCreated$6;
.super Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;
.source "GitRepoSelectBottomSheet.kt"

.field final synthetic $layoutManager:Landroidx/recyclerview/widget/LinearLayoutManager;
.field final synthetic this$0:Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;


.method constructor <init>(androidx.recyclerview.widget.LinearLayoutManager  com.bytedance.trae.conversation.git.GitRepoSelectBottomSheet)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$onViewCreated$6;->$layoutManager Landroidx/recyclerview/widget/LinearLayoutManager;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$onViewCreated$6;->this$0 Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;
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
    iget-object v1, v0, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$onViewCreated$6;->$layoutManager Landroidx/recyclerview/widget/LinearLayoutManager;
    invoke-virtual v1, Landroidx/recyclerview/widget/LinearLayoutManager;->getItemCount()I
    move-result v1
    iget-object v2, v0, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$onViewCreated$6;->$layoutManager Landroidx/recyclerview/widget/LinearLayoutManager;
    invoke-virtual v2, Landroidx/recyclerview/widget/LinearLayoutManager;->findLastVisibleItemPosition()I
    move-result v2
    iget-object v3, v0, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$onViewCreated$6;->this$0 Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;
    invoke-static v3, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->access$isLoadingMore$p(Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;)Z
    move-result v3
    if-eqz v3, +003h
    return-void 
    add-int/lit8 v1, v1, -3
    if-ge v2, v1, +003h
    return-void 
    iget-object v1, v0, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$onViewCreated$6;->this$0 Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;
    invoke-static v1, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->access$isSearching$p(Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;)Z
    move-result v1
    if-eqz v1, +003h
    return-void 
    iget-object v1, v0, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$onViewCreated$6;->this$0 Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;
    invoke-static v1, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->access$getGitViewModel$p(Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;)Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    move-result-object v1
    const/4 v2, 0
    const-string v3, "gitViewModel"
    if-nez v1, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v2
    invoke-virtual v1, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->getHasMoreRepos()Z
    move-result v1
    if-eqz v1, +012h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$onViewCreated$6;->this$0 Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;
    invoke-static v1, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->access$getGitViewModel$p(Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;)Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    move-result-object v1
    if-nez v1, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v2, v1
    invoke-virtual v2, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->loadMoreRepos()V
    return-void 
.end method
