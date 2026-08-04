# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$wakeupSandboxAndWaitForReady$2;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "HtmlArtifactRemoteArchiveUrlResolver.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $chatSessionId:Ljava/lang/String;
.field private synthetic L$0:Ljava/lang/Object;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;


.method constructor <init>(com.bytedance.trae.conversation.products.HtmlArtifactRemoteArchiveUrlResolver  java.lang.String  kotlin.coroutines.Continuation)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$wakeupSandboxAndWaitForReady$2;->this$0 Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$wakeupSandboxAndWaitForReady$2;->$chatSessionId Ljava/lang/String;
    const/4 v1, 2
    invoke-direct v0, v1, v3, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 6
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$wakeupSandboxAndWaitForReady$2;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$wakeupSandboxAndWaitForReady$2;->this$0 Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;
    iget-object v2, v3, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$wakeupSandboxAndWaitForReady$2;->$chatSessionId Ljava/lang/String;
    invoke-direct v0, v1, v2, v5, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$wakeupSandboxAndWaitForReady$2;-><init>(Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    iput-object v4, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$wakeupSandboxAndWaitForReady$2;->L$0 Ljava/lang/Object;
    check-cast v0, Lkotlin/coroutines/Continuation;
    return-object v0
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$wakeupSandboxAndWaitForReady$2;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$wakeupSandboxAndWaitForReady$2;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$wakeupSandboxAndWaitForReady$2;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$wakeupSandboxAndWaitForReady$2;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 13
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v11, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$wakeupSandboxAndWaitForReady$2;->label I
    const/4 v2, 0
    const/4 v3, 2
    const/4 v4, 1
    if-eqz v1, +01ah
    if-eq v1, v4, +010h
    if-ne v1, v3, +006h
    invoke-static v12, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +4eh
    new-instance v12, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v12, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v12
    iget-object v1, v11, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$wakeupSandboxAndWaitForReady$2;->L$0 Ljava/lang/Object;
    check-cast v1, Lkotlinx/coroutines/Deferred;
    invoke-static v12, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +30h
    invoke-static v12, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v12, v11, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$wakeupSandboxAndWaitForReady$2;->L$0 Ljava/lang/Object;
    move-object v5, v12
    check-cast v5, Lkotlinx/coroutines/CoroutineScope;
    const/4 v6, 0
    sget-object v7, Lkotlinx/coroutines/CoroutineStart;->UNDISPATCHED Lkotlinx/coroutines/CoroutineStart;
    new-instance v12, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$wakeupSandboxAndWaitForReady$2$ready$1;
    iget-object v1, v11, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$wakeupSandboxAndWaitForReady$2;->this$0 Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;
    iget-object v8, v11, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$wakeupSandboxAndWaitForReady$2;->$chatSessionId Ljava/lang/String;
    invoke-direct v12, v1, v8, v2, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$wakeupSandboxAndWaitForReady$2$ready$1;-><init>(Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    move-object v8, v12
    check-cast v8, Lkotlin/jvm/functions/Function2;
    const/4 v9, 1
    const/4 v10, 0
    invoke-static/range v5 ... v10, Lkotlinx/coroutines/BuildersKt;->async$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Deferred;
    move-result-object v1
    iget-object v12, v11, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$wakeupSandboxAndWaitForReady$2;->this$0 Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;
    iget-object v5, v11, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$wakeupSandboxAndWaitForReady$2;->$chatSessionId Ljava/lang/String;
    move-object v6, v11
    check-cast v6, Lkotlin/coroutines/Continuation;
    iput-object v1, v11, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$wakeupSandboxAndWaitForReady$2;->L$0 Ljava/lang/Object;
    iput v4, v11, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$wakeupSandboxAndWaitForReady$2;->label I
    invoke-static v12, v5, v6, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;->access$wakeupSandbox(Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver; Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v12
    if-ne v12, v0, +003h
    return-object v0
    move-object v12, v11
    check-cast v12, Lkotlin/coroutines/Continuation;
    iput-object v2, v11, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$wakeupSandboxAndWaitForReady$2;->L$0 Ljava/lang/Object;
    iput v3, v11, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$wakeupSandboxAndWaitForReady$2;->label I
    invoke-interface v1, v12, Lkotlinx/coroutines/Deferred;->await(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v12
    if-ne v12, v0, +003h
    return-object v0
    return-object v12
.end method
