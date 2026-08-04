# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/common/widget/InlineToast$show$hideRunnable$1$1;
.super Landroid/animation/AnimatorListenerAdapter;
.source "InlineToast.kt"

.field final synthetic $toastView:Landroid/view/View;


.method constructor <init>(android.view.View)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/common/widget/InlineToast$show$hideRunnable$1$1;->$toastView Landroid/view/View;
    invoke-direct v0, Landroid/animation/AnimatorListenerAdapter;-><init>()V
    return-void 
.end method

.method public onAnimationEnd(android.animation.Animator)void
    .registers 3
    # ins_size=2
    const-string v0, "animation"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v2, Lcom/bytedance/trae/common/widget/InlineToast;->INSTANCE Lcom/bytedance/trae/common/widget/InlineToast;
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/InlineToast$show$hideRunnable$1$1;->$toastView Landroid/view/View;
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-static v2, v0, Lcom/bytedance/trae/common/widget/InlineToast;->access$removeFromParent(Lcom/bytedance/trae/common/widget/InlineToast; Landroid/view/View;)V
    return-void 
.end method
