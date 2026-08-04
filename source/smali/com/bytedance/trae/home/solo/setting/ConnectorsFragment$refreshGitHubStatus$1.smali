# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment$refreshGitHubStatus$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "ConnectorsFragment.kt"

.implements Lkotlin/jvm/functions/Function2;

.field  I$0:I
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;


.method constructor <init>(com.bytedance.trae.home.solo.setting.ConnectorsFragment  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment$refreshGitHubStatus$1;->this$0 Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;
    const/4 v1, 2
    invoke-direct v0, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 4
    # ins_size=3
    new-instance v2, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment$refreshGitHubStatus$1;
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment$refreshGitHubStatus$1;->this$0 Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;
    invoke-direct v2, v0, v3, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment$refreshGitHubStatus$1;-><init>(Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment; Lkotlin/coroutines/Continuation;)V
    check-cast v2, Lkotlin/coroutines/Continuation;
    return-object v2
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment$refreshGitHubStatus$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment$refreshGitHubStatus$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment$refreshGitHubStatus$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment$refreshGitHubStatus$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 8
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v6, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment$refreshGitHubStatus$1;->label I
    const-string/jumbo v2, switchGithub
    const/4 v3, 0
    const/4 v4, 1
    const/4 v5, 0
    if-eqz v1, +012h
    if-ne v1, v4, +008h
    iget v0, v6, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment$refreshGitHubStatus$1;->I$0 I
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +29h
    new-instance v7, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v7, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v7
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v7, v6, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment$refreshGitHubStatus$1;->this$0 Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;
    invoke-static v7, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;->access$getConnectorManager$p(Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;)Lcom/bytedance/trae/conversation/git/GitHubConnectorManager;
    move-result-object v7
    if-nez v7, +008h
    const-string v7, "connectorManager"
    invoke-static v7, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v7, v3
    move-object v1, v6
    check-cast v1, Lkotlin/coroutines/Continuation;
    iput v5, v6, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment$refreshGitHubStatus$1;->I$0 I
    iput v4, v6, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment$refreshGitHubStatus$1;->label I
    invoke-virtual v7, v1, Lcom/bytedance/trae/conversation/git/GitHubConnectorManager;->checkToken(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v7
    if-ne v7, v0, +003h
    return-object v0
    move v0, v5
    check-cast v7, Ljava/lang/String;
    check-cast v7, Ljava/lang/CharSequence;
    if-eqz v7, +00bh
    invoke-static v7, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v7
    if-eqz v7, +003h
    goto +3h
    move v7, v5
    goto +2h
    move v7, v4
    if-nez v7, +004h
    move v0, v4
    goto +2h
    move v0, v5
    iget-object v7, v6, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment$refreshGitHubStatus$1;->this$0 Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;
    invoke-static v7, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;->access$getSwitchGithub$p(Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;)Landroidx/appcompat/widget/SwitchCompat;
    move-result-object v7
    if-nez v7, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v7, v3
    if-eqz v0, +003h
    goto +2h
    move v4, v5
    invoke-virtual v7, v4, Landroidx/appcompat/widget/SwitchCompat;->setChecked(Z)V
    goto +2h
    move v0, v5
    iget-object v7, v6, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment$refreshGitHubStatus$1;->this$0 Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;
    invoke-static v7, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;->access$getSwitchGithub$p(Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;)Landroidx/appcompat/widget/SwitchCompat;
    move-result-object v7
    if-nez v7, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v7, v3
    invoke-virtual v7, Landroidx/appcompat/widget/SwitchCompat;->jumpDrawablesToCurrentState()V
    iget-object v7, v6, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment$refreshGitHubStatus$1;->this$0 Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;
    invoke-static v7, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;->access$getSwitchGithub$p(Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;)Landroidx/appcompat/widget/SwitchCompat;
    move-result-object v7
    if-nez v7, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v7, v3
    invoke-virtual v7, v5, Landroidx/appcompat/widget/SwitchCompat;->setVisibility(I)V
    iget-object v7, v6, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment$refreshGitHubStatus$1;->this$0 Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;
    invoke-static v7, Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;->access$getCardManageGithub$p(Lcom/bytedance/trae/home/solo/setting/ConnectorsFragment;)Landroid/widget/LinearLayout;
    move-result-object v7
    if-nez v7, +008h
    const-string v7, "cardManageGithub"
    invoke-static v7, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v3, v7
    if-eqz v0, +003h
    goto +3h
    const/16 v5, 8
    invoke-virtual v3, v5, Landroid/widget/LinearLayout;->setVisibility(I)V
    sget-object v7, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v7
    :try_start_0x12
    :try_start_0x21
    :try_start_0x3e
.end method
