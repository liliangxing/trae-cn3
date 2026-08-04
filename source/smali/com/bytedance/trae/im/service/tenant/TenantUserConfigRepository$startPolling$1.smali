# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$startPolling$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "TenantUserConfigRepository.kt"

.implements Lkotlin/jvm/functions/Function2;

.field private synthetic L$0:Ljava/lang/Object;
.field  label:I


.method constructor <init>(kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=2
    const/4 v0, 2
    invoke-direct v1, v0, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 4
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$startPolling$1;
    invoke-direct v0, v3, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$startPolling$1;-><init>(Lkotlin/coroutines/Continuation;)V
    iput-object v2, v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$startPolling$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lkotlin/coroutines/Continuation;
    return-object v0
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$startPolling$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$startPolling$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$startPolling$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$startPolling$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 12
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v10, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$startPolling$1;->label I
    const/4 v2, 2
    const/4 v3, 1
    if-eqz v1, +021h
    if-eq v1, v3, +015h
    if-ne v1, v2, +00bh
    iget-object v1, v10, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$startPolling$1;->L$0 Ljava/lang/Object;
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    invoke-static v11, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v11, v1
    goto +1ah
    new-instance v11, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v11, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v11
    iget-object v1, v10, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$startPolling$1;->L$0 Ljava/lang/Object;
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    invoke-static v11, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v11, v1
    move-object v1, v10
    goto +20h
    invoke-static v11, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v11, v10, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$startPolling$1;->L$0 Ljava/lang/Object;
    check-cast v11, Lkotlinx/coroutines/CoroutineScope;
    move-object v1, v10
    invoke-static v11, Lkotlinx/coroutines/CoroutineScopeKt;->isActive(Lkotlinx/coroutines/CoroutineScope;)Z
    move-result v4
    if-eqz v4, +02ch
    move-object v4, v1
    check-cast v4, Lkotlin/coroutines/Continuation;
    iput-object v11, v1, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$startPolling$1;->L$0 Ljava/lang/Object;
    iput v3, v1, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$startPolling$1;->label I
    const-wide/32 v5, 600000
    invoke-static v5, v6, v4, Lkotlinx/coroutines/DelayKt;->delay(J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v4
    if-ne v4, v0, +003h
    return-object v0
    sget-object v4, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->INSTANCE Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;
    const/4 v5, 1
    const-string v6, "polling"
    sget-object v7, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->INSTANCE Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;
    invoke-static v7, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->access$currentGeneration(Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;)J
    move-result-wide v7
    move-object v9, v1
    check-cast v9, Lkotlin/coroutines/Continuation;
    iput-object v11, v1, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$startPolling$1;->L$0 Ljava/lang/Object;
    iput v2, v1, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$startPolling$1;->label I
    invoke-static/range v4 ... v9, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->access$refresh(Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository; Z Ljava/lang/String; J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v4
    if-ne v4, v0, -02dh
    return-object v0
    sget-object v11, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v11
.end method
