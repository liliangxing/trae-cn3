# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/common/activity/SimpleWebViewActivity;
.super Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;
.source "SimpleWebViewActivity.kt"

.field public static final Companion:Lcom/bytedance/trae/common/activity/SimpleWebViewActivity$Companion;
.field private static final EXTRA_SHOW_MORE_MENU:Ljava/lang/String;
.field private static final EXTRA_URL:Ljava/lang/String;
.field private webView:Landroid/webkit/WebView;


.method public static synthetic $r8$lambda$Reh2HHs899CCt41IZnmbdpI1J24(com.bytedance.trae.common.activity.SimpleWebViewActivity  java.lang.String  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/common/activity/SimpleWebViewActivity;->onCreate$lambda$3(Lcom/bytedance/trae/common/activity/SimpleWebViewActivity; Ljava/lang/String; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$ev7gzOD_Jjtbaw4yWrCiN1ZJUAM(com.bytedance.trae.common.activity.SimpleWebViewActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/common/activity/SimpleWebViewActivity;->onCreate$lambda$0(Lcom/bytedance/trae/common/activity/SimpleWebViewActivity; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$px3AAOJji4Z1HL4_4FncIitMkaU(com.bytedance.trae.common.activity.SimpleWebViewActivity  java.lang.String  android.view.MenuItem)boolean
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/common/activity/SimpleWebViewActivity;->onCreate$lambda$3$lambda$2(Lcom/bytedance/trae/common/activity/SimpleWebViewActivity; Ljava/lang/String; Landroid/view/MenuItem;)Z
    move-result v0
    return v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/common/activity/SimpleWebViewActivity$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/common/activity/SimpleWebViewActivity$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/common/activity/SimpleWebViewActivity;->Companion Lcom/bytedance/trae/common/activity/SimpleWebViewActivity$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;-><init>()V
    return-void 
.end method

.method public static final synthetic access$getWebView$p(com.bytedance.trae.common.activity.SimpleWebViewActivity)android.webkit.WebView
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/common/activity/SimpleWebViewActivity;->webView Landroid/webkit/WebView;
    return-object v0
.end method

.method public static com_bytedance_trae_common_activity_SimpleWebViewActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(com.bytedance.trae.common.activity.SimpleWebViewActivity)void
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/common/activity/SimpleWebViewActivity;->com_bytedance_trae_common_activity_SimpleWebViewActivity__onStop$___twin___()V
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

.method private static final onCreate$lambda$0(com.bytedance.trae.common.activity.SimpleWebViewActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-virtual v0, Lcom/bytedance/trae/common/activity/SimpleWebViewActivity;->finish()V
    return-void 
.end method

.method private static final onCreate$lambda$3(com.bytedance.trae.common.activity.SimpleWebViewActivity  java.lang.String  android.view.View)void
    .registers 8
    # ins_size=3
    new-instance v0, Landroid/widget/PopupMenu;
    move-object v1, v5
    check-cast v1, Landroid/content/Context;
    invoke-direct v0, v1, v7, Landroid/widget/PopupMenu;-><init>(Landroid/content/Context; Landroid/view/View;)V
    invoke-virtual v0, Landroid/widget/PopupMenu;->getMenu()Landroid/view/Menu;
    move-result-object v7
    sget v1, Lcom/bytedance/trae/common_ui/R$string;->trae_webview_open_in_browser I
    const/4 v2, 0
    const/4 v3, 1
    invoke-interface v7, v2, v3, v2, v1, Landroid/view/Menu;->add(I I I I)Landroid/view/MenuItem;
    invoke-virtual v0, Landroid/widget/PopupMenu;->getMenu()Landroid/view/Menu;
    move-result-object v7
    const/4 v1, 2
    sget v4, Lcom/bytedance/trae/common_ui/R$string;->trae_webview_share_link I
    invoke-interface v7, v2, v1, v3, v4, Landroid/view/Menu;->add(I I I I)Landroid/view/MenuItem;
    new-instance v7, Lcom/bytedance/trae/common/activity/SimpleWebViewActivity$$ExternalSyntheticLambda0;
    invoke-direct v7, v5, v6, Lcom/bytedance/trae/common/activity/SimpleWebViewActivity$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/common/activity/SimpleWebViewActivity; Ljava/lang/String;)V
    invoke-virtual v0, v7, Landroid/widget/PopupMenu;->setOnMenuItemClickListener(Landroid/widget/PopupMenu$OnMenuItemClickListener;)V
    invoke-virtual v0, Landroid/widget/PopupMenu;->show()V
    return-void 
.end method

.method private static final onCreate$lambda$3$lambda$2(com.bytedance.trae.common.activity.SimpleWebViewActivity  java.lang.String  android.view.MenuItem)boolean
    .registers 6
    # ins_size=3
    iget-object v0, v3, Lcom/bytedance/trae/common/activity/SimpleWebViewActivity;->webView Landroid/webkit/WebView;
    const/4 v1, 0
    if-nez v0, +009h
    const-string/jumbo v0, webView
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, Landroid/webkit/WebView;->getUrl()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +003h
    goto +2h
    move-object v4, v0
    invoke-interface v5, Landroid/view/MenuItem;->getItemId()I
    move-result v5
    const/4 v0, 1
    if-eq v5, v0, +021h
    const/4 v2, 2
    if-eq v5, v2, +004h
    const/4 v0, 0
    goto +29h
    new-instance v5, Landroid/content/Intent;
    const-string v2, "android.intent.action.SEND"
    invoke-direct v5, v2, Landroid/content/Intent;-><init>(Ljava/lang/String;)V
    const-string/jumbo v2, text/plain
    invoke-virtual v5, v2, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;
    const-string v2, "android.intent.extra.TEXT"
    invoke-virtual v5, v2, v4, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    invoke-static v5, v1, Landroid/content/Intent;->createChooser(Landroid/content/Intent; Ljava/lang/CharSequence;)Landroid/content/Intent;
    move-result-object v4
    invoke-virtual v3, v4, Lcom/bytedance/trae/common/activity/SimpleWebViewActivity;->startActivity(Landroid/content/Intent;)V
    goto +fh
    new-instance v5, Landroid/content/Intent;
    const-string v1, "android.intent.action.VIEW"
    invoke-static v4, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v4
    invoke-direct v5, v1, v4, Landroid/content/Intent;-><init>(Ljava/lang/String; Landroid/net/Uri;)V
    invoke-virtual v3, v5, Lcom/bytedance/trae/common/activity/SimpleWebViewActivity;->startActivity(Landroid/content/Intent;)V
    return v0
    :try_start_0x3a
.end method

.method public com_bytedance_trae_common_activity_SimpleWebViewActivity__onStop$___twin___()void
    .registers 1
    # ins_size=1
    invoke-super v0, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->onStop()V
    return-void 
.end method

.method public getDecorViewBackgroundColor()int
    .registers 2
    # ins_size=1
    sget v0, Lcom/bytedance/trae/common_ui/R$color;->trae_bg_bg_base_default I
    invoke-virtual v1, v0, Lcom/bytedance/trae/common/activity/SimpleWebViewActivity;->getColor(I)I
    move-result v0
    return v0
.end method

.method protected onCreate(android.os.Bundle)void
    .registers 9
    # ins_size=2
    invoke-super v7, v8, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->onCreate(Landroid/os/Bundle;)V
    sget v8, Lcom/bytedance/trae/common_ui/R$layout;->trae_activity_simple_webview I
    invoke-virtual v7, v8, Lcom/bytedance/trae/common/activity/SimpleWebViewActivity;->setContentView(I)V
    sget v8, Lcom/bytedance/trae/common_ui/R$id;->webview I
    invoke-virtual v7, v8, Lcom/bytedance/trae/common/activity/SimpleWebViewActivity;->findViewById(I)Landroid/view/View;
    move-result-object v8
    const-string v0, "findViewById(...)"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v8, Landroid/webkit/WebView;
    iput-object v8, v7, Lcom/bytedance/trae/common/activity/SimpleWebViewActivity;->webView Landroid/webkit/WebView;
    const/4 v0, 0
    const-string/jumbo v1, webView
    if-nez v8, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v8, v0
    invoke-virtual v7, Lcom/bytedance/trae/common/activity/SimpleWebViewActivity;->getDecorViewBackgroundColor()I
    move-result v2
    invoke-virtual v8, v2, Landroid/webkit/WebView;->setBackgroundColor(I)V
    sget v8, Lcom/bytedance/trae/common_ui/R$id;->title_bar I
    invoke-virtual v7, v8, Lcom/bytedance/trae/common/activity/SimpleWebViewActivity;->findViewById(I)Landroid/view/View;
    move-result-object v8
    check-cast v8, Lcom/bytedance/trae/common/widget/TraeTitleBar;
    new-instance v2, Lcom/bytedance/trae/common/activity/SimpleWebViewActivity$$ExternalSyntheticLambda1;
    invoke-direct v2, v7, Lcom/bytedance/trae/common/activity/SimpleWebViewActivity$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/common/activity/SimpleWebViewActivity;)V
    invoke-virtual v8, v2, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setOnLeftActionClickListener(Landroid/view/View$OnClickListener;)V
    invoke-virtual v7, Lcom/bytedance/trae/common/activity/SimpleWebViewActivity;->getIntent()Landroid/content/Intent;
    move-result-object v2
    const-string v3, "extra_url"
    invoke-virtual v2, v3, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    if-nez v2, +004h
    const-string v2, ""
    move-object v3, v2
    check-cast v3, Ljava/lang/CharSequence;
    invoke-interface v3, Ljava/lang/CharSequence;->length()I
    move-result v3
    const/4 v4, 0
    const/4 v5, 1
    if-nez v3, +004h
    move v3, v5
    goto +2h
    move v3, v4
    if-eqz v3, +006h
    invoke-virtual v7, Lcom/bytedance/trae/common/activity/SimpleWebViewActivity;->finish()V
    return-void 
    invoke-virtual v7, Lcom/bytedance/trae/common/activity/SimpleWebViewActivity;->getIntent()Landroid/content/Intent;
    move-result-object v3
    const-string v6, "extra_show_more_menu"
    invoke-virtual v3, v6, v4, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String; Z)Z
    move-result v3
    if-eqz v3, +00fh
    sget-object v3, Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;->MORE Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
    invoke-virtual v8, v3, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setRightAction(Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;)V
    new-instance v3, Lcom/bytedance/trae/common/activity/SimpleWebViewActivity$$ExternalSyntheticLambda2;
    invoke-direct v3, v7, v2, Lcom/bytedance/trae/common/activity/SimpleWebViewActivity$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/common/activity/SimpleWebViewActivity; Ljava/lang/String;)V
    invoke-virtual v8, v3, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setOnRightActionClickListener(Landroid/view/View$OnClickListener;)V
    iget-object v8, v7, Lcom/bytedance/trae/common/activity/SimpleWebViewActivity;->webView Landroid/webkit/WebView;
    if-nez v8, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v8, v0
    invoke-virtual v8, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;
    move-result-object v8
    invoke-virtual v8, v5, Landroid/webkit/WebSettings;->setJavaScriptEnabled(Z)V
    iget-object v8, v7, Lcom/bytedance/trae/common/activity/SimpleWebViewActivity;->webView Landroid/webkit/WebView;
    if-nez v8, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v8, v0
    invoke-virtual v8, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;
    move-result-object v8
    invoke-virtual v8, v5, Landroid/webkit/WebSettings;->setDomStorageEnabled(Z)V
    iget-object v8, v7, Lcom/bytedance/trae/common/activity/SimpleWebViewActivity;->webView Landroid/webkit/WebView;
    if-nez v8, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v8, v0
    new-instance v3, Lcom/bytedance/trae/common/activity/SimpleWebViewActivity$onCreate$3;
    invoke-direct v3, v7, Lcom/bytedance/trae/common/activity/SimpleWebViewActivity$onCreate$3;-><init>(Lcom/bytedance/trae/common/activity/SimpleWebViewActivity;)V
    check-cast v3, Landroid/webkit/WebViewClient;
    invoke-virtual v8, v3, Landroid/webkit/WebView;->setWebViewClient(Landroid/webkit/WebViewClient;)V
    iget-object v8, v7, Lcom/bytedance/trae/common/activity/SimpleWebViewActivity;->webView Landroid/webkit/WebView;
    if-nez v8, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v8, v0
    new-instance v3, Landroid/webkit/WebChromeClient;
    invoke-direct v3, Landroid/webkit/WebChromeClient;-><init>()V
    invoke-virtual v8, v3, Landroid/webkit/WebView;->setWebChromeClient(Landroid/webkit/WebChromeClient;)V
    iget-object v8, v7, Lcom/bytedance/trae/common/activity/SimpleWebViewActivity;->webView Landroid/webkit/WebView;
    if-nez v8, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v0, v8
    invoke-virtual v0, v2, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V
    invoke-virtual v7, Lcom/bytedance/trae/common/activity/SimpleWebViewActivity;->getOnBackPressedDispatcher()Landroidx/activity/OnBackPressedDispatcher;
    move-result-object v8
    move-object v0, v7
    check-cast v0, Landroidx/lifecycle/LifecycleOwner;
    new-instance v1, Lcom/bytedance/trae/common/activity/SimpleWebViewActivity$onCreate$4;
    invoke-direct v1, v7, Lcom/bytedance/trae/common/activity/SimpleWebViewActivity$onCreate$4;-><init>(Lcom/bytedance/trae/common/activity/SimpleWebViewActivity;)V
    check-cast v1, Landroidx/activity/OnBackPressedCallback;
    invoke-virtual v8, v0, v1, Landroidx/activity/OnBackPressedDispatcher;->addCallback(Landroidx/lifecycle/LifecycleOwner; Landroidx/activity/OnBackPressedCallback;)V
    return-void 
.end method

.method protected onDestroy()void
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/common/activity/SimpleWebViewActivity;->webView Landroid/webkit/WebView;
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
    invoke-static v0, Lcom/bytedance/trae/common/activity/SimpleWebViewActivity;->com_bytedance_trae_common_activity_SimpleWebViewActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(Lcom/bytedance/trae/common/activity/SimpleWebViewActivity;)V
    return-void 
.end method
