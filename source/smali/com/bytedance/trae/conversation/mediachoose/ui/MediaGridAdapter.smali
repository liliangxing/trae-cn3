# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter;
.super Landroidx/recyclerview/widget/RecyclerView$Adapter;
.source "MediaGridAdapter.kt"

.field public static final Companion:Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$Companion;
.field private static final TYPE_CAMERA:I
.field private static final TYPE_MEDIA:I
.field private final enablePreview:Z
.field private final items:Ljava/util/ArrayList;
.field private final onCameraClick:Lkotlin/jvm/functions/Function0;
.field private final onPreview:Lkotlin/jvm/functions/Function1;
.field private final onToggleSelect:Lkotlin/jvm/functions/Function1;
.field private selection:Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter;->Companion Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$Companion;
    return-void 
.end method

.method public constructor <init>(kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function1  boolean)void
    .registers 6
    # ins_size=5
    const-string v0, "onCameraClick"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "onToggleSelect"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "onPreview"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Landroidx/recyclerview/widget/RecyclerView$Adapter;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter;->onCameraClick Lkotlin/jvm/functions/Function0;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter;->onToggleSelect Lkotlin/jvm/functions/Function1;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter;->onPreview Lkotlin/jvm/functions/Function1;
    iput-boolean v5, v1, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter;->enablePreview Z
    new-instance v2, Ljava/util/ArrayList;
    invoke-direct v2, Ljava/util/ArrayList;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter;->items Ljava/util/ArrayList;
    return-void 
.end method

.method private final currentIndexInMediaList(int)int
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter;->items Ljava/util/ArrayList;
    check-cast v0, Ljava/util/List;
    invoke-static v0, Lkotlin/collections/CollectionsKt;->firstOrNull(Ljava/util/List;)Ljava/lang/Object;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$GridItem$Camera;->INSTANCE Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$GridItem$Camera;
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    sub-int/2addr v3, v0
    return v3
.end method

.method public final currentMediaItems()java.util.List
    .registers 6
    # ins_size=1
    iget-object v0, v5, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter;->items Ljava/util/ArrayList;
    check-cast v0, Ljava/lang/Iterable;
    new-instance v1, Ljava/util/ArrayList;
    invoke-direct v1, Ljava/util/ArrayList;-><init>()V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +01dh
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$GridItem;
    instance-of v3, v2, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$GridItem$Media;
    const/4 v4, 0
    if-eqz v3, +005h
    check-cast v2, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$GridItem$Media;
    goto +2h
    move-object v2, v4
    if-eqz v2, +006h
    invoke-virtual v2, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$GridItem$Media;->getItem()Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;
    move-result-object v4
    if-eqz v4, -01bh
    invoke-interface v1, v4, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -20h
    check-cast v1, Ljava/util/List;
    return-object v1
.end method

.method public getItemCount()int
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter;->items Ljava/util/ArrayList;
    invoke-virtual v0, Ljava/util/ArrayList;->size()I
    move-result v0
    return v0
.end method

.method public getItemViewType(int)int
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter;->items Ljava/util/ArrayList;
    invoke-virtual v0, v2, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$GridItem;
    sget-object v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$GridItem$Camera;->INSTANCE Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$GridItem$Camera;
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +004h
    const/4 v2, 0
    goto +6h
    instance-of v2, v2, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$GridItem$Media;
    if-eqz v2, +004h
    const/4 v2, 1
    return v2
    new-instance v2, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v2, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v2
.end method

.method public onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder  int)void
    .registers 5
    # ins_size=3
    const-string v0, "holder"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter;->items Ljava/util/ArrayList;
    invoke-virtual v0, v4, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;
    move-result-object v0
    const-string v1, "get(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$GridItem;
    sget-object v1, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$GridItem$Camera;->INSTANCE Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$GridItem$Camera;
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +008h
    check-cast v3, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$CameraViewHolder;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$CameraViewHolder;->bind()V
    goto +16h
    instance-of v1, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$GridItem$Media;
    if-eqz v1, +014h
    check-cast v3, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$MediaViewHolder;
    check-cast v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$GridItem$Media;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$GridItem$Media;->getItem()Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter;->selection Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;
    invoke-direct v2, v4, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter;->currentIndexInMediaList(I)I
    move-result v4
    invoke-virtual v3, v0, v1, v4, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$MediaViewHolder;->bind(Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem; Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection; I)V
    return-void 
    new-instance v3, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v3, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v3
.end method

.method public onCreateViewHolder(android.view.ViewGroup  int)androidx.recyclerview.widget.RecyclerView$ViewHolder
    .registers 7
    # ins_size=3
    const-string v0, "parent"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v5, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;
    move-result-object v0
    invoke-static v0, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;
    move-result-object v0
    const-string v1, "inflate(...)"
    const/4 v2, 0
    if-eqz v6, +034h
    const/4 v3, 1
    if-ne v6, v3, +017h
    new-instance v6, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$MediaViewHolder;
    invoke-static v0, v5, v2, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseItemMediaBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseItemMediaBinding;
    move-result-object v5
    invoke-static v5, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter;->onToggleSelect Lkotlin/jvm/functions/Function1;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter;->onPreview Lkotlin/jvm/functions/Function1;
    iget-boolean v2, v4, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter;->enablePreview Z
    invoke-direct v6, v5, v0, v1, v2, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$MediaViewHolder;-><init>(Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseItemMediaBinding; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function1; Z)V
    check-cast v6, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
    goto +2bh
    new-instance v5, Ljava/lang/IllegalStateException;
    new-instance v0, Ljava/lang/StringBuilder;
    const-string/jumbo v1, unexpected viewType=
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v6, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v6
    invoke-direct v5, v6, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v5
    new-instance v6, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$CameraViewHolder;
    invoke-static v0, v5, v2, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseItemCameraBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseItemCameraBinding;
    move-result-object v5
    invoke-static v5, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter;->onCameraClick Lkotlin/jvm/functions/Function0;
    invoke-direct v6, v5, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$CameraViewHolder;-><init>(Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseItemCameraBinding; Lkotlin/jvm/functions/Function0;)V
    check-cast v6, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
    return-object v6
.end method

.method public final submit(java.util.List  boolean)void
    .registers 5
    # ins_size=3
    const-string v0, "mediaItems"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter;->items Ljava/util/ArrayList;
    invoke-virtual v0, Ljava/util/ArrayList;->clear()V
    if-eqz v4, +009h
    iget-object v4, v2, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter;->items Ljava/util/ArrayList;
    sget-object v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$GridItem$Camera;->INSTANCE Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$GridItem$Camera;
    invoke-virtual v4, v0, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    check-cast v3, Ljava/lang/Iterable;
    invoke-interface v3, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v3
    invoke-interface v3, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +013h
    invoke-interface v3, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;
    iget-object v0, v2, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter;->items Ljava/util/ArrayList;
    new-instance v1, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$GridItem$Media;
    invoke-direct v1, v4, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$GridItem$Media;-><init>(Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;)V
    invoke-virtual v0, v1, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    goto -16h
    invoke-virtual v2, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter;->notifyDataSetChanged()V
    return-void 
.end method

.method public final updateSelection(com.bytedance.trae.conversation.mediachoose.ui.MediaSelection)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, selection
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter;->selection Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter;->notifyDataSetChanged()V
    return-void 
.end method
