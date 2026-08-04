# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$state$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "DeviceManagementViewModel.kt"

.implements Lkotlin/jvm/functions/Function3;

.field synthetic L$0:Ljava/lang/Object;
.field synthetic L$1:Ljava/lang/Object;
.field  label:I


.method constructor <init>(kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=2
    const/4 v0, 3
    invoke-direct v1, v0, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final invoke(com.bytedance.trae.home.solo.setting.viewmodel.DeviceManagementUiState  java.util.List  kotlin.coroutines.Continuation)java.lang.Object
    .registers 5
    # ins_size=4
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$state$1;
    invoke-direct v0, v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$state$1;-><init>(Lkotlin/coroutines/Continuation;)V
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$state$1;->L$0 Ljava/lang/Object;
    iput-object v3, v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$state$1;->L$1 Ljava/lang/Object;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v0, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$state$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object  java.lang.Object)java.lang.Object
    .registers 4
    # ins_size=4
    check-cast v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;
    check-cast v2, Ljava/util/List;
    check-cast v3, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$state$1;->invoke(Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState; Ljava/util/List; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 12
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    iget v0, v10, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$state$1;->label I
    if-nez v0, +01dh
    invoke-static v11, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v11, v10, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$state$1;->L$0 Ljava/lang/Object;
    move-object v0, v11
    check-cast v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;
    iget-object v11, v10, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$state$1;->L$1 Ljava/lang/Object;
    move-object v3, v11
    check-cast v3, Ljava/util/List;
    const/4 v1, 0
    const/4 v2, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/16 v8, 123
    const/4 v9, 0
    invoke-static/range v0 ... v9, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;->copy$default(Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState; Z Z Ljava/util/List; Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementProduct; Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementMenuState; Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementRenameState; Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementDeleteState; I Ljava/lang/Object;)Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;
    move-result-object v11
    return-object v11
    new-instance v11, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v11, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v11
.end method
