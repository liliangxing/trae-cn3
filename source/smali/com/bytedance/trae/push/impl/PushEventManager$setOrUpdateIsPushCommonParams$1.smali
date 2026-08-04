# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/push/impl/PushEventManager$setOrUpdateIsPushCommonParams$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "PushEventManager.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $isPush:I
.field final synthetic $pushContentType:Ljava/lang/String;
.field  label:I


.method constructor <init>(int  java.lang.String  kotlin.coroutines.Continuation)void
    .registers 4
    # ins_size=4
    iput v1, v0, Lcom/bytedance/trae/push/impl/PushEventManager$setOrUpdateIsPushCommonParams$1;->$isPush I
    iput-object v2, v0, Lcom/bytedance/trae/push/impl/PushEventManager$setOrUpdateIsPushCommonParams$1;->$pushContentType Ljava/lang/String;
    const/4 v1, 2
    invoke-direct v0, v1, v3, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v3, Lcom/bytedance/trae/push/impl/PushEventManager$setOrUpdateIsPushCommonParams$1;
    iget v0, v2, Lcom/bytedance/trae/push/impl/PushEventManager$setOrUpdateIsPushCommonParams$1;->$isPush I
    iget-object v1, v2, Lcom/bytedance/trae/push/impl/PushEventManager$setOrUpdateIsPushCommonParams$1;->$pushContentType Ljava/lang/String;
    invoke-direct v3, v0, v1, v4, Lcom/bytedance/trae/push/impl/PushEventManager$setOrUpdateIsPushCommonParams$1;-><init>(I Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/coroutines/Continuation;
    return-object v3
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/push/impl/PushEventManager$setOrUpdateIsPushCommonParams$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/push/impl/PushEventManager$setOrUpdateIsPushCommonParams$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/push/impl/PushEventManager$setOrUpdateIsPushCommonParams$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/push/impl/PushEventManager$setOrUpdateIsPushCommonParams$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 4
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    iget v0, v2, Lcom/bytedance/trae/push/impl/PushEventManager$setOrUpdateIsPushCommonParams$1;->label I
    if-nez v0, +01fh
    invoke-static v3, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v3, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    iget v0, v2, Lcom/bytedance/trae/push/impl/PushEventManager$setOrUpdateIsPushCommonParams$1;->$isPush I
    invoke-static v0, Lkotlin/coroutines/jvm/internal/Boxing;->boxInt(I)Ljava/lang/Integer;
    move-result-object v0
    const-string v1, "is_push"
    invoke-virtual v3, v1, v0, Lcom/bytedance/trae/applog/api/IApplog$Companion;->setHeaderInfo(Ljava/lang/String; Ljava/lang/Object;)V
    sget-object v3, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    const-string/jumbo v0, push_content_type
    iget-object v1, v2, Lcom/bytedance/trae/push/impl/PushEventManager$setOrUpdateIsPushCommonParams$1;->$pushContentType Ljava/lang/String;
    invoke-virtual v3, v0, v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->setHeaderInfo(Ljava/lang/String; Ljava/lang/Object;)V
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v3
    new-instance v3, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v3, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v3
.end method
