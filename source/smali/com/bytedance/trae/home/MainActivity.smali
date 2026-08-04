# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/MainActivity;
.super Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;
.source "MainActivity.kt"

.field public static final $stable:I
.field public static final Companion:Lcom/bytedance/trae/home/MainActivity$Companion;
.field public static final EXTRA_FROM_LANGUAGE_SWITCH:Ljava/lang/String;
.field private static final SPLASH_AUTO_DISMISS_MS:J
.field private static final SPLASH_MIN_SHOW_MS:J
.field private static final TAG:Ljava/lang/String;
.field private static final TAG_MAIN_TAB_FRAGMENT:Ljava/lang/String;
.field private static final TAG_ONBOARDING_FRAGMENT:Ljava/lang/String;
.field private static isColdStart:Z
.field private static pendingDeepLinkUri:Landroid/net/Uri;
.field private alreadyInit:Z
.field private final dismissSplashRunnable:Ljava/lang/Runnable;
.field private final handler:Landroid/os/Handler;
.field private isFirstEnterMainPage:Z
.field private isSplashDismissed:Z
.field private onboardingContainerId:I
.field private onboardingShowing:Z
.field private pendingNavigate:Lkotlin/jvm/functions/Function0;
.field private splashShowTime:J
.field private splashView:Landroid/view/View;


.method public static synthetic $r8$lambda$4roe2u0VdNbsgcHyxMB9ej6iofM(com.bytedance.trae.home.MainActivity)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/home/MainActivity;->showOnboarding$lambda$10(Lcom/bytedance/trae/home/MainActivity;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$6mnkcuau8T-naJv-erSPCT_D4h4(com.bytedance.trae.home.MainActivity)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/home/MainActivity;->onCreate$lambda$3(Lcom/bytedance/trae/home/MainActivity;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$T97Gmrx5XFEvKrOpSRruFR73Ybw(com.bytedance.trae.home.MainActivity  androidx.activity.OnBackPressedCallback)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/MainActivity;->onCreate$lambda$1(Lcom/bytedance/trae/home/MainActivity; Landroidx/activity/OnBackPressedCallback;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$WPJbe_A251TyWrCVpwcMra7A1NM(com.bytedance.trae.home.zlink.PendingDeepLinkRoute  com.bytedance.trae.home.MainActivity)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/MainActivity;->tryInitWhenOnResume$lambda$11(Lcom/bytedance/trae/home/zlink/PendingDeepLinkRoute; Lcom/bytedance/trae/home/MainActivity;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$kB7r6fSPoHQJZBHAOxqlOOmWCzI(com.bytedance.trae.home.MainActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/MainActivity;->addSplashView$lambda$7(Lcom/bytedance/trae/home/MainActivity; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$o1gCYRR8pmpGtNUtVgDpaft8eDo(com.bytedance.trae.home.MainActivity)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/home/MainActivity;->dismissSplashRunnable$lambda$0(Lcom/bytedance/trae/home/MainActivity;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$oKMLhZuxdJrBOFbULsD4ybVrkXM(com.bytedance.trae.home.MainActivity)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/home/MainActivity;->onCreate$lambda$2(Lcom/bytedance/trae/home/MainActivity;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$rK1a1HwaC3mPC-NpnPrIqrR9STo(com.bytedance.trae.home.MainActivity)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/home/MainActivity;->tryInitWhenOnResume$lambda$13(Lcom/bytedance/trae/home/MainActivity;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$rW4miCde10D2FxRg_8fMJdlNOlo(com.bytedance.trae.home.MainActivity  android.net.Uri)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/MainActivity;->tryInitWhenOnResume$lambda$12(Lcom/bytedance/trae/home/MainActivity; Landroid/net/Uri;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/MainActivity$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/home/MainActivity$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/home/MainActivity;->Companion Lcom/bytedance/trae/home/MainActivity$Companion;
    const/16 v0, 8
    sput v0, Lcom/bytedance/trae/home/MainActivity;->$stable I
    const/4 v0, 1
    sput-boolean v0, Lcom/bytedance/trae/home/MainActivity;->isColdStart Z
    return-void 
.end method

.method public constructor <init>()void
    .registers 3
    # ins_size=1
    invoke-direct v2, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;-><init>()V
    const/4 v0, 1
    iput-boolean v0, v2, Lcom/bytedance/trae/home/MainActivity;->isFirstEnterMainPage Z
    new-instance v0, Landroid/os/Handler;
    invoke-static Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;
    move-result-object v1
    invoke-direct v0, v1, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V
    iput-object v0, v2, Lcom/bytedance/trae/home/MainActivity;->handler Landroid/os/Handler;
    new-instance v0, Lcom/bytedance/trae/home/MainActivity$$ExternalSyntheticLambda3;
    invoke-direct v0, v2, Lcom/bytedance/trae/home/MainActivity$$ExternalSyntheticLambda3;-><init>(Lcom/bytedance/trae/home/MainActivity;)V
    iput-object v0, v2, Lcom/bytedance/trae/home/MainActivity;->dismissSplashRunnable Ljava/lang/Runnable;
    const/4 v0, -1
    iput v0, v2, Lcom/bytedance/trae/home/MainActivity;->onboardingContainerId I
    return-void 
.end method

.method public static final synthetic access$dismissSplashAndNavigate(com.bytedance.trae.home.MainActivity)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/home/MainActivity;->dismissSplashAndNavigate()V
    return-void 
.end method

.method public static final synthetic access$getHandler$p(com.bytedance.trae.home.MainActivity)android.os.Handler
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/MainActivity;->handler Landroid/os/Handler;
    return-object v0
.end method

.method public static final synthetic access$getOnboardingContainerId$p(com.bytedance.trae.home.MainActivity)int
    .registers 1
    # ins_size=1
    iget v0, v0, Lcom/bytedance/trae/home/MainActivity;->onboardingContainerId I
    return v0
.end method

.method public static final synthetic access$getPendingNavigate$p(com.bytedance.trae.home.MainActivity)kotlin.jvm.functions.Function0
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/MainActivity;->pendingNavigate Lkotlin/jvm/functions/Function0;
    return-object v0
.end method

.method public static final synthetic access$getSplashShowTime$p(com.bytedance.trae.home.MainActivity)long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/MainActivity;->splashShowTime J
    return-wide v0
.end method

.method public static final synthetic access$isSplashDismissed$p(com.bytedance.trae.home.MainActivity)boolean
    .registers 1
    # ins_size=1
    iget-boolean v0, v0, Lcom/bytedance/trae/home/MainActivity;->isSplashDismissed Z
    return v0
.end method

.method public static final synthetic access$setPendingNavigate$p(com.bytedance.trae.home.MainActivity  kotlin.jvm.functions.Function0)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/home/MainActivity;->pendingNavigate Lkotlin/jvm/functions/Function0;
    return-void 
.end method

.method public static final synthetic access$setSplashView$p(com.bytedance.trae.home.MainActivity  android.view.View)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/home/MainActivity;->splashView Landroid/view/View;
    return-void 
.end method

.method private final addSplashView(android.widget.FrameLayout)void
    .registers 6
    # ins_size=2
    invoke-static Landroid/os/SystemClock;->elapsedRealtime()J
    move-result-wide v0
    iput-wide v0, v4, Lcom/bytedance/trae/home/MainActivity;->splashShowTime J
    move-object v0, v4
    check-cast v0, Landroid/content/Context;
    invoke-static v0, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/home/R$layout;->view_splash I
    move-object v2, v5
    check-cast v2, Landroid/view/ViewGroup;
    const/4 v3, 0
    invoke-virtual v0, v1, v2, v3, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v0
    iput-object v0, v4, Lcom/bytedance/trae/home/MainActivity;->splashView Landroid/view/View;
    new-instance v1, Landroid/view/ViewGroup$LayoutParams;
    const/4 v2, -1
    invoke-direct v1, v2, v2, Landroid/view/ViewGroup$LayoutParams;-><init>(I I)V
    invoke-virtual v5, v0, v1, Landroid/widget/FrameLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    iget-object v5, v4, Lcom/bytedance/trae/home/MainActivity;->splashView Landroid/view/View;
    if-eqz v5, +00ah
    new-instance v0, Lcom/bytedance/trae/home/MainActivity$$ExternalSyntheticLambda8;
    invoke-direct v0, v4, Lcom/bytedance/trae/home/MainActivity$$ExternalSyntheticLambda8;-><init>(Lcom/bytedance/trae/home/MainActivity;)V
    invoke-virtual v5, v0, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    iget-object v5, v4, Lcom/bytedance/trae/home/MainActivity;->handler Landroid/os/Handler;
    iget-object v0, v4, Lcom/bytedance/trae/home/MainActivity;->dismissSplashRunnable Ljava/lang/Runnable;
    const-wide/16 v1, 1500
    invoke-virtual v5, v0, v1, v2, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable; J)Z
    return-void 
.end method

.method private static final addSplashView$lambda$7(com.bytedance.trae.home.MainActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/home/MainActivity;->dismissSplashAndNavigate()V
    return-void 
.end method

.method public static com_bytedance_trae_home_MainActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(com.bytedance.trae.home.MainActivity)void
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/home/MainActivity;->com_bytedance_trae_home_MainActivity__onStop$___twin___()V
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

.method private final dismissOnboarding()void
    .registers 5
    # ins_size=1
    const/4 v0, 0
    iput-boolean v0, v4, Lcom/bytedance/trae/home/MainActivity;->onboardingShowing Z
    invoke-virtual v4, Lcom/bytedance/trae/home/MainActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v0
    const-string/jumbo v1, tag_onboarding_fragment
    invoke-virtual v0, v1, Landroidx/fragment/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroidx/fragment/app/Fragment;
    move-result-object v0
    if-eqz v0, +02dh
    invoke-virtual v0, Landroidx/fragment/app/Fragment;->getView()Landroid/view/View;
    move-result-object v1
    if-eqz v1, +027h
    invoke-virtual v1, Landroid/view/View;->animate()Landroid/view/ViewPropertyAnimator;
    move-result-object v1
    if-eqz v1, +021h
    const/4 v2, 0
    invoke-virtual v1, v2, Landroid/view/ViewPropertyAnimator;->alpha(F)Landroid/view/ViewPropertyAnimator;
    move-result-object v1
    if-eqz v1, +01ah
    const-wide/16 v2, 300
    invoke-virtual v1, v2, v3, Landroid/view/ViewPropertyAnimator;->setDuration(J)Landroid/view/ViewPropertyAnimator;
    move-result-object v1
    if-eqz v1, +012h
    new-instance v2, Lcom/bytedance/trae/home/MainActivity$dismissOnboarding$1;
    invoke-direct v2, v4, v0, Lcom/bytedance/trae/home/MainActivity$dismissOnboarding$1;-><init>(Lcom/bytedance/trae/home/MainActivity; Landroidx/fragment/app/Fragment;)V
    check-cast v2, Landroid/animation/Animator$AnimatorListener;
    invoke-virtual v1, v2, Landroid/view/ViewPropertyAnimator;->setListener(Landroid/animation/Animator$AnimatorListener;)Landroid/view/ViewPropertyAnimator;
    move-result-object v0
    if-eqz v0, +005h
    invoke-virtual v0, Landroid/view/ViewPropertyAnimator;->start()V
    invoke-direct v4, Lcom/bytedance/trae/home/MainActivity;->enterMainPage()V
    return-void 
.end method

.method private final dismissSplash()void
    .registers 2
    # ins_size=1
    const/4 v0, 0
    iput-object v0, v1, Lcom/bytedance/trae/home/MainActivity;->pendingNavigate Lkotlin/jvm/functions/Function0;
    invoke-direct v1, Lcom/bytedance/trae/home/MainActivity;->dismissSplashAndNavigate()V
    return-void 
.end method

.method private final dismissSplashAndNavigate()void
    .registers 6
    # ins_size=1
    iget-boolean v0, v5, Lcom/bytedance/trae/home/MainActivity;->isSplashDismissed Z
    if-eqz v0, +003h
    return-void 
    const/4 v0, 1
    iput-boolean v0, v5, Lcom/bytedance/trae/home/MainActivity;->isSplashDismissed Z
    iget-object v0, v5, Lcom/bytedance/trae/home/MainActivity;->handler Landroid/os/Handler;
    iget-object v1, v5, Lcom/bytedance/trae/home/MainActivity;->dismissSplashRunnable Ljava/lang/Runnable;
    invoke-virtual v0, v1, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V
    iget-object v0, v5, Lcom/bytedance/trae/home/MainActivity;->pendingNavigate Lkotlin/jvm/functions/Function0;
    const/4 v1, 0
    iput-object v1, v5, Lcom/bytedance/trae/home/MainActivity;->pendingNavigate Lkotlin/jvm/functions/Function0;
    iget-object v1, v5, Lcom/bytedance/trae/home/MainActivity;->splashView Landroid/view/View;
    if-eqz v1, +020h
    invoke-virtual v1, Landroid/view/View;->animate()Landroid/view/ViewPropertyAnimator;
    move-result-object v2
    const/4 v3, 0
    invoke-virtual v2, v3, Landroid/view/ViewPropertyAnimator;->alpha(F)Landroid/view/ViewPropertyAnimator;
    move-result-object v2
    const-wide/16 v3, 200
    invoke-virtual v2, v3, v4, Landroid/view/ViewPropertyAnimator;->setDuration(J)Landroid/view/ViewPropertyAnimator;
    move-result-object v2
    new-instance v3, Lcom/bytedance/trae/home/MainActivity$dismissSplashAndNavigate$1$1;
    invoke-direct v3, v1, v5, v0, Lcom/bytedance/trae/home/MainActivity$dismissSplashAndNavigate$1$1;-><init>(Landroid/view/View; Lcom/bytedance/trae/home/MainActivity; Lkotlin/jvm/functions/Function0;)V
    check-cast v3, Landroid/animation/Animator$AnimatorListener;
    invoke-virtual v2, v3, Landroid/view/ViewPropertyAnimator;->setListener(Landroid/animation/Animator$AnimatorListener;)Landroid/view/ViewPropertyAnimator;
    move-result-object v0
    invoke-virtual v0, Landroid/view/ViewPropertyAnimator;->start()V
    goto +9h
    move-object v1, v5
    check-cast v1, Lcom/bytedance/trae/home/MainActivity;
    if-eqz v0, +005h
    invoke-interface v0, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    return-void 
.end method

.method private static final dismissSplashRunnable$lambda$0(com.bytedance.trae.home.MainActivity)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/home/MainActivity;->dismissSplashAndNavigate()V
    return-void 
.end method

.method private final doResumeInternal()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/home/MainActivity;->tryInitWhenOnResume()V
    invoke-direct v0, Lcom/bytedance/trae/home/MainActivity;->fetchStarbucksIfLoggedIn()V
    return-void 
.end method

.method private final enterMainPage()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/home/MainActivity;->doResumeInternal()V
    iget-boolean v0, v1, Lcom/bytedance/trae/home/MainActivity;->isFirstEnterMainPage Z
    if-eqz v0, +006h
    const/4 v0, 0
    iput-boolean v0, v1, Lcom/bytedance/trae/home/MainActivity;->isFirstEnterMainPage Z
    return-void 
    invoke-direct v1, Lcom/bytedance/trae/home/MainActivity;->navigateToMainTabFragment()V
    return-void 
.end method

.method private final fetchStarbucksIfLoggedIn()void
    .registers 9
    # ins_size=1
    const-class v0, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v0
    const-class v1, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v0, v1, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/login/api/ILoginService;
    if-nez v0, +003h
    return-void 
    invoke-interface v0, Lcom/bytedance/trae/login/api/ILoginService;->getAccountInfo()Lcom/bytedance/trae/login/api/AccountInfo;
    move-result-object v0
    if-nez v0, +003h
    return-void 
    invoke-virtual v0, Lcom/bytedance/trae/login/api/AccountInfo;->isLogin()Z
    move-result v1
    const/4 v2, 1
    if-eq v1, v2, +003h
    return-void 
    move-object v1, v8
    check-cast v1, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v1, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Lkotlinx/coroutines/CoroutineScope;
    const/4 v3, 0
    const/4 v4, 0
    new-instance v1, Lcom/bytedance/trae/home/MainActivity$fetchStarbucksIfLoggedIn$1;
    const/4 v5, 0
    invoke-direct v1, v0, v5, Lcom/bytedance/trae/home/MainActivity$fetchStarbucksIfLoggedIn$1;-><init>(Lcom/bytedance/trae/login/api/AccountInfo; Lkotlin/coroutines/Continuation;)V
    move-object v5, v1
    check-cast v5, Lkotlin/jvm/functions/Function2;
    const/4 v6, 3
    const/4 v7, 0
    invoke-static/range v2 ... v7, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final getDeepLinkConversationId()java.lang.String
    .registers 5
    # ins_size=1
    invoke-virtual v4, Lcom/bytedance/trae/home/MainActivity;->getIntent()Landroid/content/Intent;
    move-result-object v0
    const/4 v1, 0
    if-eqz v0, +01ch
    invoke-virtual v0, Landroid/content/Intent;->getData()Landroid/net/Uri;
    move-result-object v0
    if-nez v0, +003h
    goto +14h
    invoke-virtual v0, Landroid/net/Uri;->getHost()Ljava/lang/String;
    move-result-object v2
    const-string v3, "conversation"
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +009h
    const-string v1, "conversation_id"
    invoke-virtual v0, v1, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    return-object v0
    return-object v1
.end method

.method private final handlePendingDeepLink(android.net.Uri)void
    .registers 5
    # ins_size=2
    new-instance v0, Landroid/content/Intent;
    move-object v1, v3
    check-cast v1, Landroid/content/Context;
    const-class v2, Lcom/bytedance/trae/home/zlink/ZlinkLinkEntryActivity;
    invoke-direct v0, v1, v2, Landroid/content/Intent;-><init>(Landroid/content/Context; Ljava/lang/Class;)V
    invoke-virtual v0, v4, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;
    invoke-virtual v3, v0, Lcom/bytedance/trae/home/MainActivity;->startActivity(Landroid/content/Intent;)V
    return-void 
.end method

.method private final initDebugFloatingButton()void
    .registers 7
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isDebug()Z
    move-result v0
    if-nez v0, +003h
    return-void 
    const-string v0, "com.bytedance.trae.home.solo.setting.DebugFloatingButtonManager"
    invoke-static v0, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;
    move-result-object v0
    const-string v1, "init"
    const/4 v2, 1
    new-array v3, v2, [Ljava/lang/Class;
    const-class v4, Landroid/app/Application;
    const/4 v5, 0
    aput-object v4, v3, v5
    invoke-virtual v0, v1, v3, Ljava/lang/Class;->getMethod(Ljava/lang/String; [Ljava/lang/Class;)Ljava/lang/reflect/Method;
    move-result-object v0
    new-array v1, v2, [Ljava/lang/Object;
    invoke-virtual v6, Lcom/bytedance/trae/home/MainActivity;->getApplication()Landroid/app/Application;
    move-result-object v2
    aput-object v2, v1, v5
    const/4 v2, 0
    invoke-virtual v0, v2, v1, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object; [Ljava/lang/Object;)Ljava/lang/Object;
    goto +bh
    move-exception v0
    const-string v1, "initDebugFloatingButton failed"
    check-cast v0, Ljava/lang/Throwable;
    const-string v2, "MainActivity"
    invoke-static v2, v1, v0, Landroid/util/Log;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)I
    return-void 
    :try_start_0x9
.end method

.method private final navigateToConversationActivity()void
    .registers 10
    # ins_size=1
    invoke-direct v9, Lcom/bytedance/trae/home/MainActivity;->getDeepLinkConversationId()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v9, Lcom/bytedance/trae/home/MainActivity;->getIntent()Landroid/content/Intent;
    move-result-object v1
    const/4 v2, 0
    if-eqz v1, +005h
    invoke-virtual v1, v2, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;
    move-object v1, v0
    check-cast v1, Ljava/lang/CharSequence;
    const/4 v3, 0
    if-eqz v1, +00bh
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-nez v1, +003h
    goto +3h
    move v1, v3
    goto +2h
    const/4 v1, 1
    if-nez v1, +05dh
    sget-object v1, Lcom/bytedance/trae/conversation/ConversationUtils;->INSTANCE Lcom/bytedance/trae/conversation/ConversationUtils;
    invoke-virtual v1, v0, v2, Lcom/bytedance/trae/conversation/ConversationUtils;->resolveInitialConversation(Ljava/lang/String; Lcom/bytedance/trae/im/service/Conversation;)Lcom/bytedance/trae/im/service/Conversation;
    move-result-object v1
    if-eqz v1, +03bh
    new-instance v0, Landroid/content/Intent;
    move-object v2, v9
    check-cast v2, Landroid/content/Context;
    const-class v4, Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-direct v0, v2, v4, Landroid/content/Intent;-><init>(Landroid/content/Context; Ljava/lang/Class;)V
    sget-object v2, Lcom/bytedance/trae/conversation/CliListRepository;->Companion Lcom/bytedance/trae/conversation/CliListRepository$Companion;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/CliListRepository$Companion;->getInstance()Lcom/bytedance/trae/conversation/CliListRepository;
    move-result-object v2
    invoke-virtual v1, Lcom/bytedance/trae/im/service/Conversation;->getCliId()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v2, v4, Lcom/bytedance/trae/conversation/CliListRepository;->getCliTypeById(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    if-eqz v2, +01ah
    sget-object v2, Lcom/bytedance/trae/conversation/CliListRepository;->Companion Lcom/bytedance/trae/conversation/CliListRepository$Companion;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/CliListRepository$Companion;->getInstance()Lcom/bytedance/trae/conversation/CliListRepository;
    move-result-object v2
    invoke-virtual v1, Lcom/bytedance/trae/im/service/Conversation;->getCliId()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v2, v4, Lcom/bytedance/trae/conversation/CliListRepository;->getCliTypeById(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Lcom/bytedance/trae/im/service/Conversation;->setEnvironment(Ljava/lang/String;)V
    const-string v2, "extra_conversation"
    check-cast v1, Ljava/io/Serializable;
    invoke-virtual v0, v2, v1, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/io/Serializable;)Landroid/content/Intent;
    invoke-virtual v9, v0, Lcom/bytedance/trae/home/MainActivity;->startActivity(Landroid/content/Intent;)V
    invoke-virtual v9, v3, v3, Lcom/bytedance/trae/home/MainActivity;->overridePendingTransition(I I)V
    goto +2bh
    move-object v1, v9
    check-cast v1, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v1, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v1
    move-object v3, v1
    check-cast v3, Lkotlinx/coroutines/CoroutineScope;
    const/4 v4, 0
    const/4 v5, 0
    new-instance v1, Lcom/bytedance/trae/home/MainActivity$navigateToConversationActivity$1;
    invoke-direct v1, v0, v9, v2, Lcom/bytedance/trae/home/MainActivity$navigateToConversationActivity$1;-><init>(Ljava/lang/String; Lcom/bytedance/trae/home/MainActivity; Lkotlin/coroutines/Continuation;)V
    move-object v6, v1
    check-cast v6, Lkotlin/jvm/functions/Function2;
    const/4 v7, 3
    const/4 v8, 0
    invoke-static/range v3 ... v8, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    goto +11h
    new-instance v0, Landroid/content/Intent;
    move-object v1, v9
    check-cast v1, Landroid/content/Context;
    const-class v2, Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-direct v0, v1, v2, Landroid/content/Intent;-><init>(Landroid/content/Context; Ljava/lang/Class;)V
    invoke-virtual v9, v0, Lcom/bytedance/trae/home/MainActivity;->startActivity(Landroid/content/Intent;)V
    invoke-virtual v9, v3, v3, Lcom/bytedance/trae/home/MainActivity;->overridePendingTransition(I I)V
    return-void 
.end method

.method private final navigateToConversationById(java.lang.String)void
    .registers 11
    # ins_size=2
    move-object v0, v10
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    const/4 v1, 0
    if-nez v0, +004h
    const/4 v0, 1
    goto +2h
    move v0, v1
    if-eqz v0, +013h
    new-instance v10, Landroid/content/Intent;
    move-object v0, v9
    check-cast v0, Landroid/content/Context;
    const-class v2, Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-direct v10, v0, v2, Landroid/content/Intent;-><init>(Landroid/content/Context; Ljava/lang/Class;)V
    invoke-virtual v9, v10, Lcom/bytedance/trae/home/MainActivity;->startActivity(Landroid/content/Intent;)V
    invoke-virtual v9, v1, v1, Lcom/bytedance/trae/home/MainActivity;->overridePendingTransition(I I)V
    return-void 
    sget-object v0, Lcom/bytedance/trae/conversation/ConversationUtils;->INSTANCE Lcom/bytedance/trae/conversation/ConversationUtils;
    const/4 v2, 0
    invoke-virtual v0, v10, v2, Lcom/bytedance/trae/conversation/ConversationUtils;->resolveInitialConversation(Ljava/lang/String; Lcom/bytedance/trae/im/service/Conversation;)Lcom/bytedance/trae/im/service/Conversation;
    move-result-object v0
    if-eqz v0, +02dh
    new-instance v10, Landroid/content/Intent;
    move-object v2, v9
    check-cast v2, Landroid/content/Context;
    const-class v3, Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-direct v10, v2, v3, Landroid/content/Intent;-><init>(Landroid/content/Context; Ljava/lang/Class;)V
    sget-object v2, Lcom/bytedance/trae/conversation/CliListRepository;->Companion Lcom/bytedance/trae/conversation/CliListRepository$Companion;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/CliListRepository$Companion;->getInstance()Lcom/bytedance/trae/conversation/CliListRepository;
    move-result-object v2
    invoke-virtual v0, Lcom/bytedance/trae/im/service/Conversation;->getCliId()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Lcom/bytedance/trae/conversation/CliListRepository;->getCliTypeById(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    if-eqz v2, +00ch
    invoke-virtual v0, v2, Lcom/bytedance/trae/im/service/Conversation;->setEnvironment(Ljava/lang/String;)V
    const-string v2, "extra_conversation"
    check-cast v0, Ljava/io/Serializable;
    invoke-virtual v10, v2, v0, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/io/Serializable;)Landroid/content/Intent;
    invoke-virtual v9, v10, Lcom/bytedance/trae/home/MainActivity;->startActivity(Landroid/content/Intent;)V
    invoke-virtual v9, v1, v1, Lcom/bytedance/trae/home/MainActivity;->overridePendingTransition(I I)V
    goto +1ah
    move-object v0, v9
    check-cast v0, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v0
    move-object v3, v0
    check-cast v3, Lkotlinx/coroutines/CoroutineScope;
    const/4 v4, 0
    const/4 v5, 0
    new-instance v0, Lcom/bytedance/trae/home/MainActivity$navigateToConversationById$1;
    invoke-direct v0, v10, v9, v2, Lcom/bytedance/trae/home/MainActivity$navigateToConversationById$1;-><init>(Ljava/lang/String; Lcom/bytedance/trae/home/MainActivity; Lkotlin/coroutines/Continuation;)V
    move-object v6, v0
    check-cast v6, Lkotlin/jvm/functions/Function2;
    const/4 v7, 3
    const/4 v8, 0
    invoke-static/range v3 ... v8, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final navigateToLoginActivity()void
    .registers 4
    # ins_size=1
    new-instance v0, Landroid/content/Intent;
    invoke-direct v0, Landroid/content/Intent;-><init>()V
    move-object v1, v3
    check-cast v1, Landroid/content/Context;
    const-string v2, "com.bytedance.trae.login.activity.AccountLoginActivity"
    invoke-virtual v0, v1, v2, Landroid/content/Intent;->setClassName(Landroid/content/Context; Ljava/lang/String;)Landroid/content/Intent;
    const v1, 268468224
    invoke-virtual v0, v1, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;
    const-string v1, "login_enter_from"
    const-string v2, "deeplink"
    invoke-virtual v0, v1, v2, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    const-string v1, "login_page_source"
    const-string v2, "cold_launch"
    invoke-virtual v0, v1, v2, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    invoke-virtual v3, v0, Lcom/bytedance/trae/home/MainActivity;->startActivity(Landroid/content/Intent;)V
    return-void 
.end method

.method private final navigateToMainTabFragment()void
    .registers 5
    # ins_size=1
    invoke-virtual v4, Lcom/bytedance/trae/home/MainActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v0
    const-string/jumbo v1, tag_main_tab_fragment
    invoke-virtual v0, v1, Landroidx/fragment/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroidx/fragment/app/Fragment;
    move-result-object v0
    if-eqz v0, +003h
    return-void 
    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskFragment;
    invoke-direct v0, Lcom/bytedance/trae/home/solo/task/TaskFragment;-><init>()V
    invoke-virtual v4, Lcom/bytedance/trae/home/MainActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v2
    invoke-virtual v2, Landroidx/fragment/app/FragmentManager;->beginTransaction()Landroidx/fragment/app/FragmentTransaction;
    move-result-object v2
    sget v3, Lcom/bytedance/trae/home/R$id;->fragment_container I
    check-cast v0, Landroidx/fragment/app/Fragment;
    invoke-virtual v2, v3, v0, v1, Landroidx/fragment/app/FragmentTransaction;->replace(I Landroidx/fragment/app/Fragment; Ljava/lang/String;)Landroidx/fragment/app/FragmentTransaction;
    move-result-object v0
    invoke-virtual v0, Landroidx/fragment/app/FragmentTransaction;->commitAllowingStateLoss()I
    return-void 
.end method

.method private final observeContentReady()void
    .registers 9
    # ins_size=1
    new-instance v0, Landroidx/lifecycle/ViewModelProvider;
    move-object v1, v8
    check-cast v1, Landroidx/lifecycle/ViewModelStoreOwner;
    invoke-direct v0, v1, Landroidx/lifecycle/ViewModelProvider;-><init>(Landroidx/lifecycle/ViewModelStoreOwner;)V
    const-class v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-virtual v0, v1, Landroidx/lifecycle/ViewModelProvider;->get(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    move-object v1, v8
    check-cast v1, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v1, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Lkotlinx/coroutines/CoroutineScope;
    const/4 v3, 0
    const/4 v4, 0
    new-instance v1, Lcom/bytedance/trae/home/MainActivity$observeContentReady$1;
    const/4 v5, 0
    invoke-direct v1, v0, v8, v5, Lcom/bytedance/trae/home/MainActivity$observeContentReady$1;-><init>(Lcom/bytedance/trae/home/solo/task/TaskViewModel; Lcom/bytedance/trae/home/MainActivity; Lkotlin/coroutines/Continuation;)V
    move-object v5, v1
    check-cast v5, Lkotlin/jvm/functions/Function2;
    const/4 v6, 3
    const/4 v7, 0
    invoke-static/range v2 ... v7, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private static final onCreate$lambda$1(com.bytedance.trae.home.MainActivity  androidx.activity.OnBackPressedCallback)kotlin.Unit
    .registers 3
    # ins_size=2
    const-string v0, "$this$addCallback"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-boolean v0, v1, Lcom/bytedance/trae/home/MainActivity;->onboardingShowing Z
    if-nez v0, +00dh
    const/4 v0, 0
    invoke-virtual v2, v0, Landroidx/activity/OnBackPressedCallback;->setEnabled(Z)V
    invoke-virtual v1, Lcom/bytedance/trae/home/MainActivity;->getOnBackPressedDispatcher()Landroidx/activity/OnBackPressedDispatcher;
    move-result-object v1
    invoke-virtual v1, Landroidx/activity/OnBackPressedDispatcher;->onBackPressed()V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final onCreate$lambda$2(com.bytedance.trae.home.MainActivity)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/home/MainActivity;->onPrivacyAgreed()V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final onCreate$lambda$3(com.bytedance.trae.home.MainActivity)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/home/MainActivity;->onPrivacyDisagreed()V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private final onPrivacyAgreed()void
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/home/privacy/PrivacyCache;->INSTANCE Lcom/bytedance/trae/home/privacy/PrivacyCache;
    move-object v1, v3
    check-cast v1, Landroid/content/Context;
    const/4 v2, 1
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/privacy/PrivacyCache;->savePrivacyWindowClick(Landroid/content/Context; Z)V
    sget-object v0, Lcom/bytedance/trae/home/privacy/PrivacyManager;->INSTANCE Lcom/bytedance/trae/home/privacy/PrivacyManager;
    invoke-virtual v0, v2, Lcom/bytedance/trae/home/privacy/PrivacyManager;->notifyAgree(Z)V
    sget-object v0, Lcom/bytedance/trae/home/privacy/PrivacyManager;->INSTANCE Lcom/bytedance/trae/home/privacy/PrivacyManager;
    invoke-virtual v0, v2, Lcom/bytedance/trae/home/privacy/PrivacyManager;->updateIsFirstStartMark(Z)V
    sget-object v0, Lcom/bytedance/trae/home/zlink/ZlinkInitializer;->INSTANCE Lcom/bytedance/trae/home/zlink/ZlinkInitializer;
    invoke-virtual v3, Lcom/bytedance/trae/home/MainActivity;->getApplication()Landroid/app/Application;
    move-result-object v1
    const-string v2, "getApplication(...)"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v0, v1, Lcom/bytedance/trae/home/zlink/ZlinkInitializer;->initAfterPrivacyAgreed(Landroid/app/Application;)V
    sget-object v0, Lcom/bytedance/trae/home/privacy/InitPeriodWrapper;->INSTANCE Lcom/bytedance/trae/home/privacy/InitPeriodWrapper;
    move-object v1, v3
    check-cast v1, Landroid/app/Activity;
    invoke-virtual v0, v1, Lcom/bytedance/trae/home/privacy/InitPeriodWrapper;->notifyAllPeriod(Landroid/app/Activity;)V
    invoke-direct v3, Lcom/bytedance/trae/home/MainActivity;->showOnboardingOrMainPage()V
    return-void 
.end method

.method private final onPrivacyDisagreed()void
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/home/privacy/PrivacyCache;->INSTANCE Lcom/bytedance/trae/home/privacy/PrivacyCache;
    move-object v1, v3
    check-cast v1, Landroid/content/Context;
    const/4 v2, 0
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/privacy/PrivacyCache;->savePrivacyWindowClick(Landroid/content/Context; Z)V
    invoke-static Landroid/os/Process;->myPid()I
    move-result v0
    invoke-static v0, Landroid/os/Process;->killProcess(I)V
    return-void 
.end method

.method private final showOnboarding()void
    .registers 5
    # ins_size=1
    iget-boolean v0, v4, Lcom/bytedance/trae/home/MainActivity;->onboardingShowing Z
    if-eqz v0, +003h
    return-void 
    const/4 v0, 1
    iput-boolean v0, v4, Lcom/bytedance/trae/home/MainActivity;->onboardingShowing Z
    invoke-direct v4, Lcom/bytedance/trae/home/MainActivity;->dismissSplash()V
    iget v0, v4, Lcom/bytedance/trae/home/MainActivity;->onboardingContainerId I
    invoke-virtual v4, v0, Lcom/bytedance/trae/home/MainActivity;->findViewById(I)Landroid/view/View;
    move-result-object v0
    if-eqz v0, +006h
    const/4 v1, 0
    invoke-virtual v0, v1, Landroid/view/View;->setVisibility(I)V
    new-instance v0, Lcom/bytedance/trae/home/onboarding/OnboardingFragment;
    invoke-direct v0, Lcom/bytedance/trae/home/onboarding/OnboardingFragment;-><init>()V
    new-instance v1, Lcom/bytedance/trae/home/MainActivity$$ExternalSyntheticLambda4;
    invoke-direct v1, v4, Lcom/bytedance/trae/home/MainActivity$$ExternalSyntheticLambda4;-><init>(Lcom/bytedance/trae/home/MainActivity;)V
    invoke-virtual v0, v1, Lcom/bytedance/trae/home/onboarding/OnboardingFragment;->setOnFinished(Lkotlin/jvm/functions/Function0;)V
    invoke-virtual v4, Lcom/bytedance/trae/home/MainActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v1
    invoke-virtual v1, Landroidx/fragment/app/FragmentManager;->beginTransaction()Landroidx/fragment/app/FragmentTransaction;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/home/MainActivity;->onboardingContainerId I
    check-cast v0, Landroidx/fragment/app/Fragment;
    const-string/jumbo v3, tag_onboarding_fragment
    invoke-virtual v1, v2, v0, v3, Landroidx/fragment/app/FragmentTransaction;->replace(I Landroidx/fragment/app/Fragment; Ljava/lang/String;)Landroidx/fragment/app/FragmentTransaction;
    move-result-object v0
    invoke-virtual v0, Landroidx/fragment/app/FragmentTransaction;->commitAllowingStateLoss()I
    return-void 
.end method

.method private static final showOnboarding$lambda$10(com.bytedance.trae.home.MainActivity)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/home/MainActivity;->dismissOnboarding()V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private final showOnboardingOrMainPage()void
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/home/MainActivity;->onboardingShowing Z
    if-eqz v0, +003h
    return-void 
    sget-object v0, Lcom/bytedance/trae/home/onboarding/OnboardingFragment;->Companion Lcom/bytedance/trae/home/onboarding/OnboardingFragment$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/home/onboarding/OnboardingFragment$Companion;->hasShown()Z
    move-result v0
    if-nez v0, +006h
    invoke-direct v1, Lcom/bytedance/trae/home/MainActivity;->showOnboarding()V
    goto +4h
    invoke-direct v1, Lcom/bytedance/trae/home/MainActivity;->enterMainPage()V
    return-void 
.end method

.method private final tryInitWhenOnResume()void
    .registers 11
    # ins_size=1
    iget-boolean v0, v10, Lcom/bytedance/trae/home/MainActivity;->alreadyInit Z
    if-eqz v0, +003h
    return-void 
    const-string/jumbo v0, tryInitWhenOnResume
    const-string v1, "MainActivity"
    invoke-static v1, v0, Landroid/util/Log;->i(Ljava/lang/String; Ljava/lang/String;)I
    invoke-virtual v10, Lcom/bytedance/trae/home/MainActivity;->getIntent()Landroid/content/Intent;
    move-result-object v0
    const-string v2, "from_language_switch"
    const/4 v3, 0
    invoke-virtual v0, v2, v3, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String; Z)Z
    move-result v0
    const/4 v4, 1
    if-eqz v0, +013h
    invoke-virtual v10, Lcom/bytedance/trae/home/MainActivity;->getIntent()Landroid/content/Intent;
    move-result-object v0
    invoke-virtual v0, v2, Landroid/content/Intent;->removeExtra(Ljava/lang/String;)V
    iput-boolean v4, v10, Lcom/bytedance/trae/home/MainActivity;->alreadyInit Z
    iput-boolean v3, v10, Lcom/bytedance/trae/home/MainActivity;->isFirstEnterMainPage Z
    const-string v0, "Language switch recreate, staying on task list"
    invoke-static v1, v0, Landroid/util/Log;->i(Ljava/lang/String; Ljava/lang/String;)I
    return-void 
    invoke-virtual v10, Lcom/bytedance/trae/home/MainActivity;->getIntent()Landroid/content/Intent;
    move-result-object v0
    const-string v2, "from_login_success"
    invoke-virtual v0, v2, v3, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String; Z)Z
    move-result v0
    const-class v2, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v2
    const-class v5, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v2, v5, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/login/api/ILoginService;
    const/4 v5, 0
    if-eqz v2, +007h
    invoke-interface v2, Lcom/bytedance/trae/login/api/ILoginService;->getAccountInfo()Lcom/bytedance/trae/login/api/AccountInfo;
    move-result-object v6
    goto +2h
    move-object v6, v5
    if-eqz v2, +00ah
    invoke-interface v2, Lcom/bytedance/trae/login/api/ILoginService;->isTraeLoggedIn()Z
    move-result v7
    if-ne v7, v4, +004h
    move v7, v4
    goto +2h
    move v7, v3
    new-instance v8, Ljava/lang/StringBuilder;
    const-string v9, "loginService="
    invoke-direct v8, v9, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    if-eqz v2, +004h
    move v2, v4
    goto +2h
    move v2, v3
    invoke-virtual v8, v2, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v8, ", isLogin="
    invoke-virtual v2, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    if-eqz v6, +00bh
    invoke-virtual v6, Lcom/bytedance/trae/login/api/AccountInfo;->isLogin()Z
    move-result v8
    invoke-static v8, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v8
    goto +2h
    move-object v8, v5
    invoke-virtual v2, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v8, ", traeLoggedIn="
    invoke-virtual v2, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v7, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v8, ", fromLoginSuccess="
    invoke-virtual v2, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v0, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-static v1, v2, Landroid/util/Log;->i(Ljava/lang/String; Ljava/lang/String;)I
    if-nez v0, +030h
    if-nez v7, +02eh
    if-eqz v6, +009h
    invoke-virtual v6, Lcom/bytedance/trae/login/api/AccountInfo;->isLogin()Z
    move-result v0
    if-ne v0, v4, +003h
    move v3, v4
    if-eqz v3, +003h
    goto +21h
    const-string v0, "Not logged in, navigating to login"
    invoke-static v1, v0, Landroid/util/Log;->i(Ljava/lang/String; Ljava/lang/String;)I
    sget-object v0, Lcom/bytedance/trae/home/MainActivity;->pendingDeepLinkUri Landroid/net/Uri;
    if-nez v0, +00eh
    invoke-virtual v10, Lcom/bytedance/trae/home/MainActivity;->getIntent()Landroid/content/Intent;
    move-result-object v0
    if-eqz v0, +006h
    invoke-virtual v0, Landroid/content/Intent;->getData()Landroid/net/Uri;
    move-result-object v5
    sput-object v5, Lcom/bytedance/trae/home/MainActivity;->pendingDeepLinkUri Landroid/net/Uri;
    invoke-direct v10, Lcom/bytedance/trae/home/MainActivity;->dismissSplash()V
    invoke-direct v10, Lcom/bytedance/trae/home/MainActivity;->navigateToLoginActivity()V
    invoke-virtual v10, Lcom/bytedance/trae/home/MainActivity;->finish()V
    goto/16 +094h
    sget-object v0, Lcom/bytedance/trae/home/MainActivity;->pendingDeepLinkUri Landroid/net/Uri;
    if-nez v0, +00eh
    invoke-virtual v10, Lcom/bytedance/trae/home/MainActivity;->getIntent()Landroid/content/Intent;
    move-result-object v0
    if-eqz v0, +007h
    invoke-virtual v0, Landroid/content/Intent;->getData()Landroid/net/Uri;
    move-result-object v0
    goto +2h
    move-object v0, v5
    if-eqz v0, +00ah
    sget-object v2, Lcom/bytedance/trae/push/api/PushDeeplinkPendingStore;->INSTANCE Lcom/bytedance/trae/push/api/PushDeeplinkPendingStore;
    move-object v3, v10
    check-cast v3, Landroid/content/Context;
    invoke-virtual v2, v3, Lcom/bytedance/trae/push/api/PushDeeplinkPendingStore;->clear(Landroid/content/Context;)V
    if-nez v0, +00bh
    sget-object v0, Lcom/bytedance/trae/push/api/PushDeeplinkPendingStore;->INSTANCE Lcom/bytedance/trae/push/api/PushDeeplinkPendingStore;
    move-object v2, v10
    check-cast v2, Landroid/content/Context;
    invoke-virtual v0, v2, Lcom/bytedance/trae/push/api/PushDeeplinkPendingStore;->consumeIfPresent(Landroid/content/Context;)Landroid/net/Uri;
    move-result-object v0
    sput-object v5, Lcom/bytedance/trae/home/MainActivity;->pendingDeepLinkUri Landroid/net/Uri;
    if-eqz v0, +04fh
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "Handling pending deep link after login: "
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-static v1, v2, Landroid/util/Log;->i(Ljava/lang/String; Ljava/lang/String;)I
    invoke-virtual v10, Lcom/bytedance/trae/home/MainActivity;->getIntent()Landroid/content/Intent;
    move-result-object v1
    if-eqz v1, +005h
    invoke-virtual v1, v5, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;
    const-string v1, "conversation_id"
    invoke-virtual v0, v1, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    sget-object v2, Lcom/bytedance/trae/home/zlink/PendingDeepLinkRoutePolicy;->INSTANCE Lcom/bytedance/trae/home/zlink/PendingDeepLinkRoutePolicy;
    invoke-virtual v0, Landroid/net/Uri;->getHost()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, v1, Lcom/bytedance/trae/home/zlink/PendingDeepLinkRoutePolicy;->resolve(Ljava/lang/String; Ljava/lang/String;)Lcom/bytedance/trae/home/zlink/PendingDeepLinkRoute;
    move-result-object v1
    instance-of v2, v1, Lcom/bytedance/trae/home/zlink/PendingDeepLinkRoute$Conversation;
    if-eqz v2, +00ah
    new-instance v0, Lcom/bytedance/trae/home/MainActivity$$ExternalSyntheticLambda0;
    invoke-direct v0, v1, v10, Lcom/bytedance/trae/home/MainActivity$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/home/zlink/PendingDeepLinkRoute; Lcom/bytedance/trae/home/MainActivity;)V
    iput-object v0, v10, Lcom/bytedance/trae/home/MainActivity;->pendingNavigate Lkotlin/jvm/functions/Function0;
    goto +23h
    sget-object v2, Lcom/bytedance/trae/home/zlink/PendingDeepLinkRoute$RoutedByZlink;->INSTANCE Lcom/bytedance/trae/home/zlink/PendingDeepLinkRoute$RoutedByZlink;
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +00ah
    new-instance v1, Lcom/bytedance/trae/home/MainActivity$$ExternalSyntheticLambda1;
    invoke-direct v1, v10, v0, Lcom/bytedance/trae/home/MainActivity$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/home/MainActivity; Landroid/net/Uri;)V
    iput-object v1, v10, Lcom/bytedance/trae/home/MainActivity;->pendingNavigate Lkotlin/jvm/functions/Function0;
    goto +13h
    new-instance v0, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v0, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v0
    const-string v0, "Logged in, navigating to task"
    invoke-static v1, v0, Landroid/util/Log;->i(Ljava/lang/String; Ljava/lang/String;)I
    new-instance v0, Lcom/bytedance/trae/home/MainActivity$$ExternalSyntheticLambda2;
    invoke-direct v0, v10, Lcom/bytedance/trae/home/MainActivity$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/home/MainActivity;)V
    iput-object v0, v10, Lcom/bytedance/trae/home/MainActivity;->pendingNavigate Lkotlin/jvm/functions/Function0;
    invoke-direct v10, Lcom/bytedance/trae/home/MainActivity;->observeContentReady()V
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isOversea()Z
    move-result v0
    if-nez v0, +007h
    sget-object v0, Lcom/bytedance/trae/update/AppUpdateChecker;->INSTANCE Lcom/bytedance/trae/update/AppUpdateChecker;
    invoke-virtual v0, v4, Lcom/bytedance/trae/update/AppUpdateChecker;->checkUpdate(Z)V
    iput-boolean v4, v10, Lcom/bytedance/trae/home/MainActivity;->alreadyInit Z
    return-void 
.end method

.method private static final tryInitWhenOnResume$lambda$11(com.bytedance.trae.home.zlink.PendingDeepLinkRoute  com.bytedance.trae.home.MainActivity)kotlin.Unit
    .registers 3
    # ins_size=2
    check-cast v1, Lcom/bytedance/trae/home/zlink/PendingDeepLinkRoute$Conversation;
    invoke-virtual v1, Lcom/bytedance/trae/home/zlink/PendingDeepLinkRoute$Conversation;->getConversationId()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +006h
    invoke-direct v2, Lcom/bytedance/trae/home/MainActivity;->navigateToConversationActivity()V
    goto +8h
    invoke-virtual v1, Lcom/bytedance/trae/home/zlink/PendingDeepLinkRoute$Conversation;->getConversationId()Ljava/lang/String;
    move-result-object v1
    invoke-direct v2, v1, Lcom/bytedance/trae/home/MainActivity;->navigateToConversationById(Ljava/lang/String;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final tryInitWhenOnResume$lambda$12(com.bytedance.trae.home.MainActivity  android.net.Uri)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/home/MainActivity;->handlePendingDeepLink(Landroid/net/Uri;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final tryInitWhenOnResume$lambda$13(com.bytedance.trae.home.MainActivity)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/home/MainActivity;->navigateToConversationActivity()V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method public com_bytedance_trae_home_MainActivity__onStop$___twin___()void
    .registers 1
    # ins_size=1
    invoke-super v0, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->onStop()V
    return-void 
.end method

.method public getDecorViewBackgroundColor()int
    .registers 2
    # ins_size=1
    sget v0, Lcom/bytedance/trae/common_ui/R$color;->trae_bg_bg_base_secondary I
    invoke-virtual v1, v0, Lcom/bytedance/trae/home/MainActivity;->getColor(I)I
    move-result v0
    return v0
.end method

.method protected onCreate(android.os.Bundle)void
    .registers 13
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isPreinstallApp()Z
    move-result v0
    const-string v1, "MainActivity"
    if-eqz v0, +02dh
    sget-object v0, Lcom/bytedance/trae/home/privacy/PrivacyManager;->INSTANCE Lcom/bytedance/trae/home/privacy/PrivacyManager;
    invoke-virtual v0, Lcom/bytedance/trae/home/privacy/PrivacyManager;->checkAgreed()Z
    move-result v0
    if-nez v0, +025h
    invoke-super v11, v12, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->onCreate(Landroid/os/Bundle;)V
    const-string v12, "preinstall app, start PrivacyAgreeActivity in :privacy process"
    invoke-static v1, v12, Landroid/util/Log;->i(Ljava/lang/String; Ljava/lang/String;)I
    sget-object v12, Lcom/bytedance/trae/home/privacy/PrivacyManager;->INSTANCE Lcom/bytedance/trae/home/privacy/PrivacyManager;
    move-object v0, v11
    check-cast v0, Landroid/content/Context;
    invoke-virtual v12, v0, Lcom/bytedance/trae/home/privacy/PrivacyManager;->registerReceiver(Landroid/content/Context;)V
    new-instance v12, Landroid/content/Intent;
    const-class v1, Lcom/bytedance/trae/home/privacy/PrivacyAgreeActivity;
    invoke-direct v12, v0, v1, Landroid/content/Intent;-><init>(Landroid/content/Context; Ljava/lang/Class;)V
    const/high16 v0, 268435456
    invoke-virtual v12, v0, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;
    invoke-virtual v11, v12, Lcom/bytedance/trae/home/MainActivity;->startActivity(Landroid/content/Intent;)V
    invoke-super v11, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->finish()V
    return-void 
    invoke-virtual v11, Lcom/bytedance/trae/home/MainActivity;->getIntent()Landroid/content/Intent;
    move-result-object v0
    const/4 v2, 0
    if-eqz v0, +009h
    const-string v3, "extra_pending_uri"
    invoke-virtual v0, v3, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    goto +2h
    move-object v0, v2
    move-object v3, v0
    check-cast v3, Ljava/lang/CharSequence;
    const/4 v4, 0
    if-eqz v3, +00bh
    invoke-interface v3, Ljava/lang/CharSequence;->length()I
    move-result v3
    if-nez v3, +003h
    goto +3h
    move v3, v4
    goto +2h
    const/4 v3, 1
    if-nez v3, +01ah
    invoke-static v0, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v3
    sput-object v3, Lcom/bytedance/trae/home/MainActivity;->pendingDeepLinkUri Landroid/net/Uri;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v5, "Received pending URI from extra: "
    invoke-direct v3, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-static v1, v0, Landroid/util/Log;->i(Ljava/lang/String; Ljava/lang/String;)I
    sget-object v0, Lcom/bytedance/trae/home/privacy/InitPeriodWrapper;->INSTANCE Lcom/bytedance/trae/home/privacy/InitPeriodWrapper;
    move-object v3, v11
    check-cast v3, Landroid/app/Activity;
    invoke-virtual v0, v3, Lcom/bytedance/trae/home/privacy/InitPeriodWrapper;->beforeSuperCreate(Landroid/app/Activity;)V
    invoke-super v11, v12, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->onCreate(Landroid/os/Bundle;)V
    sget-object v12, Lcom/bytedance/trae/home/privacy/InitPeriodWrapper;->INSTANCE Lcom/bytedance/trae/home/privacy/InitPeriodWrapper;
    invoke-virtual v12, Lcom/bytedance/trae/home/privacy/InitPeriodWrapper;->afterSuperCreateStart()V
    invoke-virtual v11, Lcom/bytedance/trae/home/MainActivity;->getOnBackPressedDispatcher()Landroidx/activity/OnBackPressedDispatcher;
    move-result-object v5
    const-string v12, "<get-onBackPressedDispatcher>(...)"
    invoke-static v5, v12, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v6, v11
    check-cast v6, Landroidx/lifecycle/LifecycleOwner;
    const/4 v7, 0
    new-instance v8, Lcom/bytedance/trae/home/MainActivity$$ExternalSyntheticLambda5;
    invoke-direct v8, v11, Lcom/bytedance/trae/home/MainActivity$$ExternalSyntheticLambda5;-><init>(Lcom/bytedance/trae/home/MainActivity;)V
    const/4 v9, 2
    const/4 v10, 0
    invoke-static/range v5 ... v10, Landroidx/activity/OnBackPressedDispatcherKt;->addCallback$default(Landroidx/activity/OnBackPressedDispatcher; Landroidx/lifecycle/LifecycleOwner; Z Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)Landroidx/activity/OnBackPressedCallback;
    sget-object v12, Lcom/bytedance/trae/home/privacy/PrivacyManager;->INSTANCE Lcom/bytedance/trae/home/privacy/PrivacyManager;
    invoke-virtual v12, Lcom/bytedance/trae/home/privacy/PrivacyManager;->checkAgreed()Z
    move-result v12
    if-nez v12, +021h
    const-string v12, "privacy not agreed, show privacy dialog"
    invoke-static v1, v12, Landroid/util/Log;->i(Ljava/lang/String; Ljava/lang/String;)I
    sget-object v12, Lcom/bytedance/trae/home/privacy/PrivacyCache;->INSTANCE Lcom/bytedance/trae/home/privacy/PrivacyCache;
    move-object v0, v11
    check-cast v0, Landroid/content/Context;
    invoke-virtual v12, v0, Lcom/bytedance/trae/home/privacy/PrivacyCache;->savePrivacyWindowShow(Landroid/content/Context;)V
    sget-object v12, Lcom/bytedance/trae/home/privacy/PrivacyDialogHelper;->INSTANCE Lcom/bytedance/trae/home/privacy/PrivacyDialogHelper;
    move-object v0, v11
    check-cast v0, Landroidx/activity/ComponentActivity;
    new-instance v1, Lcom/bytedance/trae/home/MainActivity$$ExternalSyntheticLambda6;
    invoke-direct v1, v11, Lcom/bytedance/trae/home/MainActivity$$ExternalSyntheticLambda6;-><init>(Lcom/bytedance/trae/home/MainActivity;)V
    new-instance v3, Lcom/bytedance/trae/home/MainActivity$$ExternalSyntheticLambda7;
    invoke-direct v3, v11, Lcom/bytedance/trae/home/MainActivity$$ExternalSyntheticLambda7;-><init>(Lcom/bytedance/trae/home/MainActivity;)V
    invoke-virtual v12, v0, v1, v3, Lcom/bytedance/trae/home/privacy/PrivacyDialogHelper;->showDialog(Landroidx/activity/ComponentActivity; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0;)V
    new-instance v12, Landroid/widget/FrameLayout;
    move-object v0, v11
    check-cast v0, Landroid/content/Context;
    invoke-direct v12, v0, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;)V
    new-instance v1, Landroid/widget/FrameLayout;
    invoke-direct v1, v0, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;)V
    sget v3, Lcom/bytedance/trae/home/R$id;->fragment_container I
    invoke-virtual v1, v3, Landroid/widget/FrameLayout;->setId(I)V
    new-instance v3, Landroid/widget/FrameLayout$LayoutParams;
    const/4 v5, -1
    invoke-direct v3, v5, v5, Landroid/widget/FrameLayout$LayoutParams;-><init>(I I)V
    check-cast v3, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v1, v3, Landroid/widget/FrameLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v1, Landroid/view/View;
    invoke-virtual v12, v1, Landroid/widget/FrameLayout;->addView(Landroid/view/View;)V
    new-instance v1, Landroid/widget/FrameLayout;
    invoke-direct v1, v0, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;)V
    invoke-static Landroid/view/View;->generateViewId()I
    move-result v0
    invoke-virtual v1, v0, Landroid/widget/FrameLayout;->setId(I)V
    new-instance v0, Landroid/widget/FrameLayout$LayoutParams;
    invoke-direct v0, v5, v5, Landroid/widget/FrameLayout$LayoutParams;-><init>(I I)V
    check-cast v0, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v1, v0, Landroid/widget/FrameLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    const/16 v0, 8
    invoke-virtual v1, v0, Landroid/widget/FrameLayout;->setVisibility(I)V
    invoke-virtual v1, Landroid/widget/FrameLayout;->getId()I
    move-result v0
    iput v0, v11, Lcom/bytedance/trae/home/MainActivity;->onboardingContainerId I
    check-cast v1, Landroid/view/View;
    invoke-virtual v12, v1, Landroid/widget/FrameLayout;->addView(Landroid/view/View;)V
    check-cast v12, Landroid/view/View;
    invoke-virtual v11, v12, Lcom/bytedance/trae/home/MainActivity;->setContentView(Landroid/view/View;)V
    invoke-virtual v11, Lcom/bytedance/trae/home/MainActivity;->getWindow()Landroid/view/Window;
    move-result-object v12
    sget v0, Lcom/bytedance/trae/common_ui/R$color;->trae_bg_bg_base_secondary I
    invoke-virtual v12, v0, Landroid/view/Window;->setBackgroundDrawableResource(I)V
    iget-object v12, v11, Lcom/bytedance/trae/home/MainActivity;->pendingNavigate Lkotlin/jvm/functions/Function0;
    iput-object v2, v11, Lcom/bytedance/trae/home/MainActivity;->pendingNavigate Lkotlin/jvm/functions/Function0;
    if-eqz v12, +005h
    invoke-interface v12, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    sget-boolean v12, Lcom/bytedance/trae/home/MainActivity;->isColdStart Z
    if-eqz v12, +005h
    const-string v12, "cold_start"
    goto +3h
    const-string v12, "background_resume"
    sget-object v0, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    new-instance v1, Lorg/json/JSONObject;
    invoke-direct v1, Lorg/json/JSONObject;-><init>()V
    const-string v2, "enter_from"
    invoke-virtual v1, v2, v12, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v12, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    const-string/jumbo v12, splash_page_view
    invoke-virtual v0, v12, v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    sput-boolean v4, Lcom/bytedance/trae/home/MainActivity;->isColdStart Z
    sget-object v12, Lcom/bytedance/trae/home/privacy/InitPeriodWrapper;->INSTANCE Lcom/bytedance/trae/home/privacy/InitPeriodWrapper;
    invoke-virtual v12, Lcom/bytedance/trae/home/privacy/InitPeriodWrapper;->afterSuperCreateEnd()V
    invoke-direct v11, Lcom/bytedance/trae/home/MainActivity;->initDebugFloatingButton()V
    return-void 
.end method

.method protected onDestroy()void
    .registers 3
    # ins_size=1
    invoke-super v2, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->onDestroy()V
    iget-object v0, v2, Lcom/bytedance/trae/home/MainActivity;->handler Landroid/os/Handler;
    iget-object v1, v2, Lcom/bytedance/trae/home/MainActivity;->dismissSplashRunnable Ljava/lang/Runnable;
    invoke-virtual v0, v1, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V
    return-void 
.end method

.method protected onResume()void
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/home/privacy/InitPeriodWrapper;->INSTANCE Lcom/bytedance/trae/home/privacy/InitPeriodWrapper;
    invoke-virtual v0, Lcom/bytedance/trae/home/privacy/InitPeriodWrapper;->beforeSuperResume()V
    invoke-super v3, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->onResume()V
    sget-object v0, Lcom/bytedance/trae/home/privacy/InitPeriodWrapper;->INSTANCE Lcom/bytedance/trae/home/privacy/InitPeriodWrapper;
    invoke-virtual v0, Lcom/bytedance/trae/home/privacy/InitPeriodWrapper;->afterSuperResume()V
    const-class v0, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v0
    const-class v1, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v0, v1, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/login/api/ILoginService;
    if-eqz v0, +00bh
    invoke-interface v0, Lcom/bytedance/trae/login/api/ILoginService;->getAccountInfo()Lcom/bytedance/trae/login/api/AccountInfo;
    move-result-object v1
    if-eqz v1, +005h
    invoke-virtual v1, Lcom/bytedance/trae/login/api/AccountInfo;->getUserId()Ljava/lang/String;
    if-eqz v0, +011h
    invoke-interface v0, Lcom/bytedance/trae/login/api/ILoginService;->getAccountInfo()Lcom/bytedance/trae/login/api/AccountInfo;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/login/api/AccountInfo;->isLogin()Z
    move-result v0
    if-eqz v0, +007h
    sget-object v0, Lcom/bytedance/trae/conversation/voice/VoiceChatConfigWarmup;->INSTANCE Lcom/bytedance/trae/conversation/voice/VoiceChatConfigWarmup;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/VoiceChatConfigWarmup;->warmup()V
    sget-object v0, Lcom/bytedance/trae/home/privacy/PrivacyManager;->INSTANCE Lcom/bytedance/trae/home/privacy/PrivacyManager;
    invoke-virtual v0, Lcom/bytedance/trae/home/privacy/PrivacyManager;->checkAgreed()Z
    move-result v0
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "onResume: privacyAgreed="
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v0, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    const-string v2, "MainActivity"
    invoke-static v2, v1, Landroid/util/Log;->i(Ljava/lang/String; Ljava/lang/String;)I
    if-eqz v0, +005h
    invoke-direct v3, Lcom/bytedance/trae/home/MainActivity;->showOnboardingOrMainPage()V
    return-void 
    :try_start_0xd
.end method

.method protected onStop()void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/home/MainActivity;->com_bytedance_trae_home_MainActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(Lcom/bytedance/trae/home/MainActivity;)V
    return-void 
.end method
