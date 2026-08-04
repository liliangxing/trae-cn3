# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository$refresh$2;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "SettingsCreditsRepository.kt"

.implements Lkotlin/jvm/functions/Function2;

.field private synthetic L$0:Ljava/lang/Object;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository;


.method constructor <init>(com.bytedance.trae.home.solo.setting.data.DefaultSettingsCreditsRepository  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository$refresh$2;->this$0 Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository;
    const/4 v1, 2
    invoke-direct v0, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository$refresh$2;
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository$refresh$2;->this$0 Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository;
    invoke-direct v0, v1, v4, Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository$refresh$2;-><init>(Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository; Lkotlin/coroutines/Continuation;)V
    iput-object v3, v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository$refresh$2;->L$0 Ljava/lang/Object;
    check-cast v0, Lkotlin/coroutines/Continuation;
    return-object v0
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository$refresh$2;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository$refresh$2;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository$refresh$2;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository$refresh$2;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 8
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v6, Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository$refresh$2;->label I
    const/4 v2, 1
    const/4 v3, 0
    if-eqz v1, +018h
    if-ne v1, v2, +00eh
    iget-object v0, v6, Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository$refresh$2;->L$0 Ljava/lang/Object;
    check-cast v0, Ljava/lang/String;
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +06fh
    move-exception v7
    goto/16 +077h
    new-instance v7, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v7, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v7
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v7, v6, Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository$refresh$2;->L$0 Ljava/lang/Object;
    check-cast v7, Lkotlinx/coroutines/CoroutineScope;
    iget-object v7, v6, Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository$refresh$2;->this$0 Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository;
    invoke-static v7, Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository;->access$currentEligibleUserId(Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository;)Ljava/lang/String;
    move-result-object v7
    if-nez v7, +015h
    iget-object v7, v6, Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository$refresh$2;->this$0 Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository;
    invoke-static v7, v3, Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository;->access$setOwnedCreditsBalance$p(Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository; Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository$OwnedCreditsBalance;)V
    iget-object v7, v6, Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository$refresh$2;->this$0 Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository;
    invoke-static v7, Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository;->access$get_creditsState$p(Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v7
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/data/SettingsCreditsState$Hidden;->INSTANCE Lcom/bytedance/trae/home/solo/setting/data/SettingsCreditsState$Hidden;
    invoke-interface v7, v0, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    sget-object v7, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v7
    iget-object v1, v6, Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository$refresh$2;->this$0 Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository;
    invoke-static v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository;->access$getOwnedCreditsBalance$p(Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository;)Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository$OwnedCreditsBalance;
    move-result-object v1
    if-eqz v1, +01eh
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository$OwnedCreditsBalance;->getUserId()Ljava/lang/String;
    move-result-object v4
    invoke-static v4, v7, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +003h
    goto +2h
    move-object v1, v3
    if-eqz v1, +010h
    iget-object v4, v6, Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository$refresh$2;->this$0 Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository;
    invoke-static v4, Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository;->access$get_creditsState$p(Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v4
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository$OwnedCreditsBalance;->getPresentation()Lcom/bytedance/trae/home/solo/setting/data/SettingsCreditsState$Visible;
    move-result-object v1
    invoke-interface v4, v1, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    goto +ch
    iget-object v1, v6, Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository$refresh$2;->this$0 Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository;
    invoke-static v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository;->access$get_creditsState$p(Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v1
    sget-object v4, Lcom/bytedance/trae/home/solo/setting/data/SettingsCreditsState$Loading;->INSTANCE Lcom/bytedance/trae/home/solo/setting/data/SettingsCreditsState$Loading;
    invoke-interface v1, v4, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    iget-object v1, v6, Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository$refresh$2;->this$0 Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository;
    sget-object v4, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    iput-object v7, v6, Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository$refresh$2;->L$0 Ljava/lang/Object;
    iput v2, v6, Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository$refresh$2;->label I
    invoke-static v1, v6, Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository;->access$fetchCreditsUsage(Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    if-ne v1, v0, +003h
    return-object v0
    move-object v0, v7
    move-object v7, v1
    check-cast v7, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;
    invoke-static v7, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v7
    goto +fh
    move-exception v0
    move-object v5, v0
    move-object v0, v7
    move-object v7, v5
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v7, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v7
    invoke-static v7, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v7
    invoke-static v7, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +003h
    move-object v7, v3
    check-cast v7, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;
    iget-object v1, v6, Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository$refresh$2;->this$0 Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository;
    invoke-static v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository;->access$currentEligibleUserId(Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository;)Ljava/lang/String;
    move-result-object v1
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +005h
    sget-object v7, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v7
    if-eqz v7, +00dh
    iget-object v1, v6, Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository$refresh$2;->this$0 Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository;
    invoke-static v1, v7, Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository;->access$toBalancePresentation(Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository; Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;)Lcom/bytedance/trae/home/solo/setting/data/SettingsCreditsState$Visible;
    move-result-object v7
    if-eqz v7, +005h
    check-cast v7, Lcom/bytedance/trae/home/solo/setting/data/SettingsCreditsState;
    goto +21h
    iget-object v7, v6, Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository$refresh$2;->this$0 Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository;
    invoke-static v7, Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository;->access$getOwnedCreditsBalance$p(Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository;)Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository$OwnedCreditsBalance;
    move-result-object v7
    if-eqz v7, +016h
    invoke-virtual v7, Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository$OwnedCreditsBalance;->getUserId()Ljava/lang/String;
    move-result-object v1
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +003h
    move-object v3, v7
    if-eqz v3, +009h
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository$OwnedCreditsBalance;->getPresentation()Lcom/bytedance/trae/home/solo/setting/data/SettingsCreditsState$Visible;
    move-result-object v7
    check-cast v7, Lcom/bytedance/trae/home/solo/setting/data/SettingsCreditsState;
    goto +5h
    sget-object v7, Lcom/bytedance/trae/home/solo/setting/data/SettingsCreditsState$Loading;->INSTANCE Lcom/bytedance/trae/home/solo/setting/data/SettingsCreditsState$Loading;
    check-cast v7, Lcom/bytedance/trae/home/solo/setting/data/SettingsCreditsState;
    instance-of v1, v7, Lcom/bytedance/trae/home/solo/setting/data/SettingsCreditsState$Visible;
    if-eqz v1, +00fh
    iget-object v1, v6, Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository$refresh$2;->this$0 Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository;
    new-instance v2, Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository$OwnedCreditsBalance;
    move-object v3, v7
    check-cast v3, Lcom/bytedance/trae/home/solo/setting/data/SettingsCreditsState$Visible;
    invoke-direct v2, v0, v3, Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository$OwnedCreditsBalance;-><init>(Ljava/lang/String; Lcom/bytedance/trae/home/solo/setting/data/SettingsCreditsState$Visible;)V
    invoke-static v1, v2, Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository;->access$setOwnedCreditsBalance$p(Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository; Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository$OwnedCreditsBalance;)V
    iget-object v0, v6, Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository$refresh$2;->this$0 Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository;
    invoke-static v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository;->access$get_creditsState$p(Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v0
    invoke-interface v0, v7, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    sget-object v7, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v7
    :try_start_0x10
    :try_start_0x73
    :try_start_0x82
.end method
