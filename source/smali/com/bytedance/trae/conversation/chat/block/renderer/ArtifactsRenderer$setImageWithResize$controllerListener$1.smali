# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$setImageWithResize$controllerListener$1;
.super Lcom/facebook/drawee/controller/BaseControllerListener;
.source "ArtifactsRenderer.kt"

.field final synthetic $container:Landroid/widget/FrameLayout;
.field final synthetic $maxSizePx:I


.method constructor <init>(int  android.widget.FrameLayout)void
    .registers 3
    # ins_size=3
    iput v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$setImageWithResize$controllerListener$1;->$maxSizePx I
    iput-object v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$setImageWithResize$controllerListener$1;->$container Landroid/widget/FrameLayout;
    invoke-direct v0, Lcom/facebook/drawee/controller/BaseControllerListener;-><init>()V
    return-void 
.end method

.method public onFinalImageSet(java.lang.String  com.facebook.imagepipeline.image.ImageInfo  android.graphics.drawable.Animatable)void
    .registers 6
    # ins_size=4
    if-nez v4, +003h
    return-void 
    invoke-interface v4, Lcom/facebook/imagepipeline/image/ImageInfo;->getWidth()I
    move-result v3
    invoke-interface v4, Lcom/facebook/imagepipeline/image/ImageInfo;->getHeight()I
    move-result v4
    if-lez v3, +033h
    if-gtz v4, +003h
    goto +2fh
    if-lt v3, v4, +00bh
    iget v5, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$setImageWithResize$controllerListener$1;->$maxSizePx I
    int-to-float v0, v5
    int-to-float v4, v4
    mul-float/2addr v0, v4
    int-to-float v3, v3
    div-float/2addr v0, v3
    float-to-int v3, v0
    goto +ch
    iget v5, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$setImageWithResize$controllerListener$1;->$maxSizePx I
    int-to-float v0, v5
    int-to-float v3, v3
    mul-float/2addr v0, v3
    int-to-float v3, v4
    div-float/2addr v0, v3
    float-to-int v3, v0
    move v1, v5
    move v5, v3
    move v3, v1
    iget-object v4, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$setImageWithResize$controllerListener$1;->$container Landroid/widget/FrameLayout;
    invoke-virtual v4, Landroid/widget/FrameLayout;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    move-result-object v4
    const-string v0, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v4, Landroid/widget/LinearLayout$LayoutParams;
    iput v5, v4, Landroid/widget/LinearLayout$LayoutParams;->width I
    iput v3, v4, Landroid/widget/LinearLayout$LayoutParams;->height I
    iget-object v3, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$setImageWithResize$controllerListener$1;->$container Landroid/widget/FrameLayout;
    check-cast v4, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v3, v4, Landroid/widget/FrameLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    return-void 
.end method

.method public bridge synthetic onFinalImageSet(java.lang.String  java.lang.Object  android.graphics.drawable.Animatable)void
    .registers 4
    # ins_size=4
    check-cast v2, Lcom/facebook/imagepipeline/image/ImageInfo;
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$setImageWithResize$controllerListener$1;->onFinalImageSet(Ljava/lang/String; Lcom/facebook/imagepipeline/image/ImageInfo; Landroid/graphics/drawable/Animatable;)V
    return-void 
.end method
