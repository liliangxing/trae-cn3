# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity$handleCallbackUri$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "GitHubOAuthActivity.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $uri:Landroid/net/Uri;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity;


.method constructor <init>(com.bytedance.trae.home.solo.setting.GitHubOAuthActivity  android.net.Uri  kotlin.coroutines.Continuation)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity$handleCallbackUri$1;->this$0 Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity$handleCallbackUri$1;->$uri Landroid/net/Uri;
    const/4 v1, 2
    invoke-direct v0, v1, v3, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v3, Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity$handleCallbackUri$1;
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity$handleCallbackUri$1;->this$0 Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity;
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity$handleCallbackUri$1;->$uri Landroid/net/Uri;
    invoke-direct v3, v0, v1, v4, Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity$handleCallbackUri$1;-><init>(Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity; Landroid/net/Uri; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/coroutines/Continuation;
    return-object v3
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity$handleCallbackUri$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity$handleCallbackUri$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity$handleCallbackUri$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity$handleCallbackUri$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 7
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v5, Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity$handleCallbackUri$1;->label I
    const/4 v2, 1
    if-eqz v1, +012h
    if-ne v1, v2, +008h
    invoke-static v6, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +2eh
    move-exception v6
    goto +33h
    new-instance v6, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v6, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v6
    invoke-static v6, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v6, v5, Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity$handleCallbackUri$1;->this$0 Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity;
    invoke-static v6, Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity;->access$getConnectorManager(Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity;)Lcom/bytedance/trae/conversation/git/GitHubConnectorManager;
    move-result-object v6
    iget-object v1, v5, Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity$handleCallbackUri$1;->$uri Landroid/net/Uri;
    const-string v3, "code"
    invoke-virtual v1, v3, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity$handleCallbackUri$1;->this$0 Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity;
    invoke-static v3, Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity;->access$getSettingsRedirectUri(Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity;)Ljava/lang/String;
    move-result-object v3
    move-object v4, v5
    check-cast v4, Lkotlin/coroutines/Continuation;
    iput v2, v5, Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity$handleCallbackUri$1;->label I
    invoke-virtual v6, v1, v3, v4, Lcom/bytedance/trae/conversation/git/GitHubConnectorManager;->completeOAuthCallback(Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v6
    if-ne v6, v0, +003h
    return-object v0
    iget-object v6, v5, Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity$handleCallbackUri$1;->this$0 Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity;
    const/4 v0, -1
    invoke-virtual v6, v0, Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity;->setResult(I)V
    goto +50h
    instance-of v0, v6, Lcom/bytedance/trae/conversation/git/GitHubConnectorError;
    if-eqz v0, +006h
    move-object v0, v6
    check-cast v0, Lcom/bytedance/trae/conversation/git/GitHubConnectorError;
    goto +2h
    const/4 v0, 0
    if-eqz v0, +00ch
    iget-object v1, v5, Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity$handleCallbackUri$1;->this$0 Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity;
    check-cast v1, Landroid/content/Context;
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/git/GitHubConnectorError;->localizedMessage(Landroid/content/Context;)Ljava/lang/String;
    move-result-object v0
    if-nez v0, +00ah
    invoke-virtual v6, Ljava/lang/Exception;->getMessage()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +004h
    const-string v0, ""
    iget-object v6, v5, Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity$handleCallbackUri$1;->this$0 Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity;
    check-cast v6, Landroid/content/Context;
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct v1, Ljava/lang/StringBuilder;-><init>()V
    iget-object v2, v5, Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity$handleCallbackUri$1;->this$0 Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity;
    sget v3, Lcom/bytedance/trae/home/R$string;->trae_setting_connector_connect_failed I
    invoke-virtual v2, v3, Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity;->getString(I)Ljava/lang/String;
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
    const/4 v1, 0
    invoke-static v6, v0, v1, Landroid/widget/Toast;->makeText(Landroid/content/Context; Ljava/lang/CharSequence; I)Landroid/widget/Toast;
    move-result-object v6
    invoke-virtual v6, Landroid/widget/Toast;->show()V
    iget-object v6, v5, Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity$handleCallbackUri$1;->this$0 Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity;
    invoke-virtual v6, v1, Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity;->setResult(I)V
    iget-object v6, v5, Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity$handleCallbackUri$1;->this$0 Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity;
    invoke-virtual v6, Lcom/bytedance/trae/home/solo/setting/GitHubOAuthActivity;->finish()V
    sget-object v6, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v6
    :try_start_0xb
    :try_start_0x1c
.end method
