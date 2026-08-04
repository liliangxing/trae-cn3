# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$scaleGestureDetector$2$1;
.super Landroid/view/ScaleGestureDetector$SimpleOnScaleGestureListener;
.source "ArtifactPreviewActivity.kt"

.field final synthetic this$0:Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;


.method constructor <init>(com.bytedance.trae.conversation.products.ArtifactPreviewActivity)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$scaleGestureDetector$2$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
    invoke-direct v0, Landroid/view/ScaleGestureDetector$SimpleOnScaleGestureListener;-><init>()V
    return-void 
.end method

.method public onScale(android.view.ScaleGestureDetector)boolean
    .registers 5
    # ins_size=2
    const-string v0, "detector"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v4, Landroid/view/ScaleGestureDetector;->getScaleFactor()F
    move-result v4
    iget-object v0, v3, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$scaleGestureDetector$2$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
    invoke-static v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->access$getCurrentScale$p(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;)F
    move-result v0
    mul-float/2addr v0, v4
    const/high16 v4, 1056964608
    const/high16 v1, 1084227584
    invoke-static v0, v4, v1, Lkotlin/ranges/RangesKt;->coerceIn(F F F)F
    move-result v4
    iget-object v0, v3, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$scaleGestureDetector$2$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
    invoke-static v0, v4, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->access$setCurrentScale$p(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity; F)V
    iget-object v4, v3, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$scaleGestureDetector$2$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
    invoke-static v4, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->access$getIvPreview$p(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;)Lcom/facebook/drawee/view/SimpleDraweeView;
    move-result-object v4
    const/4 v0, 0
    const-string v1, "ivPreview"
    if-nez v4, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v4, v0
    iget-object v2, v3, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$scaleGestureDetector$2$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
    invoke-static v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->access$getCurrentScale$p(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;)F
    move-result v2
    invoke-virtual v4, v2, Lcom/facebook/drawee/view/SimpleDraweeView;->setScaleX(F)V
    iget-object v4, v3, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$scaleGestureDetector$2$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
    invoke-static v4, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->access$getIvPreview$p(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;)Lcom/facebook/drawee/view/SimpleDraweeView;
    move-result-object v4
    if-nez v4, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v0, v4
    iget-object v4, v3, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$scaleGestureDetector$2$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
    invoke-static v4, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->access$getCurrentScale$p(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;)F
    move-result v4
    invoke-virtual v0, v4, Lcom/facebook/drawee/view/SimpleDraweeView;->setScaleY(F)V
    const/4 v4, 1
    return v4
.end method

.method public onScaleBegin(android.view.ScaleGestureDetector)boolean
    .registers 3
    # ins_size=2
    const-string v0, "detector"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$scaleGestureDetector$2$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
    invoke-static v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->access$getScaleAnimator$p(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;)Landroid/animation/ValueAnimator;
    move-result-object v2
    if-eqz v2, +005h
    invoke-virtual v2, Landroid/animation/ValueAnimator;->cancel()V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$scaleGestureDetector$2$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
    const/4 v0, 0
    invoke-static v2, v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->access$setDragging$p(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity; Z)V
    const/4 v2, 1
    return v2
.end method

.method public onScaleEnd(android.view.ScaleGestureDetector)void
    .registers 3
    # ins_size=2
    const-string v0, "detector"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$scaleGestureDetector$2$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
    invoke-static v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->access$getCurrentScale$p(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;)F
    move-result v2
    const/high16 v0, 1065353216
    cmpg-float v2, v2, v0
    if-gez v2, +007h
    iget-object v2, v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$scaleGestureDetector$2$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
    invoke-static v2, v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->access$animateToScale(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity; F)V
    return-void 
.end method
