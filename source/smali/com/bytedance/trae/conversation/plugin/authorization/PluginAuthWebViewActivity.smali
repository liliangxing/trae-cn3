# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;
.super Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;
.source "PluginAuthWebViewActivity.kt"

.field private static final CLOUDIDE_SESSION_COOKIE_NAME:Ljava/lang/String;
.field public static final Companion:Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity$Companion;
.field private static final EXTRA_PROVIDER:Ljava/lang/String;
.field private static final EXTRA_URL:Ljava/lang/String;
.field private static final SCHEME_CN:Ljava/lang/String;
.field private static final SCHEME_OVERSEA:Ljava/lang/String;
.field private static final TAG:Ljava/lang/String;
.field private childWebView:Landroid/webkit/WebView;
.field private webView:Landroid/webkit/WebView;
.field private webViewContainer:Landroid/widget/FrameLayout;


.method public static synthetic $r8$lambda$9tSNtflsT-XzygdBr4LisjHCI78(com.bytedance.trae.conversation.plugin.authorization.PluginAuthWebViewActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;->onCreate$lambda$0(Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity; Landroid/view/View;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;->Companion Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;-><init>()V
    return-void 
.end method

.method public static final synthetic access$destroyChildWebView(com.bytedance.trae.conversation.plugin.authorization.PluginAuthWebViewActivity)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;->destroyChildWebView()V
    return-void 
.end method

.method public static final synthetic access$getChildWebView$p(com.bytedance.trae.conversation.plugin.authorization.PluginAuthWebViewActivity)android.webkit.WebView
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;->childWebView Landroid/webkit/WebView;
    return-object v0
.end method

.method public static final synthetic access$getWebView$p(com.bytedance.trae.conversation.plugin.authorization.PluginAuthWebViewActivity)android.webkit.WebView
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;->webView Landroid/webkit/WebView;
    return-object v0
.end method

.method public static final synthetic access$getWebViewContainer$p(com.bytedance.trae.conversation.plugin.authorization.PluginAuthWebViewActivity)android.widget.FrameLayout
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;->webViewContainer Landroid/widget/FrameLayout;
    return-object v0
.end method

.method public static final synthetic access$handleUri(com.bytedance.trae.conversation.plugin.authorization.PluginAuthWebViewActivity  android.net.Uri)boolean
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;->handleUri(Landroid/net/Uri;)Z
    move-result v0
    return v0
.end method

.method public static final synthetic access$handleUserCancel(com.bytedance.trae.conversation.plugin.authorization.PluginAuthWebViewActivity)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;->handleUserCancel()V
    return-void 
.end method

.method public static final synthetic access$injectBytecloudLocalStorage(com.bytedance.trae.conversation.plugin.authorization.PluginAuthWebViewActivity  android.webkit.WebView  java.lang.String)void
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;->injectBytecloudLocalStorage(Landroid/webkit/WebView; Ljava/lang/String;)V
    return-void 
.end method

.method public static final synthetic access$setChildWebView$p(com.bytedance.trae.conversation.plugin.authorization.PluginAuthWebViewActivity  android.webkit.WebView)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;->childWebView Landroid/webkit/WebView;
    return-void 
.end method

.method public static com_bytedance_trae_conversation_plugin_authorization_PluginAuthWebViewActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(com.bytedance.trae.conversation.plugin.authorization.PluginAuthWebViewActivity)void
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;->com_bytedance_trae_conversation_plugin_authorization_PluginAuthWebViewActivity__onStop$___twin___()V
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

.method private final createParentChromeClient()android.webkit.WebChromeClient
    .registers 2
    # ins_size=1
    new-instance v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity$createParentChromeClient$1;
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity$createParentChromeClient$1;-><init>(Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;)V
    check-cast v0, Landroid/webkit/WebChromeClient;
    return-object v0
.end method

.method private final destroyChildWebView()void
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;->childWebView Landroid/webkit/WebView;
    if-nez v0, +003h
    return-void 
    iget-object v1, v3, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;->webViewContainer Landroid/widget/FrameLayout;
    if-eqz v1, +008h
    move-object v2, v0
    check-cast v2, Landroid/view/View;
    invoke-virtual v1, v2, Landroid/widget/FrameLayout;->removeView(Landroid/view/View;)V
    invoke-virtual v0, Landroid/webkit/WebView;->destroy()V
    const/4 v0, 0
    iput-object v0, v3, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;->childWebView Landroid/webkit/WebView;
    return-void 
.end method

.method private final extractJwtExpiration(java.lang.String)java.lang.String
    .registers 8
    # ins_size=2
    move-object v0, v7
    check-cast v0, Ljava/lang/CharSequence;
    const-string v7, "."
    filled-new-array v7, [Ljava/lang/String;
    move-result-object v1
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 6
    const/4 v5, 0
    invoke-static/range v0 ... v5, Lkotlin/text/StringsKt;->split$default(Ljava/lang/CharSequence; [Ljava/lang/String; Z I I Ljava/lang/Object;)Ljava/util/List;
    move-result-object v7
    invoke-interface v7, Ljava/util/List;->size()I
    move-result v0
    const/4 v1, 2
    const/4 v2, 0
    if-ge v0, v1, +003h
    return-object v2
    const/4 v0, 1
    invoke-interface v7, v0, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Ljava/lang/String;
    const/16 v0, 11
    invoke-static v7, v0, Landroid/util/Base64;->decode(Ljava/lang/String; I)[B
    move-result-object v7
    new-instance v0, Lorg/json/JSONObject;
    new-instance v1, Ljava/lang/String;
    invoke-static v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    sget-object v3, Lkotlin/text/Charsets;->UTF_8 Ljava/nio/charset/Charset;
    invoke-direct v1, v7, v3, Ljava/lang/String;-><init>([B Ljava/nio/charset/Charset;)V
    invoke-direct v0, v1, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V
    const-string v7, "exp"
    const-wide/16 v3, 0
    invoke-virtual v0, v7, v3, v4, Lorg/json/JSONObject;->optLong(Ljava/lang/String; J)J
    move-result-wide v0
    cmp-long v7, v0, v3
    if-nez v7, +003h
    return-object v2
    new-instance v7, Ljava/text/SimpleDateFormat;
    const-string/jumbo v3, yyyy-MM-dd'T'HH:mm:ssXXX
    sget-object v4, Ljava/util/Locale;->US Ljava/util/Locale;
    invoke-direct v7, v3, v4, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String; Ljava/util/Locale;)V
    const-string v3, "Asia/Shanghai"
    invoke-static v3, Ljava/util/TimeZone;->getTimeZone(Ljava/lang/String;)Ljava/util/TimeZone;
    move-result-object v3
    invoke-virtual v7, v3, Ljava/text/SimpleDateFormat;->setTimeZone(Ljava/util/TimeZone;)V
    new-instance v3, Ljava/util/Date;
    const/16 v4, 1000
    int-to-long v4, v4
    mul-long/2addr v0, v4
    invoke-direct v3, v0, v1, Ljava/util/Date;-><init>(J)V
    invoke-virtual v7, v3, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;
    move-result-object v2
    goto +dh
    move-exception v7
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v1, "failed to parse JWT exp"
    check-cast v7, Ljava/lang/Throwable;
    const-string v3, "PluginAuthWebView"
    invoke-virtual v0, v3, v1, v7, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    return-object v2
    :try_start_0x1b
.end method

.method private final handleUri(android.net.Uri)boolean
    .registers 8
    # ins_size=2
    invoke-virtual v7, Landroid/net/Uri;->getScheme()Ljava/lang/String;
    move-result-object v0
    const/4 v1, 0
    if-nez v0, +003h
    return v1
    const-string/jumbo v2, traecn
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    const/4 v3, 1
    if-nez v2, +00bh
    const-string/jumbo v2, traei18n
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +05ch
    invoke-virtual v7, Landroid/net/Uri;->getHost()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v7, Landroid/net/Uri;->getPath()Ljava/lang/String;
    move-result-object v4
    const-string v5, "oauth"
    invoke-static v2, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +04ch
    const-string v2, "/lark/callback"
    invoke-static v4, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +00ah
    const-string v2, "/plugin-connector/callback"
    invoke-static v4, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +03ch
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "OAuth callback received: "
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    const-string v2, "PluginAuthWebView"
    invoke-virtual v0, v2, v1, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    invoke-direct v6, v7, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;->parseOAuthResultStatus(Landroid/net/Uri;)Ljava/lang/String;
    move-result-object v0
    invoke-virtual v6, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;->getIntent()Landroid/content/Intent;
    move-result-object v1
    const-string v2, "extra_provider"
    invoke-virtual v1, v2, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    if-nez v1, +004h
    const-string v1, ""
    const-string v2, "auth_request_id"
    invoke-virtual v7, v2, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v7
    sget-object v2, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->INSTANCE Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;
    invoke-virtual v2, v1, v0, v7, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->reportWebViewAuthResult(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)Z
    move-result v7
    if-eqz v7, +005h
    invoke-virtual v6, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;->finish()V
    return v3
    const-string v2, "http"
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +015h
    const-string v2, "https"
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +00dh
    new-instance v0, Landroid/content/Intent;
    const-string v1, "android.intent.action.VIEW"
    invoke-direct v0, v1, v7, Landroid/content/Intent;-><init>(Ljava/lang/String; Landroid/net/Uri;)V
    invoke-virtual v6, v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;->startActivity(Landroid/content/Intent;)V
    return v3
    return v1
    :try_start_0x85
.end method

.method private final handleUserCancel()void
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->INSTANCE Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->cancelWebViewAuth()V
    invoke-virtual v1, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;->finish()V
    return-void 
.end method

.method private final injectBytecloudLocalStorage(android.webkit.WebView  java.lang.String)void
    .registers 9
    # ins_size=3
    sget-object v0, Lcom/bytedance/trae/network/HostResolver;->INSTANCE Lcom/bytedance/trae/network/HostResolver;
    invoke-virtual v0, Lcom/bytedance/trae/network/HostResolver;->isBytecloudLogin()Z
    move-result v0
    if-nez v0, +003h
    return-void 
    const-class v0, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v0
    const-class v1, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v0, v1, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/login/api/ILoginService;
    const/4 v1, 0
    if-eqz v0, +007h
    invoke-interface v0, Lcom/bytedance/trae/login/api/ILoginService;->getXTToken()Ljava/lang/String;
    move-result-object v0
    goto +2h
    move-object v0, v1
    if-nez v0, +004h
    const-string v0, ""
    move-object v2, v0
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v2, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    if-eqz v2, +003h
    return-void 
    invoke-direct v6, v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;->extractJwtExpiration(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    if-nez v2, +003h
    return-void 
    invoke-static v8, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v8
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-direct v3, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v8, Landroid/net/Uri;->getScheme()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v4, "://"
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v8, Landroid/net/Uri;->getHost()Ljava/lang/String;
    move-result-object v8
    invoke-virtual v3, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v8
    invoke-static v0, Lorg/json/JSONObject;->quote(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    invoke-static v2, Lorg/json/JSONObject;->quote(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    invoke-static v8, Lorg/json/JSONObject;->quote(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v5, "
            (function() {
                if (window.location.origin === "
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v4, ") {
                    window.localStorage.setItem("bytecloud_ide_token", "
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v3, ");
                    window.localStorage.setItem("bytecloud_ide_token_expired_at", "
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v2, ");
                }
            })();
        "
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lkotlin/text/StringsKt;->trimIndent(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    if-eqz v7, +005h
    invoke-virtual v7, v0, v1, Landroid/webkit/WebView;->evaluateJavascript(Ljava/lang/String; Landroid/webkit/ValueCallback;)V
    sget-object v7, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "injected bytecloud localStorage for "
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v8
    const-string v0, "PluginAuthWebView"
    invoke-virtual v7, v0, v8, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method private final injectCookies(java.lang.String)void
    .registers 14
    # ins_size=2
    invoke-static v13, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v13
    invoke-virtual v13, Landroid/net/Uri;->getHost()Ljava/lang/String;
    move-result-object v13
    if-nez v13, +003h
    return-void 
    sget-object v0, Lcom/bytedance/trae/network/HostResolver;->INSTANCE Lcom/bytedance/trae/network/HostResolver;
    sget-object v1, Lcom/bytedance/trae/network/HostType;->PLUGIN_WEB Lcom/bytedance/trae/network/HostType;
    invoke-virtual v0, v1, Lcom/bytedance/trae/network/HostResolver;->getHost(Lcom/bytedance/trae/network/HostType;)Ljava/lang/String;
    move-result-object v0
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    const-string v2, "PluginAuthWebView"
    if-nez v1, +022h
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string/jumbo v4, skip cookie injection: host 
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v13
    const-string v3, " != expected "
    invoke-virtual v13, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v13
    invoke-virtual v13, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v13
    invoke-virtual v13, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v13
    invoke-virtual v1, v2, v13, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    move-object v3, v13
    check-cast v3, Ljava/lang/CharSequence;
    const-string v0, "."
    filled-new-array v0, [Ljava/lang/String;
    move-result-object v4
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 6
    const/4 v8, 0
    invoke-static/range v3 ... v8, Lkotlin/text/StringsKt;->split$default(Ljava/lang/CharSequence; [Ljava/lang/String; Z I I Ljava/lang/Object;)Ljava/util/List;
    move-result-object v1
    const/4 v3, 2
    invoke-static v1, v3, Lkotlin/collections/CollectionsKt;->takeLast(Ljava/util/List; I)Ljava/util/List;
    move-result-object v1
    move-object v3, v1
    check-cast v3, Ljava/lang/Iterable;
    move-object v4, v0
    check-cast v4, Ljava/lang/CharSequence;
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v9, 0
    const/16 v10, 62
    const/4 v11, 0
    invoke-static/range v3 ... v11, Lkotlin/collections/CollectionsKt;->joinToString$default(Ljava/lang/Iterable; Ljava/lang/CharSequence; Ljava/lang/CharSequence; Ljava/lang/CharSequence; I Ljava/lang/CharSequence; Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v0
    invoke-static Landroid/webkit/CookieManager;->getInstance()Landroid/webkit/CookieManager;
    move-result-object v1
    const/4 v3, 1
    invoke-virtual v1, v3, Landroid/webkit/CookieManager;->setAcceptCookie(Z)V
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v5, "https://"
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    new-instance v6, Ljava/lang/StringBuilder;
    const-string v7, "X-Cloudide-Session=; path=/; Max-Age=0; Expires=Thu, 01 Jan 1970 00:00:00 GMT; domain=."
    invoke-direct v6, v7, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v6, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v1, v4, v6, Landroid/webkit/CookieManager;->setCookie(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v4, Ljava/lang/StringBuilder;
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    const-string v6, "X-Cloudide-Session=; path=/; Max-Age=0; Expires=Thu, 01 Jan 1970 00:00:00 GMT"
    invoke-virtual v1, v4, v6, Landroid/webkit/CookieManager;->setCookie(Ljava/lang/String; Ljava/lang/String;)V
    const-class v4, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v4
    const-class v6, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v4, v6, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/login/api/ILoginService;
    if-eqz v4, +007h
    invoke-interface v4, Lcom/bytedance/trae/login/api/ILoginService;->getCloudideSession()Ljava/lang/String;
    move-result-object v4
    goto +2h
    const/4 v4, 0
    if-nez v4, +004h
    const-string v4, ""
    move-object v6, v4
    check-cast v6, Ljava/lang/CharSequence;
    invoke-interface v6, Ljava/lang/CharSequence;->length()I
    move-result v6
    if-nez v6, +003h
    goto +2h
    const/4 v3, 0
    if-eqz v3, +00dh
    sget-object v13, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v0, "cloudideSession is empty, skip cookie injection"
    invoke-virtual v13, v2, v0, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v1, Landroid/webkit/CookieManager;->flush()V
    return-void 
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v6, "X-Cloudide-Session="
    invoke-direct v3, v6, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v4, "; domain=."
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v4, "; path=/; Secure; HttpOnly; SameSite=Lax"
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    new-instance v4, Ljava/lang/StringBuilder;
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v1, v0, v3, Landroid/webkit/CookieManager;->setCookie(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v1, v0, v3, Landroid/webkit/CookieManager;->setCookie(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v1, Landroid/webkit/CookieManager;->flush()V
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v3, "injected cloudideSession cookie for "
    invoke-direct v1, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v13
    invoke-virtual v13, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v13
    invoke-virtual v0, v2, v13, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method private static final onCreate$lambda$0(com.bytedance.trae.conversation.plugin.authorization.PluginAuthWebViewActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;->handleUserCancel()V
    return-void 
.end method

.method private final parseOAuthResultStatus(android.net.Uri)java.lang.String
    .registers 18
    # ins_size=2
    const-string v0, "oauth_result"
    move-object/from16 v1, v17
    invoke-virtual v1, v0, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    const/4 v2, 0
    const/4 v3, 2
    if-nez v0, +04ah
    invoke-virtual/range v17, Landroid/net/Uri;->getFragment()Ljava/lang/String;
    move-result-object v0
    const/4 v1, 0
    if-eqz v0, +041h
    move-object v4, v0
    check-cast v4, Ljava/lang/CharSequence;
    const-string v0, "&"
    filled-new-array v0, [Ljava/lang/String;
    move-result-object v5
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 6
    const/4 v9, 0
    invoke-static/range v4 ... v9, Lkotlin/text/StringsKt;->split$default(Ljava/lang/CharSequence; [Ljava/lang/String; Z I I Ljava/lang/Object;)Ljava/util/List;
    move-result-object v0
    if-eqz v0, +02eh
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    const-string v5, "oauth_result="
    if-eqz v4, +010h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    move-object v6, v4
    check-cast v6, Ljava/lang/String;
    invoke-static v6, v5, v2, v3, v1, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v6
    if-eqz v6, -013h
    goto +2h
    move-object v4, v1
    check-cast v4, Ljava/lang/String;
    if-eqz v4, +00dh
    invoke-static v4, v5, v1, v3, v1, Lkotlin/text/StringsKt;->substringAfter$default(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v0
    if-eqz v0, +007h
    invoke-static v0, Landroid/net/Uri;->decode(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    goto +3h
    move-object v4, v1
    goto +2h
    move-object v4, v0
    move-object v0, v4
    check-cast v0, Ljava/lang/CharSequence;
    if-eqz v0, +008h
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    if-eqz v0, +003h
    const/4 v2, 1
    const-string/jumbo v1, success
    if-eqz v2, +003h
    return-object v1
    const/16 v5, 45
    const/16 v6, 43
    const/4 v7, 0
    const/4 v8, 4
    const/4 v9, 0
    invoke-static/range v4 ... v9, Lkotlin/text/StringsKt;->replace$default(Ljava/lang/String; C C Z I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v10
    const/16 v11, 95
    const/16 v12, 47
    const/4 v13, 0
    const/4 v14, 4
    const/4 v15, 0
    invoke-static/range v10 ... v15, Lkotlin/text/StringsKt;->replace$default(Ljava/lang/String; C C Z I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v0
    invoke-static v0, v3, Landroid/util/Base64;->decode(Ljava/lang/String; I)[B
    move-result-object v0
    new-instance v2, Lorg/json/JSONObject;
    new-instance v3, Ljava/lang/String;
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    sget-object v4, Lkotlin/text/Charsets;->UTF_8 Ljava/nio/charset/Charset;
    invoke-direct v3, v0, v4, Ljava/lang/String;-><init>([B Ljava/nio/charset/Charset;)V
    invoke-direct v2, v3, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V
    const-string/jumbo v0, status
    invoke-virtual v2, v0, v1, Lorg/json/JSONObject;->optString(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    move-object v2, v0
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v2, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    if-eqz v2, +003h
    goto +fh
    move-object v1, v0
    goto +dh
    move-exception v0
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v3, "failed to parse oauth_result"
    check-cast v0, Ljava/lang/Throwable;
    const-string v4, "PluginAuthWebView"
    invoke-virtual v2, v4, v3, v0, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    return-object v1
    :try_start_0x6e
.end method

.method private final setupWebView(java.lang.String)void
    .registers 7
    # ins_size=2
    invoke-static Landroid/webkit/CookieManager;->getInstance()Landroid/webkit/CookieManager;
    move-result-object v0
    iget-object v1, v5, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;->webView Landroid/webkit/WebView;
    const/4 v2, 0
    const-string/jumbo v3, webView
    if-nez v1, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v2
    const/4 v4, 1
    invoke-virtual v0, v1, v4, Landroid/webkit/CookieManager;->setAcceptThirdPartyCookies(Landroid/webkit/WebView; Z)V
    iget-object v0, v5, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;->webView Landroid/webkit/WebView;
    if-nez v0, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    invoke-virtual v0, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;
    move-result-object v0
    invoke-virtual v0, v4, Landroid/webkit/WebSettings;->setJavaScriptEnabled(Z)V
    invoke-virtual v0, v4, Landroid/webkit/WebSettings;->setDomStorageEnabled(Z)V
    invoke-virtual v0, v4, Landroid/webkit/WebSettings;->setSupportMultipleWindows(Z)V
    invoke-virtual v0, v4, Landroid/webkit/WebSettings;->setJavaScriptCanOpenWindowsAutomatically(Z)V
    iget-object v0, v5, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;->webView Landroid/webkit/WebView;
    if-nez v0, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    new-instance v1, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity$setupWebView$2;
    invoke-direct v1, v5, v6, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity$setupWebView$2;-><init>(Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity; Ljava/lang/String;)V
    check-cast v1, Landroid/webkit/WebViewClient;
    invoke-virtual v0, v1, Landroid/webkit/WebView;->setWebViewClient(Landroid/webkit/WebViewClient;)V
    iget-object v6, v5, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;->webView Landroid/webkit/WebView;
    if-nez v6, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v2, v6
    invoke-direct v5, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;->createParentChromeClient()Landroid/webkit/WebChromeClient;
    move-result-object v6
    invoke-virtual v2, v6, Landroid/webkit/WebView;->setWebChromeClient(Landroid/webkit/WebChromeClient;)V
    return-void 
.end method

.method public com_bytedance_trae_conversation_plugin_authorization_PluginAuthWebViewActivity__onStop$___twin___()void
    .registers 1
    # ins_size=1
    invoke-super v0, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->onStop()V
    return-void 
.end method

.method public getDecorViewBackgroundColor()int
    .registers 2
    # ins_size=1
    sget v0, Lcom/bytedance/trae/common_ui/R$color;->trae_bg_bg_base_default I
    invoke-virtual v1, v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;->getColor(I)I
    move-result v0
    return v0
.end method

.method protected onCreate(android.os.Bundle)void
    .registers 9
    # ins_size=2
    invoke-super v7, v8, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->onCreate(Landroid/os/Bundle;)V
    sget v8, Lcom/bytedance/trae/common_ui/R$layout;->trae_activity_simple_webview I
    invoke-virtual v7, v8, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;->setContentView(I)V
    sget v8, Lcom/bytedance/trae/common_ui/R$id;->webview I
    invoke-virtual v7, v8, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;->findViewById(I)Landroid/view/View;
    move-result-object v8
    const-string v0, "findViewById(...)"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v8, Landroid/webkit/WebView;
    iput-object v8, v7, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;->webView Landroid/webkit/WebView;
    const-string/jumbo v0, webView
    const/4 v1, 0
    if-nez v8, +006h
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v8, v1
    invoke-virtual v7, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;->getDecorViewBackgroundColor()I
    move-result v2
    invoke-virtual v8, v2, Landroid/webkit/WebView;->setBackgroundColor(I)V
    iget-object v8, v7, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;->webView Landroid/webkit/WebView;
    if-nez v8, +006h
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v8, v1
    invoke-virtual v8, Landroid/webkit/WebView;->getParent()Landroid/view/ViewParent;
    move-result-object v8
    instance-of v2, v8, Landroid/view/ViewGroup;
    if-eqz v2, +005h
    check-cast v8, Landroid/view/ViewGroup;
    goto +2h
    move-object v8, v1
    if-eqz v8, +051h
    iget-object v2, v7, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;->webView Landroid/webkit/WebView;
    if-nez v2, +006h
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v2, v1
    check-cast v2, Landroid/view/View;
    invoke-virtual v8, v2, Landroid/view/ViewGroup;->indexOfChild(Landroid/view/View;)I
    move-result v2
    iget-object v3, v7, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;->webView Landroid/webkit/WebView;
    if-nez v3, +006h
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v3, v1
    invoke-virtual v3, Landroid/webkit/WebView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    move-result-object v3
    iget-object v4, v7, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;->webView Landroid/webkit/WebView;
    if-nez v4, +006h
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v4, v1
    check-cast v4, Landroid/view/View;
    invoke-virtual v8, v4, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V
    new-instance v4, Landroid/widget/FrameLayout;
    move-object v5, v7
    check-cast v5, Landroid/content/Context;
    invoke-direct v4, v5, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;)V
    invoke-virtual v4, v3, Landroid/widget/FrameLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    iget-object v3, v7, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;->webView Landroid/webkit/WebView;
    if-nez v3, +006h
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v3, v1
    check-cast v3, Landroid/view/View;
    new-instance v5, Landroid/widget/FrameLayout$LayoutParams;
    const/4 v6, -1
    invoke-direct v5, v6, v6, Landroid/widget/FrameLayout$LayoutParams;-><init>(I I)V
    check-cast v5, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v4, v3, v5, Landroid/widget/FrameLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    move-object v3, v4
    check-cast v3, Landroid/view/View;
    invoke-virtual v8, v3, v2, Landroid/view/ViewGroup;->addView(Landroid/view/View; I)V
    iput-object v4, v7, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;->webViewContainer Landroid/widget/FrameLayout;
    sget v8, Lcom/bytedance/trae/common_ui/R$id;->title_bar I
    invoke-virtual v7, v8, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;->findViewById(I)Landroid/view/View;
    move-result-object v8
    check-cast v8, Lcom/bytedance/trae/common/widget/TraeTitleBar;
    new-instance v2, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity$$ExternalSyntheticLambda0;
    invoke-direct v2, v7, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;)V
    invoke-virtual v8, v2, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setOnLeftActionClickListener(Landroid/view/View$OnClickListener;)V
    invoke-virtual v7, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;->getIntent()Landroid/content/Intent;
    move-result-object v8
    const-string v2, "extra_url"
    invoke-virtual v8, v2, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v8
    if-nez v8, +004h
    const-string v8, ""
    move-object v2, v8
    check-cast v2, Ljava/lang/CharSequence;
    invoke-interface v2, Ljava/lang/CharSequence;->length()I
    move-result v2
    if-nez v2, +004h
    const/4 v2, 1
    goto +2h
    const/4 v2, 0
    if-eqz v2, +006h
    invoke-virtual v7, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;->finish()V
    return-void 
    invoke-direct v7, v8, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;->injectCookies(Ljava/lang/String;)V
    invoke-direct v7, v8, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;->setupWebView(Ljava/lang/String;)V
    iget-object v2, v7, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;->webView Landroid/webkit/WebView;
    if-nez v2, +006h
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v2
    invoke-virtual v1, v8, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V
    invoke-virtual v7, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;->getOnBackPressedDispatcher()Landroidx/activity/OnBackPressedDispatcher;
    move-result-object v8
    move-object v0, v7
    check-cast v0, Landroidx/lifecycle/LifecycleOwner;
    new-instance v1, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity$onCreate$2;
    invoke-direct v1, v7, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity$onCreate$2;-><init>(Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;)V
    check-cast v1, Landroidx/activity/OnBackPressedCallback;
    invoke-virtual v8, v0, v1, Landroidx/activity/OnBackPressedDispatcher;->addCallback(Landroidx/lifecycle/LifecycleOwner; Landroidx/activity/OnBackPressedCallback;)V
    return-void 
.end method

.method protected onDestroy()void
    .registers 5
    # ins_size=1
    invoke-direct v4, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;->destroyChildWebView()V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;->webViewContainer Landroid/widget/FrameLayout;
    const/4 v1, 0
    const-string/jumbo v2, webView
    if-eqz v0, +00fh
    iget-object v3, v4, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;->webView Landroid/webkit/WebView;
    if-nez v3, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v3, v1
    check-cast v3, Landroid/view/View;
    invoke-virtual v0, v3, Landroid/widget/FrameLayout;->removeView(Landroid/view/View;)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;->webView Landroid/webkit/WebView;
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v0
    invoke-virtual v1, Landroid/webkit/WebView;->destroy()V
    invoke-super v4, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->onDestroy()V
    return-void 
.end method

.method protected onStop()void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;->com_bytedance_trae_conversation_plugin_authorization_PluginAuthWebViewActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;)V
    return-void 
.end method
