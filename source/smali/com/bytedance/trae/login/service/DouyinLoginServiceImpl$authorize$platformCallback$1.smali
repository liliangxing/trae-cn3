# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$authorize$platformCallback$1;
.super Lcom/bytedance/sdk/account/platform/PlatformLoginAdapter;
.source "DouyinLoginServiceImpl.kt"

.field final synthetic $businessScene:Ljava/lang/String;
.field final synthetic $callback:Lcom/bytedance/trae/login/api/IAccountCallback;
.field final synthetic this$0:Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl;


.method public static synthetic $r8$lambda$7kRUMDgKnnjFkCKIWLgYm3XHIMU(com.bytedance.trae.login.api.IAccountCallback  com.bytedance.sdk.account.api.call.UserApiResponse  java.lang.String  java.lang.String  java.util.Map)kotlin.Unit
    .registers 5
    # ins_size=5
    invoke-static v0, v1, v2, v3, v4, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$authorize$platformCallback$1;->onLoginError$lambda$4(Lcom/bytedance/trae/login/api/IAccountCallback; Lcom/bytedance/sdk/account/api/call/UserApiResponse; Ljava/lang/String; Ljava/lang/String; Ljava/util/Map;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$Z-ywX_aO1tbz23cXTg9sW8sFcQw(com.bytedance.trae.login.api.IAccountCallback  com.bytedance.sdk.account.api.call.UserApiResponse  java.lang.String  java.lang.String)kotlin.Unit
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$authorize$platformCallback$1;->onLoginError$lambda$0(Lcom/bytedance/trae/login/api/IAccountCallback; Lcom/bytedance/sdk/account/api/call/UserApiResponse; Ljava/lang/String; Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method constructor <init>(com.bytedance.trae.login.service.DouyinLoginServiceImpl  java.lang.String  com.bytedance.trae.login.api.IAccountCallback  android.content.Context)void
    .registers 11
    # ins_size=5
    iput-object v7, v6, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$authorize$platformCallback$1;->this$0 Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl;
    iput-object v8, v6, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$authorize$platformCallback$1;->$businessScene Ljava/lang/String;
    iput-object v9, v6, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$authorize$platformCallback$1;->$callback Lcom/bytedance/trae/login/api/IAccountCallback;
    const-string v2, "23081"
    const-string v3, "aweme_v2"
    const/4 v4, 1
    const/4 v5, 0
    move-object v0, v6
    move-object v1, v10
    invoke-direct/range v0 ... v5, Lcom/bytedance/sdk/account/platform/PlatformLoginAdapter;-><init>(Landroid/content/Context; Ljava/lang/String; Ljava/lang/String; Z Z)V
    return-void 
.end method

.method private static final onLoginError$lambda$0(com.bytedance.trae.login.api.IAccountCallback  com.bytedance.sdk.account.api.call.UserApiResponse  java.lang.String  java.lang.String)kotlin.Unit
    .registers 16
    # ins_size=4
    sget-object v1, Lcom/bytedance/trae/login/api/LoginPlatform;->DOUYIN Lcom/bytedance/trae/login/api/LoginPlatform;
    iget v2, v13, Lcom/bytedance/sdk/account/api/call/UserApiResponse;->error I
    iget-object v13, v13, Lcom/bytedance/sdk/account/api/call/UserApiResponse;->errorMsg Ljava/lang/String;
    if-nez v13, +013h
    sget-object v13, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v13, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v13
    sget v0, Lcom/bytedance/trae/login/R$string;->trae_douyin_need_bind_phone I
    invoke-virtual v13, v0, Landroid/app/Application;->getString(I)Ljava/lang/String;
    move-result-object v13
    const-string v0, "getString(...)"
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v3, v13
    const/4 v5, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/16 v10, 448
    const/4 v11, 0
    move-object v0, v12
    move-object v4, v14
    move-object v6, v15
    invoke-static/range v0 ... v11, Lcom/bytedance/trae/login/api/IAccountCallback$DefaultImpls;->onFailed$default(Lcom/bytedance/trae/login/api/IAccountCallback; Lcom/bytedance/trae/login/api/LoginPlatform; I Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/util/Map; I Ljava/lang/Object;)V
    sget-object v12, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v12
.end method

.method private static final onLoginError$lambda$4(com.bytedance.trae.login.api.IAccountCallback  com.bytedance.sdk.account.api.call.UserApiResponse  java.lang.String  java.lang.String  java.util.Map)kotlin.Unit
    .registers 17
    # ins_size=5
    sget-object v1, Lcom/bytedance/trae/login/api/LoginPlatform;->DOUYIN Lcom/bytedance/trae/login/api/LoginPlatform;
    move-object v0, v13
    iget v2, v0, Lcom/bytedance/sdk/account/api/call/UserApiResponse;->error I
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    invoke-interface/range v16, Ljava/util/Map;->isEmpty()Z
    move-result v0
    if-eqz v0, +005h
    const/4 v0, 0
    move-object v9, v0
    goto +3h
    move-object/from16 v9, v16
    const/16 v10, 224
    const/4 v11, 0
    move-object v0, v12
    move-object v3, v14
    move-object v4, v15
    invoke-static/range v0 ... v11, Lcom/bytedance/trae/login/api/IAccountCallback$DefaultImpls;->onFailed$default(Lcom/bytedance/trae/login/api/IAccountCallback; Lcom/bytedance/trae/login/api/LoginPlatform; I Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/util/Map; I Ljava/lang/Object;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method public onLoginError(com.bytedance.sdk.account.api.call.UserApiResponse)void
    .registers 13
    # ins_size=2
    const-string/jumbo v0, response
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v12, Lcom/bytedance/sdk/account/api/call/UserApiResponse;->getProfileKey()Ljava/lang/String;
    move-result-object v0
    iget v1, v12, Lcom/bytedance/sdk/account/api/call/UserApiResponse;->error I
    const/16 v2, 1060
    const/4 v3, 0
    const/4 v4, 1
    if-ne v1, v2, +023h
    move-object v1, v0
    check-cast v1, Ljava/lang/CharSequence;
    if-eqz v1, +00bh
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-nez v1, +003h
    goto +3h
    move v1, v3
    goto +2h
    move v1, v4
    if-nez v1, +012h
    iget-object v1, v11, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$authorize$platformCallback$1;->this$0 Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl;
    iget-object v2, v11, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$authorize$platformCallback$1;->$callback Lcom/bytedance/trae/login/api/IAccountCallback;
    iget-object v3, v11, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$authorize$platformCallback$1;->$businessScene Ljava/lang/String;
    new-instance v4, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$authorize$platformCallback$1$$ExternalSyntheticLambda0;
    invoke-direct v4, v2, v12, v3, v0, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$authorize$platformCallback$1$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/login/api/IAccountCallback; Lcom/bytedance/sdk/account/api/call/UserApiResponse; Ljava/lang/String; Ljava/lang/String;)V
    invoke-static v1, v4, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl;->access$postToMain(Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl; Lkotlin/jvm/functions/Function0;)V
    goto/16 +0e0h
    new-instance v0, Ljava/util/LinkedHashMap;
    invoke-direct v0, Ljava/util/LinkedHashMap;-><init>()V
    move-object v10, v0
    check-cast v10, Ljava/util/Map;
    iget-object v0, v12, Lcom/bytedance/sdk/account/api/call/UserApiResponse;->mCancelToken Ljava/lang/String;
    if-eqz v0, +015h
    move-object v1, v0
    check-cast v1, Ljava/lang/CharSequence;
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-lez v1, +004h
    move v1, v4
    goto +2h
    move v1, v3
    if-eqz v1, +007h
    const-string v1, "cancel_token"
    invoke-interface v10, v1, v0, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    iget v0, v12, Lcom/bytedance/sdk/account/api/call/UserApiResponse;->error I
    const/16 v1, -1001
    if-ne v0, v1, +006h
    const-string/jumbo v0, user_cancelled
    goto +1eh
    iget v0, v12, Lcom/bytedance/sdk/account/api/call/UserApiResponse;->error I
    const/16 v1, -1004
    if-ne v0, v1, +005h
    const-string v0, "authorize_error"
    goto +15h
    iget v0, v12, Lcom/bytedance/sdk/account/api/call/UserApiResponse;->error I
    const/16 v1, -1005
    if-ne v0, v1, +006h
    const-string/jumbo v0, request_api_error
    goto +bh
    iget v0, v12, Lcom/bytedance/sdk/account/api/call/UserApiResponse;->error I
    if-lez v0, +006h
    const-string/jumbo v0, passport_error
    goto +3h
    const-string v0, "login_error"
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct v1, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v1, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v2, "("
    invoke-direct v0, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget v2, v12, Lcom/bytedance/sdk/account/api/call/UserApiResponse;->error I
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v2, 41
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v1, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    iget-object v0, v12, Lcom/bytedance/sdk/account/api/call/UserApiResponse;->errorMsg Ljava/lang/String;
    move-object v2, v0
    check-cast v2, Ljava/lang/CharSequence;
    if-eqz v2, +00bh
    invoke-interface v2, Ljava/lang/CharSequence;->length()I
    move-result v2
    if-nez v2, +003h
    goto +3h
    move v2, v3
    goto +2h
    move v2, v4
    if-nez v2, +015h
    new-instance v2, Ljava/lang/StringBuilder;
    const-string/jumbo v5, |error_msg=
    invoke-direct v2, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v1, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    iget v0, v12, Lcom/bytedance/sdk/account/api/call/UserApiResponse;->mDetailErrorCode I
    if-eqz v0, +017h
    new-instance v0, Ljava/lang/StringBuilder;
    const-string/jumbo v2, |detail_code=
    invoke-direct v0, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget v2, v12, Lcom/bytedance/sdk/account/api/call/UserApiResponse;->mDetailErrorCode I
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v1, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    iget-object v0, v12, Lcom/bytedance/sdk/account/api/call/UserApiResponse;->mDetailErrorMsg Ljava/lang/String;
    move-object v2, v0
    check-cast v2, Ljava/lang/CharSequence;
    if-eqz v2, +008h
    invoke-interface v2, Ljava/lang/CharSequence;->length()I
    move-result v2
    if-nez v2, +003h
    move v3, v4
    if-nez v3, +015h
    new-instance v2, Ljava/lang/StringBuilder;
    const-string/jumbo v3, |detail_msg=
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v1, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v8
    iget-object v0, v11, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$authorize$platformCallback$1;->this$0 Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl;
    iget-object v6, v11, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$authorize$platformCallback$1;->$callback Lcom/bytedance/trae/login/api/IAccountCallback;
    iget-object v9, v11, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$authorize$platformCallback$1;->$businessScene Ljava/lang/String;
    new-instance v1, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$authorize$platformCallback$1$$ExternalSyntheticLambda1;
    move-object v5, v1
    move-object v7, v12
    invoke-direct/range v5 ... v10, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$authorize$platformCallback$1$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/login/api/IAccountCallback; Lcom/bytedance/sdk/account/api/call/UserApiResponse; Ljava/lang/String; Ljava/lang/String; Ljava/util/Map;)V
    invoke-static v0, v1, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl;->access$postToMain(Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl; Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method

.method public onLoginSuccess(com.bytedance.sdk.account.api.call.UserApiResponse)void
    .registers 19
    # ins_size=2
    move-object/from16 v0, v17
    move-object/from16 v1, v18
    const-string/jumbo v2, response
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v3, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string v4, "douyin_auth_success_no_bind"
    const-string v5, "douyin"
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/16 v15, 2044
    const/16 v16, 0
    invoke-static/range v3 ... v16, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel$default(Lcom/bytedance/trae/login/traeauth/TraeAuthManager; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    sget-object v2, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    new-instance v3, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$authorize$platformCallback$1$onLoginSuccess$1;
    iget-object v4, v0, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$authorize$platformCallback$1;->this$0 Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl;
    iget-object v5, v0, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$authorize$platformCallback$1;->$businessScene Ljava/lang/String;
    iget-object v6, v0, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$authorize$platformCallback$1;->$callback Lcom/bytedance/trae/login/api/IAccountCallback;
    invoke-direct v3, v4, v1, v5, v6, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$authorize$platformCallback$1$onLoginSuccess$1;-><init>(Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl; Lcom/bytedance/sdk/account/api/call/UserApiResponse; Ljava/lang/String; Lcom/bytedance/trae/login/api/IAccountCallback;)V
    check-cast v3, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback;
    const-string v1, "douyin"
    invoke-virtual v2, v1, v3, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->onPassportLoginSuccess(Ljava/lang/String; Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback;)V
    return-void 
.end method
