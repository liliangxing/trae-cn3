# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;
.super Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
.source "HistorySubtitleAdapter.kt"

.field public static final Companion:Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder$Companion;
.field private static final STATUS_COLOR_FAILED:I
.field private bound:Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
.field private final callback:Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentCallback;
.field private final card:Landroid/view/View;
.field private final closeView:Landroid/widget/ImageView;
.field private final container:Landroid/widget/FrameLayout;
.field private final contentView:Landroid/widget/LinearLayout;
.field private final failedOverlay:Landroid/view/View;
.field private final loadingOverlay:Landroid/view/View;
.field private final nameView:Landroid/widget/TextView;
.field private final previewLoader:Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormPreviewImageLoader;
.field private final previewView:Lcom/facebook/drawee/view/SimpleDraweeView;
.field private final statusView:Landroid/widget/TextView;
.field private final typeIcon:Landroid/widget/ImageView;


.method public static synthetic $r8$lambda$5ry2JOuI3s7w8C-vw4TVDzVhfhs(com.bytedance.trae.conversation.brainstorm.adapter.HistorySubtitleAdapter$AttachmentViewHolder  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->bind$lambda$1(Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$d-jVtMtRTty4mstRS1xft2K9JG8(com.bytedance.trae.conversation.brainstorm.adapter.HistorySubtitleAdapter$AttachmentViewHolder  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->bind$lambda$2(Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$f1qs0ch8xNnl3gODRX1LSpBlowY(com.bytedance.trae.conversation.brainstorm.adapter.HistorySubtitleAdapter$AttachmentViewHolder  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->bind$lambda$3(Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$jc5QykZvXTyj_TfevB-LUUrq6XA(com.bytedance.trae.conversation.brainstorm.adapter.HistorySubtitleAdapter$AttachmentViewHolder  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->bind$lambda$5(Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder; Landroid/view/View;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->Companion Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder$Companion;
    const v0, -1554886
    sput v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->STATUS_COLOR_FAILED I
    return-void 
.end method

.method public constructor <init>(android.widget.FrameLayout  com.bytedance.trae.conversation.brainstorm.adapter.HistorySubtitleAdapter$AttachmentCallback)void
    .registers 5
    # ins_size=3
    const-string v0, "container"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "callback"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v0, v3
    check-cast v0, Landroid/view/View;
    invoke-direct v2, v0, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;-><init>(Landroid/view/View;)V
    iput-object v3, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->container Landroid/widget/FrameLayout;
    iput-object v4, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->callback Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentCallback;
    sget v4, Lcom/bytedance/trae/conversation/R$id;->card_attachment I
    invoke-virtual v3, v4, Landroid/widget/FrameLayout;->findViewById(I)Landroid/view/View;
    move-result-object v4
    const-string v0, "findViewById(...)"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v4, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->card Landroid/view/View;
    sget v4, Lcom/bytedance/trae/conversation/R$id;->tv_attach_name I
    invoke-virtual v3, v4, Landroid/widget/FrameLayout;->findViewById(I)Landroid/view/View;
    move-result-object v4
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v4, Landroid/widget/TextView;
    iput-object v4, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->nameView Landroid/widget/TextView;
    sget v4, Lcom/bytedance/trae/conversation/R$id;->iv_attach_type_icon I
    invoke-virtual v3, v4, Landroid/widget/FrameLayout;->findViewById(I)Landroid/view/View;
    move-result-object v4
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v4, Landroid/widget/ImageView;
    iput-object v4, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->typeIcon Landroid/widget/ImageView;
    sget v4, Lcom/bytedance/trae/conversation/R$id;->iv_attach_preview I
    invoke-virtual v3, v4, Landroid/widget/FrameLayout;->findViewById(I)Landroid/view/View;
    move-result-object v4
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v4, Lcom/facebook/drawee/view/SimpleDraweeView;
    iput-object v4, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->previewView Lcom/facebook/drawee/view/SimpleDraweeView;
    sget v1, Lcom/bytedance/trae/conversation/R$id;->ll_attach_file_content I
    invoke-virtual v3, v1, Landroid/widget/FrameLayout;->findViewById(I)Landroid/view/View;
    move-result-object v1
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v1, Landroid/widget/LinearLayout;
    iput-object v1, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->contentView Landroid/widget/LinearLayout;
    sget v1, Lcom/bytedance/trae/conversation/R$id;->overlay_attach_loading I
    invoke-virtual v3, v1, Landroid/widget/FrameLayout;->findViewById(I)Landroid/view/View;
    move-result-object v1
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v1, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->loadingOverlay Landroid/view/View;
    sget v1, Lcom/bytedance/trae/conversation/R$id;->overlay_attach_failed I
    invoke-virtual v3, v1, Landroid/widget/FrameLayout;->findViewById(I)Landroid/view/View;
    move-result-object v1
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v1, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->failedOverlay Landroid/view/View;
    sget v1, Lcom/bytedance/trae/conversation/R$id;->tv_attach_status I
    invoke-virtual v3, v1, Landroid/widget/FrameLayout;->findViewById(I)Landroid/view/View;
    move-result-object v1
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v1, Landroid/widget/TextView;
    iput-object v1, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->statusView Landroid/widget/TextView;
    sget v1, Lcom/bytedance/trae/conversation/R$id;->iv_attach_close I
    invoke-virtual v3, v1, Landroid/widget/FrameLayout;->findViewById(I)Landroid/view/View;
    move-result-object v3
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v3, Landroid/widget/ImageView;
    iput-object v3, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->closeView Landroid/widget/ImageView;
    new-instance v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormPreviewImageLoader;
    invoke-direct v3, v4, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormPreviewImageLoader;-><init>(Lcom/facebook/drawee/view/SimpleDraweeView;)V
    iput-object v3, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->previewLoader Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormPreviewImageLoader;
    return-void 
.end method

.method private final applyAttachmentVisuals(com.bytedance.trae.conversation.brainstorm.model.BrainstormAttachment)void
    .registers 9
    # ins_size=2
    invoke-direct v7, v8, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->isImageAttachment(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;)Z
    move-result v0
    invoke-direct v7, v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->applyCardLayout(Z)V
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->previewView Lcom/facebook/drawee/view/SimpleDraweeView;
    check-cast v1, Landroid/view/View;
    const/4 v2, 0
    const/16 v3, 8
    if-eqz v0, +004h
    move v4, v2
    goto +2h
    move v4, v3
    invoke-virtual v1, v4, Landroid/view/View;->setVisibility(I)V
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->contentView Landroid/widget/LinearLayout;
    check-cast v1, Landroid/view/View;
    xor-int/lit8 v4, v0, 1
    if-eqz v4, +004h
    move v4, v2
    goto +2h
    move v4, v3
    invoke-virtual v1, v4, Landroid/view/View;->setVisibility(I)V
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->typeIcon Landroid/widget/ImageView;
    check-cast v1, Landroid/view/View;
    xor-int/lit8 v4, v0, 1
    if-eqz v4, +004h
    move v4, v2
    goto +2h
    move v4, v3
    invoke-virtual v1, v4, Landroid/view/View;->setVisibility(I)V
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->loadingOverlay Landroid/view/View;
    const/4 v4, 1
    if-eqz v0, +00ch
    invoke-virtual v8, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getState()Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;
    move-result-object v5
    sget-object v6, Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;->Uploading Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;
    if-ne v5, v6, +004h
    move v5, v4
    goto +2h
    move v5, v2
    if-eqz v5, +004h
    move v5, v2
    goto +2h
    move v5, v3
    invoke-virtual v1, v5, Landroid/view/View;->setVisibility(I)V
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->failedOverlay Landroid/view/View;
    if-eqz v0, +00bh
    invoke-virtual v8, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getState()Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;
    move-result-object v5
    sget-object v6, Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;->Failed Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;
    if-ne v5, v6, +003h
    goto +2h
    move v4, v2
    if-eqz v4, +003h
    goto +2h
    move v2, v3
    invoke-virtual v1, v2, Landroid/view/View;->setVisibility(I)V
    if-eqz v0, +013h
    iget-object v0, v7, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->previewLoader Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormPreviewImageLoader;
    invoke-virtual v8, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getLocalUri()Ljava/lang/String;
    move-result-object v8
    invoke-virtual v0, v8, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormPreviewImageLoader;->load(Ljava/lang/String;)V
    iget-object v8, v7, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->closeView Landroid/widget/ImageView;
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_brainstorm_attach_close_small I
    invoke-virtual v8, v0, Landroid/widget/ImageView;->setImageResource(I)V
    goto +2bh
    iget-object v0, v7, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->previewLoader Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormPreviewImageLoader;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormPreviewImageLoader;->clear()V
    iget-object v0, v7, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->loadingOverlay Landroid/view/View;
    invoke-virtual v0, v3, Landroid/view/View;->setVisibility(I)V
    iget-object v0, v7, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->failedOverlay Landroid/view/View;
    invoke-virtual v0, v3, Landroid/view/View;->setVisibility(I)V
    iget-object v0, v7, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->nameView Landroid/widget/TextView;
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->container Landroid/widget/FrameLayout;
    invoke-virtual v1, Landroid/widget/FrameLayout;->getContext()Landroid/content/Context;
    move-result-object v1
    sget v2, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_default I
    invoke-static v1, v2, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v1
    invoke-virtual v0, v1, Landroid/widget/TextView;->setTextColor(I)V
    iget-object v0, v7, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->closeView Landroid/widget/ImageView;
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_brainstorm_attach_close_small I
    invoke-virtual v0, v1, Landroid/widget/ImageView;->setImageResource(I)V
    invoke-direct v7, v8, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->applyTypeIcon(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;)V
    return-void 
.end method

.method private final applyCardLayout(boolean)void
    .registers 8
    # ins_size=2
    iget-object v0, v6, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->card Landroid/view/View;
    invoke-virtual v0, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    move-result-object v0
    const-string v1, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/FrameLayout$LayoutParams;
    iget-object v2, v6, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->closeView Landroid/widget/ImageView;
    invoke-virtual v2, Landroid/widget/ImageView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    move-result-object v2
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v2, Landroid/widget/FrameLayout$LayoutParams;
    const/16 v1, 10
    const/16 v3, 16
    const/4 v4, 1
    if-eqz v7, +04ch
    const/16 v7, 84
    invoke-direct v6, v7, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->dp(I)I
    move-result v5
    iput v5, v0, Landroid/widget/FrameLayout$LayoutParams;->width I
    invoke-direct v6, v7, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->dp(I)I
    move-result v7
    iput v7, v0, Landroid/widget/FrameLayout$LayoutParams;->height I
    iget-object v7, v6, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->card Landroid/view/View;
    const/4 v5, 0
    invoke-virtual v7, v5, Landroid/view/View;->setBackgroundResource(I)V
    invoke-direct v6, v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->dp(I)I
    move-result v7
    iput v7, v2, Landroid/widget/FrameLayout$LayoutParams;->width I
    invoke-direct v6, v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->dp(I)I
    move-result v7
    iput v7, v2, Landroid/widget/FrameLayout$LayoutParams;->height I
    invoke-direct v6, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->dp(I)I
    move-result v7
    iput v7, v2, Landroid/widget/FrameLayout$LayoutParams;->topMargin I
    invoke-direct v6, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->dp(I)I
    move-result v7
    invoke-virtual v2, v7, Landroid/widget/FrameLayout$LayoutParams;->setMarginEnd(I)V
    iget-object v7, v6, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->closeView Landroid/widget/ImageView;
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->trae_bg_brainstorm_attachment_close I
    invoke-virtual v7, v1, Landroid/widget/ImageView;->setBackgroundResource(I)V
    iget-object v7, v6, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->closeView Landroid/widget/ImageView;
    invoke-direct v6, v4, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->dp(I)I
    move-result v1
    invoke-direct v6, v4, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->dp(I)I
    move-result v3
    invoke-direct v6, v4, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->dp(I)I
    move-result v5
    invoke-direct v6, v4, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->dp(I)I
    move-result v4
    invoke-virtual v7, v1, v3, v5, v4, Landroid/widget/ImageView;->setPadding(I I I I)V
    goto +4dh
    const/16 v7, 180
    invoke-direct v6, v7, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->dp(I)I
    move-result v7
    iput v7, v0, Landroid/widget/FrameLayout$LayoutParams;->width I
    const/16 v7, 52
    invoke-direct v6, v7, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->dp(I)I
    move-result v7
    iput v7, v0, Landroid/widget/FrameLayout$LayoutParams;->height I
    iget-object v7, v6, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->card Landroid/view/View;
    sget v5, Lcom/bytedance/trae/conversation/R$drawable;->trae_bg_brainstorm_attachment_card I
    invoke-virtual v7, v5, Landroid/view/View;->setBackgroundResource(I)V
    invoke-direct v6, v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->dp(I)I
    move-result v7
    iput v7, v2, Landroid/widget/FrameLayout$LayoutParams;->width I
    invoke-direct v6, v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->dp(I)I
    move-result v7
    iput v7, v2, Landroid/widget/FrameLayout$LayoutParams;->height I
    invoke-direct v6, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->dp(I)I
    move-result v7
    iput v7, v2, Landroid/widget/FrameLayout$LayoutParams;->topMargin I
    invoke-direct v6, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->dp(I)I
    move-result v7
    invoke-virtual v2, v7, Landroid/widget/FrameLayout$LayoutParams;->setMarginEnd(I)V
    iget-object v7, v6, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->closeView Landroid/widget/ImageView;
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->trae_bg_brainstorm_attachment_close I
    invoke-virtual v7, v1, Landroid/widget/ImageView;->setBackgroundResource(I)V
    iget-object v7, v6, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->closeView Landroid/widget/ImageView;
    invoke-direct v6, v4, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->dp(I)I
    move-result v1
    invoke-direct v6, v4, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->dp(I)I
    move-result v3
    invoke-direct v6, v4, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->dp(I)I
    move-result v5
    invoke-direct v6, v4, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->dp(I)I
    move-result v4
    invoke-virtual v7, v1, v3, v5, v4, Landroid/widget/ImageView;->setPadding(I I I I)V
    iget-object v7, v6, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->card Landroid/view/View;
    check-cast v0, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v7, v0, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    iget-object v7, v6, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->closeView Landroid/widget/ImageView;
    check-cast v2, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v7, v2, Landroid/widget/ImageView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    return-void 
.end method

.method private final applyTypeIcon(com.bytedance.trae.conversation.brainstorm.model.BrainstormAttachment)void
    .registers 6
    # ins_size=2
    iget-object v0, v4, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->typeIcon Landroid/widget/ImageView;
    sget-object v1, Lcom/bytedance/trae/conversation/brainstorm/VoiceAttachmentIconResolver;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/VoiceAttachmentIconResolver;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getDisplayName()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v5, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getMimeType()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v5, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->isImage()Z
    move-result v5
    invoke-virtual v1, v2, v3, v5, Lcom/bytedance/trae/conversation/brainstorm/VoiceAttachmentIconResolver;->getFileIconRes(Ljava/lang/String; Ljava/lang/String; Z)I
    move-result v5
    invoke-virtual v0, v5, Landroid/widget/ImageView;->setImageResource(I)V
    return-void 
.end method

.method private static final bind$lambda$1(com.bytedance.trae.conversation.brainstorm.adapter.HistorySubtitleAdapter$AttachmentViewHolder  android.view.View)void
    .registers 3
    # ins_size=2
    iget-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->bound Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    if-eqz v2, +00fh
    iget-object v1, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->callback Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentCallback;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getAttachmentId()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v2, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getState()Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;
    move-result-object v2
    invoke-interface v1, v0, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentCallback;->onClose(Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;)V
    return-void 
.end method

.method private static final bind$lambda$2(com.bytedance.trae.conversation.brainstorm.adapter.HistorySubtitleAdapter$AttachmentViewHolder  android.view.View)void
    .registers 4
    # ins_size=2
    iget-object v3, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->bound Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    if-nez v3, +003h
    return-void 
    invoke-virtual v3, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getState()Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;->ordinal()I
    move-result v0
    aget v0, v1, v0
    const/4 v1, 1
    if-eq v0, v1, +00bh
    const/4 v1, 2
    if-eq v0, v1, +011h
    iget-object v2, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->callback Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentCallback;
    invoke-interface v2, v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentCallback;->onPreview(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;)V
    goto +ah
    iget-object v2, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->callback Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentCallback;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getAttachmentId()Ljava/lang/String;
    move-result-object v3
    invoke-interface v2, v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentCallback;->onRetry(Ljava/lang/String;)V
    return-void 
.end method

.method private static final bind$lambda$3(com.bytedance.trae.conversation.brainstorm.adapter.HistorySubtitleAdapter$AttachmentViewHolder  android.view.View)void
    .registers 4
    # ins_size=2
    iget-object v3, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->bound Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    if-nez v3, +003h
    return-void 
    invoke-virtual v3, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getState()Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;->Failed Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;
    if-ne v0, v1, +00bh
    iget-object v2, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->callback Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentCallback;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getAttachmentId()Ljava/lang/String;
    move-result-object v3
    invoke-interface v2, v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentCallback;->onRetry(Ljava/lang/String;)V
    return-void 
.end method

.method private static final bind$lambda$5(com.bytedance.trae.conversation.brainstorm.adapter.HistorySubtitleAdapter$AttachmentViewHolder  android.view.View)void
    .registers 2
    # ins_size=2
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->bound Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    if-eqz v1, +00bh
    iget-object v0, v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->callback Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentCallback;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getAttachmentId()Ljava/lang/String;
    move-result-object v1
    invoke-interface v0, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentCallback;->onRetry(Ljava/lang/String;)V
    return-void 
.end method

.method private final dp(int)int
    .registers 3
    # ins_size=2
    int-to-float v2, v2
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->container Landroid/widget/FrameLayout;
    invoke-virtual v0, Landroid/widget/FrameLayout;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    invoke-virtual v0, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v0
    iget v0, v0, Landroid/util/DisplayMetrics;->density F
    mul-float/2addr v2, v0
    const/high16 v0, 1056964608
    add-float/2addr v2, v0
    float-to-int v2, v2
    return v2
.end method

.method private final failedStatusText(com.bytedance.trae.conversation.brainstorm.model.BrainstormAttachment)java.lang.CharSequence
    .registers 10
    # ins_size=2
    iget-object v0, v8, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->container Landroid/widget/FrameLayout;
    invoke-virtual v0, Landroid/widget/FrameLayout;->getContext()Landroid/content/Context;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/conversation/R$string;->trae_brainstorm_attach_resend I
    invoke-virtual v0, v1, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v0
    const-string v1, "getString(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v9, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getSizeBytes()J
    move-result-wide v1
    invoke-direct v8, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->formatFileSize(J)Ljava/lang/String;
    move-result-object v9
    move-object v1, v9
    check-cast v1, Ljava/lang/CharSequence;
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-nez v1, +004h
    const/4 v1, 1
    goto +2h
    const/4 v1, 0
    if-eqz v1, +004h
    move-object v9, v0
    goto +18h
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct v1, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v1, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    const-string v1, "  "
    invoke-virtual v9, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v9, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v9, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v9
    new-instance v1, Landroid/text/SpannableString;
    move-object v2, v9
    check-cast v2, Ljava/lang/CharSequence;
    invoke-direct v1, v2, Landroid/text/SpannableString;-><init>(Ljava/lang/CharSequence;)V
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 6
    const/4 v7, 0
    move-object v3, v0
    invoke-static/range v2 ... v7, Lkotlin/text/StringsKt;->indexOf$default(Ljava/lang/CharSequence; Ljava/lang/String; I Z I Ljava/lang/Object;)I
    move-result v9
    if-ltz v9, +013h
    new-instance v2, Landroid/text/style/ForegroundColorSpan;
    sget v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->STATUS_COLOR_FAILED I
    invoke-direct v2, v3, Landroid/text/style/ForegroundColorSpan;-><init>(I)V
    invoke-virtual v0, Ljava/lang/String;->length()I
    move-result v0
    add-int/2addr v0, v9
    const/16 v3, 33
    invoke-virtual v1, v2, v9, v0, v3, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object; I I I)V
    check-cast v1, Ljava/lang/CharSequence;
    return-object v1
.end method

.method private final formatFileSize(long)java.lang.String
    .registers 8
    # ins_size=3
    const-wide/16 v0, 0
    cmp-long v0, v6, v0
    if-gtz v0, +005h
    const-string v6, ""
    return-object v6
    const-wide/16 v0, 1024
    cmp-long v2, v6, v0
    if-gez v2, +016h
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v0, v6, v7, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v6
    const-string v7, " B"
    invoke-virtual v6, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    goto +3eh
    const-wide/32 v2, 1048576
    cmp-long v2, v6, v2
    if-gez v2, +017h
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, Ljava/lang/StringBuilder;-><init>()V
    div-long/2addr v6, v0
    invoke-virtual v2, v6, v7, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v6
    const-string v7, " KB"
    invoke-virtual v6, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    goto +22h
    sget-object v0, Lkotlin/jvm/internal/StringCompanionObject;->INSTANCE Lkotlin/jvm/internal/StringCompanionObject;
    sget-object v0, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    const/4 v1, 1
    new-array v2, v1, [Ljava/lang/Object;
    long-to-double v6, v6
    const-wide/high16 v3, 4697254411347427328
    div-double/2addr v6, v3
    invoke-static v6, v7, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;
    move-result-object v6
    const/4 v7, 0
    aput-object v6, v2, v7
    invoke-static v2, v1, Ljava/util/Arrays;->copyOf([Ljava/lang/Object; I)[Ljava/lang/Object;
    move-result-object v6
    const-string v7, "%.1f MB"
    invoke-static v0, v7, v6, Ljava/lang/String;->format(Ljava/util/Locale; Ljava/lang/String; [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v6
    const-string v7, "format(...)"
    invoke-static v6, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v6
.end method

.method private final isImageAttachment(com.bytedance.trae.conversation.brainstorm.model.BrainstormAttachment)boolean
    .registers 2
    # ins_size=2
    invoke-static v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapterKt;->access$isImageAttachment(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;)Z
    move-result v1
    return v1
.end method

.method private final normalStatusColor(com.bytedance.trae.conversation.brainstorm.model.BrainstormAttachment)int
    .registers 3
    # ins_size=2
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->isImageAttachment(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;)Z
    move-result v2
    if-eqz v2, +004h
    const/4 v2, -1
    goto +dh
    iget-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->container Landroid/widget/FrameLayout;
    invoke-virtual v2, Landroid/widget/FrameLayout;->getContext()Landroid/content/Context;
    move-result-object v2
    sget v0, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_tertiary I
    invoke-static v2, v0, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v2
    return v2
.end method

.method public final bind(com.bytedance.trae.conversation.brainstorm.model.BrainstormAttachment)void
    .registers 4
    # ins_size=2
    const-string v0, "attachment"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v3, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->bound Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    iget-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->nameView Landroid/widget/TextView;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getDisplayName()Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    invoke-virtual v0, v1, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->applyAttachmentVisuals(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;)V
    invoke-virtual v2, v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->updateState(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;)V
    iget-object v3, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->closeView Landroid/widget/ImageView;
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder$$ExternalSyntheticLambda0;
    invoke-direct v0, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;)V
    invoke-virtual v3, v0, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    iget-object v3, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->card Landroid/view/View;
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder$$ExternalSyntheticLambda1;
    invoke-direct v0, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;)V
    invoke-virtual v3, v0, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    iget-object v3, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->statusView Landroid/widget/TextView;
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder$$ExternalSyntheticLambda2;
    invoke-direct v0, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;)V
    invoke-virtual v3, v0, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    iget-object v3, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->failedOverlay Landroid/view/View;
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder$$ExternalSyntheticLambda3;
    invoke-direct v0, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder$$ExternalSyntheticLambda3;-><init>(Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;)V
    invoke-virtual v3, v0, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-void 
.end method

.method public final updateState(com.bytedance.trae.conversation.brainstorm.model.BrainstormAttachment)void
    .registers 11
    # ins_size=2
    const-string v0, "attachment"
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v10, v9, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->bound Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    invoke-direct v9, v10, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->applyAttachmentVisuals(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;)V
    iget-object v0, v9, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->closeView Landroid/widget/ImageView;
    check-cast v0, Landroid/view/View;
    invoke-virtual v10, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getState()Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;
    move-result-object v1
    sget-object v2, Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;->Uploaded Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;
    const/4 v3, 1
    const/4 v4, 0
    if-eq v1, v2, +004h
    move v1, v3
    goto +2h
    move v1, v4
    const/16 v2, 8
    if-eqz v1, +004h
    move v1, v4
    goto +2h
    move v1, v2
    invoke-virtual v0, v1, Landroid/view/View;->setVisibility(I)V
    invoke-virtual v10, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getState()Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;->ordinal()I
    move-result v0
    aget v0, v1, v0
    const/high16 v1, 1065353216
    if-eq v0, v3, +101h
    const/4 v5, 2
    if-eq v0, v5, +0d4h
    const/4 v6, 3
    if-eq v0, v6, +05eh
    const/4 v5, 4
    if-ne v0, v5, +055h
    invoke-virtual v10, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getSizeBytes()J
    move-result-wide v5
    invoke-direct v9, v5, v6, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->formatFileSize(J)Ljava/lang/String;
    move-result-object v0
    iget-object v5, v9, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->statusView Landroid/widget/TextView;
    check-cast v5, Landroid/view/View;
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v6
    if-lez v6, +004h
    move v6, v3
    goto +2h
    move v6, v4
    if-eqz v6, +003h
    move v2, v4
    invoke-virtual v5, v2, Landroid/view/View;->setVisibility(I)V
    iget-object v2, v9, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->statusView Landroid/widget/TextView;
    invoke-virtual v2, v0, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v0, v9, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->statusView Landroid/widget/TextView;
    invoke-direct v9, v10, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->normalStatusColor(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;)I
    move-result v2
    invoke-virtual v0, v2, Landroid/widget/TextView;->setTextColor(I)V
    iget-object v0, v9, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->card Landroid/view/View;
    invoke-virtual v0, v1, Landroid/view/View;->setAlpha(F)V
    iget-object v0, v9, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->card Landroid/view/View;
    invoke-direct v9, v10, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->isImageAttachment(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;)Z
    move-result v1
    if-nez v1, +018h
    invoke-virtual v10, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getUploadedRef()Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    if-eqz v1, +00bh
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    if-eqz v1, +003h
    goto +3h
    move v1, v4
    goto +2h
    move v1, v3
    if-nez v1, +003h
    goto +2h
    move v3, v4
    invoke-virtual v0, v3, Landroid/view/View;->setClickable(Z)V
    goto/16 +0cdh
    new-instance v10, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v10, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v10
    invoke-virtual v10, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getSizeBytes()J
    move-result-wide v6
    invoke-direct v9, v6, v7, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->formatFileSize(J)Ljava/lang/String;
    move-result-object v0
    invoke-virtual v10, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getProgress()I
    move-result v2
    const/16 v6, 100
    invoke-static v2, v4, v6, Lkotlin/ranges/RangesKt;->coerceIn(I I I)I
    move-result v2
    iget-object v6, v9, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->statusView Landroid/widget/TextView;
    move-object v7, v0
    check-cast v7, Ljava/lang/CharSequence;
    invoke-interface v7, Ljava/lang/CharSequence;->length()I
    move-result v7
    if-nez v7, +004h
    move v7, v3
    goto +2h
    move v7, v4
    if-eqz v7, +019h
    iget-object v0, v9, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->container Landroid/widget/FrameLayout;
    invoke-virtual v0, Landroid/widget/FrameLayout;->getContext()Landroid/content/Context;
    move-result-object v0
    sget v5, Lcom/bytedance/trae/conversation/R$string;->trae_brainstorm_attach_uploading_no_size I
    new-array v3, v3, [Ljava/lang/Object;
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v2
    aput-object v2, v3, v4
    invoke-virtual v0, v5, v3, Landroid/content/Context;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    goto +19h
    iget-object v7, v9, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->container Landroid/widget/FrameLayout;
    invoke-virtual v7, Landroid/widget/FrameLayout;->getContext()Landroid/content/Context;
    move-result-object v7
    sget v8, Lcom/bytedance/trae/conversation/R$string;->trae_brainstorm_attach_uploading_progress I
    new-array v5, v5, [Ljava/lang/Object;
    aput-object v0, v5, v4
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    aput-object v0, v5, v3
    invoke-virtual v7, v8, v5, Landroid/content/Context;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-virtual v6, v0, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v0, v9, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->statusView Landroid/widget/TextView;
    check-cast v0, Landroid/view/View;
    invoke-virtual v0, v4, Landroid/view/View;->setVisibility(I)V
    iget-object v0, v9, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->statusView Landroid/widget/TextView;
    invoke-direct v9, v10, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->normalStatusColor(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;)I
    move-result v2
    invoke-virtual v0, v2, Landroid/widget/TextView;->setTextColor(I)V
    iget-object v0, v9, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->card Landroid/view/View;
    invoke-virtual v0, v1, Landroid/view/View;->setAlpha(F)V
    iget-object v0, v9, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->card Landroid/view/View;
    invoke-direct v9, v10, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->isImageAttachment(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;)Z
    move-result v1
    invoke-virtual v0, v1, Landroid/view/View;->setClickable(Z)V
    goto +53h
    iget-object v0, v9, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->statusView Landroid/widget/TextView;
    check-cast v0, Landroid/view/View;
    invoke-virtual v0, v4, Landroid/view/View;->setVisibility(I)V
    iget-object v0, v9, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->statusView Landroid/widget/TextView;
    sget v1, Lcom/bytedance/trae/conversation/R$string;->trae_brainstorm_attach_cancelled I
    invoke-virtual v0, v1, Landroid/widget/TextView;->setText(I)V
    iget-object v0, v9, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->statusView Landroid/widget/TextView;
    invoke-direct v9, v10, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->normalStatusColor(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;)I
    move-result v1
    invoke-virtual v0, v1, Landroid/widget/TextView;->setTextColor(I)V
    iget-object v0, v9, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->card Landroid/view/View;
    const v1, 1058642330
    invoke-virtual v0, v1, Landroid/view/View;->setAlpha(F)V
    iget-object v0, v9, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->card Landroid/view/View;
    invoke-virtual v0, v4, Landroid/view/View;->setClickable(Z)V
    iget-object v0, v9, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->statusView Landroid/widget/TextView;
    invoke-virtual v0, v4, Landroid/widget/TextView;->setClickable(Z)V
    goto +29h
    iget-object v0, v9, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->statusView Landroid/widget/TextView;
    check-cast v0, Landroid/view/View;
    invoke-virtual v0, v4, Landroid/view/View;->setVisibility(I)V
    iget-object v0, v9, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->statusView Landroid/widget/TextView;
    invoke-direct v9, v10, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->failedStatusText(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;)Ljava/lang/CharSequence;
    move-result-object v2
    invoke-virtual v0, v2, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v0, v9, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->statusView Landroid/widget/TextView;
    invoke-direct v9, v10, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->normalStatusColor(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;)I
    move-result v2
    invoke-virtual v0, v2, Landroid/widget/TextView;->setTextColor(I)V
    iget-object v0, v9, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->card Landroid/view/View;
    invoke-virtual v0, v1, Landroid/view/View;->setAlpha(F)V
    iget-object v0, v9, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->card Landroid/view/View;
    invoke-virtual v0, v3, Landroid/view/View;->setClickable(Z)V
    iget-object v0, v9, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->statusView Landroid/widget/TextView;
    invoke-virtual v0, v3, Landroid/widget/TextView;->setClickable(Z)V
    invoke-virtual v10, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getState()Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;
    move-result-object v10
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;->Failed Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;
    if-eq v10, v0, +007h
    iget-object v10, v9, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;->statusView Landroid/widget/TextView;
    invoke-virtual v10, v4, Landroid/widget/TextView;->setClickable(Z)V
    return-void 
.end method
