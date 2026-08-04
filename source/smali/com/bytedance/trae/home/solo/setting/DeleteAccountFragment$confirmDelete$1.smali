# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$confirmDelete$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "DeleteAccountFragment.kt"

.implements Lkotlin/jvm/functions/Function2;

.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;


.method constructor <init>(com.bytedance.trae.home.solo.setting.DeleteAccountFragment  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$confirmDelete$1;->this$0 Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;
    const/4 v1, 2
    invoke-direct v0, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 4
    # ins_size=3
    new-instance v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$confirmDelete$1;
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$confirmDelete$1;->this$0 Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;
    invoke-direct v2, v0, v3, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$confirmDelete$1;-><init>(Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment; Lkotlin/coroutines/Continuation;)V
    check-cast v2, Lkotlin/coroutines/Continuation;
    return-object v2
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$confirmDelete$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$confirmDelete$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$confirmDelete$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$confirmDelete$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 14
    # ins_size=2
    const-string v0, "deleteUserData failed: "
    const-string v1, "confirmDelete failed: "
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v2
    iget v3, v12, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$confirmDelete$1;->label I
    const-string v4, "getString(...)"
    const-string v5, "DeleteAccountFragment"
    const/4 v6, 2
    const/4 v7, 1
    const/4 v8, 0
    if-eqz v3, +01fh
    if-eq v3, v7, +013h
    if-ne v3, v6, +009h
    invoke-static v13, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +082h
    move-exception v13
    goto +69h
    new-instance v13, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v13, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v13
    invoke-static v13, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +2ah
    move-exception v13
    goto/16 +0abh
    move-exception v13
    goto/16 +080h
    invoke-static v13, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v13, Lcom/bytedance/trae/home/solo/setting/IAccountCancelApi;->Companion Lcom/bytedance/trae/home/solo/setting/IAccountCancelApi$Companion;
    iget-object v3, v12, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$confirmDelete$1;->this$0 Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;
    invoke-static v3, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->access$getValueTicket$p(Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;)Ljava/lang/String;
    move-result-object v3
    iget-object v9, v12, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$confirmDelete$1;->this$0 Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;
    invoke-static v9, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->access$getVerifyToken$p(Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;)Ljava/lang/String;
    move-result-object v9
    iget-object v10, v12, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$confirmDelete$1;->this$0 Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;
    invoke-static v10, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->access$getCancelTicket$p(Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;)Ljava/lang/String;
    move-result-object v10
    move-object v11, v12
    check-cast v11, Lkotlin/coroutines/Continuation;
    iput v7, v12, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$confirmDelete$1;->label I
    invoke-virtual v13, v3, v9, v10, v11, Lcom/bytedance/trae/home/solo/setting/IAccountCancelApi$Companion;->confirm(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v13
    if-ne v13, v2, +003h
    return-object v2
    check-cast v13, Lcom/bytedance/trae/home/solo/setting/CancelConfirmResponse;
    invoke-virtual v13, Lcom/bytedance/trae/home/solo/setting/CancelConfirmResponse;->getErrorCode()I
    move-result v3
    if-eqz v3, +01fh
    iget-object v0, v12, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$confirmDelete$1;->this$0 Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;
    invoke-virtual v13, Lcom/bytedance/trae/home/solo/setting/CancelConfirmResponse;->getDescription()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +013h
    invoke-virtual v13, Lcom/bytedance/trae/home/solo/setting/CancelConfirmResponse;->getMessage()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +00dh
    iget-object v13, v12, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$confirmDelete$1;->this$0 Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;
    sget v2, Lcom/bytedance/trae/home/R$string;->trae_delete_failed I
    invoke-virtual v13, v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->getString(I)Ljava/lang/String;
    move-result-object v2
    invoke-static v2, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v0, v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->access$showToast(Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment; Ljava/lang/String;)V
    goto +31h
    sget-object v13, Lcom/bytedance/trae/home/solo/setting/IAccountCancelApi;->Companion Lcom/bytedance/trae/home/solo/setting/IAccountCancelApi$Companion;
    move-object v3, v12
    check-cast v3, Lkotlin/coroutines/Continuation;
    iput v6, v12, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$confirmDelete$1;->label I
    invoke-virtual v13, v3, Lcom/bytedance/trae/home/solo/setting/IAccountCancelApi$Companion;->deleteUserData(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v13
    if-ne v13, v2, +019h
    return-object v2
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-direct v3, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v13, Ljava/lang/Exception;->getMessage()Ljava/lang/String;
    move-result-object v13
    invoke-virtual v3, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v13
    invoke-virtual v13, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v13
    invoke-virtual v2, v5, v13, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v13, v12, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$confirmDelete$1;->this$0 Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$Step;->SUBMITTED Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$Step;
    invoke-static v13, v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->access$showStep(Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment; Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$Step;)V
    iget-object v13, v12, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$confirmDelete$1;->this$0 Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;
    invoke-static v13, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->access$startFinishCountdown(Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;)V
    iget-object v13, v12, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$confirmDelete$1;->this$0 Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;
    invoke-static v13, v8, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->access$setLoading$p(Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment; Z)V
    goto +26h
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v13, Ljava/lang/Exception;->getMessage()Ljava/lang/String;
    move-result-object v13
    invoke-virtual v2, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v13
    invoke-virtual v13, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v13
    invoke-virtual v0, v5, v13, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v13, v12, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$confirmDelete$1;->this$0 Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;
    sget v0, Lcom/bytedance/trae/home/R$string;->trae_delete_failed I
    invoke-virtual v13, v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->getString(I)Ljava/lang/String;
    move-result-object v0
    invoke-static v0, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v13, v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->access$showToast(Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment; Ljava/lang/String;)V
    goto -2ah
    sget-object v13, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v13
    iget-object v0, v12, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$confirmDelete$1;->this$0 Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;
    invoke-static v0, v8, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->access$setLoading$p(Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment; Z)V
    throw v13
    :try_start_0x17
    :try_start_0x26
    :try_start_0x33
    :try_start_0x78
    :try_start_0x86
    :try_start_0xae
.end method
