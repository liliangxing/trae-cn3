# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity;
.super Landroidx/appcompat/app/AppCompatActivity;
.source "GitHubOAuthActivity.kt"

.field public static final $stable:I
.field public static final Companion:Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity$Companion;
.field public static final EXTRA_MODE:Ljava/lang/String;
.field private final connectorManager$delegate:Lkotlin/Lazy;


.method public static synthetic $r8$lambda$orYzIVQh9AcOSu5xCxyEx7kMcGE(com.bytedance.trae.home.solo.setting.GitHubOAuthActivity)com.bytedance.trae.conversation.git.GitHubConnectorManager
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity;->connectorManager_delegate$lambda$0(Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity;)Lcom/bytedance/trae/conversation/git/GitHubConnectorManager;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity;->Companion Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity$Companion;
    const/16 v0, 8
    sput v0, Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity;->$stable I
    return-void 
.end method

.method public constructor <init>()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Landroidx/appcompat/app/AppCompatActivity;-><init>()V
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity$$ExternalSyntheticLambda0;
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity;)V
    invoke-static v0, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v0
    iput-object v0, v1, Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity;->connectorManager$delegate Lkotlin/Lazy;
    return-void 
.end method

.method public static final synthetic access$getConnectorManager(com.bytedance.trae.home.solo.setting.GitHubOAuthActivity)com.bytedance.trae.conversation.git.GitHubConnectorManager
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity;->getConnectorManager()Lcom/bytedance/trae/conversation/git/GitHubConnectorManager;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$getSettingsRedirectUri(com.bytedance.trae.home.solo.setting.GitHubOAuthActivity)java.lang.String
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity;->getSettingsRedirectUri()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public static com_bytedance_trae_home_solo_setting_GitHubOAuthActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(com.bytedance.trae.home.solo.setting.GitHubOAuthActivity)void
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity;->com_bytedance_trae_home_solo_setting_GitHubOAuthActivity__onStop$___twin___()V
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

.method private static final connectorManager_delegate$lambda$0(com.bytedance.trae.home.solo.setting.GitHubOAuthActivity)com.bytedance.trae.conversation.git.GitHubConnectorManager
    .registers 4
    # ins_size=1
    new-instance v0, Lcom/bytedance/trae/conversation/git/GitHubConnectorManager;
    check-cast v3, Landroid/content/Context;
    const/4 v1, 0
    const/4 v2, 2
    invoke-direct v0, v3, v1, v2, v1, Lcom/bytedance/trae/conversation/git/GitHubConnectorManager;-><init>(Landroid/content/Context; Lcom/bytedance/trae/conversation/git/GitHubConnectConfig; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v0
.end method

.method private final getConnectorManager()com.bytedance.trae.conversation.git.GitHubConnectorManager
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity;->connectorManager$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/git/GitHubConnectorManager;
    return-object v0
.end method

.method private final getSettingsRedirectUri()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity;->getPackageName()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, "://github-settings-callback"
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method private final handleCallbackUri(android.net.Uri)void
    .registers 9
    # ins_size=2
    if-eqz v8, +071h
    invoke-virtual v8, Landroid/net/Uri;->getHost()Ljava/lang/String;
    move-result-object v0
    const-string v1, "github-settings-callback"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +003h
    goto +63h
    const-string v0, "error"
    invoke-virtual v8, v0, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Ljava/lang/CharSequence;
    const/4 v2, 0
    if-eqz v1, +00bh
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    if-eqz v1, +003h
    goto +3h
    move v1, v2
    goto +2h
    const/4 v1, 1
    if-nez v1, +032h
    move-object v8, v7
    check-cast v8, Landroid/content/Context;
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct v1, Ljava/lang/StringBuilder;-><init>()V
    sget v3, Lcom/bytedance/trae/home/R$string;->trae_setting_connector_connect_failed I
    invoke-virtual v7, v3, Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity;->getString(I)Ljava/lang/String;
    move-result-object v3
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v3, ": "
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v8, v0, v2, Landroid/widget/Toast;->makeText(Landroid/content/Context; Ljava/lang/CharSequence; I)Landroid/widget/Toast;
    move-result-object v8
    invoke-virtual v8, Landroid/widget/Toast;->show()V
    invoke-virtual v7, v2, Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity;->setResult(I)V
    invoke-virtual v7, Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity;->finish()V
    return-void 
    move-object v0, v7
    check-cast v0, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    const/4 v2, 0
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity$handleCallbackUri$1;
    const/4 v4, 0
    invoke-direct v0, v7, v8, v4, Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity$handleCallbackUri$1;-><init>(Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity; Landroid/net/Uri; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public com_bytedance_trae_home_solo_setting_GitHubOAuthActivity__onStop$___twin___()void
    .registers 1
    # ins_size=1
    invoke-super v0, Landroidx/appcompat/app/AppCompatActivity;->onStop()V
    return-void 
.end method

.method protected onCreate(android.os.Bundle)void
    .registers 5
    # ins_size=2
    invoke-super v3, v4, Landroidx/appcompat/app/AppCompatActivity;->onCreate(Landroid/os/Bundle;)V
    if-eqz v4, +003h
    return-void 
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity;->getIntent()Landroid/content/Intent;
    move-result-object v4
    if-eqz v4, +00ah
    const-string v0, "extra_mode"
    invoke-virtual v4, v0, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    if-nez v4, +004h
    const-string v4, "CONNECT"
    invoke-static v4, Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity$Mode;->valueOf(Ljava/lang/String;)Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity$Mode;
    move-result-object v4
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity$Mode;->ordinal()I
    move-result v4
    aget v4, v0, v4
    const/4 v0, 1
    const-string v1, "android.intent.action.VIEW"
    if-eq v4, v0, +044h
    const/4 v0, 2
    if-ne v4, v0, +03bh
    invoke-direct v3, Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity;->getConnectorManager()Lcom/bytedance/trae/conversation/git/GitHubConnectorManager;
    move-result-object v4
    invoke-virtual v4, Lcom/bytedance/trae/conversation/git/GitHubConnectorManager;->getConfig()Lcom/bytedance/trae/conversation/git/GitHubConnectConfig;
    move-result-object v4
    invoke-virtual v4, Lcom/bytedance/trae/conversation/git/GitHubConnectConfig;->getGitHubApp()Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$GitHubApp;
    move-result-object v4
    invoke-virtual v4, Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$GitHubApp;->getSlug()Ljava/lang/String;
    move-result-object v4
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v2, "https://github.com/apps/"
    invoke-direct v0, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v0, "/installations/new"
    invoke-virtual v4, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    new-instance v0, Landroid/content/Intent;
    invoke-static v4, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v4
    invoke-direct v0, v1, v4, Landroid/content/Intent;-><init>(Ljava/lang/String; Landroid/net/Uri;)V
    invoke-virtual v3, v0, Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity;->startActivity(Landroid/content/Intent;)V
    const/4 v4, -1
    invoke-virtual v3, v4, Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity;->setResult(I)V
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity;->finish()V
    goto +3ch
    new-instance v4, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v4, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v4
    sget-object v4, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v4, v3
    check-cast v4, Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity;
    invoke-direct v3, Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity;->getConnectorManager()Lcom/bytedance/trae/conversation/git/GitHubConnectorManager;
    move-result-object v4
    invoke-direct v3, Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity;->getSettingsRedirectUri()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v4, v0, Lcom/bytedance/trae/conversation/git/GitHubConnectorManager;->buildOAuthUrl(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    invoke-static v4, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v4
    goto +ch
    move-exception v4
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v4, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v4
    invoke-static v4, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v4
    invoke-static v4, Lkotlin/Result;->exceptionOrNull-impl(Ljava/lang/Object;)Ljava/lang/Throwable;
    move-result-object v0
    if-nez v0, +011h
    check-cast v4, Ljava/lang/String;
    new-instance v0, Landroid/content/Intent;
    invoke-static v4, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v4
    invoke-direct v0, v1, v4, Landroid/content/Intent;-><init>(Ljava/lang/String; Landroid/net/Uri;)V
    invoke-virtual v3, v0, Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity;->startActivity(Landroid/content/Intent;)V
    return-void 
    instance-of v4, v0, Lcom/bytedance/trae/conversation/git/GitHubConnectorError;
    if-eqz v4, +006h
    move-object v4, v0
    check-cast v4, Lcom/bytedance/trae/conversation/git/GitHubConnectorError;
    goto +2h
    const/4 v4, 0
    if-eqz v4, +00bh
    move-object v1, v3
    check-cast v1, Landroid/content/Context;
    invoke-virtual v4, v1, Lcom/bytedance/trae/conversation/git/GitHubConnectorError;->localizedMessage(Landroid/content/Context;)Ljava/lang/String;
    move-result-object v4
    if-nez v4, +00ah
    invoke-virtual v0, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v4
    if-nez v4, +004h
    const-string v4, ""
    move-object v0, v3
    check-cast v0, Landroid/content/Context;
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct v1, Ljava/lang/StringBuilder;-><init>()V
    sget v2, Lcom/bytedance/trae/home/R$string;->trae_setting_connector_connect_failed I
    invoke-virtual v3, v2, Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity;->getString(I)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ": "
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    check-cast v4, Ljava/lang/CharSequence;
    const/4 v1, 0
    invoke-static v0, v4, v1, Landroid/widget/Toast;->makeText(Landroid/content/Context; Ljava/lang/CharSequence; I)Landroid/widget/Toast;
    move-result-object v4
    invoke-virtual v4, Landroid/widget/Toast;->show()V
    invoke-virtual v3, v1, Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity;->setResult(I)V
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity;->finish()V
    return-void 
    :try_start_0x69
.end method

.method protected onNewIntent(android.content.Intent)void
    .registers 3
    # ins_size=2
    const-string v0, "intent"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-super v1, v2, Landroidx/appcompat/app/AppCompatActivity;->onNewIntent(Landroid/content/Intent;)V
    invoke-virtual v2, Landroid/content/Intent;->getData()Landroid/net/Uri;
    move-result-object v2
    invoke-direct v1, v2, Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity;->handleCallbackUri(Landroid/net/Uri;)V
    return-void 
.end method

.method protected onResume()void
    .registers 5
    # ins_size=1
    invoke-super v4, Landroidx/appcompat/app/AppCompatActivity;->onResume()V
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity;->getIntent()Landroid/content/Intent;
    move-result-object v0
    const/4 v1, 0
    if-eqz v0, +007h
    invoke-virtual v0, Landroid/content/Intent;->getData()Landroid/net/Uri;
    move-result-object v0
    goto +2h
    move-object v0, v1
    if-eqz v0, +01ah
    invoke-virtual v0, Landroid/net/Uri;->getHost()Ljava/lang/String;
    move-result-object v2
    const-string v3, "github-settings-callback"
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +00eh
    invoke-direct v4, v0, Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity;->handleCallbackUri(Landroid/net/Uri;)V
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity;->getIntent()Landroid/content/Intent;
    move-result-object v0
    if-eqz v0, +005h
    invoke-virtual v0, v1, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;
    return-void 
.end method

.method protected onStop()void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity;->com_bytedance_trae_home_solo_setting_GitHubOAuthActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity;)V
    return-void 
.end method
