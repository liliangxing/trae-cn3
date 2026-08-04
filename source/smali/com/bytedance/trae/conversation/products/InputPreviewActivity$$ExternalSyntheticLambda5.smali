# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/products/InputPreviewActivity$$ExternalSyntheticLambda5;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Landroid/animation/ValueAnimator$AnimatorUpdateListener;

.field public final synthetic f$0:F
.field public final synthetic f$1:F
.field public final synthetic f$2:Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
.field public final synthetic f$3:F
.field public final synthetic f$4:F
.field public final synthetic f$5:F
.field public final synthetic f$6:F


.method public synthetic constructor <init>(float  float  com.bytedance.trae.conversation.products.InputPreviewActivity  float  float  float  float)void
    .registers 8
    # ins_size=8
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput v1, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$$ExternalSyntheticLambda5;->f$0 F
    iput v2, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$$ExternalSyntheticLambda5;->f$1 F
    iput-object v3, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$$ExternalSyntheticLambda5;->f$2 Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
    iput v4, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$$ExternalSyntheticLambda5;->f$3 F
    iput v5, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$$ExternalSyntheticLambda5;->f$4 F
    iput v6, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$$ExternalSyntheticLambda5;->f$5 F
    iput v7, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$$ExternalSyntheticLambda5;->f$6 F
    return-void 
.end method

.method public final onAnimationUpdate(android.animation.ValueAnimator)void
    .registers 10
    # ins_size=2
    iget v0, v8, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$$ExternalSyntheticLambda5;->f$0 F
    iget v1, v8, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$$ExternalSyntheticLambda5;->f$1 F
    iget-object v2, v8, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$$ExternalSyntheticLambda5;->f$2 Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
    iget v3, v8, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$$ExternalSyntheticLambda5;->f$3 F
    iget v4, v8, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$$ExternalSyntheticLambda5;->f$4 F
    iget v5, v8, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$$ExternalSyntheticLambda5;->f$5 F
    iget v6, v8, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$$ExternalSyntheticLambda5;->f$6 F
    move-object v7, v9
    invoke-static/range v0 ... v7, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->$r8$lambda$-0TET6ix7f8yEIAeFwuNr9qoNP4(F F Lcom/bytedance/trae/conversation/products/InputPreviewActivity; F F F F Landroid/animation/ValueAnimator;)V
    return-void 
.end method
