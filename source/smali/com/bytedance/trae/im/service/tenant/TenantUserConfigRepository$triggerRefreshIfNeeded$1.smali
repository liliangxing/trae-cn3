# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$triggerRefreshIfNeeded$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "TenantUserConfigRepository.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $generation:J
.field final synthetic $source:Ljava/lang/String;
.field  label:I


.method constructor <init>(java.lang.String  long  kotlin.coroutines.Continuation)void
    .registers 5
    # ins_size=5
    iput-object v1, v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$triggerRefreshIfNeeded$1;->$source Ljava/lang/String;
    iput-wide v2, v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$triggerRefreshIfNeeded$1;->$generation J
    const/4 v1, 2
    invoke-direct v0, v1, v4, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 6
    # ins_size=3
    new-instance v4, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$triggerRefreshIfNeeded$1;
    iget-object v0, v3, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$triggerRefreshIfNeeded$1;->$source Ljava/lang/String;
    iget-wide v1, v3, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$triggerRefreshIfNeeded$1;->$generation J
    invoke-direct v4, v0, v1, v2, v5, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$triggerRefreshIfNeeded$1;-><init>(Ljava/lang/String; J Lkotlin/coroutines/Continuation;)V
    check-cast v4, Lkotlin/coroutines/Continuation;
    return-object v4
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$triggerRefreshIfNeeded$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$triggerRefreshIfNeeded$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$triggerRefreshIfNeeded$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$triggerRefreshIfNeeded$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 9
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v7, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$triggerRefreshIfNeeded$1;->label I
    const/4 v2, 1
    if-eqz v1, +010h
    if-ne v1, v2, +006h
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +20h
    new-instance v8, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v8, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v8
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v1, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->INSTANCE Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;
    const/4 v8, 0
    iget-object v3, v7, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$triggerRefreshIfNeeded$1;->$source Ljava/lang/String;
    iget-wide v4, v7, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$triggerRefreshIfNeeded$1;->$generation J
    move-object v6, v7
    check-cast v6, Lkotlin/coroutines/Continuation;
    iput v2, v7, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository$triggerRefreshIfNeeded$1;->label I
    move v2, v8
    invoke-static/range v1 ... v6, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository;->access$refresh(Lcom/bytedance/trae/im/service/tenant/TenantUserConfigRepository; Z Ljava/lang/String; J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v8
    if-ne v8, v0, +003h
    return-object v0
    sget-object v8, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v8
.end method
