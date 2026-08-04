# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryImageRowAdapter$ImageCellVH;
.super Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
.source "BrainstormVoiceHistorySheet.kt"

.field private final card:Landroid/view/View;
.field private final closeView:Landroid/view/View;
.field private final container:Landroid/widget/FrameLayout;
.field private final failedOverlay:Landroid/view/View;
.field private final loadingOverlay:Landroid/view/View;
.field private final previewLoader:Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader;
.field private final previewView:Lcom/facebook/drawee/view/SimpleDraweeView;


.method public static synthetic $r8$lambda$E6VFApBqiTeimXCL101wkNvhbYI(com.bytedance.trae.conversation.brainstorm.widget.BrainstormVoiceHistorySheet$VoiceHistoryImageRowAdapter$ImageCellVH  com.bytedance.trae.conversation.brainstorm.widget.BrainstormVoiceHistorySheet$HistoryRow$UserAttachment  java.util.List  android.view.View)void
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryImageRowAdapter$ImageCellVH;->bind$lambda$0(Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryImageRowAdapter$ImageCellVH; Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment; Ljava/util/List; Landroid/view/View;)V
    return-void 
.end method

.method public constructor <init>(android.widget.FrameLayout  androidx.lifecycle.LifecycleCoroutineScope  com.bytedance.trae.conversation.imageupload.ConversationCopilotImageUploadApi  com.bytedance.trae.conversation.fileupload.ConversationCopilotResourceUploadApi)void
    .registers 8
    # ins_size=5
    const-string v0, "container"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "lifecycleScope"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "imageUploadApi"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, resourceUploadApi
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v0, v4
    check-cast v0, Landroid/view/View;
    invoke-direct v3, v0, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;-><init>(Landroid/view/View;)V
    iput-object v4, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryImageRowAdapter$ImageCellVH;->container Landroid/widget/FrameLayout;
    sget v0, Lcom/bytedance/trae/conversation/R$id;->card_image_cell I
    invoke-virtual v4, v0, Landroid/widget/FrameLayout;->findViewById(I)Landroid/view/View;
    move-result-object v0
    const-string v1, "findViewById(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryImageRowAdapter$ImageCellVH;->card Landroid/view/View;
    sget v0, Lcom/bytedance/trae/conversation/R$id;->iv_cell_preview I
    invoke-virtual v4, v0, Landroid/widget/FrameLayout;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Lcom/facebook/drawee/view/SimpleDraweeView;
    iput-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryImageRowAdapter$ImageCellVH;->previewView Lcom/facebook/drawee/view/SimpleDraweeView;
    sget v2, Lcom/bytedance/trae/conversation/R$id;->overlay_cell_loading I
    invoke-virtual v4, v2, Landroid/widget/FrameLayout;->findViewById(I)Landroid/view/View;
    move-result-object v2
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v2, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryImageRowAdapter$ImageCellVH;->loadingOverlay Landroid/view/View;
    sget v2, Lcom/bytedance/trae/conversation/R$id;->overlay_cell_failed I
    invoke-virtual v4, v2, Landroid/widget/FrameLayout;->findViewById(I)Landroid/view/View;
    move-result-object v2
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v2, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryImageRowAdapter$ImageCellVH;->failedOverlay Landroid/view/View;
    sget v2, Lcom/bytedance/trae/conversation/R$id;->iv_cell_close I
    invoke-virtual v4, v2, Landroid/widget/FrameLayout;->findViewById(I)Landroid/view/View;
    move-result-object v4
    invoke-static v4, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v4, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryImageRowAdapter$ImageCellVH;->closeView Landroid/view/View;
    new-instance v4, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader;
    invoke-direct v4, v0, v5, v6, v7, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader;-><init>(Lcom/facebook/drawee/view/SimpleDraweeView; Landroidx/lifecycle/LifecycleCoroutineScope; Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi; Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi;)V
    iput-object v4, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryImageRowAdapter$ImageCellVH;->previewLoader Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader;
    return-void 
.end method

.method private static final bind$lambda$0(com.bytedance.trae.conversation.brainstorm.widget.BrainstormVoiceHistorySheet$VoiceHistoryImageRowAdapter$ImageCellVH  com.bytedance.trae.conversation.brainstorm.widget.BrainstormVoiceHistorySheet$HistoryRow$UserAttachment  java.util.List  android.view.View)void
    .registers 5
    # ins_size=4
    sget-object v4, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;->Companion Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$Companion;
    iget-object v1, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryImageRowAdapter$ImageCellVH;->itemView Landroid/view/View;
    invoke-virtual v1, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v1
    const-string v0, "getContext(...)"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v4, v1, v2, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$Companion;->access$openImagePreview(Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$Companion; Landroid/content/Context; Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment; Ljava/util/List;)V
    return-void 
.end method

.method public final bind(com.bytedance.trae.conversation.brainstorm.widget.BrainstormVoiceHistorySheet$HistoryRow$UserAttachment  java.util.List)void
    .registers 6
    # ins_size=3
    const-string/jumbo v0, row
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "previewRows"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryImageRowAdapter$ImageCellVH;->loadingOverlay Landroid/view/View;
    const/16 v1, 8
    invoke-virtual v0, v1, Landroid/view/View;->setVisibility(I)V
    iget-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryImageRowAdapter$ImageCellVH;->failedOverlay Landroid/view/View;
    invoke-virtual v0, v1, Landroid/view/View;->setVisibility(I)V
    iget-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryImageRowAdapter$ImageCellVH;->closeView Landroid/view/View;
    invoke-virtual v0, v1, Landroid/view/View;->setVisibility(I)V
    iget-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryImageRowAdapter$ImageCellVH;->container Landroid/widget/FrameLayout;
    const/high16 v1, 1065353216
    invoke-virtual v0, v1, Landroid/widget/FrameLayout;->setAlpha(F)V
    iget-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryImageRowAdapter$ImageCellVH;->previewLoader Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader;
    invoke-virtual v0, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader;->load(Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment;)V
    invoke-virtual v4, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment;->getPreviewImageId()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    const/4 v1, 0
    const/4 v2, 1
    if-eqz v0, +00bh
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    if-eqz v0, +003h
    goto +3h
    move v0, v1
    goto +2h
    move v0, v2
    if-eqz v0, +016h
    invoke-virtual v4, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment;->getPreviewResourceUri()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    if-eqz v0, +00bh
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    if-eqz v0, +003h
    goto +3h
    move v0, v1
    goto +2h
    move v0, v2
    if-nez v0, +003h
    move v1, v2
    iget-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryImageRowAdapter$ImageCellVH;->card Landroid/view/View;
    invoke-virtual v0, v1, Landroid/view/View;->setClickable(Z)V
    iget-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryImageRowAdapter$ImageCellVH;->card Landroid/view/View;
    if-eqz v1, +008h
    new-instance v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryImageRowAdapter$ImageCellVH$$ExternalSyntheticLambda0;
    invoke-direct v1, v3, v4, v5, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryImageRowAdapter$ImageCellVH$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryImageRowAdapter$ImageCellVH; Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment; Ljava/util/List;)V
    goto +2h
    const/4 v1, 0
    invoke-virtual v0, v1, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-void 
.end method

.method public final clear()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryImageRowAdapter$ImageCellVH;->previewLoader Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader;->clear()V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryImageRowAdapter$ImageCellVH;->card Landroid/view/View;
    const/4 v1, 0
    invoke-virtual v0, v1, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-void 
.end method
