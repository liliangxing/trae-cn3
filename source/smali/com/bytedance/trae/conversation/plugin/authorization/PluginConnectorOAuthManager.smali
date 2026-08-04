# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;
.super Ljava/lang/Object;
.source "PluginConnectorOAuthManager.kt"

.field private static final CUSTOM_AUTH_POLLING_PROVIDERS:Ljava/util/Set;
.field private static final CUSTOM_AUTH_POLL_INTERVAL_MS:J
.field private static final DESKTOP_POLL_INTERVAL_MS:J
.field private static final DESKTOP_REDIRECT_PROVIDERS:Ljava/util/Set;
.field public static final INSTANCE:Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;
.field private static final OAUTH_HOST:Ljava/lang/String;
.field private static final OAUTH_PATH:Ljava/lang/String;
.field private static final POLL_CONSECUTIVE_ERROR_THRESHOLD:I
.field private static final POLL_INTERVAL_MS:J
.field private static final POLL_TIMEOUT_MS:J
.field private static final QRCODE_PROVIDERS:Ljava/util/Set;
.field private static final SCHEME_CN:Ljava/lang/String;
.field private static final SCHEME_OVERSEA:Ljava/lang/String;
.field private static final WEBVIEW_PROVIDERS:Ljava/util/Set;
.field private static activeJob:Lkotlinx/coroutines/Job;
.field private static authStartTimeMs:J
.field private static final lock:Ljava/lang/Object;
.field private static final mainHandler:Landroid/os/Handler;
.field private static pendingAuthRequestId:Ljava/lang/String;
.field private static pendingCompletion:Lkotlin/jvm/functions/Function1;
.field private static bridge pendingProvider:Ljava/lang/String;
.field private static final scope:Lkotlinx/coroutines/CoroutineScope;


.method public static synthetic $r8$lambda$2ME_LmEqJmzkaXc4hscRAptjVRU(kotlin.jvm.internal.Ref$ObjectRef  java.lang.String)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->handleCallback$lambda$19(Lkotlin/jvm/internal/Ref$ObjectRef; Ljava/lang/String;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$c9m_T6kIn32RgNYcnqn2HMgtccU(kotlin.jvm.internal.Ref$ObjectRef  java.lang.String)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->reportWebViewAuthResult$lambda$13(Lkotlin/jvm/internal/Ref$ObjectRef; Ljava/lang/String;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;
    invoke-direct v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->INSTANCE Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;
    const-string/jumbo v0, wecom
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf(Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->QRCODE_PROVIDERS Ljava/util/Set;
    const-string v0, "dingtalk"
    const-string/jumbo v1, tencent-docs
    filled-new-array v0, v1, [Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf([Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->DESKTOP_REDIRECT_PROVIDERS Ljava/util/Set;
    const-string v0, "kdocs"
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf(Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->CUSTOM_AUTH_POLLING_PROVIDERS Ljava/util/Set;
    const-string v0, "lark"
    const-string v1, "feishu"
    filled-new-array v0, v1, [Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf([Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->WEBVIEW_PROVIDERS Ljava/util/Set;
    new-instance v0, Ljava/lang/Object;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->lock Ljava/lang/Object;
    const/4 v0, 0
    const/4 v1, 1
    invoke-static v0, v1, v0, Lkotlinx/coroutines/SupervisorKt;->SupervisorJob$default(Lkotlinx/coroutines/Job; I Ljava/lang/Object;)Lkotlinx/coroutines/CompletableJob;
    move-result-object v0
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v1
    check-cast v1, Lkotlin/coroutines/CoroutineContext;
    invoke-interface v0, v1, Lkotlinx/coroutines/CompletableJob;->plus(Lkotlin/coroutines/CoroutineContext;)Lkotlin/coroutines/CoroutineContext;
    move-result-object v0
    invoke-static v0, Lkotlinx/coroutines/CoroutineScopeKt;->CoroutineScope(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->scope Lkotlinx/coroutines/CoroutineScope;
    new-instance v0, Landroid/os/Handler;
    invoke-static Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;
    move-result-object v1
    invoke-direct v0, v1, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V
    sput-object v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->mainHandler Landroid/os/Handler;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static final synthetic access$clearPendingAndGetCompletion(com.bytedance.trae.conversation.plugin.authorization.PluginConnectorOAuthManager)kotlin.jvm.functions.Function1
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->clearPendingAndGetCompletion()Lkotlin/jvm/functions/Function1;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$getLock$p()java.lang.Object
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->lock Ljava/lang/Object;
    return-object v0
.end method

.method public static final synthetic access$getPendingProvider$p()java.lang.String
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->pendingProvider Ljava/lang/String;
    return-object v0
.end method

.method public static final synthetic access$pollCustomAuth(com.bytedance.trae.conversation.plugin.authorization.PluginConnectorOAuthManager  com.bytedance.trae.conversation.plugin.authorization.IConnectorOAuthApi  java.lang.String  java.lang.String  kotlin.jvm.functions.Function1  kotlin.coroutines.Continuation)java.lang.Object
    .registers 6
    # ins_size=6
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->pollCustomAuth(Lcom/bytedance/trae/conversation/plugin/authorization/IConnectorOAuthApi; Ljava/lang/String; Ljava/lang/String; Lkotlin/jvm/functions/Function1; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$pollListConnectorConnections(com.bytedance.trae.conversation.plugin.authorization.PluginConnectorOAuthManager  com.bytedance.trae.conversation.plugin.authorization.IConnectorOAuthApi  java.lang.String  kotlin.jvm.functions.Function1  kotlin.coroutines.Continuation)java.lang.Object
    .registers 5
    # ins_size=5
    invoke-direct v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->pollListConnectorConnections(Lcom/bytedance/trae/conversation/plugin/authorization/IConnectorOAuthApi; Ljava/lang/String; Lkotlin/jvm/functions/Function1; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$setPendingProvider$p(java.lang.String)void
    .registers 1
    # ins_size=1
    sput-object v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->pendingProvider Ljava/lang/String;
    return-void 
.end method

.method public static final synthetic access$startPolling(com.bytedance.trae.conversation.plugin.authorization.PluginConnectorOAuthManager  com.bytedance.trae.conversation.plugin.authorization.IConnectorOAuthApi  java.lang.String  java.lang.String  kotlin.jvm.functions.Function1  kotlin.coroutines.Continuation)java.lang.Object
    .registers 6
    # ins_size=6
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->startPolling(Lcom/bytedance/trae/conversation/plugin/authorization/IConnectorOAuthApi; Ljava/lang/String; Ljava/lang/String; Lkotlin/jvm/functions/Function1; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method private final buildLarkCallbackUrl(java.lang.String)java.lang.String
    .registers 4
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isOversea()Z
    move-result v0
    if-eqz v0, +006h
    const-string/jumbo v0, traei18n
    goto +4h
    const-string/jumbo v0, traecn
    new-instance v1, Landroid/net/Uri$Builder;
    invoke-direct v1, Landroid/net/Uri$Builder;-><init>()V
    invoke-virtual v1, v0, Landroid/net/Uri$Builder;->scheme(Ljava/lang/String;)Landroid/net/Uri$Builder;
    move-result-object v0
    const-string v1, "oauth"
    invoke-virtual v0, v1, Landroid/net/Uri$Builder;->authority(Ljava/lang/String;)Landroid/net/Uri$Builder;
    move-result-object v0
    const-string v1, "/lark/callback"
    invoke-virtual v0, v1, Landroid/net/Uri$Builder;->path(Ljava/lang/String;)Landroid/net/Uri$Builder;
    move-result-object v0
    const-string v1, "auth_request_id"
    invoke-virtual v0, v1, v3, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String; Ljava/lang/String;)Landroid/net/Uri$Builder;
    move-result-object v3
    invoke-virtual v3, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;
    move-result-object v3
    invoke-virtual v3, Landroid/net/Uri;->toString()Ljava/lang/String;
    move-result-object v3
    const-string/jumbo v0, toString(...)
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v3
.end method

.method private final buildMiddlePageUrl(java.lang.String  java.lang.String)java.lang.String
    .registers 6
    # ins_size=3
    sget-object v0, Lcom/bytedance/trae/network/HostResolver;->INSTANCE Lcom/bytedance/trae/network/HostResolver;
    sget-object v1, Lcom/bytedance/trae/network/HostType;->PLUGIN_WEB Lcom/bytedance/trae/network/HostType;
    invoke-virtual v0, v1, Lcom/bytedance/trae/network/HostResolver;->getHost(Lcom/bytedance/trae/network/HostType;)Ljava/lang/String;
    move-result-object v0
    const-string v1, "lark"
    invoke-static v4, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +005h
    const-string v4, "lark-oauth"
    goto +3h
    const-string v4, "feishu-oauth"
    invoke-direct v3, v5, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->buildLarkCallbackUrl(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v5
    new-instance v1, Landroid/net/Uri$Builder;
    invoke-direct v1, Landroid/net/Uri$Builder;-><init>()V
    const-string v2, "https"
    invoke-virtual v1, v2, Landroid/net/Uri$Builder;->scheme(Ljava/lang/String;)Landroid/net/Uri$Builder;
    move-result-object v1
    invoke-virtual v1, v0, Landroid/net/Uri$Builder;->authority(Ljava/lang/String;)Landroid/net/Uri$Builder;
    move-result-object v0
    invoke-virtual v0, v4, Landroid/net/Uri$Builder;->path(Ljava/lang/String;)Landroid/net/Uri$Builder;
    move-result-object v4
    const-string/jumbo v0, trae_client
    const-string v1, "mobile"
    invoke-virtual v4, v0, v1, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String; Ljava/lang/String;)Landroid/net/Uri$Builder;
    move-result-object v4
    const-string v0, "redirect_url"
    invoke-virtual v4, v0, v5, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String; Ljava/lang/String;)Landroid/net/Uri$Builder;
    move-result-object v4
    const-string v5, "auth_scope_mode"
    const-string v0, "all"
    invoke-virtual v4, v5, v0, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String; Ljava/lang/String;)Landroid/net/Uri$Builder;
    move-result-object v4
    invoke-virtual v4, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;
    move-result-object v4
    invoke-virtual v4, Landroid/net/Uri;->toString()Ljava/lang/String;
    move-result-object v4
    const-string/jumbo v5, toString(...)
    invoke-static v4, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v4
.end method

.method private final buildMobileCallbackUrl(java.lang.String  java.lang.String)java.lang.String
    .registers 5
    # ins_size=3
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isOversea()Z
    move-result v0
    if-eqz v0, +006h
    const-string/jumbo v0, traei18n
    goto +4h
    const-string/jumbo v0, traecn
    new-instance v1, Landroid/net/Uri$Builder;
    invoke-direct v1, Landroid/net/Uri$Builder;-><init>()V
    invoke-virtual v1, v0, Landroid/net/Uri$Builder;->scheme(Ljava/lang/String;)Landroid/net/Uri$Builder;
    move-result-object v0
    const-string v1, "oauth"
    invoke-virtual v0, v1, Landroid/net/Uri$Builder;->authority(Ljava/lang/String;)Landroid/net/Uri$Builder;
    move-result-object v0
    const-string v1, "/plugin-connector/callback"
    invoke-virtual v0, v1, Landroid/net/Uri$Builder;->path(Ljava/lang/String;)Landroid/net/Uri$Builder;
    move-result-object v0
    const-string v1, "auth_request_id"
    invoke-virtual v0, v1, v3, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String; Ljava/lang/String;)Landroid/net/Uri$Builder;
    move-result-object v3
    const-string v0, "provider"
    invoke-virtual v3, v0, v4, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String; Ljava/lang/String;)Landroid/net/Uri$Builder;
    move-result-object v3
    invoke-virtual v3, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;
    move-result-object v3
    invoke-virtual v3, Landroid/net/Uri;->toString()Ljava/lang/String;
    move-result-object v3
    const-string/jumbo v4, toString(...)
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v3
.end method

.method private final clearPendingAndGetCompletion()kotlin.jvm.functions.Function1
    .registers 6
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->lock Ljava/lang/Object;
    monitor-enter v0
    sget-object v1, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->pendingCompletion Lkotlin/jvm/functions/Function1;
    const/4 v2, 0
    sput-object v2, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->pendingCompletion Lkotlin/jvm/functions/Function1;
    sput-object v2, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->pendingProvider Ljava/lang/String;
    sput-object v2, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->pendingAuthRequestId Ljava/lang/String;
    sget-object v3, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->activeJob Lkotlinx/coroutines/Job;
    if-eqz v3, +006h
    const/4 v4, 1
    invoke-static v3, v2, v4, v2, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    sput-object v2, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->activeJob Lkotlinx/coroutines/Job;
    monitor-exit v0
    return-object v1
    move-exception v1
    monitor-exit v0
    throw v1
    :try_start_0x3
.end method

.method private final createService()com.bytedance.trae.conversation.plugin.authorization.IConnectorOAuthApi
    .registers 11
    # ins_size=1
    const-class v0, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v0
    const-class v1, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v0, v1, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/login/api/ILoginService;
    if-eqz v0, +007h
    invoke-interface v0, Lcom/bytedance/trae/login/api/ILoginService;->getXTToken()Ljava/lang/String;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    if-nez v0, +004h
    const-string v0, ""
    move-object v1, v0
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    if-eqz v1, +007h
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v0
    goto +bh
    const-string v1, "X-Cloudide-Token"
    invoke-static v1, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/MapsKt;->mapOf(Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v0
    move-object v6, v0
    sget-object v1, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    const-string v2, "connector_oauth"
    const-class v3, Lcom/bytedance/trae/conversation/plugin/authorization/IConnectorOAuthApi;
    const/4 v4, 0
    sget-object v0, Lcom/bytedance/trae/network/HostResolver;->INSTANCE Lcom/bytedance/trae/network/HostResolver;
    sget-object v5, Lcom/bytedance/trae/network/HostType;->LOGIN Lcom/bytedance/trae/network/HostType;
    invoke-virtual v0, v5, Lcom/bytedance/trae/network/HostResolver;->getBaseUrl(Lcom/bytedance/trae/network/HostType;)Ljava/lang/String;
    move-result-object v5
    const/4 v7, 0
    const/16 v8, 36
    const/4 v9, 0
    invoke-static/range v1 ... v9, Lcom/bytedance/trae/network/TraeHttpConnection;->createService$default(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; Ljava/lang/Class; Lcom/bytedance/retrofit2/Converter$Factory; Ljava/lang/String; Ljava/util/Map; Z I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/plugin/authorization/IConnectorOAuthApi;
    return-object v0
.end method

.method private static final handleCallback$lambda$19(kotlin.jvm.internal.Ref$ObjectRef  java.lang.String)void
    .registers 2
    # ins_size=2
    iget-object v0, v0, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    check-cast v0, Lkotlin/jvm/functions/Function1;
    if-eqz v0, +005h
    invoke-interface v0, v1, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method

.method private final pollCustomAuth(com.bytedance.trae.conversation.plugin.authorization.IConnectorOAuthApi  java.lang.String  java.lang.String  kotlin.jvm.functions.Function1  kotlin.coroutines.Continuation)java.lang.Object
    .registers 19
    # ins_size=6
    move-object/from16 v0, v18
    instance-of v1, v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$pollCustomAuth$1;
    if-eqz v1, +013h
    move-object v1, v0
    check-cast v1, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$pollCustomAuth$1;
    iget v2, v1, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$pollCustomAuth$1;->label I
    const/high16 v3, -2147483648
    and-int/2addr v2, v3
    if-eqz v2, +009h
    iget v0, v1, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$pollCustomAuth$1;->label I
    sub-int/2addr v0, v3
    iput v0, v1, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$pollCustomAuth$1;->label I
    move-object v2, v13
    goto +7h
    new-instance v1, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$pollCustomAuth$1;
    move-object v2, v13
    invoke-direct v1, v13, v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$pollCustomAuth$1;-><init>(Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager; Lkotlin/coroutines/Continuation;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$pollCustomAuth$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v3
    iget v4, v1, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$pollCustomAuth$1;->label I
    const/4 v5, 2
    const/4 v6, 1
    if-eqz v4, +021h
    if-eq v4, v6, +011h
    if-ne v4, v5, +007h
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +06bh
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v1, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v1, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    iget-object v4, v1, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$pollCustomAuth$1;->L$1 Ljava/lang/Object;
    check-cast v4, Lkotlin/jvm/functions/Function1;
    iget-object v6, v1, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$pollCustomAuth$1;->L$0 Ljava/lang/Object;
    check-cast v6, Ljava/lang/String;
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v7, v4
    move-object v4, v6
    goto +26h
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    new-instance v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$pollCustomAuth$result$1;
    const/4 v12, 0
    move-object v7, v0
    move-object v8, v15
    move-object v9, v14
    move-object/from16 v10, v16
    move-object/from16 v11, v17
    invoke-direct/range v7 ... v12, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$pollCustomAuth$result$1;-><init>(Ljava/lang/String; Lcom/bytedance/trae/conversation/plugin/authorization/IConnectorOAuthApi; Ljava/lang/String; Lkotlin/jvm/functions/Function1; Lkotlin/coroutines/Continuation;)V
    check-cast v0, Lkotlin/jvm/functions/Function2;
    move-object v4, v15
    iput-object v4, v1, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$pollCustomAuth$1;->L$0 Ljava/lang/Object;
    move-object/from16 v7, v17
    iput-object v7, v1, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$pollCustomAuth$1;->L$1 Ljava/lang/Object;
    iput v6, v1, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$pollCustomAuth$1;->label I
    const-wide/32 v8, 300000
    invoke-static v8, v9, v0, v1, Lkotlinx/coroutines/TimeoutKt;->withTimeoutOrNull(J Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v3, +003h
    return-object v3
    check-cast v0, Lkotlin/Unit;
    if-nez v0, +032h
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/PluginTracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/PluginTracker;
    const-string v6, "custom_poll_timeout"
    invoke-virtual v0, v4, v6, Lcom/bytedance/trae/conversation/tracker/PluginTracker;->trackAuthFail(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v4, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->lock Ljava/lang/Object;
    monitor-enter v4
    const/4 v0, 0
    sput-object v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->pendingProvider Ljava/lang/String;
    sget-object v6, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    monitor-exit v4
    invoke-static Lkotlinx/coroutines/Dispatchers;->getMain()Lkotlinx/coroutines/MainCoroutineDispatcher;
    move-result-object v4
    check-cast v4, Lkotlin/coroutines/CoroutineContext;
    new-instance v6, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$pollCustomAuth$3;
    invoke-direct v6, v7, v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$pollCustomAuth$3;-><init>(Lkotlin/jvm/functions/Function1; Lkotlin/coroutines/Continuation;)V
    check-cast v6, Lkotlin/jvm/functions/Function2;
    iput-object v0, v1, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$pollCustomAuth$1;->L$0 Ljava/lang/Object;
    iput-object v0, v1, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$pollCustomAuth$1;->L$1 Ljava/lang/Object;
    iput v5, v1, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$pollCustomAuth$1;->label I
    invoke-static v4, v6, v1, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v3, +003h
    return-object v3
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
    move-exception v0
    monitor-exit v4
    throw v0
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
    :try_start_0x7c
.end method

.method private final pollListConnectorConnections(com.bytedance.trae.conversation.plugin.authorization.IConnectorOAuthApi  java.lang.String  kotlin.jvm.functions.Function1  kotlin.coroutines.Continuation)java.lang.Object
    .registers 13
    # ins_size=5
    instance-of v0, v12, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$pollListConnectorConnections$1;
    if-eqz v0, +012h
    move-object v0, v12
    check-cast v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$pollListConnectorConnections$1;
    iget v1, v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$pollListConnectorConnections$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v12, v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$pollListConnectorConnections$1;->label I
    sub-int/2addr v12, v2
    iput v12, v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$pollListConnectorConnections$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$pollListConnectorConnections$1;
    invoke-direct v0, v8, v12, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$pollListConnectorConnections$1;-><init>(Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager; Lkotlin/coroutines/Continuation;)V
    iget-object v12, v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$pollListConnectorConnections$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$pollListConnectorConnections$1;->label I
    const/4 v3, 2
    const/4 v4, 1
    const/4 v5, 0
    if-eqz v2, +020h
    if-eq v2, v4, +010h
    if-ne v2, v3, +006h
    invoke-static v12, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +5eh
    new-instance v9, Ljava/lang/IllegalStateException;
    const-string v10, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v9, v10, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v9
    iget-object v9, v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$pollListConnectorConnections$1;->L$1 Ljava/lang/Object;
    move-object v11, v9
    check-cast v11, Lkotlin/jvm/functions/Function1;
    iget-object v9, v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$pollListConnectorConnections$1;->L$0 Ljava/lang/Object;
    move-object v10, v9
    check-cast v10, Ljava/lang/String;
    invoke-static v12, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +1bh
    invoke-static v12, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    new-instance v12, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$pollListConnectorConnections$result$1;
    invoke-direct v12, v10, v9, v11, v5, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$pollListConnectorConnections$result$1;-><init>(Ljava/lang/String; Lcom/bytedance/trae/conversation/plugin/authorization/IConnectorOAuthApi; Lkotlin/jvm/functions/Function1; Lkotlin/coroutines/Continuation;)V
    check-cast v12, Lkotlin/jvm/functions/Function2;
    iput-object v10, v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$pollListConnectorConnections$1;->L$0 Ljava/lang/Object;
    iput-object v11, v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$pollListConnectorConnections$1;->L$1 Ljava/lang/Object;
    iput v4, v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$pollListConnectorConnections$1;->label I
    const-wide/32 v6, 300000
    invoke-static v6, v7, v12, v0, Lkotlinx/coroutines/TimeoutKt;->withTimeoutOrNull(J Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v12
    if-ne v12, v1, +003h
    return-object v1
    check-cast v12, Lkotlin/Unit;
    if-nez v12, +031h
    sget-object v9, Lcom/bytedance/trae/conversation/tracker/PluginTracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/PluginTracker;
    const-string v12, "desktop_poll_timeout"
    invoke-virtual v9, v10, v12, Lcom/bytedance/trae/conversation/tracker/PluginTracker;->trackAuthFail(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v9, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->lock Ljava/lang/Object;
    monitor-enter v9
    sput-object v5, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->pendingProvider Ljava/lang/String;
    sget-object v10, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    monitor-exit v9
    invoke-static Lkotlinx/coroutines/Dispatchers;->getMain()Lkotlinx/coroutines/MainCoroutineDispatcher;
    move-result-object v9
    check-cast v9, Lkotlin/coroutines/CoroutineContext;
    new-instance v10, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$pollListConnectorConnections$3;
    invoke-direct v10, v11, v5, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$pollListConnectorConnections$3;-><init>(Lkotlin/jvm/functions/Function1; Lkotlin/coroutines/Continuation;)V
    check-cast v10, Lkotlin/jvm/functions/Function2;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$pollListConnectorConnections$1;->L$0 Ljava/lang/Object;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$pollListConnectorConnections$1;->L$1 Ljava/lang/Object;
    iput v3, v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$pollListConnectorConnections$1;->label I
    invoke-static v9, v10, v0, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v9
    if-ne v9, v1, +003h
    return-object v1
    sget-object v9, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v9
    move-exception v10
    monitor-exit v9
    throw v10
    sget-object v9, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v9
    :try_start_0x6c
.end method

.method private static final reportWebViewAuthResult$lambda$13(kotlin.jvm.internal.Ref$ObjectRef  java.lang.String)void
    .registers 2
    # ins_size=2
    iget-object v0, v0, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    check-cast v0, Lkotlin/jvm/functions/Function1;
    if-eqz v0, +005h
    invoke-interface v0, v1, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method

.method public static synthetic startOAuth$default(com.bytedance.trae.conversation.plugin.authorization.PluginConnectorOAuthManager  android.content.Context  java.lang.String  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function1  int  java.lang.Object)void
    .registers 7
    # ins_size=7
    and-int/lit8 v5, v5, 4
    if-eqz v5, +003h
    const/4 v3, 0
    invoke-virtual v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->startOAuth(Landroid/content/Context; Ljava/lang/String; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function1;)V
    return-void 
.end method

.method private final startPolling(com.bytedance.trae.conversation.plugin.authorization.IConnectorOAuthApi  java.lang.String  java.lang.String  kotlin.jvm.functions.Function1  kotlin.coroutines.Continuation)java.lang.Object
    .registers 19
    # ins_size=6
    move-object/from16 v0, v18
    instance-of v1, v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startPolling$1;
    if-eqz v1, +013h
    move-object v1, v0
    check-cast v1, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startPolling$1;
    iget v2, v1, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startPolling$1;->label I
    const/high16 v3, -2147483648
    and-int/2addr v2, v3
    if-eqz v2, +009h
    iget v0, v1, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startPolling$1;->label I
    sub-int/2addr v0, v3
    iput v0, v1, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startPolling$1;->label I
    move-object v2, v13
    goto +7h
    new-instance v1, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startPolling$1;
    move-object v2, v13
    invoke-direct v1, v13, v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startPolling$1;-><init>(Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager; Lkotlin/coroutines/Continuation;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startPolling$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v3
    iget v4, v1, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startPolling$1;->label I
    const/4 v5, 2
    const/4 v6, 1
    if-eqz v4, +021h
    if-eq v4, v6, +011h
    if-ne v4, v5, +007h
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +06bh
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v1, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v1, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    iget-object v4, v1, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startPolling$1;->L$1 Ljava/lang/Object;
    check-cast v4, Lkotlin/jvm/functions/Function1;
    iget-object v6, v1, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startPolling$1;->L$0 Ljava/lang/Object;
    check-cast v6, Ljava/lang/String;
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v7, v4
    move-object v4, v6
    goto +26h
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    new-instance v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startPolling$result$1;
    const/4 v12, 0
    move-object v7, v0
    move-object v8, v15
    move-object v9, v14
    move-object/from16 v10, v16
    move-object/from16 v11, v17
    invoke-direct/range v7 ... v12, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startPolling$result$1;-><init>(Ljava/lang/String; Lcom/bytedance/trae/conversation/plugin/authorization/IConnectorOAuthApi; Ljava/lang/String; Lkotlin/jvm/functions/Function1; Lkotlin/coroutines/Continuation;)V
    check-cast v0, Lkotlin/jvm/functions/Function2;
    move-object v4, v15
    iput-object v4, v1, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startPolling$1;->L$0 Ljava/lang/Object;
    move-object/from16 v7, v17
    iput-object v7, v1, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startPolling$1;->L$1 Ljava/lang/Object;
    iput v6, v1, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startPolling$1;->label I
    const-wide/32 v8, 300000
    invoke-static v8, v9, v0, v1, Lkotlinx/coroutines/TimeoutKt;->withTimeoutOrNull(J Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v3, +003h
    return-object v3
    check-cast v0, Lkotlin/Unit;
    if-nez v0, +032h
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/PluginTracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/PluginTracker;
    const-string v6, "qrcode_poll_timeout"
    invoke-virtual v0, v4, v6, Lcom/bytedance/trae/conversation/tracker/PluginTracker;->trackAuthFail(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v4, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->lock Ljava/lang/Object;
    monitor-enter v4
    const/4 v0, 0
    sput-object v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->pendingProvider Ljava/lang/String;
    sget-object v6, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    monitor-exit v4
    invoke-static Lkotlinx/coroutines/Dispatchers;->getMain()Lkotlinx/coroutines/MainCoroutineDispatcher;
    move-result-object v4
    check-cast v4, Lkotlin/coroutines/CoroutineContext;
    new-instance v6, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startPolling$3;
    invoke-direct v6, v7, v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startPolling$3;-><init>(Lkotlin/jvm/functions/Function1; Lkotlin/coroutines/Continuation;)V
    check-cast v6, Lkotlin/jvm/functions/Function2;
    iput-object v0, v1, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startPolling$1;->L$0 Ljava/lang/Object;
    iput-object v0, v1, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startPolling$1;->L$1 Ljava/lang/Object;
    iput v5, v1, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startPolling$1;->label I
    invoke-static v4, v6, v1, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v3, +003h
    return-object v3
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
    move-exception v0
    monitor-exit v4
    throw v0
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
    :try_start_0x7c
.end method

.method public final authDurationMs()long
    .registers 6
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->lock Ljava/lang/Object;
    monitor-enter v0
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v1
    sget-wide v3, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->authStartTimeMs J
    sub-long/2addr v1, v3
    const-wide/16 v3, 0
    invoke-static v1, v2, v3, v4, Lkotlin/ranges/RangesKt;->coerceAtLeast(J J)J
    move-result-wide v1
    monitor-exit v0
    return-wide v1
    move-exception v1
    monitor-exit v0
    throw v1
    :try_start_0x3
.end method

.method public final cancelCustomAuthPolling()void
    .registers 5
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->lock Ljava/lang/Object;
    monitor-enter v0
    const/4 v1, 0
    sput-object v1, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->pendingProvider Ljava/lang/String;
    sget-object v2, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->activeJob Lkotlinx/coroutines/Job;
    if-eqz v2, +006h
    const/4 v3, 1
    invoke-static v2, v1, v3, v1, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    sput-object v1, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->activeJob Lkotlinx/coroutines/Job;
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    monitor-exit v0
    return-void 
    move-exception v1
    monitor-exit v0
    throw v1
    :try_start_0x4
.end method

.method public final cancelDesktopRedirectAuth()void
    .registers 5
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->lock Ljava/lang/Object;
    monitor-enter v0
    const/4 v1, 0
    sput-object v1, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->pendingProvider Ljava/lang/String;
    sget-object v2, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->activeJob Lkotlinx/coroutines/Job;
    if-eqz v2, +006h
    const/4 v3, 1
    invoke-static v2, v1, v3, v1, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    sput-object v1, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->activeJob Lkotlinx/coroutines/Job;
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    monitor-exit v0
    return-void 
    move-exception v1
    monitor-exit v0
    throw v1
    :try_start_0x4
.end method

.method public final cancelQrCodeAuth()void
    .registers 5
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->lock Ljava/lang/Object;
    monitor-enter v0
    const/4 v1, 0
    sput-object v1, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->pendingProvider Ljava/lang/String;
    sget-object v2, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->activeJob Lkotlinx/coroutines/Job;
    if-eqz v2, +006h
    const/4 v3, 1
    invoke-static v2, v1, v3, v1, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    sput-object v1, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->activeJob Lkotlinx/coroutines/Job;
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    monitor-exit v0
    return-void 
    move-exception v1
    monitor-exit v0
    throw v1
    :try_start_0x4
.end method

.method public final cancelWebViewAuth()void
    .registers 5
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->lock Ljava/lang/Object;
    monitor-enter v0
    const/4 v1, 0
    sput-object v1, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->pendingProvider Ljava/lang/String;
    sput-object v1, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->pendingCompletion Lkotlin/jvm/functions/Function1;
    sput-object v1, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->pendingAuthRequestId Ljava/lang/String;
    sget-object v2, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->activeJob Lkotlinx/coroutines/Job;
    if-eqz v2, +006h
    const/4 v3, 1
    invoke-static v2, v1, v3, v1, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    sput-object v1, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->activeJob Lkotlinx/coroutines/Job;
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    monitor-exit v0
    return-void 
    move-exception v1
    monitor-exit v0
    throw v1
    :try_start_0x4
.end method

.method public final handleCallback(android.net.Uri)void
    .registers 8
    # ins_size=2
    const-string v0, "handleCallback: provider mismatch, expected="
    const-string/jumbo v1, uri
    invoke-static v7, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v1, "provider"
    invoke-virtual v7, v1, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    const-string/jumbo v2, status
    invoke-virtual v7, v2, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    const-string v3, "auth_request_id"
    invoke-virtual v7, v3, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v7
    new-instance v3, Lkotlin/jvm/internal/Ref$ObjectRef;
    invoke-direct v3, Lkotlin/jvm/internal/Ref$ObjectRef;-><init>()V
    sget-object v4, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->lock Ljava/lang/Object;
    monitor-enter v4
    sget-object v5, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->pendingCompletion Lkotlin/jvm/functions/Function1;
    if-nez v5, +019h
    sget-object v7, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v0, "ConnectorOAuth"
    const-string v2, "handleCallback: no pending completion"
    invoke-virtual v7, v0, v2, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v7, Lcom/bytedance/trae/conversation/tracker/PluginTracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/PluginTracker;
    if-nez v1, +005h
    const-string/jumbo v1, unknown
    const-string v0, "callback_no_pending"
    invoke-virtual v7, v1, v0, Lcom/bytedance/trae/conversation/tracker/PluginTracker;->trackAuthFail(Ljava/lang/String; Ljava/lang/String;)V
    monitor-exit v4
    return-void 
    sget-object v5, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->pendingAuthRequestId Ljava/lang/String;
    if-eqz v5, +01fh
    invoke-static v7, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v7
    if-nez v7, +019h
    sget-object v7, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v0, "ConnectorOAuth"
    const-string v2, "handleCallback: auth_request_id mismatch"
    invoke-virtual v7, v0, v2, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v7, Lcom/bytedance/trae/conversation/tracker/PluginTracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/PluginTracker;
    if-nez v1, +005h
    const-string/jumbo v1, unknown
    const-string v0, "callback_request_id_mismatch"
    invoke-virtual v7, v1, v0, Lcom/bytedance/trae/conversation/tracker/PluginTracker;->trackAuthFail(Ljava/lang/String; Ljava/lang/String;)V
    monitor-exit v4
    return-void 
    if-eqz v1, +037h
    sget-object v7, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->pendingProvider Ljava/lang/String;
    if-eqz v7, +033h
    sget-object v7, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->pendingProvider Ljava/lang/String;
    invoke-static v1, v7, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v7
    if-nez v7, +02bh
    sget-object v7, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v2, "ConnectorOAuth"
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-direct v3, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->pendingProvider Ljava/lang/String;
    invoke-virtual v3, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v3, ", got="
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v7, v2, v0, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v7, Lcom/bytedance/trae/conversation/tracker/PluginTracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/PluginTracker;
    const-string v0, "callback_provider_mismatch"
    invoke-virtual v7, v1, v0, Lcom/bytedance/trae/conversation/tracker/PluginTracker;->trackAuthFail(Ljava/lang/String; Ljava/lang/String;)V
    monitor-exit v4
    return-void 
    sget-object v7, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->pendingCompletion Lkotlin/jvm/functions/Function1;
    iput-object v7, v3, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    const/4 v7, 0
    sput-object v7, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->pendingCompletion Lkotlin/jvm/functions/Function1;
    sput-object v7, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->pendingProvider Ljava/lang/String;
    sput-object v7, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->pendingAuthRequestId Ljava/lang/String;
    sget-object v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->activeJob Lkotlinx/coroutines/Job;
    if-eqz v0, +006h
    const/4 v1, 1
    invoke-static v0, v7, v1, v7, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    sput-object v7, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->activeJob Lkotlinx/coroutines/Job;
    sget-object v7, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    monitor-exit v4
    const-string/jumbo v7, success
    invoke-static v2, v7, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v7
    if-eqz v7, +006h
    const-string/jumbo v7, success
    goto +4h
    const-string/jumbo v7, user_cancel
    sget-object v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->mainHandler Landroid/os/Handler;
    new-instance v1, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$$ExternalSyntheticLambda0;
    invoke-direct v1, v3, v7, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$$ExternalSyntheticLambda0;-><init>(Lkotlin/jvm/internal/Ref$ObjectRef; Ljava/lang/String;)V
    invoke-virtual v0, v1, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z
    return-void 
    move-exception v7
    monitor-exit v4
    throw v7
    :try_start_0x23
    :try_start_0x3e
    :try_start_0x61
    :try_start_0x96
.end method

.method public final hasPendingOAuth()boolean
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->lock Ljava/lang/Object;
    monitor-enter v0
    sget-object v1, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->pendingCompletion Lkotlin/jvm/functions/Function1;
    if-eqz v1, +004h
    const/4 v1, 1
    goto +2h
    const/4 v1, 0
    monitor-exit v0
    return v1
    move-exception v1
    monitor-exit v0
    throw v1
    :try_start_0x3
.end method

.method public final isCustomAuthPollingProvider(java.lang.String)boolean
    .registers 3
    # ins_size=2
    const-string v0, "provider"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->CUSTOM_AUTH_POLLING_PROVIDERS Ljava/util/Set;
    invoke-interface v0, v2, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v2
    return v2
.end method

.method public final isDesktopRedirectProvider(java.lang.String)boolean
    .registers 3
    # ins_size=2
    const-string v0, "provider"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->DESKTOP_REDIRECT_PROVIDERS Ljava/util/Set;
    invoke-interface v0, v2, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v2
    return v2
.end method

.method public final isQrCodeProvider(java.lang.String)boolean
    .registers 3
    # ins_size=2
    const-string v0, "provider"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->QRCODE_PROVIDERS Ljava/util/Set;
    invoke-interface v0, v2, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v2
    return v2
.end method

.method public final isWebViewProvider(java.lang.String)boolean
    .registers 3
    # ins_size=2
    const-string v0, "provider"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->WEBVIEW_PROVIDERS Ljava/util/Set;
    invoke-interface v0, v2, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v2
    return v2
.end method

.method public final reportWebViewAuthResult(java.lang.String  java.lang.String  java.lang.String)boolean
    .registers 9
    # ins_size=4
    const-string/jumbo v0, reportWebViewAuthResult: provider mismatch, expected=
    const-string v1, "provider"
    invoke-static v6, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v1, status
    invoke-static v7, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v1, Lkotlin/jvm/internal/Ref$ObjectRef;
    invoke-direct v1, Lkotlin/jvm/internal/Ref$ObjectRef;-><init>()V
    sget-object v2, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->lock Ljava/lang/Object;
    monitor-enter v2
    sget-object v3, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->pendingCompletion Lkotlin/jvm/functions/Function1;
    const/4 v4, 0
    if-nez v3, +015h
    sget-object v7, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v8, "ConnectorOAuth"
    const-string/jumbo v0, reportWebViewAuthResult: no pending completion
    invoke-virtual v7, v8, v0, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v7, Lcom/bytedance/trae/conversation/tracker/PluginTracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/PluginTracker;
    const-string v8, "callback_no_pending"
    invoke-virtual v7, v6, v8, Lcom/bytedance/trae/conversation/tracker/PluginTracker;->trackAuthFail(Ljava/lang/String; Ljava/lang/String;)V
    monitor-exit v2
    return v4
    sget-object v3, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->pendingAuthRequestId Ljava/lang/String;
    if-eqz v3, +01bh
    invoke-static v8, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v8
    if-nez v8, +015h
    sget-object v7, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v8, "ConnectorOAuth"
    const-string/jumbo v0, reportWebViewAuthResult: auth_request_id mismatch
    invoke-virtual v7, v8, v0, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v7, Lcom/bytedance/trae/conversation/tracker/PluginTracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/PluginTracker;
    const-string v8, "callback_request_id_mismatch"
    invoke-virtual v7, v6, v8, Lcom/bytedance/trae/conversation/tracker/PluginTracker;->trackAuthFail(Ljava/lang/String; Ljava/lang/String;)V
    monitor-exit v2
    return v4
    sget-object v8, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->pendingProvider Ljava/lang/String;
    if-eqz v8, +033h
    sget-object v8, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->pendingProvider Ljava/lang/String;
    invoke-static v6, v8, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v8
    if-nez v8, +02bh
    sget-object v7, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v8, "ConnectorOAuth"
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct v1, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->pendingProvider Ljava/lang/String;
    invoke-virtual v1, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", got="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v7, v8, v0, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v7, Lcom/bytedance/trae/conversation/tracker/PluginTracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/PluginTracker;
    const-string v8, "callback_provider_mismatch"
    invoke-virtual v7, v6, v8, Lcom/bytedance/trae/conversation/tracker/PluginTracker;->trackAuthFail(Ljava/lang/String; Ljava/lang/String;)V
    monitor-exit v2
    return v4
    sget-object v6, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->pendingCompletion Lkotlin/jvm/functions/Function1;
    iput-object v6, v1, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    const/4 v6, 0
    sput-object v6, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->pendingCompletion Lkotlin/jvm/functions/Function1;
    sput-object v6, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->pendingProvider Ljava/lang/String;
    sput-object v6, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->pendingAuthRequestId Ljava/lang/String;
    sget-object v8, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->activeJob Lkotlinx/coroutines/Job;
    const/4 v0, 1
    if-eqz v8, +005h
    invoke-static v8, v6, v0, v6, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    sput-object v6, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->activeJob Lkotlinx/coroutines/Job;
    sget-object v6, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    monitor-exit v2
    sget-object v6, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->mainHandler Landroid/os/Handler;
    new-instance v8, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$$ExternalSyntheticLambda1;
    invoke-direct v8, v1, v7, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$$ExternalSyntheticLambda1;-><init>(Lkotlin/jvm/internal/Ref$ObjectRef; Ljava/lang/String;)V
    invoke-virtual v6, v8, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z
    return v0
    move-exception v6
    monitor-exit v2
    throw v6
    :try_start_0x16
    :try_start_0x2e
    :try_start_0x4b
    :try_start_0x80
.end method

.method public final startCustomAuthPollingAuth(android.content.Context  java.lang.String  kotlin.jvm.functions.Function1)void
    .registers 20
    # ins_size=4
    move-object/from16 v0, v18
    const-string v1, "context"
    move-object/from16 v2, v17
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v1, "provider"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v1, "onComplete"
    move-object/from16 v5, v19
    invoke-static v5, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v8, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->lock Ljava/lang/Object;
    monitor-enter v8
    sget-object v1, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->activeJob Lkotlinx/coroutines/Job;
    if-eqz v1, +007h
    const/4 v3, 1
    const/4 v4, 0
    invoke-static v1, v4, v3, v4, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    sput-object v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->pendingProvider Ljava/lang/String;
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v3
    sput-wide v3, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->authStartTimeMs J
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    monitor-exit v8
    invoke-virtual/range v17, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;
    move-result-object v6
    invoke-static Ljava/util/UUID;->randomUUID()Ljava/util/UUID;
    move-result-object v1
    invoke-virtual v1, Ljava/util/UUID;->toString()Ljava/lang/String;
    move-result-object v1
    const-string/jumbo v2, toString(...)
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    move-object/from16 v9, v16
    invoke-direct v9, v1, v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->buildMobileCallbackUrl(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    invoke-direct/range v16, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->createService()Lcom/bytedance/trae/conversation/plugin/authorization/IConnectorOAuthApi;
    move-result-object v2
    sget-object v10, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->scope Lkotlinx/coroutines/CoroutineScope;
    const/4 v11, 0
    sget-object v12, Lkotlinx/coroutines/CoroutineStart;->LAZY Lkotlinx/coroutines/CoroutineStart;
    new-instance v13, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startCustomAuthPollingAuth$job$1;
    const/4 v7, 0
    move-object v1, v13
    move-object/from16 v3, v18
    move-object/from16 v5, v19
    invoke-direct/range v1 ... v7, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startCustomAuthPollingAuth$job$1;-><init>(Lcom/bytedance/trae/conversation/plugin/authorization/IConnectorOAuthApi; Ljava/lang/String; Ljava/lang/String; Lkotlin/jvm/functions/Function1; Landroid/content/Context; Lkotlin/coroutines/Continuation;)V
    check-cast v13, Lkotlin/jvm/functions/Function2;
    const/4 v14, 1
    const/4 v15, 0
    invoke-static/range v10 ... v15, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    move-result-object v0
    monitor-enter v8
    sput-object v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->activeJob Lkotlinx/coroutines/Job;
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    monitor-exit v8
    invoke-interface v0, Lkotlinx/coroutines/Job;->start()Z
    return-void 
    move-exception v0
    monitor-exit v8
    throw v0
    move-exception v0
    move-object/from16 v9, v16
    monitor-exit v8
    throw v0
    :try_start_0x18
    :try_start_0x61
.end method

.method public final startDesktopRedirectAuth(java.lang.String  kotlin.jvm.functions.Function1)void
    .registers 12
    # ins_size=3
    const-string v0, "provider"
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "onComplete"
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->lock Ljava/lang/Object;
    monitor-enter v0
    sget-object v1, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->activeJob Lkotlinx/coroutines/Job;
    const/4 v2, 0
    if-eqz v1, +006h
    const/4 v3, 1
    invoke-static v1, v2, v3, v2, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    sput-object v10, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->pendingProvider Ljava/lang/String;
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v3
    sput-wide v3, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->authStartTimeMs J
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    monitor-exit v0
    invoke-direct v9, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->createService()Lcom/bytedance/trae/conversation/plugin/authorization/IConnectorOAuthApi;
    move-result-object v1
    sget-object v3, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->scope Lkotlinx/coroutines/CoroutineScope;
    const/4 v4, 0
    sget-object v5, Lkotlinx/coroutines/CoroutineStart;->LAZY Lkotlinx/coroutines/CoroutineStart;
    new-instance v6, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startDesktopRedirectAuth$job$1;
    invoke-direct v6, v1, v10, v11, v2, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startDesktopRedirectAuth$job$1;-><init>(Lcom/bytedance/trae/conversation/plugin/authorization/IConnectorOAuthApi; Ljava/lang/String; Lkotlin/jvm/functions/Function1; Lkotlin/coroutines/Continuation;)V
    check-cast v6, Lkotlin/jvm/functions/Function2;
    const/4 v7, 1
    const/4 v8, 0
    invoke-static/range v3 ... v8, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    move-result-object v10
    monitor-enter v0
    sput-object v10, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->activeJob Lkotlinx/coroutines/Job;
    sget-object v11, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    monitor-exit v0
    invoke-interface v10, Lkotlinx/coroutines/Job;->start()Z
    return-void 
    move-exception v10
    monitor-exit v0
    throw v10
    move-exception v10
    monitor-exit v0
    throw v10
    :try_start_0xd
    :try_start_0x38
.end method

.method public final startOAuth(android.content.Context  java.lang.String  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function1)void
    .registers 21
    # ins_size=5
    move-object/from16 v0, v18
    move-object/from16 v1, v20
    const-string v2, "context"
    move-object/from16 v3, v17
    invoke-static v3, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v2, "provider"
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v2, "onComplete"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static Ljava/util/UUID;->randomUUID()Ljava/util/UUID;
    move-result-object v2
    invoke-virtual v2, Ljava/util/UUID;->toString()Ljava/lang/String;
    move-result-object v2
    const-string/jumbo v4, toString(...)
    invoke-static v2, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v8, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->lock Ljava/lang/Object;
    monitor-enter v8
    sget-object v4, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->activeJob Lkotlinx/coroutines/Job;
    if-eqz v4, +007h
    const/4 v5, 1
    const/4 v6, 0
    invoke-static v4, v6, v5, v6, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    sput-object v1, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->pendingCompletion Lkotlin/jvm/functions/Function1;
    sput-object v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->pendingProvider Ljava/lang/String;
    sput-object v2, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->pendingAuthRequestId Ljava/lang/String;
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v4
    sput-wide v4, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->authStartTimeMs J
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    monitor-exit v8
    invoke-virtual/range v17, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;
    move-result-object v5
    move-object/from16 v9, v16
    invoke-direct v9, v2, v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->buildMobileCallbackUrl(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    invoke-direct/range v16, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->createService()Lcom/bytedance/trae/conversation/plugin/authorization/IConnectorOAuthApi;
    move-result-object v2
    sget-object v10, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->scope Lkotlinx/coroutines/CoroutineScope;
    const/4 v11, 0
    sget-object v12, Lkotlinx/coroutines/CoroutineStart;->LAZY Lkotlinx/coroutines/CoroutineStart;
    new-instance v13, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startOAuth$job$1;
    const/4 v7, 0
    move-object v1, v13
    move-object/from16 v3, v18
    move-object/from16 v6, v19
    invoke-direct/range v1 ... v7, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startOAuth$job$1;-><init>(Lcom/bytedance/trae/conversation/plugin/authorization/IConnectorOAuthApi; Ljava/lang/String; Ljava/lang/String; Landroid/content/Context; Lkotlin/jvm/functions/Function0; Lkotlin/coroutines/Continuation;)V
    check-cast v13, Lkotlin/jvm/functions/Function2;
    const/4 v14, 1
    const/4 v15, 0
    invoke-static/range v10 ... v15, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    move-result-object v0
    monitor-enter v8
    sput-object v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->activeJob Lkotlinx/coroutines/Job;
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    monitor-exit v8
    invoke-interface v0, Lkotlinx/coroutines/Job;->start()Z
    return-void 
    move-exception v0
    monitor-exit v8
    throw v0
    move-exception v0
    move-object/from16 v9, v16
    monitor-exit v8
    throw v0
    :try_start_0x26
    :try_start_0x65
.end method

.method public final startQrCodeAuth(java.lang.String  kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function0)void
    .registers 22
    # ins_size=5
    move-object/from16 v0, v18
    const-string v1, "provider"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v1, "onQrCodeReady"
    move-object/from16 v7, v19
    invoke-static v7, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v1, "onComplete"
    move-object/from16 v5, v20
    invoke-static v5, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v1, "onError"
    move-object/from16 v6, v21
    invoke-static v6, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v9, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->lock Ljava/lang/Object;
    monitor-enter v9
    sget-object v1, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->activeJob Lkotlinx/coroutines/Job;
    if-eqz v1, +007h
    const/4 v2, 1
    const/4 v3, 0
    invoke-static v1, v3, v2, v3, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    sput-object v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->pendingProvider Ljava/lang/String;
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v1
    sput-wide v1, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->authStartTimeMs J
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    monitor-exit v9
    invoke-static Ljava/util/UUID;->randomUUID()Ljava/util/UUID;
    move-result-object v1
    invoke-virtual v1, Ljava/util/UUID;->toString()Ljava/lang/String;
    move-result-object v1
    const-string/jumbo v2, toString(...)
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    move-object/from16 v10, v17
    invoke-direct v10, v1, v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->buildMobileCallbackUrl(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    invoke-direct/range v17, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->createService()Lcom/bytedance/trae/conversation/plugin/authorization/IConnectorOAuthApi;
    move-result-object v2
    sget-object v11, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->scope Lkotlinx/coroutines/CoroutineScope;
    const/4 v12, 0
    sget-object v13, Lkotlinx/coroutines/CoroutineStart;->LAZY Lkotlinx/coroutines/CoroutineStart;
    new-instance v14, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startQrCodeAuth$job$1;
    const/4 v8, 0
    move-object v1, v14
    move-object/from16 v3, v18
    move-object/from16 v5, v20
    move-object/from16 v6, v21
    move-object/from16 v7, v19
    invoke-direct/range v1 ... v8, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startQrCodeAuth$job$1;-><init>(Lcom/bytedance/trae/conversation/plugin/authorization/IConnectorOAuthApi; Ljava/lang/String; Ljava/lang/String; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function1; Lkotlin/coroutines/Continuation;)V
    check-cast v14, Lkotlin/jvm/functions/Function2;
    const/4 v15, 1
    const/16 v16, 0
    invoke-static/range v11 ... v16, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    move-result-object v0
    monitor-enter v9
    sput-object v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->activeJob Lkotlinx/coroutines/Job;
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    monitor-exit v9
    invoke-interface v0, Lkotlinx/coroutines/Job;->start()Z
    return-void 
    move-exception v0
    monitor-exit v9
    throw v0
    move-exception v0
    move-object/from16 v10, v17
    monitor-exit v9
    throw v0
    :try_start_0x1f
    :try_start_0x69
.end method

.method public final startWebViewAuth(android.content.Context  java.lang.String  kotlin.jvm.functions.Function1)void
    .registers 9
    # ins_size=4
    const-string v0, "context"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "provider"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "onComplete"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static Ljava/util/UUID;->randomUUID()Ljava/util/UUID;
    move-result-object v0
    invoke-virtual v0, Ljava/util/UUID;->toString()Ljava/lang/String;
    move-result-object v0
    const-string/jumbo v1, toString(...)
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->lock Ljava/lang/Object;
    monitor-enter v1
    sget-object v2, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->activeJob Lkotlinx/coroutines/Job;
    const/4 v3, 0
    if-eqz v2, +006h
    const/4 v4, 1
    invoke-static v2, v3, v4, v3, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    sput-object v3, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->activeJob Lkotlinx/coroutines/Job;
    sput-object v7, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->pendingProvider Ljava/lang/String;
    sput-object v8, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->pendingCompletion Lkotlin/jvm/functions/Function1;
    sput-object v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->pendingAuthRequestId Ljava/lang/String;
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v2
    sput-wide v2, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->authStartTimeMs J
    sget-object v8, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    monitor-exit v1
    invoke-direct v5, v7, v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->buildMiddlePageUrl(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v8
    sget-object v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity;->Companion Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity$Companion;
    invoke-virtual v0, v6, v8, v7, Lcom/bytedance/trae/conversation/plugin/authorization/PluginAuthWebViewActivity$Companion;->start(Landroid/content/Context; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    move-exception v6
    monitor-exit v1
    throw v6
    :try_start_0x20
.end method
