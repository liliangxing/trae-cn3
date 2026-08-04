# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder$scaleGestureDetector$1;
.super Landroid/view/ScaleGestureDetector$SimpleOnScaleGestureListener;
.source "MultiImagePreviewActivity.kt"

.field final synthetic this$0:Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;
.field final synthetic this$1:Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;


.method constructor <init>(com.bytedance.trae.conversation.products.MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder  com.bytedance.trae.conversation.products.MultiImagePreviewActivity)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder$scaleGestureDetector$1;->this$0 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder$scaleGestureDetector$1;->this$1 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
    invoke-direct v0, Landroid/view/ScaleGestureDetector$SimpleOnScaleGestureListener;-><init>()V
    return-void 
.end method

.method public onScale(android.view.ScaleGestureDetector)boolean
    .registers 4
    # ins_size=2
    const-string v0, "detector"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v3, Landroid/view/ScaleGestureDetector;->getScaleFactor()F
    move-result v3
    iget-object v0, v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder$scaleGestureDetector$1;->this$0 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->getCurrentScale()F
    move-result v0
    mul-float/2addr v0, v3
    const/high16 v3, 1056964608
    const/high16 v1, 1084227584
    invoke-static v0, v3, v1, Lkotlin/ranges/RangesKt;->coerceIn(F F F)F
    move-result v3
    iget-object v0, v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder$scaleGestureDetector$1;->this$0 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;
    invoke-virtual v0, v3, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->setCurrentScale(F)V
    iget-object v3, v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder$scaleGestureDetector$1;->this$0 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->getDraweeView()Lcom/facebook/drawee/view/SimpleDraweeView;
    move-result-object v3
    iget-object v0, v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder$scaleGestureDetector$1;->this$0 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->getCurrentScale()F
    move-result v0
    invoke-virtual v3, v0, Lcom/facebook/drawee/view/SimpleDraweeView;->setScaleX(F)V
    iget-object v3, v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder$scaleGestureDetector$1;->this$0 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->getDraweeView()Lcom/facebook/drawee/view/SimpleDraweeView;
    move-result-object v3
    iget-object v0, v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder$scaleGestureDetector$1;->this$0 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->getCurrentScale()F
    move-result v0
    invoke-virtual v3, v0, Lcom/facebook/drawee/view/SimpleDraweeView;->setScaleY(F)V
    const/4 v3, 1
    return v3
.end method

.method public onScaleBegin(android.view.ScaleGestureDetector)boolean
    .registers 3
    # ins_size=2
    const-string v0, "detector"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder$scaleGestureDetector$1;->this$0 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->getScaleAnimator()Landroid/animation/ValueAnimator;
    move-result-object v2
    if-eqz v2, +005h
    invoke-virtual v2, Landroid/animation/ValueAnimator;->cancel()V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder$scaleGestureDetector$1;->this$0 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;
    const/4 v0, 0
    invoke-virtual v2, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->setDragging(Z)V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder$scaleGestureDetector$1;->this$1 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
    invoke-static v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->access$getViewPager$p(Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;)Landroidx/viewpager2/widget/ViewPager2;
    move-result-object v2
    if-nez v2, +009h
    const-string/jumbo v2, viewPager
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v2, 0
    invoke-virtual v2, v0, Landroidx/viewpager2/widget/ViewPager2;->setUserInputEnabled(Z)V
    const/4 v2, 1
    return v2
.end method

.method public onScaleEnd(android.view.ScaleGestureDetector)void
    .registers 3
    # ins_size=2
    const-string v0, "detector"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder$scaleGestureDetector$1;->this$0 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->getCurrentScale()F
    move-result v2
    const/high16 v0, 1065353216
    cmpg-float v2, v2, v0
    if-gez v2, +007h
    iget-object v2, v1, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder$scaleGestureDetector$1;->this$0 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;
    invoke-virtual v2, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->animateToScale(F)V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder$scaleGestureDetector$1;->this$0 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->getCurrentScale()F
    move-result v2
    cmpg-float v2, v2, v0
    if-gtz v2, +015h
    iget-object v2, v1, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder$scaleGestureDetector$1;->this$1 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
    invoke-static v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->access$getViewPager$p(Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;)Landroidx/viewpager2/widget/ViewPager2;
    move-result-object v2
    if-nez v2, +009h
    const-string/jumbo v2, viewPager
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v2, 0
    const/4 v0, 1
    invoke-virtual v2, v0, Landroidx/viewpager2/widget/ViewPager2;->setUserInputEnabled(Z)V
    return-void 
.end method
