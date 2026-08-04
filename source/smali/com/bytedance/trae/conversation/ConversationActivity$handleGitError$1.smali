# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/ConversationActivity$handleGitError$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "ConversationActivity.kt"

.implements Lkotlin/jvm/functions/Function2;

.field private synthetic L$0:Ljava/lang/Object;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/ConversationActivity;


.method public static synthetic $r8$lambda$e_gCUjl2NNcSZfB05rn-iwOUypw(com.bytedance.trae.conversation.ConversationActivity  java.lang.String  java.lang.String)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$handleGitError$1;->invokeSuspend$lambda$4(Lcom/bytedance/trae/conversation/ConversationActivity; Ljava/lang/String; Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method constructor <init>(com.bytedance.trae.conversation.ConversationActivity  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity$handleGitError$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    const/4 v1, 2
    invoke-direct v0, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method private static final invokeSuspend$lambda$4(com.bytedance.trae.conversation.ConversationActivity  java.lang.String  java.lang.String)kotlin.Unit
    .registers 4
    # ins_size=3
    new-instance v3, Landroid/content/Intent;
    const-string v0, "android.intent.action.VIEW"
    invoke-static v2, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v2
    invoke-direct v3, v0, v2, Landroid/content/Intent;-><init>(Ljava/lang/String; Landroid/net/Uri;)V
    invoke-virtual v1, v3, Lcom/bytedance/trae/conversation/ConversationActivity;->startActivity(Landroid/content/Intent;)V
    goto +14h
    move-object v2, v1
    check-cast v2, Landroid/content/Context;
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->trae_github_error_check_token_failed I
    invoke-virtual v1, v3, Lcom/bytedance/trae/conversation/ConversationActivity;->getString(I)Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    const/4 v3, 0
    invoke-static v2, v1, v3, Landroid/widget/Toast;->makeText(Landroid/content/Context; Ljava/lang/CharSequence; I)Landroid/widget/Toast;
    move-result-object v1
    invoke-virtual v1, Landroid/widget/Toast;->show()V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
    :try_start_0x0
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/conversation/ConversationActivity$handleGitError$1;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$handleGitError$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-direct v0, v1, v4, Lcom/bytedance/trae/conversation/ConversationActivity$handleGitError$1;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity; Lkotlin/coroutines/Continuation;)V
    iput-object v3, v0, Lcom/bytedance/trae/conversation/ConversationActivity$handleGitError$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lkotlin/coroutines/Continuation;
    return-object v0
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$handleGitError$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$handleGitError$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/ConversationActivity$handleGitError$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$handleGitError$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 34
    # ins_size=2
    move-object/from16 v1, v32
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v2, v1, Lcom/bytedance/trae/conversation/ConversationActivity$handleGitError$1;->label I
    const/4 v3, 1
    if-eqz v2, +016h
    if-ne v2, v3, +00ch
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity$handleGitError$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lkotlinx/coroutines/CoroutineScope;
    invoke-static/range v33, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v2, v33
    goto +23h
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    invoke-static/range v33, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/ConversationActivity$handleGitError$1;->L$0 Ljava/lang/Object;
    check-cast v2, Lkotlinx/coroutines/CoroutineScope;
    iget-object v4, v1, Lcom/bytedance/trae/conversation/ConversationActivity$handleGitError$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    sget-object v5, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v4, Lcom/bytedance/trae/conversation/ConversationActivity;->access$getGitHubConnectorManager(Lcom/bytedance/trae/conversation/ConversationActivity;)Lcom/bytedance/trae/conversation/git/GitHubConnectorManager;
    move-result-object v4
    iput-object v2, v1, Lcom/bytedance/trae/conversation/ConversationActivity$handleGitError$1;->L$0 Ljava/lang/Object;
    iput v3, v1, Lcom/bytedance/trae/conversation/ConversationActivity$handleGitError$1;->label I
    invoke-virtual v4, v1, Lcom/bytedance/trae/conversation/git/GitHubConnectorManager;->checkToken(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v0, +003h
    return-object v0
    check-cast v2, Ljava/lang/String;
    invoke-static v2, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    goto +ch
    move-exception v0
    sget-object v2, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v0, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    iget-object v2, v1, Lcom/bytedance/trae/conversation/ConversationActivity$handleGitError$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v0, Lkotlin/Result;->exceptionOrNull-impl(Ljava/lang/Object;)Ljava/lang/Throwable;
    move-result-object v4
    const/4 v5, 0
    const/4 v6, 0
    const-string v7, "getString(...)"
    if-nez v4, +0e8h
    check-cast v0, Ljava/lang/String;
    iget-object v2, v1, Lcom/bytedance/trae/conversation/ConversationActivity$handleGitError$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v2, Lcom/bytedance/trae/conversation/ConversationActivity;->access$hideLoading(Lcom/bytedance/trae/conversation/ConversationActivity;)V
    check-cast v0, Ljava/lang/CharSequence;
    if-eqz v0, +00bh
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    if-eqz v0, +003h
    goto +3h
    move v0, v5
    goto +2h
    move v0, v3
    if-eqz v0, +0c1h
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity$handleGitError$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    sget-object v2, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationActivity;->access$getGitHubConnectorManager(Lcom/bytedance/trae/conversation/ConversationActivity;)Lcom/bytedance/trae/conversation/git/GitHubConnectorManager;
    move-result-object v0
    invoke-static v0, v6, v3, v6, Lcom/bytedance/trae/conversation/git/GitHubConnectorManager;->buildOAuthUrl$default(Lcom/bytedance/trae/conversation/git/GitHubConnectorManager; Ljava/lang/String; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    goto +ch
    move-exception v0
    sget-object v2, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v0, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    iget-object v2, v1, Lcom/bytedance/trae/conversation/ConversationActivity$handleGitError$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v0, Lkotlin/Result;->exceptionOrNull-impl(Ljava/lang/Object;)Ljava/lang/Throwable;
    move-result-object v3
    if-nez v3, +06eh
    check-cast v0, Ljava/lang/String;
    new-instance v2, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;
    iget-object v3, v1, Lcom/bytedance/trae/conversation/ConversationActivity$handleGitError$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    check-cast v3, Landroid/content/Context;
    new-instance v4, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;
    move-object v8, v4
    iget-object v5, v1, Lcom/bytedance/trae/conversation/ConversationActivity$handleGitError$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    sget v6, Lcom/bytedance/trae/multilanguage/R$string;->trae_github_connect_title I
    invoke-virtual v5, v6, Lcom/bytedance/trae/conversation/ConversationActivity;->getString(I)Ljava/lang/String;
    move-result-object v5
    move-object v9, v5
    invoke-static v5, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v5, v1, Lcom/bytedance/trae/conversation/ConversationActivity$handleGitError$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    sget v6, Lcom/bytedance/trae/multilanguage/R$string;->trae_github_connect_message I
    invoke-virtual v5, v6, Lcom/bytedance/trae/conversation/ConversationActivity;->getString(I)Ljava/lang/String;
    move-result-object v10
    const/4 v11, 0
    const/4 v12, 0
    iget-object v5, v1, Lcom/bytedance/trae/conversation/ConversationActivity$handleGitError$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    sget v6, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_dialog_btn_cancel I
    invoke-virtual v5, v6, Lcom/bytedance/trae/conversation/ConversationActivity;->getString(I)Ljava/lang/String;
    move-result-object v5
    move-object v13, v5
    invoke-static v5, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v5, v1, Lcom/bytedance/trae/conversation/ConversationActivity$handleGitError$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    sget v6, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_dialog_btn_confirm I
    invoke-virtual v5, v6, Lcom/bytedance/trae/conversation/ConversationActivity;->getString(I)Ljava/lang/String;
    move-result-object v5
    move-object v14, v5
    invoke-static v5, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 0
    const/16 v22, 0
    const/16 v23, 0
    const/16 v24, 0
    const/16 v25, 0
    const/16 v26, 0
    const/16 v27, 0
    iget-object v5, v1, Lcom/bytedance/trae/conversation/ConversationActivity$handleGitError$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    new-instance v6, Lcom/bytedance/trae/conversation/ConversationActivity$handleGitError$1$$ExternalSyntheticLambda0;
    move-object/from16 v28, v6
    invoke-direct v6, v5, v0, Lcom/bytedance/trae/conversation/ConversationActivity$handleGitError$1$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity; Ljava/lang/String;)V
    const/16 v29, 0
    const v30, 1572812
    const/16 v31, 0
    invoke-direct/range v8 ... v31, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; F Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; I I I Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Z Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function0; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-direct v2, v3, v4, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;-><init>(Landroid/content/Context; Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;)V
    invoke-virtual v2, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;->show()V
    goto +3dh
    instance-of v0, v3, Lcom/bytedance/trae/conversation/git/GitHubConnectorError;
    if-eqz v0, +005h
    move-object v6, v3
    check-cast v6, Lcom/bytedance/trae/conversation/git/GitHubConnectorError;
    if-eqz v6, +00bh
    move-object v0, v2
    check-cast v0, Landroid/content/Context;
    invoke-virtual v6, v0, Lcom/bytedance/trae/conversation/git/GitHubConnectorError;->localizedMessage(Landroid/content/Context;)Ljava/lang/String;
    move-result-object v0
    if-nez v0, +011h
    invoke-virtual v3, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +00bh
    sget v0, Lcom/bytedance/trae/multilanguage/R$string;->trae_github_error_check_token_failed I
    invoke-virtual v2, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->getString(I)Ljava/lang/String;
    move-result-object v0
    invoke-static v0, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v2, Landroid/content/Context;
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v2, v0, v5, Landroid/widget/Toast;->makeText(Landroid/content/Context; Ljava/lang/CharSequence; I)Landroid/widget/Toast;
    move-result-object v0
    invoke-virtual v0, Landroid/widget/Toast;->show()V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationActivity$handleGitError$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    check-cast v0, Landroid/content/Context;
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_network_retry I
    invoke-static v0, v2, v5, Landroid/widget/Toast;->makeText(Landroid/content/Context; I I)Landroid/widget/Toast;
    move-result-object v0
    invoke-virtual v0, Landroid/widget/Toast;->show()V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
    invoke-static v2, Lcom/bytedance/trae/conversation/ConversationActivity;->access$hideLoading(Lcom/bytedance/trae/conversation/ConversationActivity;)V
    instance-of v0, v4, Lcom/bytedance/trae/conversation/git/GitHubConnectorError;
    if-eqz v0, +005h
    move-object v6, v4
    check-cast v6, Lcom/bytedance/trae/conversation/git/GitHubConnectorError;
    if-eqz v6, +00bh
    move-object v0, v2
    check-cast v0, Landroid/content/Context;
    invoke-virtual v6, v0, Lcom/bytedance/trae/conversation/git/GitHubConnectorError;->localizedMessage(Landroid/content/Context;)Ljava/lang/String;
    move-result-object v0
    if-nez v0, +00bh
    sget v0, Lcom/bytedance/trae/multilanguage/R$string;->trae_github_error_check_token_failed I
    invoke-virtual v2, v0, Lcom/bytedance/trae/conversation/ConversationActivity;->getString(I)Ljava/lang/String;
    move-result-object v0
    invoke-static v0, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v2, Landroid/content/Context;
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v2, v0, v5, Landroid/widget/Toast;->makeText(Landroid/content/Context; Ljava/lang/CharSequence; I)Landroid/widget/Toast;
    move-result-object v0
    invoke-virtual v0, Landroid/widget/Toast;->show()V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
    :try_start_0x11
    :try_start_0x28
    :try_start_0x70
.end method
