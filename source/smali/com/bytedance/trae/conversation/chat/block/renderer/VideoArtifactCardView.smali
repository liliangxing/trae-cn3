# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;
.super Landroid/widget/LinearLayout;
.source "VideoArtifactCardView.kt"

.field private final descriptor:Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactDescriptor;
.field private loadJob:Lkotlinx/coroutines/Job;
.field private final onOpen:Lkotlin/jvm/functions/Function1;
.field private final openRequest:Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;
.field private final preview:Lcom/facebook/drawee/view/SimpleDraweeView;
.field private final resourceUploadApi$delegate:Lkotlin/Lazy;


.method public static synthetic $r8$lambda$C03fZQqbasmcnpubDwl_Dq5W0ac()java.lang.String
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;->resourceUploadApi_delegate$lambda$1$lambda$0()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$Er3ruY1raT2yvKoVFx2kYNJbJUE()com.bytedance.trae.conversation.fileupload.ConversationCopilotResourceUploadApi
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;->resourceUploadApi_delegate$lambda$1()Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$LsQtTSAnG1Nda-rLfbGCUWCnqU4(com.bytedance.trae.conversation.chat.block.renderer.VideoArtifactCardView  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;->_init_$lambda$4(Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView; Landroid/view/View;)V
    return-void 
.end method

.method public constructor <init>(android.content.Context  com.bytedance.trae.kmp.artifacts.artifact.VideoArtifactDescriptor  com.bytedance.trae.kmp.artifacts.artifact.ArtifactOpenRequest  kotlin.jvm.functions.Function1)void
    .registers 6
    # ins_size=5
    const-string v0, "context"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "descriptor"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "openRequest"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "onOpen"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v2, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    iput-object v3, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;->descriptor Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactDescriptor;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;->openRequest Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;
    iput-object v5, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;->onOpen Lkotlin/jvm/functions/Function1;
    new-instance v3, Lcom/facebook/drawee/view/SimpleDraweeView;
    invoke-direct v3, v2, Lcom/facebook/drawee/view/SimpleDraweeView;-><init>(Landroid/content/Context;)V
    iput-object v3, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;->preview Lcom/facebook/drawee/view/SimpleDraweeView;
    new-instance v3, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView$$ExternalSyntheticLambda1;
    invoke-direct v3, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView$$ExternalSyntheticLambda1;-><init>()V
    invoke-static v3, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v3
    iput-object v3, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;->resourceUploadApi$delegate Lkotlin/Lazy;
    const/4 v3, 1
    invoke-virtual v1, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;->setOrientation(I)V
    invoke-virtual v1, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;->setClipToOutline(Z)V
    sget-object v4, Landroid/view/ViewOutlineProvider;->BACKGROUND Landroid/view/ViewOutlineProvider;
    invoke-virtual v1, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;->setOutlineProvider(Landroid/view/ViewOutlineProvider;)V
    new-instance v4, Landroid/graphics/drawable/GradientDrawable;
    invoke-direct v4, Landroid/graphics/drawable/GradientDrawable;-><init>()V
    sget v5, Lcom/bytedance/trae/common_ui/R$color;->trae_bg_bg_card I
    invoke-static v2, v5, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v5
    invoke-virtual v4, v5, Landroid/graphics/drawable/GradientDrawable;->setColor(I)V
    sget v5, Lcom/bytedance/trae/common_ui/R$dimen;->trae_video_artifact_card_radius I
    invoke-direct v1, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;->dimen(I)I
    move-result v5
    int-to-float v5, v5
    invoke-virtual v4, v5, Landroid/graphics/drawable/GradientDrawable;->setCornerRadius(F)V
    sget v5, Lcom/bytedance/trae/common_ui/R$dimen;->trae_video_artifact_card_border_width I
    invoke-direct v1, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;->dimen(I)I
    move-result v5
    sget v0, Lcom/bytedance/trae/common_ui/R$color;->trae_border_border_neutral_l1 I
    invoke-static v2, v0, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v2
    invoke-virtual v4, v5, v2, Landroid/graphics/drawable/GradientDrawable;->setStroke(I I)V
    check-cast v4, Landroid/graphics/drawable/Drawable;
    invoke-virtual v1, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;->setBackground(Landroid/graphics/drawable/Drawable;)V
    new-instance v2, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v4, -1
    const/4 v5, -2
    invoke-direct v2, v4, v5, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    sget v4, Lcom/bytedance/trae/common_ui/R$dimen;->trae_video_artifact_card_bottom_margin I
    invoke-direct v1, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;->dimen(I)I
    move-result v4
    iput v4, v2, Landroid/widget/LinearLayout$LayoutParams;->bottomMargin I
    check-cast v2, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    invoke-virtual v1, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;->setClickable(Z)V
    invoke-virtual v1, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;->setFocusable(Z)V
    new-instance v2, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView$$ExternalSyntheticLambda2;
    invoke-direct v2, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;)V
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    invoke-direct v1, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;->createHeader()Landroid/view/View;
    move-result-object v2
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;->addView(Landroid/view/View;)V
    invoke-direct v1, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;->createPreview()Landroid/view/View;
    move-result-object v2
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;->addView(Landroid/view/View;)V
    invoke-direct v1, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;->updateAccessibility()V
    return-void 
.end method

.method private static final _init_$lambda$4(com.bytedance.trae.conversation.chat.block.renderer.VideoArtifactCardView  android.view.View)void
    .registers 2
    # ins_size=2
    iget-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;->onOpen Lkotlin/jvm/functions/Function1;
    iget-object v0, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;->openRequest Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;
    invoke-interface v1, v0, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method

.method public static final synthetic access$getResourceUploadApi(com.bytedance.trae.conversation.chat.block.renderer.VideoArtifactCardView)com.bytedance.trae.conversation.fileupload.ConversationCopilotResourceUploadApi
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;->getResourceUploadApi()Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$loadLastFrame(com.bytedance.trae.conversation.chat.block.renderer.VideoArtifactCardView  java.lang.String)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;->loadLastFrame(Ljava/lang/String;)V
    return-void 
.end method

.method private final createHeader()android.view.View
    .registers 11
    # ins_size=1
    new-instance v0, Landroid/widget/FrameLayout;
    invoke-virtual v10, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;->getContext()Landroid/content/Context;
    move-result-object v1
    invoke-direct v0, v1, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;)V
    new-instance v1, Landroid/widget/LinearLayout$LayoutParams;
    sget v2, Lcom/bytedance/trae/common_ui/R$dimen;->trae_video_artifact_card_header_height I
    invoke-direct v10, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;->dimen(I)I
    move-result v2
    const/4 v3, -1
    invoke-direct v1, v3, v2, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v1, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v1, Landroid/widget/FrameLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    sget v1, Lcom/bytedance/trae/common_ui/R$dimen;->trae_video_artifact_card_header_horizontal_padding I
    invoke-direct v10, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;->dimen(I)I
    move-result v1
    sget v2, Lcom/bytedance/trae/common_ui/R$dimen;->trae_video_artifact_card_header_vertical_padding I
    invoke-direct v10, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;->dimen(I)I
    move-result v2
    sget v4, Lcom/bytedance/trae/common_ui/R$dimen;->trae_video_artifact_card_header_horizontal_padding I
    invoke-direct v10, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;->dimen(I)I
    move-result v4
    sget v5, Lcom/bytedance/trae/common_ui/R$dimen;->trae_video_artifact_card_header_vertical_padding I
    invoke-direct v10, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;->dimen(I)I
    move-result v5
    invoke-virtual v0, v1, v2, v4, v5, Landroid/widget/FrameLayout;->setPadding(I I I I)V
    new-instance v1, Landroid/widget/LinearLayout;
    invoke-virtual v10, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;->getContext()Landroid/content/Context;
    move-result-object v2
    invoke-direct v1, v2, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v2, 0
    invoke-virtual v1, v2, Landroid/widget/LinearLayout;->setOrientation(I)V
    const/16 v4, 16
    invoke-virtual v1, v4, Landroid/widget/LinearLayout;->setGravity(I)V
    new-instance v4, Landroid/widget/FrameLayout;
    invoke-virtual v10, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;->getContext()Landroid/content/Context;
    move-result-object v5
    invoke-direct v4, v5, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;)V
    new-instance v5, Landroid/widget/ImageView;
    invoke-virtual v10, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;->getContext()Landroid/content/Context;
    move-result-object v6
    invoke-direct v5, v6, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V
    sget v6, Lcom/bytedance/trae/conversation/R$drawable;->ic_artifact_video I
    invoke-virtual v5, v6, Landroid/widget/ImageView;->setImageResource(I)V
    sget-object v6, Landroid/widget/ImageView$ScaleType;->FIT_CENTER Landroid/widget/ImageView$ScaleType;
    invoke-virtual v5, v6, Landroid/widget/ImageView;->setScaleType(Landroid/widget/ImageView$ScaleType;)V
    check-cast v5, Landroid/view/View;
    new-instance v6, Landroid/widget/FrameLayout$LayoutParams;
    sget v7, Lcom/bytedance/trae/common_ui/R$dimen;->trae_video_artifact_card_file_icon_size I
    invoke-direct v10, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;->dimen(I)I
    move-result v7
    sget v8, Lcom/bytedance/trae/common_ui/R$dimen;->trae_video_artifact_card_file_icon_size I
    invoke-direct v10, v8, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;->dimen(I)I
    move-result v8
    const/16 v9, 17
    invoke-direct v6, v7, v8, v9, Landroid/widget/FrameLayout$LayoutParams;-><init>(I I I)V
    check-cast v6, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v4, v5, v6, Landroid/widget/FrameLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v4, Landroid/view/View;
    new-instance v5, Landroid/widget/LinearLayout$LayoutParams;
    sget v6, Lcom/bytedance/trae/common_ui/R$dimen;->trae_video_artifact_card_file_icon_container_size I
    invoke-direct v10, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;->dimen(I)I
    move-result v6
    sget v7, Lcom/bytedance/trae/common_ui/R$dimen;->trae_video_artifact_card_file_icon_container_size I
    invoke-direct v10, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;->dimen(I)I
    move-result v7
    invoke-direct v5, v6, v7, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v5, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v1, v4, v5, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v4, Landroid/widget/TextView;
    invoke-virtual v10, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;->getContext()Landroid/content/Context;
    move-result-object v5
    const/4 v6, 0
    sget v7, Lcom/bytedance/trae/common_ui/R$style;->Trae_Text_Body_Base I
    invoke-direct v4, v5, v6, v2, v7, Landroid/widget/TextView;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I I)V
    iget-object v5, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;->descriptor Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactDescriptor;
    invoke-virtual v5, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactDescriptor;->getTitle()Ljava/lang/String;
    move-result-object v5
    check-cast v5, Ljava/lang/CharSequence;
    invoke-virtual v4, v5, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    const/4 v5, 1
    invoke-virtual v4, v5, Landroid/widget/TextView;->setMaxLines(I)V
    sget-object v5, Landroid/text/TextUtils$TruncateAt;->END Landroid/text/TextUtils$TruncateAt;
    invoke-virtual v4, v5, Landroid/widget/TextView;->setEllipsize(Landroid/text/TextUtils$TruncateAt;)V
    invoke-virtual v4, v2, Landroid/widget/TextView;->setIncludeFontPadding(Z)V
    const v5, -1127267854
    invoke-virtual v4, v5, Landroid/widget/TextView;->setLetterSpacing(F)V
    check-cast v4, Landroid/view/View;
    new-instance v5, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v6, -2
    const/high16 v7, 1065353216
    invoke-direct v5, v2, v6, v7, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I F)V
    sget v2, Lcom/bytedance/trae/common_ui/R$dimen;->trae_video_artifact_card_title_gap I
    invoke-direct v10, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;->dimen(I)I
    move-result v2
    invoke-virtual v5, v2, Landroid/widget/LinearLayout$LayoutParams;->setMarginStart(I)V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    check-cast v5, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v1, v4, v5, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v1, Landroid/view/View;
    new-instance v2, Landroid/widget/FrameLayout$LayoutParams;
    invoke-direct v2, v3, v3, Landroid/widget/FrameLayout$LayoutParams;-><init>(I I)V
    check-cast v2, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v1, v2, Landroid/widget/FrameLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v0, Landroid/view/View;
    return-object v0
.end method

.method private final createPreview()android.view.View
    .registers 10
    # ins_size=1
    new-instance v0, Landroid/widget/FrameLayout;
    invoke-virtual v9, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;->getContext()Landroid/content/Context;
    move-result-object v1
    invoke-direct v0, v1, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;)V
    new-instance v1, Landroid/widget/LinearLayout$LayoutParams;
    sget v2, Lcom/bytedance/trae/common_ui/R$dimen;->trae_video_artifact_card_preview_height I
    invoke-direct v9, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;->dimen(I)I
    move-result v2
    const/4 v3, -1
    invoke-direct v1, v3, v2, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v1, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v1, Landroid/widget/FrameLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    iget-object v1, v9, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;->preview Lcom/facebook/drawee/view/SimpleDraweeView;
    new-instance v2, Lcom/facebook/drawee/generic/GenericDraweeHierarchyBuilder;
    invoke-virtual v0, Landroid/widget/FrameLayout;->getResources()Landroid/content/res/Resources;
    move-result-object v4
    invoke-direct v2, v4, Lcom/facebook/drawee/generic/GenericDraweeHierarchyBuilder;-><init>(Landroid/content/res/Resources;)V
    sget v4, Lcom/bytedance/trae/common_ui/R$drawable;->trae_bg_image_loading I
    sget-object v5, Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;->CENTER_CROP Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;
    invoke-virtual v2, v4, v5, Lcom/facebook/drawee/generic/GenericDraweeHierarchyBuilder;->setPlaceholderImage(I Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;)Lcom/facebook/drawee/generic/GenericDraweeHierarchyBuilder;
    move-result-object v2
    sget-object v4, Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;->CENTER_CROP Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;
    invoke-virtual v2, v4, Lcom/facebook/drawee/generic/GenericDraweeHierarchyBuilder;->setActualImageScaleType(Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;)Lcom/facebook/drawee/generic/GenericDraweeHierarchyBuilder;
    move-result-object v2
    invoke-virtual v2, Lcom/facebook/drawee/generic/GenericDraweeHierarchyBuilder;->build()Lcom/facebook/drawee/generic/GenericDraweeHierarchy;
    move-result-object v2
    check-cast v2, Lcom/facebook/drawee/interfaces/DraweeHierarchy;
    invoke-virtual v1, v2, Lcom/facebook/drawee/view/SimpleDraweeView;->setHierarchy(Lcom/facebook/drawee/interfaces/DraweeHierarchy;)V
    iget-object v1, v9, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;->preview Lcom/facebook/drawee/view/SimpleDraweeView;
    check-cast v1, Landroid/view/View;
    new-instance v2, Landroid/widget/FrameLayout$LayoutParams;
    invoke-direct v2, v3, v3, Landroid/widget/FrameLayout$LayoutParams;-><init>(I I)V
    check-cast v2, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v1, v2, Landroid/widget/FrameLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v1, Landroid/view/View;
    invoke-virtual v0, Landroid/widget/FrameLayout;->getContext()Landroid/content/Context;
    move-result-object v2
    invoke-direct v1, v2, Landroid/view/View;-><init>(Landroid/content/Context;)V
    invoke-virtual v1, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v2
    sget v4, Lcom/bytedance/trae/common_ui/R$color;->trae_border_border_neutral_l1 I
    invoke-static v2, v4, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v2
    invoke-virtual v1, v2, Landroid/view/View;->setBackgroundColor(I)V
    new-instance v2, Landroid/widget/FrameLayout$LayoutParams;
    sget v4, Lcom/bytedance/trae/common_ui/R$dimen;->trae_video_artifact_card_divider_height I
    invoke-direct v9, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;->dimen(I)I
    move-result v4
    const/16 v5, 48
    invoke-direct v2, v3, v4, v5, Landroid/widget/FrameLayout$LayoutParams;-><init>(I I I)V
    check-cast v2, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v1, v2, Landroid/widget/FrameLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v1, Landroid/view/View;
    invoke-virtual v0, Landroid/widget/FrameLayout;->getContext()Landroid/content/Context;
    move-result-object v2
    invoke-direct v1, v2, Landroid/view/View;-><init>(Landroid/content/Context;)V
    new-instance v2, Landroid/graphics/drawable/GradientDrawable;
    sget-object v4, Landroid/graphics/drawable/GradientDrawable$Orientation;->TOP_BOTTOM Landroid/graphics/drawable/GradientDrawable$Orientation;
    const/4 v5, 2
    new-array v5, v5, [I
    invoke-virtual v1, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v6
    sget v7, Lcom/bytedance/trae/conversation/R$color;->trae_video_artifact_card_gradient_start I
    invoke-static v6, v7, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v6
    const/4 v7, 0
    aput v6, v5, v7
    invoke-virtual v1, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v6
    sget v8, Lcom/bytedance/trae/conversation/R$color;->trae_video_artifact_card_gradient_end I
    invoke-static v6, v8, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v6
    const/4 v8, 1
    aput v6, v5, v8
    invoke-direct v2, v4, v5, Landroid/graphics/drawable/GradientDrawable;-><init>(Landroid/graphics/drawable/GradientDrawable$Orientation; [I)V
    check-cast v2, Landroid/graphics/drawable/Drawable;
    invoke-virtual v1, v2, Landroid/view/View;->setBackground(Landroid/graphics/drawable/Drawable;)V
    new-instance v2, Landroid/widget/FrameLayout$LayoutParams;
    sget v4, Lcom/bytedance/trae/common_ui/R$dimen;->trae_video_artifact_card_gradient_height I
    invoke-direct v9, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;->dimen(I)I
    move-result v4
    const/16 v5, 80
    invoke-direct v2, v3, v4, v5, Landroid/widget/FrameLayout$LayoutParams;-><init>(I I I)V
    check-cast v2, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v1, v2, Landroid/widget/FrameLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v1, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactPlayButtonView;
    invoke-virtual v0, Landroid/widget/FrameLayout;->getContext()Landroid/content/Context;
    move-result-object v2
    const-string v3, "getContext(...)"
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactPlayButtonView;-><init>(Landroid/content/Context;)V
    check-cast v1, Landroid/view/View;
    new-instance v2, Landroid/widget/FrameLayout$LayoutParams;
    sget v3, Lcom/bytedance/trae/common_ui/R$dimen;->trae_video_artifact_card_play_button_size I
    invoke-direct v9, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;->dimen(I)I
    move-result v3
    sget v4, Lcom/bytedance/trae/common_ui/R$dimen;->trae_video_artifact_card_play_button_size I
    invoke-direct v9, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;->dimen(I)I
    move-result v4
    const/16 v5, 17
    invoke-direct v2, v3, v4, v5, Landroid/widget/FrameLayout$LayoutParams;-><init>(I I I)V
    check-cast v2, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v1, v2, Landroid/widget/FrameLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v1, Landroid/widget/TextView;
    invoke-virtual v0, Landroid/widget/FrameLayout;->getContext()Landroid/content/Context;
    move-result-object v2
    invoke-direct v1, v2, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    iget-object v2, v9, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;->descriptor Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactDescriptor;
    invoke-virtual v2, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactDescriptor;->getFormattedDuration()Ljava/lang/String;
    move-result-object v2
    check-cast v2, Ljava/lang/CharSequence;
    invoke-virtual v1, v2, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    invoke-virtual v1, v5, Landroid/widget/TextView;->setGravity(I)V
    invoke-virtual v1, v7, Landroid/widget/TextView;->setIncludeFontPadding(Z)V
    const v2, -1144313505
    invoke-virtual v1, v2, Landroid/widget/TextView;->setLetterSpacing(F)V
    invoke-virtual v1, Landroid/widget/TextView;->getContext()Landroid/content/Context;
    move-result-object v2
    sget v3, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_white I
    invoke-static v2, v3, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v2
    invoke-virtual v1, v2, Landroid/widget/TextView;->setTextColor(I)V
    invoke-virtual v1, Landroid/widget/TextView;->getResources()Landroid/content/res/Resources;
    move-result-object v2
    sget v3, Lcom/bytedance/trae/common_ui/R$dimen;->trae_footnote_footnote_font_size_sp I
    invoke-virtual v2, v3, Landroid/content/res/Resources;->getDimension(I)F
    move-result v2
    invoke-virtual v1, v7, v2, Landroid/widget/TextView;->setTextSize(I F)V
    sget v2, Lcom/bytedance/trae/common_ui/R$dimen;->trae_footnote_footnote_line_height_dp I
    invoke-direct v9, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;->dimen(I)I
    move-result v2
    invoke-static v1, v2, Landroidx/core/widget/TextViewCompat;->setLineHeight(Landroid/widget/TextView; I)V
    new-instance v2, Landroid/graphics/drawable/GradientDrawable;
    invoke-direct v2, Landroid/graphics/drawable/GradientDrawable;-><init>()V
    sget v3, Lcom/bytedance/trae/common_ui/R$dimen;->trae_context_menu_radius I
    invoke-direct v9, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;->dimen(I)I
    move-result v3
    int-to-float v3, v3
    invoke-virtual v2, v3, Landroid/graphics/drawable/GradientDrawable;->setCornerRadius(F)V
    invoke-virtual v1, Landroid/widget/TextView;->getContext()Landroid/content/Context;
    move-result-object v3
    sget v4, Lcom/bytedance/trae/common_ui/R$color;->trae_icon_icon_onbrand I
    invoke-static v3, v4, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v3
    const/high16 v4, 1120665600
    invoke-static v4, Lkotlin/math/MathKt;->roundToInt(F)I
    move-result v4
    invoke-static v3, v4, Landroidx/core/graphics/ColorUtils;->setAlphaComponent(I I)I
    move-result v3
    invoke-virtual v2, v3, Landroid/graphics/drawable/GradientDrawable;->setColor(I)V
    check-cast v2, Landroid/graphics/drawable/Drawable;
    invoke-virtual v1, v2, Landroid/widget/TextView;->setBackground(Landroid/graphics/drawable/Drawable;)V
    sget v2, Lcom/bytedance/trae/common_ui/R$dimen;->trae_video_artifact_card_duration_horizontal_padding I
    invoke-direct v9, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;->dimen(I)I
    move-result v2
    sget v3, Lcom/bytedance/trae/common_ui/R$dimen;->trae_video_artifact_card_duration_horizontal_padding I
    invoke-direct v9, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;->dimen(I)I
    move-result v3
    invoke-virtual v1, v2, v7, v3, v7, Landroid/widget/TextView;->setPadding(I I I I)V
    check-cast v1, Landroid/view/View;
    new-instance v2, Landroid/widget/FrameLayout$LayoutParams;
    sget v3, Lcom/bytedance/trae/common_ui/R$dimen;->trae_video_artifact_card_duration_height I
    invoke-direct v9, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;->dimen(I)I
    move-result v3
    const v4, 8388693
    const/4 v5, -2
    invoke-direct v2, v5, v3, v4, Landroid/widget/FrameLayout$LayoutParams;-><init>(I I I)V
    sget v3, Lcom/bytedance/trae/common_ui/R$dimen;->trae_video_artifact_card_duration_end_margin I
    invoke-direct v9, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;->dimen(I)I
    move-result v3
    invoke-virtual v2, v3, Landroid/widget/FrameLayout$LayoutParams;->setMarginEnd(I)V
    sget v3, Lcom/bytedance/trae/common_ui/R$dimen;->trae_video_artifact_card_duration_bottom_margin I
    invoke-direct v9, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;->dimen(I)I
    move-result v3
    iput v3, v2, Landroid/widget/FrameLayout$LayoutParams;->bottomMargin I
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    check-cast v2, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v1, v2, Landroid/widget/FrameLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v0, Landroid/view/View;
    return-object v0
.end method

.method private final dimen(int)int
    .registers 3
    # ins_size=2
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    invoke-virtual v0, v2, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v2
    return v2
.end method

.method private final getResourceUploadApi()com.bytedance.trae.conversation.fileupload.ConversationCopilotResourceUploadApi
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;->resourceUploadApi$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi;
    return-object v0
.end method

.method private final loadLastFrame(java.lang.String)void
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;->preview Lcom/facebook/drawee/view/SimpleDraweeView;
    invoke-static Lcom/facebook/drawee/backends/pipeline/Fresco;->newDraweeControllerBuilder()Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;
    move-result-object v1
    invoke-static v3, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v3
    invoke-virtual v1, v3, Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;->setUri(Landroid/net/Uri;)Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;
    move-result-object v3
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;->preview Lcom/facebook/drawee/view/SimpleDraweeView;
    invoke-virtual v1, Lcom/facebook/drawee/view/SimpleDraweeView;->getController()Lcom/facebook/drawee/interfaces/DraweeController;
    move-result-object v1
    invoke-virtual v3, v1, Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;->setOldController(Lcom/facebook/drawee/interfaces/DraweeController;)Lcom/facebook/drawee/controller/AbstractDraweeControllerBuilder;
    move-result-object v3
    check-cast v3, Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;
    invoke-virtual v3, Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;->build()Lcom/facebook/drawee/controller/AbstractDraweeController;
    move-result-object v3
    check-cast v3, Lcom/facebook/drawee/interfaces/DraweeController;
    invoke-virtual v0, v3, Lcom/facebook/drawee/view/SimpleDraweeView;->setController(Lcom/facebook/drawee/interfaces/DraweeController;)V
    return-void 
.end method

.method private static final resourceUploadApi_delegate$lambda$1()com.bytedance.trae.conversation.fileupload.ConversationCopilotResourceUploadApi
    .registers 7
    # ins_size=0
    new-instance v6, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi;
    new-instance v1, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView$$ExternalSyntheticLambda0;
    invoke-direct v1, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView$$ExternalSyntheticLambda0;-><init>()V
    const/4 v2, 0
    const-string/jumbo v3, video_artifact_last_frame
    const/4 v4, 2
    const/4 v5, 0
    move-object v0, v6
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi;-><init>(Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function1; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v6
.end method

.method private static final resourceUploadApi_delegate$lambda$1$lambda$0()java.lang.String
    .registers 2
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/network/HostResolver;->INSTANCE Lcom/bytedance/trae/network/HostResolver;
    sget-object v1, Lcom/bytedance/trae/network/HostType;->AI Lcom/bytedance/trae/network/HostType;
    invoke-virtual v0, v1, Lcom/bytedance/trae/network/HostResolver;->getBaseUrl(Lcom/bytedance/trae/network/HostType;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method private final updateAccessibility()void
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "Video artifact card: "
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;->descriptor Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactDescriptor;
    invoke-virtual v1, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactDescriptor;->getTitle()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    const-string v1, ", "
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;->descriptor Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactDescriptor;
    invoke-virtual v1, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactDescriptor;->getFormattedDuration()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-virtual v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;->setContentDescription(Ljava/lang/CharSequence;)V
    return-void 
.end method

.method protected onAttachedToWindow()void
    .registers 10
    # ins_size=1
    invoke-super v9, Landroid/widget/LinearLayout;->onAttachedToWindow()V
    iget-object v0, v9, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;->descriptor Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactDescriptor;
    invoke-virtual v0, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactDescriptor;->getLastFrameUri()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +003h
    return-void 
    sget-object v1, Lcom/bytedance/trae/conversation/imageupload/ResourceRepoManager;->INSTANCE Lcom/bytedance/trae/conversation/imageupload/ResourceRepoManager;
    invoke-virtual v1, v0, Lcom/bytedance/trae/conversation/imageupload/ResourceRepoManager;->get(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    if-eqz v1, +006h
    invoke-direct v9, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;->loadLastFrame(Ljava/lang/String;)V
    return-void 
    move-object v1, v9
    check-cast v1, Landroid/view/View;
    invoke-static v1, Landroidx/lifecycle/ViewTreeLifecycleOwner;->get(Landroid/view/View;)Landroidx/lifecycle/LifecycleOwner;
    move-result-object v1
    const/4 v2, 0
    if-nez v1, +011h
    invoke-virtual v9, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;->getContext()Landroid/content/Context;
    move-result-object v1
    instance-of v3, v1, Landroidx/lifecycle/LifecycleOwner;
    if-eqz v3, +005h
    check-cast v1, Landroidx/lifecycle/LifecycleOwner;
    goto +2h
    move-object v1, v2
    if-nez v1, +003h
    return-void 
    iget-object v3, v9, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;->loadJob Lkotlinx/coroutines/Job;
    if-eqz v3, +006h
    const/4 v4, 1
    invoke-static v3, v2, v4, v2, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    invoke-static v1, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v1
    move-object v3, v1
    check-cast v3, Lkotlinx/coroutines/CoroutineScope;
    const/4 v4, 0
    const/4 v5, 0
    new-instance v1, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView$onAttachedToWindow$2;
    invoke-direct v1, v0, v9, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView$onAttachedToWindow$2;-><init>(Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView; Lkotlin/coroutines/Continuation;)V
    move-object v6, v1
    check-cast v6, Lkotlin/jvm/functions/Function2;
    const/4 v7, 3
    const/4 v8, 0
    invoke-static/range v3 ... v8, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    move-result-object v0
    iput-object v0, v9, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;->loadJob Lkotlinx/coroutines/Job;
    return-void 
.end method

.method protected onDetachedFromWindow()void
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;->loadJob Lkotlinx/coroutines/Job;
    const/4 v1, 0
    if-eqz v0, +006h
    const/4 v2, 1
    invoke-static v0, v1, v2, v1, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    iput-object v1, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;->loadJob Lkotlinx/coroutines/Job;
    invoke-super v3, Landroid/widget/LinearLayout;->onDetachedFromWindow()V
    return-void 
.end method
