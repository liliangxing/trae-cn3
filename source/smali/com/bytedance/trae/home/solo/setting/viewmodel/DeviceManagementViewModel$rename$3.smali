# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$rename$3;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "DeviceManagementViewModel.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $device:Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;
.field final synthetic $trimmed:Ljava/lang/String;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel;


.method constructor <init>(com.bytedance.trae.home.solo.setting.viewmodel.DeviceManagementViewModel  com.bytedance.trae.home.solo.setting.data.DeviceManagementDevice  java.lang.String  kotlin.coroutines.Continuation)void
    .registers 5
    # ins_size=5
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$rename$3;->this$0 Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$rename$3;->$device Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;
    iput-object v3, v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$rename$3;->$trimmed Ljava/lang/String;
    const/4 v1, 2
    invoke-direct v0, v1, v4, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 6
    # ins_size=3
    new-instance v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$rename$3;
    iget-object v0, v3, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$rename$3;->this$0 Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel;
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$rename$3;->$device Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$rename$3;->$trimmed Ljava/lang/String;
    invoke-direct v4, v0, v1, v2, v5, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$rename$3;-><init>(Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel; Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v4, Lkotlin/coroutines/Continuation;
    return-object v4
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$rename$3;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$rename$3;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$rename$3;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$rename$3;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 8
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v6, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$rename$3;->label I
    const/4 v2, 2
    const/4 v3, 1
    if-eqz v1, +016h
    if-eq v1, v3, +010h
    if-ne v1, v2, +006h
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +46h
    new-instance v7, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v7, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v7
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +1eh
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v7, v6, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$rename$3;->this$0 Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel;
    invoke-static v7, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel;->access$getRepository$p(Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel;)Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementRepository;
    move-result-object v7
    iget-object v1, v6, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$rename$3;->$device Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;->getId()Ljava/lang/String;
    move-result-object v1
    iget-object v4, v6, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$rename$3;->$trimmed Ljava/lang/String;
    move-object v5, v6
    check-cast v5, Lkotlin/coroutines/Continuation;
    iput v3, v6, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$rename$3;->label I
    invoke-interface v7, v1, v4, v5, Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementRepository;->renameDevice(Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v7
    if-ne v7, v0, +003h
    return-object v0
    check-cast v7, Ljava/lang/Boolean;
    invoke-virtual v7, Ljava/lang/Boolean;->booleanValue()Z
    move-result v7
    if-eqz v7, +016h
    iget-object v7, v6, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$rename$3;->this$0 Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel;
    invoke-static v7, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel;->access$get_effects$p(Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v7
    sget-object v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementEffect$RefreshDeviceCache;->INSTANCE Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementEffect$RefreshDeviceCache;
    move-object v3, v6
    check-cast v3, Lkotlin/coroutines/Continuation;
    iput v2, v6, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$rename$3;->label I
    invoke-interface v7, v1, v3, Lkotlinx/coroutines/flow/MutableSharedFlow;->emit(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v7
    if-ne v7, v0, +003h
    return-object v0
    sget-object v7, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v7
.end method
