# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/devices/DeviceListViewModel$fetchDevices$3;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "DeviceListViewModel.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $context:Landroid/content/Context;
.field final synthetic $isCodeMode:Z
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;


.method constructor <init>(com.bytedance.trae.conversation.devices.DeviceListViewModel  android.content.Context  boolean  kotlin.coroutines.Continuation)void
    .registers 5
    # ins_size=5
    iput-object v1, v0, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel$fetchDevices$3;->this$0 Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel$fetchDevices$3;->$context Landroid/content/Context;
    iput-boolean v3, v0, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel$fetchDevices$3;->$isCodeMode Z
    const/4 v1, 2
    invoke-direct v0, v1, v4, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 6
    # ins_size=3
    new-instance v4, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel$fetchDevices$3;
    iget-object v0, v3, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel$fetchDevices$3;->this$0 Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel$fetchDevices$3;->$context Landroid/content/Context;
    iget-boolean v2, v3, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel$fetchDevices$3;->$isCodeMode Z
    invoke-direct v4, v0, v1, v2, v5, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel$fetchDevices$3;-><init>(Lcom/bytedance/trae/conversation/devices/DeviceListViewModel; Landroid/content/Context; Z Lkotlin/coroutines/Continuation;)V
    check-cast v4, Lkotlin/coroutines/Continuation;
    return-object v4
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel$fetchDevices$3;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel$fetchDevices$3;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel$fetchDevices$3;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel$fetchDevices$3;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 18
    # ins_size=2
    move-object/from16 v0, v16
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel$fetchDevices$3;->label I
    const/4 v3, 1
    if-eqz v2, +012h
    if-ne v2, v3, +008h
    invoke-static/range v17, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v2, v17
    goto +1eh
    new-instance v1, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v1, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v1
    invoke-static/range v17, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v2, v0, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel$fetchDevices$3;->this$0 Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;
    invoke-static v2, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;->access$getRepository$p(Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;)Lcom/bytedance/trae/conversation/CliListRepository;
    move-result-object v2
    move-object v4, v0
    check-cast v4, Lkotlin/coroutines/Continuation;
    iput v3, v0, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel$fetchDevices$3;->label I
    invoke-virtual v2, v4, Lcom/bytedance/trae/conversation/CliListRepository;->refreshDiscoverableDevices(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v1, +003h
    return-object v1
    check-cast v2, Lcom/bytedance/trae/conversation/DeviceDiscoveryRefreshResult;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/DeviceDiscoveryRefreshResult;->getDevices()Ljava/util/List;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/conversation/devices/DeviceItem;
    const-string v5, "cloud"
    iget-object v4, v0, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel$fetchDevices$3;->$context Landroid/content/Context;
    sget v6, Lcom/bytedance/trae/multilanguage/R$string;->trae_solo_cloud I
    invoke-virtual v4, v6, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v6
    const-string v4, "getString(...)"
    invoke-static v6, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v7, 0
    sget v8, Lcom/bytedance/trae/conversation/R$drawable;->ic_remote I
    const/4 v9, 1
    const/4 v10, 0
    sget-object v11, Lcom/bytedance/trae/im/service/CliType;->REMOTE Lcom/bytedance/trae/im/service/CliType;
    const/4 v12, 0
    const/4 v13, 0
    const/16 v14, 388
    const/4 v15, 0
    move-object v4, v2
    invoke-direct/range v4 ... v15, Lcom/bytedance/trae/conversation/devices/DeviceItem;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Z Z Lcom/bytedance/trae/im/service/CliType; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iget-boolean v4, v0, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel$fetchDevices$3;->$isCodeMode Z
    sget v5, Lcom/bytedance/trae/conversation/R$drawable;->ic_computer I
    invoke-static v1, v4, v5, Lcom/bytedance/trae/conversation/devices/DeviceListMapperKt;->toSelectableDeviceItems(Ljava/util/List; Z I)Ljava/util/List;
    move-result-object v4
    invoke-static v2, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v2
    check-cast v2, Ljava/util/Collection;
    check-cast v4, Ljava/lang/Iterable;
    invoke-static v2, v4, Lkotlin/collections/CollectionsKt;->plus(Ljava/util/Collection; Ljava/lang/Iterable;)Ljava/util/List;
    move-result-object v2
    sget-object v4, Lcom/bytedance/trae/conversation/devices/DeviceListSelectionPolicy;->INSTANCE Lcom/bytedance/trae/conversation/devices/DeviceListSelectionPolicy;
    iget-object v5, v0, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel$fetchDevices$3;->this$0 Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;
    invoke-static v5, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;->access$getSessionSelectedDeviceId$p(Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;)Ljava/lang/String;
    move-result-object v5
    iget-object v6, v0, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel$fetchDevices$3;->this$0 Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;->getPreselectedDeviceId()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v4, v2, v5, v6, Lcom/bytedance/trae/conversation/devices/DeviceListSelectionPolicy;->applySelection(Ljava/util/List; Ljava/lang/String; Ljava/lang/String;)Lcom/bytedance/trae/conversation/devices/DeviceListSelectionResult;
    move-result-object v2
    iget-object v4, v0, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel$fetchDevices$3;->this$0 Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/devices/DeviceListSelectionResult;->getSessionSelectedDeviceId()Ljava/lang/String;
    move-result-object v5
    invoke-static v4, v5, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;->access$setSessionSelectedDeviceId$p(Lcom/bytedance/trae/conversation/devices/DeviceListViewModel; Ljava/lang/String;)V
    invoke-virtual v2, Lcom/bytedance/trae/conversation/devices/DeviceListSelectionResult;->getDevices()Ljava/util/List;
    move-result-object v2
    iget-object v4, v0, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel$fetchDevices$3;->this$0 Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;
    invoke-static v4, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;->access$getDeviceListRevision$p(Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;)I
    move-result v5
    add-int/2addr v5, v3
    invoke-static v4, v5, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;->access$setDeviceListRevision$p(Lcom/bytedance/trae/conversation/devices/DeviceListViewModel; I)V
    iget-object v3, v0, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel$fetchDevices$3;->this$0 Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;
    invoke-static v3, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;->access$get_devices$p(Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;)Landroidx/lifecycle/MutableLiveData;
    move-result-object v3
    invoke-virtual v3, v2, Landroidx/lifecycle/MutableLiveData;->postValue(Ljava/lang/Object;)V
    iget-object v3, v0, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel$fetchDevices$3;->this$0 Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;
    invoke-static v3, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;->access$get_isLoading$p(Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;)Landroidx/lifecycle/MutableLiveData;
    move-result-object v3
    const/4 v4, 0
    invoke-static v4, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v4
    invoke-virtual v3, v4, Landroidx/lifecycle/MutableLiveData;->postValue(Ljava/lang/Object;)V
    iget-object v3, v0, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel$fetchDevices$3;->this$0 Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;
    iget-boolean v4, v0, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel$fetchDevices$3;->$isCodeMode Z
    invoke-interface v1, Ljava/util/List;->size()I
    move-result v1
    invoke-static v3, v4, v1, v2, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;->access$logFetchResult(Lcom/bytedance/trae/conversation/devices/DeviceListViewModel; Z I Ljava/util/List;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method
