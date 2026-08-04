# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$DeviceManagementScreen$5$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "SettingsContentScreens.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $latestCopySuccessMessage$delegate:Landroidx/compose/runtime/State;
.field final synthetic $onRefreshDeviceCache:Lkotlin/jvm/functions/Function0;
.field final synthetic $viewModel:Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel;
.field  label:I


.method constructor <init>(com.bytedance.trae.home.solo.setting.viewmodel.DeviceManagementViewModel  kotlin.jvm.functions.Function0  androidx.compose.runtime.State  kotlin.coroutines.Continuation)void
    .registers 5
    # ins_size=5
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$DeviceManagementScreen$5$1;->$viewModel Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$DeviceManagementScreen$5$1;->$onRefreshDeviceCache Lkotlin/jvm/functions/Function0;
    iput-object v3, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$DeviceManagementScreen$5$1;->$latestCopySuccessMessage$delegate Landroidx/compose/runtime/State;
    const/4 v1, 2
    invoke-direct v0, v1, v4, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 6
    # ins_size=3
    new-instance v4, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$DeviceManagementScreen$5$1;
    iget-object v0, v3, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$DeviceManagementScreen$5$1;->$viewModel Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel;
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$DeviceManagementScreen$5$1;->$onRefreshDeviceCache Lkotlin/jvm/functions/Function0;
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$DeviceManagementScreen$5$1;->$latestCopySuccessMessage$delegate Landroidx/compose/runtime/State;
    invoke-direct v4, v0, v1, v2, v5, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$DeviceManagementScreen$5$1;-><init>(Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel; Lkotlin/jvm/functions/Function0; Landroidx/compose/runtime/State; Lkotlin/coroutines/Continuation;)V
    check-cast v4, Lkotlin/coroutines/Continuation;
    return-object v4
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$DeviceManagementScreen$5$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$DeviceManagementScreen$5$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$DeviceManagementScreen$5$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$DeviceManagementScreen$5$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 7
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v5, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$DeviceManagementScreen$5$1;->label I
    const/4 v2, 1
    if-eqz v1, +010h
    if-eq v1, v2, +00ah
    new-instance v6, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v6, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v6
    invoke-static v6, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +21h
    invoke-static v6, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v6, v5, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$DeviceManagementScreen$5$1;->$viewModel Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel;
    invoke-virtual v6, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel;->getEffects()Lkotlinx/coroutines/flow/SharedFlow;
    move-result-object v6
    new-instance v1, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$DeviceManagementScreen$5$1$1;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$DeviceManagementScreen$5$1;->$onRefreshDeviceCache Lkotlin/jvm/functions/Function0;
    iget-object v4, v5, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$DeviceManagementScreen$5$1;->$latestCopySuccessMessage$delegate Landroidx/compose/runtime/State;
    invoke-direct v1, v3, v4, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$DeviceManagementScreen$5$1$1;-><init>(Lkotlin/jvm/functions/Function0; Landroidx/compose/runtime/State;)V
    check-cast v1, Lkotlinx/coroutines/flow/FlowCollector;
    move-object v3, v5
    check-cast v3, Lkotlin/coroutines/Continuation;
    iput v2, v5, Lcom/bytedance/trae/home/solo/setting/ui/SettingsContentScreensKt$DeviceManagementScreen$5$1;->label I
    invoke-interface v6, v1, v3, Lkotlinx/coroutines/flow/SharedFlow;->collect(Lkotlinx/coroutines/flow/FlowCollector; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v6
    if-ne v6, v0, +003h
    return-object v0
    new-instance v6, Lkotlin/KotlinNothingValueException;
    invoke-direct v6, Lkotlin/KotlinNothingValueException;-><init>()V
    throw v6
.end method
