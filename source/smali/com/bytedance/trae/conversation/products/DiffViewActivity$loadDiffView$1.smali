# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/products/DiffViewActivity$loadDiffView$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "DiffViewActivity.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $chatSessionId:Ljava/lang/String;
.field final synthetic $cliType:Ljava/lang/String;
.field final synthetic $taskName:Ljava/lang/String;
.field final synthetic $turnId:Ljava/lang/String;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/products/DiffViewActivity;


.method constructor <init>(java.lang.String  java.lang.String  com.bytedance.trae.conversation.products.DiffViewActivity  java.lang.String  java.lang.String  kotlin.coroutines.Continuation)void
    .registers 7
    # ins_size=7
    iput-object v1, v0, Lcom/bytedance/trae/conversation/products/DiffViewActivity$loadDiffView$1;->$cliType Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/products/DiffViewActivity$loadDiffView$1;->$turnId Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/products/DiffViewActivity$loadDiffView$1;->this$0 Lcom/bytedance/trae/conversation/products/DiffViewActivity;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/products/DiffViewActivity$loadDiffView$1;->$taskName Ljava/lang/String;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/products/DiffViewActivity$loadDiffView$1;->$chatSessionId Ljava/lang/String;
    const/4 v1, 2
    invoke-direct v0, v1, v6, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 10
    # ins_size=3
    new-instance v8, Lcom/bytedance/trae/conversation/products/DiffViewActivity$loadDiffView$1;
    iget-object v1, v7, Lcom/bytedance/trae/conversation/products/DiffViewActivity$loadDiffView$1;->$cliType Ljava/lang/String;
    iget-object v2, v7, Lcom/bytedance/trae/conversation/products/DiffViewActivity$loadDiffView$1;->$turnId Ljava/lang/String;
    iget-object v3, v7, Lcom/bytedance/trae/conversation/products/DiffViewActivity$loadDiffView$1;->this$0 Lcom/bytedance/trae/conversation/products/DiffViewActivity;
    iget-object v4, v7, Lcom/bytedance/trae/conversation/products/DiffViewActivity$loadDiffView$1;->$taskName Ljava/lang/String;
    iget-object v5, v7, Lcom/bytedance/trae/conversation/products/DiffViewActivity$loadDiffView$1;->$chatSessionId Ljava/lang/String;
    move-object v0, v8
    move-object v6, v9
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/conversation/products/DiffViewActivity$loadDiffView$1;-><init>(Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/products/DiffViewActivity; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v8, Lkotlin/coroutines/Continuation;
    return-object v8
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/DiffViewActivity$loadDiffView$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/DiffViewActivity$loadDiffView$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/products/DiffViewActivity$loadDiffView$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/products/DiffViewActivity$loadDiffView$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 8
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v6, Lcom/bytedance/trae/conversation/products/DiffViewActivity$loadDiffView$1;->label I
    const/4 v2, 3
    const/4 v3, 2
    const/4 v4, 1
    if-eqz v1, +01dh
    if-eq v1, v4, +017h
    if-eq v1, v3, +011h
    if-ne v1, v2, +007h
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +07dh
    new-instance v7, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v7, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v7
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +56h
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +37h
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v7, v6, Lcom/bytedance/trae/conversation/products/DiffViewActivity$loadDiffView$1;->$cliType Ljava/lang/String;
    sget-object v1, Lcom/bytedance/trae/im/service/CliType;->REMOTE Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v1, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v1
    invoke-static v7, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v7
    if-nez v7, +045h
    new-instance v7, Ljava/lang/StringBuilder;
    const-string v1, "diffview/turn-"
    invoke-direct v7, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v6, Lcom/bytedance/trae/conversation/products/DiffViewActivity$loadDiffView$1;->$turnId Ljava/lang/String;
    invoke-virtual v7, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    const-string v1, ".json"
    invoke-virtual v7, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    iget-object v1, v6, Lcom/bytedance/trae/conversation/products/DiffViewActivity$loadDiffView$1;->this$0 Lcom/bytedance/trae/conversation/products/DiffViewActivity;
    move-object v2, v6
    check-cast v2, Lkotlin/coroutines/Continuation;
    iput v4, v6, Lcom/bytedance/trae/conversation/products/DiffViewActivity$loadDiffView$1;->label I
    invoke-static v1, v7, v2, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->access$fetchDownloadUrlWithRetry(Lcom/bytedance/trae/conversation/products/DiffViewActivity; Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v7
    if-ne v7, v0, +003h
    return-object v0
    check-cast v7, Ljava/lang/String;
    if-eqz v7, +014h
    iget-object v1, v6, Lcom/bytedance/trae/conversation/products/DiffViewActivity$loadDiffView$1;->this$0 Lcom/bytedance/trae/conversation/products/DiffViewActivity;
    iget-object v2, v6, Lcom/bytedance/trae/conversation/products/DiffViewActivity$loadDiffView$1;->$cliType Ljava/lang/String;
    iget-object v4, v6, Lcom/bytedance/trae/conversation/products/DiffViewActivity$loadDiffView$1;->$taskName Ljava/lang/String;
    move-object v5, v6
    check-cast v5, Lkotlin/coroutines/Continuation;
    iput v3, v6, Lcom/bytedance/trae/conversation/products/DiffViewActivity$loadDiffView$1;->label I
    invoke-static v1, v7, v2, v4, v5, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->access$loadDiffFromUrl(Lcom/bytedance/trae/conversation/products/DiffViewActivity; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v7
    if-ne v7, v0, +008h
    return-object v0
    iget-object v7, v6, Lcom/bytedance/trae/conversation/products/DiffViewActivity$loadDiffView$1;->this$0 Lcom/bytedance/trae/conversation/products/DiffViewActivity;
    invoke-static v7, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->access$showDiffError(Lcom/bytedance/trae/conversation/products/DiffViewActivity;)V
    sget-object v7, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v7
    new-instance v7, Lcom/bytedance/trae/conversation/products/DiffViewManager;
    invoke-direct v7, Lcom/bytedance/trae/conversation/products/DiffViewManager;-><init>()V
    iget-object v1, v6, Lcom/bytedance/trae/conversation/products/DiffViewActivity$loadDiffView$1;->$cliType Ljava/lang/String;
    iget-object v3, v6, Lcom/bytedance/trae/conversation/products/DiffViewActivity$loadDiffView$1;->$chatSessionId Ljava/lang/String;
    iget-object v4, v6, Lcom/bytedance/trae/conversation/products/DiffViewActivity$loadDiffView$1;->$turnId Ljava/lang/String;
    move-object v5, v6
    check-cast v5, Lkotlin/coroutines/Continuation;
    iput v2, v6, Lcom/bytedance/trae/conversation/products/DiffViewActivity$loadDiffView$1;->label I
    invoke-virtual v7, v1, v3, v4, v5, Lcom/bytedance/trae/conversation/products/DiffViewManager;->fetchDiffView(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v7
    if-ne v7, v0, +003h
    return-object v0
    check-cast v7, Lcom/bytedance/trae/network/response/HttpDataResult;
    iget-object v0, v6, Lcom/bytedance/trae/conversation/products/DiffViewActivity$loadDiffView$1;->this$0 Lcom/bytedance/trae/conversation/products/DiffViewActivity;
    iget-object v1, v6, Lcom/bytedance/trae/conversation/products/DiffViewActivity$loadDiffView$1;->$taskName Ljava/lang/String;
    invoke-static v0, v7, v1, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->access$handleDiffViewResult(Lcom/bytedance/trae/conversation/products/DiffViewActivity; Lcom/bytedance/trae/network/response/HttpDataResult; Ljava/lang/String;)V
    sget-object v7, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v7
.end method
