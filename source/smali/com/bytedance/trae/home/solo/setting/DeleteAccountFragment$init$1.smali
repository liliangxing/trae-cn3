# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$init$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "DeleteAccountFragment.kt"

.implements Lkotlin/jvm/functions/Function2;

.field private synthetic L$0:Ljava/lang/Object;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;


.method constructor <init>(com.bytedance.trae.home.solo.setting.DeleteAccountFragment  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$init$1;->this$0 Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;
    const/4 v1, 2
    invoke-direct v0, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$init$1;
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$init$1;->this$0 Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;
    invoke-direct v0, v1, v4, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$init$1;-><init>(Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment; Lkotlin/coroutines/Continuation;)V
    iput-object v3, v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$init$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lkotlin/coroutines/Continuation;
    return-object v0
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$init$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$init$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$init$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$init$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 10
    # ins_size=2
    const-string v0, "github"
    const-string v1, "google"
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v2
    iget v3, v8, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$init$1;->label I
    const-string v4, "getString(...)"
    const/4 v5, 1
    if-eqz v3, +014h
    if-ne v3, v5, +00ah
    iget-object v2, v8, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$init$1;->L$0 Ljava/lang/Object;
    check-cast v2, Lkotlinx/coroutines/CoroutineScope;
    invoke-static v9, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +20h
    new-instance v9, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v9, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v9
    invoke-static v9, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v9, v8, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$init$1;->L$0 Ljava/lang/Object;
    check-cast v9, Lkotlinx/coroutines/CoroutineScope;
    sget-object v3, Lcom/bytedance/trae/home/solo/setting/IAccountCancelApi;->Companion Lcom/bytedance/trae/home/solo/setting/IAccountCancelApi$Companion;
    move-object v6, v8
    check-cast v6, Lkotlin/coroutines/Continuation;
    iput-object v9, v8, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$init$1;->L$0 Ljava/lang/Object;
    iput v5, v8, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$init$1;->label I
    invoke-virtual v3, v6, Lcom/bytedance/trae/home/solo/setting/IAccountCancelApi$Companion;->userCheck(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v9
    if-ne v9, v2, +003h
    return-object v2
    check-cast v9, Lcom/bytedance/trae/home/solo/setting/CancelUserCheckResponse;
    invoke-virtual v9, Lcom/bytedance/trae/home/solo/setting/CancelUserCheckResponse;->getErrorCode()I
    move-result v2
    if-eqz v2, +035h
    iget-object v0, v8, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$init$1;->this$0 Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;
    invoke-virtual v9, Lcom/bytedance/trae/home/solo/setting/CancelUserCheckResponse;->getDescription()Ljava/lang/String;
    move-result-object v1
    if-nez v1, +013h
    invoke-virtual v9, Lcom/bytedance/trae/home/solo/setting/CancelUserCheckResponse;->getMessage()Ljava/lang/String;
    move-result-object v1
    if-nez v1, +00dh
    iget-object v9, v8, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$init$1;->this$0 Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;
    sget v1, Lcom/bytedance/trae/home/R$string;->trae_delete_check_failed I
    invoke-virtual v9, v1, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->getString(I)Ljava/lang/String;
    move-result-object v1
    invoke-static v1, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->access$showToast(Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment; Ljava/lang/String;)V
    iget-object v9, v8, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$init$1;->this$0 Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;
    invoke-virtual v9, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->isAdded()Z
    move-result v9
    if-nez v9, +005h
    sget-object v9, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v9
    iget-object v9, v8, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$init$1;->this$0 Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;
    invoke-virtual v9, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->getParentFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v9
    invoke-virtual v9, Landroidx/fragment/app/FragmentManager;->popBackStack()V
    sget-object v9, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v9
    invoke-virtual v9, Lcom/bytedance/trae/home/solo/setting/CancelUserCheckResponse;->getData()Lcom/bytedance/trae/home/solo/setting/CancelUserCheckData;
    move-result-object v9
    iget-object v2, v8, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$init$1;->this$0 Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;
    const/4 v3, 0
    if-eqz v9, +007h
    invoke-virtual v9, Lcom/bytedance/trae/home/solo/setting/CancelUserCheckData;->getValueTicket()Ljava/lang/String;
    move-result-object v6
    goto +2h
    move-object v6, v3
    invoke-static v2, v6, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->access$setValueTicket$p(Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment; Ljava/lang/String;)V
    sget-object v2, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v2, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isOversea()Z
    move-result v2
    const/4 v6, 0
    if-eqz v2, +082h
    if-eqz v9, +00ah
    invoke-virtual v9, Lcom/bytedance/trae/home/solo/setting/CancelUserCheckData;->getAuthType()I
    move-result v2
    const/4 v7, 2
    if-ne v2, v7, +003h
    goto +2h
    move v5, v6
    if-eqz v5, +06dh
    invoke-virtual v9, Lcom/bytedance/trae/home/solo/setting/CancelUserCheckData;->getOauthPlatforms()Ljava/util/List;
    move-result-object v2
    if-eqz v2, +009h
    invoke-static v2, Lkotlin/collections/CollectionsKt;->firstOrNull(Ljava/util/List;)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/String;
    goto +2h
    move-object v2, v3
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-eqz v5, +01dh
    iget-object v0, v8, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$init$1;->this$0 Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;
    sget-object v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$AuthType;->GOOGLE Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$AuthType;
    invoke-static v0, v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->access$setAuthType$p(Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment; Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$AuthType;)V
    iget-object v0, v8, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$init$1;->this$0 Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;
    invoke-virtual v9, Lcom/bytedance/trae/home/solo/setting/CancelUserCheckData;->getPlatformUserNames()Ljava/util/Map;
    move-result-object v9
    if-eqz v9, +009h
    invoke-interface v9, v1, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v9
    move-object v3, v9
    check-cast v3, Ljava/lang/String;
    invoke-static v0, v3, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->access$setNickname$p(Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment; Ljava/lang/String;)V
    goto/16 +080h
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +01ch
    iget-object v1, v8, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$init$1;->this$0 Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;
    sget-object v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$AuthType;->GITHUB Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$AuthType;
    invoke-static v1, v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->access$setAuthType$p(Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment; Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$AuthType;)V
    iget-object v1, v8, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$init$1;->this$0 Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;
    invoke-virtual v9, Lcom/bytedance/trae/home/solo/setting/CancelUserCheckData;->getPlatformUserNames()Ljava/util/Map;
    move-result-object v9
    if-eqz v9, +009h
    invoke-interface v9, v0, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v9
    move-object v3, v9
    check-cast v3, Ljava/lang/String;
    invoke-static v1, v3, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->access$setNickname$p(Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment; Ljava/lang/String;)V
    goto +5fh
    iget-object v0, v8, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$init$1;->this$0 Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;
    sget-object v1, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$AuthType;->GITHUB Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$AuthType;
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->access$setAuthType$p(Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment; Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$AuthType;)V
    iget-object v0, v8, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$init$1;->this$0 Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;
    if-eqz v2, +00fh
    invoke-virtual v9, Lcom/bytedance/trae/home/solo/setting/CancelUserCheckData;->getPlatformUserNames()Ljava/util/Map;
    move-result-object v9
    if-eqz v9, +009h
    invoke-interface v9, v2, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v9
    check-cast v9, Ljava/lang/String;
    move-object v3, v9
    invoke-static v0, v3, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->access$setNickname$p(Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment; Ljava/lang/String;)V
    goto +43h
    iget-object v9, v8, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$init$1;->this$0 Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$AuthType;->EMAIL_CODE Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$AuthType;
    invoke-static v9, v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->access$setAuthType$p(Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment; Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$AuthType;)V
    goto +3bh
    iget-object v9, v8, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$init$1;->this$0 Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$AuthType;->SMS_CODE Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$AuthType;
    invoke-static v9, v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->access$setAuthType$p(Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment; Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$AuthType;)V
    iget-object v9, v8, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$init$1;->this$0 Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v9, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->access$getLoginService$p(Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;)Lcom/bytedance/trae/login/api/ILoginService;
    move-result-object v0
    if-eqz v0, +00dh
    invoke-interface v0, Lcom/bytedance/trae/login/api/ILoginService;->getAccountInfo()Lcom/bytedance/trae/login/api/AccountInfo;
    move-result-object v0
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/login/api/AccountInfo;->getPhoneNumber()Ljava/lang/String;
    move-result-object v0
    goto +2h
    move-object v0, v3
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    goto +ch
    move-exception v0
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v0, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +003h
    goto +2h
    move-object v3, v0
    check-cast v3, Ljava/lang/String;
    invoke-static v9, v3, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->access$setUserMobile$p(Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment; Ljava/lang/String;)V
    iget-object v9, v8, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$init$1;->this$0 Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;
    invoke-static v9, v6, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->access$showLoading(Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment; Z)V
    iget-object v9, v8, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$init$1;->this$0 Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$Step;->VERIFY Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$Step;
    invoke-static v9, v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->access$showStep(Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment; Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$Step;)V
    goto +3bh
    move-exception v9
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "init failed: "
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v9, Ljava/lang/Exception;->getMessage()Ljava/lang/String;
    move-result-object v9
    invoke-virtual v1, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v9, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v9
    const-string v1, "DeleteAccountFragment"
    invoke-virtual v0, v1, v9, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v9, v8, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$init$1;->this$0 Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;
    sget v0, Lcom/bytedance/trae/home/R$string;->trae_delete_check_failed I
    invoke-virtual v9, v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->getString(I)Ljava/lang/String;
    move-result-object v0
    invoke-static v0, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v9, v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->access$showToast(Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment; Ljava/lang/String;)V
    iget-object v9, v8, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$init$1;->this$0 Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;
    invoke-virtual v9, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->isAdded()Z
    move-result v9
    if-eqz v9, +00bh
    iget-object v9, v8, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$init$1;->this$0 Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;
    invoke-virtual v9, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->getParentFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v9
    invoke-virtual v9, Landroidx/fragment/app/FragmentManager;->popBackStack()V
    sget-object v9, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v9
    :try_start_0x15
    :try_start_0x28
    :try_start_0x117
    :try_start_0x131
.end method
