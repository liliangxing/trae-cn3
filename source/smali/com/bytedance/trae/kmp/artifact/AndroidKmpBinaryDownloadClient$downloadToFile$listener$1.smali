# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/kmp/artifact/AndroidKmpBinaryDownloadClient$downloadToFile$listener$1;
.super Lcom/ss/android/socialbase/downloader/depend/AbsDownloadListener;
.source "AndroidKmpArtifactIo.kt"

.field final synthetic $deferred:Lkotlinx/coroutines/CompletableDeferred;
.field final synthetic $request:Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadRequest;
.field final synthetic $target:Ljava/io/File;


.method constructor <init>(kotlinx.coroutines.CompletableDeferred  com.bytedance.trae.kmp.artifact.KmpBinaryDownloadRequest  java.io.File)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/kmp/artifact/AndroidKmpBinaryDownloadClient$downloadToFile$listener$1;->$deferred Lkotlinx/coroutines/CompletableDeferred;
    iput-object v2, v0, Lcom/bytedance/trae/kmp/artifact/AndroidKmpBinaryDownloadClient$downloadToFile$listener$1;->$request Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadRequest;
    iput-object v3, v0, Lcom/bytedance/trae/kmp/artifact/AndroidKmpBinaryDownloadClient$downloadToFile$listener$1;->$target Ljava/io/File;
    invoke-direct v0, Lcom/ss/android/socialbase/downloader/depend/AbsDownloadListener;-><init>()V
    return-void 
.end method

.method public onCanceled(com.ss.android.socialbase.downloader.model.DownloadInfo)void
    .registers 10
    # ins_size=2
    iget-object v9, v8, Lcom/bytedance/trae/kmp/artifact/AndroidKmpBinaryDownloadClient$downloadToFile$listener$1;->$target Ljava/io/File;
    invoke-virtual v9, Ljava/io/File;->delete()Z
    iget-object v9, v8, Lcom/bytedance/trae/kmp/artifact/AndroidKmpBinaryDownloadClient$downloadToFile$listener$1;->$deferred Lkotlinx/coroutines/CompletableDeferred;
    new-instance v7, Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadResult;
    const/4 v1, 0
    const/4 v2, -1
    const/4 v3, 0
    const-string v4, "cancelled"
    const/4 v5, 4
    const/4 v6, 0
    move-object v0, v7
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadResult;-><init>(Lcom/bytedance/trae/kmp/artifact/KmpFileReference; I Ljava/util/Map; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v9, v7, Lkotlinx/coroutines/CompletableDeferred;->complete(Ljava/lang/Object;)Z
    return-void 
.end method

.method public onFailed(com.ss.android.socialbase.downloader.model.DownloadInfo  com.ss.android.socialbase.downloader.exception.BaseException)void
    .registers 12
    # ins_size=3
    iget-object v0, v9, Lcom/bytedance/trae/kmp/artifact/AndroidKmpBinaryDownloadClient$downloadToFile$listener$1;->$target Ljava/io/File;
    invoke-virtual v0, Ljava/io/File;->delete()Z
    iget-object v0, v9, Lcom/bytedance/trae/kmp/artifact/AndroidKmpBinaryDownloadClient$downloadToFile$listener$1;->$deferred Lkotlinx/coroutines/CompletableDeferred;
    new-instance v8, Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadResult;
    const/4 v2, 0
    if-eqz v10, +007h
    invoke-virtual v10, Lcom/ss/android/socialbase/downloader/model/DownloadInfo;->getHttpStatusCode()I
    move-result v10
    goto +2h
    const/4 v10, -1
    move v3, v10
    const/4 v4, 0
    if-eqz v11, +008h
    invoke-virtual v11, Lcom/ss/android/socialbase/downloader/exception/BaseException;->getMessage()Ljava/lang/String;
    move-result-object v10
    if-nez v10, +004h
    const-string v10, "download failed"
    move-object v5, v10
    const/4 v6, 4
    const/4 v7, 0
    move-object v1, v8
    invoke-direct/range v1 ... v7, Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadResult;-><init>(Lcom/bytedance/trae/kmp/artifact/KmpFileReference; I Ljava/util/Map; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v8, Lkotlinx/coroutines/CompletableDeferred;->complete(Ljava/lang/Object;)Z
    return-void 
.end method

.method public onSuccessed(com.ss.android.socialbase.downloader.model.DownloadInfo)void
    .registers 11
    # ins_size=2
    iget-object v0, v9, Lcom/bytedance/trae/kmp/artifact/AndroidKmpBinaryDownloadClient$downloadToFile$listener$1;->$deferred Lkotlinx/coroutines/CompletableDeferred;
    iget-object v1, v9, Lcom/bytedance/trae/kmp/artifact/AndroidKmpBinaryDownloadClient$downloadToFile$listener$1;->$request Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadRequest;
    invoke-virtual v1, Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadRequest;->getTarget()Lcom/bytedance/trae/kmp/artifact/KmpFileReference;
    move-result-object v3
    if-eqz v10, +021h
    invoke-virtual v10, Lcom/ss/android/socialbase/downloader/model/DownloadInfo;->getHttpStatusCode()I
    move-result v10
    invoke-static v10, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v10
    move-object v1, v10
    check-cast v1, Ljava/lang/Number;
    invoke-virtual v1, Ljava/lang/Number;->intValue()I
    move-result v1
    if-lez v1, +004h
    const/4 v1, 1
    goto +2h
    const/4 v1, 0
    if-eqz v1, +003h
    goto +2h
    const/4 v10, 0
    if-eqz v10, +007h
    invoke-virtual v10, Ljava/lang/Integer;->intValue()I
    move-result v10
    goto +3h
    const/16 v10, 200
    move v4, v10
    const/4 v5, 0
    const/4 v6, 0
    const/16 v7, 12
    const/4 v8, 0
    new-instance v10, Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadResult;
    move-object v2, v10
    invoke-direct/range v2 ... v8, Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadResult;-><init>(Lcom/bytedance/trae/kmp/artifact/KmpFileReference; I Ljava/util/Map; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v10, Lkotlinx/coroutines/CompletableDeferred;->complete(Ljava/lang/Object;)Z
    return-void 
.end method
