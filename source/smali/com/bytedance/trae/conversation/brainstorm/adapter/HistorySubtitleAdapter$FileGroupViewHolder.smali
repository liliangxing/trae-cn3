# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$FileGroupViewHolder;
.super Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
.source "HistorySubtitleAdapter.kt"

.field public static final Companion:Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$FileGroupViewHolder$Companion;
.field private static final ROW_ITEM_SPACING_DP:I
.field private final childAdapter:Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormFileRowAdapter;
.field private lastCount:I
.field private final rowView:Landroidx/recyclerview/widget/RecyclerView;


.method public static synthetic $r8$lambda$n3cRJykfMksviEU-KhFgyqYes8c(boolean  java.util.List  com.bytedance.trae.conversation.brainstorm.adapter.HistorySubtitleAdapter$FileGroupViewHolder)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$FileGroupViewHolder;->bind$lambda$0(Z Ljava/util/List; Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$FileGroupViewHolder;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$FileGroupViewHolder$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$FileGroupViewHolder$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$FileGroupViewHolder;->Companion Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$FileGroupViewHolder$Companion;
    return-void 
.end method

.method public constructor <init>(android.widget.FrameLayout  com.bytedance.trae.conversation.brainstorm.adapter.HistorySubtitleAdapter$AttachmentCallback)void
    .registers 7
    # ins_size=3
    const-string v0, "container"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "callback"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v0, v5
    check-cast v0, Landroid/view/View;
    invoke-direct v4, v0, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;-><init>(Landroid/view/View;)V
    sget v0, Lcom/bytedance/trae/conversation/R$id;->rv_image_row I
    invoke-virtual v5, v0, Landroid/widget/FrameLayout;->findViewById(I)Landroid/view/View;
    move-result-object v0
    const-string v1, "findViewById(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroidx/recyclerview/widget/RecyclerView;
    iput-object v0, v4, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$FileGroupViewHolder;->rowView Landroidx/recyclerview/widget/RecyclerView;
    new-instance v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormFileRowAdapter;
    invoke-direct v1, v6, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormFileRowAdapter;-><init>(Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentCallback;)V
    iput-object v1, v4, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$FileGroupViewHolder;->childAdapter Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormFileRowAdapter;
    new-instance v6, Landroidx/recyclerview/widget/LinearLayoutManager;
    invoke-virtual v5, Landroid/widget/FrameLayout;->getContext()Landroid/content/Context;
    move-result-object v2
    const/4 v3, 0
    invoke-direct v6, v2, v3, v3, Landroidx/recyclerview/widget/LinearLayoutManager;-><init>(Landroid/content/Context; I Z)V
    check-cast v6, Landroidx/recyclerview/widget/RecyclerView$LayoutManager;
    invoke-virtual v0, v6, Landroidx/recyclerview/widget/RecyclerView;->setLayoutManager(Landroidx/recyclerview/widget/RecyclerView$LayoutManager;)V
    check-cast v1, Landroidx/recyclerview/widget/RecyclerView$Adapter;
    invoke-virtual v0, v1, Landroidx/recyclerview/widget/RecyclerView;->setAdapter(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V
    const/16 v6, 8
    int-to-float v6, v6
    invoke-virtual v5, Landroid/widget/FrameLayout;->getResources()Landroid/content/res/Resources;
    move-result-object v5
    invoke-virtual v5, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v5
    iget v5, v5, Landroid/util/DisplayMetrics;->density F
    mul-float/2addr v6, v5
    const/high16 v5, 1056964608
    add-float/2addr v6, v5
    float-to-int v5, v6
    new-instance v6, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$FileGroupViewHolder$1;
    invoke-direct v6, v5, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$FileGroupViewHolder$1;-><init>(I)V
    check-cast v6, Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;
    invoke-virtual v0, v6, Landroidx/recyclerview/widget/RecyclerView;->addItemDecoration(Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;)V
    return-void 
.end method

.method private static final bind$lambda$0(boolean  java.util.List  com.bytedance.trae.conversation.brainstorm.adapter.HistorySubtitleAdapter$FileGroupViewHolder)void
    .registers 3
    # ins_size=3
    if-eqz v0, +018h
    move-object v0, v1
    check-cast v0, Ljava/util/Collection;
    invoke-interface v0, Ljava/util/Collection;->isEmpty()Z
    move-result v0
    xor-int/lit8 v0, v0, 1
    if-eqz v0, +00dh
    iget-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$FileGroupViewHolder;->rowView Landroidx/recyclerview/widget/RecyclerView;
    invoke-interface v1, Ljava/util/List;->size()I
    move-result v1
    add-int/lit8 v1, v1, -1
    invoke-virtual v0, v1, Landroidx/recyclerview/widget/RecyclerView;->scrollToPosition(I)V
    return-void 
.end method

.method public final bind(java.util.List)void
    .registers 6
    # ins_size=2
    const-string v0, "attachments"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v5, Ljava/util/List;->size()I
    move-result v0
    iget v1, v4, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$FileGroupViewHolder;->lastCount I
    if-le v0, v1, +004h
    const/4 v0, 1
    goto +2h
    const/4 v0, 0
    invoke-interface v5, Ljava/util/List;->size()I
    move-result v1
    iput v1, v4, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$FileGroupViewHolder;->lastCount I
    iget-object v1, v4, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$FileGroupViewHolder;->childAdapter Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormFileRowAdapter;
    move-object v2, v5
    check-cast v2, Ljava/lang/Iterable;
    invoke-static v2, Lkotlin/collections/CollectionsKt;->toList(Ljava/lang/Iterable;)Ljava/util/List;
    move-result-object v2
    new-instance v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$FileGroupViewHolder$$ExternalSyntheticLambda0;
    invoke-direct v3, v0, v5, v4, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$FileGroupViewHolder$$ExternalSyntheticLambda0;-><init>(Z Ljava/util/List; Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$FileGroupViewHolder;)V
    invoke-virtual v1, v2, v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormFileRowAdapter;->submitList(Ljava/util/List; Ljava/lang/Runnable;)V
    return-void 
.end method
