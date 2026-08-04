# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Landroid/animation/ValueAnimator$AnimatorUpdateListener;

.field public final synthetic f$0:I
.field public final synthetic f$1:I
.field public final synthetic f$2:Landroid/view/ViewGroup$MarginLayoutParams;
.field public final synthetic f$3:Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
.field public final synthetic f$4:F
.field public final synthetic f$5:F


.method public synthetic constructor <init>(int  int  android.view.ViewGroup$MarginLayoutParams  com.bytedance.trae.conversation.products.MultiImagePreviewActivity  float  float)void
    .registers 7
    # ins_size=7
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput v1, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$$ExternalSyntheticLambda0;->f$0 I
    iput v2, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$$ExternalSyntheticLambda0;->f$1 I
    iput-object v3, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$$ExternalSyntheticLambda0;->f$2 Landroid/view/ViewGroup$MarginLayoutParams;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$$ExternalSyntheticLambda0;->f$3 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
    iput v5, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$$ExternalSyntheticLambda0;->f$4 F
    iput v6, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$$ExternalSyntheticLambda0;->f$5 F
    return-void 
.end method

.method public final onAnimationUpdate(android.animation.ValueAnimator)void
    .registers 9
    # ins_size=2
    iget v0, v7, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$$ExternalSyntheticLambda0;->f$0 I
    iget v1, v7, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$$ExternalSyntheticLambda0;->f$1 I
    iget-object v2, v7, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$$ExternalSyntheticLambda0;->f$2 Landroid/view/ViewGroup$MarginLayoutParams;
    iget-object v3, v7, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$$ExternalSyntheticLambda0;->f$3 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
    iget v4, v7, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$$ExternalSyntheticLambda0;->f$4 F
    iget v5, v7, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$$ExternalSyntheticLambda0;->f$5 F
    move-object v6, v8
    invoke-static/range v0 ... v6, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->$r8$lambda$sDsGbCN_1x4AhgM52SYaz5Ct0Xo(I I Landroid/view/ViewGroup$MarginLayoutParams; Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity; F F Landroid/animation/ValueAnimator;)V
    return-void 
.end method
