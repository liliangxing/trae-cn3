# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormImageRowAdapter$ImageCellViewHolder;
.super Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
.source "BrainstormImageRowAdapter.kt"

.field private bound:Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
.field private final callback:Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentCallback;
.field private final closeView:Landroid/view/View;
.field private final container:Landroid/widget/FrameLayout;
.field private final failedOverlay:Landroid/view/View;
.field private final loadingOverlay:Landroid/view/View;
.field private final previewLoader:Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormPreviewImageLoader;
.field private final previewView:Lcom/facebook/drawee/view/SimpleDraweeView;


.method public static synthetic $r8$lambda$4qZYAstwHaayxdZwIkIj1iRjl4c(com.bytedance.trae.conversation.brainstorm.adapter.BrainstormImageRowAdapter$ImageCellViewHolder  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormImageRowAdapter$ImageCellViewHolder;->bind$lambda$1(Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormImageRowAdapter$ImageCellViewHolder; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$McP3G1Ascf3yI3dMgt6Rz2nQSmo(com.bytedance.trae.conversation.brainstorm.adapter.BrainstormImageRowAdapter$ImageCellViewHolder  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormImageRowAdapter$ImageCellViewHolder;->bind$lambda$2(Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormImageRowAdapter$ImageCellViewHolder; Landroid/view/View;)V
    return-void 
.end method

.method public constructor <init>(android.widget.FrameLayout  com.bytedance.trae.conversation.brainstorm.adapter.HistorySubtitleAdapter$AttachmentCallback)void
    .registers 5
    # ins_size=3
    const-string v0, "container"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v0, v3
    check-cast v0, Landroid/view/View;
    invoke-direct v2, v0, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;-><init>(Landroid/view/View;)V
    iput-object v3, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormImageRowAdapter$ImageCellViewHolder;->container Landroid/widget/FrameLayout;
    iput-object v4, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormImageRowAdapter$ImageCellViewHolder;->callback Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentCallback;
    sget v4, Lcom/bytedance/trae/conversation/R$id;->iv_cell_preview I
    invoke-virtual v3, v4, Landroid/widget/FrameLayout;->findViewById(I)Landroid/view/View;
    move-result-object v4
    const-string v0, "findViewById(...)"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v4, Lcom/facebook/drawee/view/SimpleDraweeView;
    iput-object v4, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormImageRowAdapter$ImageCellViewHolder;->previewView Lcom/facebook/drawee/view/SimpleDraweeView;
    sget v1, Lcom/bytedance/trae/conversation/R$id;->overlay_cell_loading I
    invoke-virtual v3, v1, Landroid/widget/FrameLayout;->findViewById(I)Landroid/view/View;
    move-result-object v1
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v1, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormImageRowAdapter$ImageCellViewHolder;->loadingOverlay Landroid/view/View;
    sget v1, Lcom/bytedance/trae/conversation/R$id;->overlay_cell_failed I
    invoke-virtual v3, v1, Landroid/widget/FrameLayout;->findViewById(I)Landroid/view/View;
    move-result-object v1
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v1, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormImageRowAdapter$ImageCellViewHolder;->failedOverlay Landroid/view/View;
    sget v1, Lcom/bytedance/trae/conversation/R$id;->iv_cell_close I
    invoke-virtual v3, v1, Landroid/widget/FrameLayout;->findViewById(I)Landroid/view/View;
    move-result-object v3
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v3, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormImageRowAdapter$ImageCellViewHolder;->closeView Landroid/view/View;
    new-instance v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormPreviewImageLoader;
    invoke-direct v3, v4, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormPreviewImageLoader;-><init>(Lcom/facebook/drawee/view/SimpleDraweeView;)V
    iput-object v3, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormImageRowAdapter$ImageCellViewHolder;->previewLoader Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormPreviewImageLoader;
    return-void 
.end method

.method private static final bind$lambda$1(com.bytedance.trae.conversation.brainstorm.adapter.BrainstormImageRowAdapter$ImageCellViewHolder  android.view.View)void
    .registers 3
    # ins_size=2
    iget-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormImageRowAdapter$ImageCellViewHolder;->bound Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    if-eqz v2, +011h
    iget-object v1, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormImageRowAdapter$ImageCellViewHolder;->callback Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentCallback;
    if-eqz v1, +00dh
    invoke-virtual v2, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getAttachmentId()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v2, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getState()Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;
    move-result-object v2
    invoke-interface v1, v0, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentCallback;->onClose(Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;)V
    return-void 
.end method

.method private static final bind$lambda$2(com.bytedance.trae.conversation.brainstorm.adapter.BrainstormImageRowAdapter$ImageCellViewHolder  android.view.View)void
    .registers 4
    # ins_size=2
    iget-object v3, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormImageRowAdapter$ImageCellViewHolder;->bound Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    if-nez v3, +003h
    return-void 
    invoke-virtual v3, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getState()Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormImageRowAdapter$ImageCellViewHolder$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;->ordinal()I
    move-result v0
    aget v0, v1, v0
    const/4 v1, 1
    if-eq v0, v1, +00dh
    const/4 v1, 2
    if-eq v0, v1, +015h
    iget-object v2, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormImageRowAdapter$ImageCellViewHolder;->callback Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentCallback;
    if-eqz v2, +011h
    invoke-interface v2, v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentCallback;->onPreview(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;)V
    goto +ch
    iget-object v2, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormImageRowAdapter$ImageCellViewHolder;->callback Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentCallback;
    if-eqz v2, +009h
    invoke-virtual v3, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getAttachmentId()Ljava/lang/String;
    move-result-object v3
    invoke-interface v2, v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentCallback;->onRetry(Ljava/lang/String;)V
    return-void 
.end method

.method public final bind(com.bytedance.trae.conversation.brainstorm.model.BrainstormAttachment)void
    .registers 8
    # ins_size=2
    const-string v0, "attachment"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v7, v6, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormImageRowAdapter$ImageCellViewHolder;->bound Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    iget-object v0, v6, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormImageRowAdapter$ImageCellViewHolder;->previewLoader Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormPreviewImageLoader;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getLocalUri()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormPreviewImageLoader;->load(Ljava/lang/String;)V
    iget-object v0, v6, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormImageRowAdapter$ImageCellViewHolder;->loadingOverlay Landroid/view/View;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getState()Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;
    move-result-object v1
    sget-object v2, Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;->Uploading Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;
    const/4 v3, 1
    const/4 v4, 0
    if-ne v1, v2, +004h
    move v1, v3
    goto +2h
    move v1, v4
    const/16 v2, 8
    if-eqz v1, +004h
    move v1, v4
    goto +2h
    move v1, v2
    invoke-virtual v0, v1, Landroid/view/View;->setVisibility(I)V
    iget-object v0, v6, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormImageRowAdapter$ImageCellViewHolder;->failedOverlay Landroid/view/View;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getState()Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;
    move-result-object v1
    sget-object v5, Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;->Failed Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;
    if-ne v1, v5, +004h
    move v1, v3
    goto +2h
    move v1, v4
    if-eqz v1, +004h
    move v1, v4
    goto +2h
    move v1, v2
    invoke-virtual v0, v1, Landroid/view/View;->setVisibility(I)V
    iget-object v0, v6, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormImageRowAdapter$ImageCellViewHolder;->closeView Landroid/view/View;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getState()Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;
    move-result-object v1
    sget-object v5, Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;->Uploaded Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;
    if-eq v1, v5, +003h
    goto +2h
    move v3, v4
    if-eqz v3, +003h
    goto +2h
    move v4, v2
    invoke-virtual v0, v4, Landroid/view/View;->setVisibility(I)V
    iget-object v0, v6, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormImageRowAdapter$ImageCellViewHolder;->container Landroid/widget/FrameLayout;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getState()Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;
    move-result-object v7
    sget-object v1, Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;->Cancelled Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;
    if-ne v7, v1, +006h
    const v7, 1058642330
    goto +3h
    const/high16 v7, 1065353216
    invoke-virtual v0, v7, Landroid/widget/FrameLayout;->setAlpha(F)V
    iget-object v7, v6, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormImageRowAdapter$ImageCellViewHolder;->closeView Landroid/view/View;
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormImageRowAdapter$ImageCellViewHolder$$ExternalSyntheticLambda0;
    invoke-direct v0, v6, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormImageRowAdapter$ImageCellViewHolder$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormImageRowAdapter$ImageCellViewHolder;)V
    invoke-virtual v7, v0, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    iget-object v7, v6, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormImageRowAdapter$ImageCellViewHolder;->container Landroid/widget/FrameLayout;
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormImageRowAdapter$ImageCellViewHolder$$ExternalSyntheticLambda1;
    invoke-direct v0, v6, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormImageRowAdapter$ImageCellViewHolder$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormImageRowAdapter$ImageCellViewHolder;)V
    invoke-virtual v7, v0, Landroid/widget/FrameLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-void 
.end method
