# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "TraeAuthManager.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $callback:Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback;
.field final synthetic $loginPlatform:Ljava/lang/String;
.field  J$0:J
.field  J$1:J
.field private synthetic L$0:Ljava/lang/Object;
.field  L$1:Ljava/lang/Object;
.field  L$2:Ljava/lang/Object;
.field  L$3:Ljava/lang/Object;
.field  L$4:Ljava/lang/Object;
.field  L$5:Ljava/lang/Object;
.field  label:I


.method constructor <init>(java.lang.String  com.bytedance.trae.login.traeauth.TraeAuthManager$TraeAuthCallback  kotlin.coroutines.Continuation)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->$loginPlatform Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->$callback Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback;
    const/4 v1, 2
    invoke-direct v0, v1, v3, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 6
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;
    iget-object v1, v3, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->$loginPlatform Ljava/lang/String;
    iget-object v2, v3, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->$callback Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback;
    invoke-direct v0, v1, v2, v5, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;-><init>(Ljava/lang/String; Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback; Lkotlin/coroutines/Continuation;)V
    iput-object v4, v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lkotlin/coroutines/Continuation;
    return-object v0
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 55
    # ins_size=2
    move-object/from16 v1, v53
    const-string/jumbo v2, onPassportLoginSuccess: fetchUserInfo done in 
    const-string/jumbo v0, onPassportLoginSuccess: doGetRefreshToken done in 
    const-string v3, "fetchUserInfo failed (non-blocking): "
    const-string/jumbo v4, onPassportLoginSuccess: doExchangeToken done in 
    const-string/jumbo v5, onPassportLoginSuccess: performCheckLoginSync done in 
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v6
    iget v7, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->label I
    const-string v8, "device_limit"
    const-string v9, "failed_step"
    const-string/jumbo v10, reason
    const-string v11, "icube_login_failure"
    const-string v13, "login_platform"
    const-string v14, "duration_ms"
    const-string v15, "ms"
    const-string v12, "TraeAuthManager"
    move-object/from16 v17, v11
    const-string v11, "device_limit_continue_"
    packed-switch v7, +000086bh
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    invoke-static/range v54, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +7a8h
    invoke-static/range v54, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +855h
    iget-wide v2, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->J$0 J
    invoke-static/range v54, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v18, v8
    move-object/from16 v19, v9
    move-object/from16 v20, v10
    move-object v5, v11
    move-object v4, v13
    move-object/from16 v22, v14
    move-object v10, v6
    move-object v13, v12
    goto/16 +5dfh
    iget-wide v2, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->J$1 J
    move-wide/from16 v18, v2
    iget-wide v2, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->J$0 J
    iget-object v0, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->L$4 Ljava/lang/Object;
    check-cast v0, Lkotlin/jvm/internal/Ref$LongRef;
    iget-object v4, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->L$3 Ljava/lang/Object;
    check-cast v4, Lkotlin/jvm/internal/Ref$LongRef;
    iget-object v7, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->L$2 Ljava/lang/Object;
    check-cast v7, Lkotlin/jvm/internal/Ref$LongRef;
    move-object/from16 v16, v0
    iget-object v0, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->L$1 Ljava/lang/Object;
    check-cast v0, Lkotlin/jvm/internal/Ref$LongRef;
    move-object/from16 v20, v0
    iget-object v0, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lkotlin/jvm/internal/Ref$LongRef;
    invoke-static/range v54, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v23, v5
    move-object/from16 v35, v11
    move-object/from16 v34, v12
    move-object/from16 v21, v13
    move-object/from16 v22, v14
    move-object v11, v0
    move-object v12, v4
    move-object v4, v6
    move-object v14, v7
    move-object v7, v15
    move-object/from16 v0, v16
    move-wide v5, v2
    move-wide/from16 v2, v18
    move-object/from16 v18, v8
    move-object/from16 v19, v9
    move-object/from16 v50, v20
    move-object/from16 v20, v10
    move-object/from16 v10, v50
    goto/16 +4d0h
    move-exception v0
    move-object/from16 v18, v8
    goto/16 +0fch
    move-exception v0
    move-object v12, v9
    move-object v5, v11
    move-object v4, v13
    move-object v13, v14
    move-object/from16 v15, v17
    move-object v14, v8
    goto/16 +17eh
    move-object/from16 v18, v8
    iget-wide v7, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->J$1 J
    move-wide/from16 v19, v7
    iget-wide v7, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->J$0 J
    iget-object v0, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->L$5 Ljava/lang/Object;
    move-object v4, v0
    check-cast v4, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;
    iget-object v0, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->L$4 Ljava/lang/Object;
    move-object/from16 v21, v0
    check-cast v21, Lkotlin/jvm/internal/Ref$LongRef;
    iget-object v0, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->L$3 Ljava/lang/Object;
    move-object/from16 v22, v0
    check-cast v22, Lkotlin/jvm/internal/Ref$LongRef;
    iget-object v0, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->L$2 Ljava/lang/Object;
    move-object/from16 v23, v0
    check-cast v23, Lkotlin/jvm/internal/Ref$LongRef;
    iget-object v0, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->L$1 Ljava/lang/Object;
    move-object/from16 v24, v0
    check-cast v24, Lkotlin/jvm/internal/Ref$LongRef;
    iget-object v0, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->L$0 Ljava/lang/Object;
    move-object/from16 v25, v0
    check-cast v25, Lkotlin/jvm/internal/Ref$LongRef;
    invoke-static/range v54, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v0, v54
    move-object/from16 v34, v12
    move-object/from16 v27, v15
    move-object/from16 v12, v22
    move-object v15, v4
    move-object v4, v6
    move-object/from16 v22, v14
    move-object/from16 v14, v23
    move-object/from16 v23, v5
    move-object/from16 v50, v24
    move-object/from16 v24, v2
    move-object/from16 v51, v25
    move-object/from16 v25, v3
    move-wide v2, v7
    move-wide/from16 v7, v19
    move-object/from16 v19, v9
    move-object/from16 v20, v10
    move-object/from16 v9, v21
    move-object/from16 v10, v50
    move-object/from16 v21, v13
    move-object v13, v11
    move-object/from16 v11, v51
    goto/16 +384h
    move-exception v0
    move-object/from16 v34, v12
    move-object/from16 v27, v15
    move-object/from16 v12, v22
    move-object v15, v4
    move-object v4, v6
    move-object/from16 v22, v14
    move-object/from16 v14, v23
    move-object/from16 v23, v5
    move-object/from16 v50, v24
    move-object/from16 v24, v2
    move-object/from16 v51, v25
    move-object/from16 v25, v3
    move-wide v2, v7
    move-wide/from16 v7, v19
    move-object/from16 v19, v9
    move-object/from16 v20, v10
    move-object/from16 v9, v21
    move-object/from16 v10, v50
    move-object/from16 v21, v13
    move-object v13, v11
    move-object/from16 v11, v51
    goto/16 +3ach
    move-object/from16 v18, v8
    iget-wide v7, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->J$1 J
    move-wide/from16 v19, v7
    iget-wide v7, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->J$0 J
    iget-object v0, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->L$5 Ljava/lang/Object;
    check-cast v0, Lkotlin/jvm/internal/Ref$LongRef;
    move-object/from16 v21, v0
    iget-object v0, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->L$4 Ljava/lang/Object;
    check-cast v0, Lkotlin/jvm/internal/Ref$LongRef;
    move-object/from16 v22, v0
    iget-object v0, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->L$3 Ljava/lang/Object;
    check-cast v0, Lkotlin/jvm/internal/Ref$LongRef;
    move-object/from16 v23, v0
    iget-object v0, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->L$2 Ljava/lang/Object;
    check-cast v0, Lkotlin/jvm/internal/Ref$LongRef;
    move-object/from16 v24, v0
    iget-object v0, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->L$1 Ljava/lang/Object;
    check-cast v0, Lkotlin/jvm/internal/Ref$LongRef;
    move-object/from16 v25, v0
    iget-object v0, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lkotlinx/coroutines/CoroutineScope;
    invoke-static/range v54, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v0, v54
    move-object/from16 v26, v4
    move-object/from16 v50, v24
    move-object/from16 v24, v2
    move-object v2, v15
    move-object/from16 v51, v25
    move-object/from16 v25, v3
    move-object v3, v12
    move-object/from16 v12, v22
    move-object/from16 v22, v14
    move-object/from16 v14, v23
    move-object/from16 v23, v5
    move-wide/from16 v4, v19
    move-object/from16 v19, v9
    move-object/from16 v20, v10
    move-object/from16 v9, v21
    move-object/from16 v10, v50
    move-object/from16 v21, v13
    move-object v13, v11
    move-object/from16 v11, v51
    goto/16 +278h
    move-exception v0
    move-wide v2, v7
    goto +19h
    move-exception v0
    move-wide v2, v7
    goto +23h
    move-object/from16 v18, v8
    iget-wide v2, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->J$0 J
    invoke-static/range v54, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v19, v9
    move-object/from16 v20, v10
    move-object/from16 v34, v12
    move-object/from16 v21, v13
    move-object/from16 v22, v14
    move-object v13, v11
    goto/16 +1b5h
    move-exception v0
    move-object/from16 v19, v9
    move-object/from16 v20, v10
    move-object v5, v11
    move-object v4, v13
    move-object/from16 v22, v14
    move-object v10, v6
    move-object v13, v12
    goto/16 +59eh
    move-exception v0
    move-object v12, v9
    move-object v5, v11
    move-object v4, v13
    move-object v13, v14
    move-object/from16 v15, v17
    move-object/from16 v14, v18
    goto/16 +077h
    move-object/from16 v18, v8
    iget-wide v7, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->J$1 J
    move-wide/from16 v19, v7
    iget-wide v7, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->J$0 J
    move-wide/from16 v21, v7
    iget-object v7, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->L$5 Ljava/lang/Object;
    check-cast v7, Lkotlin/jvm/internal/Ref$LongRef;
    iget-object v8, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->L$4 Ljava/lang/Object;
    check-cast v8, Lkotlin/jvm/internal/Ref$LongRef;
    move-object/from16 v23, v7
    iget-object v7, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->L$3 Ljava/lang/Object;
    check-cast v7, Lkotlin/jvm/internal/Ref$LongRef;
    move-object/from16 v24, v7
    iget-object v7, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->L$2 Ljava/lang/Object;
    check-cast v7, Lkotlin/jvm/internal/Ref$LongRef;
    move-object/from16 v25, v7
    iget-object v7, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->L$1 Ljava/lang/Object;
    check-cast v7, Lkotlin/jvm/internal/Ref$LongRef;
    move-object/from16 v26, v7
    iget-object v7, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->L$0 Ljava/lang/Object;
    check-cast v7, Lkotlinx/coroutines/CoroutineScope;
    invoke-static/range v54, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v35, v11
    move-object/from16 v34, v12
    move-object/from16 v27, v15
    move-object/from16 v11, v54
    move-object v12, v8
    move-object v8, v7
    move-object/from16 v7, v25
    move-object/from16 v25, v3
    move-object/from16 v50, v24
    move-object/from16 v24, v2
    move-wide/from16 v2, v21
    move-object/from16 v21, v13
    move-object/from16 v22, v14
    move-object/from16 v14, v50
    move-object/from16 v51, v26
    move-object/from16 v26, v4
    move-object/from16 v52, v23
    move-object/from16 v23, v5
    move-wide/from16 v4, v19
    move-object/from16 v19, v9
    move-object/from16 v20, v10
    move-object/from16 v9, v52
    move-object/from16 v10, v51
    goto/16 +0d6h
    move-exception v0
    move-object/from16 v19, v9
    move-object/from16 v20, v10
    move-object v5, v11
    move-object v4, v13
    move-wide/from16 v2, v21
    move-object v10, v6
    move-object v13, v12
    move-object/from16 v22, v14
    goto/16 +529h
    move-exception v0
    move-object v12, v9
    move-object v5, v11
    move-object v4, v13
    move-object v13, v14
    move-object/from16 v15, v17
    move-object/from16 v14, v18
    move-wide/from16 v2, v21
    move-object v11, v10
    move-object v10, v6
    goto/16 +5d3h
    move-object/from16 v18, v8
    invoke-static/range v54, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v7, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->L$0 Ljava/lang/Object;
    check-cast v7, Lkotlinx/coroutines/CoroutineScope;
    move-object/from16 v19, v9
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v8
    move-object/from16 v20, v10
    new-instance v10, Lkotlin/jvm/internal/Ref$LongRef;
    invoke-direct v10, Lkotlin/jvm/internal/Ref$LongRef;-><init>()V
    move-object/from16 v21, v13
    new-instance v13, Lkotlin/jvm/internal/Ref$LongRef;
    invoke-direct v13, Lkotlin/jvm/internal/Ref$LongRef;-><init>()V
    move-object/from16 v22, v14
    new-instance v14, Lkotlin/jvm/internal/Ref$LongRef;
    invoke-direct v14, Lkotlin/jvm/internal/Ref$LongRef;-><init>()V
    move-object/from16 v23, v5
    new-instance v5, Lkotlin/jvm/internal/Ref$LongRef;
    invoke-direct v5, Lkotlin/jvm/internal/Ref$LongRef;-><init>()V
    move-object/from16 v24, v2
    new-instance v2, Lkotlin/jvm/internal/Ref$LongRef;
    invoke-direct v2, Lkotlin/jvm/internal/Ref$LongRef;-><init>()V
    move-object/from16 v25, v3
    sget-object v3, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    move-object/from16 v26, v4
    new-instance v4, Ljava/lang/StringBuilder;
    move-object/from16 v27, v15
    const-string/jumbo v15, onPassportLoginSuccess: begin, deviceId=
    invoke-direct v4, v15, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    sget-object v15, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v15, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getDeviceId()Ljava/lang/String;
    move-result-object v15
    invoke-virtual v4, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v15, ", baseUrl="
    invoke-virtual v4, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    sget-object v15, Lcom/bytedance/trae/login/traeauth/TraeAuthConfig;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthConfig;
    invoke-virtual v15, Lcom/bytedance/trae/login/traeauth/TraeAuthConfig;->getBaseUrl()Ljava/lang/String;
    move-result-object v15
    invoke-virtual v4, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v15, ", loginChannel="
    invoke-virtual v4, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    sget-object v15, Lcom/bytedance/trae/login/traeauth/TraeAuthConfig;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthConfig;
    invoke-virtual v15, Lcom/bytedance/trae/login/traeauth/TraeAuthConfig;->getLoginChannel()Ljava/lang/String;
    move-result-object v15
    invoke-virtual v4, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v12, v4, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v3
    sget-object v28, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const/16 v29, 2
    const-string v30, "doGetRefreshToken"
    iget-object v15, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->$loginPlatform Ljava/lang/String;
    move-object/from16 v34, v12
    new-instance v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1$refreshResult$1;
    move-object/from16 v35, v11
    const/4 v11, 0
    invoke-direct v12, v11, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1$refreshResult$1;-><init>(Lkotlin/coroutines/Continuation;)V
    move-object/from16 v32, v12
    check-cast v32, Lkotlin/jvm/functions/Function1;
    move-object/from16 v33, v1
    check-cast v33, Lkotlin/coroutines/Continuation;
    iput-object v7, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->L$0 Ljava/lang/Object;
    iput-object v10, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->L$1 Ljava/lang/Object;
    iput-object v13, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->L$2 Ljava/lang/Object;
    iput-object v14, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->L$3 Ljava/lang/Object;
    iput-object v5, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->L$4 Ljava/lang/Object;
    iput-object v2, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->L$5 Ljava/lang/Object;
    iput-wide v8, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->J$0 J
    iput-wide v3, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->J$1 J
    const/4 v11, 1
    iput v11, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->label I
    move-object/from16 v31, v15
    invoke-static/range v28 ... v33, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->access$retryOnTransient(Lcom/bytedance/trae/login/traeauth/TraeAuthManager; I Ljava/lang/String; Ljava/lang/String; Lkotlin/jvm/functions/Function1; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v11
    if-ne v11, v6, +003h
    return-object v6
    move-object v12, v5
    move-wide v4, v3
    move-wide/from16 v50, v8
    move-object v9, v2
    move-object v8, v7
    move-wide/from16 v2, v50
    move-object v7, v13
    check-cast v11, Lcom/bytedance/trae/login/traeauth/TraeGetRefreshTokenResult;
    invoke-virtual v11, Lcom/bytedance/trae/login/traeauth/TraeGetRefreshTokenResult;->getDeviceLimitReached()Ljava/lang/Boolean;
    move-result-object v13
    move-object/from16 v16, v9
    const/4 v15, 1
    invoke-static v15, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v9
    invoke-static v13, v9, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v9
    if-eqz v9, +08bh
    sget-object v36, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string v37, "login_failure"
    new-instance v0, Ljava/lang/StringBuilder;
    move-object/from16 v13, v35
    invoke-direct v0, v13, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v4, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->$loginPlatform Ljava/lang/String;
    invoke-virtual v0, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v38
    const/16 v39, 0
    const-string v40, "login_continue_with_device_limit_error"
    const/16 v41, 0
    const/16 v42, 0
    const/16 v43, 0
    const/16 v44, 0
    const/16 v45, 0
    const/16 v46, 0
    const/16 v47, 0
    const/16 v48, 2036
    const/16 v49, 0
    invoke-static/range v36 ... v49, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel$default(Lcom/bytedance/trae/login/traeauth/TraeAuthManager; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    invoke-static Lkotlinx/coroutines/Dispatchers;->getMain()Lkotlinx/coroutines/MainCoroutineDispatcher;
    move-result-object v0
    check-cast v0, Lkotlin/coroutines/CoroutineContext;
    new-instance v4, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1$1;
    iget-object v5, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->$callback Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback;
    const/4 v7, 0
    invoke-direct v4, v5, v7, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1$1;-><init>(Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback; Lkotlin/coroutines/Continuation;)V
    check-cast v4, Lkotlin/jvm/functions/Function2;
    move-object v5, v1
    check-cast v5, Lkotlin/coroutines/Continuation;
    iput-object v7, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->L$0 Ljava/lang/Object;
    iput-object v7, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->L$1 Ljava/lang/Object;
    iput-object v7, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->L$2 Ljava/lang/Object;
    iput-object v7, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->L$3 Ljava/lang/Object;
    iput-object v7, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->L$4 Ljava/lang/Object;
    iput-object v7, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->L$5 Ljava/lang/Object;
    iput-wide v2, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->J$0 J
    const/4 v7, 2
    iput v7, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->label I
    invoke-static v0, v4, v5, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v6, +003h
    return-object v6
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
    move-exception v0
    move-object v10, v6
    move-object v5, v13
    move-object/from16 v4, v21
    move-object/from16 v13, v34
    goto/16 +3ech
    move-exception v0
    move-object v10, v6
    move-object v5, v13
    move-object/from16 v15, v17
    move-object/from16 v14, v18
    move-object/from16 v12, v19
    move-object/from16 v11, v20
    move-object/from16 v4, v21
    goto/16 +3d2h
    move-exception v0
    goto/16 +399h
    move-exception v0
    move-object v10, v6
    move-object/from16 v15, v17
    move-object/from16 v14, v18
    move-object/from16 v12, v19
    move-object/from16 v11, v20
    move-object/from16 v4, v21
    move-object/from16 v13, v22
    move-object/from16 v5, v35
    goto/16 +481h
    move-object/from16 v13, v35
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v28
    sub-long v4, v28, v4
    iput-wide v4, v7, Lkotlin/jvm/internal/Ref$LongRef;->element J
    sget-object v4, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v5, Ljava/lang/StringBuilder;
    invoke-direct v5, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    move-wide/from16 v28, v2
    iget-wide v2, v7, Lkotlin/jvm/internal/Ref$LongRef;->element J
    invoke-virtual v5, v2, v3, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    move-object/from16 v2, v27
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    move-object/from16 v3, v34
    invoke-virtual v4, v3, v0, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;
    invoke-virtual v11, Lcom/bytedance/trae/login/traeauth/TraeGetRefreshTokenResult;->getRefreshToken()Ljava/lang/String;
    move-result-object v4
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-virtual v11, Lcom/bytedance/trae/login/traeauth/TraeGetRefreshTokenResult;->getRefreshExpireAt()Ljava/lang/Long;
    move-result-object v5
    invoke-virtual v0, v4, v5, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->saveRefreshToken(Ljava/lang/String; Ljava/lang/Long;)V
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v4
    sget-object v30, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const/16 v31, 2
    const-string v32, "doExchangeToken"
    iget-object v0, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->$loginPlatform Ljava/lang/String;
    new-instance v9, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1$exchangeResult$1;
    const/4 v15, 0
    invoke-direct v9, v11, v15, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1$exchangeResult$1;-><init>(Lcom/bytedance/trae/login/traeauth/TraeGetRefreshTokenResult; Lkotlin/coroutines/Continuation;)V
    move-object/from16 v34, v9
    check-cast v34, Lkotlin/jvm/functions/Function1;
    move-object/from16 v35, v1
    check-cast v35, Lkotlin/coroutines/Continuation;
    iput-object v8, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->L$0 Ljava/lang/Object;
    iput-object v10, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->L$1 Ljava/lang/Object;
    iput-object v7, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->L$2 Ljava/lang/Object;
    iput-object v14, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->L$3 Ljava/lang/Object;
    iput-object v12, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->L$4 Ljava/lang/Object;
    move-object/from16 v8, v16
    iput-object v8, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->L$5 Ljava/lang/Object;
    move-object v9, v7
    move-object/from16 v16, v8
    move-wide/from16 v7, v28
    iput-wide v7, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->J$0 J
    iput-wide v4, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->J$1 J
    const/4 v11, 3
    iput v11, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->label I
    move-object/from16 v33, v0
    invoke-static/range v30 ... v35, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->access$retryOnTransient(Lcom/bytedance/trae/login/traeauth/TraeAuthManager; I Ljava/lang/String; Ljava/lang/String; Lkotlin/jvm/functions/Function1; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v6, +003h
    return-object v6
    move-object v11, v10
    move-object v10, v9
    move-object/from16 v9, v16
    move-object v15, v0
    check-cast v15, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v27
    sub-long v4, v27, v4
    iput-wide v4, v14, Lkotlin/jvm/internal/Ref$LongRef;->element J
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v4, Ljava/lang/StringBuilder;
    move-object/from16 v5, v26
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    move-object/from16 v16, v6
    iget-wide v5, v14, Lkotlin/jvm/internal/Ref$LongRef;->element J
    invoke-virtual v4, v5, v6, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v0, v3, v4, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;
    invoke-virtual v15, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;->getToken()Ljava/lang/String;
    move-result-object v4
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-virtual v15, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;->getTokenExpireAt()Ljava/lang/Long;
    move-result-object v5
    invoke-virtual v0, v4, v5, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->saveJwtToken(Ljava/lang/String; Ljava/lang/Long;)V
    invoke-virtual v15, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;->getRefreshToken()Ljava/lang/String;
    move-result-object v0
    if-eqz v0, +013h
    sget-object v4, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;
    invoke-virtual v15, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;->getRefreshExpireAt()Ljava/lang/Long;
    move-result-object v5
    invoke-virtual v4, v0, v5, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->saveRefreshToken(Ljava/lang/String; Ljava/lang/Long;)V
    goto +8h
    move-exception v0
    move-wide v2, v7
    move-object v5, v13
    move-object/from16 v10, v16
    goto/16 -0e6h
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v4
    const/16 v6, 1000
    move-object/from16 v27, v2
    move-object/from16 v34, v3
    int-to-long v2, v6
    div-long/2addr v4, v2
    invoke-virtual v0, v4, v5, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->saveLastExchangeSuccessAt(J)V
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v2
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    sget-object v0, Lcom/bytedance/trae/login/user/UserInfoFetcher;->INSTANCE Lcom/bytedance/trae/login/user/UserInfoFetcher;
    invoke-virtual v15, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;->getToken()Ljava/lang/String;
    move-result-object v4
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    iput-object v11, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->L$0 Ljava/lang/Object;
    iput-object v10, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->L$1 Ljava/lang/Object;
    iput-object v14, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->L$2 Ljava/lang/Object;
    iput-object v12, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->L$3 Ljava/lang/Object;
    iput-object v9, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->L$4 Ljava/lang/Object;
    iput-object v15, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->L$5 Ljava/lang/Object;
    iput-wide v7, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->J$0 J
    iput-wide v2, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->J$1 J
    const/4 v5, 4
    iput v5, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->label I
    invoke-virtual v0, v4, v1, Lcom/bytedance/trae/login/user/UserInfoFetcher;->doFetch(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    move-object/from16 v4, v16
    if-ne v0, v4, +003h
    return-object v4
    move-wide/from16 v50, v2
    move-wide v2, v7
    move-wide/from16 v7, v50
    check-cast v0, Lcom/bytedance/trae/login/user/UserInfoFetcher$UserInfoResponse;
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/login/user/UserInfoFetcher$UserInfoResponse;->getResult()Lcom/bytedance/trae/login/user/TraeUserInfoResult;
    move-result-object v5
    goto +2h
    const/4 v5, 0
    if-eqz v0, +00dh
    invoke-virtual v0, Lcom/bytedance/trae/login/user/UserInfoFetcher$UserInfoResponse;->getResponseMetadata()Lcom/bytedance/trae/login/traeauth/TraeResponseMetadata;
    move-result-object v0
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/login/traeauth/TraeResponseMetadata;->getError()Lcom/bytedance/trae/login/traeauth/TraeResponseError;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    if-nez v0, +028h
    if-eqz v5, +026h
    invoke-virtual v5, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->getUserId()Ljava/lang/String;
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
    if-nez v0, +012h
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;
    sget-object v6, Lcom/bytedance/trae/login/user/UserInfo;->Companion Lcom/bytedance/trae/login/user/UserInfo$Companion;
    invoke-virtual v6, v5, Lcom/bytedance/trae/login/user/UserInfo$Companion;->from(Lcom/bytedance/trae/login/user/TraeUserInfoResult;)Lcom/bytedance/trae/login/user/UserInfo;
    move-result-object v6
    invoke-virtual v0, v6, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->saveUserInfo(Lcom/bytedance/trae/login/user/UserInfo;)V
    sget-object v0, Lcom/bytedance/trae/login/region/UserRegionManager;->INSTANCE Lcom/bytedance/trae/login/region/UserRegionManager;
    invoke-virtual v0, v5, Lcom/bytedance/trae/login/region/UserRegionManager;->applyRegionFromUserInfo(Lcom/bytedance/trae/login/user/TraeUserInfoResult;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    goto +15h
    move-exception v0
    goto +9h
    move-exception v0
    move-object/from16 v4, v16
    move-wide/from16 v50, v2
    move-wide v2, v7
    move-wide/from16 v7, v50
    sget-object v5, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v0, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->exceptionOrNull-impl(Ljava/lang/Object;)Ljava/lang/Throwable;
    move-result-object v0
    if-eqz v0, +02bh
    sget-object v5, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v6, Ljava/lang/StringBuilder;
    move-object/from16 v35, v13
    move-object/from16 v13, v25
    invoke-direct v6, v13, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v6, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    move-object/from16 v6, v34
    invoke-virtual v5, v6, v0, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    goto +11h
    move-exception v0
    move-object v10, v4
    goto/16 +1feh
    move-exception v0
    move-object v10, v4
    goto/16 -19ch
    move-exception v0
    move-object v10, v4
    goto/16 -1b2h
    move-object/from16 v35, v13
    move-object/from16 v6, v34
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v25
    sub-long v7, v25, v7
    iput-wide v7, v12, Lkotlin/jvm/internal/Ref$LongRef;->element J
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v5, Ljava/lang/StringBuilder;
    move-object/from16 v7, v24
    invoke-direct v5, v7, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-wide v7, v12, Lkotlin/jvm/internal/Ref$LongRef;->element J
    invoke-virtual v5, v7, v8, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v5
    move-object/from16 v7, v27
    invoke-virtual v5, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v0, v6, v5, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    move-object/from16 v34, v6
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v5
    sget-object v0, Lcom/bytedance/trae/login/region/UserRegionManager;->INSTANCE Lcom/bytedance/trae/login/region/UserRegionManager;
    invoke-virtual v15, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;->getToken()Ljava/lang/String;
    move-result-object v8
    invoke-static v8, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    move-object v13, v1
    check-cast v13, Lkotlin/coroutines/Continuation;
    iput-object v11, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->L$0 Ljava/lang/Object;
    iput-object v10, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->L$1 Ljava/lang/Object;
    iput-object v14, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->L$2 Ljava/lang/Object;
    iput-object v12, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->L$3 Ljava/lang/Object;
    iput-object v9, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->L$4 Ljava/lang/Object;
    const/4 v15, 0
    iput-object v15, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->L$5 Ljava/lang/Object;
    iput-wide v2, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->J$0 J
    iput-wide v5, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->J$1 J
    const/4 v15, 5
    iput v15, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->label I
    invoke-virtual v0, v8, v13, Lcom/bytedance/trae/login/region/UserRegionManager;->performCheckLoginSync(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v4, +003h
    return-object v4
    move-object v0, v9
    move-wide/from16 v50, v2
    move-wide v2, v5
    move-wide/from16 v5, v50
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v8
    sub-long/2addr v8, v2
    iput-wide v8, v0, Lkotlin/jvm/internal/Ref$LongRef;->element J
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    move-object/from16 v8, v23
    invoke-direct v3, v8, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-wide v8, v0, Lkotlin/jvm/internal/Ref$LongRef;->element J
    invoke-virtual v3, v8, v9, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    move-object/from16 v13, v34
    invoke-virtual v2, v13, v3, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v2
    sub-long/2addr v2, v5
    sget-object v7, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    const-string v8, "icube_login_success"
    new-instance v9, Lorg/json/JSONObject;
    invoke-direct v9, Lorg/json/JSONObject;-><init>()V
    move-object/from16 v15, v22
    invoke-virtual v9, v15, v2, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    move-object/from16 v22, v15
    const-string/jumbo v15, step_login_ms
    move-object/from16 v16, v4
    move-wide/from16 v23, v5
    iget-wide v4, v11, Lkotlin/jvm/internal/Ref$LongRef;->element J
    invoke-virtual v9, v15, v4, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    const-string/jumbo v4, step_refresh_token_ms
    iget-wide v5, v10, Lkotlin/jvm/internal/Ref$LongRef;->element J
    invoke-virtual v9, v4, v5, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    const-string/jumbo v4, step_exchange_token_ms
    iget-wide v5, v14, Lkotlin/jvm/internal/Ref$LongRef;->element J
    invoke-virtual v9, v4, v5, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    const-string/jumbo v4, step_user_info_ms
    iget-wide v5, v12, Lkotlin/jvm/internal/Ref$LongRef;->element J
    invoke-virtual v9, v4, v5, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    const-string/jumbo v4, step_check_login_ms
    iget-wide v5, v0, Lkotlin/jvm/internal/Ref$LongRef;->element J
    invoke-virtual v9, v4, v5, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    const-string v0, "kick_off_login_continue"
    move-object/from16 v4, v21
    invoke-virtual v9, v4, v0, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v7, v8, v9, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    sget-object v36, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string v37, "login_success"
    new-instance v0, Ljava/lang/StringBuilder;
    move-object/from16 v5, v35
    invoke-direct v0, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v6, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->$loginPlatform Ljava/lang/String;
    invoke-virtual v0, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v38
    invoke-static v2, v3, Lkotlin/coroutines/jvm/internal/Boxing;->boxLong(J)Ljava/lang/Long;
    move-result-object v39
    const/16 v40, 0
    const/16 v41, 0
    const/16 v42, 0
    const/16 v43, 0
    const/16 v44, 0
    const/16 v45, 0
    const/16 v46, 0
    const/16 v47, 0
    const/16 v48, 2040
    const/16 v49, 0
    invoke-static/range v36 ... v49, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel$default(Lcom/bytedance/trae/login/traeauth/TraeAuthManager; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    invoke-static Lkotlinx/coroutines/Dispatchers;->getMain()Lkotlinx/coroutines/MainCoroutineDispatcher;
    move-result-object v0
    check-cast v0, Lkotlin/coroutines/CoroutineContext;
    new-instance v2, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1$6;
    iget-object v3, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->$callback Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback;
    const/4 v6, 0
    invoke-direct v2, v3, v6, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1$6;-><init>(Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback; Lkotlin/coroutines/Continuation;)V
    check-cast v2, Lkotlin/jvm/functions/Function2;
    move-object v3, v1
    check-cast v3, Lkotlin/coroutines/Continuation;
    iput-object v6, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->L$0 Ljava/lang/Object;
    iput-object v6, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->L$1 Ljava/lang/Object;
    iput-object v6, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->L$2 Ljava/lang/Object;
    iput-object v6, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->L$3 Ljava/lang/Object;
    iput-object v6, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->L$4 Ljava/lang/Object;
    move-wide/from16 v6, v23
    iput-wide v6, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->J$0 J
    const/4 v8, 6
    iput v8, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->label I
    invoke-static v0, v2, v3, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    move-object/from16 v10, v16
    if-ne v0, v10, +003h
    return-object v10
    move-wide v2, v6
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
    move-exception v0
    goto/16 +107h
    move-exception v0
    goto/16 +0f1h
    move-exception v0
    move-object/from16 v10, v16
    goto/16 +055h
    move-exception v0
    move-object/from16 v10, v16
    goto/16 +05ah
    move-exception v0
    move-object/from16 v10, v16
    move-wide/from16 v6, v23
    goto/16 +049h
    move-exception v0
    move-object/from16 v10, v16
    move-wide/from16 v6, v23
    goto/16 +04ch
    move-exception v0
    move-object/from16 v10, v16
    goto +ah
    move-exception v0
    move-object/from16 v10, v16
    goto +eh
    move-exception v0
    move-object/from16 v10, v16
    move-object/from16 v4, v21
    move-wide/from16 v6, v23
    goto +2fh
    move-exception v0
    move-object/from16 v10, v16
    move-object/from16 v4, v21
    move-wide/from16 v6, v23
    goto +31h
    move-exception v0
    move-object v10, v4
    move-wide v6, v5
    move-object/from16 v22, v15
    goto +17h
    move-exception v0
    move-object v10, v4
    move-wide v6, v5
    move-object/from16 v4, v21
    move-object/from16 v5, v35
    move-wide v2, v6
    move-object v13, v15
    move-object/from16 v15, v17
    move-object/from16 v14, v18
    move-object/from16 v12, v19
    move-object/from16 v11, v20
    goto/16 +174h
    move-exception v0
    move-object v10, v4
    move-wide v6, v5
    move-object/from16 v4, v21
    goto +8h
    move-exception v0
    move-object v10, v4
    move-wide v6, v5
    move-object/from16 v4, v21
    move-object/from16 v13, v34
    move-object/from16 v5, v35
    move-wide v2, v6
    goto/16 +0a9h
    move-exception v0
    move-object v10, v4
    move-wide v6, v5
    move-object/from16 v4, v21
    move-object/from16 v5, v35
    move-wide v2, v6
    goto/16 +08ch
    move-exception v0
    move-object v10, v4
    move-object v13, v6
    move-object/from16 v4, v21
    goto/16 +05ch
    move-exception v0
    move-object v10, v4
    goto/16 +05eh
    move-exception v0
    move-object v10, v4
    goto/16 -361h
    move-exception v0
    move-object v10, v4
    move-object v5, v13
    move-object/from16 v4, v21
    goto/16 +076h
    move-exception v0
    move-object v5, v13
    move-object/from16 v10, v16
    move-object/from16 v4, v21
    goto +2bh
    move-exception v0
    move-object v5, v13
    move-object/from16 v10, v16
    goto +9h
    move-exception v0
    move-object v5, v13
    move-object/from16 v10, v16
    goto +dh
    move-exception v0
    move-object v10, v6
    move-object v5, v13
    move-object/from16 v4, v21
    move-object v13, v3
    move-wide v2, v7
    goto/16 +06fh
    move-exception v0
    move-object v10, v6
    move-object v5, v13
    move-object/from16 v4, v21
    move-wide v2, v7
    goto/16 +054h
    move-exception v0
    move-object v10, v6
    move-object v5, v13
    move-object/from16 v4, v21
    move-wide/from16 v7, v28
    goto -13h
    move-exception v0
    move-object v10, v6
    move-object v5, v13
    move-object/from16 v4, v21
    move-wide/from16 v7, v28
    move-object/from16 v13, v34
    goto -1ch
    move-exception v0
    move-object v10, v6
    move-object v5, v13
    move-object/from16 v4, v21
    move-wide/from16 v7, v28
    goto -1ch
    move-exception v0
    move-wide v7, v2
    goto/16 -3a9h
    move-exception v0
    move-wide v7, v2
    move-object v10, v6
    goto -48h
    move-exception v0
    move-wide v7, v2
    move-object v10, v6
    move-object/from16 v4, v21
    move-object/from16 v13, v34
    move-object/from16 v5, v35
    goto +3ah
    move-exception v0
    move-wide v7, v2
    move-object v10, v6
    move-object/from16 v4, v21
    move-object/from16 v5, v35
    goto +1fh
    move-exception v0
    move-object v10, v6
    move-object/from16 v4, v21
    move-object/from16 v13, v34
    move-object/from16 v5, v35
    goto +28h
    move-exception v0
    move-object v10, v6
    move-object/from16 v4, v21
    move-object/from16 v5, v35
    goto +eh
    move-exception v0
    move-object v10, v6
    move-object v5, v11
    move-object/from16 v4, v21
    move-object/from16 v13, v34
    goto +19h
    move-exception v0
    move-object v10, v6
    move-object v5, v11
    move-object/from16 v4, v21
    move-wide v2, v8
    move-object/from16 v15, v17
    move-object/from16 v14, v18
    move-object/from16 v12, v19
    move-object/from16 v11, v20
    move-object/from16 v13, v22
    goto/16 +0c2h
    move-exception v0
    move-object v10, v6
    move-object v5, v11
    move-object v13, v12
    move-object/from16 v4, v21
    move-wide v2, v8
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v6
    sub-long/2addr v6, v2
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v8, "Auth flow unexpected exception: "
    invoke-direct v3, v8, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v8
    invoke-virtual v3, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v13, v3, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v2, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    new-instance v3, Lorg/json/JSONObject;
    invoke-direct v3, Lorg/json/JSONObject;-><init>()V
    invoke-virtual v0, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v8
    if-nez v8, +005h
    const-string/jumbo v8, unexpected_exception
    move-object/from16 v11, v20
    invoke-virtual v3, v11, v8, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v8, unexpected
    move-object/from16 v12, v19
    invoke-virtual v3, v12, v8, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    move-object/from16 v13, v22
    invoke-virtual v3, v13, v6, v7, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    move-object/from16 v14, v18
    invoke-virtual v3, v4, v14, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    move-object/from16 v15, v17
    invoke-virtual v2, v15, v3, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    sget-object v18, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string v19, "login_failure"
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v3, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->$loginPlatform Ljava/lang/String;
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v20
    invoke-static v6, v7, Lkotlin/coroutines/jvm/internal/Boxing;->boxLong(J)Ljava/lang/Long;
    move-result-object v21
    const-string/jumbo v22, unexpected
    const/16 v23, 0
    invoke-virtual v0, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v24
    const/16 v25, 0
    const/16 v26, 0
    const/16 v27, 0
    const/16 v28, 0
    const/16 v29, 0
    const/16 v30, 2000
    const/16 v31, 0
    invoke-static/range v18 ... v31, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel$default(Lcom/bytedance/trae/login/traeauth/TraeAuthManager; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    invoke-static Lkotlinx/coroutines/Dispatchers;->getMain()Lkotlinx/coroutines/MainCoroutineDispatcher;
    move-result-object v2
    check-cast v2, Lkotlin/coroutines/CoroutineContext;
    new-instance v3, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1$10;
    iget-object v4, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->$callback Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback;
    const/4 v5, 0
    invoke-direct v3, v4, v0, v5, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1$10;-><init>(Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback; Ljava/lang/Throwable; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/jvm/functions/Function2;
    move-object v0, v1
    check-cast v0, Lkotlin/coroutines/Continuation;
    iput-object v5, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->L$0 Ljava/lang/Object;
    iput-object v5, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->L$1 Ljava/lang/Object;
    iput-object v5, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->L$2 Ljava/lang/Object;
    iput-object v5, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->L$3 Ljava/lang/Object;
    iput-object v5, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->L$4 Ljava/lang/Object;
    iput-object v5, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->L$5 Ljava/lang/Object;
    const/16 v4, 8
    iput v4, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->label I
    invoke-static v2, v3, v0, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v10, +003h
    return-object v10
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
    move-exception v0
    move-object v10, v6
    move-object v5, v11
    move-object/from16 v15, v17
    move-object/from16 v14, v18
    move-object/from16 v12, v19
    move-object/from16 v11, v20
    move-object/from16 v4, v21
    move-object/from16 v13, v22
    move-wide v2, v8
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v6
    sub-long/2addr v6, v2
    sget-object v2, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    new-instance v3, Lorg/json/JSONObject;
    invoke-direct v3, Lorg/json/JSONObject;-><init>()V
    invoke-virtual v0, Lcom/bytedance/trae/login/traeauth/TraeAuthException;->getUserFacingMessage()Ljava/lang/String;
    move-result-object v8
    const-string/jumbo v9, unknown
    if-nez v8, +009h
    invoke-virtual v0, Lcom/bytedance/trae/login/traeauth/TraeAuthException;->getMessage()Ljava/lang/String;
    move-result-object v8
    if-nez v8, +003h
    move-object v8, v9
    invoke-virtual v3, v11, v8, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-virtual v0, Lcom/bytedance/trae/login/traeauth/TraeAuthException;->getCode()Ljava/lang/String;
    move-result-object v8
    if-nez v8, +004h
    const-string v8, ""
    const-string v11, "error_code"
    invoke-virtual v3, v11, v8, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-virtual v0, Lcom/bytedance/trae/login/traeauth/TraeAuthException;->getStep()Ljava/lang/String;
    move-result-object v8
    if-nez v8, +003h
    goto +2h
    move-object v9, v8
    invoke-virtual v3, v12, v9, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-virtual v3, v13, v6, v7, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    invoke-virtual v3, v4, v14, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v2, v15, v3, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    sget-object v18, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string v19, "login_failure"
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v3, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->$loginPlatform Ljava/lang/String;
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v20
    const/16 v21, 0
    invoke-virtual v0, Lcom/bytedance/trae/login/traeauth/TraeAuthException;->getStep()Ljava/lang/String;
    move-result-object v22
    invoke-virtual v0, Lcom/bytedance/trae/login/traeauth/TraeAuthException;->getCode()Ljava/lang/String;
    move-result-object v23
    const/16 v24, 0
    const/16 v25, 0
    invoke-virtual v0, Lcom/bytedance/trae/login/traeauth/TraeAuthException;->getHttpCode()Ljava/lang/Integer;
    move-result-object v26
    invoke-virtual v0, Lcom/bytedance/trae/login/traeauth/TraeAuthException;->getLogId()Ljava/lang/String;
    move-result-object v27
    const/16 v28, 0
    const/16 v29, 0
    const/16 v30, 1636
    const/16 v31, 0
    invoke-static/range v18 ... v31, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel$default(Lcom/bytedance/trae/login/traeauth/TraeAuthManager; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    invoke-static Lkotlinx/coroutines/Dispatchers;->getMain()Lkotlinx/coroutines/MainCoroutineDispatcher;
    move-result-object v2
    check-cast v2, Lkotlin/coroutines/CoroutineContext;
    new-instance v3, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1$8;
    iget-object v4, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->$callback Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback;
    const/4 v5, 0
    invoke-direct v3, v4, v0, v5, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1$8;-><init>(Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback; Lcom/bytedance/trae/login/traeauth/TraeAuthException; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/jvm/functions/Function2;
    move-object v0, v1
    check-cast v0, Lkotlin/coroutines/Continuation;
    iput-object v5, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->L$0 Ljava/lang/Object;
    iput-object v5, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->L$1 Ljava/lang/Object;
    iput-object v5, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->L$2 Ljava/lang/Object;
    iput-object v5, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->L$3 Ljava/lang/Object;
    iput-object v5, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->L$4 Ljava/lang/Object;
    iput-object v5, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->L$5 Ljava/lang/Object;
    const/4 v4, 7
    iput v4, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onLoginContinueByDeviceLimit$1;->label I
    invoke-static v2, v3, v0, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v10, +003h
    return-object v10
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
    packed-switch-payload 0 1 2 3 4 5 6 7 8
    :try_start_0x42
    :try_start_0x71
    :try_start_0xce
    :try_start_0x14e
    :try_start_0x182
    :try_start_0x1d4
    :try_start_0x296
    :try_start_0x29a
    :try_start_0x2a4
    :try_start_0x2a9
    :try_start_0x2d9
    :try_start_0x2ec
    :try_start_0x2f4
    :try_start_0x377
    :try_start_0x388
    :try_start_0x39a
    :try_start_0x3da
    :try_start_0x404
    :try_start_0x42b
    :try_start_0x43c
    :try_start_0x449
    :try_start_0x451
    :try_start_0x47d
    :try_start_0x4ce
    :try_start_0x4de
    :try_start_0x4e6
    :try_start_0x4f7
    :try_start_0x50b
    :try_start_0x531
    :try_start_0x562
    :try_start_0x582
    :try_start_0x595
    :try_start_0x59a
    :try_start_0x5a1
    :try_start_0x5ca
    :try_start_0x5da
    :try_start_0x621
    :try_start_0x630
.end method
