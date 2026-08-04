# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$fetchDevices$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "SettingsDeviceListViewModel.kt"

.implements Lkotlin/jvm/functions/Function2;

.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;


.method public static synthetic $r8$lambda$bNpF4CHls7NzmORrsB0HPjDdCfA(com.bytedance.trae.home.solo.setting.SettingsDeviceListViewModel  java.util.List)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$fetchDevices$1;->invokeSuspend$lambda$0(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel; Ljava/util/List;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method constructor <init>(com.bytedance.trae.home.solo.setting.SettingsDeviceListViewModel  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$fetchDevices$1;->this$0 Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;
    const/4 v1, 2
    invoke-direct v0, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method private static final invokeSuspend$lambda$0(com.bytedance.trae.home.solo.setting.SettingsDeviceListViewModel  java.util.List)kotlin.Unit
    .registers 3
    # ins_size=2
    invoke-static v1, v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->access$mapDevices(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel; Ljava/util/List;)Ljava/util/List;
    move-result-object v2
    invoke-static v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceMapperKt;->pairedDeviceIds(Ljava/util/List;)Ljava/util/Set;
    move-result-object v0
    invoke-static v1, v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->access$setPreviousPairedDeviceIds$p(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel; Ljava/util/Set;)V
    invoke-static v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->access$get_devices$p(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;)Landroidx/lifecycle/MutableLiveData;
    move-result-object v0
    invoke-virtual v0, v2, Landroidx/lifecycle/MutableLiveData;->postValue(Ljava/lang/Object;)V
    invoke-static v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->access$get_isLoading$p(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;)Landroidx/lifecycle/MutableLiveData;
    move-result-object v1
    const/4 v2, 0
    invoke-static v2, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v2
    invoke-virtual v1, v2, Landroidx/lifecycle/MutableLiveData;->postValue(Ljava/lang/Object;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 4
    # ins_size=3
    new-instance v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$fetchDevices$1;
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$fetchDevices$1;->this$0 Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;
    invoke-direct v2, v0, v3, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$fetchDevices$1;-><init>(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel; Lkotlin/coroutines/Continuation;)V
    check-cast v2, Lkotlin/coroutines/Continuation;
    return-object v2
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$fetchDevices$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$fetchDevices$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$fetchDevices$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$fetchDevices$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 6
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v4, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$fetchDevices$1;->label I
    const/4 v2, 1
    if-eqz v1, +010h
    if-ne v1, v2, +006h
    invoke-static v5, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +25h
    new-instance v5, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v5, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v5
    invoke-static v5, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v5, v4, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$fetchDevices$1;->this$0 Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;
    invoke-static v5, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->access$getRepository$p(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;)Lcom/bytedance/trae/home/solo/setting/SettingsDeviceRepository;
    move-result-object v5
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$fetchDevices$1;->this$0 Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;
    new-instance v3, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$fetchDevices$1$$ExternalSyntheticLambda0;
    invoke-direct v3, v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$fetchDevices$1$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;)V
    move-object v1, v4
    check-cast v1, Lkotlin/coroutines/Continuation;
    iput v2, v4, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$fetchDevices$1;->label I
    invoke-interface v5, v3, v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceRepository;->fetchDevices(Lkotlin/jvm/functions/Function1; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v5
    if-ne v5, v0, +003h
    return-object v0
    sget-object v5, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v5
.end method
