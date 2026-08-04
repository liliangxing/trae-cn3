# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$startNextMutation$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "DeviceManagementRepository.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $mutation:Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Mutation;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;


.method constructor <init>(com.bytedance.trae.home.solo.setting.data.DefaultDeviceManagementRepository  com.bytedance.trae.home.solo.setting.data.DefaultDeviceManagementRepository$Mutation  kotlin.coroutines.Continuation)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$startNextMutation$1;->this$0 Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$startNextMutation$1;->$mutation Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Mutation;
    const/4 v1, 2
    invoke-direct v0, v1, v3, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v3, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$startNextMutation$1;
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$startNextMutation$1;->this$0 Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$startNextMutation$1;->$mutation Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Mutation;
    invoke-direct v3, v0, v1, v4, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$startNextMutation$1;-><init>(Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository; Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Mutation; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/coroutines/Continuation;
    return-object v3
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$startNextMutation$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$startNextMutation$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$startNextMutation$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$startNextMutation$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 9
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v7, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$startNextMutation$1;->label I
    const/4 v2, 2
    const/4 v3, 1
    if-eqz v1, +016h
    if-eq v1, v3, +010h
    if-ne v1, v2, +006h
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +49h
    new-instance v8, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v8, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v8
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +14h
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v8, v7, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$startNextMutation$1;->this$0 Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;
    iget-object v1, v7, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$startNextMutation$1;->$mutation Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Mutation;
    move-object v4, v7
    check-cast v4, Lkotlin/coroutines/Continuation;
    iput v3, v7, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$startNextMutation$1;->label I
    invoke-static v8, v1, v4, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;->access$executeMutation(Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository; Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Mutation; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v8
    if-ne v8, v0, +003h
    return-object v0
    check-cast v8, Ljava/lang/Boolean;
    invoke-virtual v8, Ljava/lang/Boolean;->booleanValue()Z
    move-result v8
    iget-object v1, v7, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$startNextMutation$1;->this$0 Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;
    invoke-static v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;->access$getEvents$p(Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;)Lkotlinx/coroutines/channels/Channel;
    move-result-object v1
    new-instance v3, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationCompleted;
    iget-object v4, v7, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$startNextMutation$1;->$mutation Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Mutation;
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Mutation;->getOperationId()J
    move-result-wide v4
    iget-object v6, v7, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$startNextMutation$1;->$mutation Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Mutation;
    invoke-virtual v6, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Mutation;->getCliId()Ljava/lang/String;
    move-result-object v6
    invoke-direct v3, v4, v5, v6, v8, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationCompleted;-><init>(J Ljava/lang/String; Z)V
    move-object v8, v7
    check-cast v8, Lkotlin/coroutines/Continuation;
    iput v2, v7, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$startNextMutation$1;->label I
    invoke-interface v1, v3, v8, Lkotlinx/coroutines/channels/Channel;->send(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v8
    if-ne v8, v0, +003h
    return-object v0
    sget-object v8, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v8
.end method
