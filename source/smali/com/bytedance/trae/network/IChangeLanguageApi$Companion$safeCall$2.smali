# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/network/IChangeLanguageApi$Companion$safeCall$2;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "IChangeLanguageApi.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $deviceId:Ljava/lang/String;
.field final synthetic $language:Ljava/lang/String;
.field final synthetic $userId:Ljava/lang/String;
.field private synthetic L$0:Ljava/lang/Object;
.field  label:I


.method constructor <init>(java.lang.String  java.lang.String  java.lang.String  kotlin.coroutines.Continuation)void
    .registers 5
    # ins_size=5
    iput-object v1, v0, Lcom/bytedance/trae/network/IChangeLanguageApi$Companion$safeCall$2;->$deviceId Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/network/IChangeLanguageApi$Companion$safeCall$2;->$userId Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/network/IChangeLanguageApi$Companion$safeCall$2;->$language Ljava/lang/String;
    const/4 v1, 2
    invoke-direct v0, v1, v4, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 7
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/network/IChangeLanguageApi$Companion$safeCall$2;
    iget-object v1, v4, Lcom/bytedance/trae/network/IChangeLanguageApi$Companion$safeCall$2;->$deviceId Ljava/lang/String;
    iget-object v2, v4, Lcom/bytedance/trae/network/IChangeLanguageApi$Companion$safeCall$2;->$userId Ljava/lang/String;
    iget-object v3, v4, Lcom/bytedance/trae/network/IChangeLanguageApi$Companion$safeCall$2;->$language Ljava/lang/String;
    invoke-direct v0, v1, v2, v3, v6, Lcom/bytedance/trae/network/IChangeLanguageApi$Companion$safeCall$2;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    iput-object v5, v0, Lcom/bytedance/trae/network/IChangeLanguageApi$Companion$safeCall$2;->L$0 Ljava/lang/Object;
    check-cast v0, Lkotlin/coroutines/Continuation;
    return-object v0
.end method

.method public final invoke(com.bytedance.trae.network.IChangeLanguageApi  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/network/IChangeLanguageApi$Companion$safeCall$2;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/network/IChangeLanguageApi$Companion$safeCall$2;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/network/IChangeLanguageApi$Companion$safeCall$2;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lcom/bytedance/trae/network/IChangeLanguageApi;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/network/IChangeLanguageApi$Companion$safeCall$2;->invoke(Lcom/bytedance/trae/network/IChangeLanguageApi; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 11
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v9, Lcom/bytedance/trae/network/IChangeLanguageApi$Companion$safeCall$2;->label I
    const/4 v2, 1
    if-eqz v1, +010h
    if-ne v1, v2, +006h
    invoke-static v10, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +2ah
    new-instance v10, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v10, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v10
    invoke-static v10, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v10, v9, Lcom/bytedance/trae/network/IChangeLanguageApi$Companion$safeCall$2;->L$0 Ljava/lang/Object;
    move-object v3, v10
    check-cast v3, Lcom/bytedance/trae/network/IChangeLanguageApi;
    iget-object v4, v9, Lcom/bytedance/trae/network/IChangeLanguageApi$Companion$safeCall$2;->$deviceId Ljava/lang/String;
    iget-object v5, v9, Lcom/bytedance/trae/network/IChangeLanguageApi$Companion$safeCall$2;->$userId Ljava/lang/String;
    iget-object v6, v9, Lcom/bytedance/trae/network/IChangeLanguageApi$Companion$safeCall$2;->$language Ljava/lang/String;
    new-instance v7, Lcom/bytedance/trae/network/ChangeLanguageRequest;
    iget-object v10, v9, Lcom/bytedance/trae/network/IChangeLanguageApi$Companion$safeCall$2;->$language Ljava/lang/String;
    invoke-direct v7, v10, Lcom/bytedance/trae/network/ChangeLanguageRequest;-><init>(Ljava/lang/String;)V
    move-object v8, v9
    check-cast v8, Lkotlin/coroutines/Continuation;
    iput v2, v9, Lcom/bytedance/trae/network/IChangeLanguageApi$Companion$safeCall$2;->label I
    invoke-interface/range v3 ... v8, Lcom/bytedance/trae/network/IChangeLanguageApi;->changeLanguage(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/network/ChangeLanguageRequest; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v10
    if-ne v10, v0, +003h
    return-object v0
    return-object v10
.end method
