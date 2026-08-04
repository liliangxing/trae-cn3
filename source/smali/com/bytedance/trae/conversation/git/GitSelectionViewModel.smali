# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
.super Landroidx/lifecycle/ViewModel;
.source "GitSelectionViewModel.kt"

.field public static final Companion:Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$Companion;
.field public static final KEY_SELECTED_REPO:Ljava/lang/String;
.field private static final PAGE_SIZE:I
.field private final _branchListReady:Landroidx/lifecycle/MutableLiveData;
.field private final _branchLoadError:Landroidx/lifecycle/MutableLiveData;
.field private final _branchLoadMoreResult:Landroidx/lifecycle/MutableLiveData;
.field private final _branchLoading:Landroidx/lifecycle/MutableLiveData;
.field private final _branchLoadingMore:Landroidx/lifecycle/MutableLiveData;
.field private final _branchRefreshResult:Landroidx/lifecycle/MutableLiveData;
.field private final _branchSearchResult:Landroidx/lifecycle/MutableLiveData;
.field private final _gitConnectionState:Landroidx/lifecycle/MutableLiveData;
.field private final _repoListReady:Landroidx/lifecycle/MutableLiveData;
.field private final _repoLoadError:Landroidx/lifecycle/MutableLiveData;
.field private final _repoLoadMoreResult:Landroidx/lifecycle/MutableLiveData;
.field private final _repoLoading:Landroidx/lifecycle/MutableLiveData;
.field private final _repoLoadingMore:Landroidx/lifecycle/MutableLiveData;
.field private final _repoSearchResult:Landroidx/lifecycle/MutableLiveData;
.field private final _selectedBranch:Landroidx/lifecycle/MutableLiveData;
.field private final _selectedRepo:Landroidx/lifecycle/MutableLiveData;
.field private final branchListReady:Landroidx/lifecycle/LiveData;
.field private final branchLoadError:Landroidx/lifecycle/LiveData;
.field private final branchLoadMoreResult:Landroidx/lifecycle/LiveData;
.field private final branchLoading:Landroidx/lifecycle/LiveData;
.field private final branchLoadingMore:Landroidx/lifecycle/LiveData;
.field private branchNextPageToken:Ljava/lang/String;
.field private final branchRefreshResult:Landroidx/lifecycle/LiveData;
.field private final branchSearchResult:Landroidx/lifecycle/LiveData;
.field private cachedBranchItems:Ljava/util/List;
.field private cachedRepoItems:Ljava/util/List;
.field private currentSearchKeyword:Ljava/lang/String;
.field private final gitConnectionState:Landroidx/lifecycle/LiveData;
.field private final repoListReady:Landroidx/lifecycle/LiveData;
.field private final repoLoadError:Landroidx/lifecycle/LiveData;
.field private final repoLoadMoreResult:Landroidx/lifecycle/LiveData;
.field private final repoLoading:Landroidx/lifecycle/LiveData;
.field private final repoLoadingMore:Landroidx/lifecycle/LiveData;
.field private repoNextPageToken:Ljava/lang/String;
.field private final repoSearchResult:Landroidx/lifecycle/LiveData;
.field private searchNextPageToken:Ljava/lang/String;
.field private final selectedBranch:Landroidx/lifecycle/LiveData;
.field private final selectedRepo:Landroidx/lifecycle/LiveData;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->Companion Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 3
    # ins_size=1
    invoke-direct v2, Landroidx/lifecycle/ViewModel;-><init>()V
    new-instance v0, Landroidx/lifecycle/MutableLiveData;
    sget-object v1, Lcom/bytedance/trae/conversation/git/GitConnectionState;->DISCONNECTED Lcom/bytedance/trae/conversation/git/GitConnectionState;
    invoke-direct v0, v1, Landroidx/lifecycle/MutableLiveData;-><init>(Ljava/lang/Object;)V
    iput-object v0, v2, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->_gitConnectionState Landroidx/lifecycle/MutableLiveData;
    check-cast v0, Landroidx/lifecycle/LiveData;
    iput-object v0, v2, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->gitConnectionState Landroidx/lifecycle/LiveData;
    new-instance v0, Landroidx/lifecycle/MutableLiveData;
    invoke-direct v0, Landroidx/lifecycle/MutableLiveData;-><init>()V
    iput-object v0, v2, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->_repoListReady Landroidx/lifecycle/MutableLiveData;
    check-cast v0, Landroidx/lifecycle/LiveData;
    iput-object v0, v2, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->repoListReady Landroidx/lifecycle/LiveData;
    new-instance v0, Landroidx/lifecycle/MutableLiveData;
    invoke-direct v0, Landroidx/lifecycle/MutableLiveData;-><init>()V
    iput-object v0, v2, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->_branchListReady Landroidx/lifecycle/MutableLiveData;
    check-cast v0, Landroidx/lifecycle/LiveData;
    iput-object v0, v2, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->branchListReady Landroidx/lifecycle/LiveData;
    new-instance v0, Landroidx/lifecycle/MutableLiveData;
    invoke-direct v0, Landroidx/lifecycle/MutableLiveData;-><init>()V
    iput-object v0, v2, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->_branchLoadMoreResult Landroidx/lifecycle/MutableLiveData;
    check-cast v0, Landroidx/lifecycle/LiveData;
    iput-object v0, v2, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->branchLoadMoreResult Landroidx/lifecycle/LiveData;
    new-instance v0, Landroidx/lifecycle/MutableLiveData;
    invoke-direct v0, Landroidx/lifecycle/MutableLiveData;-><init>()V
    iput-object v0, v2, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->_branchRefreshResult Landroidx/lifecycle/MutableLiveData;
    check-cast v0, Landroidx/lifecycle/LiveData;
    iput-object v0, v2, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->branchRefreshResult Landroidx/lifecycle/LiveData;
    new-instance v0, Landroidx/lifecycle/MutableLiveData;
    invoke-direct v0, Landroidx/lifecycle/MutableLiveData;-><init>()V
    iput-object v0, v2, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->_selectedRepo Landroidx/lifecycle/MutableLiveData;
    check-cast v0, Landroidx/lifecycle/LiveData;
    iput-object v0, v2, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->selectedRepo Landroidx/lifecycle/LiveData;
    new-instance v0, Landroidx/lifecycle/MutableLiveData;
    invoke-direct v0, Landroidx/lifecycle/MutableLiveData;-><init>()V
    iput-object v0, v2, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->_selectedBranch Landroidx/lifecycle/MutableLiveData;
    check-cast v0, Landroidx/lifecycle/LiveData;
    iput-object v0, v2, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->selectedBranch Landroidx/lifecycle/LiveData;
    new-instance v0, Landroidx/lifecycle/MutableLiveData;
    invoke-direct v0, Landroidx/lifecycle/MutableLiveData;-><init>()V
    iput-object v0, v2, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->_repoLoading Landroidx/lifecycle/MutableLiveData;
    check-cast v0, Landroidx/lifecycle/LiveData;
    iput-object v0, v2, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->repoLoading Landroidx/lifecycle/LiveData;
    new-instance v0, Landroidx/lifecycle/MutableLiveData;
    invoke-direct v0, Landroidx/lifecycle/MutableLiveData;-><init>()V
    iput-object v0, v2, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->_branchLoading Landroidx/lifecycle/MutableLiveData;
    check-cast v0, Landroidx/lifecycle/LiveData;
    iput-object v0, v2, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->branchLoading Landroidx/lifecycle/LiveData;
    new-instance v0, Landroidx/lifecycle/MutableLiveData;
    invoke-direct v0, Landroidx/lifecycle/MutableLiveData;-><init>()V
    iput-object v0, v2, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->_branchLoadingMore Landroidx/lifecycle/MutableLiveData;
    check-cast v0, Landroidx/lifecycle/LiveData;
    iput-object v0, v2, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->branchLoadingMore Landroidx/lifecycle/LiveData;
    new-instance v0, Landroidx/lifecycle/MutableLiveData;
    invoke-direct v0, Landroidx/lifecycle/MutableLiveData;-><init>()V
    iput-object v0, v2, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->_repoLoadingMore Landroidx/lifecycle/MutableLiveData;
    check-cast v0, Landroidx/lifecycle/LiveData;
    iput-object v0, v2, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->repoLoadingMore Landroidx/lifecycle/LiveData;
    new-instance v0, Landroidx/lifecycle/MutableLiveData;
    invoke-direct v0, Landroidx/lifecycle/MutableLiveData;-><init>()V
    iput-object v0, v2, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->_repoLoadMoreResult Landroidx/lifecycle/MutableLiveData;
    check-cast v0, Landroidx/lifecycle/LiveData;
    iput-object v0, v2, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->repoLoadMoreResult Landroidx/lifecycle/LiveData;
    new-instance v0, Landroidx/lifecycle/MutableLiveData;
    invoke-direct v0, Landroidx/lifecycle/MutableLiveData;-><init>()V
    iput-object v0, v2, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->_repoLoadError Landroidx/lifecycle/MutableLiveData;
    check-cast v0, Landroidx/lifecycle/LiveData;
    iput-object v0, v2, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->repoLoadError Landroidx/lifecycle/LiveData;
    new-instance v0, Landroidx/lifecycle/MutableLiveData;
    invoke-direct v0, Landroidx/lifecycle/MutableLiveData;-><init>()V
    iput-object v0, v2, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->_branchLoadError Landroidx/lifecycle/MutableLiveData;
    check-cast v0, Landroidx/lifecycle/LiveData;
    iput-object v0, v2, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->branchLoadError Landroidx/lifecycle/LiveData;
    new-instance v0, Landroidx/lifecycle/MutableLiveData;
    invoke-direct v0, Landroidx/lifecycle/MutableLiveData;-><init>()V
    iput-object v0, v2, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->_repoSearchResult Landroidx/lifecycle/MutableLiveData;
    check-cast v0, Landroidx/lifecycle/LiveData;
    iput-object v0, v2, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->repoSearchResult Landroidx/lifecycle/LiveData;
    new-instance v0, Landroidx/lifecycle/MutableLiveData;
    invoke-direct v0, Landroidx/lifecycle/MutableLiveData;-><init>()V
    iput-object v0, v2, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->_branchSearchResult Landroidx/lifecycle/MutableLiveData;
    check-cast v0, Landroidx/lifecycle/LiveData;
    iput-object v0, v2, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->branchSearchResult Landroidx/lifecycle/LiveData;
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v0
    iput-object v0, v2, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->cachedRepoItems Ljava/util/List;
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v0
    iput-object v0, v2, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->cachedBranchItems Ljava/util/List;
    return-void 
.end method

.method public static final synthetic access$getCachedBranchItems$p(com.bytedance.trae.conversation.git.GitSelectionViewModel)java.util.List
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->cachedBranchItems Ljava/util/List;
    return-object v0
.end method

.method public static final synthetic access$getCachedRepoItems$p(com.bytedance.trae.conversation.git.GitSelectionViewModel)java.util.List
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->cachedRepoItems Ljava/util/List;
    return-object v0
.end method

.method public static final synthetic access$get_branchListReady$p(com.bytedance.trae.conversation.git.GitSelectionViewModel)androidx.lifecycle.MutableLiveData
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->_branchListReady Landroidx/lifecycle/MutableLiveData;
    return-object v0
.end method

.method public static final synthetic access$get_branchLoadError$p(com.bytedance.trae.conversation.git.GitSelectionViewModel)androidx.lifecycle.MutableLiveData
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->_branchLoadError Landroidx/lifecycle/MutableLiveData;
    return-object v0
.end method

.method public static final synthetic access$get_branchLoadMoreResult$p(com.bytedance.trae.conversation.git.GitSelectionViewModel)androidx.lifecycle.MutableLiveData
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->_branchLoadMoreResult Landroidx/lifecycle/MutableLiveData;
    return-object v0
.end method

.method public static final synthetic access$get_branchLoading$p(com.bytedance.trae.conversation.git.GitSelectionViewModel)androidx.lifecycle.MutableLiveData
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->_branchLoading Landroidx/lifecycle/MutableLiveData;
    return-object v0
.end method

.method public static final synthetic access$get_branchLoadingMore$p(com.bytedance.trae.conversation.git.GitSelectionViewModel)androidx.lifecycle.MutableLiveData
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->_branchLoadingMore Landroidx/lifecycle/MutableLiveData;
    return-object v0
.end method

.method public static final synthetic access$get_branchRefreshResult$p(com.bytedance.trae.conversation.git.GitSelectionViewModel)androidx.lifecycle.MutableLiveData
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->_branchRefreshResult Landroidx/lifecycle/MutableLiveData;
    return-object v0
.end method

.method public static final synthetic access$get_branchSearchResult$p(com.bytedance.trae.conversation.git.GitSelectionViewModel)androidx.lifecycle.MutableLiveData
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->_branchSearchResult Landroidx/lifecycle/MutableLiveData;
    return-object v0
.end method

.method public static final synthetic access$get_gitConnectionState$p(com.bytedance.trae.conversation.git.GitSelectionViewModel)androidx.lifecycle.MutableLiveData
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->_gitConnectionState Landroidx/lifecycle/MutableLiveData;
    return-object v0
.end method

.method public static final synthetic access$get_repoListReady$p(com.bytedance.trae.conversation.git.GitSelectionViewModel)androidx.lifecycle.MutableLiveData
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->_repoListReady Landroidx/lifecycle/MutableLiveData;
    return-object v0
.end method

.method public static final synthetic access$get_repoLoadError$p(com.bytedance.trae.conversation.git.GitSelectionViewModel)androidx.lifecycle.MutableLiveData
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->_repoLoadError Landroidx/lifecycle/MutableLiveData;
    return-object v0
.end method

.method public static final synthetic access$get_repoLoadMoreResult$p(com.bytedance.trae.conversation.git.GitSelectionViewModel)androidx.lifecycle.MutableLiveData
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->_repoLoadMoreResult Landroidx/lifecycle/MutableLiveData;
    return-object v0
.end method

.method public static final synthetic access$get_repoLoading$p(com.bytedance.trae.conversation.git.GitSelectionViewModel)androidx.lifecycle.MutableLiveData
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->_repoLoading Landroidx/lifecycle/MutableLiveData;
    return-object v0
.end method

.method public static final synthetic access$get_repoLoadingMore$p(com.bytedance.trae.conversation.git.GitSelectionViewModel)androidx.lifecycle.MutableLiveData
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->_repoLoadingMore Landroidx/lifecycle/MutableLiveData;
    return-object v0
.end method

.method public static final synthetic access$get_repoSearchResult$p(com.bytedance.trae.conversation.git.GitSelectionViewModel)androidx.lifecycle.MutableLiveData
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->_repoSearchResult Landroidx/lifecycle/MutableLiveData;
    return-object v0
.end method

.method public static final synthetic access$get_selectedRepo$p(com.bytedance.trae.conversation.git.GitSelectionViewModel)androidx.lifecycle.MutableLiveData
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->_selectedRepo Landroidx/lifecycle/MutableLiveData;
    return-object v0
.end method

.method public static final synthetic access$selectDefaultBranch(com.bytedance.trae.conversation.git.GitSelectionViewModel  java.util.List)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->selectDefaultBranch(Ljava/util/List;)V
    return-void 
.end method

.method public static final synthetic access$setBranchNextPageToken$p(com.bytedance.trae.conversation.git.GitSelectionViewModel  java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->branchNextPageToken Ljava/lang/String;
    return-void 
.end method

.method public static final synthetic access$setCachedBranchItems$p(com.bytedance.trae.conversation.git.GitSelectionViewModel  java.util.List)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->cachedBranchItems Ljava/util/List;
    return-void 
.end method

.method public static final synthetic access$setCachedRepoItems$p(com.bytedance.trae.conversation.git.GitSelectionViewModel  java.util.List)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->cachedRepoItems Ljava/util/List;
    return-void 
.end method

.method public static final synthetic access$setRepoNextPageToken$p(com.bytedance.trae.conversation.git.GitSelectionViewModel  java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->repoNextPageToken Ljava/lang/String;
    return-void 
.end method

.method public static final synthetic access$setSearchNextPageToken$p(com.bytedance.trae.conversation.git.GitSelectionViewModel  java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->searchNextPageToken Ljava/lang/String;
    return-void 
.end method

.method private final selectDefaultBranch(java.util.List)void
    .registers 8
    # ins_size=2
    invoke-interface v7, Ljava/util/List;->isEmpty()Z
    move-result v0
    if-eqz v0, +003h
    return-void 
    const-string v0, "main"
    const-string v1, "develop"
    const-string v2, "master"
    filled-new-array v2, v0, v1, [Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/CollectionsKt;->listOf([Ljava/lang/Object;)Ljava/util/List;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    const/4 v2, 0
    if-eqz v1, +02bh
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/String;
    move-object v3, v7
    check-cast v3, Ljava/lang/Iterable;
    invoke-interface v3, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v3
    invoke-interface v3, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +014h
    invoke-interface v3, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    move-object v5, v4
    check-cast v5, Lcom/bytedance/trae/conversation/git/BranchItem;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/git/BranchItem;->getName()Ljava/lang/String;
    move-result-object v5
    invoke-static v5, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-eqz v5, -015h
    move-object v2, v4
    check-cast v2, Lcom/bytedance/trae/conversation/git/BranchItem;
    if-eqz v2, -02eh
    if-nez v2, +009h
    invoke-static v7, Lkotlin/collections/CollectionsKt;->first(Ljava/util/List;)Ljava/lang/Object;
    move-result-object v7
    move-object v2, v7
    check-cast v2, Lcom/bytedance/trae/conversation/git/BranchItem;
    iget-object v7, v6, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->_selectedBranch Landroidx/lifecycle/MutableLiveData;
    invoke-virtual v7, v2, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    return-void 
.end method

.method public final fetchBranchesFromServer()void
    .registers 9
    # ins_size=1
    iget-object v0, v8, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->_selectedRepo Landroidx/lifecycle/MutableLiveData;
    invoke-virtual v0, Landroidx/lifecycle/MutableLiveData;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/git/GitRepoItem;
    if-eqz v0, +02ah
    invoke-virtual v0, Lcom/bytedance/trae/conversation/git/GitRepoItem;->getRepoUrl()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +003h
    goto +22h
    iget-object v1, v8, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->_branchLoading Landroidx/lifecycle/MutableLiveData;
    const/4 v2, 1
    invoke-static v2, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v2
    invoke-virtual v1, v2, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    move-object v1, v8
    check-cast v1, Landroidx/lifecycle/ViewModel;
    invoke-static v1, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v2
    const/4 v3, 0
    const/4 v4, 0
    new-instance v1, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$fetchBranchesFromServer$1;
    const/4 v5, 0
    invoke-direct v1, v0, v8, v5, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$fetchBranchesFromServer$1;-><init>(Ljava/lang/String; Lcom/bytedance/trae/conversation/git/GitSelectionViewModel; Lkotlin/coroutines/Continuation;)V
    move-object v5, v1
    check-cast v5, Lkotlin/jvm/functions/Function2;
    const/4 v6, 3
    const/4 v7, 0
    invoke-static/range v2 ... v7, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public final fetchRepos()void
    .registers 8
    # ins_size=1
    move-object v0, v7
    check-cast v0, Landroidx/lifecycle/ViewModel;
    invoke-static v0, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v1
    const/4 v2, 0
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$fetchRepos$1;
    const/4 v4, 0
    invoke-direct v0, v7, v4, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$fetchRepos$1;-><init>(Lcom/bytedance/trae/conversation/git/GitSelectionViewModel; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public final fetchReposFromServer()void
    .registers 9
    # ins_size=1
    const/4 v0, 0
    iput-object v0, v8, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->repoNextPageToken Ljava/lang/String;
    move-object v1, v8
    check-cast v1, Landroidx/lifecycle/ViewModel;
    invoke-static v1, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v2
    const/4 v3, 0
    const/4 v4, 0
    new-instance v1, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$fetchReposFromServer$1;
    invoke-direct v1, v8, v0, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$fetchReposFromServer$1;-><init>(Lcom/bytedance/trae/conversation/git/GitSelectionViewModel; Lkotlin/coroutines/Continuation;)V
    move-object v5, v1
    check-cast v5, Lkotlin/jvm/functions/Function2;
    const/4 v6, 3
    const/4 v7, 0
    invoke-static/range v2 ... v7, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public final getBranchListReady()androidx.lifecycle.LiveData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->branchListReady Landroidx/lifecycle/LiveData;
    return-object v0
.end method

.method public final getBranchLoadError()androidx.lifecycle.LiveData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->branchLoadError Landroidx/lifecycle/LiveData;
    return-object v0
.end method

.method public final getBranchLoadMoreResult()androidx.lifecycle.LiveData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->branchLoadMoreResult Landroidx/lifecycle/LiveData;
    return-object v0
.end method

.method public final getBranchLoading()androidx.lifecycle.LiveData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->branchLoading Landroidx/lifecycle/LiveData;
    return-object v0
.end method

.method public final getBranchLoadingMore()androidx.lifecycle.LiveData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->branchLoadingMore Landroidx/lifecycle/LiveData;
    return-object v0
.end method

.method public final getBranchRefreshResult()androidx.lifecycle.LiveData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->branchRefreshResult Landroidx/lifecycle/LiveData;
    return-object v0
.end method

.method public final getBranchSearchResult()androidx.lifecycle.LiveData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->branchSearchResult Landroidx/lifecycle/LiveData;
    return-object v0
.end method

.method public final getCachedBranchItems()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->cachedBranchItems Ljava/util/List;
    return-object v0
.end method

.method public final getCachedRepoItems()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->cachedRepoItems Ljava/util/List;
    return-object v0
.end method

.method public final getGitConnectionState()androidx.lifecycle.LiveData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->gitConnectionState Landroidx/lifecycle/LiveData;
    return-object v0
.end method

.method public final getHasMoreBranches()boolean
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->branchNextPageToken Ljava/lang/String;
    check-cast v0, Ljava/lang/CharSequence;
    const/4 v1, 1
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +003h
    goto +3h
    const/4 v0, 0
    goto +2h
    move v0, v1
    xor-int/2addr v0, v1
    return v0
.end method

.method public final getHasMoreRepos()boolean
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->repoNextPageToken Ljava/lang/String;
    check-cast v0, Ljava/lang/CharSequence;
    const/4 v1, 1
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +003h
    goto +3h
    const/4 v0, 0
    goto +2h
    move v0, v1
    xor-int/2addr v0, v1
    return v0
.end method

.method public final getHasMoreSearchResults()boolean
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->searchNextPageToken Ljava/lang/String;
    check-cast v0, Ljava/lang/CharSequence;
    const/4 v1, 1
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +003h
    goto +3h
    const/4 v0, 0
    goto +2h
    move v0, v1
    xor-int/2addr v0, v1
    return v0
.end method

.method public final getRepoListReady()androidx.lifecycle.LiveData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->repoListReady Landroidx/lifecycle/LiveData;
    return-object v0
.end method

.method public final getRepoLoadError()androidx.lifecycle.LiveData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->repoLoadError Landroidx/lifecycle/LiveData;
    return-object v0
.end method

.method public final getRepoLoadMoreResult()androidx.lifecycle.LiveData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->repoLoadMoreResult Landroidx/lifecycle/LiveData;
    return-object v0
.end method

.method public final getRepoLoading()androidx.lifecycle.LiveData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->repoLoading Landroidx/lifecycle/LiveData;
    return-object v0
.end method

.method public final getRepoLoadingMore()androidx.lifecycle.LiveData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->repoLoadingMore Landroidx/lifecycle/LiveData;
    return-object v0
.end method

.method public final getRepoSearchResult()androidx.lifecycle.LiveData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->repoSearchResult Landroidx/lifecycle/LiveData;
    return-object v0
.end method

.method public final getSelectedBranch()androidx.lifecycle.LiveData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->selectedBranch Landroidx/lifecycle/LiveData;
    return-object v0
.end method

.method public final getSelectedRepo()androidx.lifecycle.LiveData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->selectedRepo Landroidx/lifecycle/LiveData;
    return-object v0
.end method

.method public final loadBranches()void
    .registers 9
    # ins_size=1
    iget-object v0, v8, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->_selectedRepo Landroidx/lifecycle/MutableLiveData;
    invoke-virtual v0, Landroidx/lifecycle/MutableLiveData;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/git/GitRepoItem;
    if-eqz v0, +020h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/git/GitRepoItem;->getRepoUrl()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +003h
    goto +18h
    move-object v1, v8
    check-cast v1, Landroidx/lifecycle/ViewModel;
    invoke-static v1, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v2
    const/4 v3, 0
    const/4 v4, 0
    new-instance v1, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$loadBranches$1;
    const/4 v5, 0
    invoke-direct v1, v8, v0, v5, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$loadBranches$1;-><init>(Lcom/bytedance/trae/conversation/git/GitSelectionViewModel; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    move-object v5, v1
    check-cast v5, Lkotlin/jvm/functions/Function2;
    const/4 v6, 3
    const/4 v7, 0
    invoke-static/range v2 ... v7, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public final loadBranchesAndAutoSelect()void
    .registers 9
    # ins_size=1
    iget-object v0, v8, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->_selectedRepo Landroidx/lifecycle/MutableLiveData;
    invoke-virtual v0, Landroidx/lifecycle/MutableLiveData;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/git/GitRepoItem;
    if-eqz v0, +020h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/git/GitRepoItem;->getRepoUrl()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +003h
    goto +18h
    move-object v1, v8
    check-cast v1, Landroidx/lifecycle/ViewModel;
    invoke-static v1, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v2
    const/4 v3, 0
    const/4 v4, 0
    new-instance v1, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$loadBranchesAndAutoSelect$1;
    const/4 v5, 0
    invoke-direct v1, v8, v0, v5, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$loadBranchesAndAutoSelect$1;-><init>(Lcom/bytedance/trae/conversation/git/GitSelectionViewModel; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    move-object v5, v1
    check-cast v5, Lkotlin/jvm/functions/Function2;
    const/4 v6, 3
    const/4 v7, 0
    invoke-static/range v2 ... v7, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public final loadMoreBranches()void
    .registers 10
    # ins_size=1
    iget-object v0, v9, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->_selectedRepo Landroidx/lifecycle/MutableLiveData;
    invoke-virtual v0, Landroidx/lifecycle/MutableLiveData;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/git/GitRepoItem;
    if-eqz v0, +046h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/git/GitRepoItem;->getRepoUrl()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +003h
    goto +3eh
    iget-object v1, v9, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->branchNextPageToken Ljava/lang/String;
    move-object v2, v1
    check-cast v2, Ljava/lang/CharSequence;
    const/4 v3, 1
    if-eqz v2, +00bh
    invoke-interface v2, Ljava/lang/CharSequence;->length()I
    move-result v2
    if-nez v2, +003h
    goto +3h
    const/4 v2, 0
    goto +2h
    move v2, v3
    if-eqz v2, +003h
    return-void 
    iget-object v2, v9, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->_branchLoadingMore Landroidx/lifecycle/MutableLiveData;
    invoke-virtual v2, Landroidx/lifecycle/MutableLiveData;->getValue()Ljava/lang/Object;
    move-result-object v2
    invoke-static v3, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v3
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +003h
    return-void 
    move-object v2, v9
    check-cast v2, Landroidx/lifecycle/ViewModel;
    invoke-static v2, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v3
    const/4 v4, 0
    const/4 v5, 0
    new-instance v2, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$loadMoreBranches$1;
    const/4 v6, 0
    invoke-direct v2, v9, v0, v1, v6, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$loadMoreBranches$1;-><init>(Lcom/bytedance/trae/conversation/git/GitSelectionViewModel; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    move-object v6, v2
    check-cast v6, Lkotlin/jvm/functions/Function2;
    const/4 v7, 3
    const/4 v8, 0
    invoke-static/range v3 ... v8, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public final loadMoreRepos()void
    .registers 9
    # ins_size=1
    iget-object v0, v8, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->repoNextPageToken Ljava/lang/String;
    move-object v1, v0
    check-cast v1, Ljava/lang/CharSequence;
    const/4 v2, 1
    if-eqz v1, +00bh
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-nez v1, +003h
    goto +3h
    const/4 v1, 0
    goto +2h
    move v1, v2
    if-eqz v1, +003h
    return-void 
    iget-object v1, v8, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->_repoLoadingMore Landroidx/lifecycle/MutableLiveData;
    invoke-virtual v1, Landroidx/lifecycle/MutableLiveData;->getValue()Ljava/lang/Object;
    move-result-object v1
    invoke-static v2, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v2
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +003h
    return-void 
    move-object v1, v8
    check-cast v1, Landroidx/lifecycle/ViewModel;
    invoke-static v1, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v2
    const/4 v3, 0
    const/4 v4, 0
    new-instance v1, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$loadMoreRepos$1;
    const/4 v5, 0
    invoke-direct v1, v8, v0, v5, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$loadMoreRepos$1;-><init>(Lcom/bytedance/trae/conversation/git/GitSelectionViewModel; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    move-object v5, v1
    check-cast v5, Lkotlin/jvm/functions/Function2;
    const/4 v6, 3
    const/4 v7, 0
    invoke-static/range v2 ... v7, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public final loadMoreSearchResults()void
    .registers 13
    # ins_size=1
    iget-object v0, v12, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->_selectedRepo Landroidx/lifecycle/MutableLiveData;
    invoke-virtual v0, Landroidx/lifecycle/MutableLiveData;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/git/GitRepoItem;
    if-eqz v0, +04dh
    invoke-virtual v0, Lcom/bytedance/trae/conversation/git/GitRepoItem;->getRepoUrl()Ljava/lang/String;
    move-result-object v3
    if-nez v3, +003h
    goto +45h
    iget-object v4, v12, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->currentSearchKeyword Ljava/lang/String;
    if-nez v4, +003h
    return-void 
    iget-object v5, v12, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->searchNextPageToken Ljava/lang/String;
    move-object v0, v5
    check-cast v0, Ljava/lang/CharSequence;
    const/4 v1, 1
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +003h
    goto +3h
    const/4 v0, 0
    goto +2h
    move v0, v1
    if-eqz v0, +003h
    return-void 
    iget-object v0, v12, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->_branchLoadingMore Landroidx/lifecycle/MutableLiveData;
    invoke-virtual v0, Landroidx/lifecycle/MutableLiveData;->getValue()Ljava/lang/Object;
    move-result-object v0
    invoke-static v1, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v1
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +003h
    return-void 
    move-object v0, v12
    check-cast v0, Landroidx/lifecycle/ViewModel;
    invoke-static v0, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v0
    const/4 v7, 0
    const/4 v8, 0
    new-instance v9, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$loadMoreSearchResults$1;
    const/4 v6, 0
    move-object v1, v9
    move-object v2, v12
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$loadMoreSearchResults$1;-><init>(Lcom/bytedance/trae/conversation/git/GitSelectionViewModel; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v9, Lkotlin/jvm/functions/Function2;
    const/4 v10, 3
    const/4 v11, 0
    move-object v6, v0
    invoke-static/range v6 ... v11, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public final loadRepos()void
    .registers 8
    # ins_size=1
    iget-object v0, v7, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->_repoLoading Landroidx/lifecycle/MutableLiveData;
    invoke-virtual v0, Landroidx/lifecycle/MutableLiveData;->getValue()Ljava/lang/Object;
    move-result-object v0
    const/4 v1, 1
    invoke-static v1, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v1
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +003h
    return-void 
    iget-object v0, v7, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->_repoLoading Landroidx/lifecycle/MutableLiveData;
    invoke-virtual v0, v1, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    move-object v0, v7
    check-cast v0, Landroidx/lifecycle/ViewModel;
    invoke-static v0, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v1
    const/4 v2, 0
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$loadRepos$1;
    const/4 v4, 0
    invoke-direct v0, v7, v4, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$loadRepos$1;-><init>(Lcom/bytedance/trae/conversation/git/GitSelectionViewModel; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public final searchBranches(java.lang.String)void
    .registers 11
    # ins_size=2
    const-string v0, "keyword"
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v9, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->_selectedRepo Landroidx/lifecycle/MutableLiveData;
    invoke-virtual v0, Landroidx/lifecycle/MutableLiveData;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/git/GitRepoItem;
    if-eqz v0, +024h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/git/GitRepoItem;->getRepoUrl()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +003h
    goto +1ch
    iput-object v10, v9, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->currentSearchKeyword Ljava/lang/String;
    const/4 v1, 0
    iput-object v1, v9, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->searchNextPageToken Ljava/lang/String;
    move-object v2, v9
    check-cast v2, Landroidx/lifecycle/ViewModel;
    invoke-static v2, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v3
    const/4 v4, 0
    const/4 v5, 0
    new-instance v2, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$searchBranches$1;
    invoke-direct v2, v9, v0, v10, v1, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$searchBranches$1;-><init>(Lcom/bytedance/trae/conversation/git/GitSelectionViewModel; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    move-object v6, v2
    check-cast v6, Lkotlin/jvm/functions/Function2;
    const/4 v7, 3
    const/4 v8, 0
    invoke-static/range v3 ... v8, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public final searchRepos(java.lang.String)void
    .registers 9
    # ins_size=2
    const-string v0, "keyword"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v0, v7
    check-cast v0, Landroidx/lifecycle/ViewModel;
    invoke-static v0, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v1
    const/4 v2, 0
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$searchRepos$1;
    const/4 v4, 0
    invoke-direct v0, v8, v7, v4, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel$searchRepos$1;-><init>(Ljava/lang/String; Lcom/bytedance/trae/conversation/git/GitSelectionViewModel; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public final selectBranch(com.bytedance.trae.conversation.git.BranchItem)void
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->_selectedBranch Landroidx/lifecycle/MutableLiveData;
    invoke-virtual v0, v2, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    return-void 
.end method

.method public final selectRepo(com.bytedance.trae.conversation.git.GitRepoItem)void
    .registers 14
    # ins_size=2
    const-string/jumbo v0, repo
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v12, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->selectedRepo Landroidx/lifecycle/LiveData;
    invoke-virtual v0, Landroidx/lifecycle/LiveData;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/git/GitRepoItem;
    const/4 v1, 0
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/git/GitRepoItem;->getRepoUrl()Ljava/lang/String;
    move-result-object v0
    goto +2h
    move-object v0, v1
    invoke-virtual v13, Lcom/bytedance/trae/conversation/git/GitRepoItem;->getRepoUrl()Ljava/lang/String;
    move-result-object v2
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +009h
    iget-object v0, v12, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->_selectedRepo Landroidx/lifecycle/MutableLiveData;
    invoke-virtual v0, v13, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    goto/16 +07eh
    invoke-virtual v13, Lcom/bytedance/trae/conversation/git/GitRepoItem;->getRepoUrl()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z
    move-result v0
    if-eqz v0, +008h
    iget-object v0, v12, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->_selectedRepo Landroidx/lifecycle/MutableLiveData;
    invoke-virtual v0, v1, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    goto +6h
    iget-object v0, v12, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->_selectedRepo Landroidx/lifecycle/MutableLiveData;
    invoke-virtual v0, v13, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    iget-object v0, v12, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->_selectedBranch Landroidx/lifecycle/MutableLiveData;
    invoke-virtual v0, v1, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    iget-object v0, v12, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->_branchRefreshResult Landroidx/lifecycle/MutableLiveData;
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v1
    invoke-virtual v0, v1, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v0
    iput-object v0, v12, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->cachedBranchItems Ljava/util/List;
    iget-object v0, v12, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->cachedRepoItems Ljava/util/List;
    check-cast v0, Ljava/lang/Iterable;
    new-instance v1, Ljava/util/ArrayList;
    const/16 v2, 10
    invoke-static v0, v2, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v2
    invoke-direct v1, v2, Ljava/util/ArrayList;-><init>(I)V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +025h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    move-object v3, v2
    check-cast v3, Lcom/bytedance/trae/conversation/git/GitRepoItem;
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    invoke-virtual v3, Lcom/bytedance/trae/conversation/git/GitRepoItem;->getId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v13, Lcom/bytedance/trae/conversation/git/GitRepoItem;->getId()Ljava/lang/String;
    move-result-object v8
    invoke-static v2, v8, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v8
    const/4 v9, 0
    const/16 v10, 47
    const/4 v11, 0
    invoke-static/range v3 ... v11, Lcom/bytedance/trae/conversation/git/GitRepoItem;->copy$default(Lcom/bytedance/trae/conversation/git/GitRepoItem; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z Z I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/git/GitRepoItem;
    move-result-object v2
    invoke-interface v1, v2, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -28h
    check-cast v1, Ljava/util/List;
    iput-object v1, v12, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->cachedRepoItems Ljava/util/List;
    invoke-virtual v13, Lcom/bytedance/trae/conversation/git/GitRepoItem;->getRepoUrl()Ljava/lang/String;
    move-result-object v13
    check-cast v13, Ljava/lang/CharSequence;
    invoke-static v13, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z
    move-result v13
    if-nez v13, +005h
    invoke-virtual v12, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->loadBranchesAndAutoSelect()V
    return-void 
.end method

.method public final setRepoNextPageToken(java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->repoNextPageToken Ljava/lang/String;
    return-void 
.end method

.method public final updateSelectRepo(com.bytedance.trae.conversation.git.GitRepoItem)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, repo
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->_selectedRepo Landroidx/lifecycle/MutableLiveData;
    invoke-virtual v0, v2, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    return-void 
.end method
