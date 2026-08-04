# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/products/FileDownloadHelper$saveFileAndLoadingInternal$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "FileDownloadHelper.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $context:Landroid/content/Context;
.field final synthetic $createTime:J
.field final synthetic $dismissLoadingCallback:Lkotlin/jvm/functions/Function3;
.field final synthetic $fileName:Ljava/lang/String;
.field final synthetic $needDecode:Z
.field final synthetic $sessionId:Ljava/lang/String;
.field final synthetic $url:Ljava/lang/String;
.field  J$0:J
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/products/FileDownloadHelper;


.method constructor <init>(com.bytedance.trae.conversation.products.FileDownloadHelper  android.content.Context  java.lang.String  java.lang.String  java.lang.String  boolean  long  kotlin.jvm.functions.Function3  kotlin.coroutines.Continuation)void
    .registers 11
    # ins_size=11
    iput-object v1, v0, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$saveFileAndLoadingInternal$1;->this$0 Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$saveFileAndLoadingInternal$1;->$context Landroid/content/Context;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$saveFileAndLoadingInternal$1;->$url Ljava/lang/String;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$saveFileAndLoadingInternal$1;->$sessionId Ljava/lang/String;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$saveFileAndLoadingInternal$1;->$fileName Ljava/lang/String;
    iput-boolean v6, v0, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$saveFileAndLoadingInternal$1;->$needDecode Z
    iput-wide v7, v0, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$saveFileAndLoadingInternal$1;->$createTime J
    iput-object v9, v0, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$saveFileAndLoadingInternal$1;->$dismissLoadingCallback Lkotlin/jvm/functions/Function3;
    const/4 v1, 2
    invoke-direct v0, v1, v10, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 14
    # ins_size=3
    new-instance v12, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$saveFileAndLoadingInternal$1;
    iget-object v1, v11, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$saveFileAndLoadingInternal$1;->this$0 Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
    iget-object v2, v11, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$saveFileAndLoadingInternal$1;->$context Landroid/content/Context;
    iget-object v3, v11, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$saveFileAndLoadingInternal$1;->$url Ljava/lang/String;
    iget-object v4, v11, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$saveFileAndLoadingInternal$1;->$sessionId Ljava/lang/String;
    iget-object v5, v11, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$saveFileAndLoadingInternal$1;->$fileName Ljava/lang/String;
    iget-boolean v6, v11, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$saveFileAndLoadingInternal$1;->$needDecode Z
    iget-wide v7, v11, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$saveFileAndLoadingInternal$1;->$createTime J
    iget-object v9, v11, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$saveFileAndLoadingInternal$1;->$dismissLoadingCallback Lkotlin/jvm/functions/Function3;
    move-object v0, v12
    move-object v10, v13
    invoke-direct/range v0 ... v10, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$saveFileAndLoadingInternal$1;-><init>(Lcom/bytedance/trae/conversation/products/FileDownloadHelper; Landroid/content/Context; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z J Lkotlin/jvm/functions/Function3; Lkotlin/coroutines/Continuation;)V
    check-cast v12, Lkotlin/coroutines/Continuation;
    return-object v12
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$saveFileAndLoadingInternal$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$saveFileAndLoadingInternal$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$saveFileAndLoadingInternal$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$saveFileAndLoadingInternal$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 16
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v14, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$saveFileAndLoadingInternal$1;->label I
    const/4 v2, 1
    if-eqz v1, +012h
    if-ne v1, v2, +008h
    iget-wide v0, v14, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$saveFileAndLoadingInternal$1;->J$0 J
    invoke-static v15, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +2dh
    new-instance v15, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v15, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v15
    invoke-static v15, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    invoke-static Landroid/os/SystemClock;->elapsedRealtime()J
    move-result-wide v3
    iget-object v5, v14, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$saveFileAndLoadingInternal$1;->this$0 Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
    iget-object v6, v14, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$saveFileAndLoadingInternal$1;->$context Landroid/content/Context;
    iget-object v7, v14, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$saveFileAndLoadingInternal$1;->$url Ljava/lang/String;
    iget-object v8, v14, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$saveFileAndLoadingInternal$1;->$sessionId Ljava/lang/String;
    iget-object v9, v14, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$saveFileAndLoadingInternal$1;->$fileName Ljava/lang/String;
    iget-boolean v10, v14, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$saveFileAndLoadingInternal$1;->$needDecode Z
    iget-wide v11, v14, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$saveFileAndLoadingInternal$1;->$createTime J
    move-object v13, v14
    check-cast v13, Lkotlin/coroutines/Continuation;
    iput-wide v3, v14, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$saveFileAndLoadingInternal$1;->J$0 J
    iput v2, v14, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$saveFileAndLoadingInternal$1;->label I
    invoke-static/range v5 ... v13, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->access$downloadFile(Lcom/bytedance/trae/conversation/products/FileDownloadHelper; Landroid/content/Context; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v15
    if-ne v15, v0, +003h
    return-object v0
    move-wide v0, v3
    check-cast v15, Lkotlin/Pair;
    invoke-static Landroid/os/SystemClock;->elapsedRealtime()J
    move-result-wide v2
    sub-long/2addr v2, v0
    iget-object v0, v14, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$saveFileAndLoadingInternal$1;->$dismissLoadingCallback Lkotlin/jvm/functions/Function3;
    if-eqz v0, +011h
    invoke-virtual v15, Lkotlin/Pair;->getFirst()Ljava/lang/Object;
    move-result-object v1
    invoke-virtual v15, Lkotlin/Pair;->getSecond()Ljava/lang/Object;
    move-result-object v15
    invoke-static v2, v3, Lkotlin/coroutines/jvm/internal/Boxing;->boxLong(J)Ljava/lang/Long;
    move-result-object v2
    invoke-interface v0, v1, v15, v2, Lkotlin/jvm/functions/Function3;->invoke(Ljava/lang/Object; Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    iget-object v15, v14, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$saveFileAndLoadingInternal$1;->this$0 Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
    invoke-static v15, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->access$getDownloadFinishBlk$p(Lcom/bytedance/trae/conversation/products/FileDownloadHelper;)Lkotlin/jvm/functions/Function1;
    move-result-object v15
    iget-object v0, v14, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$saveFileAndLoadingInternal$1;->$fileName Ljava/lang/String;
    invoke-interface v15, v0, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    iget-object v15, v14, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$saveFileAndLoadingInternal$1;->this$0 Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
    invoke-static v15, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->access$getDownloadFinishBlk$p(Lcom/bytedance/trae/conversation/products/FileDownloadHelper;)Lkotlin/jvm/functions/Function1;
    move-result-object v15
    iget-object v0, v14, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$saveFileAndLoadingInternal$1;->$fileName Ljava/lang/String;
    invoke-interface v15, v0, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v15, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v15
    move-exception v15
    iget-object v0, v14, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$saveFileAndLoadingInternal$1;->this$0 Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
    invoke-static v0, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->access$getDownloadFinishBlk$p(Lcom/bytedance/trae/conversation/products/FileDownloadHelper;)Lkotlin/jvm/functions/Function1;
    move-result-object v0
    iget-object v1, v14, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$saveFileAndLoadingInternal$1;->$fileName Ljava/lang/String;
    invoke-interface v0, v1, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    throw v15
    :try_start_0xd
    :try_start_0x1c
.end method
