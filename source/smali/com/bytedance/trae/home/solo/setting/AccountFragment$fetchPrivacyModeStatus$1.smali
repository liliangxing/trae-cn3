# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/home/solo/setting/AccountFragment$fetchPrivacyModeStatus$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "AccountFragment.kt"

.implements Lkotlin/jvm/functions/Function2;

.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/home/solo/setting/AccountFragment;


.method constructor <init>(com.bytedance.trae.home.solo.setting.AccountFragment  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/AccountFragment$fetchPrivacyModeStatus$1;->this$0 Lcom/bytedance/trae/home/solo/setting/AccountFragment;
    const/4 v1, 2
    invoke-direct v0, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 4
    # ins_size=3
    new-instance v2, Lcom/bytedance/trae/home/solo/setting/AccountFragment$fetchPrivacyModeStatus$1;
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/AccountFragment$fetchPrivacyModeStatus$1;->this$0 Lcom/bytedance/trae/home/solo/setting/AccountFragment;
    invoke-direct v2, v0, v3, Lcom/bytedance/trae/home/solo/setting/AccountFragment$fetchPrivacyModeStatus$1;-><init>(Lcom/bytedance/trae/home/solo/setting/AccountFragment; Lkotlin/coroutines/Continuation;)V
    check-cast v2, Lkotlin/coroutines/Continuation;
    return-object v2
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/AccountFragment$fetchPrivacyModeStatus$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/AccountFragment$fetchPrivacyModeStatus$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/home/solo/setting/AccountFragment$fetchPrivacyModeStatus$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/home/solo/setting/AccountFragment$fetchPrivacyModeStatus$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 6
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v4, Lcom/bytedance/trae/home/solo/setting/AccountFragment$fetchPrivacyModeStatus$1;->label I
    const/4 v2, 0
    const/4 v3, 1
    if-eqz v1, +012h
    if-ne v1, v3, +008h
    invoke-static v5, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +21h
    move-exception v5
    goto +58h
    new-instance v5, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v5, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v5
    invoke-static v5, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v5, v4, Lcom/bytedance/trae/home/solo/setting/AccountFragment$fetchPrivacyModeStatus$1;->this$0 Lcom/bytedance/trae/home/solo/setting/AccountFragment;
    invoke-static v5, v3, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->access$setSwitching$p(Lcom/bytedance/trae/home/solo/setting/AccountFragment; Z)V
    sget-object v5, Lcom/bytedance/trae/home/solo/setting/IPrivacyModeApi;->Companion Lcom/bytedance/trae/home/solo/setting/IPrivacyModeApi$Companion;
    move-object v1, v4
    check-cast v1, Lkotlin/coroutines/Continuation;
    iput v3, v4, Lcom/bytedance/trae/home/solo/setting/AccountFragment$fetchPrivacyModeStatus$1;->label I
    invoke-virtual v5, v1, Lcom/bytedance/trae/home/solo/setting/IPrivacyModeApi$Companion;->query(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v5
    if-ne v5, v0, +003h
    return-object v0
    check-cast v5, Lcom/bytedance/trae/home/solo/setting/PrivacyModeQueryResponse;
    iget-object v0, v4, Lcom/bytedance/trae/home/solo/setting/AccountFragment$fetchPrivacyModeStatus$1;->this$0 Lcom/bytedance/trae/home/solo/setting/AccountFragment;
    invoke-static v0, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->access$isEnterpriseLogin(Lcom/bytedance/trae/home/solo/setting/AccountFragment;)Z
    move-result v0
    if-nez v0, +01eh
    iget-object v0, v4, Lcom/bytedance/trae/home/solo/setting/AccountFragment$fetchPrivacyModeStatus$1;->this$0 Lcom/bytedance/trae/home/solo/setting/AccountFragment;
    invoke-static v0, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->access$getSwitchPrivacyMode$p(Lcom/bytedance/trae/home/solo/setting/AccountFragment;)Landroidx/appcompat/widget/SwitchCompat;
    move-result-object v0
    if-nez v0, +009h
    const-string/jumbo v0, switchPrivacyMode
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    invoke-virtual v5, Lcom/bytedance/trae/home/solo/setting/PrivacyModeQueryResponse;->getPrivacyStatus()Ljava/lang/String;
    move-result-object v5
    const-string v1, "open"
    invoke-static v5, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    invoke-virtual v0, v5, Landroidx/appcompat/widget/SwitchCompat;->setChecked(Z)V
    iget-object v5, v4, Lcom/bytedance/trae/home/solo/setting/AccountFragment$fetchPrivacyModeStatus$1;->this$0 Lcom/bytedance/trae/home/solo/setting/AccountFragment;
    invoke-static v5, v2, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->access$setSwitching$p(Lcom/bytedance/trae/home/solo/setting/AccountFragment; Z)V
    iget-object v5, v4, Lcom/bytedance/trae/home/solo/setting/AccountFragment$fetchPrivacyModeStatus$1;->this$0 Lcom/bytedance/trae/home/solo/setting/AccountFragment;
    invoke-static v5, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->access$isEnterpriseLogin(Lcom/bytedance/trae/home/solo/setting/AccountFragment;)Z
    move-result v5
    if-nez v5, +029h
    iget-object v5, v4, Lcom/bytedance/trae/home/solo/setting/AccountFragment$fetchPrivacyModeStatus$1;->this$0 Lcom/bytedance/trae/home/solo/setting/AccountFragment;
    invoke-static v5, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->access$applyEditablePrivacyMode(Lcom/bytedance/trae/home/solo/setting/AccountFragment;)V
    goto +22h
    iget-object v0, v4, Lcom/bytedance/trae/home/solo/setting/AccountFragment$fetchPrivacyModeStatus$1;->this$0 Lcom/bytedance/trae/home/solo/setting/AccountFragment;
    invoke-static v0, v2, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->access$setSwitching$p(Lcom/bytedance/trae/home/solo/setting/AccountFragment; Z)V
    iget-object v0, v4, Lcom/bytedance/trae/home/solo/setting/AccountFragment$fetchPrivacyModeStatus$1;->this$0 Lcom/bytedance/trae/home/solo/setting/AccountFragment;
    invoke-static v0, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->access$isEnterpriseLogin(Lcom/bytedance/trae/home/solo/setting/AccountFragment;)Z
    move-result v0
    if-nez v0, +007h
    iget-object v0, v4, Lcom/bytedance/trae/home/solo/setting/AccountFragment$fetchPrivacyModeStatus$1;->this$0 Lcom/bytedance/trae/home/solo/setting/AccountFragment;
    invoke-static v0, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->access$applyEditablePrivacyMode(Lcom/bytedance/trae/home/solo/setting/AccountFragment;)V
    throw v5
    iget-object v5, v4, Lcom/bytedance/trae/home/solo/setting/AccountFragment$fetchPrivacyModeStatus$1;->this$0 Lcom/bytedance/trae/home/solo/setting/AccountFragment;
    invoke-static v5, v2, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->access$setSwitching$p(Lcom/bytedance/trae/home/solo/setting/AccountFragment; Z)V
    iget-object v5, v4, Lcom/bytedance/trae/home/solo/setting/AccountFragment$fetchPrivacyModeStatus$1;->this$0 Lcom/bytedance/trae/home/solo/setting/AccountFragment;
    invoke-static v5, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->access$isEnterpriseLogin(Lcom/bytedance/trae/home/solo/setting/AccountFragment;)Z
    move-result v5
    if-nez v5, +003h
    goto -26h
    sget-object v5, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v5
    :try_start_0xc
    :try_start_0x22
.end method
