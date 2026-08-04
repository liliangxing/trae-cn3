# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity;
.super Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;
.source "DouyinBindPhoneActivity.kt"

.field public static final Companion:Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity$Companion;
.field private static final EXTRA_PROFILE_KEY:Ljava/lang/String;
.field private static final MAIN_ACTIVITY_CLASS:Ljava/lang/String;
.field private static final TAG_PHONE_INPUT:Ljava/lang/String;
.field private static final TAG_VERIFY_CODE:Ljava/lang/String;
.field private binding:Lcom/bytedance/trae/login/databinding/TraeActivityDouyinBindPhoneBinding;
.field private isBackPressed:Z
.field private isBindSuccess:Z
.field private profileKey:Ljava/lang/String;


.method public static synthetic $r8$lambda$4fgXOjWAbyonaUBEbiQSmpUPLFo(com.bytedance.trae.login.activity.DouyinBindPhoneActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity;->setupViews$lambda$1(Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity; Landroid/view/View;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity;->Companion Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;-><init>()V
    return-void 
.end method

.method public static final synthetic access$handleBackPressed(com.bytedance.trae.login.activity.DouyinBindPhoneActivity)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity;->handleBackPressed()V
    return-void 
.end method

.method public static com_bytedance_trae_login_activity_DouyinBindPhoneActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(com.bytedance.trae.login.activity.DouyinBindPhoneActivity)void
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity;->com_bytedance_trae_login_activity_DouyinBindPhoneActivity__onStop$___twin___()V
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

.method private final handleBackPressed()void
    .registers 16
    # ins_size=1
    iget-object v0, v15, Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity;->binding Lcom/bytedance/trae/login/databinding/TraeActivityDouyinBindPhoneBinding;
    if-nez v0, +008h
    const-string v0, "binding"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    iget-object v0, v0, Lcom/bytedance/trae/login/databinding/TraeActivityDouyinBindPhoneBinding;->loadingOverlay Landroid/widget/FrameLayout;
    invoke-virtual v0, Landroid/widget/FrameLayout;->getVisibility()I
    move-result v0
    if-nez v0, +003h
    return-void 
    const/4 v0, 1
    iput-boolean v0, v15, Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity;->isBackPressed Z
    invoke-virtual v15, Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v0
    invoke-virtual v0, Landroidx/fragment/app/FragmentManager;->getBackStackEntryCount()I
    move-result v0
    if-lez v0, +023h
    sget-object v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string v2, "douyin_bind_verify_code_exit"
    const-string v3, "douyin"
    const/4 v4, 0
    const-string v5, "back_pressed"
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/16 v13, 2036
    const/4 v14, 0
    invoke-static/range v1 ... v14, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel$default(Lcom/bytedance/trae/login/traeauth/TraeAuthManager; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    invoke-virtual v15, Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v0
    invoke-virtual v0, Landroidx/fragment/app/FragmentManager;->popBackStack()V
    const/4 v0, 0
    iput-boolean v0, v15, Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity;->isBackPressed Z
    goto +1ah
    sget-object v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string v2, "douyin_bind_phone_exit"
    const-string v3, "douyin"
    const/4 v4, 0
    const-string v5, "back_pressed"
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/16 v13, 2036
    const/4 v14, 0
    invoke-static/range v1 ... v14, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel$default(Lcom/bytedance/trae/login/traeauth/TraeAuthManager; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    invoke-virtual v15, Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity;->finish()V
    return-void 
.end method

.method private final setupViews()void
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity;->binding Lcom/bytedance/trae/login/databinding/TraeActivityDouyinBindPhoneBinding;
    if-nez v0, +008h
    const-string v0, "binding"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    iget-object v0, v0, Lcom/bytedance/trae/login/databinding/TraeActivityDouyinBindPhoneBinding;->ivBack Landroid/widget/ImageView;
    new-instance v1, Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity$$ExternalSyntheticLambda0;
    invoke-direct v1, v3, Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity;)V
    invoke-virtual v0, v1, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    invoke-virtual v3, Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity;->getOnBackPressedDispatcher()Landroidx/activity/OnBackPressedDispatcher;
    move-result-object v0
    move-object v1, v3
    check-cast v1, Landroidx/lifecycle/LifecycleOwner;
    new-instance v2, Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity$setupViews$2;
    invoke-direct v2, v3, Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity$setupViews$2;-><init>(Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity;)V
    check-cast v2, Landroidx/activity/OnBackPressedCallback;
    invoke-virtual v0, v1, v2, Landroidx/activity/OnBackPressedDispatcher;->addCallback(Landroidx/lifecycle/LifecycleOwner; Landroidx/activity/OnBackPressedCallback;)V
    return-void 
.end method

.method private static final setupViews$lambda$1(com.bytedance.trae.login.activity.DouyinBindPhoneActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity;->handleBackPressed()V
    return-void 
.end method

.method private final showPhoneInput()void
    .registers 5
    # ins_size=1
    invoke-virtual v4, Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v0
    invoke-virtual v0, Landroidx/fragment/app/FragmentManager;->beginTransaction()Landroidx/fragment/app/FragmentTransaction;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/login/R$id;->fragment_container I
    sget-object v2, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment;->Companion Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment$Companion;
    invoke-virtual v2, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment$Companion;->newInstance()Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment;
    move-result-object v2
    check-cast v2, Landroidx/fragment/app/Fragment;
    const-string/jumbo v3, tag_douyin_bind_phone_input
    invoke-virtual v0, v1, v2, v3, Landroidx/fragment/app/FragmentTransaction;->replace(I Landroidx/fragment/app/Fragment; Ljava/lang/String;)Landroidx/fragment/app/FragmentTransaction;
    move-result-object v0
    invoke-virtual v0, Landroidx/fragment/app/FragmentTransaction;->commitAllowingStateLoss()I
    return-void 
.end method

.method public com_bytedance_trae_login_activity_DouyinBindPhoneActivity__onStop$___twin___()void
    .registers 1
    # ins_size=1
    invoke-super v0, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->onStop()V
    return-void 
.end method

.method public final navigateToMainActivity()void
    .registers 5
    # ins_size=1
    const/4 v0, 1
    iput-boolean v0, v4, Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity;->isBindSuccess Z
    new-instance v1, Landroid/content/Intent;
    invoke-direct v1, Landroid/content/Intent;-><init>()V
    move-object v2, v4
    check-cast v2, Landroid/content/Context;
    const-string v3, "com.bytedance.trae.home.MainActivity"
    invoke-virtual v1, v2, v3, Landroid/content/Intent;->setClassName(Landroid/content/Context; Ljava/lang/String;)Landroid/content/Intent;
    const v2, 268468224
    invoke-virtual v1, v2, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;
    const-string v2, "from_login_success"
    invoke-virtual v1, v2, v0, Landroid/content/Intent;->putExtra(Ljava/lang/String; Z)Landroid/content/Intent;
    invoke-virtual v4, v1, Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity;->startActivity(Landroid/content/Intent;)V
    invoke-virtual v4, Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity;->finish()V
    return-void 
.end method

.method protected onCreate(android.os.Bundle)void
    .registers 4
    # ins_size=2
    invoke-super v2, v3, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->onCreate(Landroid/os/Bundle;)V
    invoke-virtual v2, Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity;->getLayoutInflater()Landroid/view/LayoutInflater;
    move-result-object v0
    invoke-static v0, Lcom/bytedance/trae/login/databinding/TraeActivityDouyinBindPhoneBinding;->inflate(Landroid/view/LayoutInflater;)Lcom/bytedance/trae/login/databinding/TraeActivityDouyinBindPhoneBinding;
    move-result-object v0
    const-string v1, "inflate(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v0, v2, Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity;->binding Lcom/bytedance/trae/login/databinding/TraeActivityDouyinBindPhoneBinding;
    if-nez v0, +008h
    const-string v0, "binding"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    invoke-virtual v0, Lcom/bytedance/trae/login/databinding/TraeActivityDouyinBindPhoneBinding;->getRoot()Landroidx/constraintlayout/widget/ConstraintLayout;
    move-result-object v0
    check-cast v0, Landroid/view/View;
    invoke-virtual v2, v0, Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity;->setContentView(Landroid/view/View;)V
    invoke-virtual v2, Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity;->getIntent()Landroid/content/Intent;
    move-result-object v0
    const-string v1, "extra_profile_key"
    invoke-virtual v0, v1, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    if-nez v0, +009h
    move-object v3, v2
    check-cast v3, Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity;
    invoke-virtual v2, Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity;->finish()V
    return-void 
    iput-object v0, v2, Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity;->profileKey Ljava/lang/String;
    invoke-direct v2, Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity;->setupViews()V
    if-nez v3, +00ah
    sget-object v3, Lcom/bytedance/trae/login/tracker/LoginTracker;->INSTANCE Lcom/bytedance/trae/login/tracker/LoginTracker;
    invoke-virtual v3, Lcom/bytedance/trae/login/tracker/LoginTracker;->trackDouyinBindPhonePageView()V
    invoke-direct v2, Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity;->showPhoneInput()V
    return-void 
.end method

.method protected onDestroy()void
    .registers 16
    # ins_size=1
    iget-boolean v0, v15, Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity;->isBindSuccess Z
    if-nez v0, +030h
    iget-boolean v0, v15, Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity;->isBackPressed Z
    if-nez v0, +02ch
    invoke-virtual v15, Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity;->isChangingConfigurations()Z
    move-result v0
    if-nez v0, +026h
    invoke-virtual v15, Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v0
    invoke-virtual v0, Landroidx/fragment/app/FragmentManager;->getBackStackEntryCount()I
    move-result v0
    if-lez v0, +005h
    const-string v0, "douyin_bind_verify_code_destroy"
    goto +3h
    const-string v0, "douyin_bind_phone_destroy"
    move-object v2, v0
    sget-object v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string v3, "douyin"
    const/4 v4, 0
    const-string v5, "destroyed"
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/16 v13, 2036
    const/4 v14, 0
    invoke-static/range v1 ... v14, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel$default(Lcom/bytedance/trae/login/traeauth/TraeAuthManager; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    invoke-super v15, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->onDestroy()V
    return-void 
.end method

.method protected onPause()void
    .registers 16
    # ins_size=1
    invoke-super v15, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->onPause()V
    iget-boolean v0, v15, Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity;->isBindSuccess Z
    if-nez v0, +02ch
    iget-boolean v0, v15, Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity;->isBackPressed Z
    if-eqz v0, +003h
    goto +26h
    invoke-virtual v15, Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v0
    invoke-virtual v0, Landroidx/fragment/app/FragmentManager;->getBackStackEntryCount()I
    move-result v0
    if-lez v0, +005h
    const-string v0, "douyin_bind_verify_code_pause"
    goto +3h
    const-string v0, "douyin_bind_phone_pause"
    move-object v2, v0
    sget-object v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string v3, "douyin"
    const/4 v4, 0
    const-string/jumbo v5, pause_background
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/16 v13, 2036
    const/4 v14, 0
    invoke-static/range v1 ... v14, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel$default(Lcom/bytedance/trae/login/traeauth/TraeAuthManager; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    return-void 
.end method

.method protected onResume()void
    .registers 2
    # ins_size=1
    invoke-super v1, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->onResume()V
    const/4 v0, 0
    iput-boolean v0, v1, Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity;->isBackPressed Z
    return-void 
.end method

.method protected onStop()void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity;->com_bytedance_trae_login_activity_DouyinBindPhoneActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity;)V
    return-void 
.end method

.method public final popToPhoneInput()void
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v0
    invoke-virtual v0, Landroidx/fragment/app/FragmentManager;->getBackStackEntryCount()I
    move-result v0
    if-lez v0, +009h
    invoke-virtual v1, Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v0
    invoke-virtual v0, Landroidx/fragment/app/FragmentManager;->popBackStack()V
    return-void 
.end method

.method public final setBindLoading(boolean)void
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity;->binding Lcom/bytedance/trae/login/databinding/TraeActivityDouyinBindPhoneBinding;
    if-nez v0, +008h
    const-string v0, "binding"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    iget-object v0, v0, Lcom/bytedance/trae/login/databinding/TraeActivityDouyinBindPhoneBinding;->loadingOverlay Landroid/widget/FrameLayout;
    if-eqz v2, +004h
    const/4 v2, 0
    goto +3h
    const/16 v2, 8
    invoke-virtual v0, v2, Landroid/widget/FrameLayout;->setVisibility(I)V
    return-void 
.end method

.method public final showVerifyCodeInput(java.lang.String)void
    .registers 18
    # ins_size=2
    move-object/from16 v0, v17
    const-string/jumbo v1, phoneNumber
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v2, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string v3, "douyin_bind_verify_code_shown"
    const-string v4, "douyin"
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/16 v14, 2044
    const/4 v15, 0
    invoke-static/range v2 ... v15, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel$default(Lcom/bytedance/trae/login/traeauth/TraeAuthManager; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    invoke-virtual/range v16, Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v1
    invoke-virtual v1, Landroidx/fragment/app/FragmentManager;->beginTransaction()Landroidx/fragment/app/FragmentTransaction;
    move-result-object v1
    sget v2, Lcom/bytedance/trae/login/R$id;->fragment_container I
    sget-object v3, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->Companion Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$Companion;
    move-object/from16 v4, v16
    iget-object v5, v4, Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity;->profileKey Ljava/lang/String;
    if-nez v5, +009h
    const-string/jumbo v5, profileKey
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v5, 0
    invoke-virtual v3, v0, v5, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$Companion;->newInstance(Ljava/lang/String; Ljava/lang/String;)Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;
    move-result-object v0
    check-cast v0, Landroidx/fragment/app/Fragment;
    const-string/jumbo v3, tag_douyin_bind_verify_code
    invoke-virtual v1, v2, v0, v3, Landroidx/fragment/app/FragmentTransaction;->replace(I Landroidx/fragment/app/Fragment; Ljava/lang/String;)Landroidx/fragment/app/FragmentTransaction;
    move-result-object v0
    invoke-virtual v0, v3, Landroidx/fragment/app/FragmentTransaction;->addToBackStack(Ljava/lang/String;)Landroidx/fragment/app/FragmentTransaction;
    move-result-object v0
    invoke-virtual v0, Landroidx/fragment/app/FragmentTransaction;->commitAllowingStateLoss()I
    return-void 
.end method
