# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormFileRowAdapter$FileCellViewHolder;
.super Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
.source "BrainstormFileRowAdapter.kt"

.field private bound:Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
.field private final callback:Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentCallback;
.field private final card:Landroid/view/View;
.field private final closeView:Landroid/view/View;
.field private final container:Landroid/widget/FrameLayout;
.field private final failedOverlay:Landroid/view/View;
.field private final loadingOverlay:Landroid/view/View;
.field private final nameView:Landroid/widget/TextView;
.field private final statusView:Landroid/widget/TextView;
.field private final typeIcon:Landroid/widget/ImageView;


.method public static synthetic $r8$lambda$Whhiw4zuPBwHwfZVRWyMqxVWSxg(com.bytedance.trae.conversation.brainstorm.adapter.BrainstormFileRowAdapter$FileCellViewHolder  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormFileRowAdapter$FileCellViewHolder;->bind$lambda$2(Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormFileRowAdapter$FileCellViewHolder; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$reUZ58f1_haYscZLvPGuTPdh_tY(com.bytedance.trae.conversation.brainstorm.adapter.BrainstormFileRowAdapter$FileCellViewHolder  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormFileRowAdapter$FileCellViewHolder;->bind$lambda$1(Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormFileRowAdapter$FileCellViewHolder; Landroid/view/View;)V
    return-void 
.end method

.method public constructor <init>(android.widget.FrameLayout  com.bytedance.trae.conversation.brainstorm.adapter.HistorySubtitleAdapter$AttachmentCallback)void
    .registers 4
    # ins_size=3
    const-string v0, "container"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v0, v2
    check-cast v0, Landroid/view/View;
    invoke-direct v1, v0, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;-><init>(Landroid/view/View;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormFileRowAdapter$FileCellViewHolder;->container Landroid/widget/FrameLayout;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormFileRowAdapter$FileCellViewHolder;->callback Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentCallback;
    sget v3, Lcom/bytedance/trae/conversation/R$id;->card_file_cell I
    invoke-virtual v2, v3, Landroid/widget/FrameLayout;->findViewById(I)Landroid/view/View;
    move-result-object v3
    const-string v0, "findViewById(...)"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v3, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormFileRowAdapter$FileCellViewHolder;->card Landroid/view/View;
    sget v3, Lcom/bytedance/trae/conversation/R$id;->iv_file_type_icon I
    invoke-virtual v2, v3, Landroid/widget/FrameLayout;->findViewById(I)Landroid/view/View;
    move-result-object v3
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v3, Landroid/widget/ImageView;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormFileRowAdapter$FileCellViewHolder;->typeIcon Landroid/widget/ImageView;
    sget v3, Lcom/bytedance/trae/conversation/R$id;->tv_file_name I
    invoke-virtual v2, v3, Landroid/widget/FrameLayout;->findViewById(I)Landroid/view/View;
    move-result-object v3
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v3, Landroid/widget/TextView;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormFileRowAdapter$FileCellViewHolder;->nameView Landroid/widget/TextView;
    sget v3, Lcom/bytedance/trae/conversation/R$id;->tv_file_status I
    invoke-virtual v2, v3, Landroid/widget/FrameLayout;->findViewById(I)Landroid/view/View;
    move-result-object v3
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v3, Landroid/widget/TextView;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormFileRowAdapter$FileCellViewHolder;->statusView Landroid/widget/TextView;
    sget v3, Lcom/bytedance/trae/conversation/R$id;->overlay_file_loading I
    invoke-virtual v2, v3, Landroid/widget/FrameLayout;->findViewById(I)Landroid/view/View;
    move-result-object v3
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v3, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormFileRowAdapter$FileCellViewHolder;->loadingOverlay Landroid/view/View;
    sget v3, Lcom/bytedance/trae/conversation/R$id;->overlay_file_failed I
    invoke-virtual v2, v3, Landroid/widget/FrameLayout;->findViewById(I)Landroid/view/View;
    move-result-object v3
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v3, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormFileRowAdapter$FileCellViewHolder;->failedOverlay Landroid/view/View;
    sget v3, Lcom/bytedance/trae/conversation/R$id;->iv_file_close I
    invoke-virtual v2, v3, Landroid/widget/FrameLayout;->findViewById(I)Landroid/view/View;
    move-result-object v2
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormFileRowAdapter$FileCellViewHolder;->closeView Landroid/view/View;
    return-void 
.end method

.method private final applyStatus(com.bytedance.trae.conversation.brainstorm.model.BrainstormAttachment)void
    .registers 9
    # ins_size=2
    invoke-virtual v8, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getState()Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormFileRowAdapter$FileCellViewHolder$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;->ordinal()I
    move-result v0
    aget v0, v1, v0
    const/4 v1, 1
    const/4 v2, 0
    if-eq v0, v1, +099h
    const/4 v3, 3
    if-eq v0, v3, +058h
    const/4 v3, 4
    if-eq v0, v3, +038h
    iget-object v0, v7, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormFileRowAdapter$FileCellViewHolder;->statusView Landroid/widget/TextView;
    check-cast v0, Landroid/view/View;
    invoke-virtual v8, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getSizeBytes()J
    move-result-wide v3
    const-wide/16 v5, 0
    cmp-long v3, v3, v5
    if-lez v3, +003h
    goto +2h
    move v1, v2
    if-eqz v1, +003h
    goto +3h
    const/16 v2, 8
    invoke-virtual v0, v2, Landroid/view/View;->setVisibility(I)V
    invoke-virtual v8, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getSizeBytes()J
    move-result-wide v0
    cmp-long v0, v0, v5
    if-lez v0, +08fh
    iget-object v0, v7, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormFileRowAdapter$FileCellViewHolder;->statusView Landroid/widget/TextView;
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormFileRowAdapter$FileCellViewHolder;->itemView Landroid/view/View;
    invoke-virtual v1, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v1
    invoke-virtual v8, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getSizeBytes()J
    move-result-wide v2
    invoke-static v1, v2, v3, Landroid/text/format/Formatter;->formatShortFileSize(Landroid/content/Context; J)Ljava/lang/String;
    move-result-object v8
    check-cast v8, Ljava/lang/CharSequence;
    invoke-virtual v0, v8, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    goto +78h
    iget-object v0, v7, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormFileRowAdapter$FileCellViewHolder;->statusView Landroid/widget/TextView;
    check-cast v0, Landroid/view/View;
    invoke-virtual v0, v2, Landroid/view/View;->setVisibility(I)V
    iget-object v0, v7, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormFileRowAdapter$FileCellViewHolder;->statusView Landroid/widget/TextView;
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormFileRowAdapter$FileCellViewHolder;->itemView Landroid/view/View;
    invoke-virtual v1, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v1
    invoke-virtual v8, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getSizeBytes()J
    move-result-wide v2
    invoke-static v1, v2, v3, Landroid/text/format/Formatter;->formatShortFileSize(Landroid/content/Context; J)Ljava/lang/String;
    move-result-object v8
    check-cast v8, Ljava/lang/CharSequence;
    invoke-virtual v0, v8, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    goto +5bh
    iget-object v0, v7, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormFileRowAdapter$FileCellViewHolder;->statusView Landroid/widget/TextView;
    check-cast v0, Landroid/view/View;
    invoke-virtual v0, v2, Landroid/view/View;->setVisibility(I)V
    iget-object v0, v7, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormFileRowAdapter$FileCellViewHolder;->itemView Landroid/view/View;
    invoke-virtual v0, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v0
    invoke-virtual v8, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getSizeBytes()J
    move-result-wide v1
    invoke-static v0, v1, v2, Landroid/text/format/Formatter;->formatShortFileSize(Landroid/content/Context; J)Ljava/lang/String;
    move-result-object v0
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormFileRowAdapter$FileCellViewHolder;->statusView Landroid/widget/TextView;
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v2, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v2, "  "
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v8, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getProgress()I
    move-result v8
    invoke-virtual v0, v8, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v8
    const/16 v0, 37
    invoke-virtual v8, v0, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v8
    check-cast v8, Ljava/lang/CharSequence;
    invoke-virtual v1, v8, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    goto +1dh
    iget-object v0, v7, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormFileRowAdapter$FileCellViewHolder;->statusView Landroid/widget/TextView;
    check-cast v0, Landroid/view/View;
    invoke-virtual v0, v2, Landroid/view/View;->setVisibility(I)V
    iget-object v0, v7, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormFileRowAdapter$FileCellViewHolder;->statusView Landroid/widget/TextView;
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormFileRowAdapter$FileCellViewHolder;->itemView Landroid/view/View;
    invoke-virtual v1, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v1
    invoke-virtual v8, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getSizeBytes()J
    move-result-wide v2
    invoke-static v1, v2, v3, Landroid/text/format/Formatter;->formatShortFileSize(Landroid/content/Context; J)Ljava/lang/String;
    move-result-object v8
    check-cast v8, Ljava/lang/CharSequence;
    invoke-virtual v0, v8, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    return-void 
.end method

.method private final applyTypeIcon(com.bytedance.trae.conversation.brainstorm.model.BrainstormAttachment)void
    .registers 6
    # ins_size=2
    iget-object v0, v4, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormFileRowAdapter$FileCellViewHolder;->typeIcon Landroid/widget/ImageView;
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

.method private static final bind$lambda$1(com.bytedance.trae.conversation.brainstorm.adapter.BrainstormFileRowAdapter$FileCellViewHolder  android.view.View)void
    .registers 3
    # ins_size=2
    iget-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormFileRowAdapter$FileCellViewHolder;->bound Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    if-eqz v2, +011h
    iget-object v1, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormFileRowAdapter$FileCellViewHolder;->callback Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentCallback;
    if-eqz v1, +00dh
    invoke-virtual v2, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getAttachmentId()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v2, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getState()Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;
    move-result-object v2
    invoke-interface v1, v0, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentCallback;->onClose(Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;)V
    return-void 
.end method

.method private static final bind$lambda$2(com.bytedance.trae.conversation.brainstorm.adapter.BrainstormFileRowAdapter$FileCellViewHolder  android.view.View)void
    .registers 4
    # ins_size=2
    iget-object v3, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormFileRowAdapter$FileCellViewHolder;->bound Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    if-nez v3, +003h
    return-void 
    invoke-virtual v3, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getState()Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormFileRowAdapter$FileCellViewHolder$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;->ordinal()I
    move-result v0
    aget v0, v1, v0
    const/4 v1, 1
    if-eq v0, v1, +00dh
    const/4 v1, 2
    if-eq v0, v1, +015h
    iget-object v2, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormFileRowAdapter$FileCellViewHolder;->callback Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentCallback;
    if-eqz v2, +011h
    invoke-interface v2, v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentCallback;->onPreview(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;)V
    goto +ch
    iget-object v2, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormFileRowAdapter$FileCellViewHolder;->callback Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentCallback;
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
    iput-object v7, v6, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormFileRowAdapter$FileCellViewHolder;->bound Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    iget-object v0, v6, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormFileRowAdapter$FileCellViewHolder;->nameView Landroid/widget/TextView;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getDisplayName()Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    invoke-virtual v0, v1, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    invoke-direct v6, v7, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormFileRowAdapter$FileCellViewHolder;->applyTypeIcon(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;)V
    invoke-direct v6, v7, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormFileRowAdapter$FileCellViewHolder;->applyStatus(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;)V
    iget-object v0, v6, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormFileRowAdapter$FileCellViewHolder;->loadingOverlay Landroid/view/View;
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
    iget-object v0, v6, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormFileRowAdapter$FileCellViewHolder;->failedOverlay Landroid/view/View;
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
    iget-object v0, v6, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormFileRowAdapter$FileCellViewHolder;->closeView Landroid/view/View;
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
    iget-object v0, v6, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormFileRowAdapter$FileCellViewHolder;->card Landroid/view/View;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getState()Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;
    move-result-object v7
    sget-object v1, Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;->Cancelled Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;
    if-ne v7, v1, +006h
    const v7, 1058642330
    goto +3h
    const/high16 v7, 1065353216
    invoke-virtual v0, v7, Landroid/view/View;->setAlpha(F)V
    iget-object v7, v6, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormFileRowAdapter$FileCellViewHolder;->closeView Landroid/view/View;
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormFileRowAdapter$FileCellViewHolder$$ExternalSyntheticLambda0;
    invoke-direct v0, v6, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormFileRowAdapter$FileCellViewHolder$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormFileRowAdapter$FileCellViewHolder;)V
    invoke-virtual v7, v0, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    iget-object v7, v6, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormFileRowAdapter$FileCellViewHolder;->card Landroid/view/View;
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormFileRowAdapter$FileCellViewHolder$$ExternalSyntheticLambda1;
    invoke-direct v0, v6, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormFileRowAdapter$FileCellViewHolder$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormFileRowAdapter$FileCellViewHolder;)V
    invoke-virtual v7, v0, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-void 
.end method
