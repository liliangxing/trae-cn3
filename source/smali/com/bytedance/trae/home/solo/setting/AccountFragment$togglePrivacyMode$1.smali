# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/home/solo/setting/AccountFragment$togglePrivacyMode$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "AccountFragment.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $open:Z
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/home/solo/setting/AccountFragment;


.method constructor <init>(boolean  com.bytedance.trae.home.solo.setting.AccountFragment  kotlin.coroutines.Continuation)void
    .registers 4
    # ins_size=4
    iput-boolean v1, v0, Lcom/bytedance/trae/home/solo/setting/AccountFragment$togglePrivacyMode$1;->$open Z
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/setting/AccountFragment$togglePrivacyMode$1;->this$0 Lcom/bytedance/trae/home/solo/setting/AccountFragment;
    const/4 v1, 2
    invoke-direct v0, v1, v3, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v3, Lcom/bytedance/trae/home/solo/setting/AccountFragment$togglePrivacyMode$1;
    iget-boolean v0, v2, Lcom/bytedance/trae/home/solo/setting/AccountFragment$togglePrivacyMode$1;->$open Z
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/AccountFragment$togglePrivacyMode$1;->this$0 Lcom/bytedance/trae/home/solo/setting/AccountFragment;
    invoke-direct v3, v0, v1, v4, Lcom/bytedance/trae/home/solo/setting/AccountFragment$togglePrivacyMode$1;-><init>(Z Lcom/bytedance/trae/home/solo/setting/AccountFragment; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/coroutines/Continuation;
    return-object v3
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/AccountFragment$togglePrivacyMode$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/AccountFragment$togglePrivacyMode$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/home/solo/setting/AccountFragment$togglePrivacyMode$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/home/solo/setting/AccountFragment$togglePrivacyMode$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 9
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v7, Lcom/bytedance/trae/home/solo/setting/AccountFragment$togglePrivacyMode$1;->label I
    const/4 v2, 0
    const-string/jumbo v3, switchPrivacyMode
    const/4 v4, 0
    const/4 v5, 1
    if-eqz v1, +013h
    if-ne v1, v5, +009h
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +1fh
    move-exception v8
    goto/16 +0b3h
    new-instance v8, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v8, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v8
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v8, Lcom/bytedance/trae/home/solo/setting/IPrivacyModeApi;->Companion Lcom/bytedance/trae/home/solo/setting/IPrivacyModeApi$Companion;
    iget-boolean v1, v7, Lcom/bytedance/trae/home/solo/setting/AccountFragment$togglePrivacyMode$1;->$open Z
    move-object v6, v7
    check-cast v6, Lkotlin/coroutines/Continuation;
    iput v5, v7, Lcom/bytedance/trae/home/solo/setting/AccountFragment$togglePrivacyMode$1;->label I
    invoke-virtual v8, v1, v6, Lcom/bytedance/trae/home/solo/setting/IPrivacyModeApi$Companion;->toggle(Z Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v8
    if-ne v8, v0, +003h
    return-object v0
    iget-object v8, v7, Lcom/bytedance/trae/home/solo/setting/AccountFragment$togglePrivacyMode$1;->this$0 Lcom/bytedance/trae/home/solo/setting/AccountFragment;
    invoke-static v8, v4, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->access$setSwitching$p(Lcom/bytedance/trae/home/solo/setting/AccountFragment; Z)V
    iget-object v8, v7, Lcom/bytedance/trae/home/solo/setting/AccountFragment$togglePrivacyMode$1;->this$0 Lcom/bytedance/trae/home/solo/setting/AccountFragment;
    invoke-static v8, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->access$isEnterpriseLogin(Lcom/bytedance/trae/home/solo/setting/AccountFragment;)Z
    move-result v8
    if-eqz v8, +01fh
    iget-object v8, v7, Lcom/bytedance/trae/home/solo/setting/AccountFragment$togglePrivacyMode$1;->this$0 Lcom/bytedance/trae/home/solo/setting/AccountFragment;
    invoke-static v8, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->access$getLoginService(Lcom/bytedance/trae/home/solo/setting/AccountFragment;)Lcom/bytedance/trae/login/api/ILoginService;
    move-result-object v0
    if-eqz v0, +012h
    invoke-interface v0, Lcom/bytedance/trae/login/api/ILoginService;->getAccountInfo()Lcom/bytedance/trae/login/api/AccountInfo;
    move-result-object v0
    if-eqz v0, +00ch
    invoke-virtual v0, Lcom/bytedance/trae/login/api/AccountInfo;->getSaasPrivacyMode()Ljava/lang/Boolean;
    move-result-object v0
    if-eqz v0, +006h
    invoke-virtual v0, Ljava/lang/Boolean;->booleanValue()Z
    move-result v5
    invoke-static v8, v5, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->access$applyEnterprisePrivacyMode(Lcom/bytedance/trae/home/solo/setting/AccountFragment; Z)V
    goto/16 +06bh
    iget-object v8, v7, Lcom/bytedance/trae/home/solo/setting/AccountFragment$togglePrivacyMode$1;->this$0 Lcom/bytedance/trae/home/solo/setting/AccountFragment;
    invoke-static v8, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->access$getSwitchPrivacyMode$p(Lcom/bytedance/trae/home/solo/setting/AccountFragment;)Landroidx/appcompat/widget/SwitchCompat;
    move-result-object v8
    if-nez v8, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v2, v8
    invoke-virtual v2, v5, Landroidx/appcompat/widget/SwitchCompat;->setEnabled(Z)V
    goto +59h
    iget-object v8, v7, Lcom/bytedance/trae/home/solo/setting/AccountFragment$togglePrivacyMode$1;->this$0 Lcom/bytedance/trae/home/solo/setting/AccountFragment;
    invoke-static v8, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->access$getSwitchPrivacyMode$p(Lcom/bytedance/trae/home/solo/setting/AccountFragment;)Landroidx/appcompat/widget/SwitchCompat;
    move-result-object v8
    if-nez v8, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v8, v2
    iget-boolean v0, v7, Lcom/bytedance/trae/home/solo/setting/AccountFragment$togglePrivacyMode$1;->$open Z
    if-nez v0, +004h
    move v0, v5
    goto +2h
    move v0, v4
    invoke-virtual v8, v0, Landroidx/appcompat/widget/SwitchCompat;->setChecked(Z)V
    iget-object v8, v7, Lcom/bytedance/trae/home/solo/setting/AccountFragment$togglePrivacyMode$1;->this$0 Lcom/bytedance/trae/home/solo/setting/AccountFragment;
    invoke-virtual v8, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->isAdded()Z
    move-result v8
    if-eqz v8, +011h
    iget-object v8, v7, Lcom/bytedance/trae/home/solo/setting/AccountFragment$togglePrivacyMode$1;->this$0 Lcom/bytedance/trae/home/solo/setting/AccountFragment;
    invoke-virtual v8, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->requireContext()Landroid/content/Context;
    move-result-object v8
    sget v0, Lcom/bytedance/trae/home/R$string;->trae_setting_privacy_mode_toggle_failed I
    invoke-static v8, v0, v4, Landroid/widget/Toast;->makeText(Landroid/content/Context; I I)Landroid/widget/Toast;
    move-result-object v8
    invoke-virtual v8, Landroid/widget/Toast;->show()V
    iget-object v8, v7, Lcom/bytedance/trae/home/solo/setting/AccountFragment$togglePrivacyMode$1;->this$0 Lcom/bytedance/trae/home/solo/setting/AccountFragment;
    invoke-static v8, v4, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->access$setSwitching$p(Lcom/bytedance/trae/home/solo/setting/AccountFragment; Z)V
    iget-object v8, v7, Lcom/bytedance/trae/home/solo/setting/AccountFragment$togglePrivacyMode$1;->this$0 Lcom/bytedance/trae/home/solo/setting/AccountFragment;
    invoke-static v8, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->access$isEnterpriseLogin(Lcom/bytedance/trae/home/solo/setting/AccountFragment;)Z
    move-result v8
    if-eqz v8, +017h
    iget-object v8, v7, Lcom/bytedance/trae/home/solo/setting/AccountFragment$togglePrivacyMode$1;->this$0 Lcom/bytedance/trae/home/solo/setting/AccountFragment;
    invoke-static v8, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->access$getLoginService(Lcom/bytedance/trae/home/solo/setting/AccountFragment;)Lcom/bytedance/trae/login/api/ILoginService;
    move-result-object v0
    if-eqz v0, -056h
    invoke-interface v0, Lcom/bytedance/trae/login/api/ILoginService;->getAccountInfo()Lcom/bytedance/trae/login/api/AccountInfo;
    move-result-object v0
    if-eqz v0, -05ch
    invoke-virtual v0, Lcom/bytedance/trae/login/api/AccountInfo;->getSaasPrivacyMode()Ljava/lang/Boolean;
    move-result-object v0
    if-eqz v0, -062h
    goto -68h
    iget-object v8, v7, Lcom/bytedance/trae/home/solo/setting/AccountFragment$togglePrivacyMode$1;->this$0 Lcom/bytedance/trae/home/solo/setting/AccountFragment;
    invoke-static v8, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->access$getSwitchPrivacyMode$p(Lcom/bytedance/trae/home/solo/setting/AccountFragment;)Landroidx/appcompat/widget/SwitchCompat;
    move-result-object v8
    if-nez v8, -05ah
    goto -60h
    sget-object v8, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v8
    iget-object v0, v7, Lcom/bytedance/trae/home/solo/setting/AccountFragment$togglePrivacyMode$1;->this$0 Lcom/bytedance/trae/home/solo/setting/AccountFragment;
    invoke-static v0, v4, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->access$setSwitching$p(Lcom/bytedance/trae/home/solo/setting/AccountFragment; Z)V
    iget-object v0, v7, Lcom/bytedance/trae/home/solo/setting/AccountFragment$togglePrivacyMode$1;->this$0 Lcom/bytedance/trae/home/solo/setting/AccountFragment;
    invoke-static v0, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->access$isEnterpriseLogin(Lcom/bytedance/trae/home/solo/setting/AccountFragment;)Z
    move-result v0
    if-eqz v0, +01eh
    iget-object v0, v7, Lcom/bytedance/trae/home/solo/setting/AccountFragment$togglePrivacyMode$1;->this$0 Lcom/bytedance/trae/home/solo/setting/AccountFragment;
    invoke-static v0, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->access$getLoginService(Lcom/bytedance/trae/home/solo/setting/AccountFragment;)Lcom/bytedance/trae/login/api/ILoginService;
    move-result-object v1
    if-eqz v1, +012h
    invoke-interface v1, Lcom/bytedance/trae/login/api/ILoginService;->getAccountInfo()Lcom/bytedance/trae/login/api/AccountInfo;
    move-result-object v1
    if-eqz v1, +00ch
    invoke-virtual v1, Lcom/bytedance/trae/login/api/AccountInfo;->getSaasPrivacyMode()Ljava/lang/Boolean;
    move-result-object v1
    if-eqz v1, +006h
    invoke-virtual v1, Ljava/lang/Boolean;->booleanValue()Z
    move-result v5
    invoke-static v0, v5, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->access$applyEnterprisePrivacyMode(Lcom/bytedance/trae/home/solo/setting/AccountFragment; Z)V
    goto +11h
    iget-object v0, v7, Lcom/bytedance/trae/home/solo/setting/AccountFragment$togglePrivacyMode$1;->this$0 Lcom/bytedance/trae/home/solo/setting/AccountFragment;
    invoke-static v0, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->access$getSwitchPrivacyMode$p(Lcom/bytedance/trae/home/solo/setting/AccountFragment;)Landroidx/appcompat/widget/SwitchCompat;
    move-result-object v0
    if-nez v0, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v2, v0
    invoke-virtual v2, v5, Landroidx/appcompat/widget/SwitchCompat;->setEnabled(Z)V
    throw v8
    :try_start_0x10
    :try_start_0x22
    :try_start_0x6d
.end method
