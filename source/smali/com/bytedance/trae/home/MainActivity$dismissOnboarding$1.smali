# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/MainActivity$dismissOnboarding$1;
.super Landroid/animation/AnimatorListenerAdapter;
.source "MainActivity.kt"

.field final synthetic $fragment:Landroidx/fragment/app/Fragment;
.field final synthetic this$0:Lcom/bytedance/trae/home/MainActivity;


.method constructor <init>(com.bytedance.trae.home.MainActivity  androidx.fragment.app.Fragment)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/home/MainActivity$dismissOnboarding$1;->this$0 Lcom/bytedance/trae/home/MainActivity;
    iput-object v2, v0, Lcom/bytedance/trae/home/MainActivity$dismissOnboarding$1;->$fragment Landroidx/fragment/app/Fragment;
    invoke-direct v0, Landroid/animation/AnimatorListenerAdapter;-><init>()V
    return-void 
.end method

.method public onAnimationEnd(android.animation.Animator)void
    .registers 3
    # ins_size=2
    const-string v0, "animation"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v2, v1, Lcom/bytedance/trae/home/MainActivity$dismissOnboarding$1;->this$0 Lcom/bytedance/trae/home/MainActivity;
    invoke-virtual v2, Lcom/bytedance/trae/home/MainActivity;->isFinishing()Z
    move-result v2
    if-nez v2, +02eh
    iget-object v2, v1, Lcom/bytedance/trae/home/MainActivity$dismissOnboarding$1;->this$0 Lcom/bytedance/trae/home/MainActivity;
    invoke-virtual v2, Lcom/bytedance/trae/home/MainActivity;->isDestroyed()Z
    move-result v2
    if-nez v2, +026h
    iget-object v2, v1, Lcom/bytedance/trae/home/MainActivity$dismissOnboarding$1;->this$0 Lcom/bytedance/trae/home/MainActivity;
    invoke-virtual v2, Lcom/bytedance/trae/home/MainActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v2
    invoke-virtual v2, Landroidx/fragment/app/FragmentManager;->beginTransaction()Landroidx/fragment/app/FragmentTransaction;
    move-result-object v2
    iget-object v0, v1, Lcom/bytedance/trae/home/MainActivity$dismissOnboarding$1;->$fragment Landroidx/fragment/app/Fragment;
    invoke-virtual v2, v0, Landroidx/fragment/app/FragmentTransaction;->remove(Landroidx/fragment/app/Fragment;)Landroidx/fragment/app/FragmentTransaction;
    move-result-object v2
    invoke-virtual v2, Landroidx/fragment/app/FragmentTransaction;->commitAllowingStateLoss()I
    iget-object v2, v1, Lcom/bytedance/trae/home/MainActivity$dismissOnboarding$1;->this$0 Lcom/bytedance/trae/home/MainActivity;
    invoke-static v2, Lcom/bytedance/trae/home/MainActivity;->access$getOnboardingContainerId$p(Lcom/bytedance/trae/home/MainActivity;)I
    move-result v0
    invoke-virtual v2, v0, Lcom/bytedance/trae/home/MainActivity;->findViewById(I)Landroid/view/View;
    move-result-object v2
    if-eqz v2, +007h
    const/16 v0, 8
    invoke-virtual v2, v0, Landroid/view/View;->setVisibility(I)V
    return-void 
.end method
