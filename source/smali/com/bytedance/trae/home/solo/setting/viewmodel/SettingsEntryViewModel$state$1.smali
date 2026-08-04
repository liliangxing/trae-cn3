# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel$state$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "SettingsEntryViewModel.kt"

.implements Lkotlin/jvm/functions/Function6;

.field synthetic I$0:I
.field synthetic L$0:Ljava/lang/Object;
.field synthetic L$1:Ljava/lang/Object;
.field synthetic L$2:Ljava/lang/Object;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel;


.method constructor <init>(com.bytedance.trae.home.solo.setting.viewmodel.SettingsEntryViewModel  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel$state$1;->this$0 Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel;
    const/4 v1, 6
    invoke-direct v0, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final invoke(com.bytedance.trae.home.solo.setting.platform.UserInfo  com.bytedance.trae.home.solo.setting.data.model.PayIdentity  int  com.bytedance.trae.home.solo.setting.data.SettingsCreditsState  int  kotlin.coroutines.Continuation)java.lang.Object
    .registers 8
    # ins_size=7
    new-instance v6, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel$state$1;
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel$state$1;->this$0 Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel;
    invoke-direct v6, v0, v7, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel$state$1;-><init>(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel; Lkotlin/coroutines/Continuation;)V
    iput-object v2, v6, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel$state$1;->L$0 Ljava/lang/Object;
    iput-object v3, v6, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel$state$1;->L$1 Ljava/lang/Object;
    iput v4, v6, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel$state$1;->I$0 I
    iput-object v5, v6, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel$state$1;->L$2 Ljava/lang/Object;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v6, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel$state$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object  java.lang.Object  java.lang.Object  java.lang.Object  java.lang.Object)java.lang.Object
    .registers 14
    # ins_size=7
    move-object v1, v8
    check-cast v1, Lcom/bytedance/trae/home/solo/setting/platform/UserInfo;
    move-object v2, v9
    check-cast v2, Lcom/bytedance/trae/home/solo/setting/data/model/PayIdentity;
    check-cast v10, Ljava/lang/Number;
    invoke-virtual v10, Ljava/lang/Number;->intValue()I
    move-result v3
    move-object v4, v11
    check-cast v4, Lcom/bytedance/trae/home/solo/setting/data/SettingsCreditsState;
    check-cast v12, Ljava/lang/Number;
    invoke-virtual v12, Ljava/lang/Number;->intValue()I
    move-result v5
    move-object v6, v13
    check-cast v6, Lkotlin/coroutines/Continuation;
    move-object v0, v7
    invoke-virtual/range v0 ... v6, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel$state$1;->invoke(Lcom/bytedance/trae/home/solo/setting/platform/UserInfo; Lcom/bytedance/trae/home/solo/setting/data/model/PayIdentity; I Lcom/bytedance/trae/home/solo/setting/data/SettingsCreditsState; I Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v8
    return-object v8
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 6
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    iget v0, v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel$state$1;->label I
    if-nez v0, +01ah
    invoke-static v5, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v5, v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel$state$1;->L$0 Ljava/lang/Object;
    check-cast v5, Lcom/bytedance/trae/home/solo/setting/platform/UserInfo;
    iget-object v0, v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel$state$1;->L$1 Ljava/lang/Object;
    check-cast v0, Lcom/bytedance/trae/home/solo/setting/data/model/PayIdentity;
    iget v1, v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel$state$1;->I$0 I
    iget-object v2, v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel$state$1;->L$2 Ljava/lang/Object;
    check-cast v2, Lcom/bytedance/trae/home/solo/setting/data/SettingsCreditsState;
    iget-object v3, v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel$state$1;->this$0 Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel;
    invoke-static v3, v5, v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel;->access$buildUiState(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel; Lcom/bytedance/trae/home/solo/setting/platform/UserInfo; Lcom/bytedance/trae/home/solo/setting/data/model/PayIdentity; I Lcom/bytedance/trae/home/solo/setting/data/SettingsCreditsState;)Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;
    move-result-object v5
    return-object v5
    new-instance v5, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v5, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v5
.end method
