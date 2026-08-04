# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$readyUpdate$1$update$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "HtmlArtifactRemoteArchiveUrlResolver.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $chatSessionId:Ljava/lang/String;
.field final synthetic $lastAnyUpdate:Lkotlin/jvm/internal/Ref$ObjectRef;
.field final synthetic $lastMatchingUpdate:Lkotlin/jvm/internal/Ref$ObjectRef;
.field synthetic L$0:Ljava/lang/Object;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;


.method constructor <init>(kotlin.jvm.internal.Ref$ObjectRef  java.lang.String  kotlin.jvm.internal.Ref$ObjectRef  com.bytedance.trae.conversation.products.HtmlArtifactRemoteArchiveUrlResolver  kotlin.coroutines.Continuation)void
    .registers 6
    # ins_size=6
    iput-object v1, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$readyUpdate$1$update$1;->$lastAnyUpdate Lkotlin/jvm/internal/Ref$ObjectRef;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$readyUpdate$1$update$1;->$chatSessionId Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$readyUpdate$1$update$1;->$lastMatchingUpdate Lkotlin/jvm/internal/Ref$ObjectRef;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$readyUpdate$1$update$1;->this$0 Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;
    const/4 v1, 2
    invoke-direct v0, v1, v5, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 10
    # ins_size=3
    new-instance v6, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$readyUpdate$1$update$1;
    iget-object v1, v7, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$readyUpdate$1$update$1;->$lastAnyUpdate Lkotlin/jvm/internal/Ref$ObjectRef;
    iget-object v2, v7, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$readyUpdate$1$update$1;->$chatSessionId Ljava/lang/String;
    iget-object v3, v7, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$readyUpdate$1$update$1;->$lastMatchingUpdate Lkotlin/jvm/internal/Ref$ObjectRef;
    iget-object v4, v7, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$readyUpdate$1$update$1;->this$0 Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;
    move-object v0, v6
    move-object v5, v9
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$readyUpdate$1$update$1;-><init>(Lkotlin/jvm/internal/Ref$ObjectRef; Ljava/lang/String; Lkotlin/jvm/internal/Ref$ObjectRef; Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver; Lkotlin/coroutines/Continuation;)V
    iput-object v8, v6, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$readyUpdate$1$update$1;->L$0 Ljava/lang/Object;
    check-cast v6, Lkotlin/coroutines/Continuation;
    return-object v6
.end method

.method public final invoke(com.bytedance.trae.conversation.products.RealtimeSandboxStatusUpdate  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$readyUpdate$1$update$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$readyUpdate$1$update$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$readyUpdate$1$update$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatusUpdate;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$readyUpdate$1$update$1;->invoke(Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatusUpdate; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 6
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    iget v0, v4, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$readyUpdate$1$update$1;->label I
    if-nez v0, +04dh
    invoke-static v5, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v5, v4, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$readyUpdate$1$update$1;->L$0 Ljava/lang/Object;
    check-cast v5, Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatusUpdate;
    iget-object v0, v4, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$readyUpdate$1$update$1;->$lastAnyUpdate Lkotlin/jvm/internal/Ref$ObjectRef;
    iput-object v5, v0, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    iget-object v0, v4, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$readyUpdate$1$update$1;->$chatSessionId Ljava/lang/String;
    invoke-virtual v5, v0, Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatusUpdate;->matches(Ljava/lang/String;)Z
    move-result v0
    if-eqz v0, +006h
    iget-object v1, v4, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$readyUpdate$1$update$1;->$lastMatchingUpdate Lkotlin/jvm/internal/Ref$ObjectRef;
    iput-object v5, v1, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$readyUpdate$1$update$1;->this$0 Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string/jumbo v3, ws sandbox status update: waitingChatSessionId=
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v3, v4, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$readyUpdate$1$update$1;->$chatSessionId Ljava/lang/String;
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", matches="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v0, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v2, ", "
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v2, v4, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$readyUpdate$1$update$1;->this$0 Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;
    invoke-static v2, v5, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;->access$describeForLog(Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver; Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatusUpdate;)Ljava/lang/String;
    move-result-object v5
    invoke-virtual v0, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    invoke-static v1, v5, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;->access$logD(Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver; Ljava/lang/String;)V
    sget-object v5, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v5
    new-instance v5, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v5, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v5
.end method
