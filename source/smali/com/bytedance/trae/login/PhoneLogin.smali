# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/PhoneLogin;
.super Ljava/lang/Object;
.source "PhoneLogin.kt"

.field private final authOppoSite:I


.method public constructor <init>()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    const/4 v0, 1
    iput v0, v1, Lcom/bytedance/trae/login/PhoneLogin;->authOppoSite I
    return-void 
.end method

.method public final doOneKeyLogin(com.bytedance.trae.login.api.IAccountCallback  java.lang.String)void
    .registers 16
    # ins_size=3
    const-string v0, "callback"
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-class v0, Lcom/bytedance/sdk/account/platform/api/IOnekeyLoginService;
    invoke-static v0, Lcom/bytedance/sdk/account/platform/base/AuthorizeFramework;->getService(Ljava/lang/Class;)Lcom/bytedance/sdk/account/platform/api/IAuthorizeService;
    move-result-object v0
    check-cast v0, Lcom/bytedance/sdk/account/platform/api/IOnekeyLoginService;
    if-nez v0, +017h
    invoke-virtual v13, Lcom/bytedance/trae/login/PhoneLogin;->providePlatform()Lcom/bytedance/trae/login/api/LoginPlatform;
    move-result-object v2
    const/4 v3, -1
    const-string v4, "IOnekeyLoginService not available"
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/16 v11, 480
    const/4 v12, 0
    move-object v1, v14
    move-object v5, v15
    invoke-static/range v1 ... v12, Lcom/bytedance/trae/login/api/IAccountCallback$DefaultImpls;->onFailed$default(Lcom/bytedance/trae/login/api/IAccountCallback; Lcom/bytedance/trae/login/api/LoginPlatform; I Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/util/Map; I Ljava/lang/Object;)V
    return-void 
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/login/PhoneLogin$doOneKeyLogin$1;
    invoke-direct v2, v14, v15, v13, v1, Lcom/bytedance/trae/login/PhoneLogin$doOneKeyLogin$1;-><init>(Lcom/bytedance/trae/login/api/IAccountCallback; Ljava/lang/String; Lcom/bytedance/trae/login/PhoneLogin; Landroid/app/Application;)V
    check-cast v2, Lcom/bytedance/sdk/account/platform/base/AuthorizeCallback;
    invoke-interface v0, v2, Lcom/bytedance/sdk/account/platform/api/IOnekeyLoginService;->getAuthToken(Lcom/bytedance/sdk/account/platform/base/AuthorizeCallback;)V
    return-void 
.end method

.method public final doPhoneLogin(com.bytedance.trae.login.api.LoginPlatform  java.lang.String  java.lang.String  com.bytedance.trae.login.api.IAccountCallback  java.lang.String)void
    .registers 14
    # ins_size=6
    const-string/jumbo v0, platform
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "account"
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "code"
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "callback"
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Ljava/util/LinkedHashMap;
    invoke-direct v0, Ljava/util/LinkedHashMap;-><init>()V
    move-object v6, v0
    check-cast v6, Ljava/util/Map;
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getAppName()Ljava/lang/String;
    move-result-object v0
    const-string v1, "app_name"
    invoke-interface v6, v1, v0, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    invoke-static Lcom/bytedance/sdk/account/impl/BDAccountAPIV3Impl;->instance()Lcom/bytedance/sdk/account/api/IBDAccountAPIV3;
    move-result-object v1
    iget v0, v8, Lcom/bytedance/trae/login/PhoneLogin;->authOppoSite I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    const/4 v5, 0
    new-instance v0, Lcom/bytedance/trae/login/PhoneLogin$doPhoneLogin$1;
    invoke-direct v0, v12, v13, v9, v8, Lcom/bytedance/trae/login/PhoneLogin$doPhoneLogin$1;-><init>(Lcom/bytedance/trae/login/api/IAccountCallback; Ljava/lang/String; Lcom/bytedance/trae/login/api/LoginPlatform; Lcom/bytedance/trae/login/PhoneLogin;)V
    move-object v7, v0
    check-cast v7, Lcom/bytedance/sdk/account/mobile/thread/call/QuickLoginCallback;
    move-object v2, v10
    move-object v3, v11
    invoke-interface/range v1 ... v7, Lcom/bytedance/sdk/account/api/IBDAccountAPIV3;->quickLogin(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/util/Map; Lcom/bytedance/sdk/account/mobile/thread/call/QuickLoginCallback;)V
    return-void 
.end method

.method public final getPhoneInfo(com.bytedance.trae.login.api.LoginPlatform  com.bytedance.trae.login.IPhoneOneKeyCallback)void
    .registers 5
    # ins_size=3
    const-string/jumbo v0, platform
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v3, "callback"
    invoke-static v4, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-class v3, Lcom/bytedance/sdk/account/platform/api/IOnekeyLoginService;
    invoke-static v3, Lcom/bytedance/sdk/account/platform/base/AuthorizeFramework;->getService(Ljava/lang/Class;)Lcom/bytedance/sdk/account/platform/api/IAuthorizeService;
    move-result-object v3
    check-cast v3, Lcom/bytedance/sdk/account/platform/api/IOnekeyLoginService;
    if-nez v3, +00bh
    const-string v3, "-1"
    const-string v0, "IOnekeyLoginService not available"
    const/4 v1, -1
    invoke-interface v4, v1, v3, v0, Lcom/bytedance/trae/login/IPhoneOneKeyCallback;->onGetPhoneOneKeyInfoFailure(I Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    new-instance v0, Lcom/bytedance/trae/login/PhoneLogin$getPhoneInfo$1;
    invoke-direct v0, v3, v4, Lcom/bytedance/trae/login/PhoneLogin$getPhoneInfo$1;-><init>(Lcom/bytedance/sdk/account/platform/api/IOnekeyLoginService; Lcom/bytedance/trae/login/IPhoneOneKeyCallback;)V
    check-cast v0, Lcom/bytedance/sdk/account/platform/base/AuthorizeCallback;
    invoke-interface v3, v0, Lcom/bytedance/sdk/account/platform/api/IOnekeyLoginService;->getPhoneInfo(Lcom/bytedance/sdk/account/platform/base/AuthorizeCallback;)V
    return-void 
.end method

.method public final providePlatform()com.bytedance.trae.login.api.LoginPlatform
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/login/api/LoginPlatform;->PHONE Lcom/bytedance/trae/login/api/LoginPlatform;
    return-object v0
.end method

.method public final sendCode(java.lang.String  com.bytedance.trae.login.IVerificationCodeCallback  boolean  java.lang.String  boolean  boolean)void
    .registers 8
    # ins_size=7
    const-string v4, "account"
    invoke-static v2, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v4, "callback"
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v4, Ljava/util/LinkedHashMap;
    invoke-direct v4, Ljava/util/LinkedHashMap;-><init>()V
    check-cast v4, Ljava/util/Map;
    const-string v5, "1"
    if-eqz v7, +004h
    move-object v7, v5
    goto +3h
    const-string v7, "0"
    const-string v0, "is6Digits"
    invoke-interface v4, v0, v7, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v7, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v7, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getAppName()Ljava/lang/String;
    move-result-object v7
    const-string v0, "app_name"
    invoke-interface v4, v0, v7, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    if-eqz v6, +007h
    const-string v6, "auto_read"
    invoke-interface v4, v6, v5, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    invoke-static Lcom/bytedance/sdk/account/impl/BDAccountAPIV3Impl;->instance()Lcom/bytedance/sdk/account/api/IBDAccountAPIV3;
    move-result-object v5
    new-instance v6, Lcom/bytedance/trae/login/PhoneLogin$sendCode$1;
    invoke-direct v6, v3, Lcom/bytedance/trae/login/PhoneLogin$sendCode$1;-><init>(Lcom/bytedance/trae/login/IVerificationCodeCallback;)V
    check-cast v6, Lcom/bytedance/sdk/account/mobile/thread/call/SendCodeCallback;
    const/16 v3, 24
    invoke-interface v5, v2, v3, v4, v6, Lcom/bytedance/sdk/account/api/IBDAccountAPIV3;->sendCode2(Ljava/lang/String; I Ljava/util/Map; Lcom/bytedance/sdk/account/mobile/thread/call/SendCodeCallback;)V
    return-void 
.end method
