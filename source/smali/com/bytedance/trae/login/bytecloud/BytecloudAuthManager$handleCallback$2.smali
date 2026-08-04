# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager$handleCallback$2;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "BytecloudAuthManager.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $uri:Landroid/net/Uri;
.field  label:I


.method constructor <init>(android.net.Uri  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager$handleCallback$2;->$uri Landroid/net/Uri;
    const/4 v1, 2
    invoke-direct v0, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 4
    # ins_size=3
    new-instance v2, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager$handleCallback$2;
    iget-object v0, v1, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager$handleCallback$2;->$uri Landroid/net/Uri;
    invoke-direct v2, v0, v3, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager$handleCallback$2;-><init>(Landroid/net/Uri; Lkotlin/coroutines/Continuation;)V
    check-cast v2, Lkotlin/coroutines/Continuation;
    return-object v2
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager$handleCallback$2;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager$handleCallback$2;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager$handleCallback$2;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager$handleCallback$2;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 29
    # ins_size=2
    move-object/from16 v1, v27
    const-string/jumbo v0, optString(...)
    const-string v2, ""
    const-string v3, "BytecloudAuth"
    const-string v4, "ByteCloud 登录成功: user="
    const-string/jumbo v5, 回调 state 校验失败: hasPending=
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    iget v6, v1, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager$handleCallback$2;->label I
    if-nez v6, +1dfh
    invoke-static/range v28, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v6, v1, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager$handleCallback$2;->$uri Landroid/net/Uri;
    const-string v7, "client_state"
    invoke-virtual v6, v7, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v6
    sget-object v7, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;
    invoke-virtual v7, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->getBytecloudOAuthState()Ljava/lang/String;
    move-result-object v7
    move-object v8, v7
    check-cast v8, Ljava/lang/CharSequence;
    invoke-interface v8, Ljava/lang/CharSequence;->length()I
    move-result v8
    const/4 v9, 1
    const/4 v10, 0
    if-lez v8, +004h
    move v8, v9
    goto +2h
    move v8, v10
    const/4 v11, 0
    if-eqz v8, +003h
    goto +2h
    move-object v7, v11
    sget-object v8, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;
    invoke-virtual v8, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->getBytecloudOAuthStateTimestamp()J
    move-result-wide v12
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v14
    if-eqz v7, +012h
    const-wide/16 v16, 0
    cmp-long v8, v12, v16
    if-lez v8, +00ch
    sub-long/2addr v14, v12
    const-wide/32 v12, 300000
    cmp-long v8, v14, v12
    if-gtz v8, +004h
    move v8, v9
    goto +2h
    move v8, v10
    if-eqz v8, +00ch
    if-eqz v6, +00ah
    invoke-static v6, v7, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v12
    if-eqz v12, +004h
    move v12, v9
    goto +2h
    move v12, v10
    if-eqz v7, +006h
    if-nez v8, +004h
    move v7, v9
    goto +2h
    move v7, v10
    if-eqz v7, +007h
    sget-object v13, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;
    invoke-virtual v13, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->clearBytecloudOAuthState()V
    sget-object v13, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;
    invoke-virtual v13, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->getJwtToken()Ljava/lang/String;
    move-result-object v13
    check-cast v13, Ljava/lang/CharSequence;
    invoke-interface v13, Ljava/lang/CharSequence;->length()I
    move-result v13
    if-lez v13, +004h
    move v13, v9
    goto +2h
    move v13, v10
    if-eqz v13, +014h
    if-nez v12, +012h
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string/jumbo v2, 已登录用户收到无效 state 的回调，拒绝处理
    invoke-virtual v0, v3, v2, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/login/bytecloud/CallbackResult$Rejected;
    const-string v2, "already_logged_in_no_valid_state"
    invoke-direct v0, v2, Lcom/bytedance/trae/login/bytecloud/CallbackResult$Rejected;-><init>(Ljava/lang/String;)V
    return-object v0
    if-nez v12, +03ah
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    if-eqz v8, +004h
    move v4, v9
    goto +2h
    move v4, v10
    invoke-virtual v2, v4, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v4, ", callbackState="
    invoke-virtual v2, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v4, ", expired="
    invoke-virtual v2, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    if-eqz v7, +003h
    goto +2h
    move v9, v10
    invoke-virtual v2, v9, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v3, v2, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/login/bytecloud/CallbackResult$Rejected;
    const-string/jumbo v2, state_mismatch
    invoke-direct v0, v2, Lcom/bytedance/trae/login/bytecloud/CallbackResult$Rejected;-><init>(Ljava/lang/String;)V
    return-object v0
    sget-object v5, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;
    invoke-virtual v5, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->clearBytecloudOAuthState()V
    iget-object v5, v1, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager$handleCallback$2;->$uri Landroid/net/Uri;
    const-string v6, "IDEUserToken"
    invoke-virtual v5, v6, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v5
    iget-object v6, v1, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager$handleCallback$2;->$uri Landroid/net/Uri;
    const-string/jumbo v7, userInfo
    invoke-virtual v6, v7, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v6
    move-object v7, v5
    check-cast v7, Ljava/lang/CharSequence;
    if-eqz v7, +00bh
    invoke-interface v7, Ljava/lang/CharSequence;->length()I
    move-result v7
    if-nez v7, +003h
    goto +3h
    move v7, v10
    goto +2h
    move v7, v9
    if-eqz v7, +012h
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string/jumbo v2, 回调中无 IDEUserToken
    invoke-virtual v0, v3, v2, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/login/bytecloud/CallbackResult$Rejected;
    const-string v2, "missing_token"
    invoke-direct v0, v2, Lcom/bytedance/trae/login/bytecloud/CallbackResult$Rejected;-><init>(Ljava/lang/String;)V
    return-object v0
    move-object v7, v6
    check-cast v7, Ljava/lang/CharSequence;
    if-eqz v7, +00bh
    invoke-interface v7, Ljava/lang/CharSequence;->length()I
    move-result v7
    if-nez v7, +003h
    goto +3h
    move v7, v10
    goto +2h
    move v7, v9
    if-eqz v7, +012h
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string/jumbo v2, 回调中无 userInfo
    invoke-virtual v0, v3, v2, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/login/bytecloud/CallbackResult$Rejected;
    const-string v2, "missing_user_info"
    invoke-direct v0, v2, Lcom/bytedance/trae/login/bytecloud/CallbackResult$Rejected;-><init>(Ljava/lang/String;)V
    return-object v0
    new-instance v7, Lorg/json/JSONObject;
    invoke-direct v7, v6, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V
    const-string/jumbo v6, username
    invoke-virtual v7, v6, v2, Lorg/json/JSONObject;->optString(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v6
    invoke-static v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    move-object v8, v6
    check-cast v8, Ljava/lang/CharSequence;
    invoke-interface v8, Ljava/lang/CharSequence;->length()I
    move-result v8
    if-nez v8, +003h
    goto +2h
    move v9, v10
    if-eqz v9, +012h
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string/jumbo v2, userInfo 中无 username
    invoke-virtual v0, v3, v2, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/login/bytecloud/CallbackResult$Rejected;
    const-string v2, "missing_username"
    invoke-direct v0, v2, Lcom/bytedance/trae/login/bytecloud/CallbackResult$Rejected;-><init>(Ljava/lang/String;)V
    return-object v0
    const-string v8, "employee_id"
    invoke-virtual v7, v8, v2, Lorg/json/JSONObject;->optString(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v23
    new-instance v8, Lcom/bytedance/trae/login/user/UserInfo;
    const-string v9, "avatar_url"
    invoke-virtual v7, v9, v2, Lorg/json/JSONObject;->optString(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v15
    invoke-static v15, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const/16 v16, 0
    const-string v9, "email"
    invoke-virtual v7, v9, v2, Lorg/json/JSONObject;->optString(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v9
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 0
    const-string v10, "ai_region"
    invoke-virtual v7, v10, v2, Lorg/json/JSONObject;->optString(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static/range v23, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    const/16 v24, 0
    const/16 v25, 2536
    const/16 v26, 0
    move-object v12, v8
    move-object v13, v6
    move-object v14, v6
    move-object/from16 v17, v9
    move-object/from16 v22, v2
    invoke-direct/range v12 ... v26, Lcom/bytedance/trae/login/user/UserInfo;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;
    invoke-virtual v0, v5, v11, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->saveJwtToken(Ljava/lang/String; Ljava/lang/Long;)V
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;
    invoke-virtual v0, v8, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->saveUserInfo(Lcom/bytedance/trae/login/user/UserInfo;)V
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;
    const-string v2, "bytecloud"
    invoke-virtual v0, v2, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->saveLoginPlatform(Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v3, v2, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/login/bytecloud/CallbackResult$Success;->INSTANCE Lcom/bytedance/trae/login/bytecloud/CallbackResult$Success;
    check-cast v0, Lcom/bytedance/trae/login/bytecloud/CallbackResult;
    goto +36h
    move-exception v0
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v4, Ljava/lang/StringBuilder;
    const-string/jumbo v5, 处理回调异常: 
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, Ljava/lang/Exception;->getMessage()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v2, v3, v4, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v2, Lcom/bytedance/trae/login/bytecloud/CallbackResult$Rejected;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "exception: "
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, Ljava/lang/Exception;->getMessage()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v3, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-direct v2, v0, Lcom/bytedance/trae/login/bytecloud/CallbackResult$Rejected;-><init>(Ljava/lang/String;)V
    move-object v0, v2
    check-cast v0, Lcom/bytedance/trae/login/bytecloud/CallbackResult;
    return-object v0
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    :try_start_0x18
.end method
