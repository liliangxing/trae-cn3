# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/git/GitHubConnectorManager;
.super Ljava/lang/Object;
.source "GitHubConnectorManager.kt"

.field private final config:Lcom/bytedance/trae/conversation/git/GitHubConnectConfig;
.field private final context:Landroid/content/Context;
.field private final tokenClient:Lcom/bytedance/trae/conversation/git/ThirdPartyTokenClient;


.method public constructor <init>(android.content.Context  com.bytedance.trae.conversation.git.GitHubConnectConfig)void
    .registers 4
    # ins_size=3
    const-string v0, "context"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "config"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/git/GitHubConnectorManager;->context Landroid/content/Context;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/git/GitHubConnectorManager;->config Lcom/bytedance/trae/conversation/git/GitHubConnectConfig;
    new-instance v2, Lcom/bytedance/trae/conversation/git/ThirdPartyTokenClient;
    invoke-direct v2, Lcom/bytedance/trae/conversation/git/ThirdPartyTokenClient;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/git/GitHubConnectorManager;->tokenClient Lcom/bytedance/trae/conversation/git/ThirdPartyTokenClient;
    return-void 
.end method

.method public synthetic constructor <init>(android.content.Context  com.bytedance.trae.conversation.git.GitHubConnectConfig  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 2
    if-eqz v3, +008h
    sget-object v2, Lcom/bytedance/trae/conversation/git/GitHubConnectConfig;->Companion Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$Companion;
    invoke-virtual v2, v1, Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$Companion;->shared(Landroid/content/Context;)Lcom/bytedance/trae/conversation/git/GitHubConnectConfig;
    move-result-object v2
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/git/GitHubConnectorManager;-><init>(Landroid/content/Context; Lcom/bytedance/trae/conversation/git/GitHubConnectConfig;)V
    return-void 
.end method

.method private final buildEnterpriseOAuthUrl(java.lang.String)java.lang.String
    .registers 7
    # ins_size=2
    const-class v0, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v0
    const-class v1, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v0, v1, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/login/api/ILoginService;
    if-eqz v0, +00dh
    invoke-interface v0, Lcom/bytedance/trae/login/api/ILoginService;->getAccountInfo()Lcom/bytedance/trae/login/api/AccountInfo;
    move-result-object v0
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/login/api/AccountInfo;->getUserId()Ljava/lang/String;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    if-nez v0, +004h
    const-string v0, ""
    move-object v1, v0
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    if-nez v1, +06ah
    sget-object v1, Lcom/bytedance/trae/network/HostResolver;->INSTANCE Lcom/bytedance/trae/network/HostResolver;
    sget-object v2, Lcom/bytedance/trae/network/HostType;->LOGIN Lcom/bytedance/trae/network/HostType;
    invoke-virtual v1, v2, Lcom/bytedance/trae/network/HostResolver;->getBaseUrl(Lcom/bytedance/trae/network/HostType;)Ljava/lang/String;
    move-result-object v1
    const/4 v2, 1
    new-array v2, v2, [C
    const/4 v3, 0
    const/16 v4, 47
    aput-char v4, v2, v3
    invoke-static v1, v2, Lkotlin/text/StringsKt;->trimEnd(Ljava/lang/String; [C)Ljava/lang/String;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v2, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    if-nez v2, +04ah
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v2, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, "/oauth/third-party/github"
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-static v1, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v1
    invoke-virtual v1, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;
    move-result-object v1
    const-string/jumbo v2, user_id
    invoke-virtual v1, v2, v0, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String; Ljava/lang/String;)Landroid/net/Uri$Builder;
    move-result-object v0
    const-string v1, "redirect_url"
    invoke-virtual v0, v1, v6, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String; Ljava/lang/String;)Landroid/net/Uri$Builder;
    move-result-object v6
    iget-object v0, v5, Lcom/bytedance/trae/conversation/git/GitHubConnectorManager;->config Lcom/bytedance/trae/conversation/git/GitHubConnectConfig;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/git/GitHubConnectConfig;->getOauth()Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$OAuth;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$OAuth;->getScope()Ljava/lang/String;
    move-result-object v0
    const-string/jumbo v1, scope
    invoke-virtual v6, v1, v0, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String; Ljava/lang/String;)Landroid/net/Uri$Builder;
    move-result-object v6
    invoke-virtual v6, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;
    move-result-object v6
    invoke-virtual v6, Landroid/net/Uri;->toString()Ljava/lang/String;
    move-result-object v6
    const-string/jumbo v0, toString(...)
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v6
    sget-object v6, Lcom/bytedance/trae/conversation/git/GitHubConnectorError$InvalidAuthorizeUrl;->INSTANCE Lcom/bytedance/trae/conversation/git/GitHubConnectorError$InvalidAuthorizeUrl;
    throw v6
    sget-object v6, Lcom/bytedance/trae/conversation/git/GitHubConnectorError$InvalidAuthorizeUrl;->INSTANCE Lcom/bytedance/trae/conversation/git/GitHubConnectorError$InvalidAuthorizeUrl;
    throw v6
.end method

.method public static synthetic buildOAuthUrl$default(com.bytedance.trae.conversation.git.GitHubConnectorManager  java.lang.String  int  java.lang.Object)java.lang.String
    .registers 4
    # ins_size=4
    and-int/lit8 v2, v2, 1
    if-eqz v2, +003h
    const/4 v1, 0
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/git/GitHubConnectorManager;->buildOAuthUrl(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic completeOAuthCallback$default(com.bytedance.trae.conversation.git.GitHubConnectorManager  java.lang.String  java.lang.String  kotlin.coroutines.Continuation  int  java.lang.Object)java.lang.Object
    .registers 6
    # ins_size=6
    and-int/lit8 v4, v4, 2
    if-eqz v4, +003h
    const/4 v2, 0
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/conversation/git/GitHubConnectorManager;->completeOAuthCallback(Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic exchangeCodeAndFetchGitHubToken$default(com.bytedance.trae.conversation.git.GitHubConnectorManager  java.lang.String  java.lang.String  kotlin.coroutines.Continuation  int  java.lang.Object)java.lang.Object
    .registers 6
    # ins_size=6
    and-int/lit8 v4, v4, 2
    if-eqz v4, +003h
    const/4 v2, 0
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/conversation/git/GitHubConnectorManager;->exchangeCodeAndFetchGitHubToken(Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method private final isEnterpriseLogin()boolean
    .registers 3
    # ins_size=1
    const-class v0, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v0
    const-class v1, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v0, v1, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/login/api/ILoginService;
    if-eqz v0, +00dh
    invoke-interface v0, Lcom/bytedance/trae/login/api/ILoginService;->getAccountInfo()Lcom/bytedance/trae/login/api/AccountInfo;
    move-result-object v0
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/login/api/AccountInfo;->getAccountType()Lcom/bytedance/trae/login/api/AccountType;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    sget-object v1, Lcom/bytedance/trae/login/api/AccountType;->TOB Lcom/bytedance/trae/login/api/AccountType;
    if-ne v0, v1, +004h
    const/4 v0, 1
    goto +2h
    const/4 v0, 0
    return v0
.end method

.method public final buildOAuthUrl(java.lang.String)java.lang.String
    .registers 7
    # ins_size=2
    if-nez v6, +00ch
    iget-object v6, v5, Lcom/bytedance/trae/conversation/git/GitHubConnectorManager;->config Lcom/bytedance/trae/conversation/git/GitHubConnectConfig;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/git/GitHubConnectConfig;->getOauth()Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$OAuth;
    move-result-object v6
    invoke-virtual v6, Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$OAuth;->getRedirectUri()Ljava/lang/String;
    move-result-object v6
    invoke-direct v5, Lcom/bytedance/trae/conversation/git/GitHubConnectorManager;->isEnterpriseLogin()Z
    move-result v0
    if-eqz v0, +007h
    invoke-direct v5, v6, Lcom/bytedance/trae/conversation/git/GitHubConnectorManager;->buildEnterpriseOAuthUrl(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v6
    return-object v6
    invoke-static Ljava/util/UUID;->randomUUID()Ljava/util/UUID;
    move-result-object v0
    invoke-virtual v0, Ljava/util/UUID;->toString()Ljava/lang/String;
    move-result-object v0
    const-string/jumbo v1, toString(...)
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v2, v5, Lcom/bytedance/trae/conversation/git/GitHubConnectorManager;->config Lcom/bytedance/trae/conversation/git/GitHubConnectConfig;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/git/GitHubConnectConfig;->getOauth()Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$OAuth;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$OAuth;->getAuthorizeEndpoint()Ljava/lang/String;
    move-result-object v2
    invoke-static v2, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v2
    invoke-virtual v2, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;
    move-result-object v2
    iget-object v3, v5, Lcom/bytedance/trae/conversation/git/GitHubConnectorManager;->config Lcom/bytedance/trae/conversation/git/GitHubConnectConfig;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/git/GitHubConnectConfig;->getOauth()Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$OAuth;
    move-result-object v3
    invoke-virtual v3, Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$OAuth;->getClientId()Ljava/lang/String;
    move-result-object v3
    const-string v4, "client_id"
    invoke-virtual v2, v4, v3, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String; Ljava/lang/String;)Landroid/net/Uri$Builder;
    move-result-object v2
    const-string v3, "redirect_uri"
    invoke-virtual v2, v3, v6, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String; Ljava/lang/String;)Landroid/net/Uri$Builder;
    move-result-object v6
    iget-object v2, v5, Lcom/bytedance/trae/conversation/git/GitHubConnectorManager;->config Lcom/bytedance/trae/conversation/git/GitHubConnectConfig;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/git/GitHubConnectConfig;->getOauth()Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$OAuth;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$OAuth;->getScope()Ljava/lang/String;
    move-result-object v2
    const-string/jumbo v3, scope
    invoke-virtual v6, v3, v2, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String; Ljava/lang/String;)Landroid/net/Uri$Builder;
    move-result-object v6
    const-string/jumbo v2, state
    invoke-virtual v6, v2, v0, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String; Ljava/lang/String;)Landroid/net/Uri$Builder;
    move-result-object v6
    invoke-virtual v6, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;
    move-result-object v6
    invoke-virtual v6, Landroid/net/Uri;->toString()Ljava/lang/String;
    move-result-object v6
    invoke-static v6, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v6
.end method

.method public final checkToken(kotlin.coroutines.Continuation)java.lang.Object
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/conversation/git/GitHubConnectorManager;->tokenClient Lcom/bytedance/trae/conversation/git/ThirdPartyTokenClient;
    const-string v1, "github"
    invoke-virtual v0, v1, v3, Lcom/bytedance/trae/conversation/git/ThirdPartyTokenClient;->getThirdPartyToken(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v3
    return-object v3
.end method

.method public final completeOAuthCallback(java.lang.String  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 12
    # ins_size=4
    instance-of v0, v11, Lcom/bytedance/trae/conversation/git/GitHubConnectorManager$completeOAuthCallback$1;
    if-eqz v0, +012h
    move-object v0, v11
    check-cast v0, Lcom/bytedance/trae/conversation/git/GitHubConnectorManager$completeOAuthCallback$1;
    iget v1, v0, Lcom/bytedance/trae/conversation/git/GitHubConnectorManager$completeOAuthCallback$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v11, v0, Lcom/bytedance/trae/conversation/git/GitHubConnectorManager$completeOAuthCallback$1;->label I
    sub-int/2addr v11, v2
    iput v11, v0, Lcom/bytedance/trae/conversation/git/GitHubConnectorManager$completeOAuthCallback$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/conversation/git/GitHubConnectorManager$completeOAuthCallback$1;
    invoke-direct v0, v8, v11, Lcom/bytedance/trae/conversation/git/GitHubConnectorManager$completeOAuthCallback$1;-><init>(Lcom/bytedance/trae/conversation/git/GitHubConnectorManager; Lkotlin/coroutines/Continuation;)V
    iget-object v11, v0, Lcom/bytedance/trae/conversation/git/GitHubConnectorManager$completeOAuthCallback$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/conversation/git/GitHubConnectorManager$completeOAuthCallback$1;->label I
    const/4 v3, 0
    const/4 v4, 3
    const/4 v5, 2
    const/4 v6, 0
    const/4 v7, 1
    if-eqz v2, +023h
    if-eq v2, v7, +01dh
    if-eq v2, v5, +011h
    if-ne v2, v4, +007h
    invoke-static v11, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +08bh
    new-instance v9, Ljava/lang/IllegalStateException;
    const-string v10, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v9, v10, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v9
    iget-object v9, v0, Lcom/bytedance/trae/conversation/git/GitHubConnectorManager$completeOAuthCallback$1;->L$0 Ljava/lang/Object;
    check-cast v9, Lcom/bytedance/trae/conversation/git/GitHubConnectorManager;
    invoke-static v11, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +4fh
    move-exception v10
    goto +56h
    invoke-static v11, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +23h
    invoke-static v11, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    invoke-direct v8, Lcom/bytedance/trae/conversation/git/GitHubConnectorManager;->isEnterpriseLogin()Z
    move-result v11
    if-nez v11, +01fh
    if-eqz v9, +01ah
    move-object v11, v9
    check-cast v11, Ljava/lang/CharSequence;
    invoke-static v11, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v11
    xor-int/2addr v11, v7
    if-eqz v11, +003h
    goto +2h
    move-object v9, v6
    if-eqz v9, +00ch
    iput v7, v0, Lcom/bytedance/trae/conversation/git/GitHubConnectorManager$completeOAuthCallback$1;->label I
    invoke-virtual v8, v9, v10, v0, Lcom/bytedance/trae/conversation/git/GitHubConnectorManager;->exchangeCodeAndFetchGitHubToken(Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v11
    if-ne v11, v1, +003h
    return-object v1
    return-object v11
    sget-object v9, Lcom/bytedance/trae/conversation/git/GitHubConnectorError$CallbackMissingCode;->INSTANCE Lcom/bytedance/trae/conversation/git/GitHubConnectorError$CallbackMissingCode;
    throw v9
    move-object v11, v9
    check-cast v11, Ljava/lang/CharSequence;
    if-eqz v11, +00bh
    invoke-static v11, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v11
    if-eqz v11, +003h
    goto +3h
    move v11, v3
    goto +2h
    move v11, v7
    if-nez v11, +032h
    sget-object v11, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v11, v8
    check-cast v11, Lcom/bytedance/trae/conversation/git/GitHubConnectorManager;
    iput-object v8, v0, Lcom/bytedance/trae/conversation/git/GitHubConnectorManager$completeOAuthCallback$1;->L$0 Ljava/lang/Object;
    iput v5, v0, Lcom/bytedance/trae/conversation/git/GitHubConnectorManager$completeOAuthCallback$1;->label I
    invoke-virtual v8, v9, v10, v0, Lcom/bytedance/trae/conversation/git/GitHubConnectorManager;->exchangeCodeAndFetchGitHubToken(Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v11
    if-ne v11, v1, +003h
    return-object v1
    move-object v9, v8
    check-cast v11, Lcom/bytedance/trae/conversation/git/GitHubConnectorAuthorization;
    invoke-static v11, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v10
    goto +dh
    move-exception v10
    move-object v9, v8
    sget-object v11, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v10, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v10
    invoke-static v10, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v10
    invoke-static v10, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v11
    if-eqz v11, +003h
    move-object v10, v6
    check-cast v10, Lcom/bytedance/trae/conversation/git/GitHubConnectorAuthorization;
    if-eqz v10, +004h
    return-object v10
    move-object v9, v8
    iput-object v6, v0, Lcom/bytedance/trae/conversation/git/GitHubConnectorManager$completeOAuthCallback$1;->L$0 Ljava/lang/Object;
    iput v4, v0, Lcom/bytedance/trae/conversation/git/GitHubConnectorManager$completeOAuthCallback$1;->label I
    invoke-virtual v9, v0, Lcom/bytedance/trae/conversation/git/GitHubConnectorManager;->checkToken(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v11
    if-ne v11, v1, +003h
    return-object v1
    check-cast v11, Ljava/lang/String;
    move-object v9, v11
    check-cast v9, Ljava/lang/CharSequence;
    if-eqz v9, +008h
    invoke-static v9, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v9
    if-eqz v9, +003h
    move v3, v7
    if-nez v3, +008h
    new-instance v9, Lcom/bytedance/trae/conversation/git/GitHubConnectorAuthorization;
    invoke-direct v9, v11, Lcom/bytedance/trae/conversation/git/GitHubConnectorAuthorization;-><init>(Ljava/lang/String;)V
    return-object v9
    sget-object v9, Lcom/bytedance/trae/conversation/git/GitHubConnectorError$DecodingFailed;->INSTANCE Lcom/bytedance/trae/conversation/git/GitHubConnectorError$DecodingFailed;
    throw v9
    :try_start_0x3f
    :try_start_0x80
    :try_start_0x91
.end method

.method public final disconnect(kotlin.coroutines.Continuation)java.lang.Object
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/conversation/git/GitHubConnectorManager;->tokenClient Lcom/bytedance/trae/conversation/git/ThirdPartyTokenClient;
    const-string v1, "github"
    invoke-virtual v0, v1, v3, Lcom/bytedance/trae/conversation/git/ThirdPartyTokenClient;->disconnectThirdPartyToken(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v3
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    if-ne v3, v0, +003h
    return-object v3
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v3
.end method

.method public final exchangeCodeAndFetchGitHubToken(java.lang.String  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 5
    # ins_size=4
    iget-object v0, v1, Lcom/bytedance/trae/conversation/git/GitHubConnectorManager;->tokenClient Lcom/bytedance/trae/conversation/git/ThirdPartyTokenClient;
    if-nez v3, +00ch
    iget-object v3, v1, Lcom/bytedance/trae/conversation/git/GitHubConnectorManager;->config Lcom/bytedance/trae/conversation/git/GitHubConnectConfig;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/git/GitHubConnectConfig;->getOauth()Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$OAuth;
    move-result-object v3
    invoke-virtual v3, Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$OAuth;->getRedirectUri()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v0, v2, v3, v4, Lcom/bytedance/trae/conversation/git/ThirdPartyTokenClient;->exchangeCodeAndFetchGitHubToken(Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    return-object v2
.end method

.method public final getConfig()com.bytedance.trae.conversation.git.GitHubConnectConfig
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/git/GitHubConnectorManager;->config Lcom/bytedance/trae/conversation/git/GitHubConnectConfig;
    return-object v0
.end method
