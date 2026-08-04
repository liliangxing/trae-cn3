# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$fetchUserPayStatus$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "SettingsViewModel.kt"

.implements Lkotlin/jvm/functions/Function2;

.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;


.method constructor <init>(com.bytedance.trae.home.solo.setting.SettingsViewModel  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$fetchUserPayStatus$1;->this$0 Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;
    const/4 v1, 2
    invoke-direct v0, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 4
    # ins_size=3
    new-instance v2, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$fetchUserPayStatus$1;
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$fetchUserPayStatus$1;->this$0 Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;
    invoke-direct v2, v0, v3, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$fetchUserPayStatus$1;-><init>(Lcom/bytedance/trae/home/solo/setting/SettingsViewModel; Lkotlin/coroutines/Continuation;)V
    check-cast v2, Lkotlin/coroutines/Continuation;
    return-object v2
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$fetchUserPayStatus$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$fetchUserPayStatus$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$fetchUserPayStatus$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$fetchUserPayStatus$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 8
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v6, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$fetchUserPayStatus$1;->label I
    const/4 v2, 0
    const/4 v3, 3
    const/4 v4, 2
    const/4 v5, 1
    if-eqz v1, +020h
    if-eq v1, v5, +017h
    if-eq v1, v4, +011h
    if-ne v1, v3, +007h
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +079h
    new-instance v7, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v7, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v7
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +4dh
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +1dh
    move-exception v7
    goto/16 +07ch
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v7, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v7, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isOversea()Z
    move-result v7
    if-eqz v7, +026h
    sget-object v7, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->INSTANCE Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;
    move-object v1, v6
    check-cast v1, Lkotlin/coroutines/Continuation;
    iput v5, v6, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$fetchUserPayStatus$1;->label I
    invoke-virtual v7, v1, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->fetchAndCache(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v7
    if-ne v7, v0, +003h
    return-object v0
    instance-of v0, v7, Lcom/bytedance/trae/home/solo/setting/UserPayStatusData;
    if-eqz v0, +005h
    move-object v2, v7
    check-cast v2, Lcom/bytedance/trae/home/solo/setting/UserPayStatusData;
    if-nez v2, +005h
    sget-object v7, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v7
    iget-object v7, v6, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$fetchUserPayStatus$1;->this$0 Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;
    invoke-static v7, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->access$get_userPayStatus$p(Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;)Landroidx/lifecycle/MutableLiveData;
    move-result-object v7
    invoke-virtual v7, v2, Landroidx/lifecycle/MutableLiveData;->postValue(Ljava/lang/Object;)V
    goto +66h
    sget-object v7, Lcom/bytedance/trae/conversation/TocCreditsPolicy;->INSTANCE Lcom/bytedance/trae/conversation/TocCreditsPolicy;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/TocCreditsPolicy;->isEnabled()Z
    move-result v7
    if-eqz v7, +021h
    sget-object v7, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->INSTANCE Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;
    move-object v1, v6
    check-cast v1, Lkotlin/coroutines/Continuation;
    iput v4, v6, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$fetchUserPayStatus$1;->label I
    invoke-virtual v7, v1, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->fetchFreshCNPayStatus(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v7
    if-ne v7, v0, +003h
    return-object v0
    check-cast v7, Lcom/bytedance/trae/home/solo/setting/CNUserPayStatusData;
    if-nez v7, +005h
    sget-object v7, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v7
    iget-object v0, v6, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$fetchUserPayStatus$1;->this$0 Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;
    invoke-static v0, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->access$get_userCNPayStatus$p(Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;)Landroidx/lifecycle/MutableLiveData;
    move-result-object v0
    invoke-virtual v0, v7, Landroidx/lifecycle/MutableLiveData;->postValue(Ljava/lang/Object;)V
    goto +3fh
    sget-object v7, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->INSTANCE Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;
    move-object v1, v6
    check-cast v1, Lkotlin/coroutines/Continuation;
    iput v3, v6, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$fetchUserPayStatus$1;->label I
    invoke-virtual v7, v1, Lcom/bytedance/trae/home/solo/setting/UserPayIdentityCache;->fetchAndCache(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v7
    if-ne v7, v0, +003h
    return-object v0
    instance-of v0, v7, Lcom/bytedance/trae/home/solo/setting/CNUserPayStatusData;
    if-eqz v0, +005h
    move-object v2, v7
    check-cast v2, Lcom/bytedance/trae/home/solo/setting/CNUserPayStatusData;
    if-nez v2, +005h
    sget-object v7, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v7
    iget-object v7, v6, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel$fetchUserPayStatus$1;->this$0 Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;
    invoke-static v7, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->access$get_userCNPayStatus$p(Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;)Landroidx/lifecycle/MutableLiveData;
    move-result-object v7
    invoke-virtual v7, v2, Landroidx/lifecycle/MutableLiveData;->postValue(Ljava/lang/Object;)V
    goto +1bh
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "fetchUserPayStatus failed: "
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v7, Ljava/lang/Exception;->getMessage()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v1, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    const-string v1, "SettingsViewModel"
    invoke-virtual v0, v1, v7, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v7, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v7
    :try_start_0x12
    :try_start_0x1f
    :try_start_0x2d
.end method
