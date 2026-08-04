# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormPreviewImageLoader;
.super Ljava/lang/Object;
.source "BrainstormAttachmentImageLoader.kt"

.field private loadedUri:Ljava/lang/String;
.field private final view:Lcom/facebook/drawee/view/SimpleDraweeView;


.method public constructor <init>(com.facebook.drawee.view.SimpleDraweeView)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, view
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormPreviewImageLoader;->view Lcom/facebook/drawee/view/SimpleDraweeView;
    return-void 
.end method

.method public final clear()void
    .registers 3
    # ins_size=1
    const/4 v0, 0
    iput-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormPreviewImageLoader;->loadedUri Ljava/lang/String;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormPreviewImageLoader;->view Lcom/facebook/drawee/view/SimpleDraweeView;
    invoke-virtual v1, v0, Lcom/facebook/drawee/view/SimpleDraweeView;->setController(Lcom/facebook/drawee/interfaces/DraweeController;)V
    return-void 
.end method

.method public final load(java.lang.String)void
    .registers 5
    # ins_size=2
    const-string/jumbo v0, uri
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormPreviewImageLoader;->loadedUri Ljava/lang/String;
    invoke-static v0, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +00bh
    iget-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormPreviewImageLoader;->view Lcom/facebook/drawee/view/SimpleDraweeView;
    invoke-virtual v0, Lcom/facebook/drawee/view/SimpleDraweeView;->getController()Lcom/facebook/drawee/interfaces/DraweeController;
    move-result-object v0
    if-eqz v0, +003h
    return-void 
    iput-object v4, v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormPreviewImageLoader;->loadedUri Ljava/lang/String;
    iget-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormPreviewImageLoader;->view Lcom/facebook/drawee/view/SimpleDraweeView;
    invoke-virtual v0, Lcom/facebook/drawee/view/SimpleDraweeView;->getHierarchy()Lcom/facebook/drawee/interfaces/DraweeHierarchy;
    move-result-object v0
    check-cast v0, Lcom/facebook/drawee/generic/GenericDraweeHierarchy;
    sget v1, Lcom/bytedance/trae/common_ui/R$drawable;->trae_bg_image_loading I
    sget-object v2, Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;->CENTER_CROP Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;
    invoke-virtual v0, v1, v2, Lcom/facebook/drawee/generic/GenericDraweeHierarchy;->setPlaceholderImage(I Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;)V
    iget-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormPreviewImageLoader;->view Lcom/facebook/drawee/view/SimpleDraweeView;
    invoke-static Lcom/facebook/drawee/backends/pipeline/Fresco;->newDraweeControllerBuilder()Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;
    move-result-object v1
    invoke-static v4, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v4
    invoke-virtual v1, v4, Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;->setUri(Landroid/net/Uri;)Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;
    move-result-object v4
    const/4 v1, 1
    invoke-virtual v4, v1, Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;->setAutoPlayAnimations(Z)Lcom/facebook/drawee/controller/AbstractDraweeControllerBuilder;
    move-result-object v4
    check-cast v4, Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormPreviewImageLoader;->view Lcom/facebook/drawee/view/SimpleDraweeView;
    invoke-virtual v1, Lcom/facebook/drawee/view/SimpleDraweeView;->getController()Lcom/facebook/drawee/interfaces/DraweeController;
    move-result-object v1
    invoke-virtual v4, v1, Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;->setOldController(Lcom/facebook/drawee/interfaces/DraweeController;)Lcom/facebook/drawee/controller/AbstractDraweeControllerBuilder;
    move-result-object v4
    check-cast v4, Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;
    invoke-virtual v4, Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;->build()Lcom/facebook/drawee/controller/AbstractDraweeController;
    move-result-object v4
    check-cast v4, Lcom/facebook/drawee/interfaces/DraweeController;
    invoke-virtual v0, v4, Lcom/facebook/drawee/view/SimpleDraweeView;->setController(Lcom/facebook/drawee/interfaces/DraweeController;)V
    return-void 
.end method
