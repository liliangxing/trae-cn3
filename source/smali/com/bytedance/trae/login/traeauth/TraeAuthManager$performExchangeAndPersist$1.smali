# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/login/traeauth/TraeAuthManager$performExchangeAndPersist$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "TraeAuthManager.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $callback:Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback;
.field final synthetic $refreshToken:Ljava/lang/String;
.field  L$0:Ljava/lang/Object;
.field  L$1:Ljava/lang/Object;
.field  L$2:Ljava/lang/Object;
.field  label:I


.method constructor <init>(java.lang.String  com.bytedance.trae.login.traeauth.TraeAuthManager$TraeAuthCallback  kotlin.coroutines.Continuation)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$performExchangeAndPersist$1;->$refreshToken Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$performExchangeAndPersist$1;->$callback Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback;
    const/4 v1, 2
    invoke-direct v0, v1, v3, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v3, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$performExchangeAndPersist$1;
    iget-object v0, v2, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$performExchangeAndPersist$1;->$refreshToken Ljava/lang/String;
    iget-object v1, v2, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$performExchangeAndPersist$1;->$callback Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback;
    invoke-direct v3, v0, v1, v4, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$performExchangeAndPersist$1;-><init>(Ljava/lang/String; Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/coroutines/Continuation;
    return-object v3
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$performExchangeAndPersist$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$performExchangeAndPersist$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$performExchangeAndPersist$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$performExchangeAndPersist$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 23
    # ins_size=2
    move-object/from16 v1, v21
    const-string v0, "TraeAuthManager"
    const-string/jumbo v2, performExchangeAndPersist: skip (double-check), token still valid for 
    const-string/jumbo v3, performExchangeAndPersist:
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v4
    iget v5, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$performExchangeAndPersist$1;->label I
    const/4 v6, 3
    const/4 v7, 2
    const/4 v8, 1
    const/4 v9, 0
    const/4 v10, 0
    if-eqz v5, +038h
    if-eq v5, v8, +021h
    if-eq v5, v7, +012h
    if-ne v5, v6, +008h
    iget-object v0, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$performExchangeAndPersist$1;->L$0 Ljava/lang/Object;
    move-object v2, v0
    check-cast v2, Lkotlinx/coroutines/sync/Mutex;
    goto +eh
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    iget-object v0, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$performExchangeAndPersist$1;->L$0 Ljava/lang/Object;
    move-object v2, v0
    check-cast v2, Lkotlinx/coroutines/sync/Mutex;
    invoke-static/range v22, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +0c5h
    move-exception v0
    goto/16 +0d3h
    iget-object v5, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$performExchangeAndPersist$1;->L$2 Ljava/lang/Object;
    check-cast v5, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback;
    iget-object v11, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$performExchangeAndPersist$1;->L$1 Ljava/lang/Object;
    check-cast v11, Ljava/lang/String;
    iget-object v12, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$performExchangeAndPersist$1;->L$0 Ljava/lang/Object;
    check-cast v12, Lkotlinx/coroutines/sync/Mutex;
    invoke-static/range v22, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v20, v12
    move-object v12, v5
    move-object/from16 v5, v20
    goto +1eh
    invoke-static/range v22, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    invoke-static Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->access$getRefreshMutex$p()Lkotlinx/coroutines/sync/Mutex;
    move-result-object v5
    iget-object v11, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$performExchangeAndPersist$1;->$refreshToken Ljava/lang/String;
    iget-object v12, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$performExchangeAndPersist$1;->$callback Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback;
    move-object v13, v1
    check-cast v13, Lkotlin/coroutines/Continuation;
    iput-object v5, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$performExchangeAndPersist$1;->L$0 Ljava/lang/Object;
    iput-object v11, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$performExchangeAndPersist$1;->L$1 Ljava/lang/Object;
    iput-object v12, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$performExchangeAndPersist$1;->L$2 Ljava/lang/Object;
    iput v8, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$performExchangeAndPersist$1;->label I
    invoke-interface v5, v10, v13, Lkotlinx/coroutines/sync/Mutex;->lock(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v13
    if-ne v13, v4, +003h
    return-object v4
    sget-object v13, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;
    invoke-virtual v13, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->isFirstAppUpgrade()Z
    move-result v13
    sget-object v14, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v15, Ljava/lang/StringBuilder;
    invoke-direct v15, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    if-eqz v13, +003h
    goto +2h
    move v8, v9
    invoke-virtual v15, v8, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v14, v0, v3, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    sget-object v3, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;
    invoke-virtual v3, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->getJwtExpireAt()J
    move-result-wide v14
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v16
    sub-long v16, v14, v16
    const-wide/16 v18, 0
    cmp-long v3, v14, v18
    if-lez v3, +04eh
    const-wide/32 v14, 18000000
    cmp-long v3, v16, v14
    if-lez v3, +047h
    sget-object v3, Lcom/bytedance/trae/network/DebugSettings;->INSTANCE Lcom/bytedance/trae/network/DebugSettings;
    invoke-virtual v3, Lcom/bytedance/trae/network/DebugSettings;->getForceTokenRefresh()Z
    move-result v3
    if-nez v3, +03fh
    sget-object v3, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v8, Ljava/lang/StringBuilder;
    invoke-direct v8, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    const/16 v2, 1000
    int-to-long v14, v2
    div-long v14, v16, v14
    invoke-virtual v8, v14, v15, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v2
    const/16 v8, 115
    invoke-virtual v2, v8, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v3, v0, v2, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    if-nez v13, +020h
    invoke-static Lkotlinx/coroutines/Dispatchers;->getMain()Lkotlinx/coroutines/MainCoroutineDispatcher;
    move-result-object v0
    check-cast v0, Lkotlin/coroutines/CoroutineContext;
    new-instance v2, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$performExchangeAndPersist$1$1$1;
    invoke-direct v2, v12, v10, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$performExchangeAndPersist$1$1$1;-><init>(Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback; Lkotlin/coroutines/Continuation;)V
    check-cast v2, Lkotlin/jvm/functions/Function2;
    iput-object v5, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$performExchangeAndPersist$1;->L$0 Ljava/lang/Object;
    iput-object v10, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$performExchangeAndPersist$1;->L$1 Ljava/lang/Object;
    iput-object v10, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$performExchangeAndPersist$1;->L$2 Ljava/lang/Object;
    iput v7, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$performExchangeAndPersist$1;->label I
    invoke-static v0, v2, v1, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v4, +003h
    return-object v4
    move-object v2, v5
    goto +12h
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    iput-object v5, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$performExchangeAndPersist$1;->L$0 Ljava/lang/Object;
    iput-object v10, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$performExchangeAndPersist$1;->L$1 Ljava/lang/Object;
    iput-object v10, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$performExchangeAndPersist$1;->L$2 Ljava/lang/Object;
    iput v6, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$performExchangeAndPersist$1;->label I
    invoke-virtual v0, v11, v12, v9, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->exchangeTokenOrThrowIgnoreDevice$impl_mainlandRelease(Ljava/lang/String; Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback; Z Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v4, -010h
    return-object v4
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-interface v2, v10, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    invoke-static Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->access$isExchangeRequesting$p()Ljava/util/concurrent/atomic/AtomicBoolean;
    move-result-object v0
    invoke-virtual v0, v9, Ljava/util/concurrent/atomic/AtomicBoolean;->set(Z)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
    move-exception v0
    move-object v2, v5
    invoke-interface v2, v10, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    throw v0
    move-exception v0
    invoke-static Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->access$isExchangeRequesting$p()Ljava/util/concurrent/atomic/AtomicBoolean;
    move-result-object v2
    invoke-virtual v2, v9, Ljava/util/concurrent/atomic/AtomicBoolean;->set(Z)V
    throw v0
    :try_start_0x30
    :try_start_0x44
    :try_start_0x50
    :try_start_0x6a
    :try_start_0xf8
    :try_start_0xfa
    :try_start_0x109
.end method
