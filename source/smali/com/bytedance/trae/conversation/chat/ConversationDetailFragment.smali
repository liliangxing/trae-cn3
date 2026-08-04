# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;
.super Landroidx/fragment/app/Fragment;
.source "ConversationDetailFragment.kt"

.field public static final Companion:Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$Companion;
.field public static final TAG:Ljava/lang/String;
.field private final adapter$delegate:Lkotlin/Lazy;
.field private btnScrollToBottom:Landroid/widget/ImageView;
.field private final fpsTracer:Lcom/bytedance/apm/trace/fps/FpsTracer;
.field private hasMoreOlderMessages:Z
.field private isAnchorLoadingVisible:Z
.field private isNewerPageLoadingVisible:Z
.field private isOlderPageLoadingVisible:Z
.field private lastTouchY:Ljava/lang/Float;
.field private lm:Landroidx/recyclerview/widget/LinearLayoutManager;
.field private newerPageLoading:Lcom/bytedance/trae/common/widget/TraeLoadingView;
.field private olderPageLoading:Lcom/bytedance/trae/common/widget/TraeLoadingView;
.field private onCopyClick:Lkotlin/jvm/functions/Function1;
.field private onFeedbackClick:Lkotlin/jvm/functions/Function2;
.field private onJumpToBottomClick:Lkotlin/jvm/functions/Function0;
.field private onLoadMore:Lkotlin/jvm/functions/Function0;
.field private onLoadNewer:Lkotlin/jvm/functions/Function0;
.field private final onPureShowWidgetInlineViewCreated:Lkotlin/jvm/functions/Function1;
.field private onReportClick:Lkotlin/jvm/functions/Function2;
.field private onRetryClick:Lkotlin/jvm/functions/Function1;
.field private onUpgradeReminderClick:Lkotlin/jvm/functions/Function1;
.field private onUseExpressPassClick:Lkotlin/jvm/functions/Function1;
.field private onUserScrolled:Lkotlin/jvm/functions/Function0;
.field private final pureShowWidgetInlineViewRefs:Ljava/util/List;
.field private rvMessages:Landroidx/recyclerview/widget/RecyclerView;
.field private stickyBottomScroller:Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;
.field private touchSlop:I
.field private userDraggedTowardNewerSinceLastCheck:Z
.field private userDraggedTowardOlderSinceLastCheck:Z


.method public static synthetic $r8$lambda$2rPDUDlgeuoOYbJCIcAMH56DJVA(com.bytedance.trae.conversation.chat.ConversationDetailFragment  int)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->scrollToCreatedAt$lambda$18(Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment; I)V
    return-void 
.end method

.method public static synthetic $r8$lambda$7ChY3srQFHsI_Om_BXPyyqx__sY(com.bytedance.trae.conversation.chat.ConversationDetailFragment  java.lang.String)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->onViewCreated$lambda$3(Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment; Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$7e8KBgZxDCKxEatFFucDH1Lc1QE(com.bytedance.trae.conversation.chat.ConversationDetailFragment  com.bytedance.trae.conversation.chat.ConversationDetailFragment$VisibleAnchor  boolean  kotlin.jvm.functions.Function0  boolean)void
    .registers 5
    # ins_size=5
    invoke-static v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->submitMessages$lambda$14(Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment; Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$VisibleAnchor; Z Lkotlin/jvm/functions/Function0; Z)V
    return-void 
.end method

.method public static synthetic $r8$lambda$DO6MURQoCWImBAtmqUNQQO2EyNg(com.bytedance.trae.conversation.chat.block.renderer.PureShowWidgetInlineView  java.lang.ref.WeakReference)boolean
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->onPureShowWidgetInlineViewCreated$lambda$2$lambda$1(Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView; Ljava/lang/ref/WeakReference;)Z
    move-result v0
    return v0
.end method

.method public static synthetic $r8$lambda$IdLIt4NhczaNsQiqZgXALp2WD2A(com.bytedance.trae.conversation.chat.ConversationDetailFragment  java.lang.String  java.lang.String)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->onViewCreated$lambda$7(Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment; Ljava/lang/String; Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$MO75z2KP0q5HptqaUWfDgrYDxaI(com.bytedance.trae.conversation.chat.ConversationDetailFragment  int  com.bytedance.trae.conversation.chat.ConversationDetailFragment$VisibleAnchor)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->restoreVisibleAnchor$lambda$26(Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment; I Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$VisibleAnchor;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$TjdMuKwKIlnUOXWg1o9OLrjt9Eg(com.bytedance.trae.conversation.chat.ConversationDetailFragment)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->submitMessages$lambda$14$lambda$13(Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$YXC0sA9k5lWE4BxO0dk0_m-lj6c(com.bytedance.trae.conversation.chat.ConversationDetailFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->onViewCreated$lambda$11(Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$_dU6HMSGQ6VYu7Up6_B7giXvGI4(com.bytedance.trae.conversation.chat.ConversationDetailFragment)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->scheduleScrollToBottomVisibilityUpdate$lambda$28$lambda$27(Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$cTb06ZMue6lXKH3YiibAMIAZ5ag(com.bytedance.trae.conversation.chat.ConversationDetailFragment  java.lang.String)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->onViewCreated$lambda$4(Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment; Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$d9yqn-eSaesY4kjiddnfpJcPiew(com.bytedance.trae.conversation.chat.ConversationDetailFragment)com.bytedance.trae.conversation.chat.ChatMessageAdapter
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->adapter_delegate$lambda$0(Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;)Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$dvdaAnvfhcpZOmOYcOi5yCfb6ng(com.bytedance.trae.conversation.chat.ConversationDetailFragment)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->scheduleScrollToBottomVisibilityUpdate$lambda$28(Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$mubcgNMSZrIhyiIJgUQRms3y1jw(com.bytedance.trae.conversation.chat.ConversationDetailFragment  java.lang.String)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->onViewCreated$lambda$6(Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment; Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$o4lyAGEN1Ag_rngPNFXfR4-1gHY(com.bytedance.trae.conversation.chat.ConversationDetailFragment  com.bytedance.trae.conversation.chat.block.renderer.PureShowWidgetInlineView)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->onPureShowWidgetInlineViewCreated$lambda$2(Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment; Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$sDeCU7AqJeNeNfX_a5GPftG_N5g(com.bytedance.trae.conversation.chat.ConversationDetailFragment  java.lang.String)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->onViewCreated$lambda$8(Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment; Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$ve53rabIIkMSdYJO5UHQRMVSxdw(com.bytedance.trae.conversation.chat.ConversationDetailFragment)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->onViewCreated$lambda$10$lambda$9(Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$z0MAKB0RAgspKOh3H88cEu5C-5M(com.bytedance.trae.conversation.chat.ConversationDetailFragment  java.lang.String  java.lang.String)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->onViewCreated$lambda$5(Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment; Ljava/lang/String; Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->Companion Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 4
    # ins_size=1
    invoke-direct v3, Landroidx/fragment/app/Fragment;-><init>()V
    new-instance v0, Lcom/bytedance/apm/trace/fps/FpsTracer;
    const-string v1, "conversation_detail_list"
    const/4 v2, 0
    invoke-direct v0, v1, v2, Lcom/bytedance/apm/trace/fps/FpsTracer;-><init>(Ljava/lang/String; Z)V
    iput-object v0, v3, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->fpsTracer Lcom/bytedance/apm/trace/fps/FpsTracer;
    new-instance v0, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$$ExternalSyntheticLambda8;
    invoke-direct v0, v3, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$$ExternalSyntheticLambda8;-><init>(Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;)V
    invoke-static v0, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v0
    iput-object v0, v3, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->adapter$delegate Lkotlin/Lazy;
    const/4 v0, 1
    iput-boolean v0, v3, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->hasMoreOlderMessages Z
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/List;
    iput-object v0, v3, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->pureShowWidgetInlineViewRefs Ljava/util/List;
    new-instance v0, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$$ExternalSyntheticLambda9;
    invoke-direct v0, v3, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$$ExternalSyntheticLambda9;-><init>(Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;)V
    iput-object v0, v3, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->onPureShowWidgetInlineViewCreated Lkotlin/jvm/functions/Function1;
    return-void 
.end method

.method public static final synthetic access$getLastTouchY$p(com.bytedance.trae.conversation.chat.ConversationDetailFragment)java.lang.Float
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->lastTouchY Ljava/lang/Float;
    return-object v0
.end method

.method public static final synthetic access$getTouchSlop$p(com.bytedance.trae.conversation.chat.ConversationDetailFragment)int
    .registers 1
    # ins_size=1
    iget v0, v0, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->touchSlop I
    return v0
.end method

.method public static final synthetic access$maybeLoadNewerAtBottom(com.bytedance.trae.conversation.chat.ConversationDetailFragment)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->maybeLoadNewerAtBottom()V
    return-void 
.end method

.method public static final synthetic access$maybeLoadOlderAtTop(com.bytedance.trae.conversation.chat.ConversationDetailFragment)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->maybeLoadOlderAtTop()V
    return-void 
.end method

.method public static final synthetic access$setLastTouchY$p(com.bytedance.trae.conversation.chat.ConversationDetailFragment  java.lang.Float)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->lastTouchY Ljava/lang/Float;
    return-void 
.end method

.method public static final synthetic access$setUserDraggedTowardNewerSinceLastCheck$p(com.bytedance.trae.conversation.chat.ConversationDetailFragment  boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->userDraggedTowardNewerSinceLastCheck Z
    return-void 
.end method

.method public static final synthetic access$setUserDraggedTowardOlderSinceLastCheck$p(com.bytedance.trae.conversation.chat.ConversationDetailFragment  boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->userDraggedTowardOlderSinceLastCheck Z
    return-void 
.end method

.method public static final synthetic access$updateScrollToBottomVisibility(com.bytedance.trae.conversation.chat.ConversationDetailFragment)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->updateScrollToBottomVisibility()V
    return-void 
.end method

.method private static final adapter_delegate$lambda$0(com.bytedance.trae.conversation.chat.ConversationDetailFragment)com.bytedance.trae.conversation.chat.ChatMessageAdapter
    .registers 3
    # ins_size=1
    new-instance v0, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->requireContext()Landroid/content/Context;
    move-result-object v2
    const-string/jumbo v1, requireContext(...)
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v0, v2, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;-><init>(Landroid/content/Context;)V
    return-object v0
.end method

.method private final applyAnchorLoadingVisibility()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->applyDirectionalLoadingVisibility()V
    return-void 
.end method

.method private final applyDirectionalLoadingVisibility()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->olderPageLoading Lcom/bytedance/trae/common/widget/TraeLoadingView;
    if-eqz v0, +011h
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->isAnchorLoadingVisible Z
    if-nez v1, +009h
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->isOlderPageLoadingVisible Z
    if-eqz v1, +003h
    goto +3h
    const/4 v1, 0
    goto +2h
    const/4 v1, 1
    invoke-virtual v0, v1, Lcom/bytedance/trae/common/widget/TraeLoadingView;->setLoadingVisible(Z)V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->newerPageLoading Lcom/bytedance/trae/common/widget/TraeLoadingView;
    if-eqz v0, +007h
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->isNewerPageLoadingVisible Z
    invoke-virtual v0, v1, Lcom/bytedance/trae/common/widget/TraeLoadingView;->setLoadingVisible(Z)V
    return-void 
.end method

.method private final getAdapter()com.bytedance.trae.conversation.chat.ChatMessageAdapter
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->adapter$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;
    return-object v0
.end method

.method private final maybeLoadNewerAtBottom()void
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->onLoadNewer Lkotlin/jvm/functions/Function0;
    if-nez v0, +003h
    return-void 
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->lm Landroidx/recyclerview/widget/LinearLayoutManager;
    if-nez v1, +003h
    return-void 
    iget-boolean v2, v4, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->userDraggedTowardNewerSinceLastCheck Z
    if-nez v2, +003h
    return-void 
    iget-boolean v2, v4, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->isNewerPageLoadingVisible Z
    if-eqz v2, +003h
    return-void 
    invoke-direct v4, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->getAdapter()Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->getCurrentList()Ljava/util/List;
    move-result-object v2
    invoke-interface v2, Ljava/util/List;->isEmpty()Z
    move-result v2
    if-eqz v2, +003h
    return-void 
    invoke-virtual v1, Landroidx/recyclerview/widget/LinearLayoutManager;->findLastVisibleItemPosition()I
    move-result v1
    invoke-direct v4, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->getAdapter()Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->getCurrentList()Ljava/util/List;
    move-result-object v2
    invoke-interface v2, Ljava/util/List;->size()I
    move-result v2
    const/4 v3, 1
    sub-int/2addr v2, v3
    if-lt v1, v2, +00bh
    const/4 v1, 0
    iput-boolean v1, v4, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->userDraggedTowardNewerSinceLastCheck Z
    invoke-virtual v4, v3, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->setLoadingNewer(Z)V
    invoke-interface v0, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    return-void 
.end method

.method private final maybeLoadOlderAtTop()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->onLoadMore Lkotlin/jvm/functions/Function0;
    if-nez v0, +003h
    return-void 
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->userDraggedTowardOlderSinceLastCheck Z
    if-nez v1, +003h
    return-void 
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->hasMoreOlderMessages Z
    if-eqz v1, +02ah
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->isOlderPageLoadingVisible Z
    if-eqz v1, +003h
    goto +24h
    invoke-direct v2, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->getAdapter()Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->getCurrentList()Ljava/util/List;
    move-result-object v1
    invoke-interface v1, Ljava/util/List;->isEmpty()Z
    move-result v1
    if-eqz v1, +003h
    return-void 
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->lm Landroidx/recyclerview/widget/LinearLayoutManager;
    if-eqz v1, +012h
    invoke-virtual v1, Landroidx/recyclerview/widget/LinearLayoutManager;->findFirstVisibleItemPosition()I
    move-result v1
    if-gtz v1, +00ch
    const/4 v1, 0
    iput-boolean v1, v2, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->userDraggedTowardOlderSinceLastCheck Z
    const/4 v1, 1
    invoke-virtual v2, v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->setLoadingMore(Z)V
    invoke-interface v0, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    return-void 
.end method

.method private static final onPureShowWidgetInlineViewCreated$lambda$2(com.bytedance.trae.conversation.chat.ConversationDetailFragment  com.bytedance.trae.conversation.chat.block.renderer.PureShowWidgetInlineView)kotlin.Unit
    .registers 4
    # ins_size=2
    const-string v0, "inlineView"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->pureShowWidgetInlineViewRefs Ljava/util/List;
    new-instance v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$$ExternalSyntheticLambda6;
    invoke-direct v1, v3, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$$ExternalSyntheticLambda6;-><init>(Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;)V
    invoke-static v0, v1, Lkotlin/collections/CollectionsKt;->removeAll(Ljava/util/List; Lkotlin/jvm/functions/Function1;)Z
    iget-object v2, v2, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->pureShowWidgetInlineViewRefs Ljava/util/List;
    new-instance v0, Ljava/lang/ref/WeakReference;
    invoke-direct v0, v3, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V
    invoke-interface v2, v0, Ljava/util/List;->add(Ljava/lang/Object;)Z
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v2
.end method

.method private static final onPureShowWidgetInlineViewCreated$lambda$2$lambda$1(com.bytedance.trae.conversation.chat.block.renderer.PureShowWidgetInlineView  java.lang.ref.WeakReference)boolean
    .registers 3
    # ins_size=2
    const-string v0, "ref"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v2, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;
    if-eqz v2, +007h
    if-ne v2, v1, +003h
    goto +3h
    const/4 v1, 0
    goto +2h
    const/4 v1, 1
    return v1
.end method

.method private static final onViewCreated$lambda$10$lambda$9(com.bytedance.trae.conversation.chat.ConversationDetailFragment)kotlin.Unit
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->stickyBottomScroller Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;
    if-eqz v0, +005h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->onItemContentChanged()V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final onViewCreated$lambda$11(com.bytedance.trae.conversation.chat.ConversationDetailFragment  android.view.View)void
    .registers 4
    # ins_size=2
    iget-object v3, v2, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->onJumpToBottomClick Lkotlin/jvm/functions/Function0;
    const/4 v0, 0
    if-eqz v3, +010h
    invoke-interface v3, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Ljava/lang/Boolean;
    invoke-virtual v3, Ljava/lang/Boolean;->booleanValue()Z
    move-result v3
    const/4 v1, 1
    if-ne v3, v1, +003h
    move v0, v1
    if-nez v0, +009h
    iget-object v3, v2, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->stickyBottomScroller Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;
    if-eqz v3, +005h
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->forceScrollToBottom()V
    iget-object v2, v2, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->btnScrollToBottom Landroid/widget/ImageView;
    if-eqz v2, +007h
    const/16 v3, 8
    invoke-virtual v2, v3, Landroid/widget/ImageView;->setVisibility(I)V
    return-void 
.end method

.method private static final onViewCreated$lambda$3(com.bytedance.trae.conversation.chat.ConversationDetailFragment  java.lang.String)kotlin.Unit
    .registers 3
    # ins_size=2
    const-string v0, "messageId"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v1, v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->onRetryClick Lkotlin/jvm/functions/Function1;
    if-eqz v1, +005h
    invoke-interface v1, v2, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final onViewCreated$lambda$4(com.bytedance.trae.conversation.chat.ConversationDetailFragment  java.lang.String)kotlin.Unit
    .registers 3
    # ins_size=2
    const-string v0, "messageId"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v1, v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->onUseExpressPassClick Lkotlin/jvm/functions/Function1;
    if-eqz v1, +005h
    invoke-interface v1, v2, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final onViewCreated$lambda$5(com.bytedance.trae.conversation.chat.ConversationDetailFragment  java.lang.String  java.lang.String)kotlin.Unit
    .registers 4
    # ins_size=3
    const-string v0, "messageId"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, resultType
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v1, v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->onFeedbackClick Lkotlin/jvm/functions/Function2;
    if-eqz v1, +005h
    invoke-interface v1, v2, v3, Lkotlin/jvm/functions/Function2;->invoke(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final onViewCreated$lambda$6(com.bytedance.trae.conversation.chat.ConversationDetailFragment  java.lang.String)kotlin.Unit
    .registers 3
    # ins_size=2
    const-string v0, "messageId"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v1, v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->onCopyClick Lkotlin/jvm/functions/Function1;
    if-eqz v1, +005h
    invoke-interface v1, v2, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final onViewCreated$lambda$7(com.bytedance.trae.conversation.chat.ConversationDetailFragment  java.lang.String  java.lang.String)kotlin.Unit
    .registers 4
    # ins_size=3
    const-string v0, "messageId"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "content"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v1, v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->onReportClick Lkotlin/jvm/functions/Function2;
    if-eqz v1, +005h
    invoke-interface v1, v2, v3, Lkotlin/jvm/functions/Function2;->invoke(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final onViewCreated$lambda$8(com.bytedance.trae.conversation.chat.ConversationDetailFragment  java.lang.String)kotlin.Unit
    .registers 3
    # ins_size=2
    const-string v0, "conversationId"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v1, v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->onUpgradeReminderClick Lkotlin/jvm/functions/Function1;
    if-eqz v1, +005h
    invoke-interface v1, v2, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private final releasePureShowWidgetInlineViews()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->pureShowWidgetInlineViewRefs Ljava/util/List;
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +014h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/ref/WeakReference;
    invoke-virtual v1, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;
    if-eqz v1, -012h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->release()V
    goto -17h
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->pureShowWidgetInlineViewRefs Ljava/util/List;
    invoke-interface v0, Ljava/util/List;->clear()V
    return-void 
.end method

.method private final restoreVisibleAnchor(com.bytedance.trae.conversation.chat.ConversationDetailFragment$VisibleAnchor)void
    .registers 6
    # ins_size=2
    invoke-direct v4, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->getAdapter()Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->getCurrentList()Ljava/util/List;
    move-result-object v0
    const-string v1, "getCurrentList(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v0, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v0
    const/4 v1, 0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +01ah
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v5, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$VisibleAnchor;->getMessageId()Ljava/lang/String;
    move-result-object v3
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +003h
    goto +5h
    add-int/lit8 v1, v1, 1
    goto -1dh
    const/4 v1, -1
    if-gez v1, +003h
    return-void 
    iget-object v0, v4, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->rvMessages Landroidx/recyclerview/widget/RecyclerView;
    if-eqz v0, +00ah
    new-instance v2, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$$ExternalSyntheticLambda7;
    invoke-direct v2, v4, v1, v5, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$$ExternalSyntheticLambda7;-><init>(Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment; I Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$VisibleAnchor;)V
    invoke-virtual v0, v2, Landroidx/recyclerview/widget/RecyclerView;->post(Ljava/lang/Runnable;)Z
    return-void 
.end method

.method private static final restoreVisibleAnchor$lambda$26(com.bytedance.trae.conversation.chat.ConversationDetailFragment  int  com.bytedance.trae.conversation.chat.ConversationDetailFragment$VisibleAnchor)void
    .registers 4
    # ins_size=3
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->lm Landroidx/recyclerview/widget/LinearLayoutManager;
    if-eqz v0, +009h
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$VisibleAnchor;->getTopOffset()I
    move-result v3
    invoke-virtual v0, v2, v3, Landroidx/recyclerview/widget/LinearLayoutManager;->scrollToPositionWithOffset(I I)V
    invoke-direct v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->scheduleScrollToBottomVisibilityUpdate()V
    return-void 
.end method

.method private final scheduleScrollToBottomVisibilityUpdate()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->rvMessages Landroidx/recyclerview/widget/RecyclerView;
    if-eqz v0, +00ah
    new-instance v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$$ExternalSyntheticLambda11;
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$$ExternalSyntheticLambda11;-><init>(Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;)V
    invoke-virtual v0, v1, Landroidx/recyclerview/widget/RecyclerView;->post(Ljava/lang/Runnable;)Z
    return-void 
.end method

.method private static final scheduleScrollToBottomVisibilityUpdate$lambda$28(com.bytedance.trae.conversation.chat.ConversationDetailFragment)void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->rvMessages Landroidx/recyclerview/widget/RecyclerView;
    if-eqz v0, +00ah
    new-instance v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$$ExternalSyntheticLambda10;
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$$ExternalSyntheticLambda10;-><init>(Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;)V
    invoke-virtual v0, v1, Landroidx/recyclerview/widget/RecyclerView;->post(Ljava/lang/Runnable;)Z
    return-void 
.end method

.method private static final scheduleScrollToBottomVisibilityUpdate$lambda$28$lambda$27(com.bytedance.trae.conversation.chat.ConversationDetailFragment)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->updateScrollToBottomVisibility()V
    return-void 
.end method

.method private static final scrollToCreatedAt$lambda$18(com.bytedance.trae.conversation.chat.ConversationDetailFragment  int)void
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->lm Landroidx/recyclerview/widget/LinearLayoutManager;
    if-eqz v0, +007h
    const/16 v1, 96
    invoke-virtual v0, v3, v1, Landroidx/recyclerview/widget/LinearLayoutManager;->scrollToPositionWithOffset(I I)V
    invoke-direct v2, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->scheduleScrollToBottomVisibilityUpdate()V
    return-void 
.end method

.method private final showScrollToBottomWithBounce()void
    .registers 7
    # ins_size=1
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->btnScrollToBottom Landroid/widget/ImageView;
    if-nez v0, +003h
    return-void 
    invoke-virtual v0, Landroid/widget/ImageView;->getVisibility()I
    move-result v1
    if-nez v1, +003h
    return-void 
    const/4 v1, 0
    invoke-virtual v0, v1, Landroid/widget/ImageView;->setScaleX(F)V
    invoke-virtual v0, v1, Landroid/widget/ImageView;->setScaleY(F)V
    const/4 v1, 0
    invoke-virtual v0, v1, Landroid/widget/ImageView;->setVisibility(I)V
    const/4 v2, 2
    new-array v3, v2, [F
    fill-array-data v3, +000003ah
    const-string/jumbo v4, scaleX
    invoke-static v0, v4, v3, Landroid/animation/ObjectAnimator;->ofFloat(Ljava/lang/Object; Ljava/lang/String; [F)Landroid/animation/ObjectAnimator;
    move-result-object v3
    new-array v4, v2, [F
    fill-array-data v4, +0000036h
    const-string/jumbo v5, scaleY
    invoke-static v0, v5, v4, Landroid/animation/ObjectAnimator;->ofFloat(Ljava/lang/Object; Ljava/lang/String; [F)Landroid/animation/ObjectAnimator;
    move-result-object v0
    new-instance v4, Landroid/animation/AnimatorSet;
    invoke-direct v4, Landroid/animation/AnimatorSet;-><init>()V
    new-array v2, v2, [Landroid/animation/Animator;
    aput-object v3, v2, v1
    const/4 v1, 1
    aput-object v0, v2, v1
    invoke-virtual v4, v2, Landroid/animation/AnimatorSet;->playTogether([Landroid/animation/Animator;)V
    const-wide/16 v0, 300
    invoke-virtual v4, v0, v1, Landroid/animation/AnimatorSet;->setDuration(J)Landroid/animation/AnimatorSet;
    new-instance v0, Landroid/view/animation/OvershootInterpolator;
    const/high16 v1, 1069547520
    invoke-direct v0, v1, Landroid/view/animation/OvershootInterpolator;-><init>(F)V
    check-cast v0, Landroid/animation/TimeInterpolator;
    invoke-virtual v4, v0, Landroid/animation/AnimatorSet;->setInterpolator(Landroid/animation/TimeInterpolator;)V
    invoke-virtual v4, Landroid/animation/AnimatorSet;->start()V
    return-void 
    fill-array-data-payload b'\x00\x00\x00\x00\x00\x00\x80?' | \x00\x00\x00\x00\x00\x00\x80\x3f
    fill-array-data-payload b'\x00\x00\x00\x00\x00\x00\x80?' | \x00\x00\x00\x00\x00\x00\x80\x3f
.end method

.method public static synthetic submitMessages$default(com.bytedance.trae.conversation.chat.ConversationDetailFragment  java.util.List  boolean  kotlin.jvm.functions.Function0  int  java.lang.Object)void
    .registers 6
    # ins_size=6
    and-int/lit8 v5, v4, 2
    if-eqz v5, +003h
    const/4 v2, 0
    and-int/lit8 v4, v4, 4
    if-eqz v4, +003h
    const/4 v3, 0
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->submitMessages(Ljava/util/List; Z Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method

.method private static final submitMessages$lambda$14(com.bytedance.trae.conversation.chat.ConversationDetailFragment  com.bytedance.trae.conversation.chat.ConversationDetailFragment$VisibleAnchor  boolean  kotlin.jvm.functions.Function0  boolean)void
    .registers 6
    # ins_size=5
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->stickyBottomScroller Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;
    if-eqz v0, +005h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->onFirstSubmit()V
    if-eqz v2, +005h
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->restoreVisibleAnchor(Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$VisibleAnchor;)V
    if-eqz v3, +005h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->forceScrollToBottom()V
    invoke-direct v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->scheduleScrollToBottomVisibilityUpdate()V
    if-eqz v4, +005h
    invoke-interface v4, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    if-eqz v5, +00eh
    iget-object v2, v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->rvMessages Landroidx/recyclerview/widget/RecyclerView;
    if-eqz v2, +00ah
    new-instance v3, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$$ExternalSyntheticLambda0;
    invoke-direct v3, v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;)V
    invoke-virtual v2, v3, Landroidx/recyclerview/widget/RecyclerView;->post(Ljava/lang/Runnable;)Z
    return-void 
.end method

.method private static final submitMessages$lambda$14$lambda$13(com.bytedance.trae.conversation.chat.ConversationDetailFragment)void
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->stickyBottomScroller Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;
    if-eqz v0, +005h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->resumeDataChangeScroll()V
    return-void 
.end method

.method private final updateScrollToBottomVisibility()void
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->lm Landroidx/recyclerview/widget/LinearLayoutManager;
    if-nez v0, +003h
    return-void 
    invoke-virtual v0, Landroidx/recyclerview/widget/LinearLayoutManager;->getItemCount()I
    move-result v1
    iget-boolean v2, v4, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->isNewerPageLoadingVisible Z
    const/16 v3, 8
    if-eqz v2, +00ah
    iget-object v0, v4, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->btnScrollToBottom Landroid/widget/ImageView;
    if-eqz v0, +005h
    invoke-virtual v0, v3, Landroid/widget/ImageView;->setVisibility(I)V
    return-void 
    if-nez v1, +00ah
    iget-object v0, v4, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->btnScrollToBottom Landroid/widget/ImageView;
    if-eqz v0, +005h
    invoke-virtual v0, v3, Landroid/widget/ImageView;->setVisibility(I)V
    return-void 
    invoke-direct v4, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->getAdapter()Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->getCurrentList()Ljava/util/List;
    move-result-object v2
    invoke-interface v2, Ljava/util/List;->isEmpty()Z
    move-result v2
    if-eqz v2, +00ah
    iget-object v0, v4, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->btnScrollToBottom Landroid/widget/ImageView;
    if-eqz v0, +005h
    invoke-virtual v0, v3, Landroid/widget/ImageView;->setVisibility(I)V
    return-void 
    invoke-virtual v0, Landroidx/recyclerview/widget/LinearLayoutManager;->findLastVisibleItemPosition()I
    move-result v0
    add-int/lit8 v1, v1, -1
    if-lt v0, v1, +00ah
    iget-object v0, v4, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->btnScrollToBottom Landroid/widget/ImageView;
    if-eqz v0, +009h
    invoke-virtual v0, v3, Landroid/widget/ImageView;->setVisibility(I)V
    goto +4h
    invoke-direct v4, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->showScrollToBottomWithBounce()V
    return-void 
.end method

.method private final visibleAnchorForHistoryAppend(java.util.List)com.bytedance.trae.conversation.chat.ConversationDetailFragment$VisibleAnchor
    .registers 10
    # ins_size=2
    invoke-direct v8, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->getAdapter()Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->getCurrentList()Ljava/util/List;
    move-result-object v0
    const-string v1, "getCurrentList(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v0, Ljava/util/List;->isEmpty()Z
    move-result v1
    const/4 v2, 0
    if-nez v1, +0c7h
    invoke-interface v9, Ljava/util/List;->size()I
    move-result v1
    invoke-interface v0, Ljava/util/List;->size()I
    move-result v3
    if-gt v1, v3, +004h
    goto/16 +0bbh
    move-object v1, v0
    check-cast v1, Ljava/util/Collection;
    invoke-static v1, Lkotlin/collections/CollectionsKt;->getIndices(Ljava/util/Collection;)Lkotlin/ranges/IntRange;
    move-result-object v3
    check-cast v3, Ljava/lang/Iterable;
    instance-of v4, v3, Ljava/util/Collection;
    const/4 v5, 1
    const/4 v6, 0
    if-eqz v4, +00dh
    move-object v4, v3
    check-cast v4, Ljava/util/Collection;
    invoke-interface v4, Ljava/util/Collection;->isEmpty()Z
    move-result v4
    if-eqz v4, +004h
    move v3, v5
    goto +31h
    invoke-interface v3, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v3
    invoke-interface v3, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, -00ah
    move-object v4, v3
    check-cast v4, Lkotlin/collections/IntIterator;
    invoke-virtual v4, Lkotlin/collections/IntIterator;->nextInt()I
    move-result v4
    invoke-static v9, v4, Lkotlin/collections/CollectionsKt;->getOrNull(Ljava/util/List; I)Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    if-eqz v7, +007h
    invoke-virtual v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v7
    goto +2h
    move-object v7, v2
    invoke-interface v0, v4, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v4
    invoke-static v7, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, -029h
    move v3, v6
    if-nez v3, +003h
    return-object v2
    check-cast v9, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/util/List;->size()I
    move-result v3
    invoke-static v9, v3, Lkotlin/collections/CollectionsKt;->drop(Ljava/lang/Iterable; I)Ljava/util/List;
    move-result-object v9
    invoke-interface v9, Ljava/util/List;->isEmpty()Z
    move-result v3
    if-nez v3, +05eh
    check-cast v9, Ljava/lang/Iterable;
    instance-of v3, v9, Ljava/util/Collection;
    if-eqz v3, +00dh
    move-object v3, v9
    check-cast v3, Ljava/util/Collection;
    invoke-interface v3, Ljava/util/Collection;->isEmpty()Z
    move-result v3
    if-eqz v3, +004h
    move v9, v6
    goto +19h
    invoke-interface v9, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v9
    invoke-interface v9, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, -00ah
    invoke-interface v9, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isHistory()Z
    move-result v3
    xor-int/2addr v3, v5
    if-eqz v3, -011h
    move v9, v5
    if-eqz v9, +003h
    goto +31h
    iget-object v9, v8, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->lm Landroidx/recyclerview/widget/LinearLayoutManager;
    if-nez v9, +003h
    return-object v2
    invoke-virtual v9, Landroidx/recyclerview/widget/LinearLayoutManager;->findFirstVisibleItemPosition()I
    move-result v3
    if-ltz v3, +009h
    invoke-interface v1, Ljava/util/Collection;->size()I
    move-result v1
    if-ge v3, v1, +003h
    goto +2h
    move v5, v6
    if-nez v5, +003h
    return-object v2
    invoke-interface v0, v3, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v9, v3, Landroidx/recyclerview/widget/LinearLayoutManager;->findViewByPosition(I)Landroid/view/View;
    move-result-object v9
    if-eqz v9, +006h
    invoke-virtual v9, Landroid/view/View;->getTop()I
    move-result v6
    new-instance v9, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$VisibleAnchor;
    invoke-direct v9, v0, v6, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$VisibleAnchor;-><init>(Ljava/lang/String; I)V
    return-object v9
    return-object v2
.end method

.method private final visibleAnchorForPrepend(java.util.List)com.bytedance.trae.conversation.chat.ConversationDetailFragment$VisibleAnchor
    .registers 8
    # ins_size=2
    invoke-direct v6, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->getAdapter()Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->getCurrentList()Ljava/util/List;
    move-result-object v0
    const-string v1, "getCurrentList(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v0, Ljava/util/List;->isEmpty()Z
    move-result v1
    const/4 v2, 0
    if-nez v1, +071h
    invoke-interface v7, Ljava/util/List;->isEmpty()Z
    move-result v1
    if-eqz v1, +004h
    goto/16 +069h
    invoke-static v0, Lkotlin/collections/CollectionsKt;->firstOrNull(Ljava/util/List;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    if-eqz v1, +061h
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v1
    if-nez v1, +003h
    goto +59h
    invoke-interface v7, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v7
    const/4 v3, 0
    move v4, v3
    invoke-interface v7, Ljava/util/Iterator;->hasNext()Z
    move-result v5
    if-eqz v5, +016h
    invoke-interface v7, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v5
    invoke-static v5, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-eqz v5, +003h
    goto +5h
    add-int/lit8 v4, v4, 1
    goto -19h
    const/4 v4, -1
    if-gtz v4, +003h
    return-object v2
    iget-object v7, v6, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->lm Landroidx/recyclerview/widget/LinearLayoutManager;
    if-nez v7, +003h
    return-object v2
    invoke-virtual v7, Landroidx/recyclerview/widget/LinearLayoutManager;->findFirstVisibleItemPosition()I
    move-result v1
    if-ltz v1, +00dh
    move-object v4, v0
    check-cast v4, Ljava/util/Collection;
    invoke-interface v4, Ljava/util/Collection;->size()I
    move-result v4
    if-ge v1, v4, +004h
    const/4 v4, 1
    goto +2h
    move v4, v3
    if-nez v4, +003h
    return-object v2
    invoke-interface v0, v1, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v7, v1, Landroidx/recyclerview/widget/LinearLayoutManager;->findViewByPosition(I)Landroid/view/View;
    move-result-object v7
    if-eqz v7, +006h
    invoke-virtual v7, Landroid/view/View;->getTop()I
    move-result v3
    new-instance v7, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$VisibleAnchor;
    invoke-direct v7, v0, v3, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$VisibleAnchor;-><init>(Ljava/lang/String; I)V
    return-object v7
    return-object v2
.end method

.method public final forceScrollToBottom()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->stickyBottomScroller Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;
    if-eqz v0, +005h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->forceScrollToBottom()V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->btnScrollToBottom Landroid/widget/ImageView;
    if-eqz v0, +007h
    const/16 v1, 8
    invoke-virtual v0, v1, Landroid/widget/ImageView;->setVisibility(I)V
    return-void 
.end method

.method public final getLastMessage()com.bytedance.trae.im.model.ParsedChatMessage
    .registers 5
    # ins_size=1
    invoke-direct v4, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->getAdapter()Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->getCurrentList()Ljava/util/List;
    move-result-object v0
    const-string v1, "getCurrentList(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v0, Ljava/util/List;->size()I
    move-result v1
    invoke-interface v0, v1, Ljava/util/List;->listIterator(I)Ljava/util/ListIterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/ListIterator;->hasPrevious()Z
    move-result v1
    if-eqz v1, +01bh
    invoke-interface v0, Ljava/util/ListIterator;->previous()Ljava/lang/Object;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isAssistantMessage()Z
    move-result v3
    if-eqz v3, +00ah
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isHistory()Z
    move-result v2
    if-eqz v2, +004h
    const/4 v2, 1
    goto +2h
    const/4 v2, 0
    if-eqz v2, -01ch
    goto +2h
    const/4 v1, 0
    check-cast v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    return-object v1
.end method

.method public final getLm()androidx.recyclerview.widget.LinearLayoutManager
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->lm Landroidx/recyclerview/widget/LinearLayoutManager;
    return-object v0
.end method

.method public final getMessages()java.util.List
    .registers 3
    # ins_size=1
    invoke-direct v2, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->getAdapter()Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->getCurrentList()Ljava/util/List;
    move-result-object v0
    const-string v1, "getCurrentList(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v0
.end method

.method public final getOnCopyClick()kotlin.jvm.functions.Function1
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->onCopyClick Lkotlin/jvm/functions/Function1;
    return-object v0
.end method

.method public final getOnFeedbackClick()kotlin.jvm.functions.Function2
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->onFeedbackClick Lkotlin/jvm/functions/Function2;
    return-object v0
.end method

.method public final getOnJumpToBottomClick()kotlin.jvm.functions.Function0
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->onJumpToBottomClick Lkotlin/jvm/functions/Function0;
    return-object v0
.end method

.method public final getOnLoadMore()kotlin.jvm.functions.Function0
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->onLoadMore Lkotlin/jvm/functions/Function0;
    return-object v0
.end method

.method public final getOnLoadNewer()kotlin.jvm.functions.Function0
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->onLoadNewer Lkotlin/jvm/functions/Function0;
    return-object v0
.end method

.method public final getOnReportClick()kotlin.jvm.functions.Function2
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->onReportClick Lkotlin/jvm/functions/Function2;
    return-object v0
.end method

.method public final getOnRetryClick()kotlin.jvm.functions.Function1
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->onRetryClick Lkotlin/jvm/functions/Function1;
    return-object v0
.end method

.method public final getOnUpgradeReminderClick()kotlin.jvm.functions.Function1
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->onUpgradeReminderClick Lkotlin/jvm/functions/Function1;
    return-object v0
.end method

.method public final getOnUseExpressPassClick()kotlin.jvm.functions.Function1
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->onUseExpressPassClick Lkotlin/jvm/functions/Function1;
    return-object v0
.end method

.method public final getOnUserScrolled()kotlin.jvm.functions.Function0
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->onUserScrolled Lkotlin/jvm/functions/Function0;
    return-object v0
.end method

.method public onCreateView(android.view.LayoutInflater  android.view.ViewGroup  android.os.Bundle)android.view.View
    .registers 5
    # ins_size=4
    const-string v4, "inflater"
    invoke-static v2, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget v4, Lcom/bytedance/trae/conversation/R$layout;->trae_fragment_conversation_detail I
    const/4 v0, 0
    invoke-virtual v2, v4, v3, v0, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    const-string v3, "inflate(...)"
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v2
.end method

.method public onDestroyView()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->stickyBottomScroller Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;
    if-eqz v0, +00bh
    invoke-direct v2, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->getAdapter()Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;
    move-result-object v1
    check-cast v1, Landroidx/recyclerview/widget/RecyclerView$Adapter;
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->detach(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V
    const/4 v0, 0
    iput-object v0, v2, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->stickyBottomScroller Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;
    invoke-direct v2, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->releasePureShowWidgetInlineViews()V
    invoke-direct v2, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->getAdapter()Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;
    move-result-object v1
    invoke-virtual v1, v0, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->setOnPureShowWidgetInlineViewCreated$conversation_mainlandRelease(Lkotlin/jvm/functions/Function1;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->rvMessages Landroidx/recyclerview/widget/RecyclerView;
    if-eqz v1, +005h
    invoke-virtual v1, v0, Landroidx/recyclerview/widget/RecyclerView;->setAdapter(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V
    iput-object v0, v2, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->rvMessages Landroidx/recyclerview/widget/RecyclerView;
    iput-object v0, v2, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->btnScrollToBottom Landroid/widget/ImageView;
    iput-object v0, v2, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->olderPageLoading Lcom/bytedance/trae/common/widget/TraeLoadingView;
    iput-object v0, v2, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->newerPageLoading Lcom/bytedance/trae/common/widget/TraeLoadingView;
    invoke-super v2, Landroidx/fragment/app/Fragment;->onDestroyView()V
    return-void 
.end method

.method public onViewCreated(android.view.View  android.os.Bundle)void
    .registers 4
    # ins_size=3
    const-string/jumbo v0, view
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-super v1, v2, v3, Landroidx/fragment/app/Fragment;->onViewCreated(Landroid/view/View; Landroid/os/Bundle;)V
    sget v3, Lcom/bytedance/trae/conversation/R$id;->rv_messages I
    invoke-virtual v2, v3, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v3
    check-cast v3, Landroidx/recyclerview/widget/RecyclerView;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->rvMessages Landroidx/recyclerview/widget/RecyclerView;
    sget v3, Lcom/bytedance/trae/conversation/R$id;->btn_scroll_to_bottom I
    invoke-virtual v2, v3, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v3
    check-cast v3, Landroid/widget/ImageView;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->btnScrollToBottom Landroid/widget/ImageView;
    sget v3, Lcom/bytedance/trae/conversation/R$id;->progress_older_page_loading I
    invoke-virtual v2, v3, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/common/widget/TraeLoadingView;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->olderPageLoading Lcom/bytedance/trae/common/widget/TraeLoadingView;
    sget v3, Lcom/bytedance/trae/conversation/R$id;->progress_newer_page_loading I
    invoke-virtual v2, v3, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/common/widget/TraeLoadingView;
    iput-object v2, v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->newerPageLoading Lcom/bytedance/trae/common/widget/TraeLoadingView;
    invoke-direct v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->applyDirectionalLoadingVisibility()V
    new-instance v2, Landroidx/recyclerview/widget/LinearLayoutManager;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->requireContext()Landroid/content/Context;
    move-result-object v3
    invoke-direct v2, v3, Landroidx/recyclerview/widget/LinearLayoutManager;-><init>(Landroid/content/Context;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->lm Landroidx/recyclerview/widget/LinearLayoutManager;
    iget-object v2, v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->rvMessages Landroidx/recyclerview/widget/RecyclerView;
    if-eqz v2, +006h
    const/4 v3, 0
    invoke-virtual v2, v3, Landroidx/recyclerview/widget/RecyclerView;->setItemAnimator(Landroidx/recyclerview/widget/RecyclerView$ItemAnimator;)V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->lm Landroidx/recyclerview/widget/LinearLayoutManager;
    const/4 v3, 0
    if-eqz v2, +005h
    invoke-virtual v2, v3, Landroidx/recyclerview/widget/LinearLayoutManager;->setSmoothScrollbarEnabled(Z)V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->rvMessages Landroidx/recyclerview/widget/RecyclerView;
    if-eqz v2, +009h
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->lm Landroidx/recyclerview/widget/LinearLayoutManager;
    check-cast v0, Landroidx/recyclerview/widget/RecyclerView$LayoutManager;
    invoke-virtual v2, v0, Landroidx/recyclerview/widget/RecyclerView;->setLayoutManager(Landroidx/recyclerview/widget/RecyclerView$LayoutManager;)V
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->requireContext()Landroid/content/Context;
    move-result-object v2
    invoke-static v2, Landroid/view/ViewConfiguration;->get(Landroid/content/Context;)Landroid/view/ViewConfiguration;
    move-result-object v2
    invoke-virtual v2, Landroid/view/ViewConfiguration;->getScaledTouchSlop()I
    move-result v2
    iput v2, v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->touchSlop I
    iget-object v2, v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->rvMessages Landroidx/recyclerview/widget/RecyclerView;
    if-eqz v2, +005h
    invoke-virtual v2, v3, Landroidx/recyclerview/widget/RecyclerView;->setHasFixedSize(Z)V
    invoke-direct v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->getAdapter()Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;
    move-result-object v2
    new-instance v3, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$$ExternalSyntheticLambda13;
    invoke-direct v3, v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$$ExternalSyntheticLambda13;-><init>(Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;)V
    invoke-virtual v2, v3, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->setOnRetryClick(Lkotlin/jvm/functions/Function1;)V
    invoke-direct v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->getAdapter()Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;
    move-result-object v2
    new-instance v3, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$$ExternalSyntheticLambda14;
    invoke-direct v3, v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$$ExternalSyntheticLambda14;-><init>(Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;)V
    invoke-virtual v2, v3, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->setOnUseExpressPassClick(Lkotlin/jvm/functions/Function1;)V
    invoke-direct v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->getAdapter()Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;
    move-result-object v2
    new-instance v3, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$$ExternalSyntheticLambda15;
    invoke-direct v3, v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$$ExternalSyntheticLambda15;-><init>(Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;)V
    invoke-virtual v2, v3, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->setOnFeedbackClick(Lkotlin/jvm/functions/Function2;)V
    invoke-direct v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->getAdapter()Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;
    move-result-object v2
    new-instance v3, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$$ExternalSyntheticLambda16;
    invoke-direct v3, v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$$ExternalSyntheticLambda16;-><init>(Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;)V
    invoke-virtual v2, v3, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->setOnCopyClick(Lkotlin/jvm/functions/Function1;)V
    invoke-direct v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->getAdapter()Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;
    move-result-object v2
    new-instance v3, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$$ExternalSyntheticLambda1;
    invoke-direct v3, v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;)V
    invoke-virtual v2, v3, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->setOnReportClick(Lkotlin/jvm/functions/Function2;)V
    invoke-direct v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->getAdapter()Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;
    move-result-object v2
    new-instance v3, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$$ExternalSyntheticLambda2;
    invoke-direct v3, v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;)V
    invoke-virtual v2, v3, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->setOnUpgradeReminderClick(Lkotlin/jvm/functions/Function1;)V
    invoke-direct v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->getAdapter()Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;
    move-result-object v2
    iget-object v3, v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->onPureShowWidgetInlineViewCreated Lkotlin/jvm/functions/Function1;
    invoke-virtual v2, v3, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->setOnPureShowWidgetInlineViewCreated$conversation_mainlandRelease(Lkotlin/jvm/functions/Function1;)V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->rvMessages Landroidx/recyclerview/widget/RecyclerView;
    if-eqz v2, +00bh
    invoke-direct v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->getAdapter()Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;
    move-result-object v3
    check-cast v3, Landroidx/recyclerview/widget/RecyclerView$Adapter;
    invoke-virtual v2, v3, Landroidx/recyclerview/widget/RecyclerView;->setAdapter(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->rvMessages Landroidx/recyclerview/widget/RecyclerView;
    if-eqz v2, +023h
    new-instance v3, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->lm Landroidx/recyclerview/widget/LinearLayoutManager;
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v3, v2, v0, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;-><init>(Landroidx/recyclerview/widget/RecyclerView; Landroidx/recyclerview/widget/LinearLayoutManager;)V
    iput-object v3, v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->stickyBottomScroller Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;
    invoke-direct v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->getAdapter()Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;
    move-result-object v2
    check-cast v2, Landroidx/recyclerview/widget/RecyclerView$Adapter;
    invoke-virtual v3, v2, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->attach(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V
    invoke-direct v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->getAdapter()Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;
    move-result-object v2
    new-instance v3, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$$ExternalSyntheticLambda3;
    invoke-direct v3, v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$$ExternalSyntheticLambda3;-><init>(Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;)V
    invoke-virtual v2, v3, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->setOnContentChanged(Lkotlin/jvm/functions/Function0;)V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->rvMessages Landroidx/recyclerview/widget/RecyclerView;
    if-eqz v2, +00ch
    new-instance v3, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$onViewCreated$8;
    invoke-direct v3, v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$onViewCreated$8;-><init>(Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;)V
    check-cast v3, Landroidx/recyclerview/widget/RecyclerView$OnItemTouchListener;
    invoke-virtual v2, v3, Landroidx/recyclerview/widget/RecyclerView;->addOnItemTouchListener(Landroidx/recyclerview/widget/RecyclerView$OnItemTouchListener;)V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->rvMessages Landroidx/recyclerview/widget/RecyclerView;
    if-eqz v2, +00ch
    new-instance v3, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$onViewCreated$9;
    invoke-direct v3, v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$onViewCreated$9;-><init>(Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;)V
    check-cast v3, Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;
    invoke-virtual v2, v3, Landroidx/recyclerview/widget/RecyclerView;->addOnScrollListener(Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;)V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->btnScrollToBottom Landroid/widget/ImageView;
    if-eqz v2, +00ah
    new-instance v3, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$$ExternalSyntheticLambda4;
    invoke-direct v3, v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$$ExternalSyntheticLambda4;-><init>(Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;)V
    invoke-virtual v2, v3, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->fpsTracer Lcom/bytedance/apm/trace/fps/FpsTracer;
    iget-object v3, v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->rvMessages Landroidx/recyclerview/widget/RecyclerView;
    invoke-virtual v2, v3, Lcom/bytedance/apm/trace/fps/FpsTracer;->startRecyclerView(Landroidx/recyclerview/widget/RecyclerView;)V
    return-void 
.end method

.method public final refreshLatestAgentMessage()void
    .registers 3
    # ins_size=1
    invoke-direct v2, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->getAdapter()Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->getCurrentList()Ljava/util/List;
    move-result-object v0
    const-string v1, "getCurrentList(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v0, Ljava/util/List;->size()I
    move-result v1
    invoke-interface v0, v1, Ljava/util/List;->listIterator(I)Ljava/util/ListIterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/ListIterator;->hasPrevious()Z
    move-result v1
    if-eqz v1, +015h
    invoke-interface v0, Ljava/util/ListIterator;->previous()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isUserMessage()Z
    move-result v1
    xor-int/lit8 v1, v1, 1
    if-eqz v1, -012h
    invoke-interface v0, Ljava/util/ListIterator;->nextIndex()I
    move-result v0
    goto +2h
    const/4 v0, -1
    if-ltz v0, +009h
    invoke-direct v2, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->getAdapter()Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;
    move-result-object v1
    invoke-virtual v1, v0, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->notifyItemChanged(I)V
    return-void 
.end method

.method public final scrollToBottom()void
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->stickyBottomScroller Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;
    if-eqz v0, +005h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->scrollToBottom()V
    return-void 
.end method

.method public final scrollToCreatedAt(java.lang.String)boolean
    .registers 12
    # ins_size=2
    const-string v0, "anchorCreatedAtMs"
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v11, Lkotlin/text/StringsKt;->toLongOrNull(Ljava/lang/String;)Ljava/lang/Long;
    move-result-object v11
    const/4 v0, 0
    if-eqz v11, +093h
    invoke-virtual v11, Ljava/lang/Long;->longValue()J
    move-result-wide v1
    invoke-direct v10, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->getAdapter()Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;
    move-result-object v11
    invoke-virtual v11, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->getCurrentList()Ljava/util/List;
    move-result-object v11
    const-string v3, "getCurrentList(...)"
    invoke-static v11, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v11, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v11
    move v4, v0
    invoke-interface v11, Ljava/util/Iterator;->hasNext()Z
    move-result v5
    const/4 v6, -1
    const/4 v7, 1
    if-eqz v5, +019h
    invoke-interface v11, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getCreatedAt()J
    move-result-wide v8
    cmp-long v5, v8, v1
    if-ltz v5, +004h
    move v5, v7
    goto +2h
    move v5, v0
    if-eqz v5, +003h
    goto +5h
    add-int/lit8 v4, v4, 1
    goto -1eh
    move v4, v6
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v11
    move-object v4, v11
    check-cast v4, Ljava/lang/Number;
    invoke-virtual v4, Ljava/lang/Number;->intValue()I
    move-result v4
    if-ltz v4, +004h
    move v4, v7
    goto +2h
    move v4, v0
    if-eqz v4, +003h
    goto +2h
    const/4 v11, 0
    if-eqz v11, +007h
    invoke-virtual v11, Ljava/lang/Integer;->intValue()I
    move-result v6
    goto +31h
    invoke-direct v10, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->getAdapter()Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;
    move-result-object v11
    invoke-virtual v11, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->getCurrentList()Ljava/util/List;
    move-result-object v11
    invoke-static v11, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v11, Ljava/util/List;->size()I
    move-result v3
    invoke-interface v11, v3, Ljava/util/List;->listIterator(I)Ljava/util/ListIterator;
    move-result-object v11
    invoke-interface v11, Ljava/util/ListIterator;->hasPrevious()Z
    move-result v3
    if-eqz v3, +019h
    invoke-interface v11, Ljava/util/ListIterator;->previous()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getCreatedAt()J
    move-result-wide v3
    cmp-long v3, v3, v1
    if-gtz v3, +004h
    move v3, v7
    goto +2h
    move v3, v0
    if-eqz v3, -017h
    invoke-interface v11, Ljava/util/ListIterator;->nextIndex()I
    move-result v6
    if-gez v6, +003h
    return v0
    iget-object v11, v10, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->rvMessages Landroidx/recyclerview/widget/RecyclerView;
    if-eqz v11, +00ah
    new-instance v0, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$$ExternalSyntheticLambda5;
    invoke-direct v0, v10, v6, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$$ExternalSyntheticLambda5;-><init>(Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment; I)V
    invoke-virtual v11, v0, Landroidx/recyclerview/widget/RecyclerView;->post(Ljava/lang/Runnable;)Z
    return v7
    return v0
.end method

.method public final setAnchorLoading(boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->isAnchorLoadingVisible Z
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->applyAnchorLoadingVisibility()V
    return-void 
.end method

.method public final setConversation(com.bytedance.trae.im.service.Conversation)void
    .registers 3
    # ins_size=2
    const-string v0, "conversation"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->getAdapter()Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;
    move-result-object v0
    invoke-virtual v0, v2, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->setConversation(Lcom/bytedance/trae/im/service/Conversation;)V
    return-void 
.end method

.method public final setHasMore(boolean)void
    .registers 5
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string/jumbo v2, setHasMore: 
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    const-string v2, "ConversationDetailFragment"
    invoke-virtual v0, v2, v1, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    iput-boolean v4, v3, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->hasMoreOlderMessages Z
    return-void 
.end method

.method public final setLm(androidx.recyclerview.widget.LinearLayoutManager)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->lm Landroidx/recyclerview/widget/LinearLayoutManager;
    return-void 
.end method

.method public final setLoadingMore(boolean)void
    .registers 5
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string/jumbo v2, setLoadingMore: 
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    const-string v2, "ConversationDetailFragment"
    invoke-virtual v0, v2, v1, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    iput-boolean v4, v3, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->isOlderPageLoadingVisible Z
    invoke-direct v3, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->applyDirectionalLoadingVisibility()V
    return-void 
.end method

.method public final setLoadingNewer(boolean)void
    .registers 5
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string/jumbo v2, setLoadingNewer: 
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    const-string v2, "ConversationDetailFragment"
    invoke-virtual v0, v2, v1, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    iput-boolean v4, v3, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->isNewerPageLoadingVisible Z
    invoke-direct v3, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->applyDirectionalLoadingVisibility()V
    if-eqz v4, +00ch
    iget-object v4, v3, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->btnScrollToBottom Landroid/widget/ImageView;
    if-eqz v4, +00bh
    const/16 v0, 8
    invoke-virtual v4, v0, Landroid/widget/ImageView;->setVisibility(I)V
    goto +4h
    invoke-direct v3, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->updateScrollToBottomVisibility()V
    return-void 
.end method

.method public final setOnCopyClick(kotlin.jvm.functions.Function1)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->onCopyClick Lkotlin/jvm/functions/Function1;
    return-void 
.end method

.method public final setOnFeedbackClick(kotlin.jvm.functions.Function2)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->onFeedbackClick Lkotlin/jvm/functions/Function2;
    return-void 
.end method

.method public final setOnJumpToBottomClick(kotlin.jvm.functions.Function0)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->onJumpToBottomClick Lkotlin/jvm/functions/Function0;
    return-void 
.end method

.method public final setOnLoadMore(kotlin.jvm.functions.Function0)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->onLoadMore Lkotlin/jvm/functions/Function0;
    return-void 
.end method

.method public final setOnLoadNewer(kotlin.jvm.functions.Function0)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->onLoadNewer Lkotlin/jvm/functions/Function0;
    return-void 
.end method

.method public final setOnReportClick(kotlin.jvm.functions.Function2)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->onReportClick Lkotlin/jvm/functions/Function2;
    return-void 
.end method

.method public final setOnRetryClick(kotlin.jvm.functions.Function1)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->onRetryClick Lkotlin/jvm/functions/Function1;
    return-void 
.end method

.method public final setOnUpgradeReminderClick(kotlin.jvm.functions.Function1)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->onUpgradeReminderClick Lkotlin/jvm/functions/Function1;
    return-void 
.end method

.method public final setOnUseExpressPassClick(kotlin.jvm.functions.Function1)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->onUseExpressPassClick Lkotlin/jvm/functions/Function1;
    return-void 
.end method

.method public final setOnUserScrolled(kotlin.jvm.functions.Function0)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->onUserScrolled Lkotlin/jvm/functions/Function0;
    return-void 
.end method

.method public final setTask()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->lm Landroidx/recyclerview/widget/LinearLayoutManager;
    if-eqz v0, +006h
    const/4 v1, 1
    invoke-virtual v0, v1, Landroidx/recyclerview/widget/LinearLayoutManager;->setSmoothScrollbarEnabled(Z)V
    return-void 
.end method

.method public final setUpgradeReminder(java.lang.String  boolean)void
    .registers 4
    # ins_size=3
    invoke-direct v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->getAdapter()Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;
    move-result-object v0
    invoke-virtual v0, v2, v3, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->setUpgradeReminder(Ljava/lang/String; Z)V
    return-void 
.end method

.method public final submitMessages(java.util.List  boolean  kotlin.jvm.functions.Function0)void
    .registers 12
    # ins_size=4
    const-string v0, "messages"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v9, Ljava/util/List;->isEmpty()Z
    move-result v0
    if-eqz v0, +009h
    iget-object v0, v8, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->stickyBottomScroller Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;
    if-eqz v0, +005h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->resetFirstSubmit()V
    const/4 v0, 0
    if-eqz v10, +004h
    move-object v1, v0
    goto +5h
    invoke-direct v8, v9, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->visibleAnchorForHistoryAppend(Ljava/util/List;)Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$VisibleAnchor;
    move-result-object v1
    if-eqz v10, +003h
    goto +9h
    invoke-direct v8, v9, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->visibleAnchorForPrepend(Ljava/util/List;)Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$VisibleAnchor;
    move-result-object v0
    if-nez v0, +004h
    move-object v4, v1
    goto +2h
    move-object v4, v0
    if-nez v1, +007h
    if-eqz v10, +003h
    goto +3h
    const/4 v0, 0
    goto +2h
    const/4 v0, 1
    move v7, v0
    if-eqz v7, +009h
    iget-object v0, v8, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->stickyBottomScroller Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;
    if-eqz v0, +005h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->suppressDataChangeScroll()V
    invoke-direct v8, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;->getAdapter()Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$$ExternalSyntheticLambda12;
    move-object v2, v1
    move-object v3, v8
    move v5, v10
    move-object v6, v11
    invoke-direct/range v2 ... v7, Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$$ExternalSyntheticLambda12;-><init>(Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment; Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$VisibleAnchor; Z Lkotlin/jvm/functions/Function0; Z)V
    invoke-virtual v0, v9, v1, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->submitMessages(Ljava/util/List; Ljava/lang/Runnable;)V
    return-void 
.end method
