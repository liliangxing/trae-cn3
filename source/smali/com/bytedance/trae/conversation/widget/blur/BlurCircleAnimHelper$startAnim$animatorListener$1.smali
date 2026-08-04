# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/widget/blur/BlurCircleAnimHelper$startAnim$animatorListener$1;
.super Ljava/lang/Object;
.source "BlurCircleAnimHelper.kt"

.implements Landroid/animation/Animator$AnimatorListener;

.field final synthetic $getAmplitude:Lkotlin/jvm/functions/Function0;
.field final synthetic this$0:Lcom/bytedance/trae/conversation/widget/blur/BlurCircleAnimHelper;


.method constructor <init>(com.bytedance.trae.conversation.widget.blur.BlurCircleAnimHelper  kotlin.jvm.functions.Function0)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleAnimHelper$startAnim$animatorListener$1;->this$0 Lcom/bytedance/trae/conversation/widget/blur/BlurCircleAnimHelper;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleAnimHelper$startAnim$animatorListener$1;->$getAmplitude Lkotlin/jvm/functions/Function0;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public onAnimationCancel(android.animation.Animator)void
    .registers 3
    # ins_size=2
    const-string v0, "animation"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleAnimHelper$startAnim$animatorListener$1;->this$0 Lcom/bytedance/trae/conversation/widget/blur/BlurCircleAnimHelper;
    const/4 v0, 0
    invoke-static v2, v0, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleAnimHelper;->access$setPlayingAnimator$p(Lcom/bytedance/trae/conversation/widget/blur/BlurCircleAnimHelper; Landroid/animation/Animator;)V
    return-void 
.end method

.method public onAnimationEnd(android.animation.Animator)void
    .registers 5
    # ins_size=2
    const-string v0, "animation"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v4, v3, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleAnimHelper$startAnim$animatorListener$1;->this$0 Lcom/bytedance/trae/conversation/widget/blur/BlurCircleAnimHelper;
    const/4 v0, 0
    invoke-static v4, v0, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleAnimHelper;->access$setPlayingAnimator$p(Lcom/bytedance/trae/conversation/widget/blur/BlurCircleAnimHelper; Landroid/animation/Animator;)V
    iget-object v4, v3, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleAnimHelper$startAnim$animatorListener$1;->this$0 Lcom/bytedance/trae/conversation/widget/blur/BlurCircleAnimHelper;
    invoke-static v4, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleAnimHelper;->access$getCurrentState$p(Lcom/bytedance/trae/conversation/widget/blur/BlurCircleAnimHelper;)I
    move-result v4
    const/4 v0, 1
    if-ne v4, v0, +003h
    return-void 
    iget-object v4, v3, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleAnimHelper$startAnim$animatorListener$1;->this$0 Lcom/bytedance/trae/conversation/widget/blur/BlurCircleAnimHelper;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleAnimHelper;->getView()Lcom/bytedance/trae/conversation/widget/blur/BlurView;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleAnimHelper$startAnim$animatorListener$1;->$getAmplitude Lkotlin/jvm/functions/Function0;
    invoke-interface v1, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/Number;
    invoke-virtual v1, Ljava/lang/Number;->floatValue()F
    move-result v1
    move-object v2, v3
    check-cast v2, Landroid/animation/Animator$AnimatorListener;
    invoke-static v4, v0, v1, v2, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleAnimHelper;->access$startAnimOnce(Lcom/bytedance/trae/conversation/widget/blur/BlurCircleAnimHelper; Lcom/bytedance/trae/conversation/widget/blur/BlurView; F Landroid/animation/Animator$AnimatorListener;)Landroid/animation/Animator;
    return-void 
.end method

.method public onAnimationRepeat(android.animation.Animator)void
    .registers 3
    # ins_size=2
    const-string v0, "animation"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    return-void 
.end method

.method public onAnimationStart(android.animation.Animator)void
    .registers 3
    # ins_size=2
    const-string v0, "animation"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    return-void 
.end method
