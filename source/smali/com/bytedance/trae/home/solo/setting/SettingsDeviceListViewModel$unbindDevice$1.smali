# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$unbindDevice$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "SettingsDeviceListViewModel.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $cliId:Ljava/lang/String;
.field final synthetic $requestId:J
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;


.method constructor <init>(com.bytedance.trae.home.solo.setting.SettingsDeviceListViewModel  java.lang.String  long  kotlin.coroutines.Continuation)void
    .registers 6
    # ins_size=6
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$unbindDevice$1;->this$0 Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$unbindDevice$1;->$cliId Ljava/lang/String;
    iput-wide v3, v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$unbindDevice$1;->$requestId J
    const/4 v1, 2
    invoke-direct v0, v1, v5, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 9
    # ins_size=3
    new-instance v7, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$unbindDevice$1;
    iget-object v1, v6, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$unbindDevice$1;->this$0 Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;
    iget-object v2, v6, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$unbindDevice$1;->$cliId Ljava/lang/String;
    iget-wide v3, v6, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$unbindDevice$1;->$requestId J
    move-object v0, v7
    move-object v5, v8
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$unbindDevice$1;-><init>(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel; Ljava/lang/String; J Lkotlin/coroutines/Continuation;)V
    check-cast v7, Lkotlin/coroutines/Continuation;
    return-object v7
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$unbindDevice$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$unbindDevice$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$unbindDevice$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$unbindDevice$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 8
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v6, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$unbindDevice$1;->label I
    const/4 v2, 2
    const/4 v3, 1
    if-eqz v1, +016h
    if-eq v1, v3, +010h
    if-ne v1, v2, +006h
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +3ah
    new-instance v7, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v7, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v7
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +18h
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v7, v6, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$unbindDevice$1;->this$0 Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;
    invoke-static v7, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->access$getRepository$p(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;)Lcom/bytedance/trae/home/solo/setting/SettingsDeviceRepository;
    move-result-object v7
    iget-object v1, v6, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$unbindDevice$1;->$cliId Ljava/lang/String;
    move-object v4, v6
    check-cast v4, Lkotlin/coroutines/Continuation;
    iput v3, v6, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$unbindDevice$1;->label I
    invoke-interface v7, v1, v4, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceRepository;->unregisterCli(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v7
    if-ne v7, v0, +003h
    return-object v0
    check-cast v7, Ljava/lang/Boolean;
    invoke-virtual v7, Ljava/lang/Boolean;->booleanValue()Z
    move-result v7
    if-eqz v7, +013h
    iget-object v7, v6, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$unbindDevice$1;->this$0 Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;
    move-object v1, v6
    check-cast v1, Lkotlin/coroutines/Continuation;
    iput v2, v6, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$unbindDevice$1;->label I
    invoke-static v7, v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->access$refreshDevicesAfterMutation(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v7
    if-ne v7, v0, +003h
    return-object v0
    sget-object v7, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v7
    iget-object v7, v6, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$unbindDevice$1;->this$0 Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;
    invoke-static v7, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->access$getPendingUnbinds$p(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;)Ljava/util/Map;
    move-result-object v7
    iget-object v0, v6, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$unbindDevice$1;->$cliId Ljava/lang/String;
    invoke-interface v7, v0, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$PendingUnbind;
    const/4 v0, 0
    if-eqz v7, +00dh
    invoke-virtual v7, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$PendingUnbind;->getRequestId()J
    move-result-wide v1
    iget-wide v4, v6, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$unbindDevice$1;->$requestId J
    cmp-long v1, v1, v4
    if-nez v1, +003h
    move v0, v3
    if-eqz v0, +030h
    iget-object v0, v6, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$unbindDevice$1;->this$0 Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;
    invoke-static v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->access$getPendingUnbinds$p(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;)Ljava/util/Map;
    move-result-object v0
    iget-object v1, v6, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$unbindDevice$1;->$cliId Ljava/lang/String;
    invoke-interface v0, v1, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    iget-object v0, v6, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$unbindDevice$1;->this$0 Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;
    iget-object v1, v6, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$unbindDevice$1;->$cliId Ljava/lang/String;
    invoke-static v0, v1, v7, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->access$restorePairing(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel; Ljava/lang/String; Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$PendingUnbind;)V
    iget-object v7, v6, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$unbindDevice$1;->this$0 Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;
    invoke-static v7, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->access$getPreviousPairedDeviceIds$p(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;)Ljava/util/Set;
    move-result-object v0
    iget-object v1, v6, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$unbindDevice$1;->$cliId Ljava/lang/String;
    invoke-static v0, v1, Lkotlin/collections/SetsKt;->plus(Ljava/util/Set; Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    invoke-static v7, v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->access$setPreviousPairedDeviceIds$p(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel; Ljava/util/Set;)V
    iget-object v7, v6, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$unbindDevice$1;->this$0 Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;
    invoke-static v7, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->access$get_unbindFailed$p(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;)Landroidx/lifecycle/MutableLiveData;
    move-result-object v7
    invoke-static v3, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v0
    invoke-virtual v7, v0, Landroidx/lifecycle/MutableLiveData;->postValue(Ljava/lang/Object;)V
    sget-object v7, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v7
.end method
