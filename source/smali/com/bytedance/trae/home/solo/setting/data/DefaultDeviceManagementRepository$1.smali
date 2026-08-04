# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "DeviceManagementRepository.kt"

.implements Lkotlin/jvm/functions/Function2;

.field  L$0:Ljava/lang/Object;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;


.method constructor <init>(com.bytedance.trae.home.solo.setting.data.DefaultDeviceManagementRepository  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$1;->this$0 Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;
    const/4 v1, 2
    invoke-direct v0, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 4
    # ins_size=3
    new-instance v2, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$1;
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$1;->this$0 Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;
    invoke-direct v2, v0, v3, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$1;-><init>(Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository; Lkotlin/coroutines/Continuation;)V
    check-cast v2, Lkotlin/coroutines/Continuation;
    return-object v2
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 8
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v6, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$1;->label I
    const/4 v2, 1
    if-eqz v1, +017h
    if-ne v1, v2, +00dh
    iget-object v1, v6, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$1;->L$0 Ljava/lang/Object;
    check-cast v1, Lkotlinx/coroutines/channels/ChannelIterator;
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v3, v1
    move-object v1, v0
    move-object v0, v6
    goto +2bh
    new-instance v7, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v7, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v7
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v7, v6, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$1;->this$0 Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;
    invoke-static v7, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;->access$getEvents$p(Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;)Lkotlinx/coroutines/channels/Channel;
    move-result-object v7
    invoke-interface v7, Lkotlinx/coroutines/channels/Channel;->iterator()Lkotlinx/coroutines/channels/ChannelIterator;
    move-result-object v7
    move-object v1, v7
    move-object v7, v6
    move-object v3, v7
    check-cast v3, Lkotlin/coroutines/Continuation;
    iput-object v1, v7, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$1;->L$0 Ljava/lang/Object;
    iput v2, v7, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$1;->label I
    invoke-interface v1, v3, Lkotlinx/coroutines/channels/ChannelIterator;->hasNext(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v3
    if-ne v3, v0, +003h
    return-object v0
    move-object v5, v0
    move-object v0, v7
    move-object v7, v3
    move-object v3, v1
    move-object v1, v5
    check-cast v7, Ljava/lang/Boolean;
    invoke-virtual v7, Ljava/lang/Boolean;->booleanValue()Z
    move-result v7
    if-eqz v7, +011h
    invoke-interface v3, Lkotlinx/coroutines/channels/ChannelIterator;->next()Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event;
    iget-object v4, v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$1;->this$0 Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;
    invoke-static v4, v7, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;->access$reduce(Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository; Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event;)V
    move-object v7, v0
    move-object v0, v1
    move-object v1, v3
    goto -29h
    sget-object v7, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v7
.end method
