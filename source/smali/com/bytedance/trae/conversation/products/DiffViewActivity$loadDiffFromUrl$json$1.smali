# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/products/DiffViewActivity$loadDiffFromUrl$json$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "DiffViewActivity.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $cliType:Ljava/lang/String;
.field final synthetic $downloadUrl:Ljava/lang/String;
.field private synthetic L$0:Ljava/lang/Object;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/products/DiffViewActivity;


.method constructor <init>(com.bytedance.trae.conversation.products.DiffViewActivity  java.lang.String  java.lang.String  kotlin.coroutines.Continuation)void
    .registers 5
    # ins_size=5
    iput-object v1, v0, Lcom/bytedance/trae/conversation/products/DiffViewActivity$loadDiffFromUrl$json$1;->this$0 Lcom/bytedance/trae/conversation/products/DiffViewActivity;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/products/DiffViewActivity$loadDiffFromUrl$json$1;->$downloadUrl Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/products/DiffViewActivity$loadDiffFromUrl$json$1;->$cliType Ljava/lang/String;
    const/4 v1, 2
    invoke-direct v0, v1, v4, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 7
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/conversation/products/DiffViewActivity$loadDiffFromUrl$json$1;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/products/DiffViewActivity$loadDiffFromUrl$json$1;->this$0 Lcom/bytedance/trae/conversation/products/DiffViewActivity;
    iget-object v2, v4, Lcom/bytedance/trae/conversation/products/DiffViewActivity$loadDiffFromUrl$json$1;->$downloadUrl Ljava/lang/String;
    iget-object v3, v4, Lcom/bytedance/trae/conversation/products/DiffViewActivity$loadDiffFromUrl$json$1;->$cliType Ljava/lang/String;
    invoke-direct v0, v1, v2, v3, v6, Lcom/bytedance/trae/conversation/products/DiffViewActivity$loadDiffFromUrl$json$1;-><init>(Lcom/bytedance/trae/conversation/products/DiffViewActivity; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    iput-object v5, v0, Lcom/bytedance/trae/conversation/products/DiffViewActivity$loadDiffFromUrl$json$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lkotlin/coroutines/Continuation;
    return-object v0
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/DiffViewActivity$loadDiffFromUrl$json$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/DiffViewActivity$loadDiffFromUrl$json$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/products/DiffViewActivity$loadDiffFromUrl$json$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/products/DiffViewActivity$loadDiffFromUrl$json$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 5
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    iget v0, v3, Lcom/bytedance/trae/conversation/products/DiffViewActivity$loadDiffFromUrl$json$1;->label I
    if-nez v0, +02dh
    invoke-static v4, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v4, v3, Lcom/bytedance/trae/conversation/products/DiffViewActivity$loadDiffFromUrl$json$1;->L$0 Ljava/lang/Object;
    check-cast v4, Lkotlinx/coroutines/CoroutineScope;
    iget-object v4, v3, Lcom/bytedance/trae/conversation/products/DiffViewActivity$loadDiffFromUrl$json$1;->this$0 Lcom/bytedance/trae/conversation/products/DiffViewActivity;
    iget-object v0, v3, Lcom/bytedance/trae/conversation/products/DiffViewActivity$loadDiffFromUrl$json$1;->$downloadUrl Ljava/lang/String;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/products/DiffViewActivity$loadDiffFromUrl$json$1;->$cliType Ljava/lang/String;
    sget-object v2, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v4, v0, v1, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->access$fetchJsonViaTTNet(Lcom/bytedance/trae/conversation/products/DiffViewActivity; Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    invoke-static v4, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v4
    goto +ch
    move-exception v4
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v4, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v4
    invoke-static v4, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v4
    invoke-static v4, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +003h
    const/4 v4, 0
    return-object v4
    new-instance v4, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v4, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v4
    :try_start_0x14
.end method
