# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/anniex/AnnieXHostActivity;
.super Landroidx/appcompat/app/AppCompatActivity;
.source "AnnieXHostActivity.kt"

.field public static final $stable:I
.field private final annieXPageHelper$delegate:Lkotlin/Lazy;


.method public static synthetic $r8$lambda$EoerM6xM7dxjrO37Ppf2zrnGKVs()com.bytedance.android.anniex.container.ui.AnnieXPageHelper
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/anniex/AnnieXHostActivity;->annieXPageHelper_delegate$lambda$0()Lcom/bytedance/android/anniex/container/ui/AnnieXPageHelper;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public constructor <init>()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Landroidx/appcompat/app/AppCompatActivity;-><init>()V
    new-instance v0, Lcom/bytedance/trae/anniex/AnnieXHostActivity$$ExternalSyntheticLambda0;
    invoke-direct v0, Lcom/bytedance/trae/anniex/AnnieXHostActivity$$ExternalSyntheticLambda0;-><init>()V
    invoke-static v0, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v0
    iput-object v0, v1, Lcom/bytedance/trae/anniex/AnnieXHostActivity;->annieXPageHelper$delegate Lkotlin/Lazy;
    return-void 
.end method

.method public static final synthetic access$getAnnieXPageHelper(com.bytedance.trae.anniex.AnnieXHostActivity)com.bytedance.android.anniex.container.ui.AnnieXPageHelper
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/anniex/AnnieXHostActivity;->getAnnieXPageHelper()Lcom/bytedance/android/anniex/container/ui/AnnieXPageHelper;
    move-result-object v0
    return-object v0
.end method

.method private static final annieXPageHelper_delegate$lambda$0()com.bytedance.android.anniex.container.ui.AnnieXPageHelper
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/android/anniex/container/ui/AnnieXPageHelper;
    invoke-direct v0, Lcom/bytedance/android/anniex/container/ui/AnnieXPageHelper;-><init>()V
    return-object v0
.end method

.method public static com_bytedance_trae_anniex_AnnieXHostActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(com.bytedance.trae.anniex.AnnieXHostActivity)void
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/anniex/AnnieXHostActivity;->com_bytedance_trae_anniex_AnnieXHostActivity__onStop$___twin___()V
    invoke-static Lcom/bytedance/sysoptimizer/EnterTransitionCrashOptimizer;->getContext()Landroid/content/Context;
    move-result-object v0
    if-eqz v0, +013h
    check-cast v1, Landroid/app/Activity;
    invoke-virtual v1, Landroid/app/Activity;->getWindow()Landroid/view/Window;
    move-result-object v1
    invoke-virtual v1, Landroid/view/Window;->getDecorView()Landroid/view/View;
    move-result-object v1
    invoke-virtual v1, Landroid/view/View;->getViewTreeObserver()Landroid/view/ViewTreeObserver;
    move-result-object v1
    invoke-virtual v1, Landroid/view/ViewTreeObserver;->dispatchOnPreDraw()Z
    return-void 
    :try_start_0xb
.end method

.method private final getAnnieXPageHelper()com.bytedance.android.anniex.container.ui.AnnieXPageHelper
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/anniex/AnnieXHostActivity;->annieXPageHelper$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/android/anniex/container/ui/AnnieXPageHelper;
    return-object v0
.end method

.method public com_bytedance_trae_anniex_AnnieXHostActivity__onStop$___twin___()void
    .registers 1
    # ins_size=1
    invoke-super v0, Landroidx/appcompat/app/AppCompatActivity;->onStop()V
    return-void 
.end method

.method public finish()void
    .registers 2
    # ins_size=1
    invoke-super v1, Landroidx/appcompat/app/AppCompatActivity;->finish()V
    invoke-direct v1, Lcom/bytedance/trae/anniex/AnnieXHostActivity;->getAnnieXPageHelper()Lcom/bytedance/android/anniex/container/ui/AnnieXPageHelper;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/android/anniex/container/ui/AnnieXPageHelper;->finish()V
    return-void 
.end method

.method protected onCreate(android.os.Bundle)void
    .registers 5
    # ins_size=2
    if-eqz v4, +005h
    invoke-virtual v4, Landroid/os/Bundle;->clear()V
    invoke-super v3, v4, Landroidx/appcompat/app/AppCompatActivity;->onCreate(Landroid/os/Bundle;)V
    const v4, 2131427358
    invoke-virtual v3, v4, Lcom/bytedance/trae/anniex/AnnieXHostActivity;->setContentView(I)V
    invoke-direct v3, Lcom/bytedance/trae/anniex/AnnieXHostActivity;->getAnnieXPageHelper()Lcom/bytedance/android/anniex/container/ui/AnnieXPageHelper;
    move-result-object v4
    move-object v0, v3
    check-cast v0, Landroidx/fragment/app/FragmentActivity;
    invoke-virtual v3, Lcom/bytedance/trae/anniex/AnnieXHostActivity;->getIntent()Landroid/content/Intent;
    move-result-object v1
    const-string v2, "getIntent(...)"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const v2, 2131230844
    invoke-virtual v4, v0, v1, v2, Lcom/bytedance/android/anniex/container/ui/AnnieXPageHelper;->onCreate(Landroidx/fragment/app/FragmentActivity; Landroid/content/Intent; I)V
    invoke-virtual v3, Lcom/bytedance/trae/anniex/AnnieXHostActivity;->getOnBackPressedDispatcher()Landroidx/activity/OnBackPressedDispatcher;
    move-result-object v4
    move-object v0, v3
    check-cast v0, Landroidx/lifecycle/LifecycleOwner;
    new-instance v1, Lcom/bytedance/trae/anniex/AnnieXHostActivity$onCreate$1;
    invoke-direct v1, v3, Lcom/bytedance/trae/anniex/AnnieXHostActivity$onCreate$1;-><init>(Lcom/bytedance/trae/anniex/AnnieXHostActivity;)V
    check-cast v1, Landroidx/activity/OnBackPressedCallback;
    invoke-virtual v4, v0, v1, Landroidx/activity/OnBackPressedDispatcher;->addCallback(Landroidx/lifecycle/LifecycleOwner; Landroidx/activity/OnBackPressedCallback;)V
    return-void 
.end method

.method protected onDestroy()void
    .registers 2
    # ins_size=1
    invoke-super v1, Landroidx/appcompat/app/AppCompatActivity;->onDestroy()V
    invoke-direct v1, Lcom/bytedance/trae/anniex/AnnieXHostActivity;->getAnnieXPageHelper()Lcom/bytedance/android/anniex/container/ui/AnnieXPageHelper;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/android/anniex/container/ui/AnnieXPageHelper;->onDestroy()V
    return-void 
.end method

.method protected onStop()void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/anniex/AnnieXHostActivity;->com_bytedance_trae_anniex_AnnieXHostActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(Lcom/bytedance/trae/anniex/AnnieXHostActivity;)V
    return-void 
.end method
