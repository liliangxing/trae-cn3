# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$MediaViewHolder;
.super Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
.source "MediaGridAdapter.kt"

.field private final binding:Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseItemMediaBinding;
.field private final enablePreview:Z
.field private final onPreview:Lkotlin/jvm/functions/Function1;
.field private final onToggleSelect:Lkotlin/jvm/functions/Function1;


.method public static synthetic $r8$lambda$YUSQSeenBahLld1qtC2QlVYnimw(com.bytedance.trae.conversation.mediachoose.ui.MediaGridAdapter$MediaViewHolder  int  boolean  com.bytedance.trae.conversation.mediachoose.model.MediaItem  android.view.View)void
    .registers 5
    # ins_size=5
    invoke-static v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$MediaViewHolder;->bind$lambda$1(Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$MediaViewHolder; I Z Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$rGQIF1YTFSh0tQWrmyHXm2uLaVQ(boolean  com.bytedance.trae.conversation.mediachoose.ui.MediaGridAdapter$MediaViewHolder  com.bytedance.trae.conversation.mediachoose.model.MediaItem  android.view.View)void
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$MediaViewHolder;->bind$lambda$0(Z Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$MediaViewHolder; Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem; Landroid/view/View;)V
    return-void 
.end method

.method public constructor <init>(com.bytedance.trae.conversation.databinding.TraeMediaChooseItemMediaBinding  kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function1  boolean)void
    .registers 6
    # ins_size=5
    const-string v0, "binding"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "onToggleSelect"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "onPreview"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v2, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseItemMediaBinding;->getRoot()Lcom/bytedance/trae/conversation/mediachoose/widget/SquareFrameLayout;
    move-result-object v0
    check-cast v0, Landroid/view/View;
    invoke-direct v1, v0, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;-><init>(Landroid/view/View;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$MediaViewHolder;->binding Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseItemMediaBinding;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$MediaViewHolder;->onToggleSelect Lkotlin/jvm/functions/Function1;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$MediaViewHolder;->onPreview Lkotlin/jvm/functions/Function1;
    iput-boolean v5, v1, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$MediaViewHolder;->enablePreview Z
    return-void 
.end method

.method private static final bind$lambda$0(boolean  com.bytedance.trae.conversation.mediachoose.ui.MediaGridAdapter$MediaViewHolder  com.bytedance.trae.conversation.mediachoose.model.MediaItem  android.view.View)void
    .registers 4
    # ins_size=4
    if-nez v0, +007h
    iget-object v0, v1, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$MediaViewHolder;->onToggleSelect Lkotlin/jvm/functions/Function1;
    invoke-interface v0, v2, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method

.method private static final bind$lambda$1(com.bytedance.trae.conversation.mediachoose.ui.MediaGridAdapter$MediaViewHolder  int  boolean  com.bytedance.trae.conversation.mediachoose.model.MediaItem  android.view.View)void
    .registers 5
    # ins_size=5
    iget-boolean v4, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$MediaViewHolder;->enablePreview Z
    if-eqz v4, +00ch
    iget-object v0, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$MediaViewHolder;->onPreview Lkotlin/jvm/functions/Function1;
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    invoke-interface v0, v1, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    goto +8h
    if-nez v2, +007h
    iget-object v0, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$MediaViewHolder;->onToggleSelect Lkotlin/jvm/functions/Function1;
    invoke-interface v0, v3, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method

.method private final formatDuration(long)java.lang.String
    .registers 8
    # ins_size=3
    const/16 v0, 1000
    int-to-long v0, v0
    div-long/2addr v6, v0
    const/16 v0, 60
    int-to-long v0, v0
    div-long v2, v6, v0
    rem-long/2addr v6, v0
    const/4 v0, 2
    new-array v1, v0, [Ljava/lang/Object;
    const/4 v4, 0
    invoke-static v2, v3, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v2
    aput-object v2, v1, v4
    const/4 v2, 1
    invoke-static v6, v7, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v6
    aput-object v6, v1, v2
    invoke-static v1, v0, Ljava/util/Arrays;->copyOf([Ljava/lang/Object; I)[Ljava/lang/Object;
    move-result-object v6
    const-string v7, "%d:%02d"
    invoke-static v7, v6, Ljava/lang/String;->format(Ljava/lang/String; [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v6
    const-string v7, "format(...)"
    invoke-static v6, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v6
.end method

.method public final bind(com.bytedance.trae.conversation.mediachoose.model.MediaItem  com.bytedance.trae.conversation.mediachoose.ui.MediaSelection  int)void
    .registers 11
    # ins_size=4
    const-string v0, "item"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v7, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$MediaViewHolder;->binding Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseItemMediaBinding;
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseItemMediaBinding;->ivThumb Lcom/facebook/drawee/view/SimpleDraweeView;
    invoke-virtual v8, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->getUri()Landroid/net/Uri;
    move-result-object v1
    invoke-virtual v0, v1, Lcom/facebook/drawee/view/SimpleDraweeView;->setImageURI(Landroid/net/Uri;)V
    invoke-virtual v8, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->isVideo()Z
    move-result v0
    const/16 v1, 8
    const/4 v2, 0
    if-eqz v0, +025h
    invoke-virtual v8, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->getDurationMs()J
    move-result-wide v3
    const-wide/16 v5, 0
    cmp-long v0, v3, v5
    if-lez v0, +01bh
    iget-object v0, v7, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$MediaViewHolder;->binding Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseItemMediaBinding;
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseItemMediaBinding;->tvDuration Landroid/widget/TextView;
    invoke-virtual v0, v2, Landroid/widget/TextView;->setVisibility(I)V
    iget-object v0, v7, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$MediaViewHolder;->binding Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseItemMediaBinding;
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseItemMediaBinding;->tvDuration Landroid/widget/TextView;
    invoke-virtual v8, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->getDurationMs()J
    move-result-wide v3
    invoke-direct v7, v3, v4, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$MediaViewHolder;->formatDuration(J)Ljava/lang/String;
    move-result-object v3
    check-cast v3, Ljava/lang/CharSequence;
    invoke-virtual v0, v3, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    goto +8h
    iget-object v0, v7, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$MediaViewHolder;->binding Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseItemMediaBinding;
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseItemMediaBinding;->tvDuration Landroid/widget/TextView;
    invoke-virtual v0, v1, Landroid/widget/TextView;->setVisibility(I)V
    if-eqz v9, +00bh
    invoke-virtual v8, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->getId()J
    move-result-wide v3
    invoke-virtual v9, v3, v4, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;->getOrderText(J)Ljava/lang/String;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    if-nez v0, +004h
    const-string v0, ""
    iget-object v3, v7, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$MediaViewHolder;->binding Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseItemMediaBinding;
    iget-object v3, v3, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseItemMediaBinding;->selectionContainer Landroid/widget/FrameLayout;
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v4
    const/4 v5, 1
    if-lez v4, +004h
    move v4, v5
    goto +2h
    move v4, v2
    invoke-virtual v3, v4, Landroid/widget/FrameLayout;->setSelected(Z)V
    iget-object v3, v7, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$MediaViewHolder;->binding Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseItemMediaBinding;
    iget-object v3, v3, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseItemMediaBinding;->tvOrder Landroid/widget/TextView;
    invoke-virtual v3, v0, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    if-eqz v9, +009h
    invoke-virtual v9, v8, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;->isDisabled(Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;)Z
    move-result v9
    if-ne v9, v5, +003h
    goto +2h
    move v5, v2
    iget-object v9, v7, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$MediaViewHolder;->binding Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseItemMediaBinding;
    iget-object v9, v9, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseItemMediaBinding;->vMask Landroid/view/View;
    if-eqz v5, +003h
    move v1, v2
    invoke-virtual v9, v1, Landroid/view/View;->setVisibility(I)V
    iget-object v9, v7, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$MediaViewHolder;->binding Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseItemMediaBinding;
    iget-object v9, v9, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseItemMediaBinding;->selectionContainer Landroid/widget/FrameLayout;
    new-instance v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$MediaViewHolder$$ExternalSyntheticLambda0;
    invoke-direct v0, v5, v7, v8, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$MediaViewHolder$$ExternalSyntheticLambda0;-><init>(Z Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$MediaViewHolder; Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;)V
    invoke-virtual v9, v0, Landroid/widget/FrameLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    iget-object v9, v7, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$MediaViewHolder;->binding Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseItemMediaBinding;
    invoke-virtual v9, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseItemMediaBinding;->getRoot()Lcom/bytedance/trae/conversation/mediachoose/widget/SquareFrameLayout;
    move-result-object v9
    new-instance v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$MediaViewHolder$$ExternalSyntheticLambda1;
    invoke-direct v0, v7, v10, v5, v8, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$MediaViewHolder$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$MediaViewHolder; I Z Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;)V
    invoke-virtual v9, v0, Lcom/bytedance/trae/conversation/mediachoose/widget/SquareFrameLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-void 
.end method
