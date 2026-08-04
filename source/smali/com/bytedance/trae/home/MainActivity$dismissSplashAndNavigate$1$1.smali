# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/MainActivity$dismissSplashAndNavigate$1$1;
.super Landroid/animation/AnimatorListenerAdapter;
.source "MainActivity.kt"

.field final synthetic $navigate:Lkotlin/jvm/functions/Function0;
.field final synthetic $view:Landroid/view/View;
.field final synthetic this$0:Lcom/bytedance/trae/home/MainActivity;


.method constructor <init>(android.view.View  com.bytedance.trae.home.MainActivity  kotlin.jvm.functions.Function0)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/home/MainActivity$dismissSplashAndNavigate$1$1;->$view Landroid/view/View;
    iput-object v2, v0, Lcom/bytedance/trae/home/MainActivity$dismissSplashAndNavigate$1$1;->this$0 Lcom/bytedance/trae/home/MainActivity;
    iput-object v3, v0, Lcom/bytedance/trae/home/MainActivity$dismissSplashAndNavigate$1$1;->$navigate Lkotlin/jvm/functions/Function0;
    invoke-direct v0, Landroid/animation/AnimatorListenerAdapter;-><init>()V
    return-void 
.end method

.method public onAnimationEnd(android.animation.Animator)void
    .registers 4
    # ins_size=2
    const-string v0, "animation"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v3, v2, Lcom/bytedance/trae/home/MainActivity$dismissSplashAndNavigate$1$1;->$view Landroid/view/View;
    invoke-virtual v3, Landroid/view/View;->getParent()Landroid/view/ViewParent;
    move-result-object v3
    instance-of v0, v3, Landroid/view/ViewGroup;
    const/4 v1, 0
    if-eqz v0, +005h
    check-cast v3, Landroid/view/ViewGroup;
    goto +2h
    move-object v3, v1
    if-eqz v3, +007h
    iget-object v0, v2, Lcom/bytedance/trae/home/MainActivity$dismissSplashAndNavigate$1$1;->$view Landroid/view/View;
    invoke-virtual v3, v0, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V
    iget-object v3, v2, Lcom/bytedance/trae/home/MainActivity$dismissSplashAndNavigate$1$1;->this$0 Lcom/bytedance/trae/home/MainActivity;
    invoke-static v3, v1, Lcom/bytedance/trae/home/MainActivity;->access$setSplashView$p(Lcom/bytedance/trae/home/MainActivity; Landroid/view/View;)V
    iget-object v3, v2, Lcom/bytedance/trae/home/MainActivity$dismissSplashAndNavigate$1$1;->$navigate Lkotlin/jvm/functions/Function0;
    if-eqz v3, +005h
    invoke-interface v3, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    return-void 
.end method
