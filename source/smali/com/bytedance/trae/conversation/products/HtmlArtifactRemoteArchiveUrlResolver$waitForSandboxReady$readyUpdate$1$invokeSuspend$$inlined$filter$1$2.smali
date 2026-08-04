# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$readyUpdate$1$invokeSuspend$$inlined$filter$1$2;
.super Ljava/lang/Object;
.source "Emitters.kt"

.implements Lkotlinx/coroutines/flow/FlowCollector;

.field final synthetic $chatSessionId$inlined:Ljava/lang/String;
.field final synthetic $this_unsafeFlow:Lkotlinx/coroutines/flow/FlowCollector;


.method public constructor <init>(kotlinx.coroutines.flow.FlowCollector  java.lang.String)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$readyUpdate$1$invokeSuspend$$inlined$filter$1$2;->$this_unsafeFlow Lkotlinx/coroutines/flow/FlowCollector;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$readyUpdate$1$invokeSuspend$$inlined$filter$1$2;->$chatSessionId$inlined Ljava/lang/String;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final emit(java.lang.Object  kotlin.coroutines.Continuation)java.lang.Object
    .registers 8
    # ins_size=3
    instance-of v0, v7, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$readyUpdate$1$invokeSuspend$$inlined$filter$1$2$1;
    if-eqz v0, +012h
    move-object v0, v7
    check-cast v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$readyUpdate$1$invokeSuspend$$inlined$filter$1$2$1;
    iget v1, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$readyUpdate$1$invokeSuspend$$inlined$filter$1$2$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v7, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$readyUpdate$1$invokeSuspend$$inlined$filter$1$2$1;->label I
    sub-int/2addr v7, v2
    iput v7, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$readyUpdate$1$invokeSuspend$$inlined$filter$1$2$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$readyUpdate$1$invokeSuspend$$inlined$filter$1$2$1;
    invoke-direct v0, v5, v7, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$readyUpdate$1$invokeSuspend$$inlined$filter$1$2$1;-><init>(Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$readyUpdate$1$invokeSuspend$$inlined$filter$1$2; Lkotlin/coroutines/Continuation;)V
    iget-object v7, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$readyUpdate$1$invokeSuspend$$inlined$filter$1$2$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$readyUpdate$1$invokeSuspend$$inlined$filter$1$2$1;->label I
    const/4 v3, 1
    if-eqz v2, +010h
    if-ne v2, v3, +006h
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +3dh
    new-instance v6, Ljava/lang/IllegalStateException;
    const-string v7, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v6, v7, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v6
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v7, v5, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$readyUpdate$1$invokeSuspend$$inlined$filter$1$2;->$this_unsafeFlow Lkotlinx/coroutines/flow/FlowCollector;
    move-object v2, v0
    check-cast v2, Lkotlin/coroutines/Continuation;
    move-object v2, v6
    check-cast v2, Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatusUpdate;
    iget-object v4, v5, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$readyUpdate$1$invokeSuspend$$inlined$filter$1$2;->$chatSessionId$inlined Ljava/lang/String;
    invoke-virtual v2, v4, Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatusUpdate;->matches(Ljava/lang/String;)Z
    move-result v4
    if-eqz v4, +017h
    invoke-virtual v2, Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatusUpdate;->getStatus()Ljava/lang/Integer;
    move-result-object v2
    sget-object v4, Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatus;->READY Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatus;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatus;->getValue()I
    move-result v4
    if-nez v2, +003h
    goto +9h
    invoke-virtual v2, Ljava/lang/Integer;->intValue()I
    move-result v2
    if-ne v2, v4, +004h
    move v2, v3
    goto +2h
    const/4 v2, 0
    if-eqz v2, +00bh
    iput v3, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$readyUpdate$1$invokeSuspend$$inlined$filter$1$2$1;->label I
    invoke-interface v7, v6, v0, Lkotlinx/coroutines/flow/FlowCollector;->emit(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v6
    if-ne v6, v1, +003h
    return-object v1
    sget-object v6, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v6
.end method
