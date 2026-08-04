# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$readyUpdate$1$invokeSuspend$$inlined$filter$1;
.super Ljava/lang/Object;
.source "SafeCollector.common.kt"

.implements Lkotlinx/coroutines/flow/Flow;

.field final synthetic $chatSessionId$inlined:Ljava/lang/String;
.field final synthetic $this_unsafeTransform$inlined:Lkotlinx/coroutines/flow/Flow;


.method public constructor <init>(kotlinx.coroutines.flow.Flow  java.lang.String)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$readyUpdate$1$invokeSuspend$$inlined$filter$1;->$this_unsafeTransform$inlined Lkotlinx/coroutines/flow/Flow;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$readyUpdate$1$invokeSuspend$$inlined$filter$1;->$chatSessionId$inlined Ljava/lang/String;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public collect(kotlinx.coroutines.flow.FlowCollector  kotlin.coroutines.Continuation)java.lang.Object
    .registers 6
    # ins_size=3
    iget-object v0, v3, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$readyUpdate$1$invokeSuspend$$inlined$filter$1;->$this_unsafeTransform$inlined Lkotlinx/coroutines/flow/Flow;
    new-instance v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$readyUpdate$1$invokeSuspend$$inlined$filter$1$2;
    iget-object v2, v3, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$readyUpdate$1$invokeSuspend$$inlined$filter$1;->$chatSessionId$inlined Ljava/lang/String;
    invoke-direct v1, v4, v2, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$readyUpdate$1$invokeSuspend$$inlined$filter$1$2;-><init>(Lkotlinx/coroutines/flow/FlowCollector; Ljava/lang/String;)V
    check-cast v1, Lkotlinx/coroutines/flow/FlowCollector;
    invoke-interface v0, v1, v5, Lkotlinx/coroutines/flow/Flow;->collect(Lkotlinx/coroutines/flow/FlowCollector; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v4
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v5
    if-ne v4, v5, +003h
    return-object v4
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v4
.end method
