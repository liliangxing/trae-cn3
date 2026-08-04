# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/products/FileDownloadHelper$copyCachedFileAndLoadingInternal$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "FileDownloadHelper.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $cacheFile:Ljava/io/File;
.field final synthetic $context:Landroid/content/Context;
.field final synthetic $createTime:J
.field final synthetic $dismissLoadingCallback:Lkotlin/jvm/functions/Function3;
.field final synthetic $fileName:Ljava/lang/String;
.field final synthetic $sessionId:Ljava/lang/String;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/products/FileDownloadHelper;


.method constructor <init>(com.bytedance.trae.conversation.products.FileDownloadHelper  android.content.Context  java.io.File  java.lang.String  java.lang.String  long  kotlin.jvm.functions.Function3  kotlin.coroutines.Continuation)void
    .registers 10
    # ins_size=10
    iput-object v1, v0, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$copyCachedFileAndLoadingInternal$1;->this$0 Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$copyCachedFileAndLoadingInternal$1;->$context Landroid/content/Context;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$copyCachedFileAndLoadingInternal$1;->$cacheFile Ljava/io/File;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$copyCachedFileAndLoadingInternal$1;->$sessionId Ljava/lang/String;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$copyCachedFileAndLoadingInternal$1;->$fileName Ljava/lang/String;
    iput-wide v6, v0, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$copyCachedFileAndLoadingInternal$1;->$createTime J
    iput-object v8, v0, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$copyCachedFileAndLoadingInternal$1;->$dismissLoadingCallback Lkotlin/jvm/functions/Function3;
    const/4 v1, 2
    invoke-direct v0, v1, v9, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 13
    # ins_size=3
    new-instance v11, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$copyCachedFileAndLoadingInternal$1;
    iget-object v1, v10, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$copyCachedFileAndLoadingInternal$1;->this$0 Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
    iget-object v2, v10, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$copyCachedFileAndLoadingInternal$1;->$context Landroid/content/Context;
    iget-object v3, v10, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$copyCachedFileAndLoadingInternal$1;->$cacheFile Ljava/io/File;
    iget-object v4, v10, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$copyCachedFileAndLoadingInternal$1;->$sessionId Ljava/lang/String;
    iget-object v5, v10, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$copyCachedFileAndLoadingInternal$1;->$fileName Ljava/lang/String;
    iget-wide v6, v10, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$copyCachedFileAndLoadingInternal$1;->$createTime J
    iget-object v8, v10, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$copyCachedFileAndLoadingInternal$1;->$dismissLoadingCallback Lkotlin/jvm/functions/Function3;
    move-object v0, v11
    move-object v9, v12
    invoke-direct/range v0 ... v9, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$copyCachedFileAndLoadingInternal$1;-><init>(Lcom/bytedance/trae/conversation/products/FileDownloadHelper; Landroid/content/Context; Ljava/io/File; Ljava/lang/String; Ljava/lang/String; J Lkotlin/jvm/functions/Function3; Lkotlin/coroutines/Continuation;)V
    check-cast v11, Lkotlin/coroutines/Continuation;
    return-object v11
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$copyCachedFileAndLoadingInternal$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$copyCachedFileAndLoadingInternal$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$copyCachedFileAndLoadingInternal$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$copyCachedFileAndLoadingInternal$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 11
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    iget v0, v9, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$copyCachedFileAndLoadingInternal$1;->label I
    if-nez v0, +04ch
    invoke-static v10, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    invoke-static Landroid/os/SystemClock;->elapsedRealtime()J
    move-result-wide v0
    iget-object v2, v9, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$copyCachedFileAndLoadingInternal$1;->this$0 Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
    iget-object v3, v9, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$copyCachedFileAndLoadingInternal$1;->$context Landroid/content/Context;
    iget-object v4, v9, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$copyCachedFileAndLoadingInternal$1;->$cacheFile Ljava/io/File;
    iget-object v5, v9, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$copyCachedFileAndLoadingInternal$1;->$sessionId Ljava/lang/String;
    iget-object v6, v9, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$copyCachedFileAndLoadingInternal$1;->$fileName Ljava/lang/String;
    iget-wide v7, v9, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$copyCachedFileAndLoadingInternal$1;->$createTime J
    invoke-static/range v2 ... v8, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->access$copyCachedFile(Lcom/bytedance/trae/conversation/products/FileDownloadHelper; Landroid/content/Context; Ljava/io/File; Ljava/lang/String; Ljava/lang/String; J)Lkotlin/Pair;
    move-result-object v10
    invoke-static Landroid/os/SystemClock;->elapsedRealtime()J
    move-result-wide v2
    sub-long/2addr v2, v0
    iget-object v0, v9, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$copyCachedFileAndLoadingInternal$1;->$dismissLoadingCallback Lkotlin/jvm/functions/Function3;
    if-eqz v0, +011h
    invoke-virtual v10, Lkotlin/Pair;->getFirst()Ljava/lang/Object;
    move-result-object v1
    invoke-virtual v10, Lkotlin/Pair;->getSecond()Ljava/lang/Object;
    move-result-object v10
    invoke-static v2, v3, Lkotlin/coroutines/jvm/internal/Boxing;->boxLong(J)Ljava/lang/Long;
    move-result-object v2
    invoke-interface v0, v1, v10, v2, Lkotlin/jvm/functions/Function3;->invoke(Ljava/lang/Object; Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    iget-object v10, v9, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$copyCachedFileAndLoadingInternal$1;->this$0 Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
    invoke-static v10, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->access$getDownloadFinishBlk$p(Lcom/bytedance/trae/conversation/products/FileDownloadHelper;)Lkotlin/jvm/functions/Function1;
    move-result-object v10
    iget-object v0, v9, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$copyCachedFileAndLoadingInternal$1;->$fileName Ljava/lang/String;
    invoke-interface v10, v0, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v10, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v10
    move-exception v10
    iget-object v0, v9, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$copyCachedFileAndLoadingInternal$1;->this$0 Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
    invoke-static v0, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->access$getDownloadFinishBlk$p(Lcom/bytedance/trae/conversation/products/FileDownloadHelper;)Lkotlin/jvm/functions/Function1;
    move-result-object v0
    iget-object v1, v9, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$copyCachedFileAndLoadingInternal$1;->$fileName Ljava/lang/String;
    invoke-interface v0, v1, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    throw v10
    new-instance v10, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v10, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v10
    :try_start_0xa
.end method
