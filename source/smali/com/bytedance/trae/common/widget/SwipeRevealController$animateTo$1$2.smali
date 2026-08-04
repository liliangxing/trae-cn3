# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/common/widget/SwipeRevealController$animateTo$1$2;
.super Landroid/animation/AnimatorListenerAdapter;
.source "SwipeRevealController.kt"

.field final synthetic $shouldOpen:Z
.field final synthetic $targetTranslationX:F
.field final synthetic this$0:Lcom/bytedance/trae/common/widget/SwipeRevealController;


.method constructor <init>(com.bytedance.trae.common.widget.SwipeRevealController  float  boolean)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/common/widget/SwipeRevealController$animateTo$1$2;->this$0 Lcom/bytedance/trae/common/widget/SwipeRevealController;
    iput v2, v0, Lcom/bytedance/trae/common/widget/SwipeRevealController$animateTo$1$2;->$targetTranslationX F
    iput-boolean v3, v0, Lcom/bytedance/trae/common/widget/SwipeRevealController$animateTo$1$2;->$shouldOpen Z
    invoke-direct v0, Landroid/animation/AnimatorListenerAdapter;-><init>()V
    return-void 
.end method

.method public onAnimationEnd(android.animation.Animator)void
    .registers 4
    # ins_size=2
    const-string v0, "animation"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v3, v2, Lcom/bytedance/trae/common/widget/SwipeRevealController$animateTo$1$2;->this$0 Lcom/bytedance/trae/common/widget/SwipeRevealController;
    iget v0, v2, Lcom/bytedance/trae/common/widget/SwipeRevealController$animateTo$1$2;->$targetTranslationX F
    iget-boolean v1, v2, Lcom/bytedance/trae/common/widget/SwipeRevealController$animateTo$1$2;->$shouldOpen Z
    invoke-static v3, v0, v1, Lcom/bytedance/trae/common/widget/SwipeRevealController;->access$settleAnimationTarget(Lcom/bytedance/trae/common/widget/SwipeRevealController; F Z)V
    iget-object v3, v2, Lcom/bytedance/trae/common/widget/SwipeRevealController$animateTo$1$2;->this$0 Lcom/bytedance/trae/common/widget/SwipeRevealController;
    const/4 v0, 0
    invoke-static v3, v0, Lcom/bytedance/trae/common/widget/SwipeRevealController;->access$setAnimator$p(Lcom/bytedance/trae/common/widget/SwipeRevealController; Landroid/animation/ValueAnimator;)V
    return-void 
.end method
