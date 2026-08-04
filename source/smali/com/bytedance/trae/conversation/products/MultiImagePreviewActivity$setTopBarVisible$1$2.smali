# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$setTopBarVisible$1$2;
.super Landroid/animation/AnimatorListenerAdapter;
.source "MultiImagePreviewActivity.kt"

.field final synthetic $endAlpha:F
.field final synthetic $endMarginTop:I
.field final synthetic $params:Landroid/view/ViewGroup$MarginLayoutParams;
.field final synthetic $visible:Z
.field final synthetic this$0:Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;


.method constructor <init>(android.view.ViewGroup$MarginLayoutParams  int  com.bytedance.trae.conversation.products.MultiImagePreviewActivity  float  boolean)void
    .registers 6
    # ins_size=6
    iput-object v1, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$setTopBarVisible$1$2;->$params Landroid/view/ViewGroup$MarginLayoutParams;
    iput v2, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$setTopBarVisible$1$2;->$endMarginTop I
    iput-object v3, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$setTopBarVisible$1$2;->this$0 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
    iput v4, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$setTopBarVisible$1$2;->$endAlpha F
    iput-boolean v5, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$setTopBarVisible$1$2;->$visible Z
    invoke-direct v0, Landroid/animation/AnimatorListenerAdapter;-><init>()V
    return-void 
.end method

.method public onAnimationEnd(android.animation.Animator)void
    .registers 5
    # ins_size=2
    const-string v0, "animation"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v4, v3, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$setTopBarVisible$1$2;->$params Landroid/view/ViewGroup$MarginLayoutParams;
    iget v0, v3, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$setTopBarVisible$1$2;->$endMarginTop I
    iput v0, v4, Landroid/view/ViewGroup$MarginLayoutParams;->topMargin I
    iget-object v4, v3, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$setTopBarVisible$1$2;->this$0 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
    invoke-static v4, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->access$getViewPager$p(Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;)Landroidx/viewpager2/widget/ViewPager2;
    move-result-object v4
    const/4 v0, 0
    if-nez v4, +009h
    const-string/jumbo v4, viewPager
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v4, v0
    iget-object v1, v3, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$setTopBarVisible$1$2;->$params Landroid/view/ViewGroup$MarginLayoutParams;
    check-cast v1, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v4, v1, Landroidx/viewpager2/widget/ViewPager2;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    iget-object v4, v3, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$setTopBarVisible$1$2;->this$0 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
    invoke-static v4, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->access$getTopBar$p(Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;)Landroid/view/View;
    move-result-object v4
    const-string/jumbo v1, topBar
    if-nez v4, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v4, v0
    iget v2, v3, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$setTopBarVisible$1$2;->$endAlpha F
    invoke-virtual v4, v2, Landroid/view/View;->setAlpha(F)V
    iget-boolean v4, v3, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$setTopBarVisible$1$2;->$visible Z
    if-nez v4, +014h
    iget-object v4, v3, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$setTopBarVisible$1$2;->this$0 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
    invoke-static v4, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->access$getTopBar$p(Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;)Landroid/view/View;
    move-result-object v4
    if-nez v4, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v0, v4
    const/16 v4, 8
    invoke-virtual v0, v4, Landroid/view/View;->setVisibility(I)V
    return-void 
.end method
