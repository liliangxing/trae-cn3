# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/DefaultCliListService$unregisterCli$2;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "CliListRepository.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $cliId:Ljava/lang/String;
.field private synthetic L$0:Ljava/lang/Object;
.field  label:I


.method constructor <init>(java.lang.String  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/conversation/DefaultCliListService$unregisterCli$2;->$cliId Ljava/lang/String;
    const/4 v1, 2
    invoke-direct v0, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/conversation/DefaultCliListService$unregisterCli$2;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/DefaultCliListService$unregisterCli$2;->$cliId Ljava/lang/String;
    invoke-direct v0, v1, v4, Lcom/bytedance/trae/conversation/DefaultCliListService$unregisterCli$2;-><init>(Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    iput-object v3, v0, Lcom/bytedance/trae/conversation/DefaultCliListService$unregisterCli$2;->L$0 Ljava/lang/Object;
    check-cast v0, Lkotlin/coroutines/Continuation;
    return-object v0
.end method

.method public final invoke(com.bytedance.trae.im.service.IListClisService  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/DefaultCliListService$unregisterCli$2;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/DefaultCliListService$unregisterCli$2;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/DefaultCliListService$unregisterCli$2;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lcom/bytedance/trae/im/service/IListClisService;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/DefaultCliListService$unregisterCli$2;->invoke(Lcom/bytedance/trae/im/service/IListClisService; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 6
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v4, Lcom/bytedance/trae/conversation/DefaultCliListService$unregisterCli$2;->label I
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
    iget-object v5, v4, Lcom/bytedance/trae/conversation/DefaultCliListService$unregisterCli$2;->L$0 Ljava/lang/Object;
    check-cast v5, Lcom/bytedance/trae/im/service/IListClisService;
    new-instance v1, Lcom/bytedance/trae/im/service/UnregisterCliRequest;
    iget-object v3, v4, Lcom/bytedance/trae/conversation/DefaultCliListService$unregisterCli$2;->$cliId Ljava/lang/String;
    invoke-direct v1, v3, Lcom/bytedance/trae/im/service/UnregisterCliRequest;-><init>(Ljava/lang/String;)V
    move-object v3, v4
    check-cast v3, Lkotlin/coroutines/Continuation;
    iput v2, v4, Lcom/bytedance/trae/conversation/DefaultCliListService$unregisterCli$2;->label I
    invoke-interface v5, v1, v3, Lcom/bytedance/trae/im/service/IListClisService;->unregisterCli(Lcom/bytedance/trae/im/service/UnregisterCliRequest; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v5
    if-ne v5, v0, +003h
    return-object v0
    return-object v5
.end method
