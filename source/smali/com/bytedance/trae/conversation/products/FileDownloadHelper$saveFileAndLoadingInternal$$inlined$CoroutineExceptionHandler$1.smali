# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/products/FileDownloadHelper$saveFileAndLoadingInternal$$inlined$CoroutineExceptionHandler$1;
.super Lkotlin/coroutines/AbstractCoroutineContextElement;
.source "CoroutineExceptionHandler.kt"

.implements Lkotlinx/coroutines/CoroutineExceptionHandler;

.field final synthetic $dismissLoadingCallback$inlined:Lkotlin/jvm/functions/Function3;
.field final synthetic $fileName$inlined:Ljava/lang/String;
.field final synthetic this$0:Lcom/bytedance/trae/conversation/products/FileDownloadHelper;


.method public constructor <init>(kotlinx.coroutines.CoroutineExceptionHandler$Key  kotlin.jvm.functions.Function3  com.bytedance.trae.conversation.products.FileDownloadHelper  java.lang.String)void
    .registers 5
    # ins_size=5
    iput-object v2, v0, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$saveFileAndLoadingInternal$$inlined$CoroutineExceptionHandler$1;->$dismissLoadingCallback$inlined Lkotlin/jvm/functions/Function3;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$saveFileAndLoadingInternal$$inlined$CoroutineExceptionHandler$1;->this$0 Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$saveFileAndLoadingInternal$$inlined$CoroutineExceptionHandler$1;->$fileName$inlined Ljava/lang/String;
    check-cast v1, Lkotlin/coroutines/CoroutineContext$Key;
    invoke-direct v0, v1, Lkotlin/coroutines/AbstractCoroutineContextElement;-><init>(Lkotlin/coroutines/CoroutineContext$Key;)V
    return-void 
.end method

.method public handleException(kotlin.coroutines.CoroutineContext  java.lang.Throwable)void
    .registers 5
    # ins_size=3
    iget-object v3, v2, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$saveFileAndLoadingInternal$$inlined$CoroutineExceptionHandler$1;->$dismissLoadingCallback$inlined Lkotlin/jvm/functions/Function3;
    if-eqz v3, +017h
    iget-object v4, v2, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$saveFileAndLoadingInternal$$inlined$CoroutineExceptionHandler$1;->this$0 Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
    invoke-static v4, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->access$getRESULT_CODE_FAILED_CRASH$p(Lcom/bytedance/trae/conversation/products/FileDownloadHelper;)I
    move-result v4
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    const-wide/16 v0, 0
    invoke-static v0, v1, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v0
    const-string v1, ""
    invoke-interface v3, v4, v1, v0, Lkotlin/jvm/functions/Function3;->invoke(Ljava/lang/Object; Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    iget-object v3, v2, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$saveFileAndLoadingInternal$$inlined$CoroutineExceptionHandler$1;->this$0 Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
    invoke-static v3, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->access$getDownloadFinishBlk$p(Lcom/bytedance/trae/conversation/products/FileDownloadHelper;)Lkotlin/jvm/functions/Function1;
    move-result-object v3
    iget-object v4, v2, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$saveFileAndLoadingInternal$$inlined$CoroutineExceptionHandler$1;->$fileName$inlined Ljava/lang/String;
    invoke-interface v3, v4, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method
