# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager;
.super Ljava/lang/Object;
.source "EnterpriseAuthManager.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager;
.field private static final PLATFORM_ENTERPRISE:Ljava/lang/String;
.field private static final TAG:Ljava/lang/String;
.field private static final TOB_SESSION_COOKIE_NAME:Ljava/lang/String;
.field private static final exceptionHandler:Lkotlinx/coroutines/CoroutineExceptionHandler;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager;
    invoke-direct v0, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager;-><init>()V
    sput-object v0, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager;->INSTANCE Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager;
    sget-object v0, Lkotlinx/coroutines/CoroutineExceptionHandler;->Key Lkotlinx/coroutines/CoroutineExceptionHandler$Key;
    new-instance v1, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager$special$$inlined$CoroutineExceptionHandler$1;
    invoke-direct v1, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager$special$$inlined$CoroutineExceptionHandler$1;-><init>(Lkotlinx/coroutines/CoroutineExceptionHandler$Key;)V
    check-cast v1, Lkotlinx/coroutines/CoroutineExceptionHandler;
    sput-object v1, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager;->exceptionHandler Lkotlinx/coroutines/CoroutineExceptionHandler;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static final synthetic access$completeTokenFlow(com.bytedance.trae.login.enterprise.EnterpriseAuthManager  java.lang.String  java.lang.String)void
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager;->completeTokenFlow(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public static final synthetic access$doAccountLogin(com.bytedance.trae.login.enterprise.EnterpriseAuthManager  java.lang.String  java.lang.String)kotlin.Pair
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager;->doAccountLogin(Ljava/lang/String; Ljava/lang/String;)Lkotlin/Pair;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$exchangeTokenForRefresh(com.bytedance.trae.login.enterprise.EnterpriseAuthManager  java.lang.String)com.bytedance.trae.login.traeauth.TraeExchangeTokenResult
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager;->exchangeTokenForRefresh(Ljava/lang/String;)Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$refreshEnterpriseUserInfo(com.bytedance.trae.login.enterprise.EnterpriseAuthManager  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager;->refreshEnterpriseUserInfo(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$updateEnterpriseUserProfile(com.bytedance.trae.login.enterprise.EnterpriseAuthManager  java.util.Map  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager;->updateEnterpriseUserProfile(Ljava/util/Map; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method private final buildSetUserInfoRequest(java.util.Map)com.bytedance.trae.login.enterprise.SetUserInfoRequest
    .registers 5
    # ins_size=2
    const-string v0, "name"
    invoke-interface v4, v0, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/String;
    const/4 v1, 0
    if-eqz v0, +00eh
    move-object v2, v0
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v2, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    xor-int/lit8 v2, v2, 1
    if-eqz v2, +003h
    goto +2h
    move-object v0, v1
    const-string v2, "avatar"
    invoke-interface v4, v2, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Ljava/lang/String;
    if-eqz v4, +00eh
    move-object v2, v4
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v2, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    xor-int/lit8 v2, v2, 1
    if-eqz v2, +003h
    goto +2h
    move-object v4, v1
    if-nez v0, +005h
    if-nez v4, +003h
    return-object v1
    new-instance v1, Lcom/bytedance/trae/login/enterprise/SetUserInfoRequest;
    invoke-direct v1, v0, v4, Lcom/bytedance/trae/login/enterprise/SetUserInfoRequest;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    return-object v1
.end method

.method private final buildUserInfo(java.lang.String  com.bytedance.trae.login.enterprise.EnterpriseGetUserInfoData)com.bytedance.trae.login.user.UserInfo
    .registers 24
    # ins_size=3
    const/4 v0, 0
    if-eqz v23, +007h
    invoke-virtual/range v23, Lcom/bytedance/trae/login/enterprise/EnterpriseGetUserInfoData;->getUserInfo()Lcom/bytedance/trae/login/enterprise/EnterpriseUserInfo;
    move-result-object v1
    goto +2h
    move-object v1, v0
    if-eqz v23, +007h
    invoke-virtual/range v23, Lcom/bytedance/trae/login/enterprise/EnterpriseGetUserInfoData;->getTenantInfoBase()Lcom/bytedance/trae/login/enterprise/EnterpriseTenantInfo;
    move-result-object v2
    goto +2h
    move-object v2, v0
    const/4 v3, 1
    const/4 v4, 0
    if-eqz v1, +01dh
    invoke-virtual v1, Lcom/bytedance/trae/login/enterprise/EnterpriseUserInfo;->getUserId()Ljava/lang/String;
    move-result-object v5
    if-eqz v5, +017h
    move-object v6, v5
    check-cast v6, Ljava/lang/CharSequence;
    invoke-interface v6, Ljava/lang/CharSequence;->length()I
    move-result v6
    if-lez v6, +004h
    move v6, v3
    goto +2h
    move v6, v4
    if-eqz v6, +003h
    goto +2h
    move-object v5, v0
    if-nez v5, +003h
    goto +3h
    move-object v7, v5
    goto +3h
    move-object/from16 v7, v22
    if-eqz v1, +01dh
    invoke-virtual v1, Lcom/bytedance/trae/login/enterprise/EnterpriseUserInfo;->getName()Ljava/lang/String;
    move-result-object v5
    if-eqz v5, +017h
    move-object v6, v5
    check-cast v6, Ljava/lang/CharSequence;
    invoke-interface v6, Ljava/lang/CharSequence;->length()I
    move-result v6
    if-lez v6, +004h
    move v6, v3
    goto +2h
    move v6, v4
    if-eqz v6, +003h
    goto +2h
    move-object v5, v0
    if-nez v5, +003h
    goto +3h
    move-object v8, v5
    goto +3h
    move-object/from16 v8, v22
    const-string v5, ""
    if-eqz v1, +00bh
    invoke-virtual v1, Lcom/bytedance/trae/login/enterprise/EnterpriseUserInfo;->getAvatar()Ljava/lang/String;
    move-result-object v6
    if-nez v6, +003h
    goto +3h
    move-object v9, v6
    goto +2h
    move-object v9, v5
    const/4 v10, 0
    if-eqz v1, +01ch
    invoke-virtual v1, Lcom/bytedance/trae/login/enterprise/EnterpriseUserInfo;->getEmail()Ljava/lang/String;
    move-result-object v6
    if-eqz v6, +016h
    move-object v11, v6
    check-cast v11, Ljava/lang/CharSequence;
    invoke-interface v11, Ljava/lang/CharSequence;->length()I
    move-result v11
    if-lez v11, +003h
    goto +2h
    move v3, v4
    if-eqz v3, +003h
    goto +2h
    move-object v6, v0
    if-nez v6, +003h
    goto +3h
    move-object v11, v6
    goto +3h
    move-object/from16 v11, v22
    const/4 v12, 0
    if-eqz v2, +00bh
    invoke-virtual v2, Lcom/bytedance/trae/login/enterprise/EnterpriseTenantInfo;->getTenantId()Ljava/lang/String;
    move-result-object v3
    if-nez v3, +003h
    goto +3h
    move-object v13, v3
    goto +ch
    if-eqz v1, +007h
    invoke-virtual v1, Lcom/bytedance/trae/login/enterprise/EnterpriseUserInfo;->getTenantId()Ljava/lang/String;
    move-result-object v3
    goto +2h
    move-object v3, v0
    if-nez v3, -00ah
    move-object v13, v5
    if-eqz v2, +00bh
    invoke-virtual v2, Lcom/bytedance/trae/login/enterprise/EnterpriseTenantInfo;->getTenantName()Ljava/lang/String;
    move-result-object v3
    if-nez v3, +003h
    goto +3h
    move-object v14, v3
    goto +2h
    move-object v14, v5
    if-eqz v2, +00ch
    invoke-virtual v2, Lcom/bytedance/trae/login/enterprise/EnterpriseTenantInfo;->getProductType()Ljava/lang/Integer;
    move-result-object v2
    if-eqz v2, +006h
    invoke-virtual v2, Ljava/lang/Integer;->intValue()I
    move-result v4
    move v15, v4
    if-eqz v1, +00ch
    invoke-virtual v1, Lcom/bytedance/trae/login/enterprise/EnterpriseUserInfo;->getAiRegion()Ljava/lang/String;
    move-result-object v1
    if-nez v1, +003h
    goto +4h
    move-object/from16 v16, v1
    goto +3h
    move-object/from16 v16, v5
    const/16 v17, 0
    if-eqz v23, +006h
    invoke-virtual/range v23, Lcom/bytedance/trae/login/enterprise/EnterpriseGetUserInfoData;->getPrivacyMode()Ljava/lang/Boolean;
    move-result-object v0
    move-object/from16 v18, v0
    const/16 v19, 1064
    const/16 v20, 0
    new-instance v0, Lcom/bytedance/trae/login/user/UserInfo;
    move-object v6, v0
    invoke-direct/range v6 ... v20, Lcom/bytedance/trae/login/user/UserInfo;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v0
.end method

.method private final completeTokenFlow(java.lang.String  java.lang.String)void
    .registers 21
    # ins_size=3
    move-object/from16 v0, v18
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v1
    move-object/from16 v3, v20
    invoke-direct v0, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager;->doGetRefreshToken(Ljava/lang/String;)Lcom/bytedance/trae/login/enterprise/EnterpriseGetRefreshTokenResult;
    move-result-object v3
    sget-object v4, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v5
    sub-long/2addr v5, v1
    const-string v1, "getRefreshToken"
    const-string v2, "enterprise"
    invoke-virtual v4, v1, v2, v5, v6, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportStepDuration(Ljava/lang/String; Ljava/lang/String; J)V
    invoke-virtual v3, Lcom/bytedance/trae/login/enterprise/EnterpriseGetRefreshTokenResult;->getRefreshToken()Ljava/lang/String;
    move-result-object v1
    move-object v3, v1
    check-cast v3, Ljava/lang/CharSequence;
    const/4 v4, 0
    const/4 v5, 1
    if-eqz v3, +00bh
    invoke-interface v3, Ljava/lang/CharSequence;->length()I
    move-result v3
    if-nez v3, +003h
    goto +3h
    move v3, v4
    goto +2h
    move v3, v5
    const-string v6, "getString(...)"
    if-nez v3, +0a7h
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v7
    invoke-direct v0, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager;->doExchangeToken(Ljava/lang/String;)Lcom/bytedance/trae/login/enterprise/EnterpriseExchangeTokenResult;
    move-result-object v1
    sget-object v3, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v9
    sub-long/2addr v9, v7
    const-string v7, "exchangeToken"
    invoke-virtual v3, v7, v2, v9, v10, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportStepDuration(Ljava/lang/String; Ljava/lang/String; J)V
    invoke-virtual v1, Lcom/bytedance/trae/login/enterprise/EnterpriseExchangeTokenResult;->getToken()Ljava/lang/String;
    move-result-object v3
    move-object v7, v3
    check-cast v7, Ljava/lang/CharSequence;
    if-eqz v7, +008h
    invoke-interface v7, Ljava/lang/CharSequence;->length()I
    move-result v7
    if-nez v7, +003h
    move v4, v5
    if-nez v4, +063h
    sget-object v4, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;
    invoke-virtual v1, Lcom/bytedance/trae/login/enterprise/EnterpriseExchangeTokenResult;->getTokenExpireAt()Ljava/lang/Long;
    move-result-object v5
    invoke-virtual v4, v3, v5, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->saveJwtToken(Ljava/lang/String; Ljava/lang/Long;)V
    invoke-virtual v1, Lcom/bytedance/trae/login/enterprise/EnterpriseExchangeTokenResult;->getRefreshToken()Ljava/lang/String;
    move-result-object v4
    if-eqz v4, +00bh
    sget-object v5, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;
    invoke-virtual v1, Lcom/bytedance/trae/login/enterprise/EnterpriseExchangeTokenResult;->getRefreshExpireAt()Ljava/lang/Long;
    move-result-object v1
    invoke-virtual v5, v4, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->saveRefreshToken(Ljava/lang/String; Ljava/lang/Long;)V
    sget-object v1, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;
    invoke-virtual v1, v2, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->saveLoginPlatform(Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v4
    const/16 v6, 1000
    int-to-long v6, v6
    div-long/2addr v4, v6
    invoke-virtual v1, v4, v5, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->saveLastExchangeSuccessAt(J)V
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v4
    invoke-direct v0, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager;->fetchUserInfo(Ljava/lang/String;)Lcom/bytedance/trae/login/enterprise/EnterpriseGetUserInfoData;
    move-result-object v1
    sget-object v6, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v7
    sub-long/2addr v7, v4
    const-string v4, "fetchUserInfo"
    invoke-virtual v6, v4, v2, v7, v8, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportStepDuration(Ljava/lang/String; Ljava/lang/String; J)V
    move-object/from16 v2, v19
    invoke-direct v0, v2, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager;->buildUserInfo(Ljava/lang/String; Lcom/bytedance/trae/login/enterprise/EnterpriseGetUserInfoData;)Lcom/bytedance/trae/login/user/UserInfo;
    move-result-object v1
    sget-object v2, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;
    invoke-virtual v2, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->saveUserInfo(Lcom/bytedance/trae/login/user/UserInfo;)V
    sget-object v1, Lcom/bytedance/trae/login/service/AccountHelper;->INSTANCE Lcom/bytedance/trae/login/service/AccountHelper;
    sget-object v2, Lcom/bytedance/trae/login/api/AccountStatus;->LOGGED_IN Lcom/bytedance/trae/login/api/AccountStatus;
    const-string v4, ""
    sget-object v5, Lcom/bytedance/trae/login/api/LoginPlatform;->ENTERPRISE Lcom/bytedance/trae/login/api/LoginPlatform;
    invoke-virtual v1, v2, v4, v5, Lcom/bytedance/trae/login/service/AccountHelper;->loginStatusChanged(Lcom/bytedance/trae/login/api/AccountStatus; Ljava/lang/String; Lcom/bytedance/trae/login/api/LoginPlatform;)V
    sget-object v1, Lcom/bytedance/trae/login/enterprise/EnterprisePassportLogin;->INSTANCE Lcom/bytedance/trae/login/enterprise/EnterprisePassportLogin;
    new-instance v2, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager$completeTokenFlow$2;
    invoke-direct v2, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager$completeTokenFlow$2;-><init>()V
    check-cast v2, Lcom/bytedance/trae/login/enterprise/EnterprisePassportLogin$Callback;
    invoke-virtual v1, v3, v2, Lcom/bytedance/trae/login/enterprise/EnterprisePassportLogin;->login(Ljava/lang/String; Lcom/bytedance/trae/login/enterprise/EnterprisePassportLogin$Callback;)V
    return-void 
    new-instance v1, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthException;
    const-string v5, "exchange token is empty"
    sget-object v2, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v2, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v2
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->trae_enterprise_error_login_failed I
    invoke-virtual v2, v3, Landroid/app/Application;->getString(I)Ljava/lang/String;
    move-result-object v2
    invoke-static v2, v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v7, 0
    const-string v8, "exchangeToken"
    const/4 v9, 4
    const/4 v10, 0
    move-object v4, v1
    move-object v6, v2
    invoke-direct/range v4 ... v10, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthException;-><init>(Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    throw v1
    new-instance v1, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthException;
    const-string/jumbo v12, refreshToken is empty
    sget-object v2, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v2, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v2
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->trae_enterprise_error_login_failed I
    invoke-virtual v2, v3, Landroid/app/Application;->getString(I)Ljava/lang/String;
    move-result-object v13
    invoke-static v13, v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v14, 0
    const-string v15, "getRefreshToken"
    const/16 v16, 4
    const/16 v17, 0
    move-object v11, v1
    invoke-direct/range v11 ... v17, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthException;-><init>(Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    throw v1
.end method

.method private final doAccountLogin(java.lang.String  java.lang.String)kotlin.Pair
    .registers 22
    # ins_size=3
    move-object/from16 v1, v19
    sget-object v0, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginConfig;->INSTANCE Lcom/bytedance/trae/login/enterprise/EnterpriseLoginConfig;
    invoke-virtual v0, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginConfig;->getBaseUrl()Ljava/lang/String;
    move-result-object v6
    sget-object v2, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    const-string v3, "enterprise_auth"
    const-class v4, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthApi;
    const/4 v5, 0
    const/4 v7, 0
    const/4 v8, 0
    const/16 v9, 52
    const/4 v10, 0
    invoke-static/range v2 ... v10, Lcom/bytedance/trae/network/TraeHttpConnection;->createService$default(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; Ljava/lang/Class; Lcom/bytedance/retrofit2/Converter$Factory; Ljava/lang/String; Ljava/util/Map; Z I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthApi;
    new-instance v2, Lcom/bytedance/ttnet/http/RequestContext;
    invoke-direct v2, Lcom/bytedance/ttnet/http/RequestContext;-><init>()V
    const/4 v3, 1
    iput-boolean v3, v2, Lcom/bytedance/ttnet/http/RequestContext;->force_handle_response Z
    new-instance v4, Lcom/bytedance/trae/login/enterprise/EnterpriseAccountLoginRequest;
    move-object/from16 v5, v20
    move-object/from16 v6, v21
    invoke-direct v4, v5, v6, Lcom/bytedance/trae/login/enterprise/EnterpriseAccountLoginRequest;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    invoke-interface v0, v4, v2, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthApi;->accountLogin(Lcom/bytedance/trae/login/enterprise/EnterpriseAccountLoginRequest; Ljava/lang/Object;)Lcom/bytedance/retrofit2/Call;
    move-result-object v0
    invoke-interface v0, Lcom/bytedance/retrofit2/Call;->execute()Lcom/bytedance/retrofit2/SsResponse;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/retrofit2/SsResponse;->code()I
    invoke-virtual v0, Lcom/bytedance/retrofit2/SsResponse;->headers()Ljava/util/List;
    move-result-object v2
    const-string v4, "headers(...)"
    invoke-static v2, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v2, Ljava/lang/Iterable;
    new-instance v4, Ljava/util/ArrayList;
    invoke-direct v4, Ljava/util/ArrayList;-><init>()V
    check-cast v4, Ljava/util/Collection;
    invoke-interface v2, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v5
    if-eqz v5, +019h
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v5
    move-object v6, v5
    check-cast v6, Lcom/bytedance/retrofit2/client/Header;
    invoke-virtual v6, Lcom/bytedance/retrofit2/client/Header;->getName()Ljava/lang/String;
    move-result-object v6
    const-string v7, "Set-Cookie"
    invoke-static v6, v7, v3, Lkotlin/text/StringsKt;->equals(Ljava/lang/String; Ljava/lang/String; Z)Z
    move-result v6
    if-eqz v6, -017h
    invoke-interface v4, v5, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -1ch
    check-cast v4, Ljava/util/List;
    check-cast v4, Ljava/lang/Iterable;
    invoke-interface v4, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    const/4 v5, 0
    if-eqz v4, +01ch
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/retrofit2/client/Header;
    sget-object v6, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager;->INSTANCE Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager;
    invoke-virtual v4, Lcom/bytedance/retrofit2/client/Header;->getValue()Ljava/lang/String;
    move-result-object v4
    const-string v7, "getValue(...)"
    invoke-static v4, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v7, "X-Cloudide-Tob-Session"
    invoke-direct v6, v4, v7, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager;->extractCookieValue(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    if-eqz v4, -01eh
    goto +2h
    move-object v4, v5
    invoke-virtual v0, Lcom/bytedance/retrofit2/SsResponse;->body()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/String;
    if-nez v2, +042h
    invoke-virtual v0, Lcom/bytedance/retrofit2/SsResponse;->errorBody()Lcom/bytedance/retrofit2/mime/TypedInput;
    move-result-object v0
    if-eqz v0, +03bh
    invoke-interface v0, Lcom/bytedance/retrofit2/mime/TypedInput;->in()Ljava/io/InputStream;
    move-result-object v0
    const-string v2, "in(...)"
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v2, Lkotlin/text/Charsets;->UTF_8 Ljava/nio/charset/Charset;
    new-instance v6, Ljava/io/InputStreamReader;
    invoke-direct v6, v0, v2, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream; Ljava/nio/charset/Charset;)V
    check-cast v6, Ljava/io/Reader;
    instance-of v0, v6, Ljava/io/BufferedReader;
    if-eqz v0, +005h
    check-cast v6, Ljava/io/BufferedReader;
    goto +9h
    new-instance v0, Ljava/io/BufferedReader;
    const/16 v2, 8192
    invoke-direct v0, v6, v2, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader; I)V
    move-object v6, v0
    check-cast v6, Ljava/io/Closeable;
    move-object v0, v6
    check-cast v0, Ljava/io/BufferedReader;
    check-cast v0, Ljava/io/Reader;
    invoke-static v0, Lkotlin/io/TextStreamsKt;->readText(Ljava/io/Reader;)Ljava/lang/String;
    move-result-object v2
    invoke-static v6, v5, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    goto +bh
    move-exception v0
    move-object v2, v0
    throw v2
    move-exception v0
    move-object v3, v0
    invoke-static v6, v2, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    throw v3
    move-object v2, v5
    const-string v0, "getString(...)"
    if-eqz v2, +08bh
    const-class v6, Lcom/bytedance/trae/login/enterprise/EnterpriseAccountLoginResult;
    invoke-direct v1, v2, v6, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager;->parseEnterpriseResponse(Ljava/lang/String; Ljava/lang/Class;)Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;->getCode()I
    move-result v6
    if-eqz v6, +054h
    invoke-virtual v2, Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;->getCode()I
    move-result v4
    invoke-direct v1, v4, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager;->mapErrorCodeToMessage(I)Ljava/lang/String;
    move-result-object v4
    if-nez v4, +02ah
    invoke-virtual v2, Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;->getMessage()Ljava/lang/String;
    move-result-object v4
    if-eqz v4, +010h
    move-object v6, v4
    check-cast v6, Ljava/lang/CharSequence;
    invoke-interface v6, Ljava/lang/CharSequence;->length()I
    move-result v6
    if-lez v6, +003h
    goto +2h
    const/4 v3, 0
    if-eqz v3, +003h
    move-object v5, v4
    if-nez v5, +012h
    sget-object v3, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v3
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->trae_enterprise_error_login_failed I
    invoke-virtual v3, v4, Landroid/app/Application;->getString(I)Ljava/lang/String;
    move-result-object v4
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto +3h
    move-object v7, v5
    goto +2h
    move-object v7, v4
    new-instance v0, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthException;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "accountLogin business error: code="
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;->getCode()I
    move-result v2
    invoke-virtual v3, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    const/4 v8, 0
    const/4 v9, 0
    const/16 v10, 12
    const/4 v11, 0
    move-object v5, v0
    invoke-direct/range v5 ... v11, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthException;-><init>(Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    throw v0
    invoke-virtual v2, Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;->getData()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/login/enterprise/EnterpriseAccountLoginResult;
    if-eqz v2, +008h
    new-instance v0, Lkotlin/Pair;
    invoke-direct v0, v2, v4, Lkotlin/Pair;-><init>(Ljava/lang/Object; Ljava/lang/Object;)V
    return-object v0
    new-instance v2, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthException;
    const-string v6, "accountLogin data is null"
    sget-object v3, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v3
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->trae_enterprise_error_login_failed I
    invoke-virtual v3, v4, Landroid/app/Application;->getString(I)Ljava/lang/String;
    move-result-object v7
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v8, 0
    const/4 v9, 0
    const/16 v10, 12
    const/4 v11, 0
    move-object v5, v2
    invoke-direct/range v5 ... v11, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthException;-><init>(Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    throw v2
    new-instance v2, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthException;
    const-string v13, "accountLogin response body is null"
    sget-object v3, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v3
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->trae_enterprise_error_login_failed I
    invoke-virtual v3, v4, Landroid/app/Application;->getString(I)Ljava/lang/String;
    move-result-object v14
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 12
    const/16 v18, 0
    move-object v12, v2
    invoke-direct/range v12 ... v18, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthException;-><init>(Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    throw v2
    :try_start_0xc4
    :try_start_0xd3
.end method

.method private final doExchangeToken(java.lang.String)com.bytedance.trae.login.enterprise.EnterpriseExchangeTokenResult
    .registers 19
    # ins_size=2
    move-object/from16 v1, v17
    sget-object v0, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginConfig;->INSTANCE Lcom/bytedance/trae/login/enterprise/EnterpriseLoginConfig;
    invoke-virtual v0, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginConfig;->getBaseUrl()Ljava/lang/String;
    move-result-object v6
    sget-object v2, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    const-string v3, "enterprise_auth"
    const-class v4, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthApi;
    const/4 v5, 0
    const/4 v7, 0
    const/4 v8, 0
    const/16 v9, 52
    const/4 v10, 0
    invoke-static/range v2 ... v10, Lcom/bytedance/trae/network/TraeHttpConnection;->createService$default(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; Ljava/lang/Class; Lcom/bytedance/retrofit2/Converter$Factory; Ljava/lang/String; Ljava/util/Map; Z I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthApi;
    new-instance v2, Lcom/bytedance/ttnet/http/RequestContext;
    invoke-direct v2, Lcom/bytedance/ttnet/http/RequestContext;-><init>()V
    const/4 v3, 1
    iput-boolean v3, v2, Lcom/bytedance/ttnet/http/RequestContext;->force_handle_response Z
    new-instance v4, Lcom/bytedance/trae/login/enterprise/EnterpriseExchangeTokenRequest;
    move-object/from16 v5, v18
    invoke-direct v4, v5, Lcom/bytedance/trae/login/enterprise/EnterpriseExchangeTokenRequest;-><init>(Ljava/lang/String;)V
    invoke-interface v0, v4, v2, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthApi;->exchangeToken(Lcom/bytedance/trae/login/enterprise/EnterpriseExchangeTokenRequest; Ljava/lang/Object;)Lcom/bytedance/retrofit2/Call;
    move-result-object v0
    invoke-interface v0, Lcom/bytedance/retrofit2/Call;->execute()Lcom/bytedance/retrofit2/SsResponse;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/retrofit2/SsResponse;->body()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/String;
    const/4 v4, 0
    if-nez v2, +042h
    invoke-virtual v0, Lcom/bytedance/retrofit2/SsResponse;->errorBody()Lcom/bytedance/retrofit2/mime/TypedInput;
    move-result-object v0
    if-eqz v0, +03bh
    invoke-interface v0, Lcom/bytedance/retrofit2/mime/TypedInput;->in()Ljava/io/InputStream;
    move-result-object v0
    const-string v2, "in(...)"
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v2, Lkotlin/text/Charsets;->UTF_8 Ljava/nio/charset/Charset;
    new-instance v5, Ljava/io/InputStreamReader;
    invoke-direct v5, v0, v2, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream; Ljava/nio/charset/Charset;)V
    check-cast v5, Ljava/io/Reader;
    instance-of v0, v5, Ljava/io/BufferedReader;
    if-eqz v0, +005h
    check-cast v5, Ljava/io/BufferedReader;
    goto +9h
    new-instance v0, Ljava/io/BufferedReader;
    const/16 v2, 8192
    invoke-direct v0, v5, v2, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader; I)V
    move-object v5, v0
    check-cast v5, Ljava/io/Closeable;
    move-object v0, v5
    check-cast v0, Ljava/io/BufferedReader;
    check-cast v0, Ljava/io/Reader;
    invoke-static v0, Lkotlin/io/TextStreamsKt;->readText(Ljava/io/Reader;)Ljava/lang/String;
    move-result-object v2
    invoke-static v5, v4, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    goto +bh
    move-exception v0
    move-object v2, v0
    throw v2
    move-exception v0
    move-object v3, v0
    invoke-static v5, v2, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    throw v3
    move-object v2, v4
    const-string v0, "getString(...)"
    if-eqz v2, +089h
    const-class v5, Lcom/bytedance/trae/login/enterprise/EnterpriseExchangeTokenResult;
    invoke-direct v1, v2, v5, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager;->parseEnterpriseResponse(Ljava/lang/String; Ljava/lang/Class;)Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;->getCode()I
    move-result v5
    if-eqz v5, +057h
    invoke-virtual v2, Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;->getCode()I
    move-result v5
    invoke-direct v1, v5, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager;->mapErrorCodeToMessage(I)Ljava/lang/String;
    move-result-object v5
    if-nez v5, +02ah
    invoke-virtual v2, Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;->getMessage()Ljava/lang/String;
    move-result-object v5
    if-eqz v5, +010h
    move-object v6, v5
    check-cast v6, Ljava/lang/CharSequence;
    invoke-interface v6, Ljava/lang/CharSequence;->length()I
    move-result v6
    if-lez v6, +003h
    goto +2h
    const/4 v3, 0
    if-eqz v3, +003h
    move-object v4, v5
    if-nez v4, +012h
    sget-object v3, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v3
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->trae_enterprise_error_login_failed I
    invoke-virtual v3, v4, Landroid/app/Application;->getString(I)Ljava/lang/String;
    move-result-object v5
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto +3h
    move-object v8, v4
    goto +2h
    move-object v8, v5
    new-instance v0, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthException;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "exchangeToken business error: code="
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;->getCode()I
    move-result v4
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v2, Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;->getCode()I
    move-result v9
    const/4 v10, 0
    const/16 v11, 8
    const/4 v12, 0
    move-object v6, v0
    invoke-direct/range v6 ... v12, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthException;-><init>(Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    throw v0
    invoke-virtual v2, Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;->getData()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/login/enterprise/EnterpriseExchangeTokenResult;
    if-eqz v2, +003h
    return-object v2
    new-instance v2, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthException;
    const-string v4, "exchangeToken data is null"
    sget-object v3, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v3
    sget v5, Lcom/bytedance/trae/multilanguage/R$string;->trae_enterprise_error_login_failed I
    invoke-virtual v3, v5, Landroid/app/Application;->getString(I)Ljava/lang/String;
    move-result-object v5
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v6, 0
    const/4 v7, 0
    const/16 v8, 12
    const/4 v9, 0
    move-object v3, v2
    invoke-direct/range v3 ... v9, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthException;-><init>(Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    throw v2
    new-instance v2, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthException;
    const-string v11, "exchangeToken response body is null"
    sget-object v3, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v3
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->trae_enterprise_error_login_failed I
    invoke-virtual v3, v4, Landroid/app/Application;->getString(I)Ljava/lang/String;
    move-result-object v12
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v13, 0
    const/4 v14, 0
    const/16 v15, 12
    const/16 v16, 0
    move-object v10, v2
    invoke-direct/range v10 ... v16, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthException;-><init>(Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    throw v2
    :try_start_0x63
    :try_start_0x72
.end method

.method private final doGetRefreshToken(java.lang.String)com.bytedance.trae.login.enterprise.EnterpriseGetRefreshTokenResult
    .registers 19
    # ins_size=2
    move-object/from16 v1, v17
    move-object/from16 v0, v18
    sget-object v2, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginConfig;->INSTANCE Lcom/bytedance/trae/login/enterprise/EnterpriseLoginConfig;
    invoke-virtual v2, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginConfig;->getBaseUrl()Ljava/lang/String;
    move-result-object v7
    const/4 v2, 2
    new-array v3, v2, [Lkotlin/Pair;
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v5, "X-Cloudide-Tob-Session="
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    const-string v5, "Cookie"
    invoke-static v5, v4, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v4
    const/4 v12, 0
    aput-object v4, v3, v12
    const-string v4, "X-Cloudide-Tob-Session"
    invoke-static v4, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/4 v13, 1
    aput-object v0, v3, v13
    invoke-static v3, Lkotlin/collections/MapsKt;->mapOf([Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v8
    sget-object v3, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    const-string v4, "enterprise_auth"
    const-class v5, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthApi;
    const/4 v6, 0
    const/4 v9, 0
    const/16 v10, 36
    const/4 v11, 0
    invoke-static/range v3 ... v11, Lcom/bytedance/trae/network/TraeHttpConnection;->createService$default(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; Ljava/lang/Class; Lcom/bytedance/retrofit2/Converter$Factory; Ljava/lang/String; Ljava/util/Map; Z I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthApi;
    new-instance v3, Lcom/bytedance/ttnet/http/RequestContext;
    invoke-direct v3, Lcom/bytedance/ttnet/http/RequestContext;-><init>()V
    iput-boolean v13, v3, Lcom/bytedance/ttnet/http/RequestContext;->force_handle_response Z
    sget-object v4, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v4, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getDeviceId()Ljava/lang/String;
    move-result-object v4
    move-object v5, v4
    check-cast v5, Ljava/lang/CharSequence;
    invoke-static v5, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v5
    xor-int/2addr v5, v13
    const/4 v6, 0
    if-eqz v5, +003h
    goto +2h
    move-object v4, v6
    if-nez v4, +024h
    sget-object v4, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v4, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getClientDid()Ljava/lang/String;
    move-result-object v4
    move-object v5, v4
    check-cast v5, Ljava/lang/CharSequence;
    invoke-static v5, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v5
    xor-int/2addr v5, v13
    if-eqz v5, +003h
    goto +2h
    move-object v4, v6
    if-nez v4, +010h
    invoke-static Ljava/util/UUID;->randomUUID()Ljava/util/UUID;
    move-result-object v4
    invoke-virtual v4, Ljava/util/UUID;->toString()Ljava/lang/String;
    move-result-object v4
    const-string/jumbo v5, toString(...)
    invoke-static v4, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v5, Lcom/bytedance/trae/login/enterprise/EnterpriseGetRefreshTokenRequest;
    invoke-direct v5, v4, v12, v2, v6, Lcom/bytedance/trae/login/enterprise/EnterpriseGetRefreshTokenRequest;-><init>(Ljava/lang/String; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v5, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthApi;->getRefreshToken(Lcom/bytedance/trae/login/enterprise/EnterpriseGetRefreshTokenRequest; Ljava/lang/Object;)Lcom/bytedance/retrofit2/Call;
    move-result-object v0
    invoke-interface v0, Lcom/bytedance/retrofit2/Call;->execute()Lcom/bytedance/retrofit2/SsResponse;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/retrofit2/SsResponse;->body()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/String;
    if-nez v2, +042h
    invoke-virtual v0, Lcom/bytedance/retrofit2/SsResponse;->errorBody()Lcom/bytedance/retrofit2/mime/TypedInput;
    move-result-object v0
    if-eqz v0, +03bh
    invoke-interface v0, Lcom/bytedance/retrofit2/mime/TypedInput;->in()Ljava/io/InputStream;
    move-result-object v0
    const-string v2, "in(...)"
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v2, Lkotlin/text/Charsets;->UTF_8 Ljava/nio/charset/Charset;
    new-instance v3, Ljava/io/InputStreamReader;
    invoke-direct v3, v0, v2, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream; Ljava/nio/charset/Charset;)V
    check-cast v3, Ljava/io/Reader;
    instance-of v0, v3, Ljava/io/BufferedReader;
    if-eqz v0, +005h
    check-cast v3, Ljava/io/BufferedReader;
    goto +9h
    new-instance v0, Ljava/io/BufferedReader;
    const/16 v2, 8192
    invoke-direct v0, v3, v2, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader; I)V
    move-object v3, v0
    check-cast v3, Ljava/io/Closeable;
    move-object v0, v3
    check-cast v0, Ljava/io/BufferedReader;
    check-cast v0, Ljava/io/Reader;
    invoke-static v0, Lkotlin/io/TextStreamsKt;->readText(Ljava/io/Reader;)Ljava/lang/String;
    move-result-object v2
    invoke-static v3, v6, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    goto +bh
    move-exception v0
    move-object v2, v0
    throw v2
    move-exception v0
    move-object v4, v0
    invoke-static v3, v2, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    throw v4
    move-object v2, v6
    const-string v0, "getString(...)"
    if-eqz v2, +082h
    const-class v3, Lcom/bytedance/trae/login/enterprise/EnterpriseGetRefreshTokenResult;
    invoke-direct v1, v2, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager;->parseEnterpriseResponse(Ljava/lang/String; Ljava/lang/Class;)Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;->getCode()I
    move-result v3
    if-eqz v3, +050h
    invoke-virtual v2, Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;->getCode()I
    move-result v3
    invoke-direct v1, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager;->mapErrorCodeToMessage(I)Ljava/lang/String;
    move-result-object v3
    if-nez v3, +026h
    invoke-virtual v2, Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;->getMessage()Ljava/lang/String;
    move-result-object v3
    if-eqz v3, +00fh
    move-object v4, v3
    check-cast v4, Ljava/lang/CharSequence;
    invoke-interface v4, Ljava/lang/CharSequence;->length()I
    move-result v4
    if-lez v4, +003h
    move v12, v13
    if-eqz v12, +003h
    move-object v6, v3
    if-nez v6, +012h
    sget-object v3, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v3
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->trae_enterprise_error_login_failed I
    invoke-virtual v3, v4, Landroid/app/Application;->getString(I)Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v6, v3
    new-instance v0, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthException;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "getRefreshToken business error: code="
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;->getCode()I
    move-result v2
    invoke-virtual v3, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    const/4 v7, 0
    const/4 v8, 0
    const/16 v9, 12
    const/4 v10, 0
    move-object v4, v0
    invoke-direct/range v4 ... v10, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthException;-><init>(Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    throw v0
    invoke-virtual v2, Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;->getData()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/login/enterprise/EnterpriseGetRefreshTokenResult;
    if-eqz v2, +003h
    return-object v2
    new-instance v2, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthException;
    const-string v4, "getRefreshToken data is null"
    sget-object v3, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v3
    sget v5, Lcom/bytedance/trae/multilanguage/R$string;->trae_enterprise_error_login_failed I
    invoke-virtual v3, v5, Landroid/app/Application;->getString(I)Ljava/lang/String;
    move-result-object v5
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v6, 0
    const/4 v7, 0
    const/16 v8, 12
    const/4 v9, 0
    move-object v3, v2
    invoke-direct/range v3 ... v9, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthException;-><init>(Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    throw v2
    new-instance v2, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthException;
    const-string v11, "getRefreshToken response body is null"
    sget-object v3, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v3
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->trae_enterprise_error_login_failed I
    invoke-virtual v3, v4, Landroid/app/Application;->getString(I)Ljava/lang/String;
    move-result-object v12
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v13, 0
    const/4 v14, 0
    const/16 v15, 12
    const/16 v16, 0
    move-object v10, v2
    invoke-direct/range v10 ... v16, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthException;-><init>(Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    throw v2
    :try_start_0xbf
    :try_start_0xce
.end method

.method private final exchangeTokenForRefresh(java.lang.String)com.bytedance.trae.login.traeauth.TraeExchangeTokenResult
    .registers 14
    # ins_size=2
    invoke-direct v12, v13, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager;->doExchangeToken(Ljava/lang/String;)Lcom/bytedance/trae/login/enterprise/EnterpriseExchangeTokenResult;
    move-result-object v13
    invoke-virtual v13, Lcom/bytedance/trae/login/enterprise/EnterpriseExchangeTokenResult;->getToken()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +003h
    goto +3h
    const/4 v0, 0
    goto +2h
    const/4 v0, 1
    if-nez v0, +023h
    new-instance v0, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;
    const/4 v2, 0
    const/4 v3, 0
    invoke-virtual v13, Lcom/bytedance/trae/login/enterprise/EnterpriseExchangeTokenResult;->getToken()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v13, Lcom/bytedance/trae/login/enterprise/EnterpriseExchangeTokenResult;->getTokenExpireAt()Ljava/lang/Long;
    move-result-object v5
    invoke-virtual v13, Lcom/bytedance/trae/login/enterprise/EnterpriseExchangeTokenResult;->getRefreshToken()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v13, Lcom/bytedance/trae/login/enterprise/EnterpriseExchangeTokenResult;->getRefreshExpireAt()Ljava/lang/Long;
    move-result-object v7
    invoke-virtual v13, Lcom/bytedance/trae/login/enterprise/EnterpriseExchangeTokenResult;->getTokenExpireDuration()Ljava/lang/Long;
    move-result-object v8
    const/4 v9, 0
    const/16 v10, 131
    const/4 v11, 0
    move-object v1, v0
    invoke-direct/range v1 ... v11, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;-><init>(Ljava/lang/Boolean; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v0
    new-instance v13, Lcom/bytedance/trae/login/traeauth/TraeAuthException;
    const/4 v1, 0
    const-string v2, "exchangeTokenForRefresh returned empty token"
    const/4 v3, 1
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/16 v9, 248
    const/4 v10, 0
    move-object v0, v13
    invoke-direct/range v0 ... v10, Lcom/bytedance/trae/login/traeauth/TraeAuthException;-><init>(Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/Throwable; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    throw v13
    move-exception v13
    new-instance v11, Lcom/bytedance/trae/login/traeauth/TraeAuthException;
    const/4 v1, 0
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v2, "exchangeTokenForRefresh network error: "
    invoke-direct v0, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v13, Ljava/lang/Exception;->getMessage()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    const/4 v3, 0
    move-object v4, v13
    check-cast v4, Ljava/lang/Throwable;
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/16 v9, 240
    const/4 v10, 0
    move-object v0, v11
    invoke-direct/range v0 ... v10, Lcom/bytedance/trae/login/traeauth/TraeAuthException;-><init>(Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/Throwable; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    throw v11
    move-exception v13
    throw v13
    move-exception v13
    invoke-virtual v13, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthException;->getErrorCode()I
    move-result v0
    invoke-direct v12, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager;->mapEnterpriseCodeToAuthCode(I)Ljava/lang/String;
    move-result-object v2
    new-instance v0, Lcom/bytedance/trae/login/traeauth/TraeAuthException;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v3, "exchangeTokenForRefresh: "
    invoke-direct v1, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v13, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthException;->getMessage()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    const/4 v4, 0
    const/4 v5, 0
    invoke-virtual v13, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthException;->getUserMessage()Ljava/lang/String;
    move-result-object v6
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/16 v10, 232
    const/4 v11, 0
    move-object v1, v0
    invoke-direct/range v1 ... v11, Lcom/bytedance/trae/login/traeauth/TraeAuthException;-><init>(Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/Throwable; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    throw v0
    :try_start_0x0
.end method

.method private final extractCookieValue(java.lang.String  java.lang.String)java.lang.String
    .registers 9
    # ins_size=3
    move-object v0, v7
    check-cast v0, Ljava/lang/CharSequence;
    const-string v7, ";"
    filled-new-array v7, [Ljava/lang/String;
    move-result-object v1
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 6
    const/4 v5, 0
    invoke-static/range v0 ... v5, Lkotlin/text/StringsKt;->split$default(Ljava/lang/CharSequence; [Ljava/lang/String; Z I I Ljava/lang/Object;)Ljava/util/List;
    move-result-object v7
    invoke-interface v7, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v7
    invoke-interface v7, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +035h
    invoke-interface v7, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/String;
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v0
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct v1, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v1, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const/16 v2, 61
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    const/4 v2, 1
    invoke-static v0, v1, v2, Lkotlin/text/StringsKt;->startsWith(Ljava/lang/String; Ljava/lang/String; Z)Z
    move-result v1
    if-eqz v1, -02eh
    const-string v7, "="
    const-string v8, ""
    invoke-static v0, v7, v8, Lkotlin/text/StringsKt;->substringAfter(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v7
    return-object v7
    const/4 v7, 0
    return-object v7
.end method

.method private final fetchUserInfo(java.lang.String)com.bytedance.trae.login.enterprise.EnterpriseGetUserInfoData
    .registers 15
    # ins_size=2
    const-string v0, "EnterpriseAuthManager"
    const-string v1, "getUserInfo: business error code="
    const/4 v2, 0
    sget-object v3, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginConfig;->INSTANCE Lcom/bytedance/trae/login/enterprise/EnterpriseLoginConfig;
    invoke-virtual v3, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginConfig;->getBaseUrl()Ljava/lang/String;
    move-result-object v8
    sget-object v4, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    const-string v5, "enterprise_auth"
    const-class v6, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthApi;
    const/4 v7, 0
    const-string/jumbo v3, x-cloudide-token
    invoke-static v3, v14, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v14
    invoke-static v14, Lkotlin/collections/MapsKt;->mapOf(Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v9
    const/4 v10, 0
    const/16 v11, 36
    const/4 v12, 0
    invoke-static/range v4 ... v12, Lcom/bytedance/trae/network/TraeHttpConnection;->createService$default(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; Ljava/lang/Class; Lcom/bytedance/retrofit2/Converter$Factory; Ljava/lang/String; Ljava/util/Map; Z I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v14
    check-cast v14, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthApi;
    new-instance v3, Lcom/bytedance/ttnet/http/RequestContext;
    invoke-direct v3, Lcom/bytedance/ttnet/http/RequestContext;-><init>()V
    const/4 v4, 1
    iput-boolean v4, v3, Lcom/bytedance/ttnet/http/RequestContext;->force_handle_response Z
    invoke-interface v14, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthApi;->getUserInfo(Ljava/lang/Object;)Lcom/bytedance/retrofit2/Call;
    move-result-object v14
    invoke-interface v14, Lcom/bytedance/retrofit2/Call;->execute()Lcom/bytedance/retrofit2/SsResponse;
    move-result-object v14
    invoke-virtual v14, Lcom/bytedance/retrofit2/SsResponse;->body()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Ljava/lang/String;
    if-nez v3, +040h
    invoke-virtual v14, Lcom/bytedance/retrofit2/SsResponse;->errorBody()Lcom/bytedance/retrofit2/mime/TypedInput;
    move-result-object v14
    if-eqz v14, +039h
    invoke-interface v14, Lcom/bytedance/retrofit2/mime/TypedInput;->in()Ljava/io/InputStream;
    move-result-object v14
    const-string v3, "in(...)"
    invoke-static v14, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v3, Lkotlin/text/Charsets;->UTF_8 Ljava/nio/charset/Charset;
    new-instance v4, Ljava/io/InputStreamReader;
    invoke-direct v4, v14, v3, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream; Ljava/nio/charset/Charset;)V
    check-cast v4, Ljava/io/Reader;
    instance-of v14, v4, Ljava/io/BufferedReader;
    if-eqz v14, +005h
    check-cast v4, Ljava/io/BufferedReader;
    goto +9h
    new-instance v14, Ljava/io/BufferedReader;
    const/16 v3, 8192
    invoke-direct v14, v4, v3, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader; I)V
    move-object v4, v14
    check-cast v4, Ljava/io/Closeable;
    move-object v14, v4
    check-cast v14, Ljava/io/BufferedReader;
    check-cast v14, Ljava/io/Reader;
    invoke-static v14, Lkotlin/io/TextStreamsKt;->readText(Ljava/io/Reader;)Ljava/lang/String;
    move-result-object v3
    invoke-static v4, v2, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    goto +9h
    move-exception v14
    throw v14
    move-exception v1
    invoke-static v4, v14, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    throw v1
    move-object v3, v2
    if-nez v3, +00ah
    sget-object v14, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v1, "getUserInfo: response body is null"
    invoke-virtual v14, v0, v1, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    return-object v2
    const-class v14, Lcom/bytedance/trae/login/enterprise/EnterpriseGetUserInfoData;
    invoke-direct v13, v3, v14, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager;->parseEnterpriseResponse(Ljava/lang/String; Ljava/lang/Class;)Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;
    move-result-object v14
    invoke-virtual v14, Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;->getCode()I
    move-result v3
    if-eqz v3, +019h
    sget-object v3, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v4, Ljava/lang/StringBuilder;
    invoke-direct v4, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v14, Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;->getCode()I
    move-result v14
    invoke-virtual v4, v14, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v14
    invoke-virtual v14, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v14
    invoke-virtual v3, v0, v14, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    return-object v2
    invoke-virtual v14, Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;->getData()Ljava/lang/Object;
    move-result-object v14
    check-cast v14, Lcom/bytedance/trae/login/enterprise/EnterpriseGetUserInfoData;
    move-object v2, v14
    goto +1ah
    move-exception v14
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "getUserInfo failed (degraded): "
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v14, Ljava/lang/Exception;->getMessage()Ljava/lang/String;
    move-result-object v14
    invoke-virtual v3, v14, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v14
    invoke-virtual v14, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v14
    invoke-virtual v1, v0, v14, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    return-object v2
    :try_start_0x5
    :try_start_0x68
    :try_start_0x71
    :try_start_0x76
    :try_start_0x78
.end method

.method private final mapEnterpriseCodeToAuthCode(int)java.lang.String
    .registers 3
    # ins_size=2
    const/16 v0, 30011
    if-eq v2, v0, +00fh
    const/16 v0, 30021
    if-eq v2, v0, +008h
    const/16 v0, 30022
    if-eq v2, v0, +004h
    const/4 v2, 0
    goto +6h
    const-string v2, "20311"
    goto +3h
    const-string v2, "20101"
    return-object v2
.end method

.method private final mapErrorCodeToMessage(int)java.lang.String
    .registers 3
    # ins_size=2
    const/16 v0, 2001
    if-eq v2, v0, +08bh
    const/16 v0, 30001
    if-eq v2, v0, +084h
    const/16 v0, 30003
    if-eq v2, v0, +07dh
    const/16 v0, 30036
    if-eq v2, v0, +076h
    const/16 v0, 30040
    if-eq v2, v0, +06fh
    const/16 v0, 30048
    if-eq v2, v0, +06bh
    const/16 v0, 30015
    if-eq v2, v0, +064h
    const/16 v0, 30016
    if-eq v2, v0, +05dh
    const/16 v0, 30024
    if-eq v2, v0, +056h
    const/16 v0, 30025
    if-eq v2, v0, +04fh
    const/16 v0, 30028
    if-eq v2, v0, +048h
    const/16 v0, 30029
    if-eq v2, v0, +041h
    const/16 v0, 30031
    if-eq v2, v0, +03ah
    const/16 v0, 30032
    if-eq v2, v0, +033h
    packed-switch v2, +0000062h
    packed-switch v2, +0000075h
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->trae_enterprise_error_service I
    goto/16 +04fh
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->trae_enterprise_error_token_expired I
    goto +4bh
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->trae_enterprise_error_token_invalid I
    goto +48h
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->trae_enterprise_error_sso_account_not_exist I
    goto +45h
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->trae_enterprise_error_password_invalid I
    goto +42h
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->trae_enterprise_error_subscription_expired I
    goto +3fh
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->trae_enterprise_error_use_sso I
    goto +3ch
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->trae_enterprise_error_not_login I
    goto +39h
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->trae_enterprise_error_session_expired I
    goto +36h
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->trae_enterprise_error_account_status I
    goto +33h
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->trae_enterprise_error_account_belong_other I
    goto +30h
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->trae_enterprise_error_account_not_exist I
    goto +2dh
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->trae_enterprise_error_code_invalid I
    goto +2ah
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->trae_enterprise_error_code_invalid_or_expired I
    goto +27h
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->trae_enterprise_error_account_not_active I
    goto +24h
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->trae_enterprise_error_sso_email_not_match I
    goto +21h
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->trae_enterprise_error_link_expired I
    goto +1eh
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->trae_enterprise_error_sso_not_enabled I
    goto +1bh
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->trae_enterprise_error_code_expired I
    goto +18h
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->trae_enterprise_error_code_invalid I
    goto +15h
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->trae_enterprise_error_subscription_expired I
    goto +12h
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->trae_enterprise_error_password_not_match I
    goto +fh
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->trae_enterprise_error_email_rate_limit I
    goto +ch
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->trae_enterprise_error_too_many_attempts I
    goto +9h
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->trae_enterprise_error_seat_over_limit I
    goto +6h
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->trae_enterprise_error_email_registered I
    goto +3h
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->trae_enterprise_error_service I
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v0
    invoke-virtual v0, v2, Landroid/app/Application;->getString(I)Ljava/lang/String;
    move-result-object v2
    return-object v2
    packed-switch-payload 7535 7536 7537 7538 7539 753a 753b 753c 753d
    packed-switch-payload 7543 7544 7545 7546
.end method

.method private final parseEnterpriseResponse(java.lang.String  java.lang.Class)com.bytedance.trae.login.enterprise.EnterpriseResponse
    .registers 6
    # ins_size=3
    const-class v0, Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;
    check-cast v0, Ljava/lang/reflect/Type;
    const/4 v1, 1
    new-array v1, v1, [Ljava/lang/reflect/Type;
    const/4 v2, 0
    aput-object v5, v1, v2
    invoke-static v0, v1, Lcom/google/gson/reflect/TypeToken;->getParameterized(Ljava/lang/reflect/Type; [Ljava/lang/reflect/Type;)Lcom/google/gson/reflect/TypeToken;
    move-result-object v5
    invoke-virtual v5, Lcom/google/gson/reflect/TypeToken;->getType()Ljava/lang/reflect/Type;
    move-result-object v5
    sget-object v0, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    invoke-virtual v0, Lcom/bytedance/trae/network/TraeHttpConnection;->getHttpGson()Lcom/google/gson/Gson;
    move-result-object v0
    invoke-virtual v0, v4, v5, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String; Ljava/lang/reflect/Type;)Ljava/lang/Object;
    move-result-object v4
    const-string v5, "fromJson(...)"
    invoke-static v4, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v4, Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;
    return-object v4
.end method

.method private final refreshEnterpriseUserInfo(java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 4
    # ins_size=3
    sget-object v3, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;
    invoke-virtual v3, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->getUserInfo()Lcom/bytedance/trae/login/user/UserInfo;
    move-result-object v3
    invoke-direct v1, v2, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager;->fetchUserInfo(Ljava/lang/String;)Lcom/bytedance/trae/login/enterprise/EnterpriseGetUserInfoData;
    move-result-object v2
    const/4 v0, 0
    if-nez v2, +003h
    return-object v0
    if-eqz v3, +006h
    invoke-virtual v3, Lcom/bytedance/trae/login/user/UserInfo;->getEmail()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +004h
    const-string v0, ""
    invoke-direct v1, v0, v2, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager;->buildUserInfo(Ljava/lang/String; Lcom/bytedance/trae/login/enterprise/EnterpriseGetUserInfoData;)Lcom/bytedance/trae/login/user/UserInfo;
    move-result-object v2
    sget-object v3, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;
    invoke-virtual v3, v2, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->saveUserInfo(Lcom/bytedance/trae/login/user/UserInfo;)V
    invoke-direct v1, v2, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager;->toAccountInfo(Lcom/bytedance/trae/login/user/UserInfo;)Lcom/bytedance/trae/login/api/AccountInfo;
    move-result-object v2
    return-object v2
.end method

.method private final toAccountInfo(com.bytedance.trae.login.user.UserInfo)com.bytedance.trae.login.api.AccountInfo
    .registers 21
    # ins_size=2
    new-instance v18, Lcom/bytedance/trae/login/api/AccountInfo;
    move-object/from16 v0, v18
    const/4 v1, 1
    const-string v2, "enterprise"
    invoke-virtual/range v20, Lcom/bytedance/trae/login/user/UserInfo;->getUserId()Ljava/lang/String;
    move-result-object v3
    const-string v4, ""
    const/4 v5, 0
    invoke-virtual/range v20, Lcom/bytedance/trae/login/user/UserInfo;->getAvatarUrl()Ljava/lang/String;
    move-result-object v6
    invoke-virtual/range v20, Lcom/bytedance/trae/login/user/UserInfo;->getScreenName()Ljava/lang/String;
    move-result-object v7
    invoke-virtual/range v20, Lcom/bytedance/trae/login/user/UserInfo;->getEmail()Ljava/lang/String;
    move-result-object v8
    const-string v9, ""
    invoke-virtual/range v20, Lcom/bytedance/trae/login/user/UserInfo;->getTenantId()Ljava/lang/String;
    move-result-object v10
    invoke-virtual/range v20, Lcom/bytedance/trae/login/user/UserInfo;->getAiRegion()Ljava/lang/String;
    move-result-object v11
    invoke-virtual/range v20, Lcom/bytedance/trae/login/user/UserInfo;->getProductType()I
    move-result v12
    const/4 v13, 0
    invoke-virtual/range v20, Lcom/bytedance/trae/login/user/UserInfo;->getTenantName()Ljava/lang/String;
    move-result-object v14
    invoke-virtual/range v20, Lcom/bytedance/trae/login/user/UserInfo;->getSaasPrivacyMode()Ljava/lang/Boolean;
    move-result-object v15
    const/16 v16, 4096
    const/16 v17, 0
    invoke-direct/range v0 ... v17, Lcom/bytedance/trae/login/api/AccountInfo;-><init>(Z Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Lcom/bytedance/trae/login/api/AccountType; Ljava/lang/String; Ljava/lang/Boolean; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v18
.end method

.method private final updateEnterpriseUserProfile(java.util.Map  kotlin.coroutines.Continuation)java.lang.Object
    .registers 20
    # ins_size=3
    const-string v1, "EnterpriseAuthManager"
    const-string/jumbo v0, setUserInfo business error: code=
    invoke-direct/range v17 ... v18, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager;->buildSetUserInfoRequest(Ljava/util/Map;)Lcom/bytedance/trae/login/enterprise/SetUserInfoRequest;
    move-result-object v2
    const/4 v3, 0
    if-nez v2, +007h
    invoke-static v3, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v0
    return-object v0
    sget-object v4, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;
    invoke-virtual v4, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->getJwtToken()Ljava/lang/String;
    move-result-object v4
    move-object v5, v4
    check-cast v5, Ljava/lang/CharSequence;
    invoke-static v5, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v5
    const/4 v6, 1
    xor-int/2addr v5, v6
    const/4 v7, 0
    if-eqz v5, +003h
    goto +2h
    move-object v4, v7
    if-nez v4, +007h
    invoke-static v3, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v0
    return-object v0
    sget-object v5, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginConfig;->INSTANCE Lcom/bytedance/trae/login/enterprise/EnterpriseLoginConfig;
    invoke-virtual v5, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginConfig;->getBaseUrl()Ljava/lang/String;
    move-result-object v12
    sget-object v8, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    const-string v9, "enterprise_auth"
    const-class v10, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthApi;
    const/4 v11, 0
    const-string v5, "X-Cloudide-Token"
    invoke-static v5, v4, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v4
    invoke-static v4, Lkotlin/collections/MapsKt;->mapOf(Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v13
    const/4 v14, 0
    const/16 v15, 36
    const/16 v16, 0
    invoke-static/range v8 ... v16, Lcom/bytedance/trae/network/TraeHttpConnection;->createService$default(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; Ljava/lang/Class; Lcom/bytedance/retrofit2/Converter$Factory; Ljava/lang/String; Ljava/util/Map; Z I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthApi;
    new-instance v5, Lcom/bytedance/ttnet/http/RequestContext;
    invoke-direct v5, Lcom/bytedance/ttnet/http/RequestContext;-><init>()V
    iput-boolean v6, v5, Lcom/bytedance/ttnet/http/RequestContext;->force_handle_response Z
    invoke-interface v4, v2, v5, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthApi;->setUserInfo(Lcom/bytedance/trae/login/enterprise/SetUserInfoRequest; Ljava/lang/Object;)Lcom/bytedance/retrofit2/Call;
    move-result-object v2
    invoke-interface v2, Lcom/bytedance/retrofit2/Call;->execute()Lcom/bytedance/retrofit2/SsResponse;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/retrofit2/SsResponse;->body()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Ljava/lang/String;
    if-nez v4, +042h
    invoke-virtual v2, Lcom/bytedance/retrofit2/SsResponse;->errorBody()Lcom/bytedance/retrofit2/mime/TypedInput;
    move-result-object v2
    if-eqz v2, +03dh
    invoke-interface v2, Lcom/bytedance/retrofit2/mime/TypedInput;->in()Ljava/io/InputStream;
    move-result-object v2
    const-string v4, "in(...)"
    invoke-static v2, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v4, Lkotlin/text/Charsets;->UTF_8 Ljava/nio/charset/Charset;
    new-instance v5, Ljava/io/InputStreamReader;
    invoke-direct v5, v2, v4, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream; Ljava/nio/charset/Charset;)V
    check-cast v5, Ljava/io/Reader;
    instance-of v2, v5, Ljava/io/BufferedReader;
    if-eqz v2, +005h
    check-cast v5, Ljava/io/BufferedReader;
    goto +9h
    new-instance v2, Ljava/io/BufferedReader;
    const/16 v4, 8192
    invoke-direct v2, v5, v4, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader; I)V
    move-object v5, v2
    check-cast v5, Ljava/io/Closeable;
    move-object v2, v5
    check-cast v2, Ljava/io/BufferedReader;
    check-cast v2, Ljava/io/Reader;
    invoke-static v2, Lkotlin/io/TextStreamsKt;->readText(Ljava/io/Reader;)Ljava/lang/String;
    move-result-object v2
    invoke-static v5, v7, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    move-object v7, v2
    goto +bh
    move-exception v0
    move-object v2, v0
    throw v2
    move-exception v0
    move-object v4, v0
    invoke-static v5, v2, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    throw v4
    move-object v7, v4
    if-nez v7, +00fh
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string/jumbo v2, setUserInfo response body is null
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    invoke-static v3, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v0
    return-object v0
    const-class v2, Ljava/lang/Object;
    move-object/from16 v4, v17
    invoke-direct v4, v7, v2, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager;->parseEnterpriseResponse(Ljava/lang/String; Ljava/lang/Class;)Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;->getCode()I
    move-result v5
    if-eqz v5, +02bh
    sget-object v5, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v6, Ljava/lang/StringBuilder;
    invoke-direct v6, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;->getCode()I
    move-result v0
    invoke-virtual v6, v0, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v6, ", message="
    invoke-virtual v0, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v2, Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;->getMessage()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v5, v1, v0, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    invoke-static v3, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v0
    return-object v0
    move v3, v6
    goto +1fh
    move-exception v0
    goto +4h
    move-exception v0
    move-object/from16 v4, v17
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v5, Ljava/lang/StringBuilder;
    const-string/jumbo v6, setUserInfo failed: 
    invoke-direct v5, v6, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, Ljava/lang/Exception;->getMessage()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v5, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v2, v1, v0, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    invoke-static v3, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v0
    return-object v0
    :try_start_0x55
    :try_start_0x8e
    :try_start_0x97
    :try_start_0x9e
    :try_start_0xa1
    :try_start_0xb9
.end method

.method public final checkLoginConfig(java.lang.String)com.bytedance.trae.login.enterprise.CheckLoginConfigResult
    .registers 19
    # ins_size=2
    move-object/from16 v1, v17
    move-object/from16 v0, v18
    const-string v2, "email"
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v2, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginConfig;->INSTANCE Lcom/bytedance/trae/login/enterprise/EnterpriseLoginConfig;
    invoke-virtual v2, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginConfig;->getBaseUrl()Ljava/lang/String;
    move-result-object v7
    sget-object v3, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    const-string v4, "enterprise_auth"
    const-class v5, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthApi;
    const/4 v6, 0
    const/4 v8, 0
    const/4 v9, 0
    const/16 v10, 52
    const/4 v11, 0
    invoke-static/range v3 ... v11, Lcom/bytedance/trae/network/TraeHttpConnection;->createService$default(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; Ljava/lang/Class; Lcom/bytedance/retrofit2/Converter$Factory; Ljava/lang/String; Ljava/util/Map; Z I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthApi;
    new-instance v3, Lcom/bytedance/ttnet/http/RequestContext;
    invoke-direct v3, Lcom/bytedance/ttnet/http/RequestContext;-><init>()V
    const/4 v4, 1
    iput-boolean v4, v3, Lcom/bytedance/ttnet/http/RequestContext;->force_handle_response Z
    new-instance v5, Lcom/bytedance/trae/login/enterprise/CheckLoginConfigRequest;
    const/4 v6, 0
    const/4 v7, 2
    invoke-direct v5, v0, v6, v7, v8, Lcom/bytedance/trae/login/enterprise/CheckLoginConfigRequest;-><init>(Ljava/lang/String; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v2, v5, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthApi;->checkLoginConfig(Lcom/bytedance/trae/login/enterprise/CheckLoginConfigRequest; Ljava/lang/Object;)Lcom/bytedance/retrofit2/Call;
    move-result-object v0
    invoke-interface v0, Lcom/bytedance/retrofit2/Call;->execute()Lcom/bytedance/retrofit2/SsResponse;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/retrofit2/SsResponse;->body()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/String;
    if-nez v2, +042h
    invoke-virtual v0, Lcom/bytedance/retrofit2/SsResponse;->errorBody()Lcom/bytedance/retrofit2/mime/TypedInput;
    move-result-object v0
    if-eqz v0, +03bh
    invoke-interface v0, Lcom/bytedance/retrofit2/mime/TypedInput;->in()Ljava/io/InputStream;
    move-result-object v0
    const-string v2, "in(...)"
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v2, Lkotlin/text/Charsets;->UTF_8 Ljava/nio/charset/Charset;
    new-instance v3, Ljava/io/InputStreamReader;
    invoke-direct v3, v0, v2, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream; Ljava/nio/charset/Charset;)V
    check-cast v3, Ljava/io/Reader;
    instance-of v0, v3, Ljava/io/BufferedReader;
    if-eqz v0, +005h
    check-cast v3, Ljava/io/BufferedReader;
    goto +9h
    new-instance v0, Ljava/io/BufferedReader;
    const/16 v2, 8192
    invoke-direct v0, v3, v2, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader; I)V
    move-object v3, v0
    check-cast v3, Ljava/io/Closeable;
    move-object v0, v3
    check-cast v0, Ljava/io/BufferedReader;
    check-cast v0, Ljava/io/Reader;
    invoke-static v0, Lkotlin/io/TextStreamsKt;->readText(Ljava/io/Reader;)Ljava/lang/String;
    move-result-object v2
    invoke-static v3, v8, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    goto +bh
    move-exception v0
    move-object v2, v0
    throw v2
    move-exception v0
    move-object v4, v0
    invoke-static v3, v2, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    throw v4
    move-object v2, v8
    const-string v0, "getString(...)"
    if-eqz v2, +086h
    const-class v3, Lcom/bytedance/trae/login/enterprise/CheckLoginConfigResult;
    invoke-direct v1, v2, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager;->parseEnterpriseResponse(Ljava/lang/String; Ljava/lang/Class;)Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;->getCode()I
    move-result v3
    if-eqz v3, +054h
    invoke-virtual v2, Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;->getCode()I
    move-result v3
    invoke-direct v1, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager;->mapErrorCodeToMessage(I)Ljava/lang/String;
    move-result-object v3
    if-nez v3, +02ah
    invoke-virtual v2, Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;->getMessage()Ljava/lang/String;
    move-result-object v3
    if-eqz v3, +010h
    move-object v5, v3
    check-cast v5, Ljava/lang/CharSequence;
    invoke-interface v5, Ljava/lang/CharSequence;->length()I
    move-result v5
    if-lez v5, +003h
    goto +2h
    move v4, v6
    if-eqz v4, +003h
    move-object v8, v3
    if-nez v8, +012h
    sget-object v3, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v3
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->trae_enterprise_error_service I
    invoke-virtual v3, v4, Landroid/app/Application;->getString(I)Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto +3h
    move-object v6, v8
    goto +2h
    move-object v6, v3
    new-instance v0, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthException;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "checkLoginConfig business error: code="
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;->getCode()I
    move-result v2
    invoke-virtual v3, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    const/4 v7, 0
    const/4 v8, 0
    const/16 v9, 12
    const/4 v10, 0
    move-object v4, v0
    invoke-direct/range v4 ... v10, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthException;-><init>(Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    throw v0
    invoke-virtual v2, Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;->getData()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/login/enterprise/CheckLoginConfigResult;
    if-eqz v2, +003h
    return-object v2
    new-instance v2, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthException;
    const-string v4, "checkLoginConfig data is null"
    sget-object v3, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v3
    sget v5, Lcom/bytedance/trae/multilanguage/R$string;->trae_enterprise_error_service I
    invoke-virtual v3, v5, Landroid/app/Application;->getString(I)Ljava/lang/String;
    move-result-object v5
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v6, 0
    const/4 v7, 0
    const/16 v8, 12
    const/4 v9, 0
    move-object v3, v2
    invoke-direct/range v3 ... v9, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthException;-><init>(Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    throw v2
    new-instance v2, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthException;
    const-string v11, "checkLoginConfig response body is null"
    sget-object v3, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v3
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->trae_enterprise_error_service I
    invoke-virtual v3, v4, Landroid/app/Application;->getString(I)Ljava/lang/String;
    move-result-object v12
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v13, 0
    const/4 v14, 0
    const/16 v15, 12
    const/16 v16, 0
    move-object v10, v2
    invoke-direct/range v10 ... v16, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthException;-><init>(Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    throw v2
    :try_start_0x69
    :try_start_0x78
.end method

.method public final getCodeInfo(java.lang.String)com.bytedance.trae.login.enterprise.GetCodeInfoResult
    .registers 19
    # ins_size=2
    move-object/from16 v1, v17
    move-object/from16 v0, v18
    const-string v2, "code"
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v2, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginConfig;->INSTANCE Lcom/bytedance/trae/login/enterprise/EnterpriseLoginConfig;
    invoke-virtual v2, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginConfig;->getBaseUrl()Ljava/lang/String;
    move-result-object v7
    sget-object v3, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    const-string v4, "enterprise_auth"
    const-class v5, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthApi;
    const/4 v6, 0
    const/4 v8, 0
    const/4 v9, 0
    const/16 v10, 52
    const/4 v11, 0
    invoke-static/range v3 ... v11, Lcom/bytedance/trae/network/TraeHttpConnection;->createService$default(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; Ljava/lang/Class; Lcom/bytedance/retrofit2/Converter$Factory; Ljava/lang/String; Ljava/util/Map; Z I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthApi;
    new-instance v3, Lcom/bytedance/ttnet/http/RequestContext;
    invoke-direct v3, Lcom/bytedance/ttnet/http/RequestContext;-><init>()V
    const/4 v4, 1
    iput-boolean v4, v3, Lcom/bytedance/ttnet/http/RequestContext;->force_handle_response Z
    new-instance v5, Lcom/bytedance/trae/login/enterprise/GetCodeInfoRequest;
    const/4 v6, 0
    const/4 v7, 2
    invoke-direct v5, v0, v6, v7, v8, Lcom/bytedance/trae/login/enterprise/GetCodeInfoRequest;-><init>(Ljava/lang/String; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v2, v5, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthApi;->getCodeInfo(Lcom/bytedance/trae/login/enterprise/GetCodeInfoRequest; Ljava/lang/Object;)Lcom/bytedance/retrofit2/Call;
    move-result-object v0
    invoke-interface v0, Lcom/bytedance/retrofit2/Call;->execute()Lcom/bytedance/retrofit2/SsResponse;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/retrofit2/SsResponse;->body()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/String;
    if-nez v2, +042h
    invoke-virtual v0, Lcom/bytedance/retrofit2/SsResponse;->errorBody()Lcom/bytedance/retrofit2/mime/TypedInput;
    move-result-object v0
    if-eqz v0, +03bh
    invoke-interface v0, Lcom/bytedance/retrofit2/mime/TypedInput;->in()Ljava/io/InputStream;
    move-result-object v0
    const-string v2, "in(...)"
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v2, Lkotlin/text/Charsets;->UTF_8 Ljava/nio/charset/Charset;
    new-instance v3, Ljava/io/InputStreamReader;
    invoke-direct v3, v0, v2, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream; Ljava/nio/charset/Charset;)V
    check-cast v3, Ljava/io/Reader;
    instance-of v0, v3, Ljava/io/BufferedReader;
    if-eqz v0, +005h
    check-cast v3, Ljava/io/BufferedReader;
    goto +9h
    new-instance v0, Ljava/io/BufferedReader;
    const/16 v2, 8192
    invoke-direct v0, v3, v2, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader; I)V
    move-object v3, v0
    check-cast v3, Ljava/io/Closeable;
    move-object v0, v3
    check-cast v0, Ljava/io/BufferedReader;
    check-cast v0, Ljava/io/Reader;
    invoke-static v0, Lkotlin/io/TextStreamsKt;->readText(Ljava/io/Reader;)Ljava/lang/String;
    move-result-object v2
    invoke-static v3, v8, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    goto +bh
    move-exception v0
    move-object v2, v0
    throw v2
    move-exception v0
    move-object v4, v0
    invoke-static v3, v2, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    throw v4
    move-object v2, v8
    const-string v0, "getString(...)"
    if-eqz v2, +086h
    const-class v3, Lcom/bytedance/trae/login/enterprise/GetCodeInfoResult;
    invoke-direct v1, v2, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager;->parseEnterpriseResponse(Ljava/lang/String; Ljava/lang/Class;)Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;->getCode()I
    move-result v3
    if-eqz v3, +054h
    invoke-virtual v2, Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;->getCode()I
    move-result v3
    invoke-direct v1, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager;->mapErrorCodeToMessage(I)Ljava/lang/String;
    move-result-object v3
    if-nez v3, +02ah
    invoke-virtual v2, Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;->getMessage()Ljava/lang/String;
    move-result-object v3
    if-eqz v3, +010h
    move-object v5, v3
    check-cast v5, Ljava/lang/CharSequence;
    invoke-interface v5, Ljava/lang/CharSequence;->length()I
    move-result v5
    if-lez v5, +003h
    goto +2h
    move v4, v6
    if-eqz v4, +003h
    move-object v8, v3
    if-nez v8, +012h
    sget-object v3, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v3
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->trae_enterprise_error_service I
    invoke-virtual v3, v4, Landroid/app/Application;->getString(I)Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto +3h
    move-object v6, v8
    goto +2h
    move-object v6, v3
    new-instance v0, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthException;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "getCodeInfo business error: code="
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;->getCode()I
    move-result v2
    invoke-virtual v3, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    const/4 v7, 0
    const/4 v8, 0
    const/16 v9, 12
    const/4 v10, 0
    move-object v4, v0
    invoke-direct/range v4 ... v10, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthException;-><init>(Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    throw v0
    invoke-virtual v2, Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;->getData()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/login/enterprise/GetCodeInfoResult;
    if-eqz v2, +003h
    return-object v2
    new-instance v2, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthException;
    const-string v4, "getCodeInfo data is null"
    sget-object v3, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v3
    sget v5, Lcom/bytedance/trae/multilanguage/R$string;->trae_enterprise_error_service I
    invoke-virtual v3, v5, Landroid/app/Application;->getString(I)Ljava/lang/String;
    move-result-object v5
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v6, 0
    const/4 v7, 0
    const/16 v8, 12
    const/4 v9, 0
    move-object v3, v2
    invoke-direct/range v3 ... v9, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthException;-><init>(Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    throw v2
    new-instance v2, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthException;
    const-string v11, "getCodeInfo response body is null"
    sget-object v3, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v3
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->trae_enterprise_error_service I
    invoke-virtual v3, v4, Landroid/app/Application;->getString(I)Ljava/lang/String;
    move-result-object v12
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v13, 0
    const/4 v14, 0
    const/16 v15, 12
    const/16 v16, 0
    move-object v10, v2
    invoke-direct/range v10 ... v16, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthException;-><init>(Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    throw v2
    :try_start_0x69
    :try_start_0x78
.end method

.method public final isEnterpriseLogin()boolean
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;
    invoke-virtual v0, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->getLoginPlatform()Ljava/lang/String;
    move-result-object v0
    const-string v1, "enterprise"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    return v0
.end method

.method public final login(kotlinx.coroutines.CoroutineScope  java.lang.String  java.lang.String  com.bytedance.trae.login.enterprise.EnterpriseAuthManager$Callback)void
    .registers 13
    # ins_size=5
    const-string v0, "callerScope"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "email"
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, password
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "callback"
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager;->exceptionHandler Lkotlinx/coroutines/CoroutineExceptionHandler;
    check-cast v1, Lkotlin/coroutines/CoroutineContext;
    invoke-virtual v0, v1, Lkotlinx/coroutines/CoroutineDispatcher;->plus(Lkotlin/coroutines/CoroutineContext;)Lkotlin/coroutines/CoroutineContext;
    move-result-object v3
    const/4 v4, 0
    new-instance v0, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager$login$1;
    const/4 v1, 0
    invoke-direct v0, v10, v11, v12, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager$login$1;-><init>(Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager$Callback; Lkotlin/coroutines/Continuation;)V
    move-object v5, v0
    check-cast v5, Lkotlin/jvm/functions/Function2;
    const/4 v6, 2
    const/4 v7, 0
    move-object v2, v9
    invoke-static/range v2 ... v7, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public final loginWithSsoSession(kotlinx.coroutines.CoroutineScope  java.lang.String  java.lang.String  com.bytedance.trae.login.enterprise.EnterpriseAuthManager$Callback)void
    .registers 13
    # ins_size=5
    const-string v0, "callerScope"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "email"
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, tobSession
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "callback"
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager;->exceptionHandler Lkotlinx/coroutines/CoroutineExceptionHandler;
    check-cast v1, Lkotlin/coroutines/CoroutineContext;
    invoke-virtual v0, v1, Lkotlinx/coroutines/CoroutineDispatcher;->plus(Lkotlin/coroutines/CoroutineContext;)Lkotlin/coroutines/CoroutineContext;
    move-result-object v3
    const/4 v4, 0
    new-instance v0, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager$loginWithSsoSession$1;
    const/4 v1, 0
    invoke-direct v0, v10, v11, v12, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager$loginWithSsoSession$1;-><init>(Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager$Callback; Lkotlin/coroutines/Continuation;)V
    move-object v5, v0
    check-cast v5, Lkotlin/jvm/functions/Function2;
    const/4 v6, 2
    const/4 v7, 0
    move-object v2, v9
    invoke-static/range v2 ... v7, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public final registerProvider()void
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    new-instance v1, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager$registerProvider$1;
    invoke-direct v1, v2, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager$registerProvider$1;-><init>(Ljava/lang/Object;)V
    check-cast v1, Lkotlin/jvm/functions/Function1;
    invoke-virtual v0, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->setEnterpriseExchangeProvider(Lkotlin/jvm/functions/Function1;)V
    sget-object v0, Lcom/bytedance/trae/login/enterprise/EnterpriseProfileRefresher;->INSTANCE Lcom/bytedance/trae/login/enterprise/EnterpriseProfileRefresher;
    new-instance v1, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager$registerProvider$2;
    invoke-direct v1, v2, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager$registerProvider$2;-><init>(Ljava/lang/Object;)V
    check-cast v1, Lkotlin/jvm/functions/Function2;
    invoke-virtual v0, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseProfileRefresher;->setRefreshProvider(Lkotlin/jvm/functions/Function2;)V
    sget-object v0, Lcom/bytedance/trae/login/enterprise/EnterpriseProfileRefresher;->INSTANCE Lcom/bytedance/trae/login/enterprise/EnterpriseProfileRefresher;
    new-instance v1, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager$registerProvider$3;
    invoke-direct v1, v2, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager$registerProvider$3;-><init>(Ljava/lang/Object;)V
    check-cast v1, Lkotlin/jvm/functions/Function2;
    invoke-virtual v0, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseProfileRefresher;->setUpdateProfileProvider(Lkotlin/jvm/functions/Function2;)V
    return-void 
.end method

.method public final sendEmailVerification(java.lang.String)void
    .registers 20
    # ins_size=2
    move-object/from16 v1, v18
    move-object/from16 v0, v19
    const-string v2, "email"
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v2, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginConfig;->INSTANCE Lcom/bytedance/trae/login/enterprise/EnterpriseLoginConfig;
    invoke-virtual v2, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginConfig;->getBaseUrl()Ljava/lang/String;
    move-result-object v7
    sget-object v3, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    const-string v4, "enterprise_auth"
    const-class v5, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthApi;
    const/4 v6, 0
    const/4 v8, 0
    const/4 v9, 0
    const/16 v10, 52
    const/4 v11, 0
    invoke-static/range v3 ... v11, Lcom/bytedance/trae/network/TraeHttpConnection;->createService$default(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; Ljava/lang/Class; Lcom/bytedance/retrofit2/Converter$Factory; Ljava/lang/String; Ljava/util/Map; Z I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthApi;
    new-instance v3, Lcom/bytedance/ttnet/http/RequestContext;
    invoke-direct v3, Lcom/bytedance/ttnet/http/RequestContext;-><init>()V
    const/4 v4, 1
    iput-boolean v4, v3, Lcom/bytedance/ttnet/http/RequestContext;->force_handle_response Z
    new-instance v5, Lcom/bytedance/trae/login/enterprise/SendEmailVerificationRequest;
    const/4 v6, 0
    const/4 v7, 2
    invoke-direct v5, v0, v6, v7, v8, Lcom/bytedance/trae/login/enterprise/SendEmailVerificationRequest;-><init>(Ljava/lang/String; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v2, v5, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthApi;->sendEmailVerification(Lcom/bytedance/trae/login/enterprise/SendEmailVerificationRequest; Ljava/lang/Object;)Lcom/bytedance/retrofit2/Call;
    move-result-object v0
    invoke-interface v0, Lcom/bytedance/retrofit2/Call;->execute()Lcom/bytedance/retrofit2/SsResponse;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/retrofit2/SsResponse;->body()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/String;
    if-nez v2, +042h
    invoke-virtual v0, Lcom/bytedance/retrofit2/SsResponse;->errorBody()Lcom/bytedance/retrofit2/mime/TypedInput;
    move-result-object v0
    if-eqz v0, +03bh
    invoke-interface v0, Lcom/bytedance/retrofit2/mime/TypedInput;->in()Ljava/io/InputStream;
    move-result-object v0
    const-string v2, "in(...)"
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v2, Lkotlin/text/Charsets;->UTF_8 Ljava/nio/charset/Charset;
    new-instance v3, Ljava/io/InputStreamReader;
    invoke-direct v3, v0, v2, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream; Ljava/nio/charset/Charset;)V
    check-cast v3, Ljava/io/Reader;
    instance-of v0, v3, Ljava/io/BufferedReader;
    if-eqz v0, +005h
    check-cast v3, Ljava/io/BufferedReader;
    goto +9h
    new-instance v0, Ljava/io/BufferedReader;
    const/16 v2, 8192
    invoke-direct v0, v3, v2, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader; I)V
    move-object v3, v0
    check-cast v3, Ljava/io/Closeable;
    move-object v0, v3
    check-cast v0, Ljava/io/BufferedReader;
    check-cast v0, Ljava/io/Reader;
    invoke-static v0, Lkotlin/io/TextStreamsKt;->readText(Ljava/io/Reader;)Ljava/lang/String;
    move-result-object v2
    invoke-static v3, v8, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    goto +bh
    move-exception v0
    move-object v2, v0
    throw v2
    move-exception v0
    move-object v4, v0
    invoke-static v3, v2, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    throw v4
    move-object v2, v8
    const-string v0, "getString(...)"
    if-eqz v2, +062h
    const-class v3, Ljava/lang/Object;
    invoke-direct v1, v2, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager;->parseEnterpriseResponse(Ljava/lang/String; Ljava/lang/Class;)Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;->getCode()I
    move-result v3
    if-eqz v3, +055h
    invoke-virtual v2, Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;->getCode()I
    move-result v3
    invoke-direct v1, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager;->mapErrorCodeToMessage(I)Ljava/lang/String;
    move-result-object v3
    if-nez v3, +02ah
    invoke-virtual v2, Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;->getMessage()Ljava/lang/String;
    move-result-object v3
    if-eqz v3, +010h
    move-object v5, v3
    check-cast v5, Ljava/lang/CharSequence;
    invoke-interface v5, Ljava/lang/CharSequence;->length()I
    move-result v5
    if-lez v5, +003h
    goto +2h
    move v4, v6
    if-eqz v4, +003h
    move-object v8, v3
    if-nez v8, +012h
    sget-object v3, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v3
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->trae_enterprise_error_service I
    invoke-virtual v3, v4, Landroid/app/Application;->getString(I)Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto +3h
    move-object v6, v8
    goto +2h
    move-object v6, v3
    new-instance v0, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthException;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string/jumbo v4, sendEmailVerification business error: code=
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;->getCode()I
    move-result v2
    invoke-virtual v3, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    const/4 v7, 0
    const/4 v8, 0
    const/16 v9, 12
    const/4 v10, 0
    move-object v4, v0
    invoke-direct/range v4 ... v10, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthException;-><init>(Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    throw v0
    return-void 
    new-instance v2, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthException;
    const-string/jumbo v12, sendEmailVerification response body is null
    sget-object v3, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v3
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->trae_enterprise_error_service I
    invoke-virtual v3, v4, Landroid/app/Application;->getString(I)Ljava/lang/String;
    move-result-object v13
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 12
    const/16 v17, 0
    move-object v11, v2
    invoke-direct/range v11 ... v17, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthException;-><init>(Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    throw v2
    :try_start_0x69
    :try_start_0x78
.end method

.method public final setUserPassword(java.lang.String  java.lang.String  java.lang.String)void
    .registers 23
    # ins_size=4
    move-object/from16 v1, v19
    move-object/from16 v0, v20
    move-object/from16 v2, v21
    move-object/from16 v3, v22
    const-string v4, "email"
    invoke-static v0, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v4, password
    invoke-static v2, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v4, "code"
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v4, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginConfig;->INSTANCE Lcom/bytedance/trae/login/enterprise/EnterpriseLoginConfig;
    invoke-virtual v4, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginConfig;->getBaseUrl()Ljava/lang/String;
    move-result-object v9
    sget-object v5, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    const-string v6, "enterprise_auth"
    const-class v7, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthApi;
    const/4 v8, 0
    const/4 v10, 0
    const/4 v11, 0
    const/16 v12, 52
    const/4 v13, 0
    invoke-static/range v5 ... v13, Lcom/bytedance/trae/network/TraeHttpConnection;->createService$default(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; Ljava/lang/Class; Lcom/bytedance/retrofit2/Converter$Factory; Ljava/lang/String; Ljava/util/Map; Z I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthApi;
    new-instance v5, Lcom/bytedance/ttnet/http/RequestContext;
    invoke-direct v5, Lcom/bytedance/ttnet/http/RequestContext;-><init>()V
    const/4 v6, 1
    iput-boolean v6, v5, Lcom/bytedance/ttnet/http/RequestContext;->force_handle_response Z
    new-instance v7, Lcom/bytedance/trae/login/enterprise/SetUserPasswordRequest;
    invoke-direct v7, v0, v2, v3, Lcom/bytedance/trae/login/enterprise/SetUserPasswordRequest;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    invoke-interface v4, v7, v5, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthApi;->setUserPassword(Lcom/bytedance/trae/login/enterprise/SetUserPasswordRequest; Ljava/lang/Object;)Lcom/bytedance/retrofit2/Call;
    move-result-object v0
    invoke-interface v0, Lcom/bytedance/retrofit2/Call;->execute()Lcom/bytedance/retrofit2/SsResponse;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/retrofit2/SsResponse;->body()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/String;
    const/4 v3, 0
    if-nez v2, +042h
    invoke-virtual v0, Lcom/bytedance/retrofit2/SsResponse;->errorBody()Lcom/bytedance/retrofit2/mime/TypedInput;
    move-result-object v0
    if-eqz v0, +03bh
    invoke-interface v0, Lcom/bytedance/retrofit2/mime/TypedInput;->in()Ljava/io/InputStream;
    move-result-object v0
    const-string v2, "in(...)"
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v2, Lkotlin/text/Charsets;->UTF_8 Ljava/nio/charset/Charset;
    new-instance v4, Ljava/io/InputStreamReader;
    invoke-direct v4, v0, v2, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream; Ljava/nio/charset/Charset;)V
    check-cast v4, Ljava/io/Reader;
    instance-of v0, v4, Ljava/io/BufferedReader;
    if-eqz v0, +005h
    check-cast v4, Ljava/io/BufferedReader;
    goto +9h
    new-instance v0, Ljava/io/BufferedReader;
    const/16 v2, 8192
    invoke-direct v0, v4, v2, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader; I)V
    move-object v4, v0
    check-cast v4, Ljava/io/Closeable;
    move-object v0, v4
    check-cast v0, Ljava/io/BufferedReader;
    check-cast v0, Ljava/io/Reader;
    invoke-static v0, Lkotlin/io/TextStreamsKt;->readText(Ljava/io/Reader;)Ljava/lang/String;
    move-result-object v2
    invoke-static v4, v3, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    goto +bh
    move-exception v0
    move-object v2, v0
    throw v2
    move-exception v0
    move-object v3, v0
    invoke-static v4, v2, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    throw v3
    move-object v2, v3
    const-string v0, "getString(...)"
    if-eqz v2, +062h
    const-class v4, Ljava/lang/Object;
    invoke-direct v1, v2, v4, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager;->parseEnterpriseResponse(Ljava/lang/String; Ljava/lang/Class;)Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;->getCode()I
    move-result v4
    if-eqz v4, +055h
    invoke-virtual v2, Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;->getCode()I
    move-result v4
    invoke-direct v1, v4, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager;->mapErrorCodeToMessage(I)Ljava/lang/String;
    move-result-object v4
    if-nez v4, +02ah
    invoke-virtual v2, Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;->getMessage()Ljava/lang/String;
    move-result-object v4
    if-eqz v4, +010h
    move-object v5, v4
    check-cast v5, Ljava/lang/CharSequence;
    invoke-interface v5, Ljava/lang/CharSequence;->length()I
    move-result v5
    if-lez v5, +003h
    goto +2h
    const/4 v6, 0
    if-eqz v6, +003h
    move-object v3, v4
    if-nez v3, +012h
    sget-object v3, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v3
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->trae_enterprise_error_service I
    invoke-virtual v3, v4, Landroid/app/Application;->getString(I)Ljava/lang/String;
    move-result-object v4
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto +3h
    move-object v7, v3
    goto +2h
    move-object v7, v4
    new-instance v0, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthException;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string/jumbo v4, setUserPassword business error: code=
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;->getCode()I
    move-result v2
    invoke-virtual v3, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    const/4 v8, 0
    const/4 v9, 0
    const/16 v10, 12
    const/4 v11, 0
    move-object v5, v0
    invoke-direct/range v5 ... v11, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthException;-><init>(Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    throw v0
    return-void 
    new-instance v2, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthException;
    const-string/jumbo v13, setUserPassword response body is null
    sget-object v3, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v3
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->trae_enterprise_error_service I
    invoke-virtual v3, v4, Landroid/app/Application;->getString(I)Ljava/lang/String;
    move-result-object v14
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 12
    const/16 v18, 0
    move-object v12, v2
    invoke-direct/range v12 ... v18, Lcom/bytedance/trae/login/enterprise/EnterpriseAuthException;-><init>(Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    throw v2
    :try_start_0x77
    :try_start_0x86
.end method
