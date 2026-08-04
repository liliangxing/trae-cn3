# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$startPolling$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "DeviceManagementViewModel.kt"

.implements Lkotlin/jvm/functions/Function2;

.field private synthetic L$0:Ljava/lang/Object;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel;


.method constructor <init>(com.bytedance.trae.home.solo.setting.viewmodel.DeviceManagementViewModel  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$startPolling$1;->this$0 Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel;
    const/4 v1, 2
    invoke-direct v0, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$startPolling$1;
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$startPolling$1;->this$0 Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel;
    invoke-direct v0, v1, v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$startPolling$1;-><init>(Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel; Lkotlin/coroutines/Continuation;)V
    iput-object v3, v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$startPolling$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lkotlin/coroutines/Continuation;
    return-object v0
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$startPolling$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$startPolling$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$startPolling$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$startPolling$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 9
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v7, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$startPolling$1;->label I
    const/4 v2, 2
    const/4 v3, 1
    if-eqz v1, +021h
    if-eq v1, v3, +015h
    if-ne v1, v2, +00bh
    iget-object v1, v7, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$startPolling$1;->L$0 Ljava/lang/Object;
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v8, v1
    goto +1ah
    new-instance v8, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v8, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v8
    iget-object v1, v7, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$startPolling$1;->L$0 Ljava/lang/Object;
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v8, v1
    move-object v1, v7
    goto +1fh
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v8, v7, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$startPolling$1;->L$0 Ljava/lang/Object;
    check-cast v8, Lkotlinx/coroutines/CoroutineScope;
    move-object v1, v7
    invoke-static v8, Lkotlinx/coroutines/CoroutineScopeKt;->isActive(Lkotlinx/coroutines/CoroutineScope;)Z
    move-result v4
    if-eqz v4, +023h
    move-object v4, v1
    check-cast v4, Lkotlin/coroutines/Continuation;
    iput-object v8, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$startPolling$1;->L$0 Ljava/lang/Object;
    iput v3, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$startPolling$1;->label I
    const-wide/16 v5, 5000
    invoke-static v5, v6, v4, Lkotlinx/coroutines/DelayKt;->delay(J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v4
    if-ne v4, v0, +003h
    return-object v0
    iget-object v4, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$startPolling$1;->this$0 Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel;
    move-object v5, v1
    check-cast v5, Lkotlin/coroutines/Continuation;
    iput-object v8, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$startPolling$1;->L$0 Ljava/lang/Object;
    iput v2, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$startPolling$1;->label I
    const/4 v6, 0
    invoke-static v4, v6, v5, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel;->access$refreshDevices(Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel; Z Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v4
    if-ne v4, v0, -024h
    return-object v0
    sget-object v8, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v8
.end method
