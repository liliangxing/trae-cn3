# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewPagerAdapter;
.super Landroidx/recyclerview/widget/RecyclerView$Adapter;
.source "PreviewPagerAdapter.kt"

.field private currentIndex:I
.field private final items:Ljava/util/List;
.field private final videoViews:Landroid/util/SparseArray;


.method public constructor <init>(java.util.List)void
    .registers 3
    # ins_size=2
    const-string v0, "items"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Landroidx/recyclerview/widget/RecyclerView$Adapter;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewPagerAdapter;->items Ljava/util/List;
    new-instance v2, Landroid/util/SparseArray;
    invoke-direct v2, Landroid/util/SparseArray;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewPagerAdapter;->videoViews Landroid/util/SparseArray;
    const/4 v2, -1
    iput v2, v1, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewPagerAdapter;->currentIndex I
    return-void 
.end method

.method public static final synthetic access$getCurrentIndex$p(com.bytedance.trae.conversation.mediachoose.ui.PreviewPagerAdapter)int
    .registers 1
    # ins_size=1
    iget v0, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewPagerAdapter;->currentIndex I
    return v0
.end method

.method public static final synthetic access$getVideoViews$p(com.bytedance.trae.conversation.mediachoose.ui.PreviewPagerAdapter)android.util.SparseArray
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewPagerAdapter;->videoViews Landroid/util/SparseArray;
    return-object v0
.end method

.method private final playVideoIfNeeded(int)void
    .registers 5
    # ins_size=2
    iget-object v0, v3, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewPagerAdapter;->videoViews Landroid/util/SparseArray;
    invoke-virtual v0, Landroid/util/SparseArray;->size()I
    move-result v0
    const/4 v1, 0
    if-ge v1, v0, +010h
    iget-object v2, v3, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewPagerAdapter;->videoViews Landroid/util/SparseArray;
    invoke-virtual v2, v1, Landroid/util/SparseArray;->valueAt(I)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Landroid/widget/VideoView;
    invoke-virtual v2, Landroid/widget/VideoView;->stopPlayback()V
    add-int/lit8 v1, v1, 1
    goto -fh
    iget-object v0, v3, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewPagerAdapter;->videoViews Landroid/util/SparseArray;
    invoke-virtual v0, v4, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Landroid/widget/VideoView;
    if-eqz v4, +005h
    invoke-virtual v4, Landroid/widget/VideoView;->start()V
    return-void 
.end method

.method public getItemCount()int
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewPagerAdapter;->items Ljava/util/List;
    invoke-interface v0, Ljava/util/List;->size()I
    move-result v0
    return v0
.end method

.method public bridge synthetic onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder  int)void
    .registers 3
    # ins_size=3
    check-cast v1, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewPagerAdapter$PageViewHolder;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewPagerAdapter;->onBindViewHolder(Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewPagerAdapter$PageViewHolder; I)V
    return-void 
.end method

.method public onBindViewHolder(com.bytedance.trae.conversation.mediachoose.ui.PreviewPagerAdapter$PageViewHolder  int)void
    .registers 4
    # ins_size=3
    const-string v0, "holder"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewPagerAdapter;->items Ljava/util/List;
    invoke-interface v0, v3, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;
    invoke-virtual v2, v0, v3, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewPagerAdapter$PageViewHolder;->bind(Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem; I)V
    return-void 
.end method

.method public bridge synthetic onCreateViewHolder(android.view.ViewGroup  int)androidx.recyclerview.widget.RecyclerView$ViewHolder
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewPagerAdapter;->onCreateViewHolder(Landroid/view/ViewGroup; I)Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewPagerAdapter$PageViewHolder;
    move-result-object v1
    check-cast v1, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
    return-object v1
.end method

.method public onCreateViewHolder(android.view.ViewGroup  int)com.bytedance.trae.conversation.mediachoose.ui.PreviewPagerAdapter$PageViewHolder
    .registers 4
    # ins_size=3
    const-string v3, "parent"
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v2, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;
    move-result-object v3
    invoke-static v3, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;
    move-result-object v3
    const/4 v0, 0
    invoke-static v3, v2, v0, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseItemPreviewPageBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseItemPreviewPageBinding;
    move-result-object v2
    const-string v3, "inflate(...)"
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v3, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewPagerAdapter$PageViewHolder;
    invoke-direct v3, v1, v2, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewPagerAdapter$PageViewHolder;-><init>(Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewPagerAdapter; Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseItemPreviewPageBinding;)V
    return-object v3
.end method

.method public final onPageSelected(int)void
    .registers 2
    # ins_size=2
    iput v1, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewPagerAdapter;->currentIndex I
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewPagerAdapter;->playVideoIfNeeded(I)V
    return-void 
.end method

.method public bridge synthetic onViewRecycled(androidx.recyclerview.widget.RecyclerView$ViewHolder)void
    .registers 2
    # ins_size=2
    check-cast v1, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewPagerAdapter$PageViewHolder;
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewPagerAdapter;->onViewRecycled(Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewPagerAdapter$PageViewHolder;)V
    return-void 
.end method

.method public onViewRecycled(com.bytedance.trae.conversation.mediachoose.ui.PreviewPagerAdapter$PageViewHolder)void
    .registers 3
    # ins_size=2
    const-string v0, "holder"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v0, v2
    check-cast v0, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
    invoke-super v1, v0, Landroidx/recyclerview/widget/RecyclerView$Adapter;->onViewRecycled(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V
    invoke-virtual v2, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewPagerAdapter$PageViewHolder;->stopVideo()V
    return-void 
.end method

.method public final stopCurrentVideo()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewPagerAdapter;->videoViews Landroid/util/SparseArray;
    iget v1, v2, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewPagerAdapter;->currentIndex I
    invoke-virtual v0, v1, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Landroid/widget/VideoView;
    if-eqz v0, +005h
    invoke-virtual v0, Landroid/widget/VideoView;->stopPlayback()V
    return-void 
.end method
