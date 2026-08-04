# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment$disconnect$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "ConnectorsFragment.kt"

.implements Lkotlin/jvm/functions/Function2;

.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;


.method constructor <init>(com.bytedance.trae.home.solo.setting.ConnectorsFragment  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment$disconnect$1;->this$0 Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;
    const/4 v1, 2
    invoke-direct v0, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 4
    # ins_size=3
    new-instance v2, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment$disconnect$1;
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment$disconnect$1;->this$0 Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;
    invoke-direct v2, v0, v3, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment$disconnect$1;-><init>(Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment; Lkotlin/coroutines/Continuation;)V
    check-cast v2, Lkotlin/coroutines/Continuation;
    return-object v2
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment$disconnect$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment$disconnect$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment$disconnect$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment$disconnect$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 8
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v6, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment$disconnect$1;->label I
    const/4 v2, 0
    const/4 v3, 1
    const/4 v4, 0
    if-eqz v1, +015h
    if-ne v1, v3, +00bh
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +2bh
    move-exception v7
    goto/16 +0bdh
    move-exception v7
    goto +65h
    new-instance v7, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v7, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v7
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v7, v6, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment$disconnect$1;->this$0 Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;
    invoke-static v7, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;->access$getConnectorManager$p(Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;)Lcom/bytedance/trae/conversation/git/GitHubConnectorManager;
    move-result-object v7
    if-nez v7, +008h
    const-string v7, "connectorManager"
    invoke-static v7, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v7, v2
    move-object v1, v6
    check-cast v1, Lkotlin/coroutines/Continuation;
    iput v3, v6, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment$disconnect$1;->label I
    invoke-virtual v7, v1, Lcom/bytedance/trae/conversation/git/GitHubConnectorManager;->disconnect(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v7
    if-ne v7, v0, +003h
    return-object v0
    iget-object v7, v6, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment$disconnect$1;->this$0 Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;
    invoke-static v7, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;->access$getSwitchGithub$p(Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;)Landroidx/appcompat/widget/SwitchCompat;
    move-result-object v7
    if-nez v7, +009h
    const-string/jumbo v7, switchGithub
    invoke-static v7, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v7, v2
    invoke-virtual v7, v4, Landroidx/appcompat/widget/SwitchCompat;->setChecked(Z)V
    iget-object v7, v6, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment$disconnect$1;->this$0 Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;
    invoke-static v7, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;->access$getCardManageGithub$p(Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;)Landroid/widget/LinearLayout;
    move-result-object v7
    if-nez v7, +008h
    const-string v7, "cardManageGithub"
    invoke-static v7, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v7, v2
    const/16 v0, 8
    invoke-virtual v7, v0, Landroid/widget/LinearLayout;->setVisibility(I)V
    iget-object v7, v6, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment$disconnect$1;->this$0 Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;
    invoke-virtual v7, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;->requireContext()Landroid/content/Context;
    move-result-object v7
    sget v0, Lcom/bytedance/trae/home/R$string;->trae_setting_connector_disconnect_success I
    invoke-static v7, v0, v4, Landroid/widget/Toast;->makeText(Landroid/content/Context; I I)Landroid/widget/Toast;
    move-result-object v7
    invoke-virtual v7, Landroid/widget/Toast;->show()V
    iget-object v7, v6, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment$disconnect$1;->this$0 Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;
    invoke-static v7, v4, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;->access$setOperating$p(Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment; Z)V
    iget-object v7, v6, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment$disconnect$1;->this$0 Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;
    invoke-static v7, v3, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;->access$setInteractionEnabled(Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment; Z)V
    goto +53h
    instance-of v0, v7, Lcom/bytedance/trae/conversation/git/GitHubConnectorError;
    if-eqz v0, +005h
    move-object v2, v7
    check-cast v2, Lcom/bytedance/trae/conversation/git/GitHubConnectorError;
    if-eqz v2, +014h
    iget-object v0, v6, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment$disconnect$1;->this$0 Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;->requireContext()Landroid/content/Context;
    move-result-object v0
    const-string/jumbo v1, requireContext(...)
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v2, v0, Lcom/bytedance/trae/conversation/git/GitHubConnectorError;->localizedMessage(Landroid/content/Context;)Ljava/lang/String;
    move-result-object v0
    if-nez v0, +00ah
    invoke-virtual v7, Ljava/lang/Exception;->getMessage()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +004h
    const-string v0, ""
    iget-object v7, v6, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment$disconnect$1;->this$0 Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;
    invoke-virtual v7, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;->requireContext()Landroid/content/Context;
    move-result-object v7
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct v1, Ljava/lang/StringBuilder;-><init>()V
    iget-object v2, v6, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment$disconnect$1;->this$0 Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;
    sget v5, Lcom/bytedance/trae/home/R$string;->trae_setting_connector_disconnect_failed I
    invoke-virtual v2, v5, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;->getString(I)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ": "
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v7, v0, v4, Landroid/widget/Toast;->makeText(Landroid/content/Context; Ljava/lang/CharSequence; I)Landroid/widget/Toast;
    move-result-object v7
    invoke-virtual v7, Landroid/widget/Toast;->show()V
    goto -5ch
    sget-object v7, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v7
    iget-object v0, v6, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment$disconnect$1;->this$0 Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;
    invoke-static v0, v4, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;->access$setOperating$p(Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment; Z)V
    iget-object v0, v6, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment$disconnect$1;->this$0 Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;
    invoke-static v0, v3, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;->access$setInteractionEnabled(Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment; Z)V
    throw v7
    :try_start_0xd
    :try_start_0x21
    :try_start_0x7a
.end method
