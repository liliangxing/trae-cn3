# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/service/AccountHelper;
.super Ljava/lang/Object;
.source "AccountHelper.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/login/service/AccountHelper;
.field private static final KEVA_DEFAULT_KEY:Ljava/lang/String;
.field private static final LOGIN_PLATFORM:Ljava/lang/String;
.field private static final LOGIN_PLATFORM_ENTERPRISE:Ljava/lang/String;
.field private static final LOGIN_PLATFORM_GITHUB:Ljava/lang/String;
.field private static final LOGIN_PLATFORM_GOOGLE:Ljava/lang/String;
.field private static final LOGIN_PLATFORM_PHONE:Ljava/lang/String;
.field private static bridge isNewUser:Z
.field private static final keva:Lcom/bytedance/keva/Keva;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/login/service/AccountHelper;
    invoke-direct v0, Lcom/bytedance/trae/login/service/AccountHelper;-><init>()V
    sput-object v0, Lcom/bytedance/trae/login/service/AccountHelper;->INSTANCE Lcom/bytedance/trae/login/service/AccountHelper;
    const-string v0, "default"
    sput-object v0, Lcom/bytedance/trae/login/service/AccountHelper;->KEVA_DEFAULT_KEY Ljava/lang/String;
    const/4 v1, 0
    invoke-static v0, v1, Lcom/bytedance/keva/Keva;->getRepo(Ljava/lang/String; I)Lcom/bytedance/keva/Keva;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/login/service/AccountHelper;->keva Lcom/bytedance/keva/Keva;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final transformLoginPlatformToString(com.bytedance.trae.login.api.LoginPlatform)java.lang.String
    .registers 4
    # ins_size=2
    if-nez v3, +004h
    const/4 v0, -1
    goto +9h
    sget-object v0, Lcom/bytedance/trae/login/service/AccountHelper$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v3, Lcom/bytedance/trae/login/api/LoginPlatform;->ordinal()I
    move-result v1
    aget v0, v0, v1
    const/4 v1, 1
    if-eq v0, v1, +01dh
    const/4 v1, 2
    if-eq v0, v1, +017h
    const/4 v1, 3
    if-eq v0, v1, +011h
    const/4 v1, 4
    if-eq v0, v1, +00bh
    if-eqz v3, +007h
    invoke-virtual v3, Lcom/bytedance/trae/login/api/LoginPlatform;->name()Ljava/lang/String;
    move-result-object v3
    goto +eh
    const/4 v3, 0
    goto +ch
    const-string v3, "login_platform_enterprise"
    goto +9h
    const-string v3, "login_platform_github"
    goto +6h
    const-string v3, "login_platform_google"
    goto +3h
    const-string v3, "login_platform_phone"
    return-object v3
.end method

.method private final transformStringToLoginPlatform(java.lang.String)com.bytedance.trae.login.api.LoginPlatform
    .registers 4
    # ins_size=2
    if-eqz v3, +03bh
    invoke-virtual v3, Ljava/lang/String;->hashCode()I
    move-result v0
    sparse-switch v0, +000006eh
    goto +32h
    const-string v0, "login_platform_enterprise"
    invoke-virtual v3, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +003h
    goto +29h
    sget-object v3, Lcom/bytedance/trae/login/api/LoginPlatform;->ENTERPRISE Lcom/bytedance/trae/login/api/LoginPlatform;
    goto/16 +05eh
    const-string v0, "login_platform_phone"
    invoke-virtual v3, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +003h
    goto +1ch
    sget-object v3, Lcom/bytedance/trae/login/api/LoginPlatform;->PHONE Lcom/bytedance/trae/login/api/LoginPlatform;
    goto +51h
    const-string v0, "login_platform_google"
    invoke-virtual v3, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +003h
    goto +10h
    sget-object v3, Lcom/bytedance/trae/login/api/LoginPlatform;->GOOGLE Lcom/bytedance/trae/login/api/LoginPlatform;
    goto +45h
    const-string v0, "login_platform_github"
    invoke-virtual v3, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +003h
    goto +4h
    sget-object v3, Lcom/bytedance/trae/login/api/LoginPlatform;->GITHUB Lcom/bytedance/trae/login/api/LoginPlatform;
    goto +39h
    move-object v0, v3
    check-cast v0, Ljava/lang/CharSequence;
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +003h
    goto +3h
    const/4 v0, 0
    goto +2h
    const/4 v0, 1
    const/4 v1, 0
    if-eqz v0, +004h
    move-object v3, v1
    goto +25h
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v0, v2
    check-cast v0, Lcom/bytedance/trae/login/service/AccountHelper;
    invoke-static v3, Lcom/bytedance/trae/login/api/LoginPlatform;->valueOf(Ljava/lang/String;)Lcom/bytedance/trae/login/api/LoginPlatform;
    move-result-object v3
    invoke-static v3, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    goto +ch
    move-exception v3
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v3, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v3
    invoke-static v3, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    invoke-static v3, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +003h
    goto +2h
    move-object v1, v3
    move-object v3, v1
    check-cast v3, Lcom/bytedance/trae/login/api/LoginPlatform;
    return-object v3
    sparse-switch-payload -3594d3a7 -35429151 38924638 67c818d7
    :try_start_0x4f
.end method

.method public final doLogoutCommon(boolean  com.bytedance.trae.login.api.LoginPlatform  com.bytedance.trae.login.api.IAccountCallback  java.lang.String)void
    .registers 7
    # ins_size=5
    invoke-static Lcom/bytedance/sdk/account/impl/BDAccountCoreApiImpl;->instance()Lcom/bytedance/sdk/account/api/IBDAccountCoreApi;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/login/service/AccountHelper$doLogoutCommon$1;
    invoke-direct v1, v3, v5, v4, v6, Lcom/bytedance/trae/login/service/AccountHelper$doLogoutCommon$1;-><init>(Z Lcom/bytedance/trae/login/api/IAccountCallback; Lcom/bytedance/trae/login/api/LoginPlatform; Ljava/lang/String;)V
    check-cast v1, Lcom/bytedance/sdk/account/api/call/AbsApiCall;
    const-string/jumbo v3, user_logout
    const/4 v4, 0
    invoke-interface v0, v3, v4, v1, Lcom/bytedance/sdk/account/api/IBDAccountCoreApi;->logout(Ljava/lang/String; Ljava/util/Map; Lcom/bytedance/sdk/account/api/call/AbsApiCall;)V
    return-void 
.end method

.method public final getAccountPlatform()com.bytedance.trae.login.api.LoginPlatform
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/login/service/AccountHelper;->keva Lcom/bytedance/keva/Keva;
    const-string v1, "login_platform"
    const-string v2, ""
    invoke-virtual v0, v1, v2, Lcom/bytedance/keva/Keva;->getString(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    invoke-direct v3, v0, Lcom/bytedance/trae/login/service/AccountHelper;->transformStringToLoginPlatform(Ljava/lang/String;)Lcom/bytedance/trae/login/api/LoginPlatform;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    return-object v0
    :try_start_0x0
.end method

.method public final isNewUser()boolean
    .registers 2
    # ins_size=1
    sget-boolean v0, Lcom/bytedance/trae/login/service/AccountHelper;->isNewUser Z
    return v0
.end method

.method public final loginStatusChanged(com.bytedance.trae.login.api.AccountStatus  java.lang.String  com.bytedance.trae.login.api.LoginPlatform)void
    .registers 6
    # ins_size=4
    const-string/jumbo v0, status
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "businessScene"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/login/api/AccountStatus;->LOGGED_IN Lcom/bytedance/trae/login/api/AccountStatus;
    if-ne v3, v0, +008h
    sget-object v0, Lcom/bytedance/trae/login/service/AccountHelper;->INSTANCE Lcom/bytedance/trae/login/service/AccountHelper;
    invoke-virtual v0, v5, Lcom/bytedance/trae/login/service/AccountHelper;->saveAccountPlatform(Lcom/bytedance/trae/login/api/LoginPlatform;)V
    goto +25h
    sget-object v5, Lcom/bytedance/trae/login/service/AccountHelper;->INSTANCE Lcom/bytedance/trae/login/service/AccountHelper;
    const/4 v0, 0
    invoke-virtual v5, v0, Lcom/bytedance/trae/login/service/AccountHelper;->saveAccountPlatform(Lcom/bytedance/trae/login/api/LoginPlatform;)V
    sget-object v5, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    invoke-virtual v5, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->clearAuthData()V
    sget-object v5, Lcom/bytedance/trae/keva/KevaRepos;->INSTANCE Lcom/bytedance/trae/keva/KevaRepos;
    invoke-virtual v5, Lcom/bytedance/trae/keva/KevaRepos;->getDefaultRepo()Lcom/bytedance/keva/Keva;
    move-result-object v5
    const-string v0, "key_has_profile_overview_data"
    const/4 v1, 0
    invoke-virtual v5, v0, v1, Lcom/bytedance/keva/Keva;->storeBoolean(Ljava/lang/String; Z)V
    sget-object v5, Lcom/bytedance/trae/keva/KevaRepos;->INSTANCE Lcom/bytedance/trae/keva/KevaRepos;
    invoke-virtual v5, Lcom/bytedance/trae/keva/KevaRepos;->getDefaultRepo()Lcom/bytedance/keva/Keva;
    move-result-object v5
    const-string v0, "key_profile_overview_data"
    const-string v1, ""
    invoke-virtual v5, v0, v1, Lcom/bytedance/keva/Keva;->storeString(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v5, Lcom/bytedance/trae/login/service/AccountStatusManager;->INSTANCE Lcom/bytedance/trae/login/service/AccountStatusManager;
    invoke-virtual v5, v3, v4, Lcom/bytedance/trae/login/service/AccountStatusManager;->loginStatusChanged(Lcom/bytedance/trae/login/api/AccountStatus; Ljava/lang/String;)V
    return-void 
.end method

.method public final saveAccountPlatform(com.bytedance.trae.login.api.LoginPlatform)void
    .registers 4
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/login/service/AccountHelper;->keva Lcom/bytedance/keva/Keva;
    const-string v1, "login_platform"
    invoke-direct v2, v3, Lcom/bytedance/trae/login/service/AccountHelper;->transformLoginPlatformToString(Lcom/bytedance/trae/login/api/LoginPlatform;)Ljava/lang/String;
    move-result-object v3
    invoke-virtual v0, v1, v3, Lcom/bytedance/keva/Keva;->storeString(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public final setIsNewUser(boolean)void
    .registers 2
    # ins_size=2
    sput-boolean v1, Lcom/bytedance/trae/login/service/AccountHelper;->isNewUser Z
    return-void 
.end method
