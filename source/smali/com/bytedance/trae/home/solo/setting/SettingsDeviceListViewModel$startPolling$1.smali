# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$startPolling$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "SettingsDeviceListViewModel.kt"

.implements Lkotlin/jvm/functions/Function2;

.field private synthetic L$0:Ljava/lang/Object;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;


.method public static synthetic $r8$lambda$HawWLvCKNAEQDh40MY_jVvuceIw(com.bytedance.trae.home.solo.setting.SettingsDeviceListViewModel  java.util.List)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$startPolling$1;->invokeSuspend$lambda$0(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel; Ljava/util/List;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method constructor <init>(com.bytedance.trae.home.solo.setting.SettingsDeviceListViewModel  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$startPolling$1;->this$0 Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;
    const/4 v1, 2
    invoke-direct v0, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method private static final invokeSuspend$lambda$0(com.bytedance.trae.home.solo.setting.SettingsDeviceListViewModel  java.util.List)kotlin.Unit
    .registers 4
    # ins_size=2
    invoke-static v2, v3, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->access$mapDevices(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel; Ljava/util/List;)Ljava/util/List;
    move-result-object v3
    invoke-static v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->access$getPreviousPairedDeviceIds$p(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;)Ljava/util/Set;
    move-result-object v0
    invoke-static v3, v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceMapperKt;->findNewlyBoundDeviceName(Ljava/util/List; Ljava/util/Set;)Ljava/lang/String;
    move-result-object v0
    if-eqz v0, +00fh
    invoke-static v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->access$getNewDeviceNotificationsEnabled$p(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;)Z
    move-result v1
    if-eqz v1, +009h
    invoke-static v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->access$get_newOnlineDevice$p(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;)Landroidx/lifecycle/MutableLiveData;
    move-result-object v1
    invoke-virtual v1, v0, Landroidx/lifecycle/MutableLiveData;->postValue(Ljava/lang/Object;)V
    invoke-static v3, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceMapperKt;->pairedDeviceIds(Ljava/util/List;)Ljava/util/Set;
    move-result-object v0
    invoke-static v2, v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->access$setPreviousPairedDeviceIds$p(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel; Ljava/util/Set;)V
    invoke-static v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->access$get_devices$p(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;)Landroidx/lifecycle/MutableLiveData;
    move-result-object v2
    invoke-virtual v2, v3, Landroidx/lifecycle/MutableLiveData;->postValue(Ljava/lang/Object;)V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v2
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$startPolling$1;
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$startPolling$1;->this$0 Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;
    invoke-direct v0, v1, v4, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$startPolling$1;-><init>(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel; Lkotlin/coroutines/Continuation;)V
    iput-object v3, v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$startPolling$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lkotlin/coroutines/Continuation;
    return-object v0
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$startPolling$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$startPolling$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$startPolling$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$startPolling$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 9
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v7, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$startPolling$1;->label I
    const/4 v2, 2
    const/4 v3, 1
    if-eqz v1, +021h
    if-eq v1, v3, +015h
    if-ne v1, v2, +00bh
    iget-object v1, v7, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$startPolling$1;->L$0 Ljava/lang/Object;
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v8, v1
    goto +1ah
    new-instance v8, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v8, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v8
    iget-object v1, v7, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$startPolling$1;->L$0 Ljava/lang/Object;
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v8, v1
    move-object v1, v7
    goto +1fh
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v8, v7, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$startPolling$1;->L$0 Ljava/lang/Object;
    check-cast v8, Lkotlinx/coroutines/CoroutineScope;
    move-object v1, v7
    invoke-static v8, Lkotlinx/coroutines/CoroutineScopeKt;->isActive(Lkotlinx/coroutines/CoroutineScope;)Z
    move-result v4
    if-eqz v4, +02dh
    move-object v4, v1
    check-cast v4, Lkotlin/coroutines/Continuation;
    iput-object v8, v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$startPolling$1;->L$0 Ljava/lang/Object;
    iput v3, v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$startPolling$1;->label I
    const-wide/16 v5, 5000
    invoke-static v5, v6, v4, Lkotlinx/coroutines/DelayKt;->delay(J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v4
    if-ne v4, v0, +003h
    return-object v0
    iget-object v4, v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$startPolling$1;->this$0 Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;
    invoke-static v4, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->access$getRepository$p(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;)Lcom/bytedance/trae/home/solo/setting/SettingsDeviceRepository;
    move-result-object v4
    iget-object v5, v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$startPolling$1;->this$0 Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;
    new-instance v6, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$startPolling$1$$ExternalSyntheticLambda0;
    invoke-direct v6, v5, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$startPolling$1$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;)V
    move-object v5, v1
    check-cast v5, Lkotlin/coroutines/Continuation;
    iput-object v8, v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$startPolling$1;->L$0 Ljava/lang/Object;
    iput v2, v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$startPolling$1;->label I
    invoke-interface v4, v6, v5, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceRepository;->fetchDevices(Lkotlin/jvm/functions/Function1; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v4
    if-ne v4, v0, -02eh
    return-object v0
    sget-object v8, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v8
.end method
