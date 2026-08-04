# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/TocCreditsPolicy;
.super Ljava/lang/Object;
.source "TocCreditsPolicy.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/TocCreditsPolicy;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/TocCreditsPolicy;
    invoke-direct v0, Lcom/bytedance/trae/conversation/TocCreditsPolicy;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/TocCreditsPolicy;->INSTANCE Lcom/bytedance/trae/conversation/TocCreditsPolicy;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static synthetic resolveUseFastRequest$default(com.bytedance.trae.conversation.TocCreditsPolicy  boolean  boolean  boolean  int  java.lang.Object)boolean
    .registers 6
    # ins_size=6
    and-int/lit8 v4, v4, 4
    if-eqz v4, +006h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/TocCreditsPolicy;->isEnabled()Z
    move-result v3
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/conversation/TocCreditsPolicy;->resolveUseFastRequest(Z Z Z)Z
    move-result v0
    return v0
.end method

.method public final isEnabled()boolean
    .registers 7
    # ins_size=1
    const/4 v0, 0
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v1, v6
    check-cast v1, Lcom/bytedance/trae/conversation/TocCreditsPolicy;
    const-class v1, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v1
    const-class v2, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v1, v2, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/login/api/ILoginService;
    if-eqz v1, +007h
    invoke-interface v1, Lcom/bytedance/trae/login/api/ILoginService;->getAccountInfo()Lcom/bytedance/trae/login/api/AccountInfo;
    move-result-object v1
    goto +2h
    move-object v1, v0
    invoke-static v1, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    goto +ch
    move-exception v1
    sget-object v2, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v1, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v1
    invoke-static v1, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    invoke-static v1, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +003h
    goto +2h
    move-object v0, v1
    check-cast v0, Lcom/bytedance/trae/login/api/AccountInfo;
    const/4 v1, 0
    const/4 v2, 1
    if-eqz v0, +009h
    invoke-virtual v0, Lcom/bytedance/trae/login/api/AccountInfo;->isLogin()Z
    move-result v3
    if-ne v3, v2, +003h
    move v1, v2
    if-eqz v0, +008h
    invoke-virtual v0, Lcom/bytedance/trae/login/api/AccountInfo;->getAccountType()Lcom/bytedance/trae/login/api/AccountType;
    move-result-object v0
    if-nez v0, +004h
    sget-object v0, Lcom/bytedance/trae/login/api/AccountType;->UNKNOWN Lcom/bytedance/trae/login/api/AccountType;
    sget-object v3, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v3, v6
    check-cast v3, Lcom/bytedance/trae/conversation/TocCreditsPolicy;
    sget-object v3, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isOversea()Z
    move-result v3
    invoke-static v3, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v3
    invoke-static v3, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    goto +ch
    move-exception v3
    sget-object v4, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v3, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v3
    invoke-static v3, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    invoke-static v2, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v4
    invoke-static v3, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v5
    if-eqz v5, +003h
    move-object v3, v4
    check-cast v3, Ljava/lang/Boolean;
    invoke-virtual v3, Ljava/lang/Boolean;->booleanValue()Z
    move-result v3
    sget-object v4, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v4, v6
    check-cast v4, Lcom/bytedance/trae/conversation/TocCreditsPolicy;
    sget-object v4, Lcom/bytedance/trae/conversation/LoginUtils;->INSTANCE Lcom/bytedance/trae/conversation/LoginUtils;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/LoginUtils;->shouldSkipTocCommercialFeatures()Z
    move-result v4
    invoke-static v4, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v4
    invoke-static v4, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v4
    goto +ch
    move-exception v4
    sget-object v5, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v4, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v4
    invoke-static v4, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v4
    invoke-static v2, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v2
    invoke-static v4, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v5
    if-eqz v5, +003h
    move-object v4, v2
    check-cast v4, Ljava/lang/Boolean;
    invoke-virtual v4, Ljava/lang/Boolean;->booleanValue()Z
    move-result v2
    invoke-virtual v6, v1, v0, v3, v2, Lcom/bytedance/trae/conversation/TocCreditsPolicy;->isEnabled(Z Lcom/bytedance/trae/login/api/AccountType; Z Z)Z
    move-result v0
    return v0
    :try_start_0x1
    :try_start_0x4b
    :try_start_0x7b
.end method

.method public final isEnabled(boolean  com.bytedance.trae.login.api.AccountType  boolean  boolean)boolean
    .registers 6
    # ins_size=5
    const-string v0, "accountType"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    if-eqz v2, +00ch
    sget-object v2, Lcom/bytedance/trae/login/api/AccountType;->TOC Lcom/bytedance/trae/login/api/AccountType;
    if-ne v3, v2, +008h
    if-nez v4, +006h
    if-nez v5, +004h
    const/4 v2, 1
    goto +2h
    const/4 v2, 0
    return v2
.end method

.method public final resolveUseFastRequest(boolean  boolean  boolean)boolean
    .registers 5
    # ins_size=4
    const/4 v0, 0
    if-eqz v4, +003h
    goto +6h
    if-nez v2, +004h
    if-eqz v3, +003h
    const/4 v0, 1
    return v0
.end method
