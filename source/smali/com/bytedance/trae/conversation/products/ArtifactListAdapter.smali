# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/products/ArtifactListAdapter;
.super Landroidx/recyclerview/widget/RecyclerView$Adapter;
.source "ArtifactListAdapter.kt"

.field private final items:Ljava/util/List;
.field private final onItemClick:Lkotlin/jvm/functions/Function1;


.method public static synthetic $r8$lambda$sDLutREuk1ST_GpzLoG8X_xQIRI(com.bytedance.trae.conversation.products.ArtifactListAdapter  com.bytedance.trae.conversation.products.ArtifactItem  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/products/ArtifactListAdapter;->onBindViewHolder$lambda$0(Lcom/bytedance/trae/conversation/products/ArtifactListAdapter; Lcom/bytedance/trae/conversation/products/ArtifactItem; Landroid/view/View;)V
    return-void 
.end method

.method public constructor <init>()void
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 1
    invoke-direct v2, v0, v1, v0, Lcom/bytedance/trae/conversation/products/ArtifactListAdapter;-><init>(Lkotlin/jvm/functions/Function1; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(kotlin.jvm.functions.Function1)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Landroidx/recyclerview/widget/RecyclerView$Adapter;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/products/ArtifactListAdapter;->onItemClick Lkotlin/jvm/functions/Function1;
    new-instance v1, Ljava/util/ArrayList;
    invoke-direct v1, Ljava/util/ArrayList;-><init>()V
    check-cast v1, Ljava/util/List;
    iput-object v1, v0, Lcom/bytedance/trae/conversation/products/ArtifactListAdapter;->items Ljava/util/List;
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.functions.Function1  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 4
    # ins_size=4
    and-int/lit8 v2, v2, 1
    if-eqz v2, +003h
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/products/ArtifactListAdapter;-><init>(Lkotlin/jvm/functions/Function1;)V
    return-void 
.end method

.method private static final onBindViewHolder$lambda$0(com.bytedance.trae.conversation.products.ArtifactListAdapter  com.bytedance.trae.conversation.products.ArtifactItem  android.view.View)void
    .registers 3
    # ins_size=3
    iget-object v0, v0, Lcom/bytedance/trae/conversation/products/ArtifactListAdapter;->onItemClick Lkotlin/jvm/functions/Function1;
    if-eqz v0, +005h
    invoke-interface v0, v1, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method

.method public getItemCount()int
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/ArtifactListAdapter;->items Ljava/util/List;
    invoke-interface v0, Ljava/util/List;->size()I
    move-result v0
    return v0
.end method

.method public bridge synthetic onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder  int)void
    .registers 3
    # ins_size=3
    check-cast v1, Lcom/bytedance/trae/conversation/products/ArtifactListAdapter$ViewHolder;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/ArtifactListAdapter;->onBindViewHolder(Lcom/bytedance/trae/conversation/products/ArtifactListAdapter$ViewHolder; I)V
    return-void 
.end method

.method public onBindViewHolder(com.bytedance.trae.conversation.products.ArtifactListAdapter$ViewHolder  int)void
    .registers 6
    # ins_size=3
    const-string v0, "holder"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v3, Lcom/bytedance/trae/conversation/products/ArtifactListAdapter;->items Ljava/util/List;
    invoke-interface v0, v5, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Lcom/bytedance/trae/conversation/products/ArtifactItem;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/products/ArtifactListAdapter$ViewHolder;->getTvName()Landroid/widget/TextView;
    move-result-object v0
    invoke-virtual v5, Lcom/bytedance/trae/conversation/products/ArtifactItem;->getName()Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    invoke-virtual v0, v1, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    invoke-virtual v4, Lcom/bytedance/trae/conversation/products/ArtifactListAdapter$ViewHolder;->getIvIcon()Landroid/widget/ImageView;
    move-result-object v0
    invoke-virtual v5, Lcom/bytedance/trae/conversation/products/ArtifactItem;->getIconResId()I
    move-result v1
    invoke-virtual v0, v1, Landroid/widget/ImageView;->setImageResource(I)V
    invoke-virtual v5, Lcom/bytedance/trae/conversation/products/ArtifactItem;->getIconResId()I
    move-result v0
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->ic_folder I
    if-ne v0, v1, +004h
    const/4 v0, 1
    goto +2h
    const/4 v0, 0
    iget-object v1, v4, Lcom/bytedance/trae/conversation/products/ArtifactListAdapter$ViewHolder;->itemView Landroid/view/View;
    invoke-virtual v1, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v1
    invoke-virtual v1, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v1
    invoke-virtual v1, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v1
    iget v1, v1, Landroid/util/DisplayMetrics;->density F
    invoke-virtual v4, Lcom/bytedance/trae/conversation/products/ArtifactListAdapter$ViewHolder;->getIvIcon()Landroid/widget/ImageView;
    move-result-object v2
    invoke-virtual v2, Landroid/widget/ImageView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    move-result-object v2
    if-eqz v0, +011h
    const/16 v0, 30
    int-to-float v0, v0
    mul-float/2addr v0, v1
    float-to-int v0, v0
    iput v0, v2, Landroid/view/ViewGroup$LayoutParams;->width I
    const/16 v0, 23
    int-to-float v0, v0
    mul-float/2addr v0, v1
    float-to-int v0, v0
    iput v0, v2, Landroid/view/ViewGroup$LayoutParams;->height I
    goto +ah
    const/16 v0, 36
    int-to-float v0, v0
    mul-float/2addr v0, v1
    float-to-int v0, v0
    iput v0, v2, Landroid/view/ViewGroup$LayoutParams;->width I
    iput v0, v2, Landroid/view/ViewGroup$LayoutParams;->height I
    invoke-virtual v4, Lcom/bytedance/trae/conversation/products/ArtifactListAdapter$ViewHolder;->getIvIcon()Landroid/widget/ImageView;
    move-result-object v0
    invoke-virtual v0, v2, Landroid/widget/ImageView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    iget-object v4, v4, Lcom/bytedance/trae/conversation/products/ArtifactListAdapter$ViewHolder;->itemView Landroid/view/View;
    new-instance v0, Lcom/bytedance/trae/conversation/products/ArtifactListAdapter$$ExternalSyntheticLambda0;
    invoke-direct v0, v3, v5, Lcom/bytedance/trae/conversation/products/ArtifactListAdapter$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/products/ArtifactListAdapter; Lcom/bytedance/trae/conversation/products/ArtifactItem;)V
    invoke-virtual v4, v0, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-void 
.end method

.method public bridge synthetic onCreateViewHolder(android.view.ViewGroup  int)androidx.recyclerview.widget.RecyclerView$ViewHolder
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/ArtifactListAdapter;->onCreateViewHolder(Landroid/view/ViewGroup; I)Lcom/bytedance/trae/conversation/products/ArtifactListAdapter$ViewHolder;
    move-result-object v1
    check-cast v1, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
    return-object v1
.end method

.method public onCreateViewHolder(android.view.ViewGroup  int)com.bytedance.trae.conversation.products.ArtifactListAdapter$ViewHolder
    .registers 5
    # ins_size=3
    const-string v4, "parent"
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v3, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;
    move-result-object v4
    invoke-static v4, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;
    move-result-object v4
    sget v0, Lcom/bytedance/trae/conversation/R$layout;->trae_item_artifact I
    const/4 v1, 0
    invoke-virtual v4, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v3
    new-instance v4, Lcom/bytedance/trae/conversation/products/ArtifactListAdapter$ViewHolder;
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v4, v3, Lcom/bytedance/trae/conversation/products/ArtifactListAdapter$ViewHolder;-><init>(Landroid/view/View;)V
    return-object v4
.end method

.method public final submitList(java.util.List)void
    .registers 3
    # ins_size=2
    const-string v0, "newItems"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/ArtifactListAdapter;->items Ljava/util/List;
    invoke-interface v0, Ljava/util/List;->clear()V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/ArtifactListAdapter;->items Ljava/util/List;
    check-cast v2, Ljava/util/Collection;
    invoke-interface v0, v2, Ljava/util/List;->addAll(Ljava/util/Collection;)Z
    invoke-virtual v1, Lcom/bytedance/trae/conversation/products/ArtifactListAdapter;->notifyDataSetChanged()V
    return-void 
.end method
