# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/network/HubNetFallbackApi$Companion$pollRawCall$2;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "HubNetFallbackApi.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $deviceId:Ljava/lang/String;
.field final synthetic $fromDownSeqId:Ljava/lang/Long;
.field final synthetic $frontierId:J
.field final synthetic $limit:Ljava/lang/Integer;
.field private synthetic L$0:Ljava/lang/Object;
.field  label:I


.method constructor <init>(long  java.lang.String  java.lang.Long  java.lang.Integer  kotlin.coroutines.Continuation)void
    .registers 7
    # ins_size=7
    iput-wide v1, v0, Lcom/bytedance/trae/network/HubNetFallbackApi$Companion$pollRawCall$2;->$frontierId J
    iput-object v3, v0, Lcom/bytedance/trae/network/HubNetFallbackApi$Companion$pollRawCall$2;->$deviceId Ljava/lang/String;
    iput-object v4, v0, Lcom/bytedance/trae/network/HubNetFallbackApi$Companion$pollRawCall$2;->$fromDownSeqId Ljava/lang/Long;
    iput-object v5, v0, Lcom/bytedance/trae/network/HubNetFallbackApi$Companion$pollRawCall$2;->$limit Ljava/lang/Integer;
    const/4 v1, 2
    invoke-direct v0, v1, v6, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 11
    # ins_size=3
    new-instance v7, Lcom/bytedance/trae/network/HubNetFallbackApi$Companion$pollRawCall$2;
    iget-wide v1, v8, Lcom/bytedance/trae/network/HubNetFallbackApi$Companion$pollRawCall$2;->$frontierId J
    iget-object v3, v8, Lcom/bytedance/trae/network/HubNetFallbackApi$Companion$pollRawCall$2;->$deviceId Ljava/lang/String;
    iget-object v4, v8, Lcom/bytedance/trae/network/HubNetFallbackApi$Companion$pollRawCall$2;->$fromDownSeqId Ljava/lang/Long;
    iget-object v5, v8, Lcom/bytedance/trae/network/HubNetFallbackApi$Companion$pollRawCall$2;->$limit Ljava/lang/Integer;
    move-object v0, v7
    move-object v6, v10
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/network/HubNetFallbackApi$Companion$pollRawCall$2;-><init>(J Ljava/lang/String; Ljava/lang/Long; Ljava/lang/Integer; Lkotlin/coroutines/Continuation;)V
    iput-object v9, v7, Lcom/bytedance/trae/network/HubNetFallbackApi$Companion$pollRawCall$2;->L$0 Ljava/lang/Object;
    check-cast v7, Lkotlin/coroutines/Continuation;
    return-object v7
.end method

.method public final invoke(com.bytedance.trae.network.HubNetFallbackApi  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/network/HubNetFallbackApi$Companion$pollRawCall$2;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/network/HubNetFallbackApi$Companion$pollRawCall$2;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/network/HubNetFallbackApi$Companion$pollRawCall$2;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lcom/bytedance/trae/network/HubNetFallbackApi;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/network/HubNetFallbackApi$Companion$pollRawCall$2;->invoke(Lcom/bytedance/trae/network/HubNetFallbackApi; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 13
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v11, Lcom/bytedance/trae/network/HubNetFallbackApi$Companion$pollRawCall$2;->label I
    const/4 v2, 1
    if-eqz v1, +010h
    if-ne v1, v2, +006h
    invoke-static v12, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +27h
    new-instance v12, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v12, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v12
    invoke-static v12, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v12, v11, Lcom/bytedance/trae/network/HubNetFallbackApi$Companion$pollRawCall$2;->L$0 Ljava/lang/Object;
    move-object v3, v12
    check-cast v3, Lcom/bytedance/trae/network/HubNetFallbackApi;
    iget-wide v4, v11, Lcom/bytedance/trae/network/HubNetFallbackApi$Companion$pollRawCall$2;->$frontierId J
    iget-object v6, v11, Lcom/bytedance/trae/network/HubNetFallbackApi$Companion$pollRawCall$2;->$deviceId Ljava/lang/String;
    iget-object v7, v11, Lcom/bytedance/trae/network/HubNetFallbackApi$Companion$pollRawCall$2;->$fromDownSeqId Ljava/lang/Long;
    iget-object v8, v11, Lcom/bytedance/trae/network/HubNetFallbackApi$Companion$pollRawCall$2;->$limit Ljava/lang/Integer;
    const/high16 v9, 52428800
    move-object v10, v11
    check-cast v10, Lkotlin/coroutines/Continuation;
    iput v2, v11, Lcom/bytedance/trae/network/HubNetFallbackApi$Companion$pollRawCall$2;->label I
    invoke-interface/range v3 ... v10, Lcom/bytedance/trae/network/HubNetFallbackApi;->poll(J Ljava/lang/String; Ljava/lang/Long; Ljava/lang/Integer; I Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v12
    if-ne v12, v0, +003h
    return-object v0
    return-object v12
.end method
