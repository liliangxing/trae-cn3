# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;
.super Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
.source "MultiImagePreviewActivity.kt"

.field private activePointerId:I
.field private boundPath:Ljava/lang/String;
.field private currentScale:F
.field private downloadJob:Lkotlinx/coroutines/Job;
.field private final draweeView:Lcom/facebook/drawee/view/SimpleDraweeView;
.field private final gestureDetector:Landroid/view/GestureDetector;
.field private isDragging:Z
.field private lastTouchX:F
.field private lastTouchY:F
.field private scaleAnimator:Landroid/animation/ValueAnimator;
.field private final scaleGestureDetector:Landroid/view/ScaleGestureDetector;
.field final synthetic this$0:Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter;


.method public static synthetic $r8$lambda$frN_ZzBFh4uRXgadNaCU4nQWwps(com.bytedance.trae.conversation.products.MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder  android.view.View  android.view.MotionEvent)boolean
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->setupTouchHandling$lambda$2(Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder; Landroid/view/View; Landroid/view/MotionEvent;)Z
    move-result v0
    return v0
.end method

.method public static synthetic $r8$lambda$rTr_0O0Jai0PcvKBQ41HQRx7_pU(float  float  com.bytedance.trae.conversation.products.MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder  float  float  float  float  android.animation.ValueAnimator)void
    .registers 8
    # ins_size=8
    invoke-static/range v0 ... v7, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->animateToScale$lambda$1$lambda$0(F F Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder; F F F F Landroid/animation/ValueAnimator;)V
    return-void 
.end method

.method public constructor <init>(com.bytedance.trae.conversation.products.MultiImagePreviewActivity$ImagePagerAdapter  android.view.View)void
    .registers 6
    # ins_size=3
    const-string v0, "itemView"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v4, v3, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->this$0 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter;
    invoke-direct v3, v5, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;-><init>(Landroid/view/View;)V
    sget v0, Lcom/bytedance/trae/conversation/R$id;->iv_pager_image I
    invoke-virtual v5, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v5
    const-string v0, "findViewById(...)"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v5, Lcom/facebook/drawee/view/SimpleDraweeView;
    iput-object v5, v3, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->draweeView Lcom/facebook/drawee/view/SimpleDraweeView;
    const/high16 v5, 1065353216
    iput v5, v3, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->currentScale F
    const/4 v5, -1
    iput v5, v3, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->activePointerId I
    new-instance v5, Landroid/view/ScaleGestureDetector;
    iget-object v0, v4, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter;->this$0 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
    check-cast v0, Landroid/content/Context;
    new-instance v1, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder$scaleGestureDetector$1;
    iget-object v2, v4, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter;->this$0 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
    invoke-direct v1, v3, v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder$scaleGestureDetector$1;-><init>(Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder; Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;)V
    check-cast v1, Landroid/view/ScaleGestureDetector$OnScaleGestureListener;
    invoke-direct v5, v0, v1, Landroid/view/ScaleGestureDetector;-><init>(Landroid/content/Context; Landroid/view/ScaleGestureDetector$OnScaleGestureListener;)V
    iput-object v5, v3, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->scaleGestureDetector Landroid/view/ScaleGestureDetector;
    new-instance v5, Landroid/view/GestureDetector;
    iget-object v0, v4, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter;->this$0 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
    check-cast v0, Landroid/content/Context;
    new-instance v1, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder$gestureDetector$1;
    iget-object v4, v4, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter;->this$0 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
    invoke-direct v1, v4, v3, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder$gestureDetector$1;-><init>(Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity; Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;)V
    check-cast v1, Landroid/view/GestureDetector$OnGestureListener;
    invoke-direct v5, v0, v1, Landroid/view/GestureDetector;-><init>(Landroid/content/Context; Landroid/view/GestureDetector$OnGestureListener;)V
    iput-object v5, v3, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->gestureDetector Landroid/view/GestureDetector;
    return-void 
.end method

.method private static final animateToScale$lambda$1$lambda$0(float  float  com.bytedance.trae.conversation.products.MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder  float  float  float  float  android.animation.ValueAnimator)void
    .registers 9
    # ins_size=8
    const-string v0, "animator"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v8, Landroid/animation/ValueAnimator;->getAnimatedValue()Ljava/lang/Object;
    move-result-object v8
    const-string v0, "null cannot be cast to non-null type kotlin.Float"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v8, Ljava/lang/Float;
    invoke-virtual v8, Ljava/lang/Float;->floatValue()F
    move-result v8
    sub-float/2addr v2, v1
    mul-float/2addr v2, v8
    add-float/2addr v1, v2
    iput v1, v3, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->currentScale F
    iget-object v2, v3, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->draweeView Lcom/facebook/drawee/view/SimpleDraweeView;
    invoke-virtual v2, v1, Lcom/facebook/drawee/view/SimpleDraweeView;->setScaleX(F)V
    iget-object v2, v3, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->draweeView Lcom/facebook/drawee/view/SimpleDraweeView;
    invoke-virtual v2, v1, Lcom/facebook/drawee/view/SimpleDraweeView;->setScaleY(F)V
    iget-object v1, v3, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->draweeView Lcom/facebook/drawee/view/SimpleDraweeView;
    sub-float/2addr v5, v4
    mul-float/2addr v5, v8
    add-float/2addr v4, v5
    invoke-virtual v1, v4, Lcom/facebook/drawee/view/SimpleDraweeView;->setTranslationX(F)V
    iget-object v1, v3, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->draweeView Lcom/facebook/drawee/view/SimpleDraweeView;
    sub-float/2addr v7, v6
    mul-float/2addr v7, v8
    add-float/2addr v6, v7
    invoke-virtual v1, v6, Lcom/facebook/drawee/view/SimpleDraweeView;->setTranslationY(F)V
    return-void 
.end method

.method private static final setupTouchHandling$lambda$2(com.bytedance.trae.conversation.products.MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder  android.view.View  android.view.MotionEvent)boolean
    .registers 8
    # ins_size=3
    iget-object v6, v5, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->scaleGestureDetector Landroid/view/ScaleGestureDetector;
    invoke-virtual v6, v7, Landroid/view/ScaleGestureDetector;->onTouchEvent(Landroid/view/MotionEvent;)Z
    iget-object v6, v5, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->gestureDetector Landroid/view/GestureDetector;
    invoke-virtual v6, v7, Landroid/view/GestureDetector;->onTouchEvent(Landroid/view/MotionEvent;)Z
    invoke-virtual v7, Landroid/view/MotionEvent;->getActionMasked()I
    move-result v6
    const/4 v0, 0
    const/4 v1, 1
    if-eqz v6, +088h
    if-eq v6, v1, +080h
    const/4 v2, 2
    if-eq v6, v2, +038h
    const/4 v2, 3
    if-eq v6, v2, +07ah
    const/4 v2, 5
    if-eq v6, v2, +02fh
    const/4 v2, 6
    if-eq v6, v2, +004h
    goto/16 +08ch
    invoke-virtual v7, Landroid/view/MotionEvent;->getActionIndex()I
    move-result v6
    invoke-virtual v7, v6, Landroid/view/MotionEvent;->getPointerId(I)I
    move-result v2
    iget v3, v5, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->activePointerId I
    if-ne v2, v3, +080h
    if-nez v6, +003h
    move v0, v1
    invoke-virtual v7, Landroid/view/MotionEvent;->getPointerCount()I
    move-result v6
    if-ge v0, v6, +077h
    invoke-virtual v7, v0, Landroid/view/MotionEvent;->getX(I)F
    move-result v6
    iput v6, v5, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->lastTouchX F
    invoke-virtual v7, v0, Landroid/view/MotionEvent;->getY(I)F
    move-result v6
    iput v6, v5, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->lastTouchY F
    invoke-virtual v7, v0, Landroid/view/MotionEvent;->getPointerId(I)I
    move-result v6
    iput v6, v5, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->activePointerId I
    goto +63h
    iput-boolean v0, v5, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->isDragging Z
    goto +60h
    iget-boolean v6, v5, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->isDragging Z
    if-eqz v6, +05dh
    iget-object v6, v5, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->scaleGestureDetector Landroid/view/ScaleGestureDetector;
    invoke-virtual v6, Landroid/view/ScaleGestureDetector;->isInProgress()Z
    move-result v6
    if-nez v6, +055h
    iget v6, v5, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->activePointerId I
    invoke-virtual v7, v6, Landroid/view/MotionEvent;->findPointerIndex(I)I
    move-result v6
    if-ltz v6, +04dh
    invoke-virtual v7, v6, Landroid/view/MotionEvent;->getX(I)F
    move-result v0
    invoke-virtual v7, v6, Landroid/view/MotionEvent;->getY(I)F
    move-result v6
    iget v7, v5, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->lastTouchX F
    sub-float v7, v0, v7
    iget v2, v5, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->lastTouchY F
    sub-float v2, v6, v2
    iget v3, v5, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->currentScale F
    const/high16 v4, 1065353216
    cmpl-float v3, v3, v4
    if-lez v3, +016h
    iget-object v3, v5, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->draweeView Lcom/facebook/drawee/view/SimpleDraweeView;
    invoke-virtual v3, Lcom/facebook/drawee/view/SimpleDraweeView;->getTranslationX()F
    move-result v4
    add-float/2addr v4, v7
    invoke-virtual v3, v4, Lcom/facebook/drawee/view/SimpleDraweeView;->setTranslationX(F)V
    iget-object v7, v5, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->draweeView Lcom/facebook/drawee/view/SimpleDraweeView;
    invoke-virtual v7, Lcom/facebook/drawee/view/SimpleDraweeView;->getTranslationY()F
    move-result v3
    add-float/2addr v3, v2
    invoke-virtual v7, v3, Lcom/facebook/drawee/view/SimpleDraweeView;->setTranslationY(F)V
    iput v0, v5, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->lastTouchX F
    iput v6, v5, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->lastTouchY F
    goto +1bh
    iput-boolean v0, v5, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->isDragging Z
    const/4 v6, -1
    iput v6, v5, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->activePointerId I
    goto +15h
    invoke-virtual v7, v0, Landroid/view/MotionEvent;->getPointerId(I)I
    move-result v6
    iput v6, v5, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->activePointerId I
    invoke-virtual v7, Landroid/view/MotionEvent;->getX()F
    move-result v6
    iput v6, v5, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->lastTouchX F
    invoke-virtual v7, Landroid/view/MotionEvent;->getY()F
    move-result v6
    iput v6, v5, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->lastTouchY F
    iput-boolean v1, v5, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->isDragging Z
    return v1
.end method

.method public final animateToScale(float)void
    .registers 13
    # ins_size=2
    iget-object v0, v11, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->scaleAnimator Landroid/animation/ValueAnimator;
    if-eqz v0, +005h
    invoke-virtual v0, Landroid/animation/ValueAnimator;->cancel()V
    iget v2, v11, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->currentScale F
    iget-object v0, v11, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->draweeView Lcom/facebook/drawee/view/SimpleDraweeView;
    invoke-virtual v0, Lcom/facebook/drawee/view/SimpleDraweeView;->getTranslationX()F
    move-result v5
    iget-object v0, v11, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->draweeView Lcom/facebook/drawee/view/SimpleDraweeView;
    invoke-virtual v0, Lcom/facebook/drawee/view/SimpleDraweeView;->getTranslationY()F
    move-result v7
    const/high16 v0, 1065353216
    cmpg-float v0, v12, v0
    if-nez v0, +004h
    const/4 v0, 1
    goto +2h
    const/4 v0, 0
    const/4 v1, 0
    if-eqz v0, +004h
    move v6, v1
    goto +2h
    move v6, v5
    if-eqz v0, +004h
    move v8, v1
    goto +2h
    move v8, v7
    const/4 v0, 2
    new-array v0, v0, [F
    fill-array-data v0, +0000036h
    invoke-static v0, Landroid/animation/ValueAnimator;->ofFloat([F)Landroid/animation/ValueAnimator;
    move-result-object v0
    iget-object v1, v11, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->this$0 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter;
    iget-object v9, v1, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter;->this$0 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
    const-wide/16 v3, 250
    invoke-virtual v0, v3, v4, Landroid/animation/ValueAnimator;->setDuration(J)Landroid/animation/ValueAnimator;
    new-instance v1, Landroid/view/animation/DecelerateInterpolator;
    invoke-direct v1, Landroid/view/animation/DecelerateInterpolator;-><init>()V
    check-cast v1, Landroid/animation/TimeInterpolator;
    invoke-virtual v0, v1, Landroid/animation/ValueAnimator;->setInterpolator(Landroid/animation/TimeInterpolator;)V
    new-instance v10, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder$$ExternalSyntheticLambda0;
    move-object v1, v10
    move v3, v12
    move-object v4, v11
    invoke-direct/range v1 ... v8, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder$$ExternalSyntheticLambda0;-><init>(F F Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder; F F F F)V
    invoke-virtual v0, v10, Landroid/animation/ValueAnimator;->addUpdateListener(Landroid/animation/ValueAnimator$AnimatorUpdateListener;)V
    new-instance v12, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder$animateToScale$1$2;
    invoke-direct v12, v11, v9, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder$animateToScale$1$2;-><init>(Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder; Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;)V
    check-cast v12, Landroid/animation/Animator$AnimatorListener;
    invoke-virtual v0, v12, Landroid/animation/ValueAnimator;->addListener(Landroid/animation/Animator$AnimatorListener;)V
    invoke-virtual v0, Landroid/animation/ValueAnimator;->start()V
    iput-object v0, v11, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->scaleAnimator Landroid/animation/ValueAnimator;
    return-void 
    nop 
    fill-array-data-payload b'\x00\x00\x00\x00\x00\x00\x80?' | \x00\x00\x00\x00\x00\x00\x80\x3f
.end method

.method public final getActivePointerId()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->activePointerId I
    return v0
.end method

.method public final getBoundPath()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->boundPath Ljava/lang/String;
    return-object v0
.end method

.method public final getCurrentScale()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->currentScale F
    return v0
.end method

.method public final getDownloadJob()kotlinx.coroutines.Job
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->downloadJob Lkotlinx/coroutines/Job;
    return-object v0
.end method

.method public final getDraweeView()com.facebook.drawee.view.SimpleDraweeView
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->draweeView Lcom/facebook/drawee/view/SimpleDraweeView;
    return-object v0
.end method

.method public final getGestureDetector()android.view.GestureDetector
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->gestureDetector Landroid/view/GestureDetector;
    return-object v0
.end method

.method public final getLastTouchX()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->lastTouchX F
    return v0
.end method

.method public final getLastTouchY()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->lastTouchY F
    return v0
.end method

.method public final getScaleAnimator()android.animation.ValueAnimator
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->scaleAnimator Landroid/animation/ValueAnimator;
    return-object v0
.end method

.method public final getScaleGestureDetector()android.view.ScaleGestureDetector
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->scaleGestureDetector Landroid/view/ScaleGestureDetector;
    return-object v0
.end method

.method public final isDragging()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->isDragging Z
    return v0
.end method

.method public final resetScale()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->scaleAnimator Landroid/animation/ValueAnimator;
    if-eqz v0, +005h
    invoke-virtual v0, Landroid/animation/ValueAnimator;->cancel()V
    const/high16 v0, 1065353216
    iput v0, v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->currentScale F
    iget-object v1, v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->draweeView Lcom/facebook/drawee/view/SimpleDraweeView;
    invoke-virtual v1, v0, Lcom/facebook/drawee/view/SimpleDraweeView;->setScaleX(F)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->draweeView Lcom/facebook/drawee/view/SimpleDraweeView;
    invoke-virtual v1, v0, Lcom/facebook/drawee/view/SimpleDraweeView;->setScaleY(F)V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->draweeView Lcom/facebook/drawee/view/SimpleDraweeView;
    const/4 v1, 0
    invoke-virtual v0, v1, Lcom/facebook/drawee/view/SimpleDraweeView;->setTranslationX(F)V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->draweeView Lcom/facebook/drawee/view/SimpleDraweeView;
    invoke-virtual v0, v1, Lcom/facebook/drawee/view/SimpleDraweeView;->setTranslationY(F)V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->this$0 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter;
    iget-object v0, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter;->this$0 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
    invoke-static v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->access$getViewPager$p(Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;)Landroidx/viewpager2/widget/ViewPager2;
    move-result-object v0
    if-nez v0, +009h
    const-string/jumbo v0, viewPager
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    const/4 v1, 1
    invoke-virtual v0, v1, Landroidx/viewpager2/widget/ViewPager2;->setUserInputEnabled(Z)V
    return-void 
.end method

.method public final setActivePointerId(int)void
    .registers 2
    # ins_size=2
    iput v1, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->activePointerId I
    return-void 
.end method

.method public final setBoundPath(java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->boundPath Ljava/lang/String;
    return-void 
.end method

.method public final setCurrentScale(float)void
    .registers 2
    # ins_size=2
    iput v1, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->currentScale F
    return-void 
.end method

.method public final setDownloadJob(kotlinx.coroutines.Job)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->downloadJob Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public final setDragging(boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->isDragging Z
    return-void 
.end method

.method public final setLastTouchX(float)void
    .registers 2
    # ins_size=2
    iput v1, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->lastTouchX F
    return-void 
.end method

.method public final setLastTouchY(float)void
    .registers 2
    # ins_size=2
    iput v1, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->lastTouchY F
    return-void 
.end method

.method public final setScaleAnimator(android.animation.ValueAnimator)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->scaleAnimator Landroid/animation/ValueAnimator;
    return-void 
.end method

.method public final setupTouchHandling()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->draweeView Lcom/facebook/drawee/view/SimpleDraweeView;
    new-instance v1, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder$$ExternalSyntheticLambda1;
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;)V
    invoke-virtual v0, v1, Lcom/facebook/drawee/view/SimpleDraweeView;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V
    return-void 
.end method
