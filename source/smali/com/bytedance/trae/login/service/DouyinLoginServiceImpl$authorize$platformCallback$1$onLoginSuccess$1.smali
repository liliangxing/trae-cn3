# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$authorize$platformCallback$1$onLoginSuccess$1;
.super Ljava/lang/Object;
.source "DouyinLoginServiceImpl.kt"

.implements Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback;

.field final synthetic $businessScene:Ljava/lang/String;
.field final synthetic $callback:Lcom/bytedance/trae/login/api/IAccountCallback;
.field final synthetic $response:Lcom/bytedance/sdk/account/api/call/UserApiResponse;
.field final synthetic this$0:Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl;


.method public static synthetic $r8$lambda$FwhWRRZb0ppOf1ewKCRzx3WKZlw(com.bytedance.trae.login.api.IAccountCallback  java.lang.String  java.util.HashMap)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$authorize$platformCallback$1$onLoginSuccess$1;->deviceOverLimit$lambda$2(Lcom/bytedance/trae/login/api/IAccountCallback; Ljava/lang/String; Ljava/util/HashMap;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$Vx-qr3l55blpf6VeZY1cbImmmB8(com.bytedance.sdk.account.api.call.UserApiResponse  java.lang.String  com.bytedance.trae.login.api.IAccountCallback)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$authorize$platformCallback$1$onLoginSuccess$1;->onSuccess$lambda$0(Lcom/bytedance/sdk/account/api/call/UserApiResponse; Ljava/lang/String; Lcom/bytedance/trae/login/api/IAccountCallback;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$X_iY37scyB3eA-zsfydcuMLwUGw(com.bytedance.trae.login.api.IAccountCallback  java.lang.String  java.lang.String  java.lang.String)kotlin.Unit
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$authorize$platformCallback$1$onLoginSuccess$1;->onFailure$lambda$1(Lcom/bytedance/trae/login/api/IAccountCallback; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method constructor <init>(com.bytedance.trae.login.service.DouyinLoginServiceImpl  com.bytedance.sdk.account.api.call.UserApiResponse  java.lang.String  com.bytedance.trae.login.api.IAccountCallback)void
    .registers 5
    # ins_size=5
    iput-object v1, v0, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$authorize$platformCallback$1$onLoginSuccess$1;->this$0 Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl;
    iput-object v2, v0, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$authorize$platformCallback$1$onLoginSuccess$1;->$response Lcom/bytedance/sdk/account/api/call/UserApiResponse;
    iput-object v3, v0, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$authorize$platformCallback$1$onLoginSuccess$1;->$businessScene Ljava/lang/String;
    iput-object v4, v0, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$authorize$platformCallback$1$onLoginSuccess$1;->$callback Lcom/bytedance/trae/login/api/IAccountCallback;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private static final deviceOverLimit$lambda$2(com.bytedance.trae.login.api.IAccountCallback  java.lang.String  java.util.HashMap)kotlin.Unit
    .registers 3
    # ins_size=3
    check-cast v2, Ljava/util/Map;
    invoke-interface v0, v1, v2, Lcom/bytedance/trae/login/api/IAccountCallback;->onDeviceOverLimit(Ljava/lang/String; Ljava/util/Map;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final onFailure$lambda$1(com.bytedance.trae.login.api.IAccountCallback  java.lang.String  java.lang.String  java.lang.String)kotlin.Unit
    .registers 16
    # ins_size=4
    sget-object v1, Lcom/bytedance/trae/login/api/LoginPlatform;->DOUYIN Lcom/bytedance/trae/login/api/LoginPlatform;
    if-eqz v13, +00dh
    invoke-static v13, Lkotlin/text/StringsKt;->toIntOrNull(Ljava/lang/String;)Ljava/lang/Integer;
    move-result-object v13
    if-eqz v13, +007h
    invoke-virtual v13, Ljava/lang/Integer;->intValue()I
    move-result v13
    goto +2h
    const/4 v13, -1
    move v2, v13
    if-nez v14, +013h
    sget-object v13, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v13, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v13
    sget v14, Lcom/bytedance/trae/login/R$string;->trae_douyin_auth_failed I
    invoke-virtual v13, v14, Landroid/app/Application;->getString(I)Ljava/lang/String;
    move-result-object v14
    const-string v13, "getString(...)"
    invoke-static v14, v13, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v3, v14
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v13, 1
    new-array v13, v13, [Lkotlin/Pair;
    const-string v14, "failed_step"
    const-string/jumbo v0, trae_auth_after_douyin_auth
    invoke-static v14, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v14
    const/4 v0, 0
    aput-object v14, v13, v0
    invoke-static v13, Lkotlin/collections/MapsKt;->mutableMapOf([Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v9
    const/16 v10, 224
    const/4 v11, 0
    move-object v0, v12
    move-object v4, v15
    invoke-static/range v0 ... v11, Lcom/bytedance/trae/login/api/IAccountCallback$DefaultImpls;->onFailed$default(Lcom/bytedance/trae/login/api/IAccountCallback; Lcom/bytedance/trae/login/api/LoginPlatform; I Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/util/Map; I Ljava/lang/Object;)V
    sget-object v12, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v12
.end method

.method private static final onSuccess$lambda$0(com.bytedance.sdk.account.api.call.UserApiResponse  java.lang.String  com.bytedance.trae.login.api.IAccountCallback)kotlin.Unit
    .registers 7
    # ins_size=3
    iget-object v4, v4, Lcom/bytedance/sdk/account/api/call/UserApiResponse;->userInfo Lcom/bytedance/sdk/account/user/IBDAccountUserEntity;
    const/4 v0, 0
    if-eqz v4, +008h
    iget-boolean v4, v4, Lcom/bytedance/sdk/account/user/IBDAccountUserEntity;->isNewUser Z
    const/4 v1, 1
    if-ne v4, v1, +003h
    move v0, v1
    sget-object v4, Lcom/bytedance/trae/login/service/AccountHelper;->INSTANCE Lcom/bytedance/trae/login/service/AccountHelper;
    invoke-virtual v4, v0, Lcom/bytedance/trae/login/service/AccountHelper;->setIsNewUser(Z)V
    sget-object v4, Lcom/bytedance/trae/login/service/AccountHelper;->INSTANCE Lcom/bytedance/trae/login/service/AccountHelper;
    sget-object v1, Lcom/bytedance/trae/login/api/AccountStatus;->LOGGED_IN Lcom/bytedance/trae/login/api/AccountStatus;
    if-nez v5, +005h
    const-string v2, ""
    goto +2h
    move-object v2, v5
    sget-object v3, Lcom/bytedance/trae/login/api/LoginPlatform;->DOUYIN Lcom/bytedance/trae/login/api/LoginPlatform;
    invoke-virtual v4, v1, v2, v3, Lcom/bytedance/trae/login/service/AccountHelper;->loginStatusChanged(Lcom/bytedance/trae/login/api/AccountStatus; Ljava/lang/String; Lcom/bytedance/trae/login/api/LoginPlatform;)V
    sget-object v4, Lcom/bytedance/trae/login/api/LoginPlatform;->DOUYIN Lcom/bytedance/trae/login/api/LoginPlatform;
    invoke-static v0, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v0
    invoke-interface v6, v4, v5, v0, Lcom/bytedance/trae/login/api/IAccountCallback;->onSuccess(Lcom/bytedance/trae/login/api/LoginPlatform; Ljava/lang/String; Ljava/lang/Boolean;)V
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v4
.end method

.method public deviceOverLimit(java.lang.String)void
    .registers 6
    # ins_size=2
    iget-object v0, v4, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$authorize$platformCallback$1$onLoginSuccess$1;->$response Lcom/bytedance/sdk/account/api/call/UserApiResponse;
    iget-object v0, v0, Lcom/bytedance/sdk/account/api/call/UserApiResponse;->userInfo Lcom/bytedance/sdk/account/user/IBDAccountUserEntity;
    const/4 v1, 0
    if-eqz v0, +008h
    iget-boolean v0, v0, Lcom/bytedance/sdk/account/user/IBDAccountUserEntity;->isNewUser Z
    const/4 v2, 1
    if-ne v0, v2, +003h
    move v1, v2
    new-instance v0, Ljava/util/HashMap;
    invoke-direct v0, Ljava/util/HashMap;-><init>()V
    move-object v2, v0
    check-cast v2, Ljava/util/Map;
    invoke-static v1, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v1
    check-cast v1, Ljava/lang/Object;
    const-string v3, "is_new_user"
    invoke-interface v2, v3, v1, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    iget-object v1, v4, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$authorize$platformCallback$1$onLoginSuccess$1;->this$0 Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl;
    iget-object v2, v4, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$authorize$platformCallback$1$onLoginSuccess$1;->$callback Lcom/bytedance/trae/login/api/IAccountCallback;
    new-instance v3, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$authorize$platformCallback$1$onLoginSuccess$1$$ExternalSyntheticLambda1;
    invoke-direct v3, v2, v5, v0, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$authorize$platformCallback$1$onLoginSuccess$1$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/login/api/IAccountCallback; Ljava/lang/String; Ljava/util/HashMap;)V
    invoke-static v1, v3, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl;->access$postToMain(Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl; Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method

.method public onFailure(java.lang.String  java.lang.String)void
    .registers 7
    # ins_size=3
    iget-object v0, v4, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$authorize$platformCallback$1$onLoginSuccess$1;->this$0 Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl;
    iget-object v1, v4, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$authorize$platformCallback$1$onLoginSuccess$1;->$callback Lcom/bytedance/trae/login/api/IAccountCallback;
    iget-object v2, v4, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$authorize$platformCallback$1$onLoginSuccess$1;->$businessScene Ljava/lang/String;
    new-instance v3, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$authorize$platformCallback$1$onLoginSuccess$1$$ExternalSyntheticLambda0;
    invoke-direct v3, v1, v5, v6, v2, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$authorize$platformCallback$1$onLoginSuccess$1$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/login/api/IAccountCallback; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    invoke-static v0, v3, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl;->access$postToMain(Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl; Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method

.method public onSuccess()void
    .registers 6
    # ins_size=1
    iget-object v0, v5, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$authorize$platformCallback$1$onLoginSuccess$1;->this$0 Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl;
    iget-object v1, v5, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$authorize$platformCallback$1$onLoginSuccess$1;->$response Lcom/bytedance/sdk/account/api/call/UserApiResponse;
    iget-object v2, v5, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$authorize$platformCallback$1$onLoginSuccess$1;->$businessScene Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$authorize$platformCallback$1$onLoginSuccess$1;->$callback Lcom/bytedance/trae/login/api/IAccountCallback;
    new-instance v4, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$authorize$platformCallback$1$onLoginSuccess$1$$ExternalSyntheticLambda2;
    invoke-direct v4, v1, v2, v3, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$authorize$platformCallback$1$onLoginSuccess$1$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/sdk/account/api/call/UserApiResponse; Ljava/lang/String; Lcom/bytedance/trae/login/api/IAccountCallback;)V
    invoke-static v0, v4, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl;->access$postToMain(Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl; Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method
