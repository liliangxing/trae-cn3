# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/privacy/PrivacyAgreeActivity;
.super Landroidx/activity/ComponentActivity;
.source "PrivacyAgreeActivity.kt"

.field public static final $stable:I
.field private final handler:Landroid/os/Handler;


.method public static synthetic $r8$lambda$IZwm9t8TdL9aGaOozb07w2H9jbY(com.bytedance.trae.home.privacy.PrivacyAgreeActivity)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/home/privacy/PrivacyAgreeActivity;->onPrivacyAccepted$lambda$4(Lcom/bytedance/trae/home/privacy/PrivacyAgreeActivity;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$TdXm4ARqQVOo7d9fCCr_nQyQhvw(android.app.Dialog  com.bytedance.trae.home.privacy.PrivacyAgreeActivity  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/home/privacy/PrivacyAgreeActivity;->showPrivacyDialog$lambda$3(Landroid/app/Dialog; Lcom/bytedance/trae/home/privacy/PrivacyAgreeActivity; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$dI2AzqK0bqhqXhh9KU1XLZhlphU()void
    .registers 0
    # ins_size=0
    invoke-static Lcom/bytedance/trae/home/privacy/PrivacyAgreeActivity;->onPrivacyRefused$lambda$5()V
    return-void 
.end method

.method public static synthetic $r8$lambda$tzMal1Tlv-Xw5l2qOjrAc8o28wU(android.app.Dialog  com.bytedance.trae.home.privacy.PrivacyAgreeActivity  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/home/privacy/PrivacyAgreeActivity;->showPrivacyDialog$lambda$2(Landroid/app/Dialog; Lcom/bytedance/trae/home/privacy/PrivacyAgreeActivity; Landroid/view/View;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public constructor <init>()void
    .registers 3
    # ins_size=1
    invoke-direct v2, Landroidx/activity/ComponentActivity;-><init>()V
    new-instance v0, Landroid/os/Handler;
    invoke-static Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;
    move-result-object v1
    invoke-direct v0, v1, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V
    iput-object v0, v2, Lcom/bytedance/trae/home/privacy/PrivacyAgreeActivity;->handler Landroid/os/Handler;
    return-void 
.end method

.method public static com_bytedance_trae_home_privacy_PrivacyAgreeActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(com.bytedance.trae.home.privacy.PrivacyAgreeActivity)void
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/home/privacy/PrivacyAgreeActivity;->com_bytedance_trae_home_privacy_PrivacyAgreeActivity__onStop$___twin___()V
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

.method private final onPrivacyAccepted()void
    .registers 5
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/home/privacy/PrivacyManager;->INSTANCE Lcom/bytedance/trae/home/privacy/PrivacyManager;
    move-object v1, v4
    check-cast v1, Landroid/content/Context;
    invoke-virtual v0, v1, Lcom/bytedance/trae/home/privacy/PrivacyManager;->sendKillMySelfBroadcast(Landroid/content/Context;)V
    sget-object v0, Lcom/bytedance/trae/home/privacy/PrivacyCache;->INSTANCE Lcom/bytedance/trae/home/privacy/PrivacyCache;
    const/4 v2, 1
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/privacy/PrivacyCache;->savePrivacyWindowClick(Landroid/content/Context; Z)V
    sget-object v0, Lcom/bytedance/trae/home/privacy/PrivacyManager;->INSTANCE Lcom/bytedance/trae/home/privacy/PrivacyManager;
    invoke-virtual v0, v2, Lcom/bytedance/trae/home/privacy/PrivacyManager;->notifyAgree(Z)V
    sget-object v0, Lcom/bytedance/trae/home/zlink/ZlinkInitializer;->INSTANCE Lcom/bytedance/trae/home/zlink/ZlinkInitializer;
    invoke-virtual v4, Lcom/bytedance/trae/home/privacy/PrivacyAgreeActivity;->getApplication()Landroid/app/Application;
    move-result-object v1
    const-string v2, "getApplication(...)"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v0, v1, Lcom/bytedance/trae/home/zlink/ZlinkInitializer;->initAfterPrivacyAgreed(Landroid/app/Application;)V
    iget-object v0, v4, Lcom/bytedance/trae/home/privacy/PrivacyAgreeActivity;->handler Landroid/os/Handler;
    new-instance v1, Lcom/bytedance/trae/home/privacy/PrivacyAgreeActivity$$ExternalSyntheticLambda1;
    invoke-direct v1, v4, Lcom/bytedance/trae/home/privacy/PrivacyAgreeActivity$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/home/privacy/PrivacyAgreeActivity;)V
    const-wide/16 v2, 300
    invoke-virtual v0, v1, v2, v3, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable; J)Z
    return-void 
.end method

.method private static final onPrivacyAccepted$lambda$4(com.bytedance.trae.home.privacy.PrivacyAgreeActivity)void
    .registers 4
    # ins_size=1
    new-instance v0, Landroid/content/Intent;
    move-object v1, v3
    check-cast v1, Landroid/content/Context;
    const-class v2, Lcom/bytedance/trae/home/MainActivity;
    invoke-direct v0, v1, v2, Landroid/content/Intent;-><init>(Landroid/content/Context; Ljava/lang/Class;)V
    const v1, 268468224
    invoke-virtual v0, v1, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;
    invoke-virtual v3, v0, Lcom/bytedance/trae/home/privacy/PrivacyAgreeActivity;->startActivity(Landroid/content/Intent;)V
    return-void 
.end method

.method private final onPrivacyRefused()void
    .registers 5
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/home/privacy/PrivacyCache;->INSTANCE Lcom/bytedance/trae/home/privacy/PrivacyCache;
    move-object v1, v4
    check-cast v1, Landroid/content/Context;
    const/4 v2, 0
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/privacy/PrivacyCache;->savePrivacyWindowClick(Landroid/content/Context; Z)V
    sget-object v0, Lcom/bytedance/trae/home/privacy/PrivacyManager;->INSTANCE Lcom/bytedance/trae/home/privacy/PrivacyManager;
    invoke-virtual v0, v1, Lcom/bytedance/trae/home/privacy/PrivacyManager;->sendKillMySelfBroadcast(Landroid/content/Context;)V
    iget-object v0, v4, Lcom/bytedance/trae/home/privacy/PrivacyAgreeActivity;->handler Landroid/os/Handler;
    new-instance v1, Lcom/bytedance/trae/home/privacy/PrivacyAgreeActivity$$ExternalSyntheticLambda0;
    invoke-direct v1, Lcom/bytedance/trae/home/privacy/PrivacyAgreeActivity$$ExternalSyntheticLambda0;-><init>()V
    const-wide/16 v2, 200
    invoke-virtual v0, v1, v2, v3, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable; J)Z
    return-void 
.end method

.method private static final onPrivacyRefused$lambda$5()void
    .registers 2
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/home/privacy/PrivacyManager;->INSTANCE Lcom/bytedance/trae/home/privacy/PrivacyManager;
    const-string/jumbo v1, user refused privacy agreement
    invoke-virtual v0, v1, Lcom/bytedance/trae/home/privacy/PrivacyManager;->exitProcess(Ljava/lang/String;)V
    return-void 
.end method

.method private final showPrivacyDialog()void
    .registers 9
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/home/privacy/PrivacyCache;->INSTANCE Lcom/bytedance/trae/home/privacy/PrivacyCache;
    move-object v1, v8
    check-cast v1, Landroid/content/Context;
    invoke-virtual v0, v1, Lcom/bytedance/trae/home/privacy/PrivacyCache;->savePrivacyWindowShow(Landroid/content/Context;)V
    new-instance v0, Landroid/app/Dialog;
    invoke-direct v0, v1, Landroid/app/Dialog;-><init>(Landroid/content/Context;)V
    invoke-static v1, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;
    move-result-object v1
    sget v2, Lcom/bytedance/trae/home/R$layout;->dialog_privacy I
    const/4 v3, 0
    invoke-virtual v1, v2, v3, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup;)Landroid/view/View;
    move-result-object v1
    invoke-virtual v0, v1, Landroid/app/Dialog;->setContentView(Landroid/view/View;)V
    invoke-virtual v0, Landroid/app/Dialog;->getWindow()Landroid/view/Window;
    move-result-object v2
    const/4 v3, 0
    if-eqz v2, +02ch
    new-instance v4, Landroid/graphics/drawable/ColorDrawable;
    invoke-direct v4, v3, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V
    check-cast v4, Landroid/graphics/drawable/Drawable;
    invoke-virtual v2, v4, Landroid/view/Window;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V
    invoke-virtual v8, Lcom/bytedance/trae/home/privacy/PrivacyAgreeActivity;->getResources()Landroid/content/res/Resources;
    move-result-object v4
    invoke-virtual v4, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v4
    iget v4, v4, Landroid/util/DisplayMetrics;->widthPixels I
    int-to-double v4, v4
    const-wide v6, 4605831338911806259
    mul-double/2addr v4, v6
    double-to-int v4, v4
    const/4 v5, -2
    invoke-virtual v2, v4, v5, Landroid/view/Window;->setLayout(I I)V
    const/16 v4, 17
    invoke-virtual v2, v4, Landroid/view/Window;->setGravity(I)V
    const/high16 v4, 1056964608
    invoke-virtual v2, v4, Landroid/view/Window;->setDimAmount(F)V
    invoke-virtual v0, v3, Landroid/app/Dialog;->setCancelable(Z)V
    invoke-virtual v0, v3, Landroid/app/Dialog;->setCanceledOnTouchOutside(Z)V
    sget-object v2, Lcom/bytedance/trae/home/privacy/PrivacyDialogHelper;->INSTANCE Lcom/bytedance/trae/home/privacy/PrivacyDialogHelper;
    move-object v3, v8
    check-cast v3, Landroidx/activity/ComponentActivity;
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-virtual v2, v3, v1, Lcom/bytedance/trae/home/privacy/PrivacyDialogHelper;->setupMessageWithLinks(Landroidx/activity/ComponentActivity; Landroid/view/View;)V
    sget v2, Lcom/bytedance/trae/home/R$id;->btn_agree I
    invoke-virtual v1, v2, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v2
    check-cast v2, Landroid/widget/TextView;
    new-instance v3, Lcom/bytedance/trae/home/privacy/PrivacyAgreeActivity$$ExternalSyntheticLambda2;
    invoke-direct v3, v0, v8, Lcom/bytedance/trae/home/privacy/PrivacyAgreeActivity$$ExternalSyntheticLambda2;-><init>(Landroid/app/Dialog; Lcom/bytedance/trae/home/privacy/PrivacyAgreeActivity;)V
    invoke-virtual v2, v3, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    sget v2, Lcom/bytedance/trae/home/R$id;->btn_disagree I
    invoke-virtual v1, v2, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v1
    check-cast v1, Landroid/widget/TextView;
    new-instance v2, Lcom/bytedance/trae/home/privacy/PrivacyAgreeActivity$$ExternalSyntheticLambda3;
    invoke-direct v2, v0, v8, Lcom/bytedance/trae/home/privacy/PrivacyAgreeActivity$$ExternalSyntheticLambda3;-><init>(Landroid/app/Dialog; Lcom/bytedance/trae/home/privacy/PrivacyAgreeActivity;)V
    invoke-virtual v1, v2, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    invoke-virtual v0, Landroid/app/Dialog;->show()V
    return-void 
.end method

.method private static final showPrivacyDialog$lambda$2(android.app.Dialog  com.bytedance.trae.home.privacy.PrivacyAgreeActivity  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-virtual v0, Landroid/app/Dialog;->dismiss()V
    invoke-direct v1, Lcom/bytedance/trae/home/privacy/PrivacyAgreeActivity;->onPrivacyAccepted()V
    return-void 
.end method

.method private static final showPrivacyDialog$lambda$3(android.app.Dialog  com.bytedance.trae.home.privacy.PrivacyAgreeActivity  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-virtual v0, Landroid/app/Dialog;->dismiss()V
    invoke-direct v1, Lcom/bytedance/trae/home/privacy/PrivacyAgreeActivity;->onPrivacyRefused()V
    return-void 
.end method

.method protected attachBaseContext(android.content.Context)void
    .registers 3
    # ins_size=2
    if-eqz v2, +00ch
    sget-object v0, Lcom/bytedance/trae/utils/LocaleManager;->INSTANCE Lcom/bytedance/trae/utils/LocaleManager;
    invoke-virtual v0, v2, Lcom/bytedance/trae/utils/LocaleManager;->wrapContext(Landroid/content/Context;)Landroid/content/Context;
    move-result-object v0
    if-nez v0, +003h
    goto +2h
    move-object v2, v0
    invoke-super v1, v2, Landroidx/activity/ComponentActivity;->attachBaseContext(Landroid/content/Context;)V
    const-string v2, "PrivacyManager"
    const-string v0, "PrivacyAgreeActivity attachBaseContext"
    invoke-static v2, v0, Landroid/util/Log;->i(Ljava/lang/String; Ljava/lang/String;)I
    return-void 
.end method

.method public com_bytedance_trae_home_privacy_PrivacyAgreeActivity__onStop$___twin___()void
    .registers 1
    # ins_size=1
    invoke-super v0, Landroidx/activity/ComponentActivity;->onStop()V
    return-void 
.end method

.method protected onCreate(android.os.Bundle)void
    .registers 4
    # ins_size=2
    invoke-virtual v2, Lcom/bytedance/trae/home/privacy/PrivacyAgreeActivity;->getWindow()Landroid/view/Window;
    move-result-object v0
    const/4 v1, 0
    invoke-static v0, v1, Landroidx/core/view/WindowCompat;->setDecorFitsSystemWindows(Landroid/view/Window; Z)V
    invoke-super v2, v3, Landroidx/activity/ComponentActivity;->onCreate(Landroid/os/Bundle;)V
    const-string v3, "PrivacyManager"
    const-string v0, "PrivacyAgreeActivity onCreate"
    invoke-static v3, v0, Landroid/util/Log;->i(Ljava/lang/String; Ljava/lang/String;)I
    invoke-direct v2, Lcom/bytedance/trae/home/privacy/PrivacyAgreeActivity;->showPrivacyDialog()V
    return-void 
.end method

.method protected onDestroy()void
    .registers 2
    # ins_size=1
    invoke-super v1, Landroidx/activity/ComponentActivity;->onDestroy()V
    invoke-static Landroid/os/Process;->myPid()I
    move-result v0
    invoke-static v0, Landroid/os/Process;->killProcess(I)V
    return-void 
.end method

.method protected onStop()void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/home/privacy/PrivacyAgreeActivity;->com_bytedance_trae_home_privacy_PrivacyAgreeActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(Lcom/bytedance/trae/home/privacy/PrivacyAgreeActivity;)V
    return-void 
.end method
