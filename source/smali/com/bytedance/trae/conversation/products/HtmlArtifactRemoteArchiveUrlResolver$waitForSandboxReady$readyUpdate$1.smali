# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$readyUpdate$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "HtmlArtifactRemoteArchiveUrlResolver.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $chatSessionId:Ljava/lang/String;
.field final synthetic $lastAnyUpdate:Lkotlin/jvm/internal/Ref$ObjectRef;
.field final synthetic $lastMatchingUpdate:Lkotlin/jvm/internal/Ref$ObjectRef;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;


.method constructor <init>(com.bytedance.trae.conversation.products.HtmlArtifactRemoteArchiveUrlResolver  java.lang.String  kotlin.jvm.internal.Ref$ObjectRef  kotlin.jvm.internal.Ref$ObjectRef  kotlin.coroutines.Continuation)void
    .registers 6
    # ins_size=6
    iput-object v1, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$readyUpdate$1;->this$0 Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$readyUpdate$1;->$chatSessionId Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$readyUpdate$1;->$lastAnyUpdate Lkotlin/jvm/internal/Ref$ObjectRef;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$readyUpdate$1;->$lastMatchingUpdate Lkotlin/jvm/internal/Ref$ObjectRef;
    const/4 v1, 2
    invoke-direct v0, v1, v5, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 9
    # ins_size=3
    new-instance v7, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$readyUpdate$1;
    iget-object v1, v6, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$readyUpdate$1;->this$0 Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;
    iget-object v2, v6, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$readyUpdate$1;->$chatSessionId Ljava/lang/String;
    iget-object v3, v6, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$readyUpdate$1;->$lastAnyUpdate Lkotlin/jvm/internal/Ref$ObjectRef;
    iget-object v4, v6, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$readyUpdate$1;->$lastMatchingUpdate Lkotlin/jvm/internal/Ref$ObjectRef;
    move-object v0, v7
    move-object v5, v8
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$readyUpdate$1;-><init>(Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver; Ljava/lang/String; Lkotlin/jvm/internal/Ref$ObjectRef; Lkotlin/jvm/internal/Ref$ObjectRef; Lkotlin/coroutines/Continuation;)V
    check-cast v7, Lkotlin/coroutines/Continuation;
    return-object v7
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$readyUpdate$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$readyUpdate$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$readyUpdate$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$readyUpdate$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 11
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v9, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$readyUpdate$1;->label I
    const/4 v2, 1
    if-eqz v1, +010h
    if-ne v1, v2, +006h
    invoke-static v10, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +67h
    new-instance v10, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v10, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v10
    invoke-static v10, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v10, v9, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$readyUpdate$1;->this$0 Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string/jumbo v3, resolve: wait sandbox ready start, chatSessionId=
    invoke-direct v1, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v3, v9, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$readyUpdate$1;->$chatSessionId Ljava/lang/String;
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v3, ", timeoutMs="
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v3, v9, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$readyUpdate$1;->this$0 Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;
    invoke-static v3, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;->access$getSandboxReadyTimeoutMs$p(Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;)J
    move-result-wide v3
    invoke-virtual v1, v3, v4, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-static v10, v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;->access$logD(Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver; Ljava/lang/String;)V
    iget-object v10, v9, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$readyUpdate$1;->this$0 Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;
    invoke-static v10, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;->access$getSandboxStatusSource$p(Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;)Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteSandboxStatusSource;
    move-result-object v10
    invoke-interface v10, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteSandboxStatusSource;->updates()Lkotlinx/coroutines/flow/Flow;
    move-result-object v10
    new-instance v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$readyUpdate$1$update$1;
    iget-object v4, v9, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$readyUpdate$1;->$lastAnyUpdate Lkotlin/jvm/internal/Ref$ObjectRef;
    iget-object v5, v9, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$readyUpdate$1;->$chatSessionId Ljava/lang/String;
    iget-object v6, v9, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$readyUpdate$1;->$lastMatchingUpdate Lkotlin/jvm/internal/Ref$ObjectRef;
    iget-object v7, v9, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$readyUpdate$1;->this$0 Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;
    const/4 v8, 0
    move-object v3, v1
    invoke-direct/range v3 ... v8, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$readyUpdate$1$update$1;-><init>(Lkotlin/jvm/internal/Ref$ObjectRef; Ljava/lang/String; Lkotlin/jvm/internal/Ref$ObjectRef; Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver; Lkotlin/coroutines/Continuation;)V
    check-cast v1, Lkotlin/jvm/functions/Function2;
    invoke-static v10, v1, Lkotlinx/coroutines/flow/FlowKt;->onEach(Lkotlinx/coroutines/flow/Flow; Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;
    move-result-object v10
    iget-object v1, v9, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$readyUpdate$1;->$chatSessionId Ljava/lang/String;
    new-instance v3, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$readyUpdate$1$invokeSuspend$$inlined$filter$1;
    invoke-direct v3, v10, v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$readyUpdate$1$invokeSuspend$$inlined$filter$1;-><init>(Lkotlinx/coroutines/flow/Flow; Ljava/lang/String;)V
    check-cast v3, Lkotlinx/coroutines/flow/Flow;
    move-object v10, v9
    check-cast v10, Lkotlin/coroutines/Continuation;
    iput v2, v9, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$readyUpdate$1;->label I
    invoke-static v3, v10, Lkotlinx/coroutines/flow/FlowKt;->first(Lkotlinx/coroutines/flow/Flow; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v10
    if-ne v10, v0, +003h
    return-object v0
    check-cast v10, Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatusUpdate;
    return-object v10
.end method
