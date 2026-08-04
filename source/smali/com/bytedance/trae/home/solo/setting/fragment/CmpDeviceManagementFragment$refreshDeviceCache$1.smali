# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/home/solo/setting/fragment/CmpDeviceManagementFragment$refreshDeviceCache$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "CmpDeviceManagementFragment.kt"

.implements Lkotlin/jvm/functions/Function2;

.field  label:I


.method public static synthetic $r8$lambda$HZ-lyDGIIuzsyewiAe5iVrKbFW4(java.util.List)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/home/solo/setting/fragment/CmpDeviceManagementFragment$refreshDeviceCache$1;->invokeSuspend$lambda$0(Ljava/util/List;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method constructor <init>(kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=2
    const/4 v0, 2
    invoke-direct v1, v0, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method private static final invokeSuspend$lambda$0(java.util.List)kotlin.Unit
    .registers 1
    # ins_size=1
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 3
    # ins_size=3
    new-instance v1, Lcom/bytedance/trae/home/solo/setting/fragment/CmpDeviceManagementFragment$refreshDeviceCache$1;
    invoke-direct v1, v2, Lcom/bytedance/trae/home/solo/setting/fragment/CmpDeviceManagementFragment$refreshDeviceCache$1;-><init>(Lkotlin/coroutines/Continuation;)V
    check-cast v1, Lkotlin/coroutines/Continuation;
    return-object v1
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/fragment/CmpDeviceManagementFragment$refreshDeviceCache$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/fragment/CmpDeviceManagementFragment$refreshDeviceCache$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/home/solo/setting/fragment/CmpDeviceManagementFragment$refreshDeviceCache$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/home/solo/setting/fragment/CmpDeviceManagementFragment$refreshDeviceCache$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 6
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v4, Lcom/bytedance/trae/home/solo/setting/fragment/CmpDeviceManagementFragment$refreshDeviceCache$1;->label I
    const/4 v2, 1
    if-eqz v1, +010h
    if-ne v1, v2, +006h
    invoke-static v5, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +23h
    new-instance v5, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v5, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v5
    invoke-static v5, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v5, Lcom/bytedance/trae/conversation/CliListRepository;->Companion Lcom/bytedance/trae/conversation/CliListRepository$Companion;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/CliListRepository$Companion;->getInstance()Lcom/bytedance/trae/conversation/CliListRepository;
    move-result-object v5
    new-instance v1, Lcom/bytedance/trae/home/solo/setting/fragment/CmpDeviceManagementFragment$refreshDeviceCache$1$$ExternalSyntheticLambda0;
    invoke-direct v1, Lcom/bytedance/trae/home/solo/setting/fragment/CmpDeviceManagementFragment$refreshDeviceCache$1$$ExternalSyntheticLambda0;-><init>()V
    move-object v3, v4
    check-cast v3, Lkotlin/coroutines/Continuation;
    iput v2, v4, Lcom/bytedance/trae/home/solo/setting/fragment/CmpDeviceManagementFragment$refreshDeviceCache$1;->label I
    invoke-virtual v5, v1, v3, Lcom/bytedance/trae/conversation/CliListRepository;->fetchClis(Lkotlin/jvm/functions/Function1; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v5
    if-ne v5, v0, +003h
    return-object v0
    sget-object v5, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v5
.end method
