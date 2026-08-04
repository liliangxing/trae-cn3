# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter$ViewHolder;
.super Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
.source "InputAttachmentAdapter.kt"

.field private final binding:Lcom/bytedance/trae/conversation/databinding/TraeItemAttachmentBinding;
.field private final onRemove:Lkotlin/jvm/functions/Function1;
.field private final onRetry:Lkotlin/jvm/functions/Function1;


.method public static synthetic $r8$lambda$AVCqh-qdrvkbwYVozncglziM_So(com.bytedance.trae.conversation.widget.InputAttachmentAdapter$ViewHolder  com.bytedance.trae.conversation.widget.AttachmentItem  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter$ViewHolder;->bindStatus$lambda$3(Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter$ViewHolder; Lcom/bytedance/trae/conversation/widget/AttachmentItem; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$U7UEKrOFaTArvVsiEkAXoysrpVI(com.bytedance.trae.conversation.widget.InputAttachmentAdapter$ViewHolder  com.bytedance.trae.conversation.widget.AttachmentItem  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter$ViewHolder;->bind$lambda$2(Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter$ViewHolder; Lcom/bytedance/trae/conversation/widget/AttachmentItem; Landroid/view/View;)V
    return-void 
.end method

.method public constructor <init>(com.bytedance.trae.conversation.databinding.TraeItemAttachmentBinding  kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function1)void
    .registers 5
    # ins_size=4
    const-string v0, "binding"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "onRemove"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "onRetry"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v2, Lcom/bytedance/trae/conversation/databinding/TraeItemAttachmentBinding;->getRoot()Landroid/widget/FrameLayout;
    move-result-object v0
    check-cast v0, Landroid/view/View;
    invoke-direct v1, v0, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;-><init>(Landroid/view/View;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter$ViewHolder;->binding Lcom/bytedance/trae/conversation/databinding/TraeItemAttachmentBinding;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter$ViewHolder;->onRemove Lkotlin/jvm/functions/Function1;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter$ViewHolder;->onRetry Lkotlin/jvm/functions/Function1;
    return-void 
.end method

.method private static final bind$lambda$2(com.bytedance.trae.conversation.widget.InputAttachmentAdapter$ViewHolder  com.bytedance.trae.conversation.widget.AttachmentItem  android.view.View)void
    .registers 3
    # ins_size=3
    iget-object v0, v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter$ViewHolder;->onRemove Lkotlin/jvm/functions/Function1;
    invoke-interface v0, v1, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method

.method private static final bindStatus$lambda$3(com.bytedance.trae.conversation.widget.InputAttachmentAdapter$ViewHolder  com.bytedance.trae.conversation.widget.AttachmentItem  android.view.View)void
    .registers 3
    # ins_size=3
    iget-object v0, v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter$ViewHolder;->onRetry Lkotlin/jvm/functions/Function1;
    invoke-interface v0, v1, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method

.method private final extractExtension(java.lang.String  java.lang.String)java.lang.String
    .registers 9
    # ins_size=3
    if-eqz v7, +026h
    move-object v0, v7
    check-cast v0, Ljava/lang/CharSequence;
    const/16 v1, 46
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 6
    const/4 v5, 0
    invoke-static/range v0 ... v5, Lkotlin/text/StringsKt;->lastIndexOf$default(Ljava/lang/CharSequence; C I Z I Ljava/lang/Object;)I
    move-result v0
    if-ltz v0, +017h
    invoke-virtual v7, Ljava/lang/String;->length()I
    move-result v1
    add-int/lit8 v1, v1, -1
    if-ge v0, v1, +00fh
    add-int/lit8 v0, v0, 1
    invoke-virtual v7, v0, Ljava/lang/String;->substring(I)Ljava/lang/String;
    move-result-object v7
    const-string/jumbo v8, substring(...)
    invoke-static v7, v8, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v7
    const-string v7, ""
    if-eqz v8, +00ch
    const/16 v0, 47
    invoke-static v8, v0, v7, Lkotlin/text/StringsKt;->substringAfter(Ljava/lang/String; C Ljava/lang/String;)Ljava/lang/String;
    move-result-object v8
    if-nez v8, +003h
    goto +2h
    move-object v7, v8
    return-object v7
.end method

.method public final bind(com.bytedance.trae.conversation.widget.AttachmentItem)void
    .registers 7
    # ins_size=2
    const-string v0, "item"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v6, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->isImage()Z
    move-result v0
    const/4 v1, 0
    const/16 v2, 8
    if-eqz v0, +075h
    iget-object v0, v5, Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter$ViewHolder;->binding Lcom/bytedance/trae/conversation/databinding/TraeItemAttachmentBinding;
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemAttachmentBinding;->ivAttachment Lcom/facebook/drawee/view/SimpleDraweeView;
    invoke-virtual v0, v1, Lcom/facebook/drawee/view/SimpleDraweeView;->setVisibility(I)V
    iget-object v0, v5, Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter$ViewHolder;->binding Lcom/bytedance/trae/conversation/databinding/TraeItemAttachmentBinding;
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemAttachmentBinding;->ivAttachment Lcom/facebook/drawee/view/SimpleDraweeView;
    invoke-virtual v0, Lcom/facebook/drawee/view/SimpleDraweeView;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    invoke-virtual v0, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v0
    const/4 v1, 1
    const/high16 v3, 1098907648
    invoke-static v1, v3, v0, Landroid/util/TypedValue;->applyDimension(I F Landroid/util/DisplayMetrics;)F
    move-result v0
    invoke-static v0, Lcom/facebook/drawee/generic/RoundingParams;->fromCornersRadius(F)Lcom/facebook/drawee/generic/RoundingParams;
    move-result-object v0
    sget-object v3, Lcom/facebook/drawee/generic/RoundingParams$RoundingMethod;->OVERLAY_COLOR Lcom/facebook/drawee/generic/RoundingParams$RoundingMethod;
    invoke-virtual v0, v3, Lcom/facebook/drawee/generic/RoundingParams;->setRoundingMethod(Lcom/facebook/drawee/generic/RoundingParams$RoundingMethod;)Lcom/facebook/drawee/generic/RoundingParams;
    const-string v3, "#FFF5F5F5"
    invoke-static v3, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I
    move-result v3
    invoke-virtual v0, v3, Lcom/facebook/drawee/generic/RoundingParams;->setOverlayColor(I)Lcom/facebook/drawee/generic/RoundingParams;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter$ViewHolder;->binding Lcom/bytedance/trae/conversation/databinding/TraeItemAttachmentBinding;
    iget-object v3, v3, Lcom/bytedance/trae/conversation/databinding/TraeItemAttachmentBinding;->ivAttachment Lcom/facebook/drawee/view/SimpleDraweeView;
    invoke-virtual v3, Lcom/facebook/drawee/view/SimpleDraweeView;->getHierarchy()Lcom/facebook/drawee/interfaces/DraweeHierarchy;
    move-result-object v3
    check-cast v3, Lcom/facebook/drawee/generic/GenericDraweeHierarchy;
    sget-object v4, Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;->CENTER_CROP Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;
    invoke-virtual v3, v4, Lcom/facebook/drawee/generic/GenericDraweeHierarchy;->setActualImageScaleType(Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;)V
    invoke-virtual v3, v0, Lcom/facebook/drawee/generic/GenericDraweeHierarchy;->setRoundingParams(Lcom/facebook/drawee/generic/RoundingParams;)V
    invoke-static Lcom/facebook/drawee/backends/pipeline/Fresco;->newDraweeControllerBuilder()Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;
    move-result-object v0
    invoke-virtual v6, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->getUri()Landroid/net/Uri;
    move-result-object v3
    invoke-virtual v0, v3, Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;->setUri(Landroid/net/Uri;)Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;
    move-result-object v0
    invoke-virtual v0, v1, Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;->setAutoPlayAnimations(Z)Lcom/facebook/drawee/controller/AbstractDraweeControllerBuilder;
    move-result-object v0
    check-cast v0, Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;
    iget-object v1, v5, Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter$ViewHolder;->binding Lcom/bytedance/trae/conversation/databinding/TraeItemAttachmentBinding;
    iget-object v1, v1, Lcom/bytedance/trae/conversation/databinding/TraeItemAttachmentBinding;->ivAttachment Lcom/facebook/drawee/view/SimpleDraweeView;
    invoke-virtual v1, Lcom/facebook/drawee/view/SimpleDraweeView;->getController()Lcom/facebook/drawee/interfaces/DraweeController;
    move-result-object v1
    invoke-virtual v0, v1, Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;->setOldController(Lcom/facebook/drawee/interfaces/DraweeController;)Lcom/facebook/drawee/controller/AbstractDraweeControllerBuilder;
    move-result-object v0
    check-cast v0, Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;
    invoke-virtual v0, Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;->build()Lcom/facebook/drawee/controller/AbstractDraweeController;
    move-result-object v0
    iget-object v1, v5, Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter$ViewHolder;->binding Lcom/bytedance/trae/conversation/databinding/TraeItemAttachmentBinding;
    iget-object v1, v1, Lcom/bytedance/trae/conversation/databinding/TraeItemAttachmentBinding;->ivAttachment Lcom/facebook/drawee/view/SimpleDraweeView;
    check-cast v0, Lcom/facebook/drawee/interfaces/DraweeController;
    invoke-virtual v1, v0, Lcom/facebook/drawee/view/SimpleDraweeView;->setController(Lcom/facebook/drawee/interfaces/DraweeController;)V
    iget-object v0, v5, Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter$ViewHolder;->binding Lcom/bytedance/trae/conversation/databinding/TraeItemAttachmentBinding;
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemAttachmentBinding;->fileInfoOverlay Landroid/widget/FrameLayout;
    invoke-virtual v0, v2, Landroid/widget/FrameLayout;->setVisibility(I)V
    goto +42h
    iget-object v0, v5, Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter$ViewHolder;->binding Lcom/bytedance/trae/conversation/databinding/TraeItemAttachmentBinding;
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemAttachmentBinding;->ivAttachment Lcom/facebook/drawee/view/SimpleDraweeView;
    invoke-virtual v0, v2, Lcom/facebook/drawee/view/SimpleDraweeView;->setVisibility(I)V
    iget-object v0, v5, Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter$ViewHolder;->binding Lcom/bytedance/trae/conversation/databinding/TraeItemAttachmentBinding;
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemAttachmentBinding;->fileInfoOverlay Landroid/widget/FrameLayout;
    invoke-virtual v0, v1, Landroid/widget/FrameLayout;->setVisibility(I)V
    invoke-virtual v6, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->getFileName()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v6, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->getMimeType()Ljava/lang/String;
    move-result-object v1
    invoke-direct v5, v0, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter$ViewHolder;->extractExtension(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    iget-object v1, v5, Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter$ViewHolder;->binding Lcom/bytedance/trae/conversation/databinding/TraeItemAttachmentBinding;
    iget-object v1, v1, Lcom/bytedance/trae/conversation/databinding/TraeItemAttachmentBinding;->tvExtBadge Landroid/widget/TextView;
    sget-object v2, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    invoke-virtual v0, v2, Ljava/lang/String;->toUpperCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v0
    const-string/jumbo v2, toUpperCase(...)
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Ljava/lang/CharSequence;
    invoke-virtual v1, v0, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v0, v5, Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter$ViewHolder;->binding Lcom/bytedance/trae/conversation/databinding/TraeItemAttachmentBinding;
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemAttachmentBinding;->tvFileName Landroid/widget/TextView;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->getFileName()Ljava/lang/String;
    move-result-object v1
    if-eqz v1, +003h
    goto +3h
    const-string v1, ""
    check-cast v1, Ljava/lang/CharSequence;
    invoke-virtual v0, v1, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v0, v5, Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter$ViewHolder;->binding Lcom/bytedance/trae/conversation/databinding/TraeItemAttachmentBinding;
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemAttachmentBinding;->btnRemove Landroid/widget/ImageView;
    new-instance v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter$ViewHolder$$ExternalSyntheticLambda1;
    invoke-direct v1, v5, v6, Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter$ViewHolder$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter$ViewHolder; Lcom/bytedance/trae/conversation/widget/AttachmentItem;)V
    invoke-virtual v0, v1, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    invoke-virtual v5, v6, Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter$ViewHolder;->bindStatus(Lcom/bytedance/trae/conversation/widget/AttachmentItem;)V
    return-void 
.end method

.method public final bindStatus(com.bytedance.trae.conversation.widget.AttachmentItem)void
    .registers 7
    # ins_size=2
    const-string v0, "item"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v6, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->getUploadStatus()Lcom/bytedance/trae/conversation/widget/AttachmentUploadStatus;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/conversation/widget/AttachmentUploadStatus;->Uploading Lcom/bytedance/trae/conversation/widget/AttachmentUploadStatus;
    const/4 v2, 1
    const/4 v3, 0
    if-eq v0, v1, +00dh
    invoke-virtual v6, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->getUploadStatus()Lcom/bytedance/trae/conversation/widget/AttachmentUploadStatus;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/conversation/widget/AttachmentUploadStatus;->Pending Lcom/bytedance/trae/conversation/widget/AttachmentUploadStatus;
    if-ne v0, v1, +003h
    goto +3h
    move v0, v3
    goto +2h
    move v0, v2
    invoke-virtual v6, Lcom/bytedance/trae/conversation/widget/AttachmentItem;->getUploadStatus()Lcom/bytedance/trae/conversation/widget/AttachmentUploadStatus;
    move-result-object v1
    sget-object v4, Lcom/bytedance/trae/conversation/widget/AttachmentUploadStatus;->Error Lcom/bytedance/trae/conversation/widget/AttachmentUploadStatus;
    if-ne v1, v4, +003h
    goto +2h
    move v2, v3
    iget-object v1, v5, Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter$ViewHolder;->binding Lcom/bytedance/trae/conversation/databinding/TraeItemAttachmentBinding;
    iget-object v1, v1, Lcom/bytedance/trae/conversation/databinding/TraeItemAttachmentBinding;->overlayLoading Landroid/widget/FrameLayout;
    const/16 v4, 8
    if-eqz v0, +004h
    move v0, v3
    goto +2h
    move v0, v4
    invoke-virtual v1, v0, Landroid/widget/FrameLayout;->setVisibility(I)V
    iget-object v0, v5, Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter$ViewHolder;->binding Lcom/bytedance/trae/conversation/databinding/TraeItemAttachmentBinding;
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemAttachmentBinding;->overlayFailed Landroid/widget/FrameLayout;
    if-eqz v2, +003h
    goto +2h
    move v3, v4
    invoke-virtual v0, v3, Landroid/widget/FrameLayout;->setVisibility(I)V
    iget-object v0, v5, Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter$ViewHolder;->binding Lcom/bytedance/trae/conversation/databinding/TraeItemAttachmentBinding;
    iget-object v0, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemAttachmentBinding;->overlayFailed Landroid/widget/FrameLayout;
    new-instance v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter$ViewHolder$$ExternalSyntheticLambda0;
    invoke-direct v1, v5, v6, Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter$ViewHolder$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter$ViewHolder; Lcom/bytedance/trae/conversation/widget/AttachmentItem;)V
    invoke-virtual v0, v1, Landroid/widget/FrameLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-void 
.end method
