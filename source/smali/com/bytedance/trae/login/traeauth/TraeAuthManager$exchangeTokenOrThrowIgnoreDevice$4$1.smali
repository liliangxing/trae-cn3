# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$4$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "TraeAuthManager.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $callback:Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback;
.field final synthetic $refreshToken:Ljava/lang/String;
.field  label:I


.method constructor <init>(java.lang.String  com.bytedance.trae.login.traeauth.TraeAuthManager$TraeAuthCallback  kotlin.coroutines.Continuation)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$4$1;->$refreshToken Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$4$1;->$callback Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback;
    const/4 v1, 2
    invoke-direct v0, v1, v3, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v3, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$4$1;
    iget-object v0, v2, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$4$1;->$refreshToken Ljava/lang/String;
    iget-object v1, v2, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$4$1;->$callback Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback;
    invoke-direct v3, v0, v1, v4, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$4$1;-><init>(Ljava/lang/String; Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/coroutines/Continuation;
    return-object v3
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$4$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$4$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$4$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$4$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 7
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v5, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$4$1;->label I
    const/4 v2, 1
    if-eqz v1, +010h
    if-ne v1, v2, +006h
    invoke-static v6, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +1eh
    new-instance v6, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v6, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v6
    invoke-static v6, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v6, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthManager;
    iget-object v1, v5, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$4$1;->$refreshToken Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$4$1;->$callback Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback;
    move-object v4, v5
    check-cast v4, Lkotlin/coroutines/Continuation;
    iput v2, v5, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$4$1;->label I
    invoke-virtual v6, v1, v3, v2, v4, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->exchangeTokenOrThrowIgnoreDevice$impl_mainlandRelease(Ljava/lang/String; Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback; Z Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v6
    if-ne v6, v0, +003h
    return-object v0
    sget-object v6, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v6
.end method
