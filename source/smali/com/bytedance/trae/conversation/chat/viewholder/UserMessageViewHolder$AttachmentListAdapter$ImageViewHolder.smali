# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$ImageViewHolder;
.super Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
.source "UserMessageViewHolder.kt"

.field private final fileDownloadHelper:Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
.field private final ivImage:Lcom/facebook/drawee/view/SimpleDraweeView;
.field private loadJob:Lkotlinx/coroutines/Job;


.method public static synthetic $r8$lambda$Ol-Zjk9lr0Lpnf83evmrAmcOeSA(com.bytedance.trae.conversation.chat.viewholder.UserPreviewImageItem  java.util.List  com.bytedance.trae.conversation.chat.viewholder.UserMessageViewHolder$AttachmentListAdapter$ImageViewHolder  java.lang.String  java.lang.String  java.lang.String  android.view.View)void
    .registers 7
    # ins_size=7
    invoke-static/range v0 ... v6, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$ImageViewHolder;->bind$lambda$13(Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageItem; Ljava/util/List; Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$ImageViewHolder; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Landroid/view/View;)V
    return-void 
.end method

.method public constructor <init>(android.view.View)void
    .registers 3
    # ins_size=2
    const-string v0, "itemView"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v2, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;-><init>(Landroid/view/View;)V
    sget v0, Lcom/bytedance/trae/conversation/R$id;->iv_attachment I
    invoke-virtual v2, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v2
    const-string v0, "findViewById(...)"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v2, Lcom/facebook/drawee/view/SimpleDraweeView;
    iput-object v2, v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$ImageViewHolder;->ivImage Lcom/facebook/drawee/view/SimpleDraweeView;
    new-instance v2, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
    invoke-direct v2, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$ImageViewHolder;->fileDownloadHelper Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
    return-void 
.end method

.method public static final synthetic access$getFileDownloadHelper$p(com.bytedance.trae.conversation.chat.viewholder.UserMessageViewHolder$AttachmentListAdapter$ImageViewHolder)com.bytedance.trae.conversation.products.FileDownloadHelper
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$ImageViewHolder;->fileDownloadHelper Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
    return-object v0
.end method

.method public static final synthetic access$getIvImage$p(com.bytedance.trae.conversation.chat.viewholder.UserMessageViewHolder$AttachmentListAdapter$ImageViewHolder)com.facebook.drawee.view.SimpleDraweeView
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$ImageViewHolder;->ivImage Lcom/facebook/drawee/view/SimpleDraweeView;
    return-object v0
.end method

.method private final applyImageHierarchy()void
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$ImageViewHolder;->ivImage Lcom/facebook/drawee/view/SimpleDraweeView;
    invoke-virtual v0, Lcom/facebook/drawee/view/SimpleDraweeView;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    invoke-virtual v0, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v0
    const/4 v1, 1
    const/high16 v2, 1096810496
    invoke-static v1, v2, v0, Landroid/util/TypedValue;->applyDimension(I F Landroid/util/DisplayMetrics;)F
    move-result v0
    invoke-static v0, Lcom/facebook/drawee/generic/RoundingParams;->fromCornersRadius(F)Lcom/facebook/drawee/generic/RoundingParams;
    move-result-object v0
    sget-object v1, Lcom/facebook/drawee/generic/RoundingParams$RoundingMethod;->OVERLAY_COLOR Lcom/facebook/drawee/generic/RoundingParams$RoundingMethod;
    invoke-virtual v0, v1, Lcom/facebook/drawee/generic/RoundingParams;->setRoundingMethod(Lcom/facebook/drawee/generic/RoundingParams$RoundingMethod;)Lcom/facebook/drawee/generic/RoundingParams;
    const-string v1, "#FFF5F5F5"
    invoke-static v1, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I
    move-result v1
    invoke-virtual v0, v1, Lcom/facebook/drawee/generic/RoundingParams;->setOverlayColor(I)Lcom/facebook/drawee/generic/RoundingParams;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$ImageViewHolder;->ivImage Lcom/facebook/drawee/view/SimpleDraweeView;
    invoke-virtual v1, Lcom/facebook/drawee/view/SimpleDraweeView;->getHierarchy()Lcom/facebook/drawee/interfaces/DraweeHierarchy;
    move-result-object v1
    check-cast v1, Lcom/facebook/drawee/generic/GenericDraweeHierarchy;
    sget v2, Lcom/bytedance/trae/common_ui/R$drawable;->trae_bg_image_loading I
    sget-object v3, Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;->CENTER_CROP Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;
    invoke-virtual v1, v2, v3, Lcom/facebook/drawee/generic/GenericDraweeHierarchy;->setPlaceholderImage(I Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;)V
    sget-object v2, Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;->CENTER_CROP Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;
    invoke-virtual v1, v2, Lcom/facebook/drawee/generic/GenericDraweeHierarchy;->setActualImageScaleType(Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;)V
    invoke-virtual v1, v0, Lcom/facebook/drawee/generic/GenericDraweeHierarchy;->setRoundingParams(Lcom/facebook/drawee/generic/RoundingParams;)V
    return-void 
.end method

.method private static final bind$lambda$13(com.bytedance.trae.conversation.chat.viewholder.UserPreviewImageItem  java.util.List  com.bytedance.trae.conversation.chat.viewholder.UserMessageViewHolder$AttachmentListAdapter$ImageViewHolder  java.lang.String  java.lang.String  java.lang.String  android.view.View)void
    .registers 24
    # ins_size=7
    move-object/from16 v0, v19
    if-eqz v17, +007h
    invoke-virtual/range v17, Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageItem;->getKind()Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageKind;
    move-result-object v1
    goto +2h
    const/4 v1, 0
    const/4 v2, -1
    if-nez v1, +004h
    move v1, v2
    goto +9h
    sget-object v3, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$ImageViewHolder$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageKind;->ordinal()I
    move-result v1
    aget v1, v3, v1
    if-eq v1, v2, +2b0h
    const-string v2, ""
    const-string v3, "getContext(...)"
    const/16 v4, 10
    const/4 v5, 0
    const/4 v6, 1
    if-eq v1, v6, +1cch
    const/4 v7, 2
    if-eq v1, v7, +0edh
    const/4 v7, 3
    if-ne v1, v7, +0e4h
    move-object/from16 v1, v18
    check-cast v1, Ljava/lang/Iterable;
    new-instance v7, Ljava/util/ArrayList;
    invoke-direct v7, Ljava/util/ArrayList;-><init>()V
    check-cast v7, Ljava/util/Collection;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v8
    invoke-interface v8, Ljava/util/Iterator;->hasNext()Z
    move-result v9
    if-eqz v9, +01ah
    invoke-interface v8, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v9
    move-object v10, v9
    check-cast v10, Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageItem;
    invoke-virtual v10, Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageItem;->getKind()Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageKind;
    move-result-object v10
    sget-object v11, Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageKind;->LOCAL_ARTIFACT Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageKind;
    if-ne v10, v11, +004h
    move v10, v6
    goto +2h
    move v10, v5
    if-eqz v10, -018h
    invoke-interface v7, v9, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -1dh
    check-cast v7, Ljava/util/List;
    check-cast v7, Ljava/lang/Iterable;
    new-instance v8, Ljava/util/ArrayList;
    invoke-static v7, v4, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v9
    invoke-direct v8, v9, Ljava/util/ArrayList;-><init>(I)V
    check-cast v8, Ljava/util/Collection;
    invoke-interface v7, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v7
    invoke-interface v7, Ljava/util/Iterator;->hasNext()Z
    move-result v9
    if-eqz v9, +010h
    invoke-interface v7, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v9
    check-cast v9, Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageItem;
    invoke-virtual v9, Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageItem;->getSourceId()Ljava/lang/String;
    move-result-object v9
    invoke-interface v8, v9, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -13h
    check-cast v8, Ljava/util/List;
    invoke-virtual/range v17, Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageItem;->getSourceId()Ljava/lang/String;
    move-result-object v7
    invoke-interface v8, v7, Ljava/util/List;->indexOf(Ljava/lang/Object;)I
    move-result v7
    invoke-static v7, v5, Lkotlin/ranges/RangesKt;->coerceAtLeast(I I)I
    move-result v12
    check-cast v8, Ljava/util/Collection;
    invoke-interface v8, Ljava/util/Collection;->isEmpty()Z
    move-result v7
    xor-int/2addr v7, v6
    if-eqz v7, +235h
    new-instance v7, Ljava/util/ArrayList;
    invoke-direct v7, Ljava/util/ArrayList;-><init>()V
    check-cast v7, Ljava/util/Collection;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v9
    if-eqz v9, +01ah
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v9
    move-object v10, v9
    check-cast v10, Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageItem;
    invoke-virtual v10, Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageItem;->getKind()Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageKind;
    move-result-object v10
    sget-object v11, Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageKind;->LOCAL_ARTIFACT Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageKind;
    if-ne v10, v11, +004h
    move v10, v6
    goto +2h
    move v10, v5
    if-eqz v10, -018h
    invoke-interface v7, v9, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -1dh
    check-cast v7, Ljava/util/List;
    check-cast v7, Ljava/lang/Iterable;
    new-instance v1, Ljava/util/ArrayList;
    invoke-static v7, v4, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v4
    invoke-direct v1, v4, Ljava/util/ArrayList;-><init>(I)V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v7, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v4
    invoke-interface v4, Ljava/util/Iterator;->hasNext()Z
    move-result v5
    if-eqz v5, +013h
    invoke-interface v4, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageItem;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageItem;->getDisplayName()Ljava/lang/String;
    move-result-object v5
    if-nez v5, +003h
    move-object v5, v2
    invoke-interface v1, v5, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -16h
    check-cast v1, Ljava/util/List;
    sget-object v9, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->Companion Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$Companion;
    iget-object v0, v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$ImageViewHolder;->itemView Landroid/view/View;
    invoke-virtual v0, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v10
    invoke-static v10, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v11, Ljava/util/ArrayList;
    invoke-direct v11, v8, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V
    new-instance v13, Ljava/util/ArrayList;
    check-cast v1, Ljava/util/Collection;
    invoke-direct v13, v1, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V
    move-object/from16 v14, v20
    move-object/from16 v15, v21
    move-object/from16 v16, v22
    invoke-virtual/range v9 ... v16, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$Companion;->startWithLocalArtifacts(Landroid/content/Context; Ljava/util/ArrayList; I Ljava/util/ArrayList; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    goto/16 +1beh
    new-instance v0, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v0, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v0
    move-object/from16 v1, v18
    check-cast v1, Ljava/lang/Iterable;
    new-instance v7, Ljava/util/ArrayList;
    invoke-direct v7, Ljava/util/ArrayList;-><init>()V
    check-cast v7, Ljava/util/Collection;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v8
    invoke-interface v8, Ljava/util/Iterator;->hasNext()Z
    move-result v9
    if-eqz v9, +01ah
    invoke-interface v8, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v9
    move-object v10, v9
    check-cast v10, Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageItem;
    invoke-virtual v10, Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageItem;->getKind()Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageKind;
    move-result-object v10
    sget-object v11, Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageKind;->REMOTE_RESOURCE Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageKind;
    if-ne v10, v11, +004h
    move v10, v6
    goto +2h
    move v10, v5
    if-eqz v10, -018h
    invoke-interface v7, v9, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -1dh
    check-cast v7, Ljava/util/List;
    check-cast v7, Ljava/lang/Iterable;
    new-instance v8, Ljava/util/ArrayList;
    invoke-static v7, v4, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v9
    invoke-direct v8, v9, Ljava/util/ArrayList;-><init>(I)V
    check-cast v8, Ljava/util/Collection;
    invoke-interface v7, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v7
    invoke-interface v7, Ljava/util/Iterator;->hasNext()Z
    move-result v9
    if-eqz v9, +010h
    invoke-interface v7, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v9
    check-cast v9, Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageItem;
    invoke-virtual v9, Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageItem;->getSourceId()Ljava/lang/String;
    move-result-object v9
    invoke-interface v8, v9, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -13h
    check-cast v8, Ljava/util/List;
    invoke-virtual/range v17, Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageItem;->getSourceId()Ljava/lang/String;
    move-result-object v7
    invoke-interface v8, v7, Ljava/util/List;->indexOf(Ljava/lang/Object;)I
    move-result v7
    invoke-static v7, v5, Lkotlin/ranges/RangesKt;->coerceAtLeast(I I)I
    move-result v7
    check-cast v8, Ljava/util/Collection;
    invoke-interface v8, Ljava/util/Collection;->isEmpty()Z
    move-result v9
    xor-int/2addr v9, v6
    if-eqz v9, +14dh
    new-instance v9, Ljava/util/ArrayList;
    invoke-direct v9, Ljava/util/ArrayList;-><init>()V
    check-cast v9, Ljava/util/Collection;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v10
    if-eqz v10, +01ah
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v10
    move-object v11, v10
    check-cast v11, Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageItem;
    invoke-virtual v11, Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageItem;->getKind()Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageKind;
    move-result-object v11
    sget-object v12, Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageKind;->REMOTE_RESOURCE Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageKind;
    if-ne v11, v12, +004h
    move v11, v6
    goto +2h
    move v11, v5
    if-eqz v11, -018h
    invoke-interface v9, v10, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -1dh
    check-cast v9, Ljava/util/List;
    check-cast v9, Ljava/lang/Iterable;
    new-instance v1, Ljava/util/ArrayList;
    invoke-static v9, v4, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v4
    invoke-direct v1, v4, Ljava/util/ArrayList;-><init>(I)V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v9, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v4
    invoke-interface v4, Ljava/util/Iterator;->hasNext()Z
    move-result v5
    if-eqz v5, +013h
    invoke-interface v4, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageItem;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageItem;->getDisplayName()Ljava/lang/String;
    move-result-object v5
    if-nez v5, +003h
    move-object v5, v2
    invoke-interface v1, v5, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -16h
    check-cast v1, Ljava/util/List;
    sget-object v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->Companion Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$Companion;
    iget-object v0, v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$ImageViewHolder;->itemView Landroid/view/View;
    invoke-virtual v0, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v0
    invoke-static v0, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v3, Ljava/util/ArrayList;
    invoke-direct v3, v8, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V
    new-instance v4, Ljava/util/ArrayList;
    check-cast v1, Ljava/util/Collection;
    invoke-direct v4, v1, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V
    invoke-virtual v2, v0, v3, v7, v4, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$Companion;->startWithRemoteResources(Landroid/content/Context; Ljava/util/ArrayList; I Ljava/util/ArrayList;)V
    goto/16 +0dch
    move-object/from16 v1, v18
    check-cast v1, Ljava/lang/Iterable;
    new-instance v7, Ljava/util/ArrayList;
    invoke-direct v7, Ljava/util/ArrayList;-><init>()V
    check-cast v7, Ljava/util/Collection;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v8
    invoke-interface v8, Ljava/util/Iterator;->hasNext()Z
    move-result v9
    if-eqz v9, +01ah
    invoke-interface v8, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v9
    move-object v10, v9
    check-cast v10, Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageItem;
    invoke-virtual v10, Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageItem;->getKind()Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageKind;
    move-result-object v10
    sget-object v11, Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageKind;->IMAGE_ID Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageKind;
    if-ne v10, v11, +004h
    move v10, v6
    goto +2h
    move v10, v5
    if-eqz v10, -018h
    invoke-interface v7, v9, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -1dh
    check-cast v7, Ljava/util/List;
    check-cast v7, Ljava/lang/Iterable;
    new-instance v8, Ljava/util/ArrayList;
    invoke-static v7, v4, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v9
    invoke-direct v8, v9, Ljava/util/ArrayList;-><init>(I)V
    check-cast v8, Ljava/util/Collection;
    invoke-interface v7, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v7
    invoke-interface v7, Ljava/util/Iterator;->hasNext()Z
    move-result v9
    if-eqz v9, +010h
    invoke-interface v7, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v9
    check-cast v9, Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageItem;
    invoke-virtual v9, Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageItem;->getSourceId()Ljava/lang/String;
    move-result-object v9
    invoke-interface v8, v9, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -13h
    check-cast v8, Ljava/util/List;
    invoke-virtual/range v17, Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageItem;->getSourceId()Ljava/lang/String;
    move-result-object v7
    invoke-interface v8, v7, Ljava/util/List;->indexOf(Ljava/lang/Object;)I
    move-result v7
    invoke-static v7, v5, Lkotlin/ranges/RangesKt;->coerceAtLeast(I I)I
    move-result v7
    check-cast v8, Ljava/util/Collection;
    invoke-interface v8, Ljava/util/Collection;->isEmpty()Z
    move-result v9
    xor-int/2addr v9, v6
    if-eqz v9, +071h
    new-instance v9, Ljava/util/ArrayList;
    invoke-direct v9, Ljava/util/ArrayList;-><init>()V
    check-cast v9, Ljava/util/Collection;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v10
    if-eqz v10, +01ah
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v10
    move-object v11, v10
    check-cast v11, Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageItem;
    invoke-virtual v11, Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageItem;->getKind()Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageKind;
    move-result-object v11
    sget-object v12, Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageKind;->IMAGE_ID Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageKind;
    if-ne v11, v12, +004h
    move v11, v6
    goto +2h
    move v11, v5
    if-eqz v11, -018h
    invoke-interface v9, v10, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -1dh
    check-cast v9, Ljava/util/List;
    check-cast v9, Ljava/lang/Iterable;
    new-instance v1, Ljava/util/ArrayList;
    invoke-static v9, v4, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v4
    invoke-direct v1, v4, Ljava/util/ArrayList;-><init>(I)V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v9, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v4
    invoke-interface v4, Ljava/util/Iterator;->hasNext()Z
    move-result v5
    if-eqz v5, +013h
    invoke-interface v4, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageItem;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageItem;->getDisplayName()Ljava/lang/String;
    move-result-object v5
    if-nez v5, +003h
    move-object v5, v2
    invoke-interface v1, v5, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -16h
    check-cast v1, Ljava/util/List;
    sget-object v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->Companion Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$Companion;
    iget-object v0, v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$ImageViewHolder;->itemView Landroid/view/View;
    invoke-virtual v0, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v0
    invoke-static v0, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v3, Ljava/util/ArrayList;
    invoke-direct v3, v8, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V
    new-instance v4, Ljava/util/ArrayList;
    check-cast v1, Ljava/util/Collection;
    invoke-direct v4, v1, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V
    invoke-virtual v2, v0, v3, v7, v4, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$Companion;->startWithImageIds(Landroid/content/Context; Ljava/util/ArrayList; I Ljava/util/ArrayList;)V
    return-void 
.end method

.method private final bindLocalArtifactImage(java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String)void
    .registers 20
    # ins_size=8
    move-object v7, v12
    move-object v2, v13
    sget-object v0, Lcom/bytedance/trae/conversation/products/LocalArtifactPath;->INSTANCE Lcom/bytedance/trae/conversation/products/LocalArtifactPath;
    invoke-virtual v0, v13, Lcom/bytedance/trae/conversation/products/LocalArtifactPath;->requestTarget(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v5
    move-object/from16 v0, v16
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    if-eqz v1, +003h
    move-object v0, v15
    move-object v4, v0
    check-cast v4, Ljava/lang/String;
    iget-object v0, v7, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$ImageViewHolder;->itemView Landroid/view/View;
    invoke-virtual v0, v13, Landroid/view/View;->setTag(Ljava/lang/Object;)V
    iget-object v0, v7, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$ImageViewHolder;->ivImage Lcom/facebook/drawee/view/SimpleDraweeView;
    const/4 v1, 0
    invoke-virtual v0, v1, Lcom/facebook/drawee/view/SimpleDraweeView;->setController(Lcom/facebook/drawee/interfaces/DraweeController;)V
    iget-object v0, v7, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$ImageViewHolder;->fileDownloadHelper Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v1
    invoke-virtual v1, Landroid/app/Application;->getApplicationContext()Landroid/content/Context;
    move-result-object v1
    const-string v3, "getApplicationContext(...)"
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v0, v1, v4, v5, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->getCachedFile(Landroid/content/Context; Ljava/lang/String; Ljava/lang/String;)Ljava/io/File;
    move-result-object v0
    if-eqz v0, +02dh
    iget-object v1, v7, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$ImageViewHolder;->ivImage Lcom/facebook/drawee/view/SimpleDraweeView;
    invoke-static Lcom/facebook/drawee/backends/pipeline/Fresco;->newDraweeControllerBuilder()Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;
    move-result-object v2
    invoke-static v0, Landroid/net/Uri;->fromFile(Ljava/io/File;)Landroid/net/Uri;
    move-result-object v0
    invoke-virtual v2, v0, Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;->setUri(Landroid/net/Uri;)Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;
    move-result-object v0
    const/4 v2, 1
    invoke-virtual v0, v2, Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;->setAutoPlayAnimations(Z)Lcom/facebook/drawee/controller/AbstractDraweeControllerBuilder;
    move-result-object v0
    check-cast v0, Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;
    iget-object v2, v7, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$ImageViewHolder;->ivImage Lcom/facebook/drawee/view/SimpleDraweeView;
    invoke-virtual v2, Lcom/facebook/drawee/view/SimpleDraweeView;->getController()Lcom/facebook/drawee/interfaces/DraweeController;
    move-result-object v2
    invoke-virtual v0, v2, Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;->setOldController(Lcom/facebook/drawee/interfaces/DraweeController;)Lcom/facebook/drawee/controller/AbstractDraweeControllerBuilder;
    move-result-object v0
    check-cast v0, Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;
    invoke-virtual v0, Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;->build()Lcom/facebook/drawee/controller/AbstractDraweeController;
    move-result-object v0
    check-cast v0, Lcom/facebook/drawee/interfaces/DraweeController;
    invoke-virtual v1, v0, Lcom/facebook/drawee/view/SimpleDraweeView;->setController(Lcom/facebook/drawee/interfaces/DraweeController;)V
    return-void 
    if-nez v14, +003h
    return-void 
    invoke-static Lkotlinx/coroutines/Dispatchers;->getMain()Lkotlinx/coroutines/MainCoroutineDispatcher;
    move-result-object v0
    check-cast v0, Lkotlin/coroutines/CoroutineContext;
    invoke-static v0, Lkotlinx/coroutines/CoroutineScopeKt;->CoroutineScope(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v8
    const/4 v9, 0
    const/4 v10, 0
    new-instance v11, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$ImageViewHolder$bindLocalArtifactImage$1;
    const/4 v6, 0
    move-object v0, v11
    move-object v1, v12
    move-object v2, v13
    move-object v3, v14
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$ImageViewHolder$bindLocalArtifactImage$1;-><init>(Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$ImageViewHolder; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    move-object v0, v11
    check-cast v0, Lkotlin/jvm/functions/Function2;
    const/4 v1, 3
    const/4 v2, 0
    move-object v13, v8
    move-object v14, v9
    move-object v15, v10
    move-object/from16 v16, v0
    move/from16 v17, v1
    move-object/from16 v18, v2
    invoke-static/range v13 ... v18, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    move-result-object v0
    iput-object v0, v7, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$ImageViewHolder;->loadJob Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final bindRemoteResourceImage(java.lang.String  java.lang.String)void
    .registers 13
    # ins_size=3
    iget-object v0, v10, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$ImageViewHolder;->itemView Landroid/view/View;
    invoke-virtual v0, v11, Landroid/view/View;->setTag(Ljava/lang/Object;)V
    iget-object v0, v10, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$ImageViewHolder;->ivImage Lcom/facebook/drawee/view/SimpleDraweeView;
    const/4 v1, 0
    invoke-virtual v0, v1, Lcom/facebook/drawee/view/SimpleDraweeView;->setController(Lcom/facebook/drawee/interfaces/DraweeController;)V
    if-nez v12, +003h
    return-void 
    const-string v0, "content://"
    const/4 v2, 0
    const/4 v3, 2
    invoke-static v12, v0, v2, v3, v1, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +02eh
    const-string v0, "file://"
    invoke-static v12, v0, v2, v3, v1, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +003h
    goto +24h
    invoke-static Lkotlinx/coroutines/Dispatchers;->getMain()Lkotlinx/coroutines/MainCoroutineDispatcher;
    move-result-object v0
    check-cast v0, Lkotlin/coroutines/CoroutineContext;
    invoke-static v0, Lkotlinx/coroutines/CoroutineScopeKt;->CoroutineScope(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v1
    const/4 v2, 0
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$ImageViewHolder$bindRemoteResourceImage$1;
    const/4 v9, 0
    move-object v4, v0
    move-object v5, v10
    move-object v6, v11
    move-object v7, v12
    move-object v8, v11
    invoke-direct/range v4 ... v9, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$ImageViewHolder$bindRemoteResourceImage$1;-><init>(Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$ImageViewHolder; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    move-result-object v11
    iput-object v11, v10, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$ImageViewHolder;->loadJob Lkotlinx/coroutines/Job;
    return-void 
    iget-object v11, v10, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$ImageViewHolder;->ivImage Lcom/facebook/drawee/view/SimpleDraweeView;
    invoke-static Lcom/facebook/drawee/backends/pipeline/Fresco;->newDraweeControllerBuilder()Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;
    move-result-object v0
    invoke-static v12, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v12
    invoke-virtual v0, v12, Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;->setUri(Landroid/net/Uri;)Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;
    move-result-object v12
    const/4 v0, 1
    invoke-virtual v12, v0, Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;->setAutoPlayAnimations(Z)Lcom/facebook/drawee/controller/AbstractDraweeControllerBuilder;
    move-result-object v12
    check-cast v12, Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;
    iget-object v0, v10, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$ImageViewHolder;->ivImage Lcom/facebook/drawee/view/SimpleDraweeView;
    invoke-virtual v0, Lcom/facebook/drawee/view/SimpleDraweeView;->getController()Lcom/facebook/drawee/interfaces/DraweeController;
    move-result-object v0
    invoke-virtual v12, v0, Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;->setOldController(Lcom/facebook/drawee/interfaces/DraweeController;)Lcom/facebook/drawee/controller/AbstractDraweeControllerBuilder;
    move-result-object v12
    check-cast v12, Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;
    invoke-virtual v12, Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;->build()Lcom/facebook/drawee/controller/AbstractDraweeController;
    move-result-object v12
    check-cast v12, Lcom/facebook/drawee/interfaces/DraweeController;
    invoke-virtual v11, v12, Lcom/facebook/drawee/view/SimpleDraweeView;->setController(Lcom/facebook/drawee/interfaces/DraweeController;)V
    return-void 
.end method

.method public final bind(com.bytedance.trae.im.model.MessagePart  java.util.Map  java.util.List  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String)void
    .registers 24
    # ins_size=9
    move-object v8, v15
    move-object/from16 v0, v17
    const-string v1, "part"
    move-object/from16 v2, v16
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v1, resolvedUrls
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v1, "allImages"
    move-object/from16 v9, v18
    invoke-static v9, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v1, "conversationId"
    move-object/from16 v10, v19
    invoke-static v10, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v1, "chatSessionId"
    move-object/from16 v11, v20
    invoke-static v11, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v1, "cliType"
    move-object/from16 v5, v21
    invoke-static v5, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v1, "mode"
    move-object/from16 v6, v22
    invoke-static v6, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v1, "messageId"
    move-object/from16 v12, v23
    invoke-static v12, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v15, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$ImageViewHolder;->cancelLoad()V
    invoke-static/range v16, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolderKt;->previewImageItemFromData(Lcom/bytedance/trae/im/model/MessagePart;)Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageItem;
    move-result-object v13
    const/4 v1, 0
    if-eqz v13, +010h
    invoke-virtual v13, Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageItem;->getSourceId()Ljava/lang/String;
    move-result-object v2
    if-eqz v2, +00ah
    invoke-interface v0, v2, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/String;
    move-object v2, v0
    goto +2h
    move-object v2, v1
    invoke-direct v15, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$ImageViewHolder;->applyImageHierarchy()V
    if-eqz v13, +007h
    invoke-virtual v13, Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageItem;->getKind()Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageKind;
    move-result-object v0
    goto +2h
    move-object v0, v1
    sget-object v3, Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageKind;->REMOTE_RESOURCE Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageKind;
    if-ne v0, v3, +00ah
    invoke-virtual v13, Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageItem;->getSourceId()Ljava/lang/String;
    move-result-object v0
    invoke-direct v15, v0, v2, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$ImageViewHolder;->bindRemoteResourceImage(Ljava/lang/String; Ljava/lang/String;)V
    goto +61h
    if-eqz v13, +007h
    invoke-virtual v13, Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageItem;->getKind()Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageKind;
    move-result-object v0
    goto +2h
    move-object v0, v1
    sget-object v3, Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageKind;->LOCAL_ARTIFACT Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageKind;
    if-ne v0, v3, +015h
    invoke-virtual v13, Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageItem;->getSourceId()Ljava/lang/String;
    move-result-object v1
    move-object v0, v15
    move-object/from16 v3, v19
    move-object/from16 v4, v20
    move-object/from16 v5, v21
    move-object/from16 v6, v22
    move-object/from16 v7, v23
    invoke-direct/range v0 ... v7, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$ImageViewHolder;->bindLocalArtifactImage(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    goto +42h
    move-object v0, v2
    check-cast v0, Ljava/lang/CharSequence;
    const/4 v3, 1
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +003h
    goto +3h
    const/4 v0, 0
    goto +2h
    move v0, v3
    if-nez v0, +02ch
    iget-object v0, v8, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$ImageViewHolder;->ivImage Lcom/facebook/drawee/view/SimpleDraweeView;
    invoke-static Lcom/facebook/drawee/backends/pipeline/Fresco;->newDraweeControllerBuilder()Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;
    move-result-object v1
    invoke-static v2, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v2
    invoke-virtual v1, v2, Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;->setUri(Landroid/net/Uri;)Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;
    move-result-object v1
    invoke-virtual v1, v3, Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;->setAutoPlayAnimations(Z)Lcom/facebook/drawee/controller/AbstractDraweeControllerBuilder;
    move-result-object v1
    check-cast v1, Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;
    iget-object v2, v8, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$ImageViewHolder;->ivImage Lcom/facebook/drawee/view/SimpleDraweeView;
    invoke-virtual v2, Lcom/facebook/drawee/view/SimpleDraweeView;->getController()Lcom/facebook/drawee/interfaces/DraweeController;
    move-result-object v2
    invoke-virtual v1, v2, Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;->setOldController(Lcom/facebook/drawee/interfaces/DraweeController;)Lcom/facebook/drawee/controller/AbstractDraweeControllerBuilder;
    move-result-object v1
    check-cast v1, Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;
    invoke-virtual v1, Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;->build()Lcom/facebook/drawee/controller/AbstractDraweeController;
    move-result-object v1
    check-cast v1, Lcom/facebook/drawee/interfaces/DraweeController;
    invoke-virtual v0, v1, Lcom/facebook/drawee/view/SimpleDraweeView;->setController(Lcom/facebook/drawee/interfaces/DraweeController;)V
    goto +6h
    iget-object v0, v8, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$ImageViewHolder;->ivImage Lcom/facebook/drawee/view/SimpleDraweeView;
    invoke-virtual v0, v1, Lcom/facebook/drawee/view/SimpleDraweeView;->setImageURI(Landroid/net/Uri;)V
    iget-object v7, v8, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$ImageViewHolder;->itemView Landroid/view/View;
    new-instance v14, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$ImageViewHolder$$ExternalSyntheticLambda0;
    move-object v0, v14
    move-object v1, v13
    move-object/from16 v2, v18
    move-object v3, v15
    move-object/from16 v4, v20
    move-object/from16 v5, v19
    move-object/from16 v6, v23
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$ImageViewHolder$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageItem; Ljava/util/List; Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$ImageViewHolder; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v7, v14, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-void 
.end method

.method public final cancelLoad()void
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$ImageViewHolder;->loadJob Lkotlinx/coroutines/Job;
    const/4 v1, 0
    if-eqz v0, +006h
    const/4 v2, 1
    invoke-static v0, v1, v2, v1, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    iput-object v1, v3, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$ImageViewHolder;->loadJob Lkotlinx/coroutines/Job;
    return-void 
.end method
