# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/products/FileDownloadHelper$saveFile$2$1;
.super Ljava/lang/Object;
.source "FileDownloadHelper.kt"

.implements Lkotlin/jvm/functions/Function1;

.field final synthetic $cacheFile:Ljava/io/File;
.field final synthetic $context:Landroid/content/Context;
.field final synthetic $downloadId:Lkotlin/jvm/internal/Ref$IntRef;
.field final synthetic this$0:Lcom/bytedance/trae/conversation/products/FileDownloadHelper;


.method constructor <init>(com.bytedance.trae.conversation.products.FileDownloadHelper  kotlin.jvm.internal.Ref$IntRef  java.io.File  android.content.Context)void
    .registers 5
    # ins_size=5
    iput-object v1, v0, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$saveFile$2$1;->this$0 Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$saveFile$2$1;->$downloadId Lkotlin/jvm/internal/Ref$IntRef;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$saveFile$2$1;->$cacheFile Ljava/io/File;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$saveFile$2$1;->$context Landroid/content/Context;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public bridge synthetic invoke(java.lang.Object)java.lang.Object
    .registers 2
    # ins_size=2
    check-cast v1, Ljava/lang/Throwable;
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$saveFile$2$1;->invoke(Ljava/lang/Throwable;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method public final invoke(java.lang.Throwable)void
    .registers 5
    # ins_size=2
    iget-object v4, v3, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$saveFile$2$1;->this$0 Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
    invoke-static v4, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->access$getDownloadContinuationMap$p(Lcom/bytedance/trae/conversation/products/FileDownloadHelper;)Ljava/util/concurrent/ConcurrentHashMap;
    move-result-object v4
    iget-object v0, v3, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$saveFile$2$1;->$downloadId Lkotlin/jvm/internal/Ref$IntRef;
    iget v0, v0, Lkotlin/jvm/internal/Ref$IntRef;->element I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    invoke-virtual v4, v0, Ljava/util/concurrent/ConcurrentHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v4, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    iget-object v0, v3, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$saveFile$2$1;->this$0 Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
    invoke-static v0, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->access$getTAG$p(Lcom/bytedance/trae/conversation/products/FileDownloadHelper;)Ljava/lang/String;
    move-result-object v0
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "Download cancel, downloadId="
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v2, v3, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$saveFile$2$1;->$downloadId Lkotlin/jvm/internal/Ref$IntRef;
    iget v2, v2, Lkotlin/jvm/internal/Ref$IntRef;->element I
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", file="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$saveFile$2$1;->$cacheFile Ljava/io/File;
    invoke-virtual v2, Ljava/io/File;->getName()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v4, v0, v1, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v4, v3, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$saveFile$2$1;->$context Landroid/content/Context;
    invoke-static v4, Lcom/ss/android/socialbase/downloader/downloader/Downloader;->getInstance(Landroid/content/Context;)Lcom/ss/android/socialbase/downloader/downloader/Downloader;
    move-result-object v4
    iget-object v0, v3, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$saveFile$2$1;->$downloadId Lkotlin/jvm/internal/Ref$IntRef;
    iget v0, v0, Lkotlin/jvm/internal/Ref$IntRef;->element I
    invoke-virtual v4, v0, Lcom/ss/android/socialbase/downloader/downloader/Downloader;->cancel(I)V
    return-void 
.end method
