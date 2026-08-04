# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1$exchangeResult$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "TraeAuthManager.kt"

.implements Lkotlin/jvm/functions/Function1;

.field final synthetic $refreshResult:Lcom/bytedance/trae/login/traeauth/TraeGetRefreshTokenResult;
.field  label:I


.method constructor <init>(com.bytedance.trae.login.traeauth.TraeGetRefreshTokenResult  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1$exchangeResult$1;->$refreshResult Lcom/bytedance/trae/login/traeauth/TraeGetRefreshTokenResult;
    const/4 v1, 1
    invoke-direct v0, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 4
    # ins_size=2
    new-instance v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1$exchangeResult$1;
    iget-object v1, v2, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1$exchangeResult$1;->$refreshResult Lcom/bytedance/trae/login/traeauth/TraeGetRefreshTokenResult;
    invoke-direct v0, v1, v3, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1$exchangeResult$1;-><init>(Lcom/bytedance/trae/login/traeauth/TraeGetRefreshTokenResult; Lkotlin/coroutines/Continuation;)V
    check-cast v0, Lkotlin/coroutines/Continuation;
    return-object v0
.end method

.method public bridge synthetic invoke(java.lang.Object)java.lang.Object
    .registers 2
    # ins_size=2
    check-cast v1, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1$exchangeResult$1;->invoke(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=2
    invoke-virtual v1, v2, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1$exchangeResult$1;->create(Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1$exchangeResult$1;
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v2, v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1$exchangeResult$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    return-object v2
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 6
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v4, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1$exchangeResult$1;->label I
    const/4 v2, 1
    if-eqz v1, +010h
    if-ne v1, v2, +006h
    invoke-static v5, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +23h
    new-instance v5, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v5, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v5
    invoke-static v5, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v5, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    iget-object v1, v4, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1$exchangeResult$1;->$refreshResult Lcom/bytedance/trae/login/traeauth/TraeGetRefreshTokenResult;
    invoke-virtual v1, Lcom/bytedance/trae/login/traeauth/TraeGetRefreshTokenResult;->getRefreshToken()Ljava/lang/String;
    move-result-object v1
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    move-object v3, v4
    check-cast v3, Lkotlin/coroutines/Continuation;
    iput v2, v4, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$onPassportLoginSuccess$1$exchangeResult$1;->label I
    invoke-static v5, v1, v3, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->access$doExchangeTokenOrThrow(Lcom/bytedance/trae/login/traeauth/TraeAuthManager; Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v5
    if-ne v5, v0, +003h
    return-object v0
    return-object v5
.end method
