# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/im/service/IMService$payloadReceiver$1$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "IMService.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $data:Ljava/lang/String;
.field final synthetic $isConsecutiveSeq:Z
.field final synthetic $proto:I
.field  label:I


.method constructor <init>(int  java.lang.String  boolean  kotlin.coroutines.Continuation)void
    .registers 5
    # ins_size=5
    iput v1, v0, Lcom/bytedance/trae/im/service/IMService$payloadReceiver$1$1;->$proto I
    iput-object v2, v0, Lcom/bytedance/trae/im/service/IMService$payloadReceiver$1$1;->$data Ljava/lang/String;
    iput-boolean v3, v0, Lcom/bytedance/trae/im/service/IMService$payloadReceiver$1$1;->$isConsecutiveSeq Z
    const/4 v1, 2
    invoke-direct v0, v1, v4, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 6
    # ins_size=3
    new-instance v4, Lcom/bytedance/trae/im/service/IMService$payloadReceiver$1$1;
    iget v0, v3, Lcom/bytedance/trae/im/service/IMService$payloadReceiver$1$1;->$proto I
    iget-object v1, v3, Lcom/bytedance/trae/im/service/IMService$payloadReceiver$1$1;->$data Ljava/lang/String;
    iget-boolean v2, v3, Lcom/bytedance/trae/im/service/IMService$payloadReceiver$1$1;->$isConsecutiveSeq Z
    invoke-direct v4, v0, v1, v2, v5, Lcom/bytedance/trae/im/service/IMService$payloadReceiver$1$1;-><init>(I Ljava/lang/String; Z Lkotlin/coroutines/Continuation;)V
    check-cast v4, Lkotlin/coroutines/Continuation;
    return-object v4
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/im/service/IMService$payloadReceiver$1$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/im/service/IMService$payloadReceiver$1$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/im/service/IMService$payloadReceiver$1$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/im/service/IMService$payloadReceiver$1$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 5
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    iget v0, v3, Lcom/bytedance/trae/im/service/IMService$payloadReceiver$1$1;->label I
    if-nez v0, +013h
    invoke-static v4, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v4, Lcom/bytedance/trae/im/service/IMService;->INSTANCE Lcom/bytedance/trae/im/service/IMService;
    iget v0, v3, Lcom/bytedance/trae/im/service/IMService$payloadReceiver$1$1;->$proto I
    iget-object v1, v3, Lcom/bytedance/trae/im/service/IMService$payloadReceiver$1$1;->$data Ljava/lang/String;
    iget-boolean v2, v3, Lcom/bytedance/trae/im/service/IMService$payloadReceiver$1$1;->$isConsecutiveSeq Z
    invoke-static v4, v0, v1, v2, Lcom/bytedance/trae/im/service/IMService;->access$parsePayload(Lcom/bytedance/trae/im/service/IMService; I Ljava/lang/String; Z)V
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v4
    new-instance v4, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v4, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v4
.end method
