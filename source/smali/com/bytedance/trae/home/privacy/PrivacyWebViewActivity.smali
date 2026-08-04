# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/privacy/PrivacyWebViewActivity;
.super Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;
.source "PrivacyWebViewActivity.kt"

.field public static final $stable:I
.field public static final Companion:Lcom/bytedance/trae/home/privacy/PrivacyWebViewActivity$Companion;
.field private static final EXTRA_URL:Ljava/lang/String;
.field private webView:Landroid/webkit/WebView;


.method public static synthetic $r8$lambda$3rVOtedHzIGSIctssP46uPgZP2A(com.bytedance.trae.home.privacy.PrivacyWebViewActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/privacy/PrivacyWebViewActivity;->onCreate$lambda$0(Lcom/bytedance/trae/home/privacy/PrivacyWebViewActivity; Landroid/view/View;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/privacy/PrivacyWebViewActivity$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/home/privacy/PrivacyWebViewActivity$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/home/privacy/PrivacyWebViewActivity;->Companion Lcom/bytedance/trae/home/privacy/PrivacyWebViewActivity$Companion;
    const/16 v0, 8
    sput v0, Lcom/bytedance/trae/home/privacy/PrivacyWebViewActivity;->$stable I
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;-><init>()V
    return-void 
.end method

.method public static final synthetic access$getWebView$p(com.bytedance.trae.home.privacy.PrivacyWebViewActivity)android.webkit.WebView
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/privacy/PrivacyWebViewActivity;->webView Landroid/webkit/WebView;
    return-object v0
.end method

.method public static com_bytedance_trae_home_privacy_PrivacyWebViewActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(com.bytedance.trae.home.privacy.PrivacyWebViewActivity)void
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/home/privacy/PrivacyWebViewActivity;->com_bytedance_trae_home_privacy_PrivacyWebViewActivity__onStop$___twin___()V
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

.method private static final onCreate$lambda$0(com.bytedance.trae.home.privacy.PrivacyWebViewActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-virtual v0, Lcom/bytedance/trae/home/privacy/PrivacyWebViewActivity;->finish()V
    return-void 
.end method

.method public com_bytedance_trae_home_privacy_PrivacyWebViewActivity__onStop$___twin___()void
    .registers 1
    # ins_size=1
    invoke-super v0, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->onStop()V
    return-void 
.end method

.method protected onCreate(android.os.Bundle)void
    .registers 6
    # ins_size=2
    invoke-super v4, v5, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->onCreate(Landroid/os/Bundle;)V
    sget v5, Lcom/bytedance/trae/home/R$layout;->activity_privacy_webview I
    invoke-virtual v4, v5, Lcom/bytedance/trae/home/privacy/PrivacyWebViewActivity;->setContentView(I)V
    sget v5, Lcom/bytedance/trae/home/R$id;->webview I
    invoke-virtual v4, v5, Lcom/bytedance/trae/home/privacy/PrivacyWebViewActivity;->findViewById(I)Landroid/view/View;
    move-result-object v5
    const-string v0, "findViewById(...)"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v5, Landroid/webkit/WebView;
    iput-object v5, v4, Lcom/bytedance/trae/home/privacy/PrivacyWebViewActivity;->webView Landroid/webkit/WebView;
    sget v5, Lcom/bytedance/trae/home/R$id;->btn_back I
    invoke-virtual v4, v5, Lcom/bytedance/trae/home/privacy/PrivacyWebViewActivity;->findViewById(I)Landroid/view/View;
    move-result-object v5
    check-cast v5, Landroid/widget/ImageView;
    new-instance v0, Lcom/bytedance/trae/home/privacy/PrivacyWebViewActivity$$ExternalSyntheticLambda0;
    invoke-direct v0, v4, Lcom/bytedance/trae/home/privacy/PrivacyWebViewActivity$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/home/privacy/PrivacyWebViewActivity;)V
    invoke-virtual v5, v0, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    invoke-virtual v4, Lcom/bytedance/trae/home/privacy/PrivacyWebViewActivity;->getIntent()Landroid/content/Intent;
    move-result-object v5
    const-string v0, "extra_url"
    invoke-virtual v5, v0, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v5
    if-nez v5, +004h
    const-string v5, ""
    move-object v0, v5
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    const/4 v1, 1
    if-nez v0, +004h
    move v0, v1
    goto +2h
    const/4 v0, 0
    if-eqz v0, +006h
    invoke-virtual v4, Lcom/bytedance/trae/home/privacy/PrivacyWebViewActivity;->finish()V
    return-void 
    iget-object v0, v4, Lcom/bytedance/trae/home/privacy/PrivacyWebViewActivity;->webView Landroid/webkit/WebView;
    const/4 v2, 0
    const-string/jumbo v3, webView
    if-nez v0, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    invoke-virtual v0, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;
    move-result-object v0
    invoke-virtual v0, v1, Landroid/webkit/WebSettings;->setJavaScriptEnabled(Z)V
    iget-object v0, v4, Lcom/bytedance/trae/home/privacy/PrivacyWebViewActivity;->webView Landroid/webkit/WebView;
    if-nez v0, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    invoke-virtual v0, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;
    move-result-object v0
    invoke-virtual v0, v1, Landroid/webkit/WebSettings;->setDomStorageEnabled(Z)V
    iget-object v0, v4, Lcom/bytedance/trae/home/privacy/PrivacyWebViewActivity;->webView Landroid/webkit/WebView;
    if-nez v0, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    new-instance v1, Landroid/webkit/WebViewClient;
    invoke-direct v1, Landroid/webkit/WebViewClient;-><init>()V
    invoke-virtual v0, v1, Landroid/webkit/WebView;->setWebViewClient(Landroid/webkit/WebViewClient;)V
    iget-object v0, v4, Lcom/bytedance/trae/home/privacy/PrivacyWebViewActivity;->webView Landroid/webkit/WebView;
    if-nez v0, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    new-instance v1, Landroid/webkit/WebChromeClient;
    invoke-direct v1, Landroid/webkit/WebChromeClient;-><init>()V
    invoke-virtual v0, v1, Landroid/webkit/WebView;->setWebChromeClient(Landroid/webkit/WebChromeClient;)V
    iget-object v0, v4, Lcom/bytedance/trae/home/privacy/PrivacyWebViewActivity;->webView Landroid/webkit/WebView;
    if-nez v0, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v2, v0
    invoke-virtual v2, v5, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V
    invoke-virtual v4, Lcom/bytedance/trae/home/privacy/PrivacyWebViewActivity;->getOnBackPressedDispatcher()Landroidx/activity/OnBackPressedDispatcher;
    move-result-object v5
    move-object v0, v4
    check-cast v0, Landroidx/lifecycle/LifecycleOwner;
    new-instance v1, Lcom/bytedance/trae/home/privacy/PrivacyWebViewActivity$onCreate$2;
    invoke-direct v1, v4, Lcom/bytedance/trae/home/privacy/PrivacyWebViewActivity$onCreate$2;-><init>(Lcom/bytedance/trae/home/privacy/PrivacyWebViewActivity;)V
    check-cast v1, Landroidx/activity/OnBackPressedCallback;
    invoke-virtual v5, v0, v1, Landroidx/activity/OnBackPressedDispatcher;->addCallback(Landroidx/lifecycle/LifecycleOwner; Landroidx/activity/OnBackPressedCallback;)V
    return-void 
.end method

.method protected onDestroy()void
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/privacy/PrivacyWebViewActivity;->webView Landroid/webkit/WebView;
    if-nez v0, +009h
    const-string/jumbo v0, webView
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    invoke-virtual v0, Landroid/webkit/WebView;->destroy()V
    invoke-super v1, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->onDestroy()V
    return-void 
.end method

.method protected onStop()void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/home/privacy/PrivacyWebViewActivity;->com_bytedance_trae_home_privacy_PrivacyWebViewActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(Lcom/bytedance/trae/home/privacy/PrivacyWebViewActivity;)V
    return-void 
.end method
