# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;
.super Landroidx/fragment/app/Fragment;
.source "SiteMessageListFragment.kt"

.field public static final $stable:I
.field public static final Companion:Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment$Companion;
.field private adapter:Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;
.field private currentPage:I
.field private dimOverlay:Landroid/view/View;
.field private emptyState:Landroid/view/View;
.field private floatingCard:Landroid/widget/ImageView;
.field private hasMore:Z
.field private isLoading:Z
.field private recyclerView:Landroidx/recyclerview/widget/RecyclerView;
.field private final scrollListener:Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment$scrollListener$1;
.field private swipeRefresh:Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;
.field private titleBar:Lcom/bytedance/trae/common/widget/TraeTitleBar;
.field private tvEmpty:Landroid/widget/TextView;


.method public static synthetic $r8$lambda$-a8_kC1Mss4APWcN8JCmucZK2nc(android.widget.PopupWindow  com.bytedance.trae.home.solo.sitemessage.SiteMessageListFragment  int  com.bytedance.trae.home.solo.sitemessage.SiteMessageItem  android.view.View)void
    .registers 5
    # ins_size=5
    invoke-static v0, v1, v2, v3, v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->showDeletePopup$lambda$18(Landroid/widget/PopupWindow; Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment; I Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$AsVzhnI6qkuFCg0GGHJMvNeINq8(com.bytedance.trae.home.solo.sitemessage.SiteMessageListFragment  com.bytedance.trae.home.solo.sitemessage.SiteMessageItem  int)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->onViewCreated$lambda$3(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment; Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem; I)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$QOWOIJJbCh847e2MbWdaUTBeHBw(com.bytedance.trae.home.solo.sitemessage.SiteMessageItem  int)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->onViewCreated$lambda$5(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem; I)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$RFMwetysUkDpk-7Ofms-AB_EQyY(com.bytedance.trae.home.solo.sitemessage.SiteMessageListFragment)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->onViewCreated$lambda$7(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$TbWogbpzkPAVfXJuCPYdXVtSGlQ(com.bytedance.trae.home.solo.sitemessage.SiteMessageListFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->onViewCreated$lambda$0(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$d5W3bg58Y4EXwsuXX8yijV-7FMw(com.bytedance.trae.home.solo.sitemessage.SiteMessageListFragment  com.bytedance.trae.home.solo.sitemessage.SiteMessageItem)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->deleteItem$lambda$20(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment; Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$d6uHxnzc3gOpW6JiztQW6mWfSGY(com.bytedance.trae.home.solo.sitemessage.SiteMessageListFragment  com.bytedance.trae.home.solo.sitemessage.SiteMessageItem)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->onViewCreated$lambda$2(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment; Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$hdQ1sVPYVpoK6KMNBfAwbgo81r8(com.bytedance.trae.home.solo.sitemessage.SiteMessageListFragment  android.view.View  com.bytedance.trae.home.solo.sitemessage.SiteMessageItem  int)kotlin.Unit
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->onViewCreated$lambda$4(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment; Landroid/view/View; Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem; I)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$mEfQb6EHwzjoVzh8YqOXMZTHtsA(com.bytedance.trae.home.solo.sitemessage.SiteMessageListFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->onViewCreated$lambda$1(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$qPdIVMIQBgpid1t7F-yDnvpAEoY(com.bytedance.trae.home.solo.sitemessage.SiteMessageListFragment  android.graphics.Bitmap)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->showDeletePopup$lambda$17(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment; Landroid/graphics/Bitmap;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->Companion Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment$Companion;
    const/16 v0, 8
    sput v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->$stable I
    return-void 
.end method

.method public constructor <init>()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Landroidx/fragment/app/Fragment;-><init>()V
    const/4 v0, 1
    iput v0, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->currentPage I
    new-instance v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment$scrollListener$1;
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment$scrollListener$1;-><init>(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;)V
    iput-object v0, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->scrollListener Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment$scrollListener$1;
    return-void 
.end method

.method public static final synthetic access$getAdapter$p(com.bytedance.trae.home.solo.sitemessage.SiteMessageListFragment)com.bytedance.trae.home.solo.sitemessage.SiteMessageAdapter
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->adapter Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;
    return-object v0
.end method

.method public static final synthetic access$getReadTracker(com.bytedance.trae.home.solo.sitemessage.SiteMessageListFragment)com.bytedance.trae.home.solo.sitemessage.SiteMessageReadTracker
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->getReadTracker()Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$getSwipeRefresh$p(com.bytedance.trae.home.solo.sitemessage.SiteMessageListFragment)androidx.swiperefreshlayout.widget.SwipeRefreshLayout
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->swipeRefresh Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;
    return-object v0
.end method

.method public static final synthetic access$loadMore(com.bytedance.trae.home.solo.sitemessage.SiteMessageListFragment)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->loadMore()V
    return-void 
.end method

.method public static final synthetic access$markAllAsRead(com.bytedance.trae.home.solo.sitemessage.SiteMessageListFragment  java.util.List)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->markAllAsRead(Ljava/util/List;)V
    return-void 
.end method

.method public static final synthetic access$setCurrentPage$p(com.bytedance.trae.home.solo.sitemessage.SiteMessageListFragment  int)void
    .registers 2
    # ins_size=2
    iput v1, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->currentPage I
    return-void 
.end method

.method public static final synthetic access$setHasMore$p(com.bytedance.trae.home.solo.sitemessage.SiteMessageListFragment  boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->hasMore Z
    return-void 
.end method

.method public static final synthetic access$setLoading$p(com.bytedance.trae.home.solo.sitemessage.SiteMessageListFragment  boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->isLoading Z
    return-void 
.end method

.method public static final synthetic access$updateEmptyState(com.bytedance.trae.home.solo.sitemessage.SiteMessageListFragment)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->updateEmptyState()V
    return-void 
.end method

.method private final deleteItem(int  com.bytedance.trae.home.solo.sitemessage.SiteMessageItem)void
    .registers 13
    # ins_size=3
    iget-object v0, v10, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->adapter Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;
    const-string v1, "adapter"
    const/4 v2, 0
    if-nez v0, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;->closeOpenItem()V
    iget-object v0, v10, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->adapter Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;
    if-nez v0, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;->getItemCount()I
    move-result v0
    const/4 v3, 0
    invoke-static v3, v0, Lkotlin/ranges/RangesKt;->until(I I)Lkotlin/ranges/IntRange;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +02bh
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    move-object v5, v4
    check-cast v5, Ljava/lang/Number;
    invoke-virtual v5, Ljava/lang/Number;->intValue()I
    move-result v5
    iget-object v6, v10, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->adapter Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;
    if-nez v6, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v6, v2
    invoke-virtual v6, v5, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;->getItem(I)Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;
    move-result-object v5
    if-eqz v5, +00eh
    invoke-virtual v5, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;->getId()I
    move-result v5
    invoke-virtual v12, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;->getId()I
    move-result v6
    if-ne v5, v6, +004h
    const/4 v5, 1
    goto +2h
    move v5, v3
    if-eqz v5, -02ch
    goto +2h
    move-object v4, v2
    check-cast v4, Ljava/lang/Integer;
    if-eqz v4, +006h
    invoke-virtual v4, Ljava/lang/Integer;->intValue()I
    move-result v11
    sget-object v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageTracker;->INSTANCE Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageTracker;
    invoke-virtual v12, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;->getId()I
    move-result v3
    invoke-virtual v0, v3, v11, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageTracker;->trackItemDelete(I I)V
    iget-object v0, v10, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->adapter Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;
    if-nez v0, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v2, v0
    invoke-virtual v2, v11, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;->removeAt(I)Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;
    invoke-direct v10, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->updateEmptyState()V
    sget-object v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository;->INSTANCE Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository;
    invoke-virtual v12, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;->getId()I
    move-result v11
    invoke-static v11, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v11
    invoke-static v11, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v4
    const-string v5, "delete"
    const/4 v6, 0
    new-instance v7, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment$$ExternalSyntheticLambda2;
    invoke-direct v7, v10, v12, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment; Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;)V
    const/4 v8, 4
    const/4 v9, 0
    invoke-static/range v3 ... v9, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository;->updateStatus$default(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository; Ljava/util/List; Ljava/lang/String; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0; I Ljava/lang/Object;)V
    return-void 
.end method

.method private static final deleteItem$lambda$20(com.bytedance.trae.home.solo.sitemessage.SiteMessageListFragment  com.bytedance.trae.home.solo.sitemessage.SiteMessageItem)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->getReadTracker()Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;
    move-result-object v0
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;->getId()I
    move-result v1
    invoke-virtual v0, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;->cachePendingDeleteEvent(I)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private final fetchFirstPage()void
    .registers 8
    # ins_size=1
    const/4 v0, 1
    iput-boolean v0, v7, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->isLoading Z
    iput v0, v7, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->currentPage I
    invoke-virtual v7, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->getViewLifecycleOwner()Landroidx/lifecycle/LifecycleOwner;
    move-result-object v0
    const-string v1, "getViewLifecycleOwner(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    const/4 v2, 0
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment$fetchFirstPage$1;
    const/4 v4, 0
    invoke-direct v0, v7, v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment$fetchFirstPage$1;-><init>(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final getReadTracker()com.bytedance.trae.home.solo.sitemessage.SiteMessageReadTracker
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository;->INSTANCE Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository;
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository;->getReadTracker()Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;
    move-result-object v0
    return-object v0
.end method

.method private final handleCtaTap(com.bytedance.trae.home.solo.sitemessage.SiteMessageItem)void
    .registers 6
    # ins_size=2
    invoke-virtual v5, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;->getOpenInBrowser()Z
    move-result v0
    if-eqz v0, +006h
    invoke-direct v4, v5, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->openInExternalBrowser(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;)V
    return-void 
    invoke-virtual v5, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;->getCommandId()Ljava/lang/String;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Ljava/lang/CharSequence;
    const/4 v2, 0
    const/4 v3, 1
    if-eqz v1, +00bh
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    if-eqz v1, +003h
    goto +3h
    move v1, v2
    goto +2h
    move v1, v3
    if-nez v1, +006h
    invoke-direct v4, v5, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->routeByCommand(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem; Ljava/lang/String;)V
    return-void 
    invoke-virtual v5, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;->getActionUrl()Ljava/lang/String;
    move-result-object v0
    if-eqz v0, +00dh
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    check-cast v0, Ljava/lang/CharSequence;
    if-eqz v0, +008h
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    if-eqz v0, +003h
    move v2, v3
    if-nez v2, +005h
    invoke-direct v4, v5, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->openInExternalBrowser(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;)V
    return-void 
.end method

.method private final loadMore()void
    .registers 9
    # ins_size=1
    iget-boolean v0, v8, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->hasMore Z
    if-eqz v0, +02dh
    iget-boolean v0, v8, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->isLoading Z
    if-eqz v0, +003h
    goto +27h
    const/4 v0, 1
    iput-boolean v0, v8, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->isLoading Z
    iget v1, v8, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->currentPage I
    add-int/2addr v1, v0
    invoke-virtual v8, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->getViewLifecycleOwner()Landroidx/lifecycle/LifecycleOwner;
    move-result-object v0
    const-string v2, "getViewLifecycleOwner(...)"
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v0
    move-object v2, v0
    check-cast v2, Lkotlinx/coroutines/CoroutineScope;
    const/4 v3, 0
    const/4 v4, 0
    new-instance v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment$loadMore$1;
    const/4 v5, 0
    invoke-direct v0, v1, v8, v5, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment$loadMore$1;-><init>(I Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment; Lkotlin/coroutines/Continuation;)V
    move-object v5, v0
    check-cast v5, Lkotlin/jvm/functions/Function2;
    const/4 v6, 3
    const/4 v7, 0
    invoke-static/range v2 ... v7, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final markAllAsRead(java.util.List)void
    .registers 19
    # ins_size=2
    move-object/from16 v0, v18
    check-cast v0, Ljava/lang/Iterable;
    new-instance v1, Ljava/util/ArrayList;
    invoke-direct v1, Ljava/util/ArrayList;-><init>()V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    const/4 v4, 0
    if-eqz v3, +01bh
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    move-object v5, v3
    check-cast v5, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;
    invoke-virtual v5, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;->isRead()Ljava/lang/Boolean;
    move-result-object v5
    invoke-static v4, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v4
    invoke-static v5, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, -01ah
    invoke-interface v1, v3, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -1fh
    check-cast v1, Ljava/util/List;
    check-cast v1, Ljava/lang/Iterable;
    new-instance v2, Ljava/util/ArrayList;
    const/16 v3, 10
    invoke-static v1, v3, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v5
    invoke-direct v2, v5, Ljava/util/ArrayList;-><init>(I)V
    check-cast v2, Ljava/util/Collection;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v5
    if-eqz v5, +014h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;
    invoke-virtual v5, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;->getId()I
    move-result v5
    invoke-static v5, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v5
    invoke-interface v2, v5, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -17h
    move-object v7, v2
    check-cast v7, Ljava/util/List;
    invoke-interface v7, Ljava/util/List;->isEmpty()Z
    move-result v1
    if-eqz v1, +003h
    return-void 
    new-instance v1, Ljava/util/ArrayList;
    invoke-static v0, v3, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v2
    invoke-direct v1, v2, Ljava/util/ArrayList;-><init>(I)V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +02dh
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    move-object v8, v2
    check-cast v8, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;
    invoke-virtual v8, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;->isRead()Ljava/lang/Boolean;
    move-result-object v2
    invoke-static v4, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v3
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +014h
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v2, 1
    invoke-static v2, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v13
    const/4 v14, 0
    const/16 v15, 47
    const/16 v16, 0
    invoke-static/range v8 ... v16, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;->copy$default(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem; I Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean; Lcom/bytedance/trae/home/solo/sitemessage/NotificationData; I Ljava/lang/Object;)Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;
    move-result-object v8
    invoke-interface v1, v8, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -30h
    check-cast v1, Ljava/util/List;
    move-object/from16 v0, v17
    iget-object v2, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->adapter Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;
    if-nez v2, +008h
    const-string v2, "adapter"
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v2, 0
    invoke-virtual v2, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;->setData(Ljava/util/List;)V
    sget-object v6, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository;->INSTANCE Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository;
    const-string v8, "read"
    const/4 v9, 0
    const/4 v10, 0
    const/16 v11, 12
    const/4 v12, 0
    invoke-static/range v6 ... v12, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository;->updateStatus$default(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository; Ljava/util/List; Ljava/lang/String; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0; I Ljava/lang/Object;)V
    return-void 
.end method

.method private final navigateToSettings()void
    .registers 6
    # ins_size=1
    invoke-virtual v5, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->getParentFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v0
    invoke-virtual v0, Landroidx/fragment/app/FragmentManager;->beginTransaction()Landroidx/fragment/app/FragmentTransaction;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/home/R$anim;->trae_slide_in_right I
    sget v2, Lcom/bytedance/trae/home/R$anim;->trae_slide_out_left I
    sget v3, Lcom/bytedance/trae/home/R$anim;->trae_slide_in_left I
    sget v4, Lcom/bytedance/trae/home/R$anim;->trae_slide_out_right I
    invoke-virtual v0, v1, v2, v3, v4, Landroidx/fragment/app/FragmentTransaction;->setCustomAnimations(I I I I)Landroidx/fragment/app/FragmentTransaction;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/home/R$id;->settings_fragment_container I
    sget-object v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment;->Companion Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment$Companion;
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment$Companion;->newInstance()Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment;
    move-result-object v2
    check-cast v2, Landroidx/fragment/app/Fragment;
    invoke-virtual v0, v1, v2, Landroidx/fragment/app/FragmentTransaction;->replace(I Landroidx/fragment/app/Fragment;)Landroidx/fragment/app/FragmentTransaction;
    move-result-object v0
    const/4 v1, 0
    invoke-virtual v0, v1, Landroidx/fragment/app/FragmentTransaction;->addToBackStack(Ljava/lang/String;)Landroidx/fragment/app/FragmentTransaction;
    move-result-object v0
    invoke-virtual v0, Landroidx/fragment/app/FragmentTransaction;->commit()I
    return-void 
.end method

.method private static final onViewCreated$lambda$0(com.bytedance.trae.home.solo.sitemessage.SiteMessageListFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->getParentFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v0
    invoke-virtual v0, Landroidx/fragment/app/FragmentManager;->popBackStack()V
    return-void 
.end method

.method private static final onViewCreated$lambda$1(com.bytedance.trae.home.solo.sitemessage.SiteMessageListFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->navigateToSettings()V
    return-void 
.end method

.method private static final onViewCreated$lambda$2(com.bytedance.trae.home.solo.sitemessage.SiteMessageListFragment  com.bytedance.trae.home.solo.sitemessage.SiteMessageItem)kotlin.Unit
    .registers 3
    # ins_size=2
    const-string v0, "item"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->handleCtaTap(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final onViewCreated$lambda$3(com.bytedance.trae.home.solo.sitemessage.SiteMessageListFragment  com.bytedance.trae.home.solo.sitemessage.SiteMessageItem  int)kotlin.Unit
    .registers 4
    # ins_size=3
    const-string v0, "item"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v3, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->deleteItem(I Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final onViewCreated$lambda$4(com.bytedance.trae.home.solo.sitemessage.SiteMessageListFragment  android.view.View  com.bytedance.trae.home.solo.sitemessage.SiteMessageItem  int)kotlin.Unit
    .registers 5
    # ins_size=4
    const-string/jumbo v0, view
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "item"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v2, v3, v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->showDeletePopup(Landroid/view/View; Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem; I)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final onViewCreated$lambda$5(com.bytedance.trae.home.solo.sitemessage.SiteMessageItem  int)kotlin.Unit
    .registers 6
    # ins_size=2
    const-string v0, "item"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageTracker;->INSTANCE Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageTracker;
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;->getId()I
    move-result v1
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;->getNotificationType()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +004h
    const-string v2, ""
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;->isRead()Ljava/lang/Boolean;
    move-result-object v4
    const/4 v3, 0
    invoke-static v3, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v3
    invoke-static v4, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    xor-int/lit8 v4, v4, 1
    invoke-virtual v0, v1, v2, v4, v5, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageTracker;->trackItemClick(I Ljava/lang/String; Z I)V
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v4
.end method

.method private static final onViewCreated$lambda$7(com.bytedance.trae.home.solo.sitemessage.SiteMessageListFragment)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->fetchFirstPage()V
    return-void 
.end method

.method private final openInExternalBrowser(com.bytedance.trae.home.solo.sitemessage.SiteMessageItem)void
    .registers 7
    # ins_size=2
    invoke-virtual v6, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;->getActionUrl()Ljava/lang/String;
    move-result-object v0
    if-eqz v0, +053h
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +003h
    goto +45h
    move-object v1, v0
    check-cast v1, Ljava/lang/CharSequence;
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    const/4 v2, 1
    if-nez v1, +004h
    move v1, v2
    goto +2h
    const/4 v1, 0
    if-eqz v1, +003h
    return-void 
    invoke-static v0, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v1
    invoke-virtual v1, Landroid/net/Uri;->getScheme()Ljava/lang/String;
    move-result-object v3
    const-string v4, "http"
    invoke-static v3, v4, v2, Lkotlin/text/StringsKt;->equals(Ljava/lang/String; Ljava/lang/String; Z)Z
    move-result v4
    if-nez v4, +00bh
    const-string v4, "https"
    invoke-static v3, v4, v2, Lkotlin/text/StringsKt;->equals(Ljava/lang/String; Ljava/lang/String; Z)Z
    move-result v2
    if-nez v2, +003h
    return-void 
    sget-object v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageTracker;->INSTANCE Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageTracker;
    invoke-virtual v6, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;->getId()I
    move-result v3
    invoke-virtual v6, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;->getActionTitle()Ljava/lang/String;
    move-result-object v6
    if-nez v6, +004h
    const-string v6, ""
    invoke-virtual v2, v3, v6, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageTracker;->trackCtaClick(I Ljava/lang/String; Ljava/lang/String;)V
    new-instance v6, Landroid/content/Intent;
    const-string v0, "android.intent.action.VIEW"
    invoke-direct v6, v0, v1, Landroid/content/Intent;-><init>(Ljava/lang/String; Landroid/net/Uri;)V
    invoke-virtual v5, v6, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->startActivity(Landroid/content/Intent;)V
    return-void 
    :try_start_0x4d
.end method

.method private final resolveDeepLink(java.lang.String  java.lang.String)java.lang.String
    .registers 5
    # ins_size=3
    const-string v0, "in_app_navigation"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +039h
    move-object v3, v4
    check-cast v3, Ljava/lang/CharSequence;
    if-eqz v3, +00bh
    invoke-static v3, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v3
    if-eqz v3, +003h
    goto +3h
    const/4 v3, 0
    goto +2h
    const/4 v3, 1
    const/4 v0, 0
    if-eqz v3, +003h
    return-object v0
    new-instance v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment$resolveDeepLink$type$1;
    invoke-direct v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment$resolveDeepLink$type$1;-><init>()V
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment$resolveDeepLink$type$1;->getType()Ljava/lang/reflect/Type;
    move-result-object v3
    new-instance v1, Lcom/google/gson/Gson;
    invoke-direct v1, Lcom/google/gson/Gson;-><init>()V
    invoke-virtual v1, v4, v3, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String; Ljava/lang/reflect/Type;)Ljava/lang/Object;
    move-result-object v3
    const-string v4, "fromJson(...)"
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v3, Ljava/util/Map;
    const-string/jumbo v4, url
    invoke-interface v3, v4, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Ljava/lang/String;
    move-object v0, v3
    return-object v0
    return-object v3
    :try_start_0x1b
.end method

.method private final routeByCommand(com.bytedance.trae.home.solo.sitemessage.SiteMessageItem  java.lang.String)void
    .registers 9
    # ins_size=3
    invoke-virtual v7, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;->getCommandArgs()Ljava/lang/String;
    move-result-object v0
    invoke-direct v6, v8, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->resolveDeepLink(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v8
    if-nez v8, +003h
    return-void 
    invoke-static v8, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v0
    invoke-virtual v0, Landroid/net/Uri;->getHost()Ljava/lang/String;
    move-result-object v1
    if-nez v1, +003h
    return-void 
    new-instance v2, Ljava/util/LinkedHashMap;
    invoke-direct v2, Ljava/util/LinkedHashMap;-><init>()V
    check-cast v2, Ljava/util/Map;
    invoke-virtual v0, Landroid/net/Uri;->getQueryParameterNames()Ljava/util/Set;
    move-result-object v3
    invoke-interface v3, Ljava/util/Set;->iterator()Ljava/util/Iterator;
    move-result-object v3
    invoke-interface v3, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +012h
    invoke-interface v3, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Ljava/lang/String;
    invoke-virtual v0, v4, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v5
    if-eqz v5, -010h
    invoke-interface v2, v4, v5, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    goto -15h
    sget-object v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageTracker;->INSTANCE Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageTracker;
    invoke-virtual v7, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;->getId()I
    move-result v3
    invoke-virtual v7, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;->getActionTitle()Ljava/lang/String;
    move-result-object v7
    if-nez v7, +004h
    const-string v7, ""
    invoke-virtual v0, v3, v7, v8, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageTracker;->trackCtaClick(I Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v7
    const v8, 740154499
    if-eq v7, v8, +028h
    const v8, 1224424441
    if-eq v7, v8, +015h
    const v8, 1846152997
    if-eq v7, v8, +003h
    goto +28h
    const-string v7, "newtask"
    invoke-virtual v1, v7, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v7
    if-nez v7, +003h
    goto +1fh
    invoke-direct v6, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->routeToNewtask(Ljava/util/Map;)V
    goto +1bh
    const-string/jumbo v7, webview
    invoke-virtual v1, v7, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v7
    if-nez v7, +003h
    goto +11h
    invoke-direct v6, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->routeToWebview(Ljava/util/Map;)V
    goto +dh
    const-string v7, "conversation"
    invoke-virtual v1, v7, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v7
    if-nez v7, +003h
    goto +4h
    invoke-direct v6, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->routeToConversation(Ljava/util/Map;)V
    return-void 
.end method

.method private final routeToConnectDevice(java.util.Map)void
    .registers 5
    # ins_size=2
    const-string v0, "device_type"
    invoke-interface v4, v0, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Ljava/lang/String;
    if-nez v4, +005h
    const-string/jumbo v4, work
    const-string v0, "ide"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +005h
    sget-object v4, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->IDE Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    goto +3h
    sget-object v4, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->WORK Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    sget-object v0, Lcom/bytedance/trae/conversation/devices/MobileIdeFeatureGate;->INSTANCE Lcom/bytedance/trae/conversation/devices/MobileIdeFeatureGate;
    invoke-virtual v0, v4, Lcom/bytedance/trae/conversation/devices/MobileIdeFeatureGate;->canOpenConnectGuide(Lcom/bytedance/trae/conversation/devices/DeviceProductType;)Z
    move-result v0
    if-nez v0, +004h
    sget-object v4, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->WORK Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->getContext()Landroid/content/Context;
    move-result-object v0
    if-nez v0, +003h
    return-void 
    new-instance v1, Landroid/content/Intent;
    const-class v2, Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-direct v1, v0, v2, Landroid/content/Intent;-><init>(Landroid/content/Context; Ljava/lang/Class;)V
    const-string v0, "extra_enter_from"
    const-string/jumbo v2, site_message
    invoke-virtual v1, v0, v2, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    const-string v0, "extra_pending_connect_device_type"
    invoke-virtual v4, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->name()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v0, v2, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    sget-object v0, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->IDE Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    if-ne v4, v0, +009h
    const-string v4, "extra_mode"
    const-string v0, "code"
    invoke-virtual v1, v4, v0, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    invoke-virtual v3, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->startActivity(Landroid/content/Intent;)V
    return-void 
.end method

.method private final routeToConversation(java.util.Map)void
    .registers 5
    # ins_size=2
    const-string v0, "conversation_id"
    invoke-interface v4, v0, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Ljava/lang/String;
    if-nez v4, +003h
    return-void 
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->getContext()Landroid/content/Context;
    move-result-object v0
    if-nez v0, +003h
    return-void 
    new-instance v1, Landroid/content/Intent;
    const-class v2, Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-direct v1, v0, v2, Landroid/content/Intent;-><init>(Landroid/content/Context; Ljava/lang/Class;)V
    const-string v0, "extra_conversation_id"
    invoke-virtual v1, v0, v4, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    const-string v4, "extra_enter_from"
    const-string/jumbo v0, site_message
    invoke-virtual v1, v4, v0, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    invoke-virtual v3, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->startActivity(Landroid/content/Intent;)V
    return-void 
.end method

.method private final routeToNewtask(java.util.Map)void
    .registers 4
    # ins_size=2
    const-string v0, "action"
    invoke-interface v3, v0, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/String;
    if-nez v0, +003h
    return-void 
    const-string v1, "connect_device"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +005h
    invoke-direct v2, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->routeToConnectDevice(Ljava/util/Map;)V
    return-void 
.end method

.method private final routeToWebview(java.util.Map)void
    .registers 11
    # ins_size=2
    const-string/jumbo v0, url
    invoke-interface v10, v0, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v10
    move-object v2, v10
    check-cast v2, Ljava/lang/String;
    if-nez v2, +003h
    return-void 
    sget-object v10, Lcom/bytedance/trae/utils/TrustedDomainUtils;->INSTANCE Lcom/bytedance/trae/utils/TrustedDomainUtils;
    invoke-virtual v10, v2, Lcom/bytedance/trae/utils/TrustedDomainUtils;->isTrustedUrl(Ljava/lang/String;)Z
    move-result v10
    if-nez v10, +003h
    return-void 
    invoke-virtual v9, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->getContext()Landroid/content/Context;
    move-result-object v1
    if-nez v1, +003h
    return-void 
    sget-object v0, Lcom/bytedance/trae/conversation/ShareWebViewActivity;->Companion Lcom/bytedance/trae/conversation/ShareWebViewActivity$Companion;
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/16 v7, 60
    const/4 v8, 0
    invoke-static/range v0 ... v8, Lcom/bytedance/trae/conversation/ShareWebViewActivity$Companion;->start$default(Lcom/bytedance/trae/conversation/ShareWebViewActivity$Companion; Landroid/content/Context; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    return-void 
.end method

.method private final showDeletePopup(android.view.View  com.bytedance.trae.home.solo.sitemessage.SiteMessageItem  int)void
    .registers 20
    # ins_size=4
    move-object/from16 v0, v16
    invoke-virtual/range v17, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v1
    invoke-virtual v1, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v2
    invoke-virtual v2, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v2
    iget v2, v2, Landroid/util/DisplayMetrics;->density F
    invoke-virtual/range v16, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->getView()Landroid/view/View;
    move-result-object v3
    if-eqz v3, +0d3h
    sget v4, Lcom/bytedance/trae/home/R$id;->root_container I
    invoke-virtual v3, v4, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v3
    if-nez v3, +004h
    goto/16 +0c9h
    iget-object v4, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->adapter Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;
    const/4 v5, 0
    if-nez v4, +008h
    const-string v4, "adapter"
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v4, v5
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;->closeOpenItem()V
    invoke-virtual/range v17, Landroid/view/View;->getParent()Landroid/view/ViewParent;
    move-result-object v4
    instance-of v6, v4, Landroid/view/View;
    if-eqz v6, +005h
    check-cast v4, Landroid/view/View;
    goto +2h
    move-object v4, v5
    if-nez v4, +004h
    move-object/from16 v4, v17
    invoke-virtual v4, Landroid/view/View;->getWidth()I
    move-result v6
    invoke-virtual v4, Landroid/view/View;->getHeight()I
    move-result v7
    sget-object v8, Landroid/graphics/Bitmap$Config;->ARGB_8888 Landroid/graphics/Bitmap$Config;
    invoke-static v6, v7, v8, Landroid/graphics/Bitmap;->createBitmap(I I Landroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    move-result-object v6
    invoke-static v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    new-instance v7, Landroid/graphics/Canvas;
    invoke-direct v7, v6, Landroid/graphics/Canvas;-><init>(Landroid/graphics/Bitmap;)V
    invoke-virtual v4, v7, Landroid/view/View;->draw(Landroid/graphics/Canvas;)V
    const/4 v7, 2
    new-array v8, v7, [I
    invoke-virtual v4, v8, Landroid/view/View;->getLocationInWindow([I)V
    new-array v7, v7, [I
    invoke-virtual v3, v7, Landroid/view/View;->getLocationInWindow([I)V
    const/4 v9, 0
    aget v10, v8, v9
    aget v11, v7, v9
    sub-int/2addr v10, v11
    const/4 v11, 1
    aget v12, v8, v11
    aget v7, v7, v11
    sub-int/2addr v12, v7
    iget-object v7, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->floatingCard Landroid/widget/ImageView;
    if-eqz v7, +01eh
    invoke-virtual v7, v6, Landroid/widget/ImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V
    new-instance v13, Landroid/widget/FrameLayout$LayoutParams;
    invoke-virtual v4, Landroid/view/View;->getWidth()I
    move-result v14
    invoke-virtual v4, Landroid/view/View;->getHeight()I
    move-result v15
    invoke-direct v13, v14, v15, Landroid/widget/FrameLayout$LayoutParams;-><init>(I I)V
    iput v10, v13, Landroid/widget/FrameLayout$LayoutParams;->leftMargin I
    iput v12, v13, Landroid/widget/FrameLayout$LayoutParams;->topMargin I
    check-cast v13, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v7, v13, Landroid/widget/ImageView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    invoke-virtual v7, v9, Landroid/widget/ImageView;->setVisibility(I)V
    iget-object v7, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->dimOverlay Landroid/view/View;
    if-eqz v7, +005h
    invoke-virtual v7, v9, Landroid/view/View;->setVisibility(I)V
    invoke-static v1, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;
    move-result-object v1
    sget v7, Lcom/bytedance/trae/home/R$layout;->popup_message_delete I
    invoke-virtual v1, v7, v5, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup;)Landroid/view/View;
    move-result-object v1
    const/16 v5, 240
    int-to-float v5, v5
    mul-float/2addr v5, v2
    float-to-int v5, v5
    const/16 v7, 44
    int-to-float v7, v7
    mul-float/2addr v7, v2
    float-to-int v7, v7
    new-instance v10, Landroid/widget/PopupWindow;
    invoke-direct v10, v1, v5, v7, v11, Landroid/widget/PopupWindow;-><init>(Landroid/view/View; I I Z)V
    const/high16 v5, 1090519040
    mul-float/2addr v5, v2
    invoke-virtual v10, v5, Landroid/widget/PopupWindow;->setElevation(F)V
    invoke-virtual v10, v11, Landroid/widget/PopupWindow;->setOutsideTouchable(Z)V
    new-instance v5, Landroid/graphics/drawable/ColorDrawable;
    invoke-direct v5, v9, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V
    check-cast v5, Landroid/graphics/drawable/Drawable;
    invoke-virtual v10, v5, Landroid/widget/PopupWindow;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V
    new-instance v5, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment$$ExternalSyntheticLambda0;
    invoke-direct v5, v0, v6, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment; Landroid/graphics/Bitmap;)V
    invoke-virtual v10, v5, Landroid/widget/PopupWindow;->setOnDismissListener(Landroid/widget/PopupWindow$OnDismissListener;)V
    new-instance v5, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment$$ExternalSyntheticLambda1;
    move-object/from16 v6, v18
    move/from16 v7, v19
    invoke-direct v5, v10, v0, v7, v6, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment$$ExternalSyntheticLambda1;-><init>(Landroid/widget/PopupWindow; Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment; I Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;)V
    invoke-virtual v1, v5, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    aget v1, v8, v9
    aget v5, v8, v11
    invoke-virtual v4, Landroid/view/View;->getHeight()I
    move-result v4
    add-int/2addr v5, v4
    const/16 v4, 8
    int-to-float v4, v4
    mul-float/2addr v4, v2
    float-to-int v2, v4
    add-int/2addr v5, v2
    invoke-virtual v10, v3, v9, v1, v5, Landroid/widget/PopupWindow;->showAtLocation(Landroid/view/View; I I I)V
    return-void 
    :try_start_0x3e
.end method

.method private static final showDeletePopup$lambda$17(com.bytedance.trae.home.solo.sitemessage.SiteMessageListFragment  android.graphics.Bitmap)void
    .registers 5
    # ins_size=2
    iget-object v0, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->dimOverlay Landroid/view/View;
    const/16 v1, 8
    if-eqz v0, +005h
    invoke-virtual v0, v1, Landroid/view/View;->setVisibility(I)V
    iget-object v0, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->floatingCard Landroid/widget/ImageView;
    if-eqz v0, +006h
    const/4 v2, 0
    invoke-virtual v0, v2, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V
    iget-object v3, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->floatingCard Landroid/widget/ImageView;
    if-eqz v3, +005h
    invoke-virtual v3, v1, Landroid/widget/ImageView;->setVisibility(I)V
    invoke-virtual v4, Landroid/graphics/Bitmap;->recycle()V
    return-void 
.end method

.method private static final showDeletePopup$lambda$18(android.widget.PopupWindow  com.bytedance.trae.home.solo.sitemessage.SiteMessageListFragment  int  com.bytedance.trae.home.solo.sitemessage.SiteMessageItem  android.view.View)void
    .registers 5
    # ins_size=5
    invoke-virtual v0, Landroid/widget/PopupWindow;->dismiss()V
    invoke-direct v1, v2, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->deleteItem(I Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;)V
    return-void 
.end method

.method private final updateEmptyState()void
    .registers 6
    # ins_size=1
    iget-object v0, v5, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->adapter Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;
    if-nez v0, +008h
    const-string v0, "adapter"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;->isEmpty()Z
    move-result v0
    iget-object v1, v5, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->emptyState Landroid/view/View;
    const/4 v2, 0
    const/16 v3, 8
    if-eqz v1, +00ah
    if-eqz v0, +004h
    move v4, v2
    goto +2h
    move v4, v3
    invoke-virtual v1, v4, Landroid/view/View;->setVisibility(I)V
    iget-object v1, v5, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->recyclerView Landroidx/recyclerview/widget/RecyclerView;
    if-eqz v1, +008h
    if-eqz v0, +003h
    move v2, v3
    invoke-virtual v1, v2, Landroidx/recyclerview/widget/RecyclerView;->setVisibility(I)V
    return-void 
.end method

.method public onCreateView(android.view.LayoutInflater  android.view.ViewGroup  android.os.Bundle)android.view.View
    .registers 5
    # ins_size=4
    const-string v4, "inflater"
    invoke-static v2, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget v4, Lcom/bytedance/trae/home/R$layout;->fragment_site_message_list I
    const/4 v0, 0
    invoke-virtual v2, v4, v3, v0, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    return-object v2
.end method

.method public onDestroyView()void
    .registers 2
    # ins_size=1
    invoke-super v1, Landroidx/fragment/app/Fragment;->onDestroyView()V
    invoke-direct v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->getReadTracker()Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;->flushReadReport()V
    return-void 
.end method

.method public onViewCreated(android.view.View  android.os.Bundle)void
    .registers 6
    # ins_size=3
    const-string/jumbo v0, view
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-super v3, v4, v5, Landroidx/fragment/app/Fragment;->onViewCreated(Landroid/view/View; Landroid/os/Bundle;)V
    sget v5, Lcom/bytedance/trae/home/R$id;->title_bar I
    invoke-virtual v4, v5, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v5
    check-cast v5, Lcom/bytedance/trae/common/widget/TraeTitleBar;
    iput-object v5, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    sget v5, Lcom/bytedance/trae/home/R$id;->rv_messages I
    invoke-virtual v4, v5, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v5
    check-cast v5, Landroidx/recyclerview/widget/RecyclerView;
    iput-object v5, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->recyclerView Landroidx/recyclerview/widget/RecyclerView;
    sget v5, Lcom/bytedance/trae/home/R$id;->swipe_refresh I
    invoke-virtual v4, v5, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v5
    check-cast v5, Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;
    iput-object v5, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->swipeRefresh Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;
    sget v5, Lcom/bytedance/trae/home/R$id;->tv_empty I
    invoke-virtual v4, v5, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v5
    check-cast v5, Landroid/widget/TextView;
    iput-object v5, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->tvEmpty Landroid/widget/TextView;
    sget v5, Lcom/bytedance/trae/home/R$id;->empty_state I
    invoke-virtual v4, v5, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v5
    iput-object v5, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->emptyState Landroid/view/View;
    sget v5, Lcom/bytedance/trae/home/R$id;->dim_overlay I
    invoke-virtual v4, v5, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v5
    iput-object v5, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->dimOverlay Landroid/view/View;
    sget v5, Lcom/bytedance/trae/home/R$id;->floating_card I
    invoke-virtual v4, v5, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v4
    check-cast v4, Landroid/widget/ImageView;
    iput-object v4, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->floatingCard Landroid/widget/ImageView;
    iget-object v4, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    if-eqz v4, +00ah
    new-instance v5, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment$$ExternalSyntheticLambda3;
    invoke-direct v5, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment$$ExternalSyntheticLambda3;-><init>(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;)V
    invoke-virtual v4, v5, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setOnLeftActionClickListener(Landroid/view/View$OnClickListener;)V
    sget-object v4, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v4, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isOversea()Z
    move-result v4
    if-eqz v4, +00fh
    iget-object v4, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    if-eqz v4, +013h
    new-instance v5, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment$$ExternalSyntheticLambda4;
    invoke-direct v5, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment$$ExternalSyntheticLambda4;-><init>(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;)V
    invoke-virtual v4, v5, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setOnRightActionClickListener(Landroid/view/View$OnClickListener;)V
    goto +9h
    iget-object v4, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    if-eqz v4, +006h
    const/4 v5, 0
    invoke-virtual v4, v5, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setRightActionsVisible(Z)V
    new-instance v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;
    new-instance v5, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment$$ExternalSyntheticLambda5;
    invoke-direct v5, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment$$ExternalSyntheticLambda5;-><init>(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;)V
    new-instance v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment$$ExternalSyntheticLambda6;
    invoke-direct v0, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment$$ExternalSyntheticLambda6;-><init>(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;)V
    new-instance v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment$$ExternalSyntheticLambda7;
    invoke-direct v1, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment$$ExternalSyntheticLambda7;-><init>(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;)V
    new-instance v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment$$ExternalSyntheticLambda8;
    invoke-direct v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment$$ExternalSyntheticLambda8;-><init>()V
    invoke-direct v4, v5, v0, v1, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;-><init>(Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function2; Lkotlin/jvm/functions/Function3; Lkotlin/jvm/functions/Function2;)V
    iput-object v4, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->adapter Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;
    iget-object v4, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->recyclerView Landroidx/recyclerview/widget/RecyclerView;
    if-eqz v4, +026h
    new-instance v5, Landroidx/recyclerview/widget/LinearLayoutManager;
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->requireContext()Landroid/content/Context;
    move-result-object v0
    invoke-direct v5, v0, Landroidx/recyclerview/widget/LinearLayoutManager;-><init>(Landroid/content/Context;)V
    check-cast v5, Landroidx/recyclerview/widget/RecyclerView$LayoutManager;
    invoke-virtual v4, v5, Landroidx/recyclerview/widget/RecyclerView;->setLayoutManager(Landroidx/recyclerview/widget/RecyclerView$LayoutManager;)V
    iget-object v5, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->adapter Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;
    if-nez v5, +008h
    const-string v5, "adapter"
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v5, 0
    check-cast v5, Landroidx/recyclerview/widget/RecyclerView$Adapter;
    invoke-virtual v4, v5, Landroidx/recyclerview/widget/RecyclerView;->setAdapter(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V
    iget-object v5, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->scrollListener Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment$scrollListener$1;
    check-cast v5, Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;
    invoke-virtual v4, v5, Landroidx/recyclerview/widget/RecyclerView;->addOnScrollListener(Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;)V
    iget-object v4, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->swipeRefresh Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;
    if-eqz v4, +00ah
    new-instance v5, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment$$ExternalSyntheticLambda9;
    invoke-direct v5, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment$$ExternalSyntheticLambda9;-><init>(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;)V
    invoke-virtual v4, v5, Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;->setOnRefreshListener(Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;)V
    sget-object v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository;->INSTANCE Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository;
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository;->clearLocalUnreadBadge()V
    invoke-direct v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->fetchFirstPage()V
    return-void 
.end method
