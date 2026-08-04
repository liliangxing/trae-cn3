# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;
.super Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;
.source "EnterpriseSsoWebViewActivity.kt"

.field private static final CALLBACK_HOST:Ljava/lang/String;
.field private static final CALLBACK_PATH:Ljava/lang/String;
.field private static final CALLBACK_SCHEME:Ljava/lang/String;
.field public static final Companion:Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity$Companion;
.field private static final EXTRA_EMAIL:Ljava/lang/String;
.field private static final EXTRA_SSO_URL:Ljava/lang/String;
.field private static final MAIN_ACTIVITY_CLASS:Ljava/lang/String;
.field private static final TAG:Ljava/lang/String;
.field private static final TOB_SESSION_COOKIE_NAME:Ljava/lang/String;
.field private email:Ljava/lang/String;
.field private isHandlingCallback:Z
.field private pbLoading:Landroid/widget/ProgressBar;
.field private webView:Landroid/webkit/WebView;


.method public static synthetic $r8$lambda$RO8ToEQKjQdZNZ5d1SPI0dAKXSc(com.bytedance.trae.login.enterprise.EnterpriseSsoWebViewActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;->onCreate$lambda$0(Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity; Landroid/view/View;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;->Companion Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;-><init>()V
    const-string v0, ""
    iput-object v0, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;->email Ljava/lang/String;
    return-void 
.end method

.method public static final synthetic access$getPbLoading$p(com.bytedance.trae.login.enterprise.EnterpriseSsoWebViewActivity)android.widget.ProgressBar
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;->pbLoading Landroid/widget/ProgressBar;
    return-object v0
.end method

.method public static final synthetic access$handleSsoCallback(com.bytedance.trae.login.enterprise.EnterpriseSsoWebViewActivity)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;->handleSsoCallback()V
    return-void 
.end method

.method public static final synthetic access$isSsoCallback(com.bytedance.trae.login.enterprise.EnterpriseSsoWebViewActivity  android.net.Uri)boolean
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;->isSsoCallback(Landroid/net/Uri;)Z
    move-result v0
    return v0
.end method

.method public static final synthetic access$navigateToMain(com.bytedance.trae.login.enterprise.EnterpriseSsoWebViewActivity)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;->navigateToMain()V
    return-void 
.end method

.method public static com_bytedance_trae_login_enterprise_EnterpriseSsoWebViewActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(com.bytedance.trae.login.enterprise.EnterpriseSsoWebViewActivity)void
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;->com_bytedance_trae_login_enterprise_EnterpriseSsoWebViewActivity__onStop$___twin___()V
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

.method private final extractCookieValue(java.lang.String  java.lang.String)java.lang.String
    .registers 11
    # ins_size=3
    move-object v0, v9
    check-cast v0, Ljava/lang/CharSequence;
    const/4 v9, 0
    const/4 v6, 1
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-nez v1, +003h
    goto +3h
    move v1, v9
    goto +2h
    move v1, v6
    const/4 v7, 0
    if-eqz v1, +003h
    return-object v7
    const-string v1, ";"
    filled-new-array v1, [Ljava/lang/String;
    move-result-object v1
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 6
    const/4 v5, 0
    invoke-static/range v0 ... v5, Lkotlin/text/StringsKt;->split$default(Ljava/lang/CharSequence; [Ljava/lang/String; Z I I Ljava/lang/Object;)Ljava/util/List;
    move-result-object v0
    invoke-interface v0, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +040h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/String;
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v1
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v2, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const/16 v3, 61
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-static v1, v2, v6, Lkotlin/text/StringsKt;->startsWith(Ljava/lang/String; Ljava/lang/String; Z)Z
    move-result v2
    if-eqz v2, -02dh
    const-string v10, "="
    const-string v0, ""
    invoke-static v1, v10, v0, Lkotlin/text/StringsKt;->substringAfter(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v10
    move-object v0, v10
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-lez v0, +003h
    move v9, v6
    if-eqz v9, +003h
    move-object v7, v10
    return-object v7
.end method

.method private final extractSessionFromCookies()java.lang.String
    .registers 8
    # ins_size=1
    invoke-static Landroid/webkit/CookieManager;->getInstance()Landroid/webkit/CookieManager;
    move-result-object v0
    invoke-virtual v0, Landroid/webkit/CookieManager;->flush()V
    sget-object v1, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginConfig;->INSTANCE Lcom/bytedance/trae/login/enterprise/EnterpriseLoginConfig;
    invoke-virtual v1, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginConfig;->getBaseUrl()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Landroid/webkit/CookieManager;->getCookie(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    const-string v3, "X-Cloudide-Tob-Session"
    invoke-direct v7, v2, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;->extractCookieValue(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    if-eqz v2, +003h
    return-object v2
    iget-object v2, v7, Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;->webView Landroid/webkit/WebView;
    const/4 v4, 0
    if-nez v2, +009h
    const-string/jumbo v2, webView
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v2, v4
    invoke-virtual v2, Landroid/webkit/WebView;->getUrl()Ljava/lang/String;
    move-result-object v2
    move-object v5, v2
    check-cast v5, Ljava/lang/CharSequence;
    if-eqz v5, +00bh
    invoke-interface v5, Ljava/lang/CharSequence;->length()I
    move-result v5
    if-nez v5, +003h
    goto +3h
    const/4 v5, 0
    goto +2h
    const/4 v5, 1
    if-nez v5, +013h
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +00dh
    invoke-virtual v0, v2, Landroid/webkit/CookieManager;->getCookie(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    invoke-direct v7, v2, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;->extractCookieValue(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    if-eqz v2, +003h
    return-object v2
    invoke-static v1, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v2
    invoke-virtual v2, Landroid/net/Uri;->getHost()Ljava/lang/String;
    move-result-object v5
    if-nez v5, +003h
    return-object v4
    new-instance v6, Ljava/lang/StringBuilder;
    invoke-direct v6, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v2, Landroid/net/Uri;->getScheme()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v6, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v6, "://"
    invoke-virtual v2, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +00dh
    invoke-virtual v0, v2, Landroid/webkit/CookieManager;->getCookie(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    invoke-direct v7, v0, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;->extractCookieValue(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    if-eqz v0, +003h
    return-object v0
    return-object v4
.end method

.method private final handleSsoCallback()void
    .registers 21
    # ins_size=1
    move-object/from16 v0, v20
    iget-boolean v1, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;->isHandlingCallback Z
    if-eqz v1, +003h
    return-void 
    const/4 v1, 1
    iput-boolean v1, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;->isHandlingCallback Z
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v3, "SSO callback intercepted, extracting session cookie"
    const-string v4, "EnterpriseSsoWebView"
    invoke-virtual v2, v4, v3, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    invoke-direct/range v20, Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;->extractSessionFromCookies()Ljava/lang/String;
    move-result-object v2
    move-object v3, v2
    check-cast v3, Ljava/lang/CharSequence;
    const/4 v5, 0
    if-eqz v3, +00ah
    invoke-interface v3, Ljava/lang/CharSequence;->length()I
    move-result v3
    if-nez v3, +003h
    goto +2h
    move v1, v5
    if-eqz v1, +038h
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v2, "Failed to extract X-Cloudide-Tob-Session from cookies"
    invoke-virtual v1, v4, v2, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v6, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string v7, "enterprise_sso_session_fail"
    const-string v8, "enterprise"
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const-string v12, "cookie_extraction_failed"
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 2012
    const/16 v19, 0
    invoke-static/range v6 ... v19, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel$default(Lcom/bytedance/trae/login/traeauth/TraeAuthManager; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    move-object v1, v0
    check-cast v1, Landroid/content/Context;
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->trae_enterprise_sso_login_failed I
    invoke-virtual v0, v2, Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;->getString(I)Ljava/lang/String;
    move-result-object v2
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v1, v2, v5, Landroid/widget/Toast;->makeText(Landroid/content/Context; Ljava/lang/CharSequence; I)Landroid/widget/Toast;
    move-result-object v1
    invoke-virtual v1, Landroid/widget/Toast;->show()V
    invoke-virtual/range v20, Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;->finish()V
    return-void 
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v3, "Session cookie extracted, starting token flow"
    invoke-virtual v1, v4, v3, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v5, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string v6, "enterprise_sso_callback"
    const-string v7, "enterprise"
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 2044
    const/16 v18, 0
    invoke-static/range v5 ... v18, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel$default(Lcom/bytedance/trae/login/traeauth/TraeAuthManager; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    sget-object v1, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager;->INSTANCE Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager;
    move-object v3, v0
    check-cast v3, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v3, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v3
    check-cast v3, Lkotlinx/coroutines/CoroutineScope;
    iget-object v4, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;->email Ljava/lang/String;
    new-instance v5, Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity$handleSsoCallback$1;
    invoke-direct v5, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity$handleSsoCallback$1;-><init>(Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;)V
    check-cast v5, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager$Callback;
    invoke-virtual v1, v3, v4, v2, v5, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager;->loginWithSsoSession(Lkotlinx/coroutines/CoroutineScope; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager$Callback;)V
    return-void 
.end method

.method private final isSsoCallback(android.net.Uri)boolean
    .registers 7
    # ins_size=2
    invoke-virtual v6, Landroid/net/Uri;->getScheme()Ljava/lang/String;
    move-result-object v0
    const-string/jumbo v1, traecn
    const/4 v2, 1
    invoke-static v0, v1, v2, Lkotlin/text/StringsKt;->equals(Ljava/lang/String; Ljava/lang/String; Z)Z
    move-result v0
    const/4 v1, 0
    if-eqz v0, +025h
    invoke-virtual v6, Landroid/net/Uri;->getHost()Ljava/lang/String;
    move-result-object v0
    const-string/jumbo v3, oauth
    invoke-static v0, v3, v2, Lkotlin/text/StringsKt;->equals(Ljava/lang/String; Ljava/lang/String; Z)Z
    move-result v0
    if-eqz v0, +018h
    invoke-virtual v6, Landroid/net/Uri;->getPath()Ljava/lang/String;
    move-result-object v6
    if-eqz v6, +00eh
    const/4 v0, 2
    const/4 v3, 0
    const-string v4, "/saas/callback"
    invoke-static v6, v4, v1, v0, v3, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v6
    if-ne v6, v2, +004h
    move v6, v2
    goto +2h
    move v6, v1
    if-eqz v6, +003h
    goto +2h
    move v2, v1
    return v2
.end method

.method private final navigateToMain()void
    .registers 4
    # ins_size=1
    new-instance v0, Landroid/content/Intent;
    invoke-direct v0, Landroid/content/Intent;-><init>()V
    move-object v1, v3
    check-cast v1, Landroid/content/Context;
    const-string v2, "com.bytedance.trae.home.MainActivity"
    invoke-virtual v0, v1, v2, Landroid/content/Intent;->setClassName(Landroid/content/Context; Ljava/lang/String;)Landroid/content/Intent;
    const v1, 268468224
    invoke-virtual v0, v1, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;
    invoke-virtual v3, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;->startActivity(Landroid/content/Intent;)V
    invoke-virtual v3, Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;->finish()V
    return-void 
.end method

.method private static final onCreate$lambda$0(com.bytedance.trae.login.enterprise.EnterpriseSsoWebViewActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-virtual v0, Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;->finish()V
    return-void 
.end method

.method private final setupWebView()void
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;->webView Landroid/webkit/WebView;
    const/4 v1, 0
    const-string/jumbo v2, webView
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;
    move-result-object v0
    const/4 v3, 1
    invoke-virtual v0, v3, Landroid/webkit/WebSettings;->setJavaScriptEnabled(Z)V
    invoke-virtual v0, v3, Landroid/webkit/WebSettings;->setDomStorageEnabled(Z)V
    invoke-virtual v0, v3, Landroid/webkit/WebSettings;->setDatabaseEnabled(Z)V
    iget-object v0, v4, Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;->webView Landroid/webkit/WebView;
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    new-instance v3, Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity$setupWebView$2;
    invoke-direct v3, v4, Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity$setupWebView$2;-><init>(Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;)V
    check-cast v3, Landroid/webkit/WebViewClient;
    invoke-virtual v0, v3, Landroid/webkit/WebView;->setWebViewClient(Landroid/webkit/WebViewClient;)V
    iget-object v0, v4, Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;->webView Landroid/webkit/WebView;
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v0
    new-instance v0, Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity$setupWebView$3;
    invoke-direct v0, v4, Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity$setupWebView$3;-><init>(Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;)V
    check-cast v0, Landroid/webkit/WebChromeClient;
    invoke-virtual v1, v0, Landroid/webkit/WebView;->setWebChromeClient(Landroid/webkit/WebChromeClient;)V
    return-void 
.end method

.method public com_bytedance_trae_login_enterprise_EnterpriseSsoWebViewActivity__onStop$___twin___()void
    .registers 1
    # ins_size=1
    invoke-super v0, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->onStop()V
    return-void 
.end method

.method protected onCreate(android.os.Bundle)void
    .registers 8
    # ins_size=2
    invoke-super v6, v7, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->onCreate(Landroid/os/Bundle;)V
    sget v7, Lcom/bytedance/trae/login/R$layout;->trae_activity_enterprise_sso_webview I
    invoke-virtual v6, v7, Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;->setContentView(I)V
    invoke-virtual v6, Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;->getIntent()Landroid/content/Intent;
    move-result-object v7
    const-string/jumbo v0, sso_url
    invoke-virtual v7, v0, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v7
    invoke-virtual v6, Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;->getIntent()Landroid/content/Intent;
    move-result-object v0
    const-string v1, "email"
    invoke-virtual v0, v1, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    if-nez v0, +004h
    const-string v0, ""
    iput-object v0, v6, Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;->email Ljava/lang/String;
    move-object v0, v7
    check-cast v0, Ljava/lang/CharSequence;
    const/4 v1, 1
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +003h
    goto +3h
    const/4 v0, 0
    goto +2h
    move v0, v1
    const-string v2, "EnterpriseSsoWebView"
    if-eqz v0, +00dh
    sget-object v7, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v0, "SSO URL is empty"
    invoke-virtual v7, v2, v0, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v6, Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;->finish()V
    return-void 
    sget v0, Lcom/bytedance/trae/login/R$id;->pb_loading I
    invoke-virtual v6, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;->findViewById(I)Landroid/view/View;
    move-result-object v0
    const-string v3, "findViewById(...)"
    invoke-static v0, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/ProgressBar;
    iput-object v0, v6, Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;->pbLoading Landroid/widget/ProgressBar;
    sget v0, Lcom/bytedance/trae/login/R$id;->btn_back I
    invoke-virtual v6, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;->findViewById(I)Landroid/view/View;
    move-result-object v0
    new-instance v4, Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity$$ExternalSyntheticLambda0;
    invoke-direct v4, v6, Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;)V
    invoke-virtual v0, v4, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    sget v0, Lcom/bytedance/trae/login/R$id;->webview I
    invoke-virtual v6, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/webkit/WebView;
    iput-object v0, v6, Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;->webView Landroid/webkit/WebView;
    invoke-direct v6, Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;->setupWebView()V
    invoke-static Landroid/webkit/CookieManager;->getInstance()Landroid/webkit/CookieManager;
    move-result-object v0
    invoke-virtual v0, v1, Landroid/webkit/CookieManager;->setAcceptCookie(Z)V
    invoke-static Landroid/webkit/CookieManager;->getInstance()Landroid/webkit/CookieManager;
    move-result-object v0
    iget-object v3, v6, Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;->webView Landroid/webkit/WebView;
    const/4 v4, 0
    const-string/jumbo v5, webView
    if-nez v3, +006h
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v3, v4
    invoke-virtual v0, v3, v1, Landroid/webkit/CookieManager;->setAcceptThirdPartyCookies(Landroid/webkit/WebView; Z)V
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v1, "Loading SSO URL"
    invoke-virtual v0, v2, v1, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v0, v6, Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;->webView Landroid/webkit/WebView;
    if-nez v0, +006h
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v4, v0
    invoke-virtual v4, v7, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V
    return-void 
.end method

.method protected onDestroy()void
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;->webView Landroid/webkit/WebView;
    const-string/jumbo v1, webView
    const/4 v2, 0
    if-nez v0, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    invoke-virtual v0, Landroid/webkit/WebView;->stopLoading()V
    iget-object v0, v4, Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;->webView Landroid/webkit/WebView;
    if-nez v0, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    invoke-virtual v0, Landroid/webkit/WebView;->getParent()Landroid/view/ViewParent;
    move-result-object v0
    instance-of v3, v0, Landroid/view/ViewGroup;
    if-eqz v3, +005h
    check-cast v0, Landroid/view/ViewGroup;
    goto +2h
    move-object v0, v2
    if-eqz v0, +00fh
    iget-object v3, v4, Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;->webView Landroid/webkit/WebView;
    if-nez v3, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v3, v2
    check-cast v3, Landroid/view/View;
    invoke-virtual v0, v3, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V
    iget-object v0, v4, Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;->webView Landroid/webkit/WebView;
    if-nez v0, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v2, v0
    invoke-virtual v2, Landroid/webkit/WebView;->destroy()V
    invoke-super v4, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->onDestroy()V
    return-void 
.end method

.method protected onStop()void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;->com_bytedance_trae_login_enterprise_EnterpriseSsoWebViewActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(Lcom/bytedance/trae/login/enterprise/EnterpriseSsoWebViewActivity;)V
    return-void 
.end method
