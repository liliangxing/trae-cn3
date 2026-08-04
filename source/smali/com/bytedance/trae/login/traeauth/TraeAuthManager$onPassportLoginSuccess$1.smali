# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "TraeAuthManager.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $callback:Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback;
.field final synthetic $loginPlatform:Ljava/lang/String;
.field  I$0:I
.field  J$0:J
.field  J$1:J
.field private synthetic L$0:Ljava/lang/Object;
.field  L$1:Ljava/lang/Object;
.field  L$2:Ljava/lang/Object;
.field  L$3:Ljava/lang/Object;
.field  L$4:Ljava/lang/Object;
.field  L$5:Ljava/lang/Object;
.field  L$6:Ljava/lang/Object;
.field  L$7:Ljava/lang/Object;
.field  label:I


.method constructor <init>(java.lang.String  com.bytedance.trae.login.traeauth.TraeAuthManager$TraeAuthCallback  kotlin.coroutines.Continuation)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->$loginPlatform Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->$callback Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback;
    const/4 v1, 2
    invoke-direct v0, v1, v3, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 6
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;
    iget-object v1, v3, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->$loginPlatform Ljava/lang/String;
    iget-object v2, v3, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->$callback Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback;
    invoke-direct v0, v1, v2, v5, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;-><init>(Ljava/lang/String; Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback; Lkotlin/coroutines/Continuation;)V
    iput-object v4, v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lkotlin/coroutines/Continuation;
    return-object v0
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 64
    # ins_size=2
    move-object/from16 v1, v62
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v2
    iget v3, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->label I
    const-string v4, "ms, chainAttempt="
    const-string v5, "failed_step"
    const-string/jumbo v7, reason
    const-string v8, "icube_login_failure"
    const-string v9, "chain_attempt"
    const-string v10, "duration_ms"
    const-string v11, "login_platform"
    const-string v14, "ms"
    const-string v15, "TraeAuthManager"
    packed-switch v3, +000123fh
    new-instance v1, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v1, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v1
    invoke-static/range v63, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +fb5h
    iget v3, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->I$0 I
    move-object/from16 v17, v7
    iget-wide v6, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->J$0 J
    iget-object v12, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$6 Ljava/lang/Object;
    check-cast v12, Lkotlin/jvm/internal/Ref$LongRef;
    iget-object v13, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$5 Ljava/lang/Object;
    check-cast v13, Lkotlin/jvm/internal/Ref$LongRef;
    move-object/from16 v19, v2
    iget-object v2, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$4 Ljava/lang/Object;
    check-cast v2, Lkotlin/jvm/internal/Ref$LongRef;
    move-object/from16 v20, v2
    iget-object v2, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$3 Ljava/lang/Object;
    check-cast v2, Lkotlin/jvm/internal/Ref$LongRef;
    move-object/from16 v21, v2
    iget-object v2, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$2 Ljava/lang/Object;
    check-cast v2, Lkotlin/jvm/internal/Ref$LongRef;
    move-object/from16 v22, v2
    iget-object v2, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$1 Ljava/lang/Object;
    check-cast v2, Lkotlin/jvm/internal/Ref$IntRef;
    move-object/from16 v23, v2
    iget-object v2, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$0 Ljava/lang/Object;
    check-cast v2, Lkotlinx/coroutines/CoroutineScope;
    invoke-static/range v63, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v24, v4
    move-object/from16 v34, v14
    move-object/from16 v26, v17
    move-object/from16 v4, v19
    const/16 v18, 1
    move-object/from16 v19, v8
    move-object/from16 v17, v9
    move-object v9, v12
    move-object/from16 v8, v21
    move-object/from16 v21, v11
    move-object v11, v13
    move-wide v12, v6
    move-object v7, v15
    move v6, v3
    move-object v3, v2
    move-object/from16 v2, v23
    move-object/from16 v23, v10
    move-object v10, v1
    move-object/from16 v1, v22
    move-object/from16 v55, v20
    move-object/from16 v20, v5
    move-object/from16 v5, v55
    goto/16 +10a3h
    invoke-static/range v63, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +11d3h
    move-object/from16 v19, v2
    move-object/from16 v17, v7
    iget v2, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->I$0 I
    iget-wide v6, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->J$0 J
    iget-object v3, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$6 Ljava/lang/Object;
    check-cast v3, Lkotlin/jvm/internal/Ref$LongRef;
    iget-object v12, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$5 Ljava/lang/Object;
    check-cast v12, Lkotlin/jvm/internal/Ref$LongRef;
    iget-object v13, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$4 Ljava/lang/Object;
    check-cast v13, Lkotlin/jvm/internal/Ref$LongRef;
    move/from16 v20, v2
    iget-object v2, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$3 Ljava/lang/Object;
    check-cast v2, Lkotlin/jvm/internal/Ref$LongRef;
    move-object/from16 v21, v2
    iget-object v2, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$2 Ljava/lang/Object;
    check-cast v2, Lkotlin/jvm/internal/Ref$LongRef;
    move-object/from16 v22, v2
    iget-object v2, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$1 Ljava/lang/Object;
    check-cast v2, Lkotlin/jvm/internal/Ref$IntRef;
    move-object/from16 v23, v2
    iget-object v2, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$0 Ljava/lang/Object;
    check-cast v2, Lkotlinx/coroutines/CoroutineScope;
    invoke-static/range v63, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v24, v4
    move-object v4, v13
    move-object/from16 v34, v14
    move-object/from16 v33, v15
    move-object/from16 v15, v22
    const/16 v18, 1
    move-wide v13, v6
    move-object/from16 v6, v19
    move/from16 v22, v20
    move-object/from16 v20, v5
    move-object/from16 v19, v8
    move-object v5, v9
    move-object/from16 v8, v23
    move-object/from16 v23, v10
    move-object v10, v1
    move-object/from16 v1, v21
    move-object/from16 v21, v11
    goto/16 +9bch
    move-exception v0
    move-object/from16 v20, v5
    move-wide/from16 v27, v6
    move-object v4, v11
    move-object v7, v15
    move-object/from16 v2, v19
    move-object/from16 v13, v23
    move-object/from16 v19, v8
    move-object/from16 v23, v10
    move-object v10, v1
    goto/16 +2a6h
    move-exception v0
    move-object/from16 v63, v0
    const/16 v18, 1
    move-object/from16 v55, v9
    move-object v9, v1
    move-object v1, v14
    move-object/from16 v14, v19
    move-object/from16 v19, v8
    move-object v8, v3
    move-object/from16 v3, v17
    move-object/from16 v17, v55
    move-object/from16 v56, v11
    move-object v11, v2
    move-object v2, v12
    move-object v12, v13
    move-object/from16 v13, v23
    move-object/from16 v23, v10
    move-object/from16 v10, v21
    move-object/from16 v21, v56
    move-wide/from16 v57, v6
    move-object v6, v4
    move-object v7, v15
    move-object/from16 v15, v22
    move/from16 v22, v20
    move-object/from16 v20, v5
    move-wide/from16 v4, v57
    goto/16 +f10h
    move-object/from16 v19, v2
    move-object/from16 v17, v7
    iget-wide v2, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->J$1 J
    iget v6, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->I$0 I
    iget-wide v12, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->J$0 J
    iget-object v7, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$7 Ljava/lang/Object;
    check-cast v7, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;
    move-wide/from16 v20, v2
    iget-object v2, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$6 Ljava/lang/Object;
    check-cast v2, Lkotlin/jvm/internal/Ref$LongRef;
    iget-object v3, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$5 Ljava/lang/Object;
    check-cast v3, Lkotlin/jvm/internal/Ref$LongRef;
    move-object/from16 v22, v2
    iget-object v2, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$4 Ljava/lang/Object;
    check-cast v2, Lkotlin/jvm/internal/Ref$LongRef;
    move-object/from16 v23, v2
    iget-object v2, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$3 Ljava/lang/Object;
    check-cast v2, Lkotlin/jvm/internal/Ref$LongRef;
    move-object/from16 v24, v2
    iget-object v2, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$2 Ljava/lang/Object;
    check-cast v2, Lkotlin/jvm/internal/Ref$LongRef;
    move-object/from16 v25, v2
    iget-object v2, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$1 Ljava/lang/Object;
    check-cast v2, Lkotlin/jvm/internal/Ref$IntRef;
    move-object/from16 v26, v2
    iget-object v2, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$0 Ljava/lang/Object;
    check-cast v2, Lkotlinx/coroutines/CoroutineScope;
    invoke-static/range v63, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    const/16 v18, 1
    move-wide/from16 v55, v12
    move-object v12, v1
    move-object v1, v2
    move-object/from16 v13, v26
    move/from16 v26, v6
    move-object/from16 v6, v23
    move-object/from16 v23, v10
    move-object/from16 v57, v4
    move-object v4, v3
    move-wide/from16 v2, v20
    move-object/from16 v20, v5
    move-object/from16 v21, v11
    move-object/from16 v5, v24
    move-object/from16 v24, v57
    move-object v11, v7
    move-object/from16 v7, v22
    move-object/from16 v22, v9
    move-wide/from16 v9, v55
    move-object/from16 v58, v19
    move-object/from16 v19, v8
    move-object v8, v15
    move-object/from16 v15, v25
    move-object/from16 v25, v58
    goto/16 +7afh
    move-object/from16 v19, v2
    move-object/from16 v17, v7
    iget-wide v2, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->J$1 J
    iget v6, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->I$0 I
    iget-wide v12, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->J$0 J
    iget-object v7, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$7 Ljava/lang/Object;
    check-cast v7, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;
    move-wide/from16 v20, v2
    iget-object v2, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$6 Ljava/lang/Object;
    check-cast v2, Lkotlin/jvm/internal/Ref$LongRef;
    iget-object v3, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$5 Ljava/lang/Object;
    check-cast v3, Lkotlin/jvm/internal/Ref$LongRef;
    move-object/from16 v22, v2
    iget-object v2, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$4 Ljava/lang/Object;
    check-cast v2, Lkotlin/jvm/internal/Ref$LongRef;
    move-object/from16 v23, v2
    iget-object v2, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$3 Ljava/lang/Object;
    check-cast v2, Lkotlin/jvm/internal/Ref$LongRef;
    move-object/from16 v24, v2
    iget-object v2, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$2 Ljava/lang/Object;
    check-cast v2, Lkotlin/jvm/internal/Ref$LongRef;
    move-object/from16 v25, v2
    iget-object v2, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$1 Ljava/lang/Object;
    check-cast v2, Lkotlin/jvm/internal/Ref$IntRef;
    move-object/from16 v26, v2
    iget-object v2, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$0 Ljava/lang/Object;
    check-cast v2, Lkotlinx/coroutines/CoroutineScope;
    invoke-static/range v63, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v33, v15
    const/16 v18, 1
    move v15, v6
    move-object/from16 v6, v19
    move-object/from16 v19, v8
    move-object v8, v7
    move-object v7, v3
    move-object/from16 v55, v1
    move-object/from16 v1, v63
    move-object/from16 v56, v11
    move-object/from16 v11, v55
    move-object/from16 v57, v4
    move-object v4, v2
    move-wide/from16 v2, v20
    move-object/from16 v20, v5
    move-object/from16 v21, v56
    move-object/from16 v5, v23
    move-object/from16 v23, v10
    move-object/from16 v10, v24
    move-object/from16 v24, v57
    move-object/from16 v58, v22
    move-object/from16 v22, v9
    move-object/from16 v9, v58
    goto/16 +5a5h
    move-exception v0
    move-wide/from16 v27, v12
    move-object/from16 v33, v15
    move-object/from16 v13, v26
    const/16 v18, 1
    move v15, v6
    move-object/from16 v26, v23
    move-object/from16 v23, v10
    move-object/from16 v10, v24
    move-object/from16 v24, v4
    move-object v4, v2
    move-object/from16 v55, v1
    move-object v1, v0
    move-object/from16 v56, v11
    move-object/from16 v11, v55
    move-object/from16 v57, v7
    move-object v7, v3
    move-wide/from16 v2, v20
    move-object/from16 v20, v5
    move-object/from16 v21, v56
    move-object/from16 v5, v19
    move-object/from16 v19, v8
    move-object/from16 v8, v57
    move-object/from16 v58, v22
    move-object/from16 v22, v9
    move-object/from16 v9, v58
    goto/16 +60fh
    move-object/from16 v19, v2
    move-object/from16 v17, v7
    iget-wide v2, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->J$1 J
    iget v6, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->I$0 I
    iget-wide v12, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->J$0 J
    iget-object v7, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$6 Ljava/lang/Object;
    check-cast v7, Lkotlin/jvm/internal/Ref$LongRef;
    move-wide/from16 v20, v2
    iget-object v2, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$5 Ljava/lang/Object;
    check-cast v2, Lkotlin/jvm/internal/Ref$LongRef;
    iget-object v3, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$4 Ljava/lang/Object;
    check-cast v3, Lkotlin/jvm/internal/Ref$LongRef;
    move-object/from16 v22, v2
    iget-object v2, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$3 Ljava/lang/Object;
    check-cast v2, Lkotlin/jvm/internal/Ref$LongRef;
    move-object/from16 v23, v2
    iget-object v2, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$2 Ljava/lang/Object;
    check-cast v2, Lkotlin/jvm/internal/Ref$LongRef;
    move-object/from16 v24, v2
    iget-object v2, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$1 Ljava/lang/Object;
    check-cast v2, Lkotlin/jvm/internal/Ref$IntRef;
    move-object/from16 v25, v2
    iget-object v2, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$0 Ljava/lang/Object;
    check-cast v2, Lkotlinx/coroutines/CoroutineScope;
    invoke-static/range v63, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-wide/from16 v49, v12
    move-object/from16 v35, v15
    move-object/from16 v13, v25
    const/16 v18, 1
    move v15, v6
    move-object/from16 v55, v1
    move-object/from16 v1, v63
    move-object/from16 v56, v8
    move-object/from16 v8, v55
    move-object/from16 v57, v3
    move-object v3, v2
    move-object/from16 v2, v57
    move-object/from16 v58, v24
    move-object/from16 v24, v4
    move-object/from16 v4, v58
    move-wide/from16 v59, v20
    move-object/from16 v20, v5
    move-object/from16 v21, v11
    move-object/from16 v5, v19
    move-object/from16 v11, v22
    move-object/from16 v19, v56
    move-object/from16 v22, v9
    move-object v9, v7
    move-wide/from16 v6, v59
    move-object/from16 v61, v23
    move-object/from16 v23, v10
    move-object/from16 v10, v61
    goto/16 +40dh
    move-object/from16 v19, v2
    move-object/from16 v17, v7
    iget-wide v2, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->J$1 J
    iget v6, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->I$0 I
    iget-wide v12, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->J$0 J
    iget-object v7, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$7 Ljava/lang/Object;
    check-cast v7, Ljava/lang/String;
    move-wide/from16 v20, v2
    iget-object v2, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$6 Ljava/lang/Object;
    check-cast v2, Lkotlin/jvm/internal/Ref$LongRef;
    iget-object v3, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$5 Ljava/lang/Object;
    check-cast v3, Lkotlin/jvm/internal/Ref$LongRef;
    move-object/from16 v22, v2
    iget-object v2, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$4 Ljava/lang/Object;
    check-cast v2, Lkotlin/jvm/internal/Ref$LongRef;
    move-object/from16 v23, v2
    iget-object v2, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$3 Ljava/lang/Object;
    check-cast v2, Lkotlin/jvm/internal/Ref$LongRef;
    move-object/from16 v24, v2
    iget-object v2, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$2 Ljava/lang/Object;
    check-cast v2, Lkotlin/jvm/internal/Ref$LongRef;
    move-object/from16 v25, v2
    iget-object v2, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$1 Ljava/lang/Object;
    check-cast v2, Lkotlin/jvm/internal/Ref$IntRef;
    move-object/from16 v26, v2
    iget-object v2, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$0 Ljava/lang/Object;
    check-cast v2, Lkotlinx/coroutines/CoroutineScope;
    invoke-static/range v63, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v34, v14
    move-object/from16 v33, v15
    move-object/from16 v15, v63
    move v14, v6
    move-object/from16 v55, v8
    move-object v8, v1
    move-object/from16 v1, v26
    move-object/from16 v56, v3
    move-object v3, v2
    move-object/from16 v2, v24
    move-object/from16 v24, v4
    move-object/from16 v4, v25
    move-object/from16 v25, v19
    move-object/from16 v19, v55
    move-object/from16 v57, v11
    move-object/from16 v11, v56
    move-wide/from16 v58, v20
    move-object/from16 v20, v5
    move-object/from16 v21, v57
    move-object/from16 v5, v23
    move-object/from16 v23, v10
    move-object v10, v7
    move-wide/from16 v6, v58
    move-object/from16 v60, v22
    move-object/from16 v22, v9
    move-object/from16 v9, v60
    goto/16 +2a8h
    move-exception v0
    move-object/from16 v20, v5
    move-object/from16 v23, v10
    move-object v4, v11
    move-wide/from16 v27, v12
    move-object v7, v15
    move-object/from16 v2, v19
    move-object/from16 v13, v26
    goto/16 +098h
    move-exception v0
    move-object/from16 v63, v0
    move-object/from16 v20, v5
    move-object/from16 v21, v11
    move-object v7, v15
    move-object/from16 v15, v25
    const/16 v18, 1
    move-object v11, v2
    move-object v2, v3
    move-object/from16 v3, v17
    move-object/from16 v17, v9
    move-object v9, v1
    move-object v1, v14
    move-object/from16 v14, v19
    move-object/from16 v19, v8
    move-object/from16 v8, v22
    move/from16 v22, v6
    move-object v6, v4
    move-wide v4, v12
    move-object/from16 v12, v23
    move-object/from16 v13, v26
    move-object/from16 v23, v10
    move-object/from16 v10, v24
    goto/16 +d0ah
    move-object/from16 v19, v2
    move-object/from16 v17, v7
    iget-wide v2, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->J$1 J
    iget v6, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->I$0 I
    iget-wide v12, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->J$0 J
    iget-object v7, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$6 Ljava/lang/Object;
    check-cast v7, Lkotlin/jvm/internal/Ref$LongRef;
    move-wide/from16 v20, v2
    iget-object v2, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$5 Ljava/lang/Object;
    check-cast v2, Lkotlin/jvm/internal/Ref$LongRef;
    iget-object v3, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$4 Ljava/lang/Object;
    check-cast v3, Lkotlin/jvm/internal/Ref$LongRef;
    move-object/from16 v22, v2
    iget-object v2, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$3 Ljava/lang/Object;
    check-cast v2, Lkotlin/jvm/internal/Ref$LongRef;
    move-object/from16 v23, v2
    iget-object v2, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$2 Ljava/lang/Object;
    check-cast v2, Lkotlin/jvm/internal/Ref$LongRef;
    move-object/from16 v24, v2
    iget-object v2, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$1 Ljava/lang/Object;
    check-cast v2, Lkotlin/jvm/internal/Ref$IntRef;
    move-object/from16 v25, v2
    iget-object v2, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$0 Ljava/lang/Object;
    check-cast v2, Lkotlinx/coroutines/CoroutineScope;
    invoke-static/range v63, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v28, v14
    move-object/from16 v27, v15
    move-object/from16 v15, v19
    move v14, v6
    move-object/from16 v19, v8
    move-object/from16 v8, v23
    move-object/from16 v23, v10
    move-object v10, v1
    move-object/from16 v1, v25
    move-object/from16 v55, v4
    move-object/from16 v4, v63
    move-object/from16 v56, v3
    move-object v3, v2
    move-object/from16 v2, v24
    move-object/from16 v24, v55
    move-object/from16 v57, v5
    move-object/from16 v5, v56
    move-wide/from16 v58, v20
    move-object/from16 v20, v57
    move-object/from16 v21, v11
    move-object/from16 v11, v22
    move-object/from16 v22, v9
    move-object v9, v7
    move-wide/from16 v6, v58
    goto/16 +189h
    move-exception v0
    move-object/from16 v20, v5
    move-object/from16 v23, v10
    move-object v4, v11
    move-wide/from16 v27, v12
    move-object v7, v15
    move-object/from16 v2, v19
    move-object/from16 v13, v25
    move-object v10, v1
    move-object/from16 v19, v8
    move-object v1, v0
    goto/16 +ba3h
    move-exception v0
    move-object/from16 v63, v0
    move-object/from16 v20, v5
    move-object/from16 v21, v11
    const/16 v18, 1
    move-object v11, v2
    move-object/from16 v2, v22
    move/from16 v22, v6
    move-object v6, v4
    move-wide v4, v12
    move-object/from16 v13, v25
    move-object v12, v3
    move-object/from16 v3, v17
    move-object/from16 v17, v9
    move-object v9, v1
    move-object v1, v14
    move-object/from16 v14, v19
    move-object/from16 v19, v8
    move-object v8, v7
    move-object v7, v15
    move-object/from16 v15, v24
    move-object/from16 v55, v23
    move-object/from16 v23, v10
    move-object/from16 v10, v55
    goto/16 +c6dh
    move-object/from16 v19, v2
    move-object/from16 v17, v7
    invoke-static/range v63, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v2, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$0 Ljava/lang/Object;
    check-cast v2, Lkotlinx/coroutines/CoroutineScope;
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v6
    new-instance v3, Lkotlin/jvm/internal/Ref$IntRef;
    invoke-direct v3, Lkotlin/jvm/internal/Ref$IntRef;-><init>()V
    new-instance v12, Lkotlin/jvm/internal/Ref$LongRef;
    invoke-direct v12, Lkotlin/jvm/internal/Ref$LongRef;-><init>()V
    new-instance v13, Lkotlin/jvm/internal/Ref$LongRef;
    invoke-direct v13, Lkotlin/jvm/internal/Ref$LongRef;-><init>()V
    new-instance v20, Lkotlin/jvm/internal/Ref$LongRef;
    invoke-direct/range v20, Lkotlin/jvm/internal/Ref$LongRef;-><init>()V
    new-instance v21, Lkotlin/jvm/internal/Ref$LongRef;
    invoke-direct/range v21, Lkotlin/jvm/internal/Ref$LongRef;-><init>()V
    new-instance v22, Lkotlin/jvm/internal/Ref$LongRef;
    invoke-direct/range v22, Lkotlin/jvm/internal/Ref$LongRef;-><init>()V
    move-object/from16 v63, v2
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    move-object/from16 v23, v3
    new-instance v3, Ljava/lang/StringBuilder;
    move-wide/from16 v24, v6
    const-string/jumbo v6, onPassportLoginSuccess: begin, deviceId=
    invoke-direct v3, v6, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    sget-object v6, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v6, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getDeviceId()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v3, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v6, ", baseUrl="
    invoke-virtual v3, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    sget-object v6, Lcom/bytedance/trae/login/traeauth/TraeAuthConfig;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthConfig;
    invoke-virtual v6, Lcom/bytedance/trae/login/traeauth/TraeAuthConfig;->getBaseUrl()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v3, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v6, ", loginChannel="
    invoke-virtual v3, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    sget-object v6, Lcom/bytedance/trae/login/traeauth/TraeAuthConfig;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthConfig;
    invoke-virtual v6, Lcom/bytedance/trae/login/traeauth/TraeAuthConfig;->getLoginChannel()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v3, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v15, v3, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v2, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    new-instance v3, Lorg/json/JSONObject;
    invoke-direct v3, Lorg/json/JSONObject;-><init>()V
    iget-object v6, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->$loginPlatform Ljava/lang/String;
    invoke-virtual v3, v11, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v6, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    const-string v6, "icube_login_passport_done"
    invoke-virtual v2, v6, v3, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    sget-object v26, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string/jumbo v27, passport_done
    iget-object v2, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->$loginPlatform Ljava/lang/String;
    const/16 v29, 0
    const/16 v30, 0
    const/16 v31, 0
    const/16 v32, 0
    const/16 v33, 0
    const/16 v34, 0
    const/16 v35, 0
    const/16 v36, 0
    const/16 v37, 0
    const/16 v38, 2044
    const/16 v39, 0
    move-object/from16 v28, v2
    invoke-static/range v26 ... v39, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel$default(Lcom/bytedance/trae/login/traeauth/TraeAuthManager; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    move-object/from16 v3, v63
    move-object/from16 v7, v19
    move-object/from16 v2, v23
    const/4 v6, 0
    move-object/from16 v19, v8
    move-object/from16 v23, v10
    move-object v8, v13
    move-object v10, v1
    move-object v1, v12
    move-wide/from16 v12, v24
    move-object/from16 v24, v4
    move-object/from16 v55, v20
    move-object/from16 v20, v5
    move-object/from16 v5, v55
    move-object/from16 v56, v22
    move-object/from16 v22, v9
    move-object/from16 v9, v56
    move-object/from16 v57, v21
    move-object/from16 v21, v11
    move-object/from16 v11, v57
    iget v4, v2, Lkotlin/jvm/internal/Ref$IntRef;->element I
    const/16 v18, 1
    add-int/lit8 v4, v4, 1
    iput v4, v2, Lkotlin/jvm/internal/Ref$IntRef;->element I
    sget-object v4, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    move-object/from16 v25, v7
    new-instance v7, Ljava/lang/StringBuilder;
    move/from16 v26, v6
    const-string/jumbo v6, onPassportLoginSuccess: chainAttempt=#
    invoke-direct v7, v6, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget v6, v2, Lkotlin/jvm/internal/Ref$IntRef;->element I
    invoke-virtual v7, v6, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v6
    const-string v7, ", elapsed="
    invoke-virtual v6, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v27
    move-object/from16 v29, v8
    sub-long v7, v27, v12
    invoke-virtual v6, v7, v8, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, v14, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v4, v15, v6, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v6
    sget-object v30, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const/16 v31, 2
    const-string v32, "doLogin"
    iget-object v4, v10, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->$loginPlatform Ljava/lang/String;
    new-instance v8, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1$cloudideSession$1;
    move-object/from16 v27, v15
    iget-object v15, v10, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->$loginPlatform Ljava/lang/String;
    move-object/from16 v28, v14
    const/4 v14, 0
    invoke-direct v8, v15, v14, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1$cloudideSession$1;-><init>(Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    move-object/from16 v34, v8
    check-cast v34, Lkotlin/jvm/functions/Function1;
    move-object/from16 v35, v10
    check-cast v35, Lkotlin/coroutines/Continuation;
    iput-object v3, v10, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$0 Ljava/lang/Object;
    iput-object v2, v10, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$1 Ljava/lang/Object;
    iput-object v1, v10, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$2 Ljava/lang/Object;
    move-object/from16 v8, v29
    iput-object v8, v10, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$3 Ljava/lang/Object;
    iput-object v5, v10, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$4 Ljava/lang/Object;
    iput-object v11, v10, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$5 Ljava/lang/Object;
    iput-object v9, v10, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$6 Ljava/lang/Object;
    iput-wide v12, v10, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->J$0 J
    move/from16 v14, v26
    iput v14, v10, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->I$0 I
    iput-wide v6, v10, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->J$1 J
    const/4 v15, 1
    iput v15, v10, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->label I
    move-object/from16 v33, v4
    invoke-static/range v30 ... v35, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->access$retryOnTransient(Lcom/bytedance/trae/login/traeauth/TraeAuthManager; I Ljava/lang/String; Ljava/lang/String; Lkotlin/jvm/functions/Function1; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v4
    move-object/from16 v15, v25
    if-ne v4, v15, +003h
    return-object v15
    move-object/from16 v55, v2
    move-object v2, v1
    move-object/from16 v1, v55
    check-cast v4, Ljava/lang/String;
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v25
    sub-long v6, v25, v6
    iput-wide v6, v2, Lkotlin/jvm/internal/Ref$LongRef;->element J
    sget-object v6, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v7, Ljava/lang/StringBuilder;
    invoke-direct v7, Ljava/lang/StringBuilder;-><init>()V
    move-object/from16 v25, v15
    const-string/jumbo v15, onPassportLoginSuccess: doLogin done in 
    invoke-virtual v7, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    move/from16 v26, v14
    iget-wide v14, v2, Lkotlin/jvm/internal/Ref$LongRef;->element J
    invoke-virtual v7, v14, v15, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v7
    move-object/from16 v14, v28
    invoke-virtual v7, v14, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    move-object/from16 v15, v27
    invoke-virtual v6, v15, v7, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v6, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;
    invoke-virtual v6, v4, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->saveCloudideSession(Ljava/lang/String;)V
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v6
    sget-object v27, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const/16 v28, 2
    const-string v29, "doGetRefreshToken"
    move-object/from16 v33, v15
    iget-object v15, v10, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->$loginPlatform Ljava/lang/String;
    move-object/from16 v34, v14
    new-instance v14, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1$refreshResult$1;
    move-object/from16 v30, v15
    const/4 v15, 0
    invoke-direct v14, v4, v15, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1$refreshResult$1;-><init>(Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    move-object/from16 v31, v14
    check-cast v31, Lkotlin/jvm/functions/Function1;
    move-object/from16 v32, v10
    check-cast v32, Lkotlin/coroutines/Continuation;
    iput-object v3, v10, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$0 Ljava/lang/Object;
    iput-object v1, v10, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$1 Ljava/lang/Object;
    iput-object v2, v10, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$2 Ljava/lang/Object;
    iput-object v8, v10, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$3 Ljava/lang/Object;
    iput-object v5, v10, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$4 Ljava/lang/Object;
    iput-object v11, v10, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$5 Ljava/lang/Object;
    iput-object v9, v10, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$6 Ljava/lang/Object;
    iput-object v4, v10, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$7 Ljava/lang/Object;
    iput-wide v12, v10, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->J$0 J
    move/from16 v14, v26
    iput v14, v10, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->I$0 I
    iput-wide v6, v10, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->J$1 J
    const/4 v15, 2
    iput v15, v10, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->label I
    invoke-static/range v27 ... v32, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->access$retryOnTransient(Lcom/bytedance/trae/login/traeauth/TraeAuthManager; I Ljava/lang/String; Ljava/lang/String; Lkotlin/jvm/functions/Function1; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v15
    move-object/from16 v26, v1
    move-object/from16 v1, v25
    if-ne v15, v1, +003h
    return-object v1
    move-object/from16 v25, v1
    move-object/from16 v1, v26
    move-object/from16 v55, v4
    move-object v4, v2
    move-object v2, v8
    move-object v8, v10
    move-object/from16 v10, v55
    check-cast v15, Lcom/bytedance/trae/login/traeauth/TraeGetRefreshTokenResult;
    move/from16 v26, v14
    invoke-virtual v15, Lcom/bytedance/trae/login/traeauth/TraeGetRefreshTokenResult;->getDeviceLimitReached()Ljava/lang/Boolean;
    move-result-object v14
    move-wide/from16 v27, v12
    const/16 v18, 1
    invoke-static/range v18, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v12
    invoke-static v14, v12, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v12
    if-eqz v12, +05ch
    sget-object v35, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string v36, "login_device_limit"
    iget-object v6, v8, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->$loginPlatform Ljava/lang/String;
    const/16 v38, 0
    const/16 v39, 0
    const/16 v40, 0
    const/16 v41, 0
    const/16 v42, 0
    const/16 v43, 0
    const/16 v44, 0
    const/16 v45, 0
    const/16 v46, 0
    const/16 v47, 2044
    const/16 v48, 0
    move-object/from16 v37, v6
    invoke-static/range v35 ... v48, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel$default(Lcom/bytedance/trae/login/traeauth/TraeAuthManager; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    iget-object v6, v8, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->$callback Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback;
    if-eqz v6, +007h
    invoke-interface v6, v10, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback;->deviceOverLimit(Ljava/lang/String;)V
    sget-object v6, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
    move-exception v0
    move-object v13, v1
    move-object v10, v8
    move-object/from16 v4, v21
    move-object/from16 v9, v22
    move-object/from16 v2, v25
    move-object/from16 v7, v33
    goto/16 -24ch
    move-exception v0
    move-object/from16 v63, v0
    move-object v13, v1
    move-object v10, v2
    move-object v15, v4
    move-object v12, v5
    move-object v2, v11
    move-object/from16 v6, v24
    move-object/from16 v14, v25
    move-wide/from16 v4, v27
    move-object/from16 v7, v33
    move-object/from16 v1, v34
    move-object v11, v3
    move-object/from16 v3, v17
    move-object/from16 v17, v22
    move/from16 v22, v26
    move-object/from16 v55, v9
    move-object v9, v8
    move-object/from16 v8, v55
    goto/16 +a2bh
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v12
    sub-long/2addr v12, v6
    iput-wide v12, v2, Lkotlin/jvm/internal/Ref$LongRef;->element J
    sget-object v6, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v7, Ljava/lang/StringBuilder;
    invoke-direct v7, Ljava/lang/StringBuilder;-><init>()V
    const-string/jumbo v10, onPassportLoginSuccess: doGetRefreshToken done in 
    invoke-virtual v7, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    iget-wide v12, v2, Lkotlin/jvm/internal/Ref$LongRef;->element J
    invoke-virtual v7, v12, v13, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v7
    move-object/from16 v14, v34
    invoke-virtual v7, v14, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    move-object/from16 v10, v33
    invoke-virtual v6, v10, v7, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v6, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;
    invoke-virtual v15, Lcom/bytedance/trae/login/traeauth/TraeGetRefreshTokenResult;->getRefreshToken()Ljava/lang/String;
    move-result-object v7
    invoke-static v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-virtual v15, Lcom/bytedance/trae/login/traeauth/TraeGetRefreshTokenResult;->getRefreshExpireAt()Ljava/lang/Long;
    move-result-object v12
    invoke-virtual v6, v7, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->saveRefreshToken(Ljava/lang/String; Ljava/lang/Long;)V
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v6
    sget-object v29, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const/16 v30, 2
    const-string v31, "doExchangeToken"
    iget-object v12, v8, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->$loginPlatform Ljava/lang/String;
    new-instance v13, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1$exchangeResult$1;
    move-object/from16 v35, v10
    const/4 v10, 0
    invoke-direct v13, v15, v10, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1$exchangeResult$1;-><init>(Lcom/bytedance/trae/login/traeauth/TraeGetRefreshTokenResult; Lkotlin/coroutines/Continuation;)V
    move-object/from16 v33, v13
    check-cast v33, Lkotlin/jvm/functions/Function1;
    move-object/from16 v34, v8
    check-cast v34, Lkotlin/coroutines/Continuation;
    iput-object v3, v8, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$0 Ljava/lang/Object;
    iput-object v1, v8, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$1 Ljava/lang/Object;
    iput-object v4, v8, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$2 Ljava/lang/Object;
    iput-object v2, v8, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$3 Ljava/lang/Object;
    iput-object v5, v8, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$4 Ljava/lang/Object;
    iput-object v11, v8, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$5 Ljava/lang/Object;
    iput-object v9, v8, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$6 Ljava/lang/Object;
    const/4 v10, 0
    iput-object v10, v8, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$7 Ljava/lang/Object;
    move-object v13, v1
    move-object v10, v2
    move-wide/from16 v1, v27
    iput-wide v1, v8, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->J$0 J
    move/from16 v15, v26
    iput v15, v8, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->I$0 I
    iput-wide v6, v8, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->J$1 J
    move-wide/from16 v27, v1
    const/4 v1, 3
    iput v1, v8, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->label I
    move-object/from16 v32, v12
    invoke-static/range v29 ... v34, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->access$retryOnTransient(Lcom/bytedance/trae/login/traeauth/TraeAuthManager; I Ljava/lang/String; Ljava/lang/String; Lkotlin/jvm/functions/Function1; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    move-object/from16 v2, v25
    if-ne v1, v2, +003h
    return-object v2
    move-wide/from16 v49, v27
    move-object/from16 v55, v5
    move-object v5, v2
    move-object/from16 v2, v55
    check-cast v1, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v25
    sub-long v6, v25, v6
    iput-wide v6, v2, Lkotlin/jvm/internal/Ref$LongRef;->element J
    sget-object v6, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v7, Ljava/lang/StringBuilder;
    invoke-direct v7, Ljava/lang/StringBuilder;-><init>()V
    const-string/jumbo v12, onPassportLoginSuccess: doExchangeToken done in 
    invoke-virtual v7, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    move-object/from16 v25, v11
    iget-wide v11, v2, Lkotlin/jvm/internal/Ref$LongRef;->element J
    invoke-virtual v7, v11, v12, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, v14, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    move-object/from16 v12, v35
    invoke-virtual v6, v12, v7, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v6, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;
    invoke-virtual v1, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;->getToken()Ljava/lang/String;
    move-result-object v7
    invoke-static v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-virtual v1, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;->getTokenExpireAt()Ljava/lang/Long;
    move-result-object v11
    invoke-virtual v6, v7, v11, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->saveJwtToken(Ljava/lang/String; Ljava/lang/Long;)V
    invoke-virtual v1, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;->getRefreshToken()Ljava/lang/String;
    move-result-object v6
    if-eqz v6, +032h
    sget-object v7, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;
    invoke-virtual v1, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;->getRefreshExpireAt()Ljava/lang/Long;
    move-result-object v11
    invoke-virtual v7, v6, v11, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->saveRefreshToken(Ljava/lang/String; Ljava/lang/Long;)V
    sget-object v6, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    goto +25h
    move-exception v0
    move-object v1, v0
    move-object v2, v5
    move-object v10, v8
    move-object v7, v12
    move-object/from16 v4, v21
    move-object/from16 v9, v22
    move-wide/from16 v27, v49
    goto/16 +852h
    move-exception v0
    move-object/from16 v63, v0
    move-object v11, v3
    move-object v7, v12
    move-object v1, v14
    move-object/from16 v3, v17
    move-object/from16 v17, v22
    move-object/from16 v6, v24
    move-object v12, v2
    move-object v14, v5
    move/from16 v22, v15
    move-object/from16 v2, v25
    move-object v15, v4
    move-wide/from16 v4, v49
    goto/16 -102h
    sget-object v6, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v26
    const/16 v7, 1000
    move-object/from16 v33, v12
    int-to-long v11, v7
    div-long v11, v26, v11
    invoke-virtual v6, v11, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->saveLastExchangeSuccessAt(J)V
    invoke-virtual v1, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;->getDeviceBindStatus()Ljava/lang/String;
    move-result-object v6
    const-string v7, "BINDING_REQUIRED"
    invoke-static v6, v7, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v6
    if-eqz v6, +025h
    invoke-static Lcom/bytedance/trae/login/traeauth/LazyLoginBindDevice;->lazyBindDevice()V
    goto +20h
    move-exception v0
    move-object v1, v0
    move-object v2, v5
    move-object v10, v8
    move-object/from16 v4, v21
    move-object/from16 v9, v22
    move-object/from16 v7, v33
    goto -45h
    move-exception v0
    move-object/from16 v63, v0
    move-object v12, v2
    move-object v11, v3
    move-object v1, v14
    move-object/from16 v3, v17
    move-object/from16 v17, v22
    move-object/from16 v6, v24
    move-object/from16 v2, v25
    move-object/from16 v7, v33
    move-object v14, v5
    move/from16 v22, v15
    goto -43h
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v6
    sget-object v11, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    sget-object v11, Lcom/bytedance/trae/login/user/UserInfoFetcher;->INSTANCE Lcom/bytedance/trae/login/user/UserInfoFetcher;
    invoke-virtual v1, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;->getToken()Ljava/lang/String;
    move-result-object v12
    invoke-static v12, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    iput-object v3, v8, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$0 Ljava/lang/Object;
    iput-object v13, v8, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$1 Ljava/lang/Object;
    iput-object v4, v8, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$2 Ljava/lang/Object;
    iput-object v10, v8, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$3 Ljava/lang/Object;
    iput-object v2, v8, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$4 Ljava/lang/Object;
    move-object/from16 v26, v2
    move-object/from16 v2, v25
    iput-object v2, v8, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$5 Ljava/lang/Object;
    iput-object v9, v8, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$6 Ljava/lang/Object;
    iput-object v1, v8, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$7 Ljava/lang/Object;
    move-object/from16 v63, v1
    move-object/from16 v25, v2
    move-wide/from16 v1, v49
    iput-wide v1, v8, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->J$0 J
    iput v15, v8, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->I$0 I
    iput-wide v6, v8, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->J$1 J
    move-wide/from16 v27, v1
    const/4 v1, 4
    iput v1, v8, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->label I
    invoke-virtual v11, v12, v8, Lcom/bytedance/trae/login/user/UserInfoFetcher;->doFetch(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    if-ne v1, v5, +003h
    return-object v5
    move-object v11, v8
    move-object/from16 v8, v63
    move-object/from16 v55, v4
    move-object v4, v3
    move-wide v2, v6
    move-object/from16 v7, v25
    move-object/from16 v25, v55
    move-object v6, v5
    move-object/from16 v5, v26
    move-object/from16 v26, v13
    move-wide/from16 v12, v27
    check-cast v1, Lcom/bytedance/trae/login/user/UserInfoFetcher$UserInfoResponse;
    if-eqz v1, +010h
    invoke-virtual v1, Lcom/bytedance/trae/login/user/UserInfoFetcher$UserInfoResponse;->getResult()Lcom/bytedance/trae/login/user/TraeUserInfoResult;
    move-result-object v27
    move-wide/from16 v55, v2
    move-object/from16 v2, v27
    move-wide/from16 v27, v55
    goto +7h
    move-exception v0
    goto/16 +063h
    move-wide/from16 v27, v2
    const/4 v2, 0
    if-eqz v1, +012h
    invoke-virtual v1, Lcom/bytedance/trae/login/user/UserInfoFetcher$UserInfoResponse;->getResponseMetadata()Lcom/bytedance/trae/login/traeauth/TraeResponseMetadata;
    move-result-object v1
    if-eqz v1, +00ch
    invoke-virtual v1, Lcom/bytedance/trae/login/traeauth/TraeResponseMetadata;->getError()Lcom/bytedance/trae/login/traeauth/TraeResponseError;
    move-result-object v1
    goto +7h
    move-exception v0
    move-object v1, v0
    move-wide/from16 v2, v27
    goto +4eh
    const/4 v1, 0
    if-nez v1, +029h
    if-eqz v2, +027h
    invoke-virtual v2, Lcom/bytedance/trae/login/user/TraeUserInfoResult;->getUserId()Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    if-eqz v1, +00bh
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-nez v1, +003h
    goto +3h
    const/4 v1, 0
    goto +3h
    move/from16 v1, v18
    if-nez v1, +012h
    sget-object v1, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;
    sget-object v3, Lcom/bytedance/trae/login/user/UserInfo;->Companion Lcom/bytedance/trae/login/user/UserInfo$Companion;
    invoke-virtual v3, v2, Lcom/bytedance/trae/login/user/UserInfo$Companion;->from(Lcom/bytedance/trae/login/user/TraeUserInfoResult;)Lcom/bytedance/trae/login/user/UserInfo;
    move-result-object v3
    invoke-virtual v1, v3, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->saveUserInfo(Lcom/bytedance/trae/login/user/UserInfo;)V
    sget-object v1, Lcom/bytedance/trae/login/region/UserRegionManager;->INSTANCE Lcom/bytedance/trae/login/region/UserRegionManager;
    invoke-virtual v1, v2, Lcom/bytedance/trae/login/region/UserRegionManager;->applyRegionFromUserInfo(Lcom/bytedance/trae/login/user/TraeUserInfoResult;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static v1, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    move-wide/from16 v2, v27
    move-object/from16 v55, v6
    move-object v6, v5
    move-object v5, v10
    move-object v10, v8
    move-object/from16 v56, v25
    move-object/from16 v25, v55
    move-object/from16 v57, v9
    move-object v9, v7
    move-wide v7, v12
    move-object/from16 v13, v26
    move-object v12, v11
    move/from16 v26, v15
    move-object/from16 v15, v56
    move-object/from16 v11, v57
    goto +45h
    move-exception v0
    move-wide/from16 v27, v2
    move-object v1, v0
    move-wide/from16 v27, v12
    move-object/from16 v13, v26
    move-object/from16 v26, v5
    move-object v5, v6
    goto +20h
    move-exception v0
    goto +12h
    move-exception v0
    move-wide/from16 v27, v1
    goto +eh
    move-exception v0
    move-object/from16 v63, v1
    move-object/from16 v25, v2
    goto +6h
    move-exception v0
    move-object/from16 v63, v1
    move-object/from16 v26, v2
    move-wide/from16 v27, v49
    move-object v1, v0
    move-object v11, v8
    move-object/from16 v8, v63
    move-object/from16 v55, v4
    move-object v4, v3
    move-wide v2, v6
    move-object/from16 v7, v25
    move-object/from16 v25, v55
    sget-object v6, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v1, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v1
    invoke-static v1, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    move-object v12, v11
    move-object/from16 v6, v26
    move-object v11, v9
    move/from16 v26, v15
    move-object/from16 v15, v25
    move-object/from16 v25, v5
    move-object v9, v7
    move-object v5, v10
    move-object v10, v8
    move-wide/from16 v7, v27
    invoke-static v1, Lkotlin/Result;->exceptionOrNull-impl(Ljava/lang/Object;)Ljava/lang/Throwable;
    move-result-object v1
    if-eqz v1, +070h
    move-wide/from16 v27, v7
    sget-object v7, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v8, Ljava/lang/StringBuilder;
    invoke-direct v8, Ljava/lang/StringBuilder;-><init>()V
    move-object/from16 v29, v11
    const-string v11, "fetchUserInfo failed (non-blocking): "
    invoke-virtual v8, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v1, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v8, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    move-object/from16 v8, v33
    invoke-virtual v7, v8, v1, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    goto/16 +052h
    move-exception v0
    move-object v1, v0
    move-object v7, v8
    move-object v10, v12
    move-object/from16 v4, v21
    move-object/from16 v9, v22
    move-object/from16 v2, v25
    goto/16 +6c5h
    move-exception v0
    move-object/from16 v63, v0
    move-object v11, v4
    move-object v10, v5
    move-object v7, v8
    move-object v2, v9
    move-object v9, v12
    move-object v1, v14
    move-object/from16 v3, v17
    move-object/from16 v17, v22
    move-object/from16 v14, v25
    move/from16 v22, v26
    move-wide/from16 v4, v27
    move-object/from16 v8, v29
    goto +26h
    move-exception v0
    goto +fh
    move-exception v0
    move-object v1, v0
    move-object v10, v12
    move-object/from16 v4, v21
    move-object/from16 v9, v22
    move-object/from16 v2, v25
    goto/16 +4d8h
    move-exception v0
    move-object/from16 v29, v11
    move-object/from16 v63, v0
    move-object v11, v4
    move-object v10, v5
    move-object v2, v9
    move-object v9, v12
    move-object v1, v14
    move-object/from16 v3, v17
    move-object/from16 v17, v22
    move-object/from16 v14, v25
    move/from16 v22, v26
    move-wide/from16 v4, v27
    move-object/from16 v8, v29
    move-object/from16 v7, v33
    move-object v12, v6
    goto/16 +20bh
    move-wide/from16 v27, v7
    move-object/from16 v29, v11
    move-object/from16 v8, v33
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v30
    sub-long v1, v30, v2
    iput-wide v1, v9, Lkotlin/jvm/internal/Ref$LongRef;->element J
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, Ljava/lang/StringBuilder;-><init>()V
    const-string/jumbo v3, onPassportLoginSuccess: fetchUserInfo done in 
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    move-object v3, v6
    iget-wide v6, v9, Lkotlin/jvm/internal/Ref$LongRef;->element J
    invoke-virtual v2, v6, v7, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v14, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v8, v2, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v1
    sget-object v6, Lcom/bytedance/trae/login/region/UserRegionManager;->INSTANCE Lcom/bytedance/trae/login/region/UserRegionManager;
    invoke-virtual v10, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;->getToken()Ljava/lang/String;
    move-result-object v7
    invoke-static v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    move-object v11, v12
    check-cast v11, Lkotlin/coroutines/Continuation;
    iput-object v4, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$0 Ljava/lang/Object;
    iput-object v13, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$1 Ljava/lang/Object;
    iput-object v15, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$2 Ljava/lang/Object;
    iput-object v5, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$3 Ljava/lang/Object;
    iput-object v3, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$4 Ljava/lang/Object;
    iput-object v9, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$5 Ljava/lang/Object;
    move-object/from16 v30, v3
    move-object/from16 v3, v29
    iput-object v3, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$6 Ljava/lang/Object;
    iput-object v10, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$7 Ljava/lang/Object;
    move-object/from16 v31, v3
    move-object/from16 v29, v4
    move-wide/from16 v3, v27
    iput-wide v3, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->J$0 J
    move-wide/from16 v27, v3
    move/from16 v3, v26
    iput v3, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->I$0 I
    iput-wide v1, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->J$1 J
    const/4 v4, 5
    iput v4, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->label I
    invoke-virtual v6, v7, v11, Lcom/bytedance/trae/login/region/UserRegionManager;->performCheckLoginSync(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v4
    move-object/from16 v6, v25
    if-ne v4, v6, +003h
    return-object v6
    move/from16 v26, v3
    move-object/from16 v25, v6
    move-object v4, v9
    move-object v11, v10
    move-wide/from16 v9, v27
    move-object/from16 v6, v30
    move-object/from16 v7, v31
    move-wide v2, v1
    move-object/from16 v1, v29
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v27
    sub-long v2, v27, v2
    iput-wide v2, v7, Lkotlin/jvm/internal/Ref$LongRef;->element J
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-direct v3, Ljava/lang/StringBuilder;-><init>()V
    move-object/from16 v27, v1
    const-string/jumbo v1, onPassportLoginSuccess: performCheckLoginSync done in 
    invoke-virtual v3, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    move-object/from16 v28, v4
    iget-wide v3, v7, Lkotlin/jvm/internal/Ref$LongRef;->element J
    invoke-virtual v1, v3, v4, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v14, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v2, v8, v1, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v1
    sub-long/2addr v1, v9
    sget-object v3, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v4, Ljava/lang/StringBuilder;
    invoke-direct v4, Ljava/lang/StringBuilder;-><init>()V
    move-object/from16 v34, v14
    const-string v14, "Auth flow completed in "
    invoke-virtual v4, v14, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v4
    move-object/from16 v14, v24
    invoke-virtual v4, v14, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    move-object/from16 v24, v14
    iget v14, v13, Lkotlin/jvm/internal/Ref$IntRef;->element I
    invoke-virtual v4, v14, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v8, v4, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v3, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    const-string v4, "icube_login_success"
    new-instance v14, Lorg/json/JSONObject;
    invoke-direct v14, Lorg/json/JSONObject;-><init>()V
    move-object/from16 v33, v8
    iget-object v8, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->$loginPlatform Ljava/lang/String;
    move-wide/from16 v29, v9
    move-object/from16 v9, v23
    invoke-virtual v14, v9, v1, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    const-string/jumbo v10, step_login_ms
    move-wide/from16 v31, v1
    iget-wide v1, v15, Lkotlin/jvm/internal/Ref$LongRef;->element J
    invoke-virtual v14, v10, v1, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    const-string/jumbo v1, step_refresh_token_ms
    move-object/from16 v23, v9
    iget-wide v9, v5, Lkotlin/jvm/internal/Ref$LongRef;->element J
    invoke-virtual v14, v1, v9, v10, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    const-string/jumbo v1, step_exchange_token_ms
    iget-wide v9, v6, Lkotlin/jvm/internal/Ref$LongRef;->element J
    invoke-virtual v14, v1, v9, v10, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    const-string/jumbo v1, step_user_info_ms
    move-object v2, v5
    move-object v10, v6
    move-object/from16 v9, v28
    iget-wide v5, v9, Lkotlin/jvm/internal/Ref$LongRef;->element J
    invoke-virtual v14, v1, v5, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    const-string/jumbo v1, step_check_login_ms
    iget-wide v5, v7, Lkotlin/jvm/internal/Ref$LongRef;->element J
    invoke-virtual v14, v1, v5, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    iget v1, v13, Lkotlin/jvm/internal/Ref$IntRef;->element I
    move-object/from16 v5, v22
    invoke-virtual v14, v5, v1, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    move-object/from16 v1, v21
    invoke-virtual v14, v1, v8, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v6, "login_bind_status"
    invoke-virtual v11, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;->getDeviceBindStatus()Ljava/lang/String;
    move-result-object v8
    invoke-virtual v14, v6, v8, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v6, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v3, v4, v14, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    sget-object v35, Lcom/bytedance/trae/login/tracker/LoginTracker;->INSTANCE Lcom/bytedance/trae/login/tracker/LoginTracker;
    const/16 v36, 1
    iget-object v3, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->$loginPlatform Ljava/lang/String;
    const/16 v38, 0
    const/16 v39, 4
    const/16 v40, 0
    move-object/from16 v37, v3
    invoke-static/range v35 ... v40, Lcom/bytedance/trae/login/tracker/LoginTracker;->trackLoginResult$default(Lcom/bytedance/trae/login/tracker/LoginTracker; Z Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    sget-object v41, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string v42, "login_success"
    iget-object v3, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->$loginPlatform Ljava/lang/String;
    invoke-static/range v31 ... v32, Lkotlin/coroutines/jvm/internal/Boxing;->boxLong(J)Ljava/lang/Long;
    move-result-object v44
    const/16 v45, 0
    const/16 v46, 0
    const/16 v47, 0
    invoke-virtual v11, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;->getDeviceBindStatus()Ljava/lang/String;
    move-result-object v48
    const/16 v49, 0
    const/16 v50, 0
    const/16 v51, 0
    const/16 v52, 0
    const/16 v53, 1976
    const/16 v54, 0
    move-object/from16 v43, v3
    invoke-static/range v41 ... v54, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel$default(Lcom/bytedance/trae/login/traeauth/TraeAuthManager; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    sget-object v3, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string v4, "doLogin"
    iget-object v6, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->$loginPlatform Ljava/lang/String;
    move-object v8, v13
    iget-wide v13, v15, Lkotlin/jvm/internal/Ref$LongRef;->element J
    invoke-virtual v3, v4, v6, v13, v14, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportStepDuration(Ljava/lang/String; Ljava/lang/String; J)V
    sget-object v3, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string v4, "doGetRefreshToken"
    iget-object v6, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->$loginPlatform Ljava/lang/String;
    iget-wide v13, v2, Lkotlin/jvm/internal/Ref$LongRef;->element J
    invoke-virtual v3, v4, v6, v13, v14, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportStepDuration(Ljava/lang/String; Ljava/lang/String; J)V
    sget-object v3, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string v4, "doExchangeToken"
    iget-object v6, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->$loginPlatform Ljava/lang/String;
    iget-wide v13, v10, Lkotlin/jvm/internal/Ref$LongRef;->element J
    invoke-virtual v3, v4, v6, v13, v14, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportStepDuration(Ljava/lang/String; Ljava/lang/String; J)V
    sget-object v3, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string v4, "fetchUserInfo"
    iget-object v6, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->$loginPlatform Ljava/lang/String;
    iget-wide v13, v9, Lkotlin/jvm/internal/Ref$LongRef;->element J
    invoke-virtual v3, v4, v6, v13, v14, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportStepDuration(Ljava/lang/String; Ljava/lang/String; J)V
    sget-object v3, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string v4, "checkLogin"
    iget-object v6, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->$loginPlatform Ljava/lang/String;
    iget-wide v13, v7, Lkotlin/jvm/internal/Ref$LongRef;->element J
    invoke-virtual v3, v4, v6, v13, v14, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportStepDuration(Ljava/lang/String; Ljava/lang/String; J)V
    invoke-static Lkotlinx/coroutines/Dispatchers;->getMain()Lkotlinx/coroutines/MainCoroutineDispatcher;
    move-result-object v3
    check-cast v3, Lkotlin/coroutines/CoroutineContext;
    new-instance v4, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1$6;
    iget-object v6, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->$callback Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback;
    const/4 v11, 0
    invoke-direct v4, v6, v11, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1$6;-><init>(Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback; Lkotlin/coroutines/Continuation;)V
    check-cast v4, Lkotlin/jvm/functions/Function2;
    move-object v6, v12
    check-cast v6, Lkotlin/coroutines/Continuation;
    move-object/from16 v11, v27
    iput-object v11, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$0 Ljava/lang/Object;
    iput-object v8, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$1 Ljava/lang/Object;
    iput-object v15, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$2 Ljava/lang/Object;
    iput-object v2, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$3 Ljava/lang/Object;
    iput-object v10, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$4 Ljava/lang/Object;
    iput-object v9, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$5 Ljava/lang/Object;
    iput-object v7, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$6 Ljava/lang/Object;
    const/4 v13, 0
    iput-object v13, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$7 Ljava/lang/Object;
    move-wide/from16 v13, v29
    iput-wide v13, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->J$0 J
    move-object/from16 v21, v1
    move/from16 v1, v26
    iput v1, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->I$0 I
    move/from16 v22, v1
    const/4 v1, 6
    iput v1, v12, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->label I
    invoke-static v3, v4, v6, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    move-object/from16 v6, v25
    if-ne v1, v6, +003h
    return-object v6
    move-object v1, v2
    move-object v3, v7
    move-object v4, v10
    move-object v2, v11
    move-object v10, v12
    move-object v12, v9
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
    move-exception v0
    move-object v1, v0
    move-object v9, v5
    move-object v2, v6
    move-wide/from16 v27, v13
    move-object/from16 v4, v21
    goto/16 +0ddh
    move-exception v0
    move-object/from16 v63, v0
    move-object v11, v2
    move-object v9, v10
    move-object v2, v12
    move-object/from16 v7, v33
    move-object v10, v1
    move-object v12, v4
    move-object/from16 v1, v34
    move-object/from16 v55, v8
    move-object v8, v3
    move-object/from16 v3, v17
    move-object/from16 v17, v5
    move-wide v4, v13
    move-object v14, v6
    move-object/from16 v13, v55
    move-object/from16 v6, v24
    goto/16 +56dh
    move-exception v0
    goto/16 +0d3h
    move-exception v0
    move-object/from16 v6, v25
    goto +41h
    move-exception v0
    move/from16 v22, v1
    goto/16 +0cah
    move-exception v0
    move-object/from16 v6, v25
    goto +17h
    move-exception v0
    move-object/from16 v6, v25
    move/from16 v22, v26
    goto +26h
    move-exception v0
    move-object/from16 v6, v25
    move/from16 v22, v26
    goto +1eh
    move-exception v0
    goto +5h
    move-exception v0
    goto +14h
    move-exception v0
    move-object v8, v13
    move-object/from16 v6, v25
    move-wide/from16 v13, v29
    move-object v4, v1
    move-object v9, v5
    move-object v2, v6
    move-object v10, v12
    move-wide/from16 v27, v13
    move-object/from16 v7, v33
    move-object v1, v0
    goto/16 +093h
    move-exception v0
    move-object v8, v13
    move-object/from16 v6, v25
    move/from16 v22, v26
    move-object/from16 v11, v27
    move-wide/from16 v13, v29
    move-object/from16 v63, v0
    move-object/from16 v21, v1
    goto/16 +099h
    move-exception v0
    move-object v8, v13
    move-object/from16 v6, v25
    move-wide/from16 v13, v29
    move-object v1, v0
    move-object v9, v5
    move-object v2, v6
    move-object v10, v12
    goto -6ch
    move-exception v0
    move-object v8, v13
    goto +5h
    move-exception v0
    move-object v8, v13
    move-object/from16 v5, v22
    move-object/from16 v6, v25
    move/from16 v22, v26
    move-object/from16 v11, v27
    goto +21h
    move-exception v0
    goto +8h
    move-exception v0
    move-object v2, v5
    move-object v10, v6
    goto +10h
    move-exception v0
    move-object/from16 v23, v9
    move-object v8, v13
    move-object/from16 v6, v25
    move-wide/from16 v13, v29
    goto/16 +04fh
    move-exception v0
    move-object v2, v5
    move-object v10, v6
    move-object/from16 v23, v9
    move-object v8, v13
    move-object/from16 v5, v22
    move-object/from16 v6, v25
    move/from16 v22, v26
    move-object/from16 v11, v27
    move-object/from16 v9, v28
    move-wide/from16 v13, v29
    goto/16 +05ah
    move-exception v0
    goto +34h
    move-exception v0
    move-object v2, v5
    goto +dh
    move-exception v0
    move-object v2, v5
    move-object/from16 v33, v8
    move-object v8, v13
    move-object/from16 v24, v14
    goto +eh
    move-exception v0
    move-object v2, v5
    move-object/from16 v33, v8
    move-object v8, v13
    goto +8h
    move-exception v0
    move-object v2, v5
    move-object/from16 v33, v8
    move-object v8, v13
    move-object/from16 v34, v14
    move-object/from16 v5, v22
    move/from16 v22, v26
    move-object/from16 v11, v27
    move-wide v13, v9
    move-object/from16 v9, v28
    goto +32h
    move-exception v0
    move-object v2, v5
    move-object/from16 v33, v8
    move-object v8, v13
    move-object/from16 v34, v14
    move-object/from16 v5, v22
    move/from16 v22, v26
    move-object/from16 v11, v27
    goto +22h
    move-exception v0
    move-object/from16 v33, v8
    move-object v8, v13
    move-object/from16 v6, v25
    move-wide v13, v9
    move-object v1, v0
    move-object v2, v6
    move-object v10, v12
    move-wide/from16 v27, v13
    move-object/from16 v4, v21
    move-object/from16 v9, v22
    move-object/from16 v7, v33
    move-object v13, v8
    goto/16 +3b5h
    move-exception v0
    move-object v11, v1
    move-object v2, v5
    move-object/from16 v33, v8
    move-object v8, v13
    move-object/from16 v34, v14
    move-object/from16 v5, v22
    move/from16 v22, v26
    move-wide v13, v9
    move-object v9, v4
    move-object v10, v6
    move-object/from16 v6, v25
    move-object/from16 v63, v0
    move-object/from16 v3, v17
    move-object/from16 v1, v34
    move-object/from16 v17, v5
    move-wide v4, v13
    move-object v14, v6
    move-object v13, v8
    move-object/from16 v6, v24
    move-object v8, v7
    move-object/from16 v7, v33
    move-object/from16 v55, v10
    move-object v10, v2
    move-object v2, v9
    move-object v9, v12
    move-object/from16 v12, v55
    goto/16 +47eh
    move-exception v0
    move-object/from16 v6, v25
    move-object v1, v0
    move-object v2, v6
    move-object v7, v8
    move-object v10, v12
    move-object/from16 v4, v21
    move-object/from16 v9, v22
    goto/16 +37eh
    move-exception v0
    move-object v7, v9
    move-object/from16 v6, v25
    goto +31h
    move-exception v0
    move-wide/from16 v27, v3
    goto +15h
    move-exception v0
    move-wide/from16 v27, v3
    goto +6h
    move-exception v0
    move-object/from16 v31, v3
    move-object/from16 v29, v4
    move-object v7, v9
    move-object/from16 v6, v25
    move/from16 v3, v26
    goto +1eh
    move-exception v0
    move-object/from16 v30, v3
    goto +11h
    move-exception v0
    move-object/from16 v9, v22
    move-object/from16 v6, v25
    move-object v1, v0
    move-object v2, v6
    move-object v7, v8
    move-object v10, v12
    move-object/from16 v4, v21
    goto/16 +355h
    move-exception v0
    move-object/from16 v30, v6
    move-object v7, v9
    move-object/from16 v6, v25
    move/from16 v3, v26
    move-object/from16 v31, v29
    move-object/from16 v29, v4
    move-object/from16 v63, v0
    move-object v10, v5
    move-object v2, v7
    move-object v7, v8
    move-object v9, v12
    move-object v1, v14
    move-wide/from16 v4, v27
    move-object/from16 v11, v29
    move-object/from16 v12, v30
    move-object/from16 v8, v31
    goto +2bh
    move-exception v0
    move-wide/from16 v27, v7
    move-object/from16 v9, v22
    move-object/from16 v6, v25
    move-object v1, v0
    move-object v2, v6
    move-object v10, v12
    goto/16 +161h
    move-exception v0
    move-object/from16 v29, v4
    move-object/from16 v30, v6
    move-wide/from16 v27, v7
    move-object v7, v9
    move-object/from16 v31, v11
    move-object/from16 v6, v25
    move/from16 v3, v26
    move-object/from16 v63, v0
    move-object v10, v5
    move-object v2, v7
    move-object v9, v12
    move-object v1, v14
    move-wide/from16 v4, v27
    move-object/from16 v11, v29
    move-object/from16 v12, v30
    move-object/from16 v8, v31
    move-object/from16 v7, v33
    move-object v14, v6
    move-object/from16 v6, v24
    move-object/from16 v55, v22
    move/from16 v22, v3
    move-object/from16 v3, v17
    move-object/from16 v17, v55
    goto/16 +3f5h
    move-exception v0
    move-object/from16 v9, v22
    move-object v1, v0
    move-object v2, v5
    move-object v10, v11
    goto/16 +12eh
    move-exception v0
    move-object/from16 v55, v22
    move-object/from16 v22, v9
    move-object/from16 v9, v55
    move-object/from16 v63, v0
    move-object v2, v7
    move-object v1, v14
    move-object/from16 v3, v17
    move-object/from16 v8, v22
    move-object/from16 v6, v24
    move-object/from16 v12, v26
    move-object/from16 v7, v33
    move-object v14, v5
    move-object/from16 v17, v9
    move-object v9, v11
    move/from16 v22, v15
    move-object/from16 v15, v25
    move-object v11, v4
    goto/16 +13ah
    move-exception v0
    move-object/from16 v9, v22
    move-wide/from16 v27, v49
    move-object v1, v0
    move-object v2, v5
    goto/16 +104h
    move-exception v0
    move-object/from16 v26, v2
    move-object v7, v9
    move-wide/from16 v27, v49
    move-object/from16 v63, v0
    move-object v11, v3
    move-object v9, v8
    move-object v1, v14
    move-object/from16 v3, v17
    move-object/from16 v17, v22
    move-object/from16 v6, v24
    move-object/from16 v2, v25
    move-object/from16 v12, v26
    move-object v14, v5
    move-object v8, v7
    move/from16 v22, v15
    move-object/from16 v7, v33
    goto/16 +113h
    move-exception v0
    move-object/from16 v9, v22
    move-wide/from16 v27, v49
    move-object v1, v0
    move-object v2, v5
    move-object v10, v8
    move-object v7, v12
    goto/16 -0aeh
    move-exception v0
    move-object/from16 v26, v2
    move-object v7, v9
    move-wide/from16 v27, v49
    move-object/from16 v63, v0
    move-object v11, v3
    move-object v9, v8
    move-object v1, v14
    move-object/from16 v3, v17
    move-object/from16 v17, v22
    move-object/from16 v6, v24
    move-object/from16 v2, v25
    move-object v14, v5
    move-object v8, v7
    move-object v7, v12
    move/from16 v22, v15
    move-object/from16 v12, v26
    goto/16 +0ech
    move-exception v0
    move-object/from16 v26, v2
    move-object v7, v9
    goto +15h
    move-exception v0
    move-object/from16 v9, v22
    move-wide/from16 v27, v49
    move-object v1, v0
    move-object v2, v5
    move-object v10, v8
    move-object/from16 v4, v21
    move-object/from16 v7, v35
    goto/16 +27ah
    move-exception v0
    move-object/from16 v26, v2
    move-object v7, v9
    move-object/from16 v25, v11
    move-wide/from16 v27, v49
    move-object/from16 v63, v0
    move-object v11, v3
    move-object v9, v8
    move-object v1, v14
    move-object/from16 v3, v17
    move-object/from16 v17, v22
    move-object/from16 v6, v24
    move-object/from16 v2, v25
    move-object/from16 v12, v26
    move-object v14, v5
    move-object v8, v7
    move/from16 v22, v15
    move-object/from16 v7, v35
    goto/16 +0bah
    move-exception v0
    goto +13h
    move-exception v0
    goto +4h
    move-exception v0
    move-wide/from16 v27, v1
    move-object/from16 v2, v25
    goto +18h
    move-exception v0
    move-wide/from16 v27, v1
    goto +7h
    move-exception v0
    move-wide/from16 v27, v1
    goto +ch
    move-exception v0
    move-object v13, v1
    move-object/from16 v9, v22
    move-object/from16 v2, v25
    move-object v1, v0
    goto -3fh
    move-exception v0
    move-object v13, v1
    move-object v10, v2
    move-object/from16 v2, v25
    move/from16 v15, v26
    move-object/from16 v55, v22
    move-object/from16 v22, v9
    move-object/from16 v9, v55
    move-object/from16 v63, v0
    move-object v12, v5
    move-object v1, v14
    move-object/from16 v6, v24
    move-object/from16 v7, v35
    goto +39h
    move-exception v0
    move-object v13, v1
    move-object/from16 v9, v22
    move-object/from16 v2, v25
    move-object v1, v0
    move-object v7, v10
    move-object/from16 v4, v21
    move-object v10, v8
    goto/16 +21eh
    move-exception v0
    move-object v13, v1
    move-object v1, v10
    move/from16 v15, v26
    move-object v10, v2
    move-object/from16 v2, v25
    move-object/from16 v55, v22
    move-object/from16 v22, v9
    move-object/from16 v9, v55
    move-object/from16 v63, v0
    move-object v7, v1
    move-object v12, v5
    move-object v1, v14
    move-object/from16 v6, v24
    goto +16h
    move-exception v0
    move-object v13, v1
    move-object v10, v2
    move-object/from16 v2, v25
    move/from16 v15, v26
    move-object/from16 v55, v22
    move-object/from16 v22, v9
    move-object/from16 v9, v55
    move-object/from16 v63, v0
    move-object v12, v5
    move-object v1, v14
    move-object/from16 v6, v24
    move-object/from16 v7, v33
    move-object v14, v2
    move-object v2, v11
    goto +44h
    move-exception v0
    move-object v13, v1
    move-object/from16 v9, v22
    move-object/from16 v2, v25
    goto +1ah
    move-exception v0
    move-object v13, v1
    move-object v10, v2
    move-object/from16 v2, v25
    move/from16 v15, v26
    goto +24h
    move-exception v0
    move-object v10, v2
    move-wide/from16 v27, v12
    move-object/from16 v2, v25
    move/from16 v15, v26
    goto +18h
    move-exception v0
    move-wide/from16 v27, v12
    move-object/from16 v9, v22
    move-object/from16 v2, v25
    move-object v13, v1
    move-object v1, v0
    move-object v10, v8
    move-object/from16 v4, v21
    move-object/from16 v7, v33
    goto/16 +1c8h
    move-exception v0
    move-object v10, v2
    move-wide/from16 v27, v12
    move v15, v14
    move-object/from16 v2, v25
    const/16 v18, 1
    move-object v13, v1
    move-object/from16 v55, v22
    move-object/from16 v22, v9
    move-object/from16 v9, v55
    move-object/from16 v63, v0
    move-object v14, v2
    move-object v12, v5
    move-object v2, v11
    move-object/from16 v6, v24
    move-object/from16 v7, v33
    move-object/from16 v1, v34
    move-object v11, v3
    move-object/from16 v3, v17
    move-object/from16 v17, v9
    move-object v9, v8
    move-object/from16 v8, v22
    move/from16 v22, v15
    move-object v15, v4
    move-wide/from16 v4, v27
    goto/16 +291h
    move-exception v0
    move-object/from16 v26, v1
    move-object v7, v9
    move-object/from16 v4, v21
    move-object/from16 v1, v25
    const/16 v18, 1
    goto +dh
    move-exception v0
    move-object v7, v9
    move-object/from16 v4, v21
    move/from16 v14, v26
    const/16 v18, 1
    move-object/from16 v26, v1
    move-object/from16 v1, v25
    move-object/from16 v63, v0
    move-object v15, v2
    move-object v9, v10
    move-object v2, v11
    move-object/from16 v6, v24
    move-object v11, v3
    move-object v10, v8
    move-object/from16 v3, v17
    move-object/from16 v17, v22
    move-object v8, v7
    move/from16 v22, v14
    move-object/from16 v7, v33
    move-object v14, v1
    move-object/from16 v1, v34
    goto/16 +0e0h
    move-exception v0
    move-object/from16 v26, v1
    move-object/from16 v4, v21
    move-object/from16 v9, v22
    move-object/from16 v1, v25
    move-object v2, v1
    move-wide/from16 v27, v12
    move-object/from16 v13, v26
    goto/16 -7fah
    move-exception v0
    move-object v7, v9
    move-object/from16 v4, v21
    const/16 v18, 1
    move-object/from16 v21, v14
    move/from16 v14, v26
    move-object/from16 v26, v1
    move-object/from16 v1, v25
    move-object/from16 v63, v0
    move-object v15, v2
    move-object v9, v10
    move-object v2, v11
    move-object/from16 v6, v24
    move-object v11, v3
    move-object v10, v8
    move-object/from16 v3, v17
    move-object/from16 v17, v22
    move-object v8, v7
    move/from16 v22, v14
    move-object/from16 v7, v33
    goto/16 +057h
    move-exception v0
    move-object/from16 v26, v1
    move-object/from16 v4, v21
    move-object/from16 v9, v22
    move-object/from16 v1, v25
    move-object v2, v1
    move-wide/from16 v27, v12
    move-object v7, v15
    move-object/from16 v13, v26
    goto/16 -a77h
    move-exception v0
    move-object v7, v9
    move-object v6, v15
    move-object/from16 v4, v21
    const/16 v18, 1
    move-object/from16 v21, v14
    move/from16 v14, v26
    move-object/from16 v26, v1
    move-object/from16 v1, v25
    move-object/from16 v63, v0
    move-object v15, v2
    move-object v9, v10
    move-object v2, v11
    move-object v11, v3
    move-object v10, v8
    move-object/from16 v3, v17
    move-object/from16 v17, v22
    move-object v8, v7
    move/from16 v22, v14
    move-object v14, v1
    move-object v7, v6
    move-object/from16 v1, v21
    move-object/from16 v6, v24
    goto +24h
    move-exception v0
    move-object v7, v9
    move-object/from16 v4, v21
    const/16 v18, 1
    move-object/from16 v21, v14
    move/from16 v14, v26
    move-object/from16 v26, v1
    move-object/from16 v1, v25
    move-object/from16 v63, v0
    move-object v15, v2
    move-object v9, v10
    move-object v2, v11
    move-object/from16 v6, v24
    move-object v11, v3
    move-object v10, v8
    move-object/from16 v3, v17
    move-object/from16 v17, v22
    move-object v8, v7
    move/from16 v22, v14
    move-object/from16 v7, v27
    move-object v14, v1
    move-object/from16 v1, v21
    move-object/from16 v21, v4
    goto/16 +052h
    move-exception v0
    move-object v7, v9
    move-object/from16 v4, v21
    move/from16 v14, v26
    const/16 v18, 1
    move-object/from16 v26, v1
    move-object/from16 v1, v25
    goto +2fh
    move-exception v0
    move-object/from16 v26, v1
    move-object/from16 v4, v21
    move-object/from16 v9, v22
    move-object/from16 v1, v25
    goto +12h
    move-exception v0
    move-object/from16 v26, v1
    move-object v7, v9
    move-object/from16 v4, v21
    move-object/from16 v1, v25
    goto +1ah
    move-exception v0
    move-object/from16 v26, v1
    move-object v1, v15
    move-object/from16 v4, v21
    move-object/from16 v9, v22
    move-object v2, v1
    move-object/from16 v7, v27
    move-object v1, v0
    move-wide/from16 v27, v12
    move-object/from16 v13, v26
    goto/16 +0b0h
    move-exception v0
    move-object/from16 v26, v1
    move-object v7, v9
    move-object v1, v15
    move-object/from16 v4, v21
    const/16 v18, 1
    move-object/from16 v63, v0
    move-object v15, v2
    move-object v9, v10
    move-object v2, v11
    move-object/from16 v6, v24
    move-object v11, v3
    move-object v10, v8
    move-object/from16 v3, v17
    move-object/from16 v17, v22
    move-object v8, v7
    move/from16 v22, v14
    move-object/from16 v7, v27
    move-object v14, v1
    move-object/from16 v1, v28
    move-wide/from16 v55, v12
    move-object v12, v5
    move-wide/from16 v4, v55
    move-object/from16 v13, v26
    goto/16 +17ch
    move-exception v0
    move/from16 v18, v15
    move-object/from16 v4, v21
    move-object/from16 v6, v24
    move-object/from16 v15, v25
    move-object/from16 v7, v27
    goto +24h
    move-exception v0
    move-object/from16 v4, v21
    move-object/from16 v6, v24
    move-object/from16 v15, v25
    goto +ah
    move-exception v0
    move-object/from16 v4, v21
    move-object/from16 v6, v24
    move-object/from16 v15, v25
    move/from16 v14, v26
    move-object/from16 v7, v27
    goto +eh
    move-exception v0
    move-object/from16 v4, v21
    move-object/from16 v6, v24
    move-object/from16 v15, v25
    move/from16 v14, v26
    move-object/from16 v7, v27
    move-object/from16 v8, v29
    const/16 v18, 1
    move-object/from16 v21, v1
    move-object/from16 v1, v28
    goto +26h
    move-exception v0
    move-object/from16 v4, v21
    move-object/from16 v9, v22
    move-object/from16 v15, v25
    move-object/from16 v7, v27
    goto +45h
    move-exception v0
    move-object/from16 v4, v21
    move-object/from16 v6, v24
    move-object/from16 v15, v25
    move-object/from16 v7, v27
    goto +9h
    move-exception v0
    move-object v7, v15
    move-object/from16 v4, v21
    move-object/from16 v6, v24
    move-object/from16 v15, v25
    move-object/from16 v8, v29
    const/16 v18, 1
    move-object/from16 v21, v1
    move-object v1, v14
    move/from16 v14, v26
    move-object/from16 v55, v22
    move-object/from16 v22, v9
    move-object/from16 v9, v55
    move-object/from16 v63, v0
    move-wide/from16 v55, v12
    move-object v13, v2
    move-object v12, v5
    move-object v2, v11
    move-object v11, v3
    move-object/from16 v3, v17
    move-object/from16 v17, v9
    move-object v9, v10
    move-object v10, v8
    move-object/from16 v8, v22
    move/from16 v22, v14
    move-object v14, v15
    move-object/from16 v15, v21
    move-object/from16 v21, v4
    move-wide/from16 v4, v55
    goto/16 +102h
    move-exception v0
    move-object v7, v15
    move-object/from16 v4, v21
    move-object/from16 v9, v22
    move-object/from16 v15, v25
    move-object v1, v0
    move-wide/from16 v27, v12
    move-object v13, v2
    move-object v2, v15
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v5
    sub-long v5, v5, v27
    sget-object v3, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v8, Ljava/lang/StringBuilder;
    const-string v11, "Auth flow unexpected exception: "
    invoke-direct v8, v11, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, Ljava/lang/Exception;->getMessage()Ljava/lang/String;
    move-result-object v11
    invoke-virtual v8, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v8
    invoke-virtual v3, v7, v8, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v3, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    new-instance v7, Lorg/json/JSONObject;
    invoke-direct v7, Lorg/json/JSONObject;-><init>()V
    iget-object v8, v10, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->$loginPlatform Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/Exception;->getMessage()Ljava/lang/String;
    move-result-object v11
    if-nez v11, +005h
    const-string/jumbo v11, unexpected_exception
    move-object/from16 v12, v17
    invoke-virtual v7, v12, v11, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v11, unexpected
    move-object/from16 v12, v20
    invoke-virtual v7, v12, v11, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    move-object/from16 v11, v23
    invoke-virtual v7, v11, v5, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    iget v11, v13, Lkotlin/jvm/internal/Ref$IntRef;->element I
    invoke-virtual v7, v9, v11, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    invoke-virtual v7, v4, v8, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    move-object/from16 v4, v19
    invoke-virtual v3, v4, v7, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    sget-object v3, Lcom/bytedance/trae/login/tracker/LoginTracker;->INSTANCE Lcom/bytedance/trae/login/tracker/LoginTracker;
    iget-object v4, v10, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->$loginPlatform Ljava/lang/String;
    const-string v7, "network_error"
    const/4 v8, 0
    invoke-virtual v3, v8, v4, v7, Lcom/bytedance/trae/login/tracker/LoginTracker;->trackLoginResult(Z Ljava/lang/String; Ljava/lang/String;)V
    sget-object v18, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string v19, "login_failure"
    iget-object v3, v10, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->$loginPlatform Ljava/lang/String;
    invoke-static v5, v6, Lkotlin/coroutines/jvm/internal/Boxing;->boxLong(J)Ljava/lang/Long;
    move-result-object v21
    const-string/jumbo v22, unexpected
    const/16 v23, 0
    invoke-virtual v1, Ljava/lang/Exception;->getMessage()Ljava/lang/String;
    move-result-object v24
    const/16 v25, 0
    const/16 v26, 0
    const/16 v27, 0
    const/16 v28, 0
    const/16 v29, 0
    const/16 v30, 2000
    const/16 v31, 0
    move-object/from16 v20, v3
    invoke-static/range v18 ... v31, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel$default(Lcom/bytedance/trae/login/traeauth/TraeAuthManager; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    invoke-static Lkotlinx/coroutines/Dispatchers;->getMain()Lkotlinx/coroutines/MainCoroutineDispatcher;
    move-result-object v3
    check-cast v3, Lkotlin/coroutines/CoroutineContext;
    new-instance v4, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1$10;
    iget-object v5, v10, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->$callback Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback;
    const/4 v6, 0
    invoke-direct v4, v5, v1, v6, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1$10;-><init>(Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback; Ljava/lang/Exception; Lkotlin/coroutines/Continuation;)V
    check-cast v4, Lkotlin/jvm/functions/Function2;
    move-object v1, v10
    check-cast v1, Lkotlin/coroutines/Continuation;
    iput-object v6, v10, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$0 Ljava/lang/Object;
    iput-object v6, v10, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$1 Ljava/lang/Object;
    iput-object v6, v10, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$2 Ljava/lang/Object;
    iput-object v6, v10, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$3 Ljava/lang/Object;
    iput-object v6, v10, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$4 Ljava/lang/Object;
    iput-object v6, v10, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$5 Ljava/lang/Object;
    iput-object v6, v10, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$6 Ljava/lang/Object;
    iput-object v6, v10, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$7 Ljava/lang/Object;
    const/16 v5, 9
    iput v5, v10, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->label I
    invoke-static v3, v4, v1, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    if-ne v1, v2, +003h
    return-object v2
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
    move-exception v0
    move-object v7, v15
    move-object/from16 v4, v21
    move-object/from16 v6, v24
    move-object/from16 v15, v25
    const/16 v18, 1
    move-object/from16 v21, v1
    move-object v1, v14
    move/from16 v14, v26
    move-object/from16 v55, v17
    move-object/from16 v17, v2
    move-object/from16 v2, v20
    move-object/from16 v20, v5
    move-object/from16 v5, v19
    move-object/from16 v19, v3
    move-object/from16 v3, v55
    move-object/from16 v56, v22
    move-object/from16 v22, v9
    move-object/from16 v9, v56
    move-object/from16 v63, v0
    move-object/from16 v8, v22
    move/from16 v22, v14
    move-object v14, v15
    move-object/from16 v15, v21
    move-object/from16 v21, v4
    move-object/from16 v55, v20
    move-object/from16 v20, v2
    move-object v2, v11
    move-object/from16 v11, v19
    move-object/from16 v19, v5
    move-wide v4, v12
    move-object/from16 v13, v17
    move-object/from16 v12, v55
    move-object/from16 v17, v9
    move-object v9, v10
    move-object/from16 v10, v29
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v24
    move-object/from16 v27, v2
    move-object/from16 v26, v3
    sub-long v2, v24, v4
    move-object/from16 v24, v6
    invoke-virtual/range v63, Lcom/bytedance/trae/login/traeauth/TraeAuthException;->getCode()Ljava/lang/String;
    move-result-object v6
    move-object/from16 v25, v14
    const-string v14, "20310"
    invoke-static v6, v14, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v6
    if-eqz v6, +00dh
    add-int/lit8 v6, v22, 1
    const/4 v14, 2
    if-le v6, v14, +005h
    move/from16 v16, v18
    goto +9h
    move/from16 v22, v6
    goto +2h
    const/4 v14, 2
    move/from16 v6, v22
    const/16 v16, 0
    invoke-virtual/range v63, Lcom/bytedance/trae/login/traeauth/TraeAuthException;->isRetryable()Z
    move-result v22
    if-eqz v22, +0dch
    const-wide/32 v28, 60000
    cmp-long v22, v2, v28
    if-gez v22, +0d5h
    if-eqz v16, +004h
    goto/16 +0d1h
    iget v2, v13, Lkotlin/jvm/internal/Ref$IntRef;->element I
    int-to-long v2, v2
    const-wide/16 v28, 2000
    mul-long v2, v2, v28
    move-object/from16 v22, v15
    const-wide/16 v14, 10000
    invoke-static v2, v3, v14, v15, Lkotlin/ranges/RangesKt;->coerceAtMost(J J)J
    move-result-wide v2
    sget-object v14, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v15, Ljava/lang/StringBuilder;
    move/from16 v29, v6
    const-string v6, "Auth chain attempt #"
    invoke-direct v15, v6, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget v6, v13, Lkotlin/jvm/internal/Ref$IntRef;->element I
    invoke-virtual v15, v6, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v6
    const-string v15, " failed ("
    invoke-virtual v6, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual/range v63, Lcom/bytedance/trae/login/traeauth/TraeAuthException;->getMessage()Ljava/lang/String;
    move-result-object v15
    invoke-virtual v6, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    const-string v15, "), retrying in "
    invoke-virtual v6, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, v2, v3, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v14, v7, v6, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v30, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string v31, "auth_retry_failure"
    iget-object v6, v9, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->$loginPlatform Ljava/lang/String;
    const/16 v33, 0
    invoke-virtual/range v63, Lcom/bytedance/trae/login/traeauth/TraeAuthException;->getStep()Ljava/lang/String;
    move-result-object v34
    invoke-virtual/range v63, Lcom/bytedance/trae/login/traeauth/TraeAuthException;->getCode()Ljava/lang/String;
    move-result-object v35
    new-instance v14, Ljava/lang/StringBuilder;
    const-string v15, "attempt_"
    invoke-direct v14, v15, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget v15, v13, Lkotlin/jvm/internal/Ref$IntRef;->element I
    invoke-virtual v14, v15, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v14
    const-string v15, ": "
    invoke-virtual v14, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v14
    invoke-virtual/range v63, Lcom/bytedance/trae/login/traeauth/TraeAuthException;->getMessage()Ljava/lang/String;
    move-result-object v15
    invoke-virtual v14, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v14
    invoke-virtual v14, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v36
    const/16 v37, 0
    const/16 v38, 0
    invoke-virtual/range v63, Lcom/bytedance/trae/login/traeauth/TraeAuthException;->getLogId()Ljava/lang/String;
    move-result-object v39
    const/16 v40, 0
    const/16 v41, 0
    const/16 v42, 1732
    const/16 v43, 0
    move-object/from16 v32, v6
    invoke-static/range v30 ... v43, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel$default(Lcom/bytedance/trae/login/traeauth/TraeAuthManager; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    move-object v6, v9
    check-cast v6, Lkotlin/coroutines/Continuation;
    iput-object v11, v9, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$0 Ljava/lang/Object;
    iput-object v13, v9, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$1 Ljava/lang/Object;
    move-object/from16 v15, v22
    iput-object v15, v9, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$2 Ljava/lang/Object;
    iput-object v10, v9, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$3 Ljava/lang/Object;
    iput-object v12, v9, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$4 Ljava/lang/Object;
    move-object/from16 v14, v27
    iput-object v14, v9, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$5 Ljava/lang/Object;
    iput-object v8, v9, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$6 Ljava/lang/Object;
    move-object/from16 v34, v1
    const/4 v1, 0
    iput-object v1, v9, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$7 Ljava/lang/Object;
    iput-wide v4, v9, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->J$0 J
    move/from16 v1, v29
    iput v1, v9, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->I$0 I
    move-wide/from16 v29, v4
    const/16 v4, 8
    iput v4, v9, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->label I
    invoke-static v2, v3, v6, Lkotlinx/coroutines/DelayKt;->delay(J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    move-object/from16 v6, v25
    if-ne v2, v6, +003h
    return-object v6
    move-object v4, v6
    move-object v3, v11
    move-object v5, v12
    move-object v2, v13
    move-object v11, v14
    move-wide/from16 v12, v29
    move v6, v1
    move-object v1, v15
    move-object/from16 v55, v9
    move-object v9, v8
    move-object v8, v10
    move-object/from16 v10, v55
    move-object v15, v7
    move-object/from16 v22, v17
    move-object/from16 v17, v26
    move-object/from16 v14, v34
    move-object v7, v4
    goto/16 -cach
    move v1, v6
    move-object/from16 v6, v25
    if-eqz v16, +01ch
    sget-object v4, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v5, Ljava/lang/StringBuilder;
    const-string v8, "Auth flow: session not found chain retries exhausted ("
    invoke-direct v5, v8, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v5, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v5, "), giving up"
    invoke-virtual v1, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v4, v7, v1, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v5, "Auth flow failed after "
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, v2, v3, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v4
    move-object/from16 v5, v24
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    iget v5, v13, Lkotlin/jvm/internal/Ref$IntRef;->element I
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v5, ", retryable="
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual/range v63, Lcom/bytedance/trae/login/traeauth/TraeAuthException;->isRetryable()Z
    move-result v5
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v5, ": ["
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual/range v63, Lcom/bytedance/trae/login/traeauth/TraeAuthException;->getCode()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v5, "] "
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual/range v63, Lcom/bytedance/trae/login/traeauth/TraeAuthException;->getMessage()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v1, v7, v4, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    new-instance v4, Lorg/json/JSONObject;
    invoke-direct v4, Lorg/json/JSONObject;-><init>()V
    iget-object v5, v9, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->$loginPlatform Ljava/lang/String;
    invoke-virtual/range v63, Lcom/bytedance/trae/login/traeauth/TraeAuthException;->getUserFacingMessage()Ljava/lang/String;
    move-result-object v7
    const-string/jumbo v8, unknown
    if-nez v7, +009h
    invoke-virtual/range v63, Lcom/bytedance/trae/login/traeauth/TraeAuthException;->getMessage()Ljava/lang/String;
    move-result-object v7
    if-nez v7, +003h
    move-object v7, v8
    move-object/from16 v10, v26
    invoke-virtual v4, v10, v7, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-virtual/range v63, Lcom/bytedance/trae/login/traeauth/TraeAuthException;->getCode()Ljava/lang/String;
    move-result-object v7
    if-nez v7, +004h
    const-string v7, ""
    const-string v10, "error_code"
    invoke-virtual v4, v10, v7, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-virtual/range v63, Lcom/bytedance/trae/login/traeauth/TraeAuthException;->getStep()Ljava/lang/String;
    move-result-object v7
    if-nez v7, +003h
    goto +2h
    move-object v8, v7
    move-object/from16 v7, v20
    invoke-virtual v4, v7, v8, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    move-object/from16 v7, v23
    invoke-virtual v4, v7, v2, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    iget v7, v13, Lkotlin/jvm/internal/Ref$IntRef;->element I
    move-object/from16 v8, v17
    invoke-virtual v4, v8, v7, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    move-object/from16 v7, v21
    invoke-virtual v4, v7, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v5, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    move-object/from16 v5, v19
    invoke-virtual v1, v5, v4, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    sget-object v1, Lcom/bytedance/trae/login/tracker/LoginTracker;->INSTANCE Lcom/bytedance/trae/login/tracker/LoginTracker;
    iget-object v4, v9, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->$loginPlatform Ljava/lang/String;
    invoke-virtual/range v63, Lcom/bytedance/trae/login/traeauth/TraeAuthException;->getCode()Ljava/lang/String;
    move-result-object v5
    if-nez v5, +004h
    const-string v5, "auth_failed"
    const/4 v7, 0
    invoke-virtual v1, v7, v4, v5, Lcom/bytedance/trae/login/tracker/LoginTracker;->trackLoginResult(Z Ljava/lang/String; Ljava/lang/String;)V
    sget-object v18, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    const-string v19, "login_failure"
    iget-object v1, v9, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->$loginPlatform Ljava/lang/String;
    invoke-static v2, v3, Lkotlin/coroutines/jvm/internal/Boxing;->boxLong(J)Ljava/lang/Long;
    move-result-object v21
    invoke-virtual/range v63, Lcom/bytedance/trae/login/traeauth/TraeAuthException;->getStep()Ljava/lang/String;
    move-result-object v22
    invoke-virtual/range v63, Lcom/bytedance/trae/login/traeauth/TraeAuthException;->getCode()Ljava/lang/String;
    move-result-object v23
    invoke-virtual/range v63, Lcom/bytedance/trae/login/traeauth/TraeAuthException;->getUserFacingMessage()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +006h
    invoke-virtual/range v63, Lcom/bytedance/trae/login/traeauth/TraeAuthException;->getMessage()Ljava/lang/String;
    move-result-object v2
    move-object/from16 v24, v2
    const/16 v25, 0
    const/16 v26, 0
    invoke-virtual/range v63, Lcom/bytedance/trae/login/traeauth/TraeAuthException;->getLogId()Ljava/lang/String;
    move-result-object v27
    const/16 v28, 0
    const/16 v29, 0
    const/16 v30, 1728
    const/16 v31, 0
    move-object/from16 v20, v1
    invoke-static/range v18 ... v31, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->reportLoginFunnel$default(Lcom/bytedance/trae/login/traeauth/TraeAuthManager; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    invoke-static Lkotlinx/coroutines/Dispatchers;->getMain()Lkotlinx/coroutines/MainCoroutineDispatcher;
    move-result-object v1
    check-cast v1, Lkotlin/coroutines/CoroutineContext;
    new-instance v2, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1$8;
    iget-object v3, v9, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->$callback Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback;
    move-object/from16 v4, v63
    const/4 v5, 0
    invoke-direct v2, v3, v4, v5, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1$8;-><init>(Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback; Lcom/bytedance/trae/login/traeauth/TraeAuthException; Lkotlin/coroutines/Continuation;)V
    check-cast v2, Lkotlin/jvm/functions/Function2;
    move-object v3, v9
    check-cast v3, Lkotlin/coroutines/Continuation;
    iput-object v5, v9, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$0 Ljava/lang/Object;
    iput-object v5, v9, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$1 Ljava/lang/Object;
    iput-object v5, v9, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$2 Ljava/lang/Object;
    iput-object v5, v9, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$3 Ljava/lang/Object;
    iput-object v5, v9, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$4 Ljava/lang/Object;
    iput-object v5, v9, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$5 Ljava/lang/Object;
    iput-object v5, v9, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$6 Ljava/lang/Object;
    iput-object v5, v9, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->L$7 Ljava/lang/Object;
    const/4 v4, 7
    iput v4, v9, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1;->label I
    invoke-static v1, v2, v3, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    if-ne v1, v6, +003h
    return-object v6
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
    packed-switch-payload 0 1 2 3 4 5 6 7 8 9
    :try_start_0xb2
    :try_start_0x14a
    :try_start_0x1b0
    :try_start_0x240
    :try_start_0x2ae
    :try_start_0x34a
    :try_start_0x4b7
    :try_start_0x4bb
    :try_start_0x4c7
    :try_start_0x4cc
    :try_start_0x4df
    :try_start_0x4eb
    :try_start_0x4f0
    :try_start_0x4f4
    :try_start_0x502
    :try_start_0x515
    :try_start_0x51e
    :try_start_0x526
    :try_start_0x530
    :try_start_0x544
    :try_start_0x548
    :try_start_0x56c
    :try_start_0x589
    :try_start_0x58d
    :try_start_0x595
    :try_start_0x59f
    :try_start_0x5f9
    :try_start_0x616
    :try_start_0x620
    :try_start_0x644
    :try_start_0x664
    :try_start_0x668
    :try_start_0x66f
    :try_start_0x683
    :try_start_0x69d
    :try_start_0x6ad
    :try_start_0x6c6
    :try_start_0x6f6
    :try_start_0x701
    :try_start_0x712
    :try_start_0x735
    :try_start_0x739
    :try_start_0x752
    :try_start_0x75e
    :try_start_0x767
    :try_start_0x782
    :try_start_0x786
    :try_start_0x799
    :try_start_0x81d
    :try_start_0x836
    :try_start_0x83e
    :try_start_0x847
    :try_start_0x85b
    :try_start_0x8b0
    :try_start_0x8c7
    :try_start_0x8f8
    :try_start_0x902
    :try_start_0x908
    :try_start_0x90f
    :try_start_0x927
    :try_start_0x938
    :try_start_0x941
    :try_start_0x960
    :try_start_0x96c
    :try_start_0x972
    :try_start_0x98a
    :try_start_0x990
    :try_start_0x9a2
    :try_start_0x9b6
    :try_start_0x9c7
    :try_start_0x9cc
    :try_start_0xa1a
    :try_start_0xa60
    :try_start_0xa73
    :try_start_0xa79
    :try_start_0xa7e
    :try_start_0xa8f
.end method
