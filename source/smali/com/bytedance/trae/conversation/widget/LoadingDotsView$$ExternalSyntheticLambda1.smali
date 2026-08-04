# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/widget/LoadingDotsView$$ExternalSyntheticLambda1;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Landroid/animation/ValueAnimator$AnimatorUpdateListener;

.field public final synthetic f$0:Lcom/bytedance/trae/conversation/widget/LoadingDotsView;
.field public final synthetic f$1:I


.method public synthetic constructor <init>(com.bytedance.trae.conversation.widget.LoadingDotsView  int)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/widget/LoadingDotsView$$ExternalSyntheticLambda1;->f$0 Lcom/bytedance/trae/conversation/widget/LoadingDotsView;
    iput v2, v0, Lcom/bytedance/trae/conversation/widget/LoadingDotsView$$ExternalSyntheticLambda1;->f$1 I
    return-void 
.end method

.method public final onAnimationUpdate(android.animation.ValueAnimator)void
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/conversation/widget/LoadingDotsView$$ExternalSyntheticLambda1;->f$0 Lcom/bytedance/trae/conversation/widget/LoadingDotsView;
    iget v1, v2, Lcom/bytedance/trae/conversation/widget/LoadingDotsView$$ExternalSyntheticLambda1;->f$1 I
    invoke-static v0, v1, v3, Lcom/bytedance/trae/conversation/widget/LoadingDotsView;->$r8$lambda$8f0cuWcwA5uHtd97p5L3sz7HEok(Lcom/bytedance/trae/conversation/widget/LoadingDotsView; I Landroid/animation/ValueAnimator;)V
    return-void 
.end method
