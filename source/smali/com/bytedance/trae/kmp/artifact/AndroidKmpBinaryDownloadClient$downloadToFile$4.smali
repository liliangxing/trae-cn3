# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/kmp/artifact/AndroidKmpBinaryDownloadClient$downloadToFile$4;
.super Ljava/lang/Object;
.source "AndroidKmpArtifactIo.kt"

.implements Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadTask;

.field final synthetic $deferred:Lkotlinx/coroutines/CompletableDeferred;
.field final synthetic $downloadId:I
.field final synthetic $target:Ljava/io/File;
.field final synthetic this$0:Lcom/bytedance/trae/kmp/artifact/AndroidKmpBinaryDownloadClient;


.method constructor <init>(kotlinx.coroutines.CompletableDeferred  com.bytedance.trae.kmp.artifact.AndroidKmpBinaryDownloadClient  int  java.io.File)void
    .registers 5
    # ins_size=5
    iput-object v1, v0, Lcom/bytedance/trae/kmp/artifact/AndroidKmpBinaryDownloadClient$downloadToFile$4;->$deferred Lkotlinx/coroutines/CompletableDeferred;
    iput-object v2, v0, Lcom/bytedance/trae/kmp/artifact/AndroidKmpBinaryDownloadClient$downloadToFile$4;->this$0 Lcom/bytedance/trae/kmp/artifact/AndroidKmpBinaryDownloadClient;
    iput v3, v0, Lcom/bytedance/trae/kmp/artifact/AndroidKmpBinaryDownloadClient$downloadToFile$4;->$downloadId I
    iput-object v4, v0, Lcom/bytedance/trae/kmp/artifact/AndroidKmpBinaryDownloadClient$downloadToFile$4;->$target Ljava/io/File;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public await(kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifact/AndroidKmpBinaryDownloadClient$downloadToFile$4;->$deferred Lkotlinx/coroutines/CompletableDeferred;
    invoke-interface v0, v2, Lkotlinx/coroutines/CompletableDeferred;->await(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    return-object v2
.end method

.method public cancel()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/kmp/artifact/AndroidKmpBinaryDownloadClient$downloadToFile$4;->this$0 Lcom/bytedance/trae/kmp/artifact/AndroidKmpBinaryDownloadClient;
    invoke-static v0, Lcom/bytedance/trae/kmp/artifact/AndroidKmpBinaryDownloadClient;->access$getContext$p(Lcom/bytedance/trae/kmp/artifact/AndroidKmpBinaryDownloadClient;)Landroid/content/Context;
    move-result-object v0
    invoke-static v0, Lcom/ss/android/socialbase/downloader/downloader/Downloader;->getInstance(Landroid/content/Context;)Lcom/ss/android/socialbase/downloader/downloader/Downloader;
    move-result-object v0
    iget v1, v2, Lcom/bytedance/trae/kmp/artifact/AndroidKmpBinaryDownloadClient$downloadToFile$4;->$downloadId I
    invoke-virtual v0, v1, Lcom/ss/android/socialbase/downloader/downloader/Downloader;->cancel(I)V
    iget-object v0, v2, Lcom/bytedance/trae/kmp/artifact/AndroidKmpBinaryDownloadClient$downloadToFile$4;->$target Ljava/io/File;
    invoke-virtual v0, Ljava/io/File;->delete()Z
    return-void 
.end method
