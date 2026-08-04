# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;
.super Ljava/lang/Object;
.source "StickyBottomScroller.kt"

.field private final dataObserver:Lcom/bytedance/trae/conversation/chat/StickyBottomScroller$dataObserver$1;
.field private hasHandledFirstSubmit:Z
.field private isDataChangeScrollSuppressed:Z
.field private isStickToBottom:Z
.field private isUserScrolling:Z
.field private lastRecyclerHeight:I
.field private final layoutChangeListener:Landroid/view/View$OnLayoutChangeListener;
.field private final layoutManager:Landroidx/recyclerview/widget/LinearLayoutManager;
.field private pendingScroll:Z
.field private final recyclerView:Landroidx/recyclerview/widget/RecyclerView;
.field private final scrollListener:Lcom/bytedance/trae/conversation/chat/StickyBottomScroller$scrollListener$1;


.method public static synthetic $r8$lambda$3AQhWpA3NyUqW_88Y4Gg8EUYQ-M(com.bytedance.trae.conversation.chat.StickyBottomScroller)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->layoutChangeListener$lambda$2$lambda$0(Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$Dkz7Ngu1B1MdaeTYBK4ZBIdJN1c(com.bytedance.trae.conversation.chat.StickyBottomScroller)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->layoutChangeListener$lambda$2$lambda$1(Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$NUSYP0jBlCAs6xSxpTfbR3Njvz8(com.bytedance.trae.conversation.chat.StickyBottomScroller)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->forceScrollToBottom$lambda$8(Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$VUYqt_kqoSpwPw5otIySE1KjJKc(com.bytedance.trae.conversation.chat.StickyBottomScroller)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->onItemContentChanged$lambda$9(Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$_GT4jWMi9QtdDCwZ4VB1FMQD0C0(com.bytedance.trae.conversation.chat.StickyBottomScroller)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->scrollToBottom$lambda$7(Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$fgoAgKsLv8ByJ-HFgydyFC95JLM(com.bytedance.trae.conversation.chat.StickyBottomScroller)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->scrollToBottom$lambda$7$lambda$6(Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$nHn2NP0MQrCKLmZpcvtXQ_X0-g0(com.bytedance.trae.conversation.chat.StickyBottomScroller  int)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->scrollToBottomWithoutAnimation$lambda$5(Lcom/bytedance/trae/conversation/chat/StickyBottomScroller; I)V
    return-void 
.end method

.method public static synthetic $r8$lambda$oCCcATV2be4mlXBulncy-rUvQtE(com.bytedance.trae.conversation.chat.StickyBottomScroller)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->handleDataChanged$lambda$4(Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$pSDvODP5ABlBb4WSrVSgKW8diKU(com.bytedance.trae.conversation.chat.StickyBottomScroller  android.view.View  int  int  int  int  int  int  int  int)void
    .registers 10
    # ins_size=10
    invoke-static/range v0 ... v9, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->layoutChangeListener$lambda$2(Lcom/bytedance/trae/conversation/chat/StickyBottomScroller; Landroid/view/View; I I I I I I I I)V
    return-void 
.end method

.method public static synthetic $r8$lambda$rv6hBIRAYWBo0JlgcXuNZUPxSeA(com.bytedance.trae.conversation.chat.StickyBottomScroller)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->onFirstSubmit$lambda$3(Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;)V
    return-void 
.end method

.method public constructor <init>(androidx.recyclerview.widget.RecyclerView  androidx.recyclerview.widget.LinearLayoutManager)void
    .registers 4
    # ins_size=3
    const-string v0, "recyclerView"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "layoutManager"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->recyclerView Landroidx/recyclerview/widget/RecyclerView;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->layoutManager Landroidx/recyclerview/widget/LinearLayoutManager;
    const/4 v2, 1
    iput-boolean v2, v1, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->isStickToBottom Z
    new-instance v2, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller$scrollListener$1;
    invoke-direct v2, v1, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller$scrollListener$1;-><init>(Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->scrollListener Lcom/bytedance/trae/conversation/chat/StickyBottomScroller$scrollListener$1;
    new-instance v2, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller$$ExternalSyntheticLambda0;
    invoke-direct v2, v1, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->layoutChangeListener Landroid/view/View$OnLayoutChangeListener;
    new-instance v2, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller$dataObserver$1;
    invoke-direct v2, v1, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller$dataObserver$1;-><init>(Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->dataObserver Lcom/bytedance/trae/conversation/chat/StickyBottomScroller$dataObserver$1;
    return-void 
.end method

.method public static final synthetic access$handleDataChanged(com.bytedance.trae.conversation.chat.StickyBottomScroller)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->handleDataChanged()V
    return-void 
.end method

.method public static final synthetic access$isAtBottom(com.bytedance.trae.conversation.chat.StickyBottomScroller)boolean
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->isAtBottom()Z
    move-result v0
    return v0
.end method

.method public static final synthetic access$isUserScrolling$p(com.bytedance.trae.conversation.chat.StickyBottomScroller)boolean
    .registers 1
    # ins_size=1
    iget-boolean v0, v0, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->isUserScrolling Z
    return v0
.end method

.method public static final synthetic access$setStickToBottom$p(com.bytedance.trae.conversation.chat.StickyBottomScroller  boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->isStickToBottom Z
    return-void 
.end method

.method public static final synthetic access$setUserScrolling$p(com.bytedance.trae.conversation.chat.StickyBottomScroller  boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->isUserScrolling Z
    return-void 
.end method

.method private static final forceScrollToBottom$lambda$8(com.bytedance.trae.conversation.chat.StickyBottomScroller)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->scrollToBottomWithoutAnimation()V
    return-void 
.end method

.method private final handleDataChanged()void
    .registers 3
    # ins_size=1
    iget-boolean v0, v2, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->isDataChangeScrollSuppressed Z
    if-eqz v0, +003h
    return-void 
    iget-boolean v0, v2, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->isStickToBottom Z
    if-eqz v0, +019h
    iget-boolean v0, v2, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->isUserScrolling Z
    if-eqz v0, +003h
    goto +13h
    iget-boolean v0, v2, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->pendingScroll Z
    if-eqz v0, +003h
    return-void 
    const/4 v0, 1
    iput-boolean v0, v2, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->pendingScroll Z
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->recyclerView Landroidx/recyclerview/widget/RecyclerView;
    new-instance v1, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller$$ExternalSyntheticLambda2;
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;)V
    invoke-virtual v0, v1, Landroidx/recyclerview/widget/RecyclerView;->post(Ljava/lang/Runnable;)Z
    return-void 
.end method

.method private static final handleDataChanged$lambda$4(com.bytedance.trae.conversation.chat.StickyBottomScroller)void
    .registers 4
    # ins_size=1
    const/4 v0, 0
    iput-boolean v0, v3, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->pendingScroll Z
    iget-boolean v1, v3, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->isStickToBottom Z
    if-eqz v1, +00ch
    iget-boolean v1, v3, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->isUserScrolling Z
    if-eqz v1, +003h
    goto +6h
    const/4 v1, 1
    const/4 v2, 0
    invoke-static v3, v0, v1, v2, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->scrollToBottomIfNeeded$default(Lcom/bytedance/trae/conversation/chat/StickyBottomScroller; Z I Ljava/lang/Object;)V
    return-void 
.end method

.method private final isAtBottom()boolean
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->layoutManager Landroidx/recyclerview/widget/LinearLayoutManager;
    invoke-virtual v0, Landroidx/recyclerview/widget/LinearLayoutManager;->getItemCount()I
    move-result v0
    const/4 v1, 1
    if-nez v0, +003h
    return v1
    iget-object v2, v3, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->layoutManager Landroidx/recyclerview/widget/LinearLayoutManager;
    invoke-virtual v2, Landroidx/recyclerview/widget/LinearLayoutManager;->findLastCompletelyVisibleItemPosition()I
    move-result v2
    sub-int/2addr v0, v1
    if-lt v2, v0, +003h
    goto +2h
    const/4 v1, 0
    return v1
.end method

.method private final isContentOverflow()boolean
    .registers 6
    # ins_size=1
    iget-object v0, v5, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->layoutManager Landroidx/recyclerview/widget/LinearLayoutManager;
    invoke-virtual v0, Landroidx/recyclerview/widget/LinearLayoutManager;->getItemCount()I
    move-result v0
    const/4 v1, 1
    sub-int/2addr v0, v1
    const/4 v2, 0
    if-gez v0, +003h
    return v2
    iget-object v3, v5, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->layoutManager Landroidx/recyclerview/widget/LinearLayoutManager;
    invoke-virtual v3, v0, Landroidx/recyclerview/widget/LinearLayoutManager;->findViewByPosition(I)Landroid/view/View;
    move-result-object v3
    if-eqz v3, +018h
    invoke-virtual v3, Landroid/view/View;->getBottom()I
    move-result v0
    iget-object v3, v5, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->recyclerView Landroidx/recyclerview/widget/RecyclerView;
    invoke-virtual v3, Landroidx/recyclerview/widget/RecyclerView;->getHeight()I
    move-result v3
    iget-object v4, v5, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->recyclerView Landroidx/recyclerview/widget/RecyclerView;
    invoke-virtual v4, Landroidx/recyclerview/widget/RecyclerView;->getPaddingBottom()I
    move-result v4
    sub-int/2addr v3, v4
    if-le v0, v3, +003h
    goto +2h
    move v1, v2
    return v1
    iget-object v3, v5, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->layoutManager Landroidx/recyclerview/widget/LinearLayoutManager;
    invoke-virtual v3, Landroidx/recyclerview/widget/LinearLayoutManager;->findLastVisibleItemPosition()I
    move-result v3
    if-ge v3, v0, +003h
    goto +2h
    move v1, v2
    return v1
.end method

.method private static final layoutChangeListener$lambda$2(com.bytedance.trae.conversation.chat.StickyBottomScroller  android.view.View  int  int  int  int  int  int  int  int)void
    .registers 10
    # ins_size=10
    sub-int/2addr v5, v3
    sub-int/2addr v9, v7
    if-lez v9, +012h
    if-ge v5, v9, +010h
    const/4 v1, 1
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->isStickToBottom Z
    iget-object v1, v0, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->recyclerView Landroidx/recyclerview/widget/RecyclerView;
    new-instance v2, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller$$ExternalSyntheticLambda4;
    invoke-direct v2, v0, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller$$ExternalSyntheticLambda4;-><init>(Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;)V
    invoke-virtual v1, v2, Landroidx/recyclerview/widget/RecyclerView;->post(Ljava/lang/Runnable;)Z
    goto +13h
    if-lez v9, +012h
    if-eq v5, v9, +010h
    iget-boolean v1, v0, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->isStickToBottom Z
    if-eqz v1, +00ch
    iget-object v1, v0, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->recyclerView Landroidx/recyclerview/widget/RecyclerView;
    new-instance v2, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller$$ExternalSyntheticLambda5;
    invoke-direct v2, v0, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller$$ExternalSyntheticLambda5;-><init>(Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;)V
    invoke-virtual v1, v2, Landroidx/recyclerview/widget/RecyclerView;->post(Ljava/lang/Runnable;)Z
    iput v5, v0, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->lastRecyclerHeight I
    return-void 
.end method

.method private static final layoutChangeListener$lambda$2$lambda$0(com.bytedance.trae.conversation.chat.StickyBottomScroller)void
    .registers 2
    # ins_size=1
    const/4 v0, 0
    invoke-direct v1, v0, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->scrollToBottomIfNeeded(Z)V
    return-void 
.end method

.method private static final layoutChangeListener$lambda$2$lambda$1(com.bytedance.trae.conversation.chat.StickyBottomScroller)void
    .registers 2
    # ins_size=1
    const/4 v0, 0
    invoke-direct v1, v0, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->scrollToBottomIfNeeded(Z)V
    return-void 
.end method

.method private static final onFirstSubmit$lambda$3(com.bytedance.trae.conversation.chat.StickyBottomScroller)void
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->hasHandledFirstSubmit Z
    if-eqz v0, +003h
    return-void 
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->layoutManager Landroidx/recyclerview/widget/LinearLayoutManager;
    invoke-virtual v0, Landroidx/recyclerview/widget/LinearLayoutManager;->getItemCount()I
    move-result v0
    if-nez v0, +003h
    return-void 
    const/4 v0, 1
    iput-boolean v0, v1, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->hasHandledFirstSubmit Z
    invoke-direct v1, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->isContentOverflow()Z
    move-result v0
    if-eqz v0, +005h
    invoke-direct v1, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->scrollToBottomWithoutAnimation()V
    return-void 
.end method

.method private static final onItemContentChanged$lambda$9(com.bytedance.trae.conversation.chat.StickyBottomScroller)void
    .registers 4
    # ins_size=1
    const/4 v0, 0
    iput-boolean v0, v3, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->pendingScroll Z
    iget-boolean v1, v3, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->isStickToBottom Z
    if-eqz v1, +00ch
    iget-boolean v1, v3, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->isUserScrolling Z
    if-eqz v1, +003h
    goto +6h
    const/4 v1, 1
    const/4 v2, 0
    invoke-static v3, v0, v1, v2, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->scrollToBottomIfNeeded$default(Lcom/bytedance/trae/conversation/chat/StickyBottomScroller; Z I Ljava/lang/Object;)V
    return-void 
.end method

.method private static final scrollToBottom$lambda$7(com.bytedance.trae.conversation.chat.StickyBottomScroller)void
    .registers 4
    # ins_size=1
    const/4 v0, 1
    const/4 v1, 0
    const/4 v2, 0
    invoke-static v3, v2, v0, v1, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->scrollToBottomIfNeeded$default(Lcom/bytedance/trae/conversation/chat/StickyBottomScroller; Z I Ljava/lang/Object;)V
    iget-object v0, v3, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->recyclerView Landroidx/recyclerview/widget/RecyclerView;
    new-instance v1, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller$$ExternalSyntheticLambda3;
    invoke-direct v1, v3, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller$$ExternalSyntheticLambda3;-><init>(Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;)V
    invoke-virtual v0, v1, Landroidx/recyclerview/widget/RecyclerView;->post(Ljava/lang/Runnable;)Z
    return-void 
.end method

.method private static final scrollToBottom$lambda$7$lambda$6(com.bytedance.trae.conversation.chat.StickyBottomScroller)void
    .registers 4
    # ins_size=1
    const/4 v0, 1
    const/4 v1, 0
    const/4 v2, 0
    invoke-static v3, v2, v0, v1, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->scrollToBottomIfNeeded$default(Lcom/bytedance/trae/conversation/chat/StickyBottomScroller; Z I Ljava/lang/Object;)V
    return-void 
.end method

.method private final scrollToBottomIfNeeded(boolean)void
    .registers 5
    # ins_size=2
    iget-object v0, v3, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->layoutManager Landroidx/recyclerview/widget/LinearLayoutManager;
    invoke-virtual v0, Landroidx/recyclerview/widget/LinearLayoutManager;->getItemCount()I
    move-result v0
    add-int/lit8 v0, v0, -1
    if-gez v0, +003h
    return-void 
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->layoutManager Landroidx/recyclerview/widget/LinearLayoutManager;
    invoke-virtual v1, v0, Landroidx/recyclerview/widget/LinearLayoutManager;->findViewByPosition(I)Landroid/view/View;
    move-result-object v0
    if-eqz v0, +025h
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->recyclerView Landroidx/recyclerview/widget/RecyclerView;
    invoke-virtual v1, Landroidx/recyclerview/widget/RecyclerView;->getHeight()I
    move-result v1
    iget-object v2, v3, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->recyclerView Landroidx/recyclerview/widget/RecyclerView;
    invoke-virtual v2, Landroidx/recyclerview/widget/RecyclerView;->getPaddingBottom()I
    move-result v2
    sub-int/2addr v1, v2
    invoke-virtual v0, Landroid/view/View;->getBottom()I
    move-result v0
    sub-int/2addr v0, v1
    if-lez v0, +014h
    const/4 v1, 0
    if-eqz v4, +008h
    iget-object v4, v3, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->recyclerView Landroidx/recyclerview/widget/RecyclerView;
    invoke-virtual v4, v1, v0, Landroidx/recyclerview/widget/RecyclerView;->smoothScrollBy(I I)V
    goto +ah
    iget-object v4, v3, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->recyclerView Landroidx/recyclerview/widget/RecyclerView;
    invoke-virtual v4, v1, v0, Landroidx/recyclerview/widget/RecyclerView;->scrollBy(I I)V
    goto +4h
    invoke-direct v3, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->scrollToBottomWithoutAnimation()V
    return-void 
.end method

.method static synthetic scrollToBottomIfNeeded$default(com.bytedance.trae.conversation.chat.StickyBottomScroller  boolean  int  java.lang.Object)void
    .registers 4
    # ins_size=4
    and-int/lit8 v2, v2, 1
    if-eqz v2, +008h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->layoutManager Landroidx/recyclerview/widget/LinearLayoutManager;
    invoke-virtual v1, Landroidx/recyclerview/widget/LinearLayoutManager;->isSmoothScrollbarEnabled()Z
    move-result v1
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->scrollToBottomIfNeeded(Z)V
    return-void 
.end method

.method private final scrollToBottomWithoutAnimation()void
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->layoutManager Landroidx/recyclerview/widget/LinearLayoutManager;
    invoke-virtual v0, Landroidx/recyclerview/widget/LinearLayoutManager;->getItemCount()I
    move-result v0
    if-nez v0, +003h
    return-void 
    add-int/lit8 v0, v0, -1
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->layoutManager Landroidx/recyclerview/widget/LinearLayoutManager;
    const/high16 v2, -2147483648
    invoke-virtual v1, v0, v2, Landroidx/recyclerview/widget/LinearLayoutManager;->scrollToPositionWithOffset(I I)V
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->recyclerView Landroidx/recyclerview/widget/RecyclerView;
    new-instance v2, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller$$ExternalSyntheticLambda9;
    invoke-direct v2, v3, v0, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller$$ExternalSyntheticLambda9;-><init>(Lcom/bytedance/trae/conversation/chat/StickyBottomScroller; I)V
    invoke-virtual v1, v2, Landroidx/recyclerview/widget/RecyclerView;->post(Ljava/lang/Runnable;)Z
    return-void 
.end method

.method private static final scrollToBottomWithoutAnimation$lambda$5(com.bytedance.trae.conversation.chat.StickyBottomScroller  int)void
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->layoutManager Landroidx/recyclerview/widget/LinearLayoutManager;
    invoke-virtual v0, v3, Landroidx/recyclerview/widget/LinearLayoutManager;->findViewByPosition(I)Landroid/view/View;
    move-result-object v3
    if-nez v3, +003h
    return-void 
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->recyclerView Landroidx/recyclerview/widget/RecyclerView;
    invoke-virtual v0, Landroidx/recyclerview/widget/RecyclerView;->getHeight()I
    move-result v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->recyclerView Landroidx/recyclerview/widget/RecyclerView;
    invoke-virtual v1, Landroidx/recyclerview/widget/RecyclerView;->getPaddingBottom()I
    move-result v1
    sub-int/2addr v0, v1
    invoke-virtual v3, Landroid/view/View;->getBottom()I
    move-result v3
    sub-int/2addr v3, v0
    if-lez v3, +008h
    iget-object v2, v2, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->recyclerView Landroidx/recyclerview/widget/RecyclerView;
    const/4 v0, 0
    invoke-virtual v2, v0, v3, Landroidx/recyclerview/widget/RecyclerView;->scrollBy(I I)V
    return-void 
.end method

.method public final attach(androidx.recyclerview.widget.RecyclerView$Adapter)void
    .registers 4
    # ins_size=2
    const-string v0, "adapter"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->recyclerView Landroidx/recyclerview/widget/RecyclerView;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->scrollListener Lcom/bytedance/trae/conversation/chat/StickyBottomScroller$scrollListener$1;
    check-cast v1, Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;
    invoke-virtual v0, v1, Landroidx/recyclerview/widget/RecyclerView;->addOnScrollListener(Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;)V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->recyclerView Landroidx/recyclerview/widget/RecyclerView;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->layoutChangeListener Landroid/view/View$OnLayoutChangeListener;
    invoke-virtual v0, v1, Landroidx/recyclerview/widget/RecyclerView;->addOnLayoutChangeListener(Landroid/view/View$OnLayoutChangeListener;)V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->dataObserver Lcom/bytedance/trae/conversation/chat/StickyBottomScroller$dataObserver$1;
    check-cast v0, Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;
    invoke-virtual v3, v0, Landroidx/recyclerview/widget/RecyclerView$Adapter;->registerAdapterDataObserver(Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;)V
    return-void 
.end method

.method public final detach(androidx.recyclerview.widget.RecyclerView$Adapter)void
    .registers 4
    # ins_size=2
    const-string v0, "adapter"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->recyclerView Landroidx/recyclerview/widget/RecyclerView;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->scrollListener Lcom/bytedance/trae/conversation/chat/StickyBottomScroller$scrollListener$1;
    check-cast v1, Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;
    invoke-virtual v0, v1, Landroidx/recyclerview/widget/RecyclerView;->removeOnScrollListener(Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;)V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->recyclerView Landroidx/recyclerview/widget/RecyclerView;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->layoutChangeListener Landroid/view/View$OnLayoutChangeListener;
    invoke-virtual v0, v1, Landroidx/recyclerview/widget/RecyclerView;->removeOnLayoutChangeListener(Landroid/view/View$OnLayoutChangeListener;)V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->dataObserver Lcom/bytedance/trae/conversation/chat/StickyBottomScroller$dataObserver$1;
    check-cast v0, Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;
    invoke-virtual v3, v0, Landroidx/recyclerview/widget/RecyclerView$Adapter;->unregisterAdapterDataObserver(Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;)V
    return-void 
.end method

.method public final forceScrollToBottom()void
    .registers 3
    # ins_size=1
    const/4 v0, 1
    iput-boolean v0, v2, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->isStickToBottom Z
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->recyclerView Landroidx/recyclerview/widget/RecyclerView;
    new-instance v1, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller$$ExternalSyntheticLambda1;
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;)V
    invoke-virtual v0, v1, Landroidx/recyclerview/widget/RecyclerView;->post(Ljava/lang/Runnable;)Z
    return-void 
.end method

.method public final onFirstSubmit()void
    .registers 3
    # ins_size=1
    iget-boolean v0, v2, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->hasHandledFirstSubmit Z
    if-eqz v0, +003h
    return-void 
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->recyclerView Landroidx/recyclerview/widget/RecyclerView;
    new-instance v1, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller$$ExternalSyntheticLambda7;
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller$$ExternalSyntheticLambda7;-><init>(Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;)V
    invoke-virtual v0, v1, Landroidx/recyclerview/widget/RecyclerView;->post(Ljava/lang/Runnable;)Z
    return-void 
.end method

.method public final onItemContentChanged()void
    .registers 3
    # ins_size=1
    iget-boolean v0, v2, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->isStickToBottom Z
    if-eqz v0, +019h
    iget-boolean v0, v2, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->isUserScrolling Z
    if-eqz v0, +003h
    goto +13h
    iget-boolean v0, v2, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->pendingScroll Z
    if-eqz v0, +003h
    return-void 
    const/4 v0, 1
    iput-boolean v0, v2, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->pendingScroll Z
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->recyclerView Landroidx/recyclerview/widget/RecyclerView;
    new-instance v1, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller$$ExternalSyntheticLambda6;
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller$$ExternalSyntheticLambda6;-><init>(Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;)V
    invoke-virtual v0, v1, Landroidx/recyclerview/widget/RecyclerView;->post(Ljava/lang/Runnable;)Z
    return-void 
.end method

.method public final resetFirstSubmit()void
    .registers 2
    # ins_size=1
    const/4 v0, 0
    iput-boolean v0, v1, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->hasHandledFirstSubmit Z
    const/4 v0, 1
    iput-boolean v0, v1, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->isStickToBottom Z
    return-void 
.end method

.method public final resumeDataChangeScroll()void
    .registers 2
    # ins_size=1
    const/4 v0, 0
    iput-boolean v0, v1, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->isDataChangeScrollSuppressed Z
    return-void 
.end method

.method public final scrollToBottom()void
    .registers 3
    # ins_size=1
    invoke-direct v2, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->isAtBottom()Z
    move-result v0
    if-eqz v0, +00fh
    const/4 v0, 1
    iput-boolean v0, v2, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->isStickToBottom Z
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->recyclerView Landroidx/recyclerview/widget/RecyclerView;
    new-instance v1, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller$$ExternalSyntheticLambda8;
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller$$ExternalSyntheticLambda8;-><init>(Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;)V
    invoke-virtual v0, v1, Landroidx/recyclerview/widget/RecyclerView;->post(Ljava/lang/Runnable;)Z
    return-void 
.end method

.method public final suppressDataChangeScroll()void
    .registers 2
    # ins_size=1
    const/4 v0, 1
    iput-boolean v0, v1, Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;->isDataChangeScrollSuppressed Z
    return-void 
.end method
