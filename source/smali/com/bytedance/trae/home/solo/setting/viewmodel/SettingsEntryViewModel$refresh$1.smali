# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel$refresh$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "SettingsEntryViewModel.kt"

.implements Lkotlin/jvm/functions/Function2;

.field private synthetic L$0:Ljava/lang/Object;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel;


.method constructor <init>(com.bytedance.trae.home.solo.setting.viewmodel.SettingsEntryViewModel  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel$refresh$1;->this$0 Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel;
    const/4 v1, 2
    invoke-direct v0, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel$refresh$1;
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel$refresh$1;->this$0 Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel;
    invoke-direct v0, v1, v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel$refresh$1;-><init>(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel; Lkotlin/coroutines/Continuation;)V
    iput-object v3, v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel$refresh$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lkotlin/coroutines/Continuation;
    return-object v0
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel$refresh$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel$refresh$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel$refresh$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel$refresh$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 9
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    iget v0, v7, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel$refresh$1;->label I
    if-nez v0, +03bh
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v8, v7, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel$refresh$1;->L$0 Ljava/lang/Object;
    check-cast v8, Lkotlinx/coroutines/CoroutineScope;
    const/4 v1, 0
    const/4 v2, 0
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel$refresh$1$1;
    iget-object v3, v7, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel$refresh$1;->this$0 Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel;
    const/4 v6, 0
    invoke-direct v0, v3, v6, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel$refresh$1$1;-><init>(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel; Lkotlin/coroutines/Continuation;)V
    move-object v3, v0
    check-cast v3, Lkotlin/jvm/functions/Function2;
    const/4 v4, 3
    const/4 v5, 0
    move-object v0, v8
    invoke-static/range v0 ... v5, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel$refresh$1$2;
    iget-object v3, v7, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel$refresh$1;->this$0 Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel;
    invoke-direct v0, v3, v6, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel$refresh$1$2;-><init>(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel; Lkotlin/coroutines/Continuation;)V
    move-object v3, v0
    check-cast v3, Lkotlin/jvm/functions/Function2;
    move-object v0, v8
    invoke-static/range v0 ... v5, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel$refresh$1$3;
    iget-object v3, v7, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel$refresh$1;->this$0 Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel;
    invoke-direct v0, v3, v6, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel$refresh$1$3;-><init>(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel; Lkotlin/coroutines/Continuation;)V
    move-object v3, v0
    check-cast v3, Lkotlin/jvm/functions/Function2;
    move-object v0, v8
    invoke-static/range v0 ... v5, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    sget-object v8, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v8
    new-instance v8, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v8, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v8
.end method
