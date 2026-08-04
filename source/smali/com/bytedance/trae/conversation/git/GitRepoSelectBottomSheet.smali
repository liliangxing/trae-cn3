# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;
.super Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;
.source "GitRepoSelectBottomSheet.kt"

.field public static final Companion:Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$Companion;
.field private static final PAGE_SIZE:I
.field public static final TAG:Ljava/lang/String;
.field private adapter:Lcom/bytedance/trae/conversation/git/GitRepoItemAdapter;
.field private btnGoToGithub:Landroid/widget/TextView;
.field private contentView:Landroid/view/View;
.field private emptyStateView:Landroid/view/View;
.field private fullRepoItems:Ljava/util/List;
.field private gitViewModel:Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
.field private isLoadingMore:Z
.field private isSearching:Z
.field private ivSearchClear:Landroid/widget/ImageView;
.field private onAuthFailed:Lkotlin/jvm/functions/Function0;
.field private onRepoSelected:Lkotlin/jvm/functions/Function1;
.field private progressBar:Landroid/widget/ProgressBar;
.field private repoItems:Ljava/util/List;
.field private rvRepositories:Landroidx/recyclerview/widget/RecyclerView;
.field private searchJob:Lkotlinx/coroutines/Job;
.field private searchLoadingBar:Landroid/widget/ProgressBar;
.field private selectedRepo:Lcom/bytedance/trae/conversation/git/GitRepoItem;
.field private titleBar:Lcom/bytedance/trae/common/widget/TraeTitleBar;
.field private tvSearchEmpty:Landroid/widget/TextView;


.method public static synthetic $r8$lambda$Fk0EVA9UiMaLtneed7ze5VsQQ3I(com.bytedance.trae.conversation.git.GitRepoSelectBottomSheet  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->onViewCreated$lambda$2(Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$IDWmMil9pmibR-XdTZDYaZyvdsI(com.bytedance.trae.conversation.git.GitRepoSelectBottomSheet  java.lang.String  java.util.List)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->onViewCreated$lambda$6(Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet; Ljava/lang/String; Ljava/util/List;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$RYacwlKbptVFxR2kHUxXvzEfIPY(com.bytedance.trae.conversation.git.GitRepoSelectBottomSheet  android.widget.ProgressBar  java.lang.Boolean)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->onViewCreated$lambda$7(Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet; Landroid/widget/ProgressBar; Ljava/lang/Boolean;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$Re5p3VZGLbpcuAvIL4t8hts3004(com.bytedance.trae.conversation.git.GitRepoSelectBottomSheet  java.lang.String  java.util.List)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->onViewCreated$lambda$9(Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet; Ljava/lang/String; Ljava/util/List;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$T83PMu2UzArDqaIydrWDwr_kCvI(java.lang.String  com.bytedance.trae.conversation.git.GitRepoSelectBottomSheet  com.bytedance.trae.conversation.git.GitRepoItem)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->onViewCreated$lambda$3(Ljava/lang/String; Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet; Lcom/bytedance/trae/conversation/git/GitRepoItem;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$_FfXevE7ntgJrBvhyvxSNLmiIyk(com.google.android.material.bottomsheet.BottomSheetDialog  com.bytedance.trae.conversation.git.GitRepoSelectBottomSheet  android.content.DialogInterface)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->onCreateDialog$lambda$1(Lcom/google/android/material/bottomsheet/BottomSheetDialog; Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet; Landroid/content/DialogInterface;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$_ZDhz3YK_NzT6Q5GfA6RugRwZ7s(android.widget.EditText  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->onViewCreated$lambda$4(Landroid/widget/EditText; Landroid/view/View;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->Companion Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;-><init>()V
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v0
    iput-object v0, v1, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->repoItems Ljava/util/List;
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v0
    iput-object v0, v1, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->fullRepoItems Ljava/util/List;
    return-void 
.end method

.method public static final synthetic access$getAdapter$p(com.bytedance.trae.conversation.git.GitRepoSelectBottomSheet)com.bytedance.trae.conversation.git.GitRepoItemAdapter
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->adapter Lcom/bytedance/trae/conversation/git/GitRepoItemAdapter;
    return-object v0
.end method

.method public static final synthetic access$getContentView$p(com.bytedance.trae.conversation.git.GitRepoSelectBottomSheet)android.view.View
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->contentView Landroid/view/View;
    return-object v0
.end method

.method public static final synthetic access$getEmptyStateView$p(com.bytedance.trae.conversation.git.GitRepoSelectBottomSheet)android.view.View
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->emptyStateView Landroid/view/View;
    return-object v0
.end method

.method public static final synthetic access$getFullRepoItems$p(com.bytedance.trae.conversation.git.GitRepoSelectBottomSheet)java.util.List
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->fullRepoItems Ljava/util/List;
    return-object v0
.end method

.method public static final synthetic access$getGitViewModel$p(com.bytedance.trae.conversation.git.GitRepoSelectBottomSheet)com.bytedance.trae.conversation.git.GitSelectionViewModel
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->gitViewModel Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    return-object v0
.end method

.method public static final synthetic access$getIvSearchClear$p(com.bytedance.trae.conversation.git.GitRepoSelectBottomSheet)android.widget.ImageView
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->ivSearchClear Landroid/widget/ImageView;
    return-object v0
.end method

.method public static final synthetic access$getProgressBar$p(com.bytedance.trae.conversation.git.GitRepoSelectBottomSheet)android.widget.ProgressBar
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->progressBar Landroid/widget/ProgressBar;
    return-object v0
.end method

.method public static final synthetic access$getRepoItems$p(com.bytedance.trae.conversation.git.GitRepoSelectBottomSheet)java.util.List
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->repoItems Ljava/util/List;
    return-object v0
.end method

.method public static final synthetic access$getRvRepositories$p(com.bytedance.trae.conversation.git.GitRepoSelectBottomSheet)androidx.recyclerview.widget.RecyclerView
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->rvRepositories Landroidx/recyclerview/widget/RecyclerView;
    return-object v0
.end method

.method public static final synthetic access$getSearchJob$p(com.bytedance.trae.conversation.git.GitRepoSelectBottomSheet)kotlinx.coroutines.Job
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->searchJob Lkotlinx/coroutines/Job;
    return-object v0
.end method

.method public static final synthetic access$getSearchLoadingBar$p(com.bytedance.trae.conversation.git.GitRepoSelectBottomSheet)android.widget.ProgressBar
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->searchLoadingBar Landroid/widget/ProgressBar;
    return-object v0
.end method

.method public static final synthetic access$getTvSearchEmpty$p(com.bytedance.trae.conversation.git.GitRepoSelectBottomSheet)android.widget.TextView
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->tvSearchEmpty Landroid/widget/TextView;
    return-object v0
.end method

.method public static final synthetic access$isLoadingMore$p(com.bytedance.trae.conversation.git.GitRepoSelectBottomSheet)boolean
    .registers 1
    # ins_size=1
    iget-boolean v0, v0, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->isLoadingMore Z
    return v0
.end method

.method public static final synthetic access$isSearching$p(com.bytedance.trae.conversation.git.GitRepoSelectBottomSheet)boolean
    .registers 1
    # ins_size=1
    iget-boolean v0, v0, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->isSearching Z
    return v0
.end method

.method public static final synthetic access$setFullRepoItems$p(com.bytedance.trae.conversation.git.GitRepoSelectBottomSheet  java.util.List)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->fullRepoItems Ljava/util/List;
    return-void 
.end method

.method public static final synthetic access$setRepoItems$p(com.bytedance.trae.conversation.git.GitRepoSelectBottomSheet  java.util.List)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->repoItems Ljava/util/List;
    return-void 
.end method

.method public static final synthetic access$setSearchJob$p(com.bytedance.trae.conversation.git.GitRepoSelectBottomSheet  kotlinx.coroutines.Job)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->searchJob Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public static final synthetic access$setSearching$p(com.bytedance.trae.conversation.git.GitRepoSelectBottomSheet  boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->isSearching Z
    return-void 
.end method

.method private final loadRepos()void
    .registers 8
    # ins_size=1
    iget-object v0, v7, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->progressBar Landroid/widget/ProgressBar;
    if-eqz v0, +006h
    const/4 v1, 0
    invoke-virtual v0, v1, Landroid/widget/ProgressBar;->setVisibility(I)V
    iget-object v0, v7, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->contentView Landroid/view/View;
    if-eqz v0, +007h
    const/16 v1, 8
    invoke-virtual v0, v1, Landroid/view/View;->setVisibility(I)V
    move-object v0, v7
    check-cast v0, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    const/4 v2, 0
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$loadRepos$1;
    const/4 v4, 0
    invoke-direct v0, v7, v4, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$loadRepos$1;-><init>(Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private static final onCreateDialog$lambda$1(com.google.android.material.bottomsheet.BottomSheetDialog  com.bytedance.trae.conversation.git.GitRepoSelectBottomSheet  android.content.DialogInterface)void
    .registers 4
    # ins_size=3
    sget v3, Lcom/google/android/material/R$id;->design_bottom_sheet I
    invoke-virtual v1, v3, Lcom/google/android/material/bottomsheet/BottomSheetDialog;->findViewById(I)Landroid/view/View;
    move-result-object v1
    if-eqz v1, +031h
    const v3, 17170445
    invoke-virtual v1, v3, Landroid/view/View;->setBackgroundResource(I)V
    invoke-static v1, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->from(Landroid/view/View;)Lcom/google/android/material/bottomsheet/BottomSheetBehavior;
    move-result-object v3
    invoke-virtual v2, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->getResources()Landroid/content/res/Resources;
    move-result-object v2
    invoke-virtual v2, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v2
    iget v2, v2, Landroid/util/DisplayMetrics;->heightPixels I
    mul-int/lit8 v2, v2, 9
    div-int/lit8 v2, v2, 10
    invoke-virtual v3, v2, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->setPeekHeight(I)V
    const/4 v0, 3
    invoke-virtual v3, v0, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->setState(I)V
    const/4 v0, 1
    invoke-virtual v3, v0, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->setSkipCollapsed(Z)V
    invoke-virtual v3, v0, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->setHideable(Z)V
    invoke-virtual v1, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    move-result-object v3
    iput v2, v3, Landroid/view/ViewGroup$LayoutParams;->height I
    invoke-virtual v1, v3, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    return-void 
.end method

.method private static final onViewCreated$lambda$2(com.bytedance.trae.conversation.git.GitRepoSelectBottomSheet  android.view.View)void
    .registers 4
    # ins_size=2
    sget-object v3, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;->INSTANCE Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;
    invoke-virtual v3, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;->isBytecloudLogin()Z
    move-result v3
    const-string v0, "android.intent.action.VIEW"
    if-eqz v3, +011h
    new-instance v3, Landroid/content/Intent;
    const-string v1, "https://code.byted.org/repository/new"
    invoke-static v1, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v1
    invoke-direct v3, v0, v1, Landroid/content/Intent;-><init>(Ljava/lang/String; Landroid/net/Uri;)V
    invoke-virtual v2, v3, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->startActivity(Landroid/content/Intent;)V
    goto +fh
    new-instance v3, Landroid/content/Intent;
    const-string v1, "https://github.com"
    invoke-static v1, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v1
    invoke-direct v3, v0, v1, Landroid/content/Intent;-><init>(Ljava/lang/String; Landroid/net/Uri;)V
    invoke-virtual v2, v3, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->startActivity(Landroid/content/Intent;)V
    return-void 
    :try_start_0x0
    :try_start_0xa
.end method

.method private static final onViewCreated$lambda$3(java.lang.String  com.bytedance.trae.conversation.git.GitRepoSelectBottomSheet  com.bytedance.trae.conversation.git.GitRepoItem)kotlin.Unit
    .registers 12
    # ins_size=3
    const-string/jumbo v0, repo
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v11, Lcom/bytedance/trae/conversation/git/GitRepoItem;->getId()Ljava/lang/String;
    move-result-object v0
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v9
    xor-int/lit8 v9, v9, 1
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/InputTracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/InputTracker;
    invoke-virtual v0, v9, Lcom/bytedance/trae/conversation/tracker/InputTracker;->trackSelectRepositoryClick(I)V
    if-nez v9, +01ch
    iget-object v9, v10, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->onRepoSelected Lkotlin/jvm/functions/Function1;
    if-eqz v9, +01fh
    new-instance v11, Lcom/bytedance/trae/conversation/git/GitRepoItem;
    const-string v1, ""
    const-string v2, ""
    const-string v3, ""
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/16 v7, 56
    const/4 v8, 0
    move-object v0, v11
    invoke-direct/range v0 ... v8, Lcom/bytedance/trae/conversation/git/GitRepoItem;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v9, v11, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    goto +8h
    iget-object v9, v10, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->onRepoSelected Lkotlin/jvm/functions/Function1;
    if-eqz v9, +005h
    invoke-interface v9, v11, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    invoke-virtual v10, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->dismiss()V
    sget-object v9, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v9
.end method

.method private static final onViewCreated$lambda$4(android.widget.EditText  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-virtual v0, Landroid/widget/EditText;->getText()Landroid/text/Editable;
    move-result-object v0
    invoke-interface v0, Landroid/text/Editable;->clear()V
    return-void 
.end method

.method private static final onViewCreated$lambda$6(com.bytedance.trae.conversation.git.GitRepoSelectBottomSheet  java.lang.String  java.util.List)kotlin.Unit
    .registers 14
    # ins_size=3
    iget-object v0, v11, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->searchLoadingBar Landroid/widget/ProgressBar;
    const/16 v1, 8
    if-eqz v0, +005h
    invoke-virtual v0, v1, Landroid/widget/ProgressBar;->setVisibility(I)V
    invoke-interface v13, Ljava/util/List;->isEmpty()Z
    move-result v0
    const/4 v2, 0
    if-eqz v0, +011h
    iget-object v0, v11, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->rvRepositories Landroidx/recyclerview/widget/RecyclerView;
    if-eqz v0, +005h
    invoke-virtual v0, v1, Landroidx/recyclerview/widget/RecyclerView;->setVisibility(I)V
    iget-object v0, v11, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->tvSearchEmpty Landroid/widget/TextView;
    if-eqz v0, +014h
    invoke-virtual v0, v2, Landroid/widget/TextView;->setVisibility(I)V
    goto +fh
    iget-object v0, v11, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->rvRepositories Landroidx/recyclerview/widget/RecyclerView;
    if-eqz v0, +005h
    invoke-virtual v0, v2, Landroidx/recyclerview/widget/RecyclerView;->setVisibility(I)V
    iget-object v0, v11, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->tvSearchEmpty Landroid/widget/TextView;
    if-eqz v0, +005h
    invoke-virtual v0, v1, Landroid/widget/TextView;->setVisibility(I)V
    invoke-static v13, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    check-cast v13, Ljava/lang/Iterable;
    new-instance v0, Ljava/util/ArrayList;
    const/16 v1, 10
    invoke-static v13, v1, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v1
    invoke-direct v0, v1, Ljava/util/ArrayList;-><init>(I)V
    check-cast v0, Ljava/util/Collection;
    invoke-interface v13, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v13
    invoke-interface v13, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +021h
    invoke-interface v13, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Lcom/bytedance/trae/conversation/git/GitRepoItem;
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    invoke-virtual v2, Lcom/bytedance/trae/conversation/git/GitRepoItem;->getId()Ljava/lang/String;
    move-result-object v1
    invoke-static v1, v12, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v7
    const/4 v8, 0
    const/16 v9, 47
    const/4 v10, 0
    invoke-static/range v2 ... v10, Lcom/bytedance/trae/conversation/git/GitRepoItem;->copy$default(Lcom/bytedance/trae/conversation/git/GitRepoItem; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z Z I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/git/GitRepoItem;
    move-result-object v1
    invoke-interface v0, v1, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -24h
    check-cast v0, Ljava/util/List;
    iput-object v0, v11, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->repoItems Ljava/util/List;
    iget-object v12, v11, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->adapter Lcom/bytedance/trae/conversation/git/GitRepoItemAdapter;
    if-nez v12, +008h
    const-string v12, "adapter"
    invoke-static v12, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v12, 0
    iget-object v11, v11, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->repoItems Ljava/util/List;
    invoke-virtual v12, v11, Lcom/bytedance/trae/conversation/git/GitRepoItemAdapter;->submitList(Ljava/util/List;)V
    sget-object v11, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v11
.end method

.method private static final onViewCreated$lambda$7(com.bytedance.trae.conversation.git.GitRepoSelectBottomSheet  android.widget.ProgressBar  java.lang.Boolean)kotlin.Unit
    .registers 4
    # ins_size=3
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-virtual v3, Ljava/lang/Boolean;->booleanValue()Z
    move-result v0
    iput-boolean v0, v1, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->isLoadingMore Z
    invoke-virtual v3, Ljava/lang/Boolean;->booleanValue()Z
    move-result v1
    if-eqz v1, +004h
    const/4 v1, 0
    goto +3h
    const/16 v1, 8
    invoke-virtual v2, v1, Landroid/widget/ProgressBar;->setVisibility(I)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final onViewCreated$lambda$9(com.bytedance.trae.conversation.git.GitRepoSelectBottomSheet  java.lang.String  java.util.List)kotlin.Unit
    .registers 14
    # ins_size=3
    invoke-static v13, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    move-object v0, v13
    check-cast v0, Ljava/util/Collection;
    invoke-interface v0, Ljava/util/Collection;->isEmpty()Z
    move-result v0
    xor-int/lit8 v0, v0, 1
    if-eqz v0, +05dh
    iget-boolean v0, v11, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->isSearching Z
    if-nez v0, +059h
    check-cast v13, Ljava/lang/Iterable;
    new-instance v0, Ljava/util/ArrayList;
    const/16 v1, 10
    invoke-static v13, v1, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v1
    invoke-direct v0, v1, Ljava/util/ArrayList;-><init>(I)V
    check-cast v0, Ljava/util/Collection;
    invoke-interface v13, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v13
    invoke-interface v13, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +021h
    invoke-interface v13, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Lcom/bytedance/trae/conversation/git/GitRepoItem;
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    invoke-virtual v2, Lcom/bytedance/trae/conversation/git/GitRepoItem;->getId()Ljava/lang/String;
    move-result-object v1
    invoke-static v1, v12, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v7
    const/4 v8, 0
    const/16 v9, 47
    const/4 v10, 0
    invoke-static/range v2 ... v10, Lcom/bytedance/trae/conversation/git/GitRepoItem;->copy$default(Lcom/bytedance/trae/conversation/git/GitRepoItem; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z Z I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/git/GitRepoItem;
    move-result-object v1
    invoke-interface v0, v1, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -24h
    check-cast v0, Ljava/util/List;
    iget-object v12, v11, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->repoItems Ljava/util/List;
    check-cast v12, Ljava/util/Collection;
    check-cast v0, Ljava/lang/Iterable;
    invoke-static v12, v0, Lkotlin/collections/CollectionsKt;->plus(Ljava/util/Collection; Ljava/lang/Iterable;)Ljava/util/List;
    move-result-object v12
    iput-object v12, v11, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->repoItems Ljava/util/List;
    iput-object v12, v11, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->fullRepoItems Ljava/util/List;
    iget-object v12, v11, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->adapter Lcom/bytedance/trae/conversation/git/GitRepoItemAdapter;
    if-nez v12, +008h
    const-string v12, "adapter"
    invoke-static v12, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v12, 0
    iget-object v11, v11, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->repoItems Ljava/util/List;
    invoke-virtual v12, v11, Lcom/bytedance/trae/conversation/git/GitRepoItemAdapter;->submitList(Ljava/util/List;)V
    sget-object v11, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v11
.end method

.method public final getOnAuthFailed()kotlin.jvm.functions.Function0
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->onAuthFailed Lkotlin/jvm/functions/Function0;
    return-object v0
.end method

.method public final getOnRepoSelected()kotlin.jvm.functions.Function1
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->onRepoSelected Lkotlin/jvm/functions/Function1;
    return-object v0
.end method

.method public final getSelectedRepo()com.bytedance.trae.conversation.git.GitRepoItem
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->selectedRepo Lcom/bytedance/trae/conversation/git/GitRepoItem;
    return-object v0
.end method

.method public onCreateDialog(android.os.Bundle)android.app.Dialog
    .registers 3
    # ins_size=2
    invoke-super v1, v2, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;->onCreateDialog(Landroid/os/Bundle;)Landroid/app/Dialog;
    move-result-object v2
    const-string v0, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v2, Lcom/google/android/material/bottomsheet/BottomSheetDialog;
    new-instance v0, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$$ExternalSyntheticLambda0;
    invoke-direct v0, v2, v1, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$$ExternalSyntheticLambda0;-><init>(Lcom/google/android/material/bottomsheet/BottomSheetDialog; Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;)V
    invoke-virtual v2, v0, Lcom/google/android/material/bottomsheet/BottomSheetDialog;->setOnShowListener(Landroid/content/DialogInterface$OnShowListener;)V
    check-cast v2, Landroid/app/Dialog;
    return-object v2
.end method

.method public onCreateView(android.view.LayoutInflater  android.view.ViewGroup  android.os.Bundle)android.view.View
    .registers 5
    # ins_size=4
    const-string v4, "inflater"
    invoke-static v2, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget v4, Lcom/bytedance/trae/conversation/R$layout;->trae_dialog_git_repo_select I
    const/4 v0, 0
    invoke-virtual v2, v4, v3, v0, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    return-object v2
.end method

.method public onViewCreated(android.view.View  android.os.Bundle)void
    .registers 10
    # ins_size=3
    const-string/jumbo v0, view
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-super v7, v8, v9, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;->onViewCreated(Landroid/view/View; Landroid/os/Bundle;)V
    new-instance v9, Landroidx/lifecycle/ViewModelProvider;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->requireActivity()Landroidx/fragment/app/FragmentActivity;
    move-result-object v0
    const-string/jumbo v1, requireActivity(...)
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroidx/lifecycle/ViewModelStoreOwner;
    invoke-direct v9, v0, Landroidx/lifecycle/ViewModelProvider;-><init>(Landroidx/lifecycle/ViewModelStoreOwner;)V
    const-class v0, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    invoke-virtual v9, v0, Landroidx/lifecycle/ViewModelProvider;->get(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;
    move-result-object v9
    check-cast v9, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    iput-object v9, v7, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->gitViewModel Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    sget v9, Lcom/bytedance/trae/conversation/R$id;->rv_repositories I
    invoke-virtual v8, v9, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v9
    check-cast v9, Landroidx/recyclerview/widget/RecyclerView;
    iput-object v9, v7, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->rvRepositories Landroidx/recyclerview/widget/RecyclerView;
    sget v9, Lcom/bytedance/trae/conversation/R$id;->et_search I
    invoke-virtual v8, v9, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v9
    check-cast v9, Landroid/widget/EditText;
    sget v0, Lcom/bytedance/trae/conversation/R$id;->pb_loading_more I
    invoke-virtual v8, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    check-cast v0, Landroid/widget/ProgressBar;
    sget v1, Lcom/bytedance/trae/conversation/R$id;->title_bar I
    invoke-virtual v8, v1, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/common/widget/TraeTitleBar;
    iput-object v1, v7, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    if-eqz v1, +006h
    const/4 v2, 0
    invoke-virtual v1, v2, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setRightActionsVisible(Z)V
    sget v1, Lcom/bytedance/trae/conversation/R$id;->progress_bar I
    invoke-virtual v8, v1, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v1
    check-cast v1, Landroid/widget/ProgressBar;
    iput-object v1, v7, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->progressBar Landroid/widget/ProgressBar;
    sget v1, Lcom/bytedance/trae/conversation/R$id;->layout_container I
    invoke-virtual v8, v1, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v1
    iput-object v1, v7, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->contentView Landroid/view/View;
    sget v1, Lcom/bytedance/trae/conversation/R$id;->pb_search_loading I
    invoke-virtual v8, v1, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v1
    check-cast v1, Landroid/widget/ProgressBar;
    iput-object v1, v7, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->searchLoadingBar Landroid/widget/ProgressBar;
    sget v1, Lcom/bytedance/trae/conversation/R$id;->iv_search_clear I
    invoke-virtual v8, v1, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v1
    check-cast v1, Landroid/widget/ImageView;
    iput-object v1, v7, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->ivSearchClear Landroid/widget/ImageView;
    sget v1, Lcom/bytedance/trae/conversation/R$id;->tv_search_empty I
    invoke-virtual v8, v1, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v1
    check-cast v1, Landroid/widget/TextView;
    iput-object v1, v7, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->tvSearchEmpty Landroid/widget/TextView;
    sget v1, Lcom/bytedance/trae/conversation/R$id;->layout_empty_state I
    invoke-virtual v8, v1, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v1
    iput-object v1, v7, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->emptyStateView Landroid/view/View;
    sget v1, Lcom/bytedance/trae/conversation/R$id;->btn_go_to_github I
    invoke-virtual v8, v1, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v1
    check-cast v1, Landroid/widget/TextView;
    iput-object v1, v7, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->btnGoToGithub Landroid/widget/TextView;
    sget v1, Lcom/bytedance/trae/conversation/R$id;->tv_empty_hint I
    invoke-virtual v8, v1, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v8
    check-cast v8, Landroid/widget/TextView;
    sget-object v1, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;->INSTANCE Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;
    invoke-virtual v1, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;->isBytecloudLogin()Z
    move-result v1
    if-eqz v1, +00ah
    if-eqz v8, +00fh
    sget v1, Lcom/bytedance/trae/multilanguage/R$string;->trae_bits_code_branch_empty_hint I
    invoke-virtual v8, v1, Landroid/widget/TextView;->setText(I)V
    goto +8h
    if-eqz v8, +007h
    sget v1, Lcom/bytedance/trae/multilanguage/R$string;->trae_git_repo_empty_hint I
    invoke-virtual v8, v1, Landroid/widget/TextView;->setText(I)V
    sget-object v8, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;->INSTANCE Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;
    invoke-virtual v8, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;->isBytecloudLogin()Z
    move-result v8
    if-eqz v8, +00ch
    iget-object v8, v7, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->btnGoToGithub Landroid/widget/TextView;
    if-eqz v8, +011h
    sget v1, Lcom/bytedance/trae/multilanguage/R$string;->trae_git_go_to_bits_code I
    invoke-virtual v8, v1, Landroid/widget/TextView;->setText(I)V
    goto +ah
    iget-object v8, v7, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->btnGoToGithub Landroid/widget/TextView;
    if-eqz v8, +007h
    sget v1, Lcom/bytedance/trae/multilanguage/R$string;->trae_git_go_to_github I
    invoke-virtual v8, v1, Landroid/widget/TextView;->setText(I)V
    iget-object v8, v7, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->btnGoToGithub Landroid/widget/TextView;
    if-eqz v8, +00ah
    new-instance v1, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$$ExternalSyntheticLambda1;
    invoke-direct v1, v7, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;)V
    invoke-virtual v8, v1, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    iget-object v8, v7, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->selectedRepo Lcom/bytedance/trae/conversation/git/GitRepoItem;
    const/4 v1, 0
    if-eqz v8, +007h
    invoke-virtual v8, Lcom/bytedance/trae/conversation/git/GitRepoItem;->getId()Ljava/lang/String;
    move-result-object v8
    goto +2h
    move-object v8, v1
    new-instance v2, Landroidx/recyclerview/widget/LinearLayoutManager;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->getContext()Landroid/content/Context;
    move-result-object v3
    invoke-direct v2, v3, Landroidx/recyclerview/widget/LinearLayoutManager;-><init>(Landroid/content/Context;)V
    iget-object v3, v7, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->rvRepositories Landroidx/recyclerview/widget/RecyclerView;
    if-eqz v3, +008h
    move-object v4, v2
    check-cast v4, Landroidx/recyclerview/widget/RecyclerView$LayoutManager;
    invoke-virtual v3, v4, Landroidx/recyclerview/widget/RecyclerView;->setLayoutManager(Landroidx/recyclerview/widget/RecyclerView$LayoutManager;)V
    new-instance v3, Lcom/bytedance/trae/conversation/git/GitRepoItemAdapter;
    new-instance v4, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$$ExternalSyntheticLambda2;
    invoke-direct v4, v8, v7, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$$ExternalSyntheticLambda2;-><init>(Ljava/lang/String; Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;)V
    invoke-direct v3, v4, Lcom/bytedance/trae/conversation/git/GitRepoItemAdapter;-><init>(Lkotlin/jvm/functions/Function1;)V
    iput-object v3, v7, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->adapter Lcom/bytedance/trae/conversation/git/GitRepoItemAdapter;
    iget-object v4, v7, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->rvRepositories Landroidx/recyclerview/widget/RecyclerView;
    if-eqz v4, +007h
    check-cast v3, Landroidx/recyclerview/widget/RecyclerView$Adapter;
    invoke-virtual v4, v3, Landroidx/recyclerview/widget/RecyclerView;->setAdapter(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V
    iget-object v3, v7, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->ivSearchClear Landroid/widget/ImageView;
    if-eqz v3, +00ah
    new-instance v4, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$$ExternalSyntheticLambda3;
    invoke-direct v4, v9, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$$ExternalSyntheticLambda3;-><init>(Landroid/widget/EditText;)V
    invoke-virtual v3, v4, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    new-instance v3, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$onViewCreated$4;
    invoke-direct v3, v7, v8, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$onViewCreated$4;-><init>(Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet; Ljava/lang/String;)V
    check-cast v3, Landroid/text/TextWatcher;
    invoke-virtual v9, v3, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V
    iget-object v9, v7, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->gitViewModel Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    const-string v3, "gitViewModel"
    if-nez v9, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v9, v1
    invoke-virtual v9, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->getRepoSearchResult()Landroidx/lifecycle/LiveData;
    move-result-object v9
    invoke-virtual v7, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->getViewLifecycleOwner()Landroidx/lifecycle/LifecycleOwner;
    move-result-object v4
    new-instance v5, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$$ExternalSyntheticLambda4;
    invoke-direct v5, v7, v8, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$$ExternalSyntheticLambda4;-><init>(Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet; Ljava/lang/String;)V
    new-instance v6, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$sam$androidx_lifecycle_Observer$0;
    invoke-direct v6, v5, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$sam$androidx_lifecycle_Observer$0;-><init>(Lkotlin/jvm/functions/Function1;)V
    check-cast v6, Landroidx/lifecycle/Observer;
    invoke-virtual v9, v4, v6, Landroidx/lifecycle/LiveData;->observe(Landroidx/lifecycle/LifecycleOwner; Landroidx/lifecycle/Observer;)V
    iget-object v9, v7, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->rvRepositories Landroidx/recyclerview/widget/RecyclerView;
    if-eqz v9, +00ch
    new-instance v4, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$onViewCreated$6;
    invoke-direct v4, v2, v7, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$onViewCreated$6;-><init>(Landroidx/recyclerview/widget/LinearLayoutManager; Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;)V
    check-cast v4, Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;
    invoke-virtual v9, v4, Landroidx/recyclerview/widget/RecyclerView;->addOnScrollListener(Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;)V
    iget-object v9, v7, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->gitViewModel Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    if-nez v9, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v9, v1
    invoke-virtual v9, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->getRepoLoadingMore()Landroidx/lifecycle/LiveData;
    move-result-object v9
    invoke-virtual v7, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->getViewLifecycleOwner()Landroidx/lifecycle/LifecycleOwner;
    move-result-object v2
    new-instance v4, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$$ExternalSyntheticLambda5;
    invoke-direct v4, v7, v0, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$$ExternalSyntheticLambda5;-><init>(Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet; Landroid/widget/ProgressBar;)V
    new-instance v0, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$sam$androidx_lifecycle_Observer$0;
    invoke-direct v0, v4, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$sam$androidx_lifecycle_Observer$0;-><init>(Lkotlin/jvm/functions/Function1;)V
    check-cast v0, Landroidx/lifecycle/Observer;
    invoke-virtual v9, v2, v0, Landroidx/lifecycle/LiveData;->observe(Landroidx/lifecycle/LifecycleOwner; Landroidx/lifecycle/Observer;)V
    iget-object v9, v7, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->gitViewModel Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;
    if-nez v9, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v9
    invoke-virtual v1, Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;->getRepoLoadMoreResult()Landroidx/lifecycle/LiveData;
    move-result-object v9
    invoke-virtual v7, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->getViewLifecycleOwner()Landroidx/lifecycle/LifecycleOwner;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$$ExternalSyntheticLambda6;
    invoke-direct v1, v7, v8, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$$ExternalSyntheticLambda6;-><init>(Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet; Ljava/lang/String;)V
    new-instance v8, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$sam$androidx_lifecycle_Observer$0;
    invoke-direct v8, v1, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$sam$androidx_lifecycle_Observer$0;-><init>(Lkotlin/jvm/functions/Function1;)V
    check-cast v8, Landroidx/lifecycle/Observer;
    invoke-virtual v9, v0, v8, Landroidx/lifecycle/LiveData;->observe(Landroidx/lifecycle/LifecycleOwner; Landroidx/lifecycle/Observer;)V
    invoke-direct v7, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->loadRepos()V
    return-void 
.end method

.method public final setOnAuthFailed(kotlin.jvm.functions.Function0)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->onAuthFailed Lkotlin/jvm/functions/Function0;
    return-void 
.end method

.method public final setOnRepoSelected(kotlin.jvm.functions.Function1)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->onRepoSelected Lkotlin/jvm/functions/Function1;
    return-void 
.end method

.method public final setSelectedRepo(com.bytedance.trae.conversation.git.GitRepoItem)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->selectedRepo Lcom/bytedance/trae/conversation/git/GitRepoItem;
    return-void 
.end method
