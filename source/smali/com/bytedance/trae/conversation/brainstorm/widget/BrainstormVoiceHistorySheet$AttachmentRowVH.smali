# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AttachmentRowVH;
.super Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
.source "BrainstormVoiceHistorySheet.kt"

.field private final card:Landroid/view/View;
.field private final closeView:Landroid/widget/ImageView;
.field private final contentView:Landroid/widget/LinearLayout;
.field private final conversationId:Ljava/lang/String;
.field private final failedOverlay:Landroid/view/View;
.field private final imageUploadApi:Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi;
.field private final lifecycleScope:Landroidx/lifecycle/LifecycleCoroutineScope;
.field private final loadingOverlay:Landroid/view/View;
.field private final nameView:Landroid/widget/TextView;
.field private final previewLoader:Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader;
.field private final previewView:Lcom/facebook/drawee/view/SimpleDraweeView;
.field private final resourceUploadApi:Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi;
.field private final statusView:Landroid/widget/TextView;
.field private final typeIcon:Landroid/widget/ImageView;


.method public static synthetic $r8$lambda$ESV1WHcj3K9ggRRLYtXz_QzjCw8(java.lang.String  com.bytedance.trae.conversation.brainstorm.widget.BrainstormVoiceHistorySheet$AttachmentRowVH  com.bytedance.trae.conversation.brainstorm.widget.BrainstormVoiceHistorySheet$HistoryRow$UserAttachment  java.util.List  java.lang.String  android.view.View)void
    .registers 6
    # ins_size=6
    invoke-static/range v0 ... v5, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AttachmentRowVH;->bind$lambda$0(Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AttachmentRowVH; Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment; Ljava/util/List; Ljava/lang/String; Landroid/view/View;)V
    return-void 
.end method

.method public constructor <init>(android.widget.FrameLayout  java.lang.String  androidx.lifecycle.LifecycleCoroutineScope  com.bytedance.trae.conversation.imageupload.ConversationCopilotImageUploadApi  com.bytedance.trae.conversation.fileupload.ConversationCopilotResourceUploadApi)void
    .registers 12
    # ins_size=6
    const-string v0, "container"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "conversationId"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "lifecycleScope"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "imageUploadApi"
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, resourceUploadApi
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v0, v7
    check-cast v0, Landroid/view/View;
    invoke-direct v6, v0, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;-><init>(Landroid/view/View;)V
    iput-object v8, v6, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AttachmentRowVH;->conversationId Ljava/lang/String;
    iput-object v9, v6, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AttachmentRowVH;->lifecycleScope Landroidx/lifecycle/LifecycleCoroutineScope;
    iput-object v10, v6, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AttachmentRowVH;->imageUploadApi Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi;
    iput-object v11, v6, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AttachmentRowVH;->resourceUploadApi Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi;
    sget v8, Lcom/bytedance/trae/conversation/R$id;->card_attachment I
    invoke-virtual v7, v8, Landroid/widget/FrameLayout;->findViewById(I)Landroid/view/View;
    move-result-object v8
    const-string v0, "findViewById(...)"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v8, v6, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AttachmentRowVH;->card Landroid/view/View;
    sget v1, Lcom/bytedance/trae/conversation/R$id;->tv_attach_name I
    invoke-virtual v7, v1, Landroid/widget/FrameLayout;->findViewById(I)Landroid/view/View;
    move-result-object v1
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v1, Landroid/widget/TextView;
    iput-object v1, v6, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AttachmentRowVH;->nameView Landroid/widget/TextView;
    sget v1, Lcom/bytedance/trae/conversation/R$id;->iv_attach_type_icon I
    invoke-virtual v7, v1, Landroid/widget/FrameLayout;->findViewById(I)Landroid/view/View;
    move-result-object v1
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v1, Landroid/widget/ImageView;
    iput-object v1, v6, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AttachmentRowVH;->typeIcon Landroid/widget/ImageView;
    sget v1, Lcom/bytedance/trae/conversation/R$id;->iv_attach_preview I
    invoke-virtual v7, v1, Landroid/widget/FrameLayout;->findViewById(I)Landroid/view/View;
    move-result-object v1
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v1, Lcom/facebook/drawee/view/SimpleDraweeView;
    iput-object v1, v6, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AttachmentRowVH;->previewView Lcom/facebook/drawee/view/SimpleDraweeView;
    sget v2, Lcom/bytedance/trae/conversation/R$id;->ll_attach_file_content I
    invoke-virtual v7, v2, Landroid/widget/FrameLayout;->findViewById(I)Landroid/view/View;
    move-result-object v2
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v2, Landroid/widget/LinearLayout;
    iput-object v2, v6, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AttachmentRowVH;->contentView Landroid/widget/LinearLayout;
    sget v2, Lcom/bytedance/trae/conversation/R$id;->tv_attach_status I
    invoke-virtual v7, v2, Landroid/widget/FrameLayout;->findViewById(I)Landroid/view/View;
    move-result-object v2
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v2, Landroid/widget/TextView;
    iput-object v2, v6, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AttachmentRowVH;->statusView Landroid/widget/TextView;
    sget v3, Lcom/bytedance/trae/conversation/R$id;->iv_attach_close I
    invoke-virtual v7, v3, Landroid/widget/FrameLayout;->findViewById(I)Landroid/view/View;
    move-result-object v3
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v3, Landroid/widget/ImageView;
    iput-object v3, v6, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AttachmentRowVH;->closeView Landroid/widget/ImageView;
    sget v4, Lcom/bytedance/trae/conversation/R$id;->overlay_attach_loading I
    invoke-virtual v7, v4, Landroid/widget/FrameLayout;->findViewById(I)Landroid/view/View;
    move-result-object v4
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v4, v6, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AttachmentRowVH;->loadingOverlay Landroid/view/View;
    sget v5, Lcom/bytedance/trae/conversation/R$id;->overlay_attach_failed I
    invoke-virtual v7, v5, Landroid/widget/FrameLayout;->findViewById(I)Landroid/view/View;
    move-result-object v7
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v7, v6, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AttachmentRowVH;->failedOverlay Landroid/view/View;
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader;
    invoke-direct v0, v1, v9, v10, v11, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader;-><init>(Lcom/facebook/drawee/view/SimpleDraweeView; Landroidx/lifecycle/LifecycleCoroutineScope; Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi; Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi;)V
    iput-object v0, v6, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AttachmentRowVH;->previewLoader Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader;
    check-cast v2, Landroid/view/View;
    const/16 v9, 8
    invoke-virtual v2, v9, Landroid/view/View;->setVisibility(I)V
    check-cast v3, Landroid/view/View;
    invoke-virtual v3, v9, Landroid/view/View;->setVisibility(I)V
    invoke-virtual v4, v9, Landroid/view/View;->setVisibility(I)V
    invoke-virtual v7, v9, Landroid/view/View;->setVisibility(I)V
    const/high16 v7, 1065353216
    invoke-virtual v8, v7, Landroid/view/View;->setAlpha(F)V
    return-void 
.end method

.method private final applyAttachmentVisuals(com.bytedance.trae.conversation.brainstorm.widget.BrainstormVoiceHistorySheet$HistoryRow$UserAttachment)void
    .registers 6
    # ins_size=2
    invoke-virtual v5, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment;->isImage()Z
    move-result v0
    invoke-direct v4, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AttachmentRowVH;->applyCardLayout(Z)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AttachmentRowVH;->previewView Lcom/facebook/drawee/view/SimpleDraweeView;
    check-cast v0, Landroid/view/View;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment;->isImage()Z
    move-result v1
    const/4 v2, 0
    const/16 v3, 8
    if-eqz v1, +004h
    move v1, v2
    goto +2h
    move v1, v3
    invoke-virtual v0, v1, Landroid/view/View;->setVisibility(I)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AttachmentRowVH;->contentView Landroid/widget/LinearLayout;
    check-cast v0, Landroid/view/View;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment;->isImage()Z
    move-result v1
    xor-int/lit8 v1, v1, 1
    if-eqz v1, +004h
    move v1, v2
    goto +2h
    move v1, v3
    invoke-virtual v0, v1, Landroid/view/View;->setVisibility(I)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AttachmentRowVH;->typeIcon Landroid/widget/ImageView;
    check-cast v0, Landroid/view/View;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment;->isImage()Z
    move-result v1
    xor-int/lit8 v1, v1, 1
    if-eqz v1, +003h
    goto +2h
    move v2, v3
    invoke-virtual v0, v2, Landroid/view/View;->setVisibility(I)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AttachmentRowVH;->loadingOverlay Landroid/view/View;
    invoke-virtual v0, v3, Landroid/view/View;->setVisibility(I)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AttachmentRowVH;->failedOverlay Landroid/view/View;
    invoke-virtual v0, v3, Landroid/view/View;->setVisibility(I)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AttachmentRowVH;->closeView Landroid/widget/ImageView;
    check-cast v0, Landroid/view/View;
    invoke-virtual v0, v3, Landroid/view/View;->setVisibility(I)V
    invoke-virtual v5, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment;->isImage()Z
    move-result v0
    if-eqz v0, +008h
    iget-object v0, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AttachmentRowVH;->previewLoader Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader;
    invoke-virtual v0, v5, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader;->load(Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment;)V
    goto +6h
    iget-object v5, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AttachmentRowVH;->previewLoader Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader;->clear()V
    return-void 
.end method

.method private final applyCardLayout(boolean)void
    .registers 9
    # ins_size=2
    iget-object v0, v7, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AttachmentRowVH;->card Landroid/view/View;
    invoke-virtual v0, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    move-result-object v0
    const-string v1, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/FrameLayout$LayoutParams;
    iget-object v2, v7, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AttachmentRowVH;->closeView Landroid/widget/ImageView;
    invoke-virtual v2, Landroid/widget/ImageView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    move-result-object v2
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v2, Landroid/widget/FrameLayout$LayoutParams;
    if-eqz v8, +025h
    iget-object v8, v7, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AttachmentRowVH;->itemView Landroid/view/View;
    invoke-virtual v8, Landroid/view/View;->getResources()Landroid/content/res/Resources;
    move-result-object v8
    sget v1, Lcom/bytedance/trae/conversation/R$dimen;->trae_brainstorm_attachment_image_size I
    invoke-virtual v8, v1, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v8
    iput v8, v0, Landroid/widget/FrameLayout$LayoutParams;->width I
    iget-object v8, v7, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AttachmentRowVH;->itemView Landroid/view/View;
    invoke-virtual v8, Landroid/view/View;->getResources()Landroid/content/res/Resources;
    move-result-object v8
    sget v1, Lcom/bytedance/trae/conversation/R$dimen;->trae_brainstorm_attachment_image_size I
    invoke-virtual v8, v1, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v8
    iput v8, v0, Landroid/widget/FrameLayout$LayoutParams;->height I
    iget-object v8, v7, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AttachmentRowVH;->card Landroid/view/View;
    const/4 v1, 0
    invoke-virtual v8, v1, Landroid/view/View;->setBackgroundResource(I)V
    goto +24h
    iget-object v8, v7, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AttachmentRowVH;->itemView Landroid/view/View;
    invoke-virtual v8, Landroid/view/View;->getResources()Landroid/content/res/Resources;
    move-result-object v8
    sget v1, Lcom/bytedance/trae/conversation/R$dimen;->trae_brainstorm_attachment_file_width I
    invoke-virtual v8, v1, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v8
    iput v8, v0, Landroid/widget/FrameLayout$LayoutParams;->width I
    iget-object v8, v7, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AttachmentRowVH;->itemView Landroid/view/View;
    invoke-virtual v8, Landroid/view/View;->getResources()Landroid/content/res/Resources;
    move-result-object v8
    sget v1, Lcom/bytedance/trae/conversation/R$dimen;->trae_brainstorm_attachment_file_height I
    invoke-virtual v8, v1, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v8
    iput v8, v0, Landroid/widget/FrameLayout$LayoutParams;->height I
    iget-object v8, v7, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AttachmentRowVH;->card Landroid/view/View;
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->trae_bg_brainstorm_attachment_card I
    invoke-virtual v8, v1, Landroid/view/View;->setBackgroundResource(I)V
    iget-object v8, v7, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AttachmentRowVH;->itemView Landroid/view/View;
    invoke-virtual v8, Landroid/view/View;->getResources()Landroid/content/res/Resources;
    move-result-object v8
    sget v1, Lcom/bytedance/trae/conversation/R$dimen;->trae_brainstorm_attachment_close_size I
    invoke-virtual v8, v1, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v8
    iput v8, v2, Landroid/widget/FrameLayout$LayoutParams;->width I
    iget-object v8, v7, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AttachmentRowVH;->itemView Landroid/view/View;
    invoke-virtual v8, Landroid/view/View;->getResources()Landroid/content/res/Resources;
    move-result-object v8
    sget v1, Lcom/bytedance/trae/conversation/R$dimen;->trae_brainstorm_attachment_close_size I
    invoke-virtual v8, v1, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v8
    iput v8, v2, Landroid/widget/FrameLayout$LayoutParams;->height I
    iget-object v8, v7, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AttachmentRowVH;->itemView Landroid/view/View;
    invoke-virtual v8, Landroid/view/View;->getResources()Landroid/content/res/Resources;
    move-result-object v8
    sget v1, Lcom/bytedance/trae/conversation/R$dimen;->trae_brainstorm_attachment_close_margin I
    invoke-virtual v8, v1, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v8
    iput v8, v2, Landroid/widget/FrameLayout$LayoutParams;->topMargin I
    iget-object v8, v7, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AttachmentRowVH;->itemView Landroid/view/View;
    invoke-virtual v8, Landroid/view/View;->getResources()Landroid/content/res/Resources;
    move-result-object v8
    sget v1, Lcom/bytedance/trae/conversation/R$dimen;->trae_brainstorm_attachment_close_margin I
    invoke-virtual v8, v1, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v8
    invoke-virtual v2, v8, Landroid/widget/FrameLayout$LayoutParams;->setMarginEnd(I)V
    iget-object v8, v7, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AttachmentRowVH;->closeView Landroid/widget/ImageView;
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AttachmentRowVH;->itemView Landroid/view/View;
    invoke-virtual v1, Landroid/view/View;->getResources()Landroid/content/res/Resources;
    move-result-object v1
    sget v3, Lcom/bytedance/trae/conversation/R$dimen;->trae_brainstorm_attachment_close_padding I
    invoke-virtual v1, v3, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v1
    iget-object v3, v7, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AttachmentRowVH;->itemView Landroid/view/View;
    invoke-virtual v3, Landroid/view/View;->getResources()Landroid/content/res/Resources;
    move-result-object v3
    sget v4, Lcom/bytedance/trae/conversation/R$dimen;->trae_brainstorm_attachment_close_padding I
    invoke-virtual v3, v4, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v3
    iget-object v4, v7, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AttachmentRowVH;->itemView Landroid/view/View;
    invoke-virtual v4, Landroid/view/View;->getResources()Landroid/content/res/Resources;
    move-result-object v4
    sget v5, Lcom/bytedance/trae/conversation/R$dimen;->trae_brainstorm_attachment_close_padding I
    invoke-virtual v4, v5, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v4
    iget-object v5, v7, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AttachmentRowVH;->itemView Landroid/view/View;
    invoke-virtual v5, Landroid/view/View;->getResources()Landroid/content/res/Resources;
    move-result-object v5
    sget v6, Lcom/bytedance/trae/conversation/R$dimen;->trae_brainstorm_attachment_close_padding I
    invoke-virtual v5, v6, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v5
    invoke-virtual v8, v1, v3, v4, v5, Landroid/widget/ImageView;->setPadding(I I I I)V
    iget-object v8, v7, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AttachmentRowVH;->card Landroid/view/View;
    check-cast v0, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v8, v0, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    iget-object v8, v7, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AttachmentRowVH;->closeView Landroid/widget/ImageView;
    check-cast v2, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v8, v2, Landroid/widget/ImageView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    return-void 
.end method

.method private final applyTypeIcon(com.bytedance.trae.conversation.brainstorm.widget.BrainstormVoiceHistorySheet$HistoryRow$UserAttachment)void
    .registers 9
    # ins_size=2
    iget-object v0, v7, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AttachmentRowVH;->typeIcon Landroid/widget/ImageView;
    sget-object v1, Lcom/bytedance/trae/conversation/brainstorm/VoiceAttachmentIconResolver;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/VoiceAttachmentIconResolver;
    invoke-virtual v8, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment;->getFilename()Ljava/lang/String;
    move-result-object v2
    const/4 v3, 0
    invoke-virtual v8, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment;->isImage()Z
    move-result v4
    const/4 v5, 2
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lcom/bytedance/trae/conversation/brainstorm/VoiceAttachmentIconResolver;->getFileIconRes$default(Lcom/bytedance/trae/conversation/brainstorm/VoiceAttachmentIconResolver; Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)I
    move-result v8
    invoke-virtual v0, v8, Landroid/widget/ImageView;->setImageResource(I)V
    return-void 
.end method

.method private static final bind$lambda$0(java.lang.String  com.bytedance.trae.conversation.brainstorm.widget.BrainstormVoiceHistorySheet$AttachmentRowVH  com.bytedance.trae.conversation.brainstorm.widget.BrainstormVoiceHistorySheet$HistoryRow$UserAttachment  java.util.List  java.lang.String  android.view.View)void
    .registers 19
    # ins_size=6
    move-object v0, v14
    move-object v1, v15
    move-object/from16 v2, v16
    move-object/from16 v3, v17
    move-object v4, v13
    check-cast v4, Ljava/lang/CharSequence;
    const/4 v5, 0
    const/4 v6, 1
    if-eqz v4, +00bh
    invoke-static v4, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v4
    if-eqz v4, +003h
    goto +3h
    move v4, v5
    goto +2h
    move v4, v6
    const-string v7, "getContext(...)"
    if-nez v4, +012h
    sget-object v3, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;->Companion Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$Companion;
    iget-object v0, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AttachmentRowVH;->itemView Landroid/view/View;
    invoke-virtual v0, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v0
    invoke-static v0, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v3, v0, v15, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$Companion;->access$openImagePreview(Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$Companion; Landroid/content/Context; Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment; Ljava/util/List;)V
    goto/16 +09eh
    invoke-virtual v15, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment;->isImage()Z
    move-result v4
    if-eqz v4, +023h
    move-object v4, v3
    check-cast v4, Ljava/lang/CharSequence;
    if-eqz v4, +00bh
    invoke-static v4, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v4
    if-eqz v4, +003h
    goto +3h
    move v4, v5
    goto +2h
    move v4, v6
    if-nez v4, +012h
    sget-object v3, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;->Companion Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$Companion;
    iget-object v0, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AttachmentRowVH;->itemView Landroid/view/View;
    invoke-virtual v0, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v0
    invoke-static v0, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v3, v0, v15, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$Companion;->access$openImagePreview(Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$Companion; Landroid/content/Context; Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment; Ljava/util/List;)V
    goto/16 +077h
    move-object v2, v3
    check-cast v2, Ljava/lang/CharSequence;
    if-eqz v2, +00bh
    invoke-static v2, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    if-eqz v2, +003h
    goto +3h
    move v2, v5
    goto +2h
    move v2, v6
    if-nez v2, +066h
    invoke-virtual v15, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment;->getPreviewChatSessionId()Ljava/lang/String;
    move-result-object v2
    check-cast v2, Ljava/lang/CharSequence;
    if-eqz v2, +008h
    invoke-static v2, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    if-eqz v2, +003h
    move v5, v6
    if-eqz v5, +026h
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v5, "open attachment without chatSessionId: resourceUri="
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v5, ", fileName="
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v15, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment;->getFilename()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    const-string v5, "BrainstormVoiceHistory"
    invoke-virtual v2, v5, v4, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->Companion Lcom/bytedance/trae/conversation/products/InputPreviewActivity$Companion;
    iget-object v4, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AttachmentRowVH;->itemView Landroid/view/View;
    invoke-virtual v4, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v4
    invoke-static v4, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v15, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment;->getFilename()Ljava/lang/String;
    move-result-object v5
    iget-object v6, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AttachmentRowVH;->conversationId Ljava/lang/String;
    invoke-virtual v15, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment;->getPreviewChatSessionId()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +004h
    const-string v0, ""
    move-object v7, v0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/16 v11, 224
    const/4 v12, 0
    move-object v0, v2
    move-object v1, v4
    move-object/from16 v2, v17
    move-object v3, v5
    move-object v4, v6
    move-object v5, v7
    move-object v6, v8
    move-object v7, v9
    move-object v8, v10
    move v9, v11
    move-object v10, v12
    invoke-static/range v0 ... v10, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$Companion;->start$default(Lcom/bytedance/trae/conversation/products/InputPreviewActivity$Companion; Landroid/content/Context; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    return-void 
.end method

.method public final bind(com.bytedance.trae.conversation.brainstorm.widget.BrainstormVoiceHistorySheet$HistoryRow$UserAttachment  java.util.List)void
    .registers 12
    # ins_size=3
    const-string/jumbo v0, row
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "previewRows"
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v9, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AttachmentRowVH;->nameView Landroid/widget/TextView;
    invoke-virtual v10, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment;->getFilename()Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    invoke-virtual v0, v1, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    invoke-direct v9, v10, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AttachmentRowVH;->applyTypeIcon(Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment;)V
    invoke-direct v9, v10, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AttachmentRowVH;->applyAttachmentVisuals(Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment;)V
    invoke-virtual v10, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment;->isImage()Z
    move-result v0
    const/4 v1, 0
    if-nez v0, +029h
    invoke-virtual v10, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment;->getFile_size()J
    move-result-wide v2
    const-wide/16 v4, 0
    cmp-long v0, v2, v4
    if-lez v0, +01fh
    iget-object v0, v9, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AttachmentRowVH;->statusView Landroid/widget/TextView;
    check-cast v0, Landroid/view/View;
    invoke-virtual v0, v1, Landroid/view/View;->setVisibility(I)V
    iget-object v0, v9, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AttachmentRowVH;->statusView Landroid/widget/TextView;
    iget-object v2, v9, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AttachmentRowVH;->itemView Landroid/view/View;
    invoke-virtual v2, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v2
    invoke-virtual v10, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment;->getFile_size()J
    move-result-wide v3
    invoke-static v2, v3, v4, Landroid/text/format/Formatter;->formatShortFileSize(Landroid/content/Context; J)Ljava/lang/String;
    move-result-object v2
    check-cast v2, Ljava/lang/CharSequence;
    invoke-virtual v0, v2, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    goto +ah
    iget-object v0, v9, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AttachmentRowVH;->statusView Landroid/widget/TextView;
    check-cast v0, Landroid/view/View;
    const/16 v2, 8
    invoke-virtual v0, v2, Landroid/view/View;->setVisibility(I)V
    invoke-virtual v10, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment;->getPreviewImageId()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v10, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment;->getPreviewResourceUri()Ljava/lang/String;
    move-result-object v8
    iget-object v0, v9, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AttachmentRowVH;->card Landroid/view/View;
    move-object v2, v4
    check-cast v2, Ljava/lang/CharSequence;
    const/4 v3, 1
    if-eqz v2, +00bh
    invoke-static v2, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v5
    if-eqz v5, +003h
    goto +3h
    move v5, v1
    goto +2h
    move v5, v3
    if-eqz v5, +016h
    move-object v5, v8
    check-cast v5, Ljava/lang/CharSequence;
    if-eqz v5, +00bh
    invoke-static v5, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v5
    if-eqz v5, +003h
    goto +3h
    move v5, v1
    goto +2h
    move v5, v3
    if-nez v5, +003h
    goto +3h
    move v5, v1
    goto +2h
    move v5, v3
    invoke-virtual v0, v5, Landroid/view/View;->setClickable(Z)V
    iget-object v0, v9, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AttachmentRowVH;->card Landroid/view/View;
    if-eqz v2, +00bh
    invoke-static v2, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    if-eqz v2, +003h
    goto +3h
    move v2, v1
    goto +2h
    move v2, v3
    if-eqz v2, +012h
    move-object v2, v8
    check-cast v2, Ljava/lang/CharSequence;
    if-eqz v2, +008h
    invoke-static v2, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    if-eqz v2, +003h
    move v1, v3
    if-eqz v1, +004h
    const/4 v10, 0
    goto +bh
    new-instance v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AttachmentRowVH$$ExternalSyntheticLambda0;
    move-object v3, v1
    move-object v5, v9
    move-object v6, v10
    move-object v7, v11
    invoke-direct/range v3 ... v8, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AttachmentRowVH$$ExternalSyntheticLambda0;-><init>(Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AttachmentRowVH; Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment; Ljava/util/List; Ljava/lang/String;)V
    move-object v10, v1
    invoke-virtual v0, v10, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-void 
.end method
