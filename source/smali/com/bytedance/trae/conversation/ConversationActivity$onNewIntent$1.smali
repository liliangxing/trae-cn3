# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/ConversationActivity$onNewIntent$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "ConversationActivity.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $uri:Landroid/net/Uri;
.field private synthetic L$0:Ljava/lang/Object;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/ConversationActivity;


.method constructor <init>(com.bytedance.trae.conversation.ConversationActivity  android.net.Uri  kotlin.coroutines.Continuation)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity$onNewIntent$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/ConversationActivity$onNewIntent$1;->$uri Landroid/net/Uri;
    const/4 v1, 2
    invoke-direct v0, v1, v3, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 6
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/conversation/ConversationActivity$onNewIntent$1;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/ConversationActivity$onNewIntent$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    iget-object v2, v3, Lcom/bytedance/trae/conversation/ConversationActivity$onNewIntent$1;->$uri Landroid/net/Uri;
    invoke-direct v0, v1, v2, v5, Lcom/bytedance/trae/conversation/ConversationActivity$onNewIntent$1;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity; Landroid/net/Uri; Lkotlin/coroutines/Continuation;)V
    iput-object v4, v0, Lcom/bytedance/trae/conversation/ConversationActivity$onNewIntent$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lkotlin/coroutines/Continuation;
    return-object v0
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$onNewIntent$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$onNewIntent$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/ConversationActivity$onNewIntent$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$onNewIntent$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 12
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v10, Lcom/bytedance/trae/conversation/ConversationActivity$onNewIntent$1;->label I
    const/4 v2, 1
    if-eqz v1, +010h
    if-ne v1, v2, +006h
    invoke-static v11, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +2dh
    new-instance v11, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v11, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v11
    invoke-static v11, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v11, v10, Lcom/bytedance/trae/conversation/ConversationActivity$onNewIntent$1;->L$0 Ljava/lang/Object;
    check-cast v11, Lkotlinx/coroutines/CoroutineScope;
    iget-object v11, v10, Lcom/bytedance/trae/conversation/ConversationActivity$onNewIntent$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    iget-object v1, v10, Lcom/bytedance/trae/conversation/ConversationActivity$onNewIntent$1;->$uri Landroid/net/Uri;
    sget-object v3, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v11, Lcom/bytedance/trae/conversation/ConversationActivity;->access$getGitHubConnectorManager(Lcom/bytedance/trae/conversation/ConversationActivity;)Lcom/bytedance/trae/conversation/git/GitHubConnectorManager;
    move-result-object v4
    const-string v11, "code"
    invoke-virtual v1, v11, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v5
    const/4 v6, 0
    const/4 v8, 2
    const/4 v9, 0
    iput v2, v10, Lcom/bytedance/trae/conversation/ConversationActivity$onNewIntent$1;->label I
    move-object v7, v10
    invoke-static/range v4 ... v9, Lcom/bytedance/trae/conversation/git/GitHubConnectorManager;->completeOAuthCallback$default(Lcom/bytedance/trae/conversation/git/GitHubConnectorManager; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v11
    if-ne v11, v0, +003h
    return-object v0
    check-cast v11, Lcom/bytedance/trae/conversation/git/GitHubConnectorAuthorization;
    invoke-static v11, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v11
    goto +ch
    move-exception v11
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v11, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v11
    invoke-static v11, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v11
    iget-object v0, v10, Lcom/bytedance/trae/conversation/ConversationActivity$onNewIntent$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v11, Lkotlin/Result;->isSuccess-impl(Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +00ch
    move-object v1, v11
    check-cast v1, Lcom/bytedance/trae/conversation/git/GitHubConnectorAuthorization;
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationActivity;->access$getInputFragment(Lcom/bytedance/trae/conversation/ConversationActivity;)Lcom/bytedance/trae/conversation/widget/InputFragment;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->loadGitRepos()V
    iget-object v0, v10, Lcom/bytedance/trae/conversation/ConversationActivity$onNewIntent$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v11, Lkotlin/Result;->exceptionOrNull-impl(Ljava/lang/Object;)Ljava/lang/Throwable;
    move-result-object v11
    if-eqz v11, +033h
    instance-of v1, v11, Lcom/bytedance/trae/conversation/git/GitHubConnectorError;
    if-eqz v1, +006h
    move-object v1, v11
    check-cast v1, Lcom/bytedance/trae/conversation/git/GitHubConnectorError;
    goto +2h
    const/4 v1, 0
    if-eqz v1, +00bh
    move-object v2, v0
    check-cast v2, Landroid/content/Context;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/git/GitHubConnectorError;->localizedMessage(Landroid/content/Context;)Ljava/lang/String;
    move-result-object v1
    if-nez v1, +013h
    invoke-virtual v11, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v1
    if-nez v1, +00dh
    sget v11, Lcom/bytedance/trae/multilanguage/R$string;->trae_github_error_check_token_failed I
    invoke-virtual v0, v11, Lcom/bytedance/trae/conversation/ConversationActivity;->getString(I)Ljava/lang/String;
    move-result-object v1
    const-string v11, "getString(...)"
    invoke-static v1, v11, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/content/Context;
    check-cast v1, Ljava/lang/CharSequence;
    const/4 v11, 0
    invoke-static v0, v1, v11, Landroid/widget/Toast;->makeText(Landroid/content/Context; Ljava/lang/CharSequence; I)Landroid/widget/Toast;
    move-result-object v11
    invoke-virtual v11, Landroid/widget/Toast;->show()V
    sget-object v11, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v11
    :try_start_0xb
    :try_start_0x22
.end method
